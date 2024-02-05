package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiReactRequestTasklet;
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
public class MakeReactQuizConfig extends MakeQuizJobFlow {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ApiReactRequestTasklet apiReactRequestTasklet;

    private final Step converterFromResponseStep;
    private final Step categoryMapperStep;

    @Bean(name = "makeReactQuizJob")
    public Job makeReactQuizJob() {
        return makeQuizFlow(jobBuilderFactory, apiReactRequestStep(),
                converterFromResponseStep,
                categoryMapperStep,
                CategoryTitle.REACT);
    }

    @Bean(name = "apiReactRequestStep")
    public Step apiReactRequestStep() {
        return stepBuilderFactory.get("apiReactRequestStep")
                .tasklet(apiReactRequestTasklet)
                .build();
    }
}
