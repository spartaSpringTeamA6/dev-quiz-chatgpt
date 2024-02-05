package org.example.devquizbatch.tasklets.makequiz.step1apirequest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiJavaScriptRequestTasklet extends ApiRequestAbstractTemplate {

        public ApiJavaScriptRequestTasklet(RestTemplate restTemplate) {
            super(restTemplate);
        }

        @Override
        public CategoryTitle getCategoryTitle() {
            return CategoryTitle.JAVASCRIPT;
        }
}
