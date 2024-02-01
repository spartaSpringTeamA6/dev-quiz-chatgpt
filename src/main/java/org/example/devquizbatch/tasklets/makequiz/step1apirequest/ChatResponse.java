package org.example.devquizbatch.tasklets.makequiz.step1apirequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatResponse {

	private List<Choice> choices;

	// constructors, getters and setters

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public static class Choice {

		private int index;
		private Message message;

		// constructors, getters and setters
	}
}
