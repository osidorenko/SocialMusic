package by.bsuir.spp_project.config;

import by.bsuir.spp_project.entity.secure.Client;
import by.bsuir.spp_project.service.secure.ClientServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@NoArgsConstructor
public class LoginFilter implements Filter {
    private final static int TEST_USER_ID = 2;


    private boolean noLogin;
    ClientServiceImpl userService;
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig = filterConfig;
        userService = (ClientServiceImpl) WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext()).getBean("clientServiceImpl");
    }

    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)var1;
        Principal p = request.getUserPrincipal();
        if(noLogin) {
            if (request.getSession().getAttribute(UserContext.path) == null) {
                Client u = userService.findById(TEST_USER_ID);
                UserContext.init(u, request);
            }
        } else {
            if (p != null) {
                if (request.getSession().getAttribute(UserContext.path) == null) {
                    Client u = userService.byLogin(request.getUserPrincipal().getName());
                    UserContext.init(u, request);
                }
            }
        }
        try {
            var3.doFilter(var1, var2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void destroy(){

    }

    public LoginFilter(boolean login) {
        this.noLogin = login;
    }
}
