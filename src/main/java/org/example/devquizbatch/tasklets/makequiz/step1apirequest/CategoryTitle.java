package org.example.devquizbatch.tasklets.makequiz.step1apirequest;

public enum CategoryTitle {

	JAVA("java"),
	DATABASE("database"),
	SPRING("spring"),
	NETWORK("network"),
	PYTHON("python"),
	COMPUTER_SCIENCE("computerscience"),
	DJANGO("django"),
	JPA("jpa"),
	LINUX("linux"),
	C("c"),
	REACT("react"),
	JAVASCRIPT("javascript");

	private final String categoryTitle;

	CategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String get() {
		return categoryTitle;
	}
}
