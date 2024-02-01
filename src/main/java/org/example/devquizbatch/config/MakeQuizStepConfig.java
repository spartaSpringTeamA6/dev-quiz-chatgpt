package org.example.devquizbatch.config;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.tasklets.makequiz.step2converter.ConverterTasklet;
import org.example.devquizbatch.tasklets.makequiz.step3mapper.CategoryMapperTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MakeQuizStepConfig {

	private final StepBuilderFactory stepBuilderFactory;

	private final ConverterTasklet converterTasklet;

	private final CategoryMapperTasklet categoryMapperTasklet;

	@Bean(name = "converterFromResponseStep")
	public Step converterFromResponseStep() {
		return stepBuilderFactory.get("converterFromResponseStep")
			.tasklet(converterTasklet)
			.build();
	}

	@Bean(name = "categoryMapperStep")
	public Step categoryMapperStep() {
		return stepBuilderFactory.get("categoryMapperStep")
			.tasklet(categoryMapperTasklet)
			.build();
	}
}
