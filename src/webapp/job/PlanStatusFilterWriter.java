package webapp.job;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PreDestroy;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.domain.Plan;
import webapp.service.StrippedPlanService;


@RefreshScope
public class PlanStatusFilterWriter implements ItemWriter<Plan>, InitializingBean {
  
    @Override
    public void afterPropertiesSet() throws Exception {}
    
    @Autowired
    public RestHighLevelClient restClient;
    
    @Value("${indexname}")
    private String indexName;
    
    @Autowired
    StrippedPlanService strippedPlanService;

    @Override
    public void write(List<? extends Plan> list) throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
    	Set<String> planIds=new HashSet<String>();
    	
    	try{
       	 if(list!=null && list.size()>0){
       		       		
       		for(Plan plan:list){
       			planIds.add(plan.getPlanId().toString());
       		}
       		 
       		strippedPlanService.deleteCancelledOrDeletedPlanData(planIds);
       		 
       	}
       	}catch(Exception e){
       		throw new RuntimeException("Error occured while clearing existing Plan ids for Cancelled :"+planIds+ "-->"+e.getMessage());
       	}
	}
    
    @PreDestroy
    public void cleanup() {
        try {
            this.restClient.close();
        } catch (IOException ioe) {
        }
    }

}
