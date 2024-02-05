package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiDjangoRequestTasklet;
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
public class MakeDjangoQuizConfig extends MakeQuizJobFlow {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ApiDjangoRequestTasklet apiDjangoRequestTasklet;

    private final Step converterFromResponseStep;
    private final Step categoryMapperStep;

    @Bean(name = "makeDjangoQuizJob")
    public Job makeDjangoQuizJob() {
        return makeQuizFlow(jobBuilderFactory, apiDjangoRequestStep(),
                converterFromResponseStep,
                categoryMapperStep,
                CategoryTitle.DJANGO);
    }

    @Bean(name = "apiDjangoRequestStep")
    public Step apiDjangoRequestStep() {
        return stepBuilderFactory.get("apiDjangoRequestStep")
                .tasklet(apiDjangoRequestTasklet)
                .build();
    }
}
