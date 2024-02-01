package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiInterviewRequestTasklet;
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
public class MakeInterviewQuizConfig extends MakeQuizJobFlow {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	private final ApiInterviewRequestTasklet apiInterviewRequestTasklet;

	private final Step converterFromResponseStep;
	private final Step categoryMapperStep;

	//	/**
//	 * Interview Quiz 생성 작업을 수행하는 Batch Job을 생성합니다.
//	 *
//	 * @return Interview Quiz 생성 Job
//	 */
	@Bean(name = "makeInterviewQuizJob")
	public Job makeInterviewQuizJob() {
		return makeQuizFlow(jobBuilderFactory, apiInterviewRequestStep(),
			converterFromResponseStep,
			categoryMapperStep, CategoryTitle.INTERVIEW);
	}

	@Bean(name = "apiInterviewRequestStep")
	public Step apiInterviewRequestStep() {
		return stepBuilderFactory.get("apiInterviewRequestStep")
			.tasklet(apiInterviewRequestTasklet)
			.build();
	}
}
