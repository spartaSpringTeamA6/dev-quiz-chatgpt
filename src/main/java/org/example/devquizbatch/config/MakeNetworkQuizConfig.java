package org.example.devquizbatch.config;


import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiNetworkRequestTasklet;
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
public class MakeNetworkQuizConfig extends MakeQuizJobFlow {


	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	private final ApiNetworkRequestTasklet apiNetworkRequestTasklet;

	private final Step converterFromResponseStep;
	private final Step categoryMapperStep;

	@Bean(name = "makeNetworkQuizJob")
	public Job makeNetworkQuizJob() {
		return makeQuizFlow(jobBuilderFactory, apiNetworkRequestStep(),
			converterFromResponseStep,
			categoryMapperStep, CategoryTitle.NETWORK);
	}

	@Bean(name = "apiNetworkRequestStep")
	public Step apiNetworkRequestStep() {
		return stepBuilderFactory.get("apiNetworkRequestStep")
			.tasklet(apiNetworkRequestTasklet)
			.build();
	}
}
