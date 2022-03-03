package by.bsuir.spp_project.controller.shutdown;

import org.springframework.context.annotation.Bean;

import javax.annotation.PreDestroy;


public class TerminateBean {
    @PreDestroy
    public void onDestroy() throws Exception {
        System.out.println("Spring Container is destroyed!");
    }
}
