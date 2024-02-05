package org.example.devquizbatch.tasklets.makequiz.step1apirequest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiLinuxRequestTasklet extends ApiRequestAbstractTemplate {

        public ApiLinuxRequestTasklet(RestTemplate restTemplate) {
            super(restTemplate);
        }

        @Override
        public CategoryTitle getCategoryTitle() {
            return CategoryTitle.LINUX;
        }
}
