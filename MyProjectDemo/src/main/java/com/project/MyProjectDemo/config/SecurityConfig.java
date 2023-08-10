package com.project.MyProjectDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	// Authentication
	@Bean
	public UserDetailsService userDetailsService() {
		
	/*	UserDetails
		  krishna=User.withUsername("krishna").password(encoder.encode("soppari")).
		  roles("ADMIN").build(); 
		UserDetails
		  sowmya=User.withUsername("sowmya").password(encoder.encode(
		  "palthi")).roles("USER").build(); 
		return new
		  InMemoryUserDetailsManager(krishna,sowmya);  */
		return new UserInfoUserDetailsService();
	}
	
	//Authorization
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/products/welcome","/products/new","/products/add")
				.permitAll().and().authorizeHttpRequests().requestMatchers("/products/**")
				.authenticated().and().formLogin().and().build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
}
