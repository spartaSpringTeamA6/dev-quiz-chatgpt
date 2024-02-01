package org.example.devquizbatch.tasklets.makequiz.step1apirequest;

public enum CategoryTitle {

	JAVA("java"), DATA_STRUCTURE("datastructure"), DATABASE("database"), SPRING("spring"), NETWORK(
		"network"), INTERVIEW("interview");

	private final String categoryTitle;

	CategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String get() {
		return categoryTitle;
	}
}
