package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiCRequestTasklet;
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
public class MakeCQuizConfig extends MakeQuizJobFlow {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ApiCRequestTasklet apiCRequestTasklet;

    private final Step converterFromResponseStep;
    private final Step categoryMapperStep;

    @Bean(name = "makeCQuizJob")
    public Job makeCQuizJob() {
        return makeQuizFlow(jobBuilderFactory, apiCRequestStep(),
                converterFromResponseStep,
                categoryMapperStep,
                CategoryTitle.C);
    }

    @Bean(name = "apiCRequestStep")
    public Step apiCRequestStep() {
        return stepBuilderFactory.get("apiCRequestStep")
                .tasklet(apiCRequestTasklet)
                .build();
    }
}
