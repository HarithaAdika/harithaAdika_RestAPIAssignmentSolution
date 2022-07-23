
package com.greatlearning.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employeemanagement.serviceImpl.MyUserDetailsService;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new MyUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(getUserDetailsService());
		auth.setPasswordEncoder(getBCryptPasswordEncoder());
		return auth;
	}

	@Override
	public void configure(AuthenticationManagerBuilder mgr) {
		mgr.authenticationProvider(getAuthenticationProvider());
	}

//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/", "/employees/list","/employees/getEmployeesByFirstName","/employees/getEmployeeById","/employees/sort")
//		.hasAnyRole()
//		//.hasAnyAuthority("USER", "ADMIN")
//		.antMatchers("/employees/addSingleEmployee","/employees/update", "/employees/delete").hasAnyAuthority("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().loginProcessingUrl("/login").successForwardUrl("/employees/list").permitAll()
//		.and()
//		.logout().logoutSuccessUrl("/login").permitAll()
//		.and()
//		.exceptionHandling()
//		.and()
//		.cors()
//		.and()
//		.csrf()
//		.disable();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/users/**", "/roles/**","/employees/addSingleEmployee", 
					"/employees/update", "/employees/delete")
			.hasAnyAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.formLogin();
//			.formLogin().loginProcessingUrl("/login").successForwardUrl("/employees/list").permitAll()
//			.and()
//			.logout().logoutSuccessUrl("/login").permitAll();

	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}
}
