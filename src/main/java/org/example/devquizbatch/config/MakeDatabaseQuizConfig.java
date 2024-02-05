package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiDatabaseRequestTasklet;
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
public class MakeDatabaseQuizConfig extends MakeQuizJobFlow {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	private final ApiDatabaseRequestTasklet apiDatabaseRequestTasklet;

	private final Step converterFromResponseStep;
	private final Step categoryMapperStep;

	@Bean(name = "makeDatabaseQuizJob")
	public Job makeDatabaseQuizJob() {
		return makeQuizFlow(jobBuilderFactory, apiDatabaseRequestStep(),
			converterFromResponseStep,
			categoryMapperStep,
			CategoryTitle.DATABASE);
	}

	@Bean(name = "apiDatabaseRequestStep")
	public Step apiDatabaseRequestStep() {
		return stepBuilderFactory.get("apiDatabaseRequestStep")
			.tasklet(apiDatabaseRequestTasklet)
			.build();
	}
}
