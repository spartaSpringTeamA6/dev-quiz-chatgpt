package org.example.devquizbatch.domain.quiz;

import java.util.List;


public interface QuizQueryRepository {

	List<QuizQueryDto> getQuizzesForRedisBy();

}
