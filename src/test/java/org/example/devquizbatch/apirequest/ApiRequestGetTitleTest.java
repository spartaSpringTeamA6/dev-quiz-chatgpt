package org.example.devquizbatch.apirequest;

import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiCRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiComputerScienceRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiDatabaseRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiDjangoRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiJPARequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiJavaRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiJavaScriptRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiLinuxRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiNetworkRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiPythonRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiReactRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiRequestAbstractTemplate;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.ApiSpringRequestTasklet;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiRequestGetTitleTest {
    @Mock
    private RestTemplate restTemplate;
    private ApiRequestAbstractTemplate apiRequestTasklet;

    @Test
    public void 스프링_카테고리를_가져온다(){
        apiRequestTasklet = new ApiSpringRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.SPRING);
    }
    @Test
    public void 네트워크_카테고리를_가져온다(){
        apiRequestTasklet = new ApiNetworkRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.NETWORK);
    }
    @Test
    public void 자바_카테고리를_가져온다(){
        apiRequestTasklet = new ApiJavaRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.JAVA);
    }
    @Test
    public void 데이터베이스_카테고리를_가져온다(){
        apiRequestTasklet = new ApiDatabaseRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.DATABASE);
    }
    @Test
    public void C_카테고리를_가져온다(){
        apiRequestTasklet = new ApiCRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.C);
    }
    @Test
    public void 컴퓨터_사이언스_카테고리를_가져온다(){
        apiRequestTasklet = new ApiComputerScienceRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.COMPUTER_SCIENCE);
    }
    @Test
    public void 리액트_카테고리를_가져온다(){
        apiRequestTasklet = new ApiReactRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.REACT);
    }
    @Test
    public void 자바스크립트_카테고리를_가져온다(){
        apiRequestTasklet = new ApiJavaScriptRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.JAVASCRIPT);
    }
    @Test
    public void 리눅스_카테고리를_가져온다(){
        apiRequestTasklet = new ApiLinuxRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.LINUX);
    }
    @Test
    public void 파이썬_카테고리를_가져온다(){
        apiRequestTasklet = new ApiPythonRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.PYTHON);
    }
    @Test
    public void JPA_카테고리를_가져온다(){
        apiRequestTasklet = new ApiJPARequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.JPA);
    }
    @Test
    public void 장고_카테고리를_가져온다(){
        apiRequestTasklet = new ApiDjangoRequestTasklet(restTemplate);
        CategoryTitle categoryTitle = apiRequestTasklet.getCategoryTitle();

        assertThat(categoryTitle).isEqualTo(CategoryTitle.DJANGO);
    }
}
