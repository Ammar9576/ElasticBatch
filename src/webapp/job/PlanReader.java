package webapp.job;

import static org.springframework.util.ClassUtils.getShortName;

import java.text.ParseException;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.data.AbstractPaginatedDataItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import webapp.dao.StrippedPlanRepository;
import webapp.domain.StrippedPlan;
import webapp.util.specifications.StrippedPlanSpecifications;

/**
 * 
 */
@Component
public class PlanReader extends AbstractPaginatedDataItemReader<StrippedPlan> implements InitializingBean {

    private Pageable planPageable;
    private String indexDate;

    @Autowired
    private StrippedPlanRepository strippedPlanRepository;
    
    @PostConstruct
    public void init() {
         setName(getShortName(getClass()));
         this.planPageable = new PageRequest(0,5000);
    }
    
   
    
    @BeforeStep
    public void initializeValues(StepExecution stepExecution) {

    	this.indexDate = stepExecution.getJobExecution().getExecutionContext().getString("indexDate");

    }

    @Override
    protected Iterator<StrippedPlan> doPageRead() {

    	Page<StrippedPlan>  plans =null;
		
		Specifications superSpec = null;
			try {
		    	
		    	
				superSpec = superSpec.where(StrippedPlanSpecifications.dummyCondition());
				superSpec = superSpec.or(StrippedPlanSpecifications.origmodificationDateGreaterthanAndEqual(this.indexDate));
				//superSpec = superSpec.or(StrippedPlanSpecifications.creationDateGreaterthanAndEqual(this.indexDate));
				superSpec = superSpec.or(StrippedPlanSpecifications.portfolioDateGreaterthanAndEqual(this.indexDate));
				plans = strippedPlanRepository.findAll(superSpec,this.planPageable);
				
				if(plans==null || (plans!=null && plans.getNumberOfElements()<=0)){
					setName(getShortName(getClass()));
			        this.planPageable = new PageRequest(0,5000);
			    }else{
			    	planPageable = planPageable.next();
			    }
		
			} catch (ParseException e) {
				throw new RuntimeException("Error occured while reading plan data from DB :"+e.getMessage());
			}
		return plans.iterator();

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
