package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiJavaScriptRequestTasklet;
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
public class MakeJavaScriptQuizConfig extends MakeQuizJobFlow {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ApiJavaScriptRequestTasklet apiJavaScriptRequestTasklet;

    private final Step converterFromResponseStep;
    private final Step categoryMapperStep;

    @Bean(name = "makeJavaScriptQuizJob")
    public Job makeJavaScriptQuizJob() {
        return makeQuizFlow(jobBuilderFactory, apiJavaScriptRequestStep(),
                converterFromResponseStep,
                categoryMapperStep,
                CategoryTitle.JAVASCRIPT);
    }

    @Bean(name = "apiJavaScriptRequestStep")
    public Step apiJavaScriptRequestStep() {
        return stepBuilderFactory.get("apiJavaScriptRequestStep")
                .tasklet(apiJavaScriptRequestTasklet)
                .build();
    }
}
