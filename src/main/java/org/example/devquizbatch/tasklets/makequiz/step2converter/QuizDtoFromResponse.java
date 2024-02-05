package org.example.devquizbatch.tasklets.makequiz.step2converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuizDtoFromResponse {

	private CategoryTitle categoryTitle;

	private String id;

	private String title;

	private List<Choice> choices;

	public void setId() {
		this.id = this.categoryTitle.get() + "_" + ((int) (Math.random() * 10000));
	}

	public void setCategoryTitle(CategoryTitle categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Choice {

		private String content;

		private boolean isAnswer;
	}
}
