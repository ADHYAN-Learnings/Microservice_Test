package com.pamater.practiice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		
		UserDetails admin = User.builder()
				                .username("admin")
				                .password(passwordEncoder.encode("admin123"))
				                .roles("ADMIN")
				                .build();
		
		UserDetails user = User.builder()
				               .username("Aditya")
				               .password(passwordEncoder.encode("aditya123"))
				               .roles("USER")
				               .build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
	

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	  
		http.csrf(csrf -> csrf.disable())
		    .authorizeHttpRequests(auth -> auth
			.requestMatchers(HttpMethod.GET,"/employee/pathVariable/**").hasAnyRole("ADMIN","USER")
			.requestMatchers(HttpMethod.POST,"/employee/pathVariable/**").hasAnyRole("ADMIN")
			.requestMatchers(HttpMethod.DELETE,"/employee/pathVariable/**").hasAnyRole("ADMIN")
			
			.anyRequest().authenticated()
				).httpBasic(Customizer.withDefaults());
		
		return http.build();
	}

}
