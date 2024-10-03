package com.worker.config;

import org.camunda.community.rest.client.springboot.CamundaAutodeploymentProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CamundaConfiguration {

    @Bean
    @Primary
    public CamundaAutodeploymentProperties camundaAutodeploymentProperties() {
        CamundaAutodeploymentProperties properties = new CamundaAutodeploymentProperties();
        properties.setEnabled(false);
        return properties;
    }
}
