package com.aditya.dataprovider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${spring.security.user.name}")
	private String uname;
	
	@Value("${spring.security.user.password}")
	private String upass;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception 
	    {
	        http
	         .csrf().disable()
	         .authorizeRequests().anyRequest().authenticated()
	         .and()
	         .httpBasic();
	    }
	  
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	            throws Exception 
	    {
	        auth.inMemoryAuthentication()
	            .withUser("aditya")
	            .password("{noop}password")
	            .roles("ADMIN");
	    }

}
