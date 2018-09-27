package webapp.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.joda.time.LocalDateTime;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.launch.NoSuchJobInstanceException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webapp.domain.BatchDetail;
import webapp.domain.Plan;
import webapp.domain.ResponseObject;
import webapp.service.StrippedPlanService;

/**
 * 
 */
//@Component
@RestController
public class JobsLauncher  {

    @Autowired
    private Job planIndexJob;

    @Autowired
    private JobLauncher jobLauncher;
    
    private JobExecution execution;
    
    @Autowired
    JobOperator jobOperator;
    
    @Autowired
    StrippedPlanService strippedPlanService;
    
    @Value("#{'${filterParams}'.split(',')}")
    private List<String> filterParams;
    
   //@RequestMapping("/launchjob")
   @Scheduled(cron = "0 0/3 * * * ?")
   public ResponseEntity<ResponseObject> launch() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException,
            JobInstanceAlreadyCompleteException,
            ExecutionException,
            InterruptedException, IOException, Exception {
		   Set batchDetails =new HashSet();
		   ResponseObject resObj = new ResponseObject();
    	try{
        JobParameters jobParameters = new JobParametersBuilder()
            .addString("JOB_START_DATE", (new LocalDateTime()).toString())
            .toJobParameters();
        
	        execution=jobLauncher.run(planIndexJob, jobParameters);
	       
	        
	        
	        BatchDetail batchDetail=new BatchDetail();
	        batchDetail.setId(execution.getId());
	        if(!execution.getAllFailureExceptions().isEmpty()){
	        	batchDetail.setStatus(execution.getAllFailureExceptions().get(0).getMessage()+""+execution.getStatus().name());
	        }else{
	        	batchDetail.setStatus(execution.getStatus().name());
	        }
	        
			
	        batchDetails.add(batchDetail);
	        if("COMPLETED".equals(execution.getStatus().name())){
	        	resObj.setSuccess(true);	
	        }
	        resObj.setData(batchDetails);	
	        return new ResponseEntity<ResponseObject>(resObj, HttpStatus.OK);	     

    	}catch (JobExecutionAlreadyRunningException e) {
    		resObj = new ResponseObject(e.getMessage());
    		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);
        } catch (JobRestartException e) {          
        	resObj = new ResponseObject(e.getMessage());
    		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);

        } catch (JobInstanceAlreadyCompleteException e) {          
        	resObj = new ResponseObject(e.getMessage());
    		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);

        } catch (JobParametersInvalidException e) {        
        	resObj = new ResponseObject(e.getMessage());
    		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);

        }catch (Exception e) {        
        	resObj = new ResponseObject(e.getMessage());
    		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);

        }
    	
}
   
   @RequestMapping("/stopjob")
   public ResponseEntity<ResponseObject> stopJob() throws NoSuchJobExecutionException, JobExecutionNotRunningException, NoSuchJobInstanceException  {

	  Set<Long> executions;
	  Set batchDetails =new HashSet();
	  ResponseObject resObj = new ResponseObject();
	  try {
		executions = jobOperator.getRunningExecutions("planIndexJob");
		List<Long> jobIdList = new ArrayList<Long>(executions);
		Collections.sort(jobIdList, Collections.reverseOrder());
		//for(Long id:jobIdList){
		if(jobIdList!=null && jobIdList.size()>0){
			jobOperator.stop(jobIdList.get(0)/*executions.iterator().next()*/);
			ResponseObject responseObject =new ResponseObject();
			long startTime = System.currentTimeMillis(); //fetch starting time
			boolean batchjobStatus=false;
			BatchDetail batchDetail=new BatchDetail();
			while(!batchjobStatus && (System.currentTimeMillis()-startTime)<100000)
			{	
				batchDetail.setId(jobIdList.get(0));
				batchDetail.setStatus("STOPPING");
				String s= jobOperator.getSummary(jobIdList.get(0));
				List<String> list =  
					    Stream.of(s.split("\\s*,\\s*") ).collect( Collectors.toList() );
				if(list.contains("status=STOPPED")){
					batchjobStatus=true;
					batchDetail.setStatus("STOPPED");
				}
			}
			batchDetails.add(batchDetail);	      
			//break;
		}
		//}
		resObj.setSuccess(true);
		resObj.setData(batchDetails);
		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.OK);
	} catch (NoSuchJobException e) {
		resObj = new ResponseObject(e.getMessage());
		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);
	}catch (Exception e) {
		
		if("JobExecutionNotRunningException".equals(e.getClass().getSimpleName())){
			resObj = new ResponseObject("No running jobs exist");
		}else{
			resObj = new ResponseObject(e.getMessage());
		}
		return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);
		
	}
	 
}
   
   @GetMapping("/getPlanStatus")
   public  ResponseEntity<ResponseObject> getPlanDetails(@RequestParam(value="date",required=true) String date,@RequestParam(value="deletedFlag",required=true) boolean deletedFlag){
	   ResponseObject resObj = new ResponseObject();
	   
	   try {
		   if(date!=null && !date.matches("[0-9]{1,2}-[a-zA-Z]{3}-[0-9]{4}")){
			   resObj = new ResponseObject("Correct the date format to dd-MMM-yyyy");
			   return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);
		   }else{
			   date=date+" 00:00:00";
		   }
		   List<Plan> planStatusFilters =  strippedPlanService.getCancelledOrDeletedPlanData(date,filterParams);

		   Iterator<Plan> planStatusFiltersItr = planStatusFilters.iterator();
		   Set<String> planIds = new HashSet<>();
		   
		   while(planStatusFiltersItr.hasNext()) {
			   planIds.add(planStatusFiltersItr.next().getPlanId());
		   }	
		   
		   if(deletedFlag) {
			   if(strippedPlanService.deleteCancelledOrDeletedPlanData(planIds)) {
				   resObj = new ResponseObject(planIds,true,"Plan Deleted Successfully"); 
			   }else {
				   resObj = new ResponseObject(planIds,false,"Unable to delete the plan");
			   }
		   }else {
			   	resObj.setSuccess(true);
				resObj.setData(planIds);
		   }
			return new ResponseEntity<ResponseObject>(resObj, HttpStatus.OK);
	  }catch(Exception e) {
		  	resObj = new ResponseObject(e.getMessage());
			return new ResponseEntity<ResponseObject>(resObj, HttpStatus.BAD_REQUEST);
		  
	   }
   }
   
   
}