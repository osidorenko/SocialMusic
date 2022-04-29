package by.bsuir.spp_project.config;

import by.bsuir.spp_project.entity.secure.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;


import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContext implements Serializable {

    public final static String path = "by.bsuir.spp_project.config.UserContext";
    private Integer id;
    private String name;
    private Set<String> roles = new HashSet<String>();

    public static UserContext init(Client user, HttpServletRequest request) {
        if(user != null){
            if(request.getSession().getAttribute(path) == null) {
                UserContext ctx = new UserContext();
                ctx.setId(user.getId());
                ctx.setName(user.getLogin());
                SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(it -> ctx.getRoles().add(it.getAuthority()));
                request.getSession().setAttribute(path, ctx);
                return ctx;
            } else return get(request);
        }
        return null;
    }

    public static UserContext get(HttpServletRequest request) {
        if(request.getSession().getAttribute(path) != null)
            return (UserContext)request.getSession().getAttribute(path);
        return null;
    }
}
