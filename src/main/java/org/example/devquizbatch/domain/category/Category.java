package org.example.devquizbatch.domain.category;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.devquizbatch.domain.BaseTimeEntity;
import org.example.devquizbatch.domain.quiz.Quiz;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
public class Category extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;

	@Column(nullable = false, name = "category_title")
	private String categoryTitle;

	@Column(nullable = true, name = "category_description")
	private String categoryDescription;

	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Quiz> quizzes;


	public void updateCategoryName(String categoryTitle) {
		if (categoryTitle != null && !categoryTitle.isEmpty()) {
			this.categoryTitle = categoryTitle;
		}
	}

	public void updateCategoryDescription(String categoryDescription) {
		if (categoryDescription != null && !categoryDescription.isEmpty()) {
			this.categoryDescription = categoryDescription;
		}
	}
	//

}
