package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
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
public class MakeLinuxQuizConfig extends MakeQuizJobFlow {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ApiLinuxRequestTasklet apiLinuxRequestTasklet;

    private final Step converterFromResponseStep;
    private final Step categoryMapperStep;

    @Bean(name = "makeLinuxQuizJob")
    public Job makeLinuxQuizJob() {
        return makeQuizFlow(jobBuilderFactory, apiLinuxRequestStep(),
                converterFromResponseStep,
                categoryMapperStep,
                CategoryTitle.LINUX);
    }

    @Bean(name = "apiLinuxRequestStep")
    public Step apiLinuxRequestStep() {
        return stepBuilderFactory.get("apiLinuxRequestStep")
                .tasklet(apiLinuxRequestTasklet)
                .build();
    }
}
