package org.example.devquizbatch.apirequest;

import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ChatRequest;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChatRequestTest {

    private final ChatRequest chatRequest = new ChatRequest();

    @Test
    public void 자바_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.JAVA);
        assertThat(message).isEqualTo(
            "자바와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void C_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.C);
        assertThat(message).isEqualTo(
            "C 프로그래밍 언어와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 컴퓨터_사이언스_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.COMPUTER_SCIENCE);
        assertThat(message).isEqualTo(
            "컴퓨터 전공 과목과 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 데이터베이스_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.DATABASE);
        assertThat(message).isEqualTo(
            "데이터베이스와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 장고_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.DJANGO);
        assertThat(message).isEqualTo(
            "장고 프레임워크와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 파이썬_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.PYTHON);
        assertThat(message).isEqualTo(
            "파이썬과 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 리액트_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.REACT);
        assertThat(message).isEqualTo(
            "리액트와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 리눅스_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.LINUX);
        assertThat(message).isEqualTo(
            "리눅스와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 자바스크립트_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.JAVASCRIPT);
        assertThat(message).isEqualTo(
            "자바스크립트와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void JPA_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.JPA);
        assertThat(message).isEqualTo(
            "JPA와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 네트워크_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.NETWORK);
        assertThat(message).isEqualTo(
            "네트워크와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }
    @Test
    public void 스프링_카테고리를_넣었을때_메세지_요청() {
        String message = chatRequest.addCategorySpecificMessage(CategoryTitle.SPRING);
        assertThat(message).isEqualTo(
            "스프링 프레임워크와 관련된 cs 면접 문제를 5개 만들어줘, 단 정답은 무조건 한개이어야 하고, 선택지는 4개이어야 해, JSON 형식으로 만들어줘");
    }

}
