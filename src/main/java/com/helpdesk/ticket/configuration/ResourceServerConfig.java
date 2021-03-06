package com.helpdesk.ticket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	 private static final String RESOURCE_ID = "resource_id";
	 
	
	  @Override public void configure(ResourceServerSecurityConfigurer resources) {
		  resources.resourceId(RESOURCE_ID).stateless(false); 
	  }
	 

     @Override
     public void configure(HttpSecurity http) throws Exception {
     	http
     	.authorizeRequests()
     	.anyRequest().authenticated().and()
     	.sessionManagement()
     	.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
     	.csrf().disable();
     	http.httpBasic().disable();
     }
}
