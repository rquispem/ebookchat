package com.app.rquispe.ebook.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    /*
     * 1. The authentication will be done by a login web form.
     * 2. When the form submits a POST to /login, Spring Security will take care of the authentication for you.
     * 3. The login page is the root context, /.
     * 4. When the login succeeds, the user will be redirected to the /chat URI
     * 5. The logout URI is /logout, and after the logout action, the user will be redirected to the / URI, which is the login page.
     * 6. The URIs /login, /new-account, and / are allowed for everybody (including anonymous users).
     * 7. A POST to /chatroom (to create a chat room) is allowed only by users with the role ROLE_ADMIN.
     * 8. Any other requests are allowed only by logged-in users.
     *
     *
     * When theformlogin is submitted to POST /login,Spring Security will intercept the request and
     * query the MySQL instance to fetch the user and check whether the provided credentials are correct
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .formLogin()
                .loginProcessingUrl("/login") //este es la url que llama el formulario, security lo intercepta
                .loginPage("/") // esta es la pagina de login
                .defaultSuccessUrl("/chat") // cuandp todo bien se va a /chat controller
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .and()
            .authorizeRequests()
                .antMatchers("/login", "/new-account", "/", "/webjars/**").permitAll()
                .antMatchers(HttpMethod.POST, "/chatroom").hasRole("ADMIN")
                .anyRequest().authenticated();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    /*
     * The BCryptPasswordEncoder component is used to encrypt the user’s password using bcrypt.
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
