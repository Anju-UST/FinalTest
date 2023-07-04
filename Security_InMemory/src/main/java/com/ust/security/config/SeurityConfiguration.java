package com.ust.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SeurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("anju").password("jubin").roles("ADMIN")
		.and()
		.withUser("annu").password("minnu").roles("USER")
		.and()
		.withUser("anjana").password("ss").roles("ADMIN")
		.and()
		.withUser("angelin").password("ang").roles("STAFF");
		
	}
	//anju--user and admin
	//annu-only user
	//anjana-- only admin 
	//both except staff
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		//.antMatchers("/user").hasRole("USER")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/forAll").permitAll().and().formLogin();
		
	}
	@Bean
	@SuppressWarnings("depreciation")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
