package by.bsuir.spp_project.controller;

import by.bsuir.spp_project.config.UserContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BasicController {
    @Autowired
    private HttpServletRequest httpServletRequest;

    protected UserContext context() {
        return UserContext.get(httpServletRequest);
    }
}
