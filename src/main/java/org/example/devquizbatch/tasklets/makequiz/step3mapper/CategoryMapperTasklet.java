package org.example.devquizbatch.tasklets.makequiz.step3mapper;

import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.domain.category.Category;
import org.example.devquizbatch.domain.category.CategoryRepository;
import org.example.devquizbatch.domain.quiz.Quiz;
import org.example.devquizbatch.tasklets.makequiz.step2converter.QuizDtoFromResponse;
import org.example.devquizbatch.tasklets.makequiz.step2converter.QuizDtoFromResponseQueue;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryMapperTasklet implements Tasklet {

	private final CategoryRepository categoryRepository;

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
		throws Exception {
		List<QuizDtoFromResponse> quizDtoFromResponses = QuizDtoFromResponseQueue.getOne();
		Category category = categoryRepository.findCategoryByCategoryTitle(
			quizDtoFromResponses.get(0).getCategoryTitle().get());
		List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);
		QuizQueue.add(quizzes);
		return RepeatStatus.FINISHED;
	}
}
