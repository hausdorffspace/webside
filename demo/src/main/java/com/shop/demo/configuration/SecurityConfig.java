package com.shop.demo.configuration;

import com.shop.demo.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index", "/users", "/", "/addArticle","/viewArticle")
                .hasAnyAuthority("ROLE_USER")
                .anyRequest()
                .permitAll()
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/index")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceImplementation)
                .passwordEncoder(passwordEncoder);

        /*auth.inMemoryAuthentication()
                .withUser("test")
                .password(passwordEncoder.encode("test"))
                .roles("USERS");*/
        /*auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT login, password,enabled " +
                        "FROM user " +
                        "WHERE login = ?")
                .authoritiesByUsernameQuery("SELECT login, role " +
                        "FROM user_role a, user u, user_user_role r" +
                        "WHERE u.login = ? " +
                        "AND r.user_id = u.user_id")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);*/
    }
}
