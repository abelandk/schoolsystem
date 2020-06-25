package com.springpractice.schoolsystem.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/course/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN")
			.antMatchers("/student/**").hasAnyRole("STUDENT")
			.antMatchers("/teacher/**").hasAnyRole("TEACHER")
			.antMatchers("/", "/index", "/login").permitAll()
			.anyRequest().authenticated()
		
		  .and() .formLogin() .loginPage("/login")
		  .loginProcessingUrl("/authenticateTheUser") //No need to write a controller for this url, 
		  											  // spring provides it for free .permitAll() .and() .logout()
		  .and() 
		  .exceptionHandling()
		  .accessDeniedPage("/access-denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				
		auth.authenticationProvider(daoAuthenticationProvider());
		
		
	}

	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailService);
		
		return daoAuthenticationProvider;
	}

	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
