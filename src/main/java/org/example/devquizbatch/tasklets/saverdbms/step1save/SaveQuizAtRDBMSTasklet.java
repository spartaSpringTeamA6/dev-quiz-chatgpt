package org.example.devquizbatch.tasklets.saverdbms.step1save;


import lombok.RequiredArgsConstructor;
import org.example.devquizbatch.domain.quiz.Quiz;
import org.example.devquizbatch.domain.quiz.QuizRepository;
import org.example.devquizbatch.tasklets.makequiz.step3mapper.QuizQueue;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class SaveQuizAtRDBMSTasklet implements Tasklet {

	private final QuizRepository quizRepository;


	/**
	 * RDBMS에 퀴즈를 저장하는 Tasklet입니다. 퀴즈 목록을 가져와서 RDBMS에 저장합니다.
	 *
	 * @param stepContribution StepContribution 객체
	 * @param chunkContext     ChunkContext 객체
	 * @return RepeatStatus.FINISHED
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
		throws Exception {
		List<Quiz> quizzes = QuizQueue.getAllFromQueue();
		quizRepository.saveAll(quizzes);
		return RepeatStatus.FINISHED;
	}
}
