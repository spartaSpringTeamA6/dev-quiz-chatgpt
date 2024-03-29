package org.example.devquizbatch.tasklets.makequiz.step2converter;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class QuizDtoFromResponseQueue {


	private static final Queue<List<QuizDtoFromResponse>> quizDtoFromResponsesQueue = new LinkedList<>();

	private QuizDtoFromResponseQueue() {

	}

	public static void add(List<QuizDtoFromResponse> quizDtoFromResponses) {
		try {
			quizDtoFromResponsesQueue.add(quizDtoFromResponses);
		} catch (IllegalStateException e) {
			log.error("큐 공간 부족");
		}
	}

	public static List<QuizDtoFromResponse> getOne() {
		return quizDtoFromResponsesQueue.poll();
	}
}
