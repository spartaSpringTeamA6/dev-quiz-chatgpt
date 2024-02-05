package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiJPARequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
@DependsOn(value = {"converterFromResponseStep", "categoryMapperStep"})
public class MakeJPAQuizConfig extends MakeQuizJobFlow {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ApiJPARequestTasklet apiJPARequestTasklet;

    private final Step converterFromResponseStep;
    private final Step categoryMapperStep;

    @Bean(name = "makeJPAQuizJob")
    public Job makeJPAQuizJob() {
        return makeQuizFlow(jobBuilderFactory, apiJPARequestStep(),
                converterFromResponseStep,
                categoryMapperStep,
                CategoryTitle.JPA);
    }

    @Bean(name = "apiJPARequestStep")
    public Step apiJPARequestStep() {
        return stepBuilderFactory.get("apiJPARequestStep")
                .tasklet(apiJPARequestTasklet)
                .build();
    }
}
