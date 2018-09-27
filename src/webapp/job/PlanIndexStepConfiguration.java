package webapp.job;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import webapp.domain.Plan;
import webapp.domain.Portfolio;
import webapp.domain.StrippedPlan;
import webapp.domain.StrippedPlanIndexV1;

/**
 *
 */
@Configuration
@EnableBatchProcessing
public class PlanIndexStepConfiguration {

    @Bean
    public Step createIndexStep(
            StepBuilderFactory stepBuilderFactory,
            @Qualifier("planReader") ItemReader<StrippedPlan> planReader,
            @Qualifier("planIndexProcessor") ItemProcessor<StrippedPlan,StrippedPlanIndexV1> planIndexProcessor,
            @Qualifier("indexWriter") IndexWriter indexWriter) {

        return stepBuilderFactory.get("createIndexStep")
        		.<StrippedPlan, StrippedPlanIndexV1> chunk(5000)
                .reader(planReader)
                .processor(planIndexProcessor)
                .writer(indexWriter)
                .build();
    }

    @Bean(name = "planReader")
    public ItemReader<StrippedPlan> planReader() {
        return new PlanReader();
    }

    @Bean(name = "planIndexProcessor")
    public ItemProcessor<StrippedPlan, StrippedPlanIndexV1> planIndexProcessor() {
        return new PlanIndexProcessor();
    }

    @Bean(name = "indexWriter")
    public IndexWriter indexWriter() {
        return new IndexWriter();
    }  
    
    
    
    @Bean
    public Step createPorfolioStep(
            StepBuilderFactory stepBuilderFactory,
            @Qualifier("portfolioReader") ItemReader<Portfolio> portfolioReader,
            @Qualifier("portfolioWriter") PortfolioWriter portfolioWriter) {

        return stepBuilderFactory.get("createPorfolioStep")
        		.<Portfolio, Portfolio> chunk(1000)
                .reader(portfolioReader)
                .writer(portfolioWriter)
                .build();
    }

    @Bean(name = "portfolioReader")
    public ItemReader<Portfolio> portfolioReader() {
        return new PortfolioReader();  
    }

    

    @Bean(name = "portfolioWriter")
    public PortfolioWriter portfolioWriter() {
        return new PortfolioWriter();
    }  

    // Plans Status step configuration
    @Bean
    public Step createPlanStatusStep(
            StepBuilderFactory stepBuilderFactory,
            @Qualifier("planStatusFilterReader") ItemReader<Plan> planStatusFilterReader,
            @Qualifier("planStatusFilterWriter") PlanStatusFilterWriter planStatusFilterWriter) {

        return stepBuilderFactory.get("createPlanStatusStep")
        		.<Plan, Plan> chunk(1000)
                .reader(planStatusFilterReader)
                .writer(planStatusFilterWriter)
                .build();
    }

    @Bean(name = "planStatusFilterReader")
    public ItemReader<Plan> planStatusFilterReader() {
        return new PlanStatusFilterReader();  
    }

    

    @Bean(name = "planStatusFilterWriter")
    public PlanStatusFilterWriter planStatusFilterWriter() {
        return new PlanStatusFilterWriter();
    }  


}
