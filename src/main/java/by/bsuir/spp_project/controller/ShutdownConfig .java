package by.bsuir.spp_project.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ShutdownConfig {

    @Bean
    public TerminateBean getTerminateBean() {
        return new TerminateBean();
    }
}
