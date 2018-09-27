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

import webapp.dao.PortfolioRepository;
import webapp.domain.Portfolio;
import webapp.util.specifications.PortfolioSpecifications;

/**
 * 
 */
@Component
public class PortfolioReader extends AbstractPaginatedDataItemReader<Portfolio> implements InitializingBean {

    private Pageable planPageable;
    private String indexDate;

    @Autowired
    private PortfolioRepository portfolioRepository;
    
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
    protected Iterator<Portfolio> doPageRead() {

    	Page<Portfolio>  portfolios =null;
		
		Specifications superSpec = null;
			try {
		    	
		    	
				superSpec = superSpec.where(PortfolioSpecifications.dummyCondition());
				superSpec = superSpec.or(PortfolioSpecifications.portfolioDateGreaterthanAndEqual(this.indexDate));
				portfolios = portfolioRepository.findAll(superSpec,this.planPageable);
			
				if(portfolios==null || (portfolios!=null && portfolios.getNumberOfElements()<=0)){
					setName(getShortName(getClass()));
			        this.planPageable = new PageRequest(0,5000);
			    }else{
			    	planPageable = planPageable.next();
			    }
			
			} catch (ParseException e) {
				throw new RuntimeException("Error occured while reading portfolio data from DB :"+e.getMessage());
			}
			return portfolios.iterator();

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
