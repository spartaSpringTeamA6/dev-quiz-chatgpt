package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiSpringRequestTasklet;
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
public class MakeSpringQuizConfig extends MakeQuizJobFlow {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	private final ApiSpringRequestTasklet apiSpringRequestTasklet;

	private final Step converterFromResponseStep;
	private final Step categoryMapperStep;

	@Bean(name = "makeSpringQuizJob")
	public Job makeSpringQuizJob() {
		return makeQuizFlow(jobBuilderFactory, apiSpringRequestStep(),
			converterFromResponseStep,
			categoryMapperStep, CategoryTitle.SPRING);
	}

	@Bean(name = "apiSpringRequestStep")
	public Step apiSpringRequestStep() {
		return stepBuilderFactory.get("apiSpringRequestStep")
			.tasklet(apiSpringRequestTasklet)
			.build();
	}
}
