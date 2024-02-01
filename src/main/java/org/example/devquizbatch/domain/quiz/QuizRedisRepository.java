package org.example.devquizbatch.domain.quiz;

import org.example.devquizbatch.domain.quizschema.QuizSchema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRedisRepository extends CrudRepository<QuizSchema, String> {

}
