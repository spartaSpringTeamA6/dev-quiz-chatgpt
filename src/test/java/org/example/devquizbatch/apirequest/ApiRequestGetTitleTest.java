package org.example.devquizbatch.apirequest;

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
}
