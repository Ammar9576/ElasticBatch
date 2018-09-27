package webapp.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import webapp.job.PlanIndexJobListener;

/**
 * 
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class PlanIndexJobConfiguration {

    @Bean
    public Job planIndexJob(JobBuilderFactory jobs,Step createPorfolioStep, Step createIndexStep,Step createPlanStatusStep, PlanIndexJobListener planIndexJobJobListener){
    	return jobs.get("planIndexJob")
                    .incrementer(new RunIdIncrementer())
                    .listener(planIndexJobJobListener)
                    .flow(createPorfolioStep) 
                    .next(createIndexStep)
                    .next(createPlanStatusStep)
                    .end()
                    .build();
    }

}
