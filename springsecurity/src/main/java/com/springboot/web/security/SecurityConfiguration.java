package com.springboot.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration  extends  WebSecurityConfigurerAdapter{
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		set your configuration on the yuth  object
		auth.inMemoryAuthentication()
		.withUser("blash")
		.password("blash")
		.roles("User")
		.and()
		.withUser("foo")
		.password("foo")
		.roles("ADMIN");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.authorizeHttpRequests()
		.antMatchers("/**")
		.hasRole("ADMIN")
		.and().formLogin();
	}
	@Bean
	public  PasswordEncoder getPasswordEncoder() {	
		return NoOpPasswordEncoder.getInstance();
	}
}
