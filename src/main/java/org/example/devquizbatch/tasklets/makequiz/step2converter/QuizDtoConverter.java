package org.example.devquizbatch.tasklets.makequiz.step2converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class QuizDtoConverter {

	public static List<QuizDtoFromResponse> toQuizDtosFromResponses(final String response,
		final CategoryTitle categoryTitle) {
		Gson gson = new Gson();

		Type quizListType = new TypeToken<List<QuizDtoFromResponse>>() {
		}.getType();

		List<QuizDtoFromResponse> quizDtoFromResponses = gson.fromJson(response, quizListType);
		for (QuizDtoFromResponse dto : quizDtoFromResponses) {
			dto.setCategoryTitle(categoryTitle);
			dto.setId();
		}
		return quizDtoFromResponses;
	}
}
