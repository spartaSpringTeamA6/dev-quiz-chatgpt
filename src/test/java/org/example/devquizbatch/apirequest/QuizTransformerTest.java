package org.example.devquizbatch.apirequest;

import org.example.devquizbatch.domain.category.Category;
import org.example.devquizbatch.domain.quiz.Quiz;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;
import org.example.devquizbatch.tasklets.makequiz.step2converter.QuizDtoConverter;
import org.example.devquizbatch.tasklets.makequiz.step2converter.QuizDtoFromResponse;
import org.example.devquizbatch.tasklets.makequiz.step3mapper.QuizTransformer;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class QuizTransformerTest {

    String responseJsonFromOPENAIAPI;

    List<QuizDtoFromResponse> quizDtoFromResponses;

    @BeforeEach
    void setUp() {
        responseJsonFromOPENAIAPI = "["
                + "{\"title\": \"4-3은?\", \"choices\": [{\"content\": \"1\", \"isAnswer\": true},{\"content\": \"2\", \"isAnswer\":false},{\"content\": \"5\", \"isAnswer\": false},{\"content\": \"4\", \"isAnswer\": false} ]},"
                + "{\"title\": \"7-2은?\", \"choices\": [{\"content\": \"1\", \"isAnswer\": false},{\"content\": \"5\", \"isAnswer\":true},{\"content\": \"3\", \"isAnswer\": false},{\"content\": \"4\", \"isAnswer\": false} ]},"
                + "{\"title\": \"8-4은?\", \"choices\": [{\"content\": \"3\", \"isAnswer\": false},{\"content\": \"2\", \"isAnswer\":false},{\"content\": \"5\", \"isAnswer\": false},{\"content\": \"4\", \"isAnswer\": true} ]}"
                + "]";
    }

    @Test
    public void 자바_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.JAVA.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.JAVA);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.JAVA.get());
    }
    @Test
    public void C_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.C.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.C);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.C.get());
    }
    @Test
    public void 컴퓨터_사이언스_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.COMPUTER_SCIENCE.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.COMPUTER_SCIENCE);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.COMPUTER_SCIENCE.get());
    }
    @Test
    public void 데이터베이스_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.DATABASE.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.DATABASE);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.DATABASE.get());
    }
    @Test
    public void 장고_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.DJANGO.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.DJANGO);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.DJANGO.get());
    }
    @Test
    public void 파이썬_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.PYTHON.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.PYTHON);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.PYTHON.get());
    }
    @Test
    public void 리액트_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.REACT.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.REACT);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.REACT.get());
    }
    @Test
    public void 리눅스_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.LINUX.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.LINUX);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.LINUX.get());
    }
    @Test
    public void 자바스크립트_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.JAVASCRIPT.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.JAVASCRIPT);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.JAVASCRIPT.get());
    }
    @Test
    public void JPA_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.JPA.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.JPA);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.JPA.get());
    }
    @Test
    public void 네트워크_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.NETWORK.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.NETWORK);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.NETWORK.get());
    }
    @Test
    public void 스프링_카테고리가_담긴_퀴즈_Response_dto_로부터_Quiz_엔티티로_변환한다() {
        Category category = Category.builder()
            .categoryTitle(CategoryTitle.SPRING.get())
            .build();

        quizDtoFromResponses = QuizDtoConverter.toQuizDtosFromResponses(responseJsonFromOPENAIAPI,
            CategoryTitle.SPRING);

        List<Quiz> quizzes = QuizTransformer.toQuizzes(quizDtoFromResponses, category);

        assertThat(quizzes.get(0).getQuizChoices().size()).isEqualTo(4);
        assertThat(quizzes.get(0).getCategory().getCategoryTitle()).isEqualTo(
            CategoryTitle.SPRING.get());
    }
}
