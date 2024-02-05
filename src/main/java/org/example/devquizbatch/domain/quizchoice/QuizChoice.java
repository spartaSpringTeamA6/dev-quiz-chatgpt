package org.example.devquizbatch.domain.quizchoice;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.devquizbatch.domain.quiz.Quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Getter
@Table(name = "quiz_choice")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "choice_id")
	private long choiceId;

	@Column(nullable = false, name = "choice_content")
	private String choiceContent;

	@Column(nullable = false, name = "choice_sequence")
	private int choiceSequence;

	@Column(nullable = false, name = "is_answer")
	private boolean isAnswer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	public boolean getIsAnswer() {
		return isAnswer;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public void updateContent(final String updateContent) {
		this.choiceContent = updateContent;
	}

	public void updateIsAnswer(final boolean updateIsAnswer) {
		this.isAnswer = isAnswer;
	}
}
