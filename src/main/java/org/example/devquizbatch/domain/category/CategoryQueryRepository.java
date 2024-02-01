package org.example.devquizbatch.domain.category;


public interface CategoryQueryRepository {

	Category findCategoryByCategoryTitle(final String categoryTitle);

}
