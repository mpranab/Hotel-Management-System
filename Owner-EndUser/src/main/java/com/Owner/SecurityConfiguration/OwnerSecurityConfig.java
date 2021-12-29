package com.Owner.SecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Owner.Service.OwnerService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class OwnerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private OwnerService ownerService;

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(ownerService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
	   //authorizeRequests() Allows restricting access based upon the HttpServletRequest using RequestMatcher implementations.
		
	   //permitAll() This will allow the public access that is anyone can access endpoint PUBLIC_URL without authentication.
		
	   //http.csrf().disable() 
	   //It is to use CSRF protection for any request that could be processed by a browser by normal users. 
	   //If you are only creating a service that is used by non-browser clients, you will likely want to disable CSRF protection.
		
	   //.antMatchers() is a Springboot HTTP method used to configure the URL paths from which the Springboot application security should permit requests based on the user's roles.
		
	   //.antmatchers() method is an overloaded method that receives both the HTTP request methods and the specific URLs as its arguments.
		
  	   //.permitAll()- It will configure the authorization so that all requests are allowed on that particular path. 
		
	   //anyRequest(). authenticated() is that any request must be authenticated otherwise my Spring app will return a 401 response.
		
	   //and() method is used to concatenate multiple configurer of Spring Security. 

		http.csrf().disable().authorizeRequests().antMatchers("/Owner/addOwner", "/Owner/auth").permitAll().anyRequest()
				.authenticated().and().formLogin();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();

	}

}