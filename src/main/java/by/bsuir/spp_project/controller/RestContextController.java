package by.bsuir.spp_project.controller;

import by.bsuir.spp_project.SppProjectApplication;
import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestContextController implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    @PostMapping("/stop")
    public void shutdownContext() {
        ((ConfigurableApplicationContext) applicationContext).close();
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.applicationContext = ctx;

    }
}
