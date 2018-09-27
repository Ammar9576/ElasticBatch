package webapp.job;

import static org.springframework.util.ClassUtils.getShortName;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.data.AbstractPaginatedDataItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import webapp.dao.PlanRepository;
import webapp.domain.Plan;
import webapp.util.specifications.PlanStatusFilterSpecifications;


@Component
public class PlanStatusFilterReader extends AbstractPaginatedDataItemReader<Plan> implements InitializingBean {

    private Pageable planPageable;
    private String indexDate;
    
	@Value("#{'${filterParams}'.split(',')}")
	List<String> filterParams;

    @Autowired
    private PlanRepository planRepository;
    
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
    protected Iterator<Plan> doPageRead() {

    	Page<Plan>  plan =null;
		
		Specifications superSpec = null;
			try {
				
				superSpec = superSpec.where(PlanStatusFilterSpecifications.modificationDateGreaterthanAndEqual(this.indexDate));
				superSpec = superSpec.and(PlanStatusFilterSpecifications.hasPlanStatus(filterParams));

				plan = planRepository.findAll(superSpec,this.planPageable);
				
				
				
				if(plan==null || (plan!=null && plan.getNumberOfElements()<=0)){
					setName(getShortName(getClass()));
			        this.planPageable = new PageRequest(0,5000);
			    }else{
			    	planPageable = planPageable.next();
			    }
		
			} catch (Exception e) {
				throw new RuntimeException("Error occured while reading plan status data from DB :"+e.getMessage());
			}
		return plan.iterator();

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
