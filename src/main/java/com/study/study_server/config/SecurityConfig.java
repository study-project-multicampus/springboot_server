package com.study.study_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login/**").authenticated()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout() //logout configuration
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");
        http.csrf()
                .ignoringAntMatchers("/h2-console/**")
                .disable();

    }



}
