package org.example.devquizbatch.tasklets.makequiz.step3mapper;

import org.example.devquizbatch.domain.category.Category;
import org.example.devquizbatch.domain.quiz.Quiz;
import org.example.devquizbatch.domain.quizchoice.QuizChoice;
import org.example.devquizbatch.tasklets.makequiz.step2converter.QuizDtoFromResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class QuizTransformer {

	public static List<Quiz> toQuizzes(final List<QuizDtoFromResponse> quizDtoFromResponses,
									   final Category category) {
		return quizDtoFromResponses.stream()
			.map(quizDto -> {
				final Quiz quiz = createQuizFromRequest(quizDto);
				addChoicesToQuiz(quiz, quizDto.getChoices());
				quiz.addCategory(category);
				return quiz;
			})
			.collect(Collectors.toList());
	}

	private static Quiz createQuizFromRequest(final QuizDtoFromResponse quizDto) {
		return Quiz.builder()
			.quizTitle(quizDto.getTitle())
			.build();
	}

	private static void addChoicesToQuiz(final Quiz quiz,
		final List<QuizDtoFromResponse.Choice> choices) {

		IntStream.range(0, choices.size())
				.forEach(index -> {
					QuizChoice quizChoice = QuizTransformer.createQuizChoiceFromChoiceDto(index,choices.get(index));
					quiz.addChoice(quizChoice);
				});
	}

	private static QuizChoice createQuizChoiceFromChoiceDto(
			int sequence,
		final QuizDtoFromResponse.Choice choice) {
		return QuizChoice.builder()
			.choiceContent(choice.getContent())
			.choiceSequence(sequence+1)
			.isAnswer(choice.isAnswer())
			.build();
	}

}
