package org.example.devquizbatch.tasklets.makequiz.step2converter;

import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConverterTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
		throws Exception {
		final ExecutionContext jobExecutionContext = chunkContext.getStepContext()
			.getStepExecution().getJobExecution().getExecutionContext();
		String response = jobExecutionContext.getString("response");
		CategoryTitle categoryTitle = (CategoryTitle) jobExecutionContext.get("categoryTitle");
		List<QuizDtoFromResponse> quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(
			response, categoryTitle);
		QuizDtoFromResponseQueue.add(quizDtoFromResponses);
		return RepeatStatus.FINISHED;
	}
}
