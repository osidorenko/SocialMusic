package by.bsuir.spp_project.config;

import by.bsuir.spp_project.service.secure.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class BasicConfig extends WebSecurityConfigurerAdapter {

    @Value("${app.noLogin}")
    private String noLogin;

    public boolean isNoLogin() {
        return noLogin.equals("true");
    }

    @Autowired
    private ClientServiceImpl userService;

    @Bean
    public FilterRegistrationBean loginFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(loginFilter());
        registration.addUrlPatterns("/*");
        registration.setName("loginFilter");
        registration.setOrder(1);
        return registration;
    }

    public Filter loginFilter() {
        return new LoginFilter(isNoLogin());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if(isNoLogin()) {
            http.cors().and().csrf().disable().anonymous();
        } else {
            http
//                .anonymous();
                    .authorizeRequests()
                    .antMatchers("/**").authenticated()
//                    .antMatchers( "/css/**").permitAll()
                    //Swagger URL matches!!!

                    .anyRequest()
                    .authenticated()
                    .and()
                    .csrf().disable()
                    .formLogin().defaultSuccessUrl("/index.html");
        }
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
//        auth.setPasswordEncoder(new EmptyPasswordEncoder());
        return auth;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//for multiple encodings use {encoding key}hash format
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        ((DelegatingPasswordEncoder)encoder).setDefaultPasswordEncoderForMatches(new MessageDigestPasswordEncoder("MD5"));
        return new MessageDigestPasswordEncoder("MD5");
    }

    private class EmptyPasswordEncoder implements PasswordEncoder {

        public String encode(CharSequence rawPassword) {
            return rawPassword.toString();
        }

        public boolean matches(CharSequence rawPassword, String prefixEncodedPassword) {
            return rawPassword.equals(prefixEncodedPassword);
        }
    }

}