package org.example.devquizbatch.tasklets.makequiz.step3mapper;


import lombok.extern.slf4j.Slf4j;
import org.example.devquizbatch.domain.quiz.Quiz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


@Slf4j
public class QuizQueue {

	private static final Queue<List<Quiz>> quizzesQueue = new LinkedList<>();

	private QuizQueue() {

	}
	public static void add(List<Quiz> quizzes) {
		try {
			quizzesQueue.add(quizzes);
		} catch (IllegalStateException e) {
			log.error("큐 공간 부족");
		}
	}

	public static List<Quiz> getOne() {
		return quizzesQueue.poll();
	}

	public static List<Quiz> getAllFromQueue() {
		List<Quiz> quizzes = new ArrayList<>();
		int size = quizzesQueue.size();
		for (int i = 0; i < size; i++) {
			List<Quiz> quizzesFromQueue = quizzesQueue.poll();
			if (quizzesFromQueue == null || quizzesFromQueue.size() == 0) {
				return quizzes;
			}
			quizzes.addAll(quizzesFromQueue);
		}
		return quizzes;
	}
}
