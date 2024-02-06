package org.example.devquizbatch.tasklets.makequiz.step1apirequest;

public enum CategoryTitle {

	JAVA("JAVA"),
	DATABASE("DATABASE"),
	SPRING("SPRING"),
	NETWORK("NETWORK"),
	PYTHON("PYTHON"),
	COMPUTER_SCIENCE("COMPUTER_SCIENCE"),
	DJANGO("DJANGO"),
	JPA("JPA"),
	LINUX("LINUX"),
	C("C"),
	REACT("REACT"),
	JAVASCRIPT("JAVASCRIPT");

	private final String categoryTitle;

	CategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String get() {
		return categoryTitle;
	}
}
