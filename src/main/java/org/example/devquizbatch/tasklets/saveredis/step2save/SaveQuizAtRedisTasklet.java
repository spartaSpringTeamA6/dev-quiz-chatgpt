package org.example.devquizbatch.tasklets.saveredis.step2save;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.devquizbatch.domain.quiz.QuizQueryDto;
import org.example.devquizbatch.domain.quiz.QuizRedisRepository;
import org.example.devquizbatch.domain.quiz.QuizRepository;
import org.example.devquizbatch.domain.quizschema.QuizSchema;
import org.example.devquizbatch.domain.quizschema.QuizSchemaMapper;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class SaveQuizAtRedisTasklet implements Tasklet {


	private final QuizRedisRepository quizRedisRepository;

	private final QuizRepository quizRepository;

	/**
	 * Redis에 퀴즈를 저장하는 Tasklet입니다. RDBMS에서 퀴즈 목록을 가져와서 Redis에 저장합니다.
	 *
	 * @param stepContribution StepContribution 객체
	 * @param chunkContext     ChunkContext 객체
	 * @return RepeatStatus.FINISHED
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
		throws Exception {
		List<QuizQueryDto> quizzes = quizRepository.getQuizzesForRedisBy();
		List<QuizSchema> quizSchemas = QuizSchemaMapper.toQuizSchemas(quizzes);
		quizRedisRepository.saveAll(quizSchemas);
		return RepeatStatus.FINISHED;
	}
}
