package org.example.devquizbatch.tasklets.makequiz.step1apirequest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiDjangoRequestTasklet extends ApiRequestAbstractTemplate {

        public ApiDjangoRequestTasklet(RestTemplate restTemplate) {
            super(restTemplate);
        }

        @Override
        public CategoryTitle getCategoryTitle() {
            return CategoryTitle.DJANGO;
        }
}
