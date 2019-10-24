package com.helpdesk.ticket.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	    static final String CLIENT_ID = "client";
	    static final String CLIENT_SECRET = "clientpassword";
	    static final String GRANT_TYPE = "password";
	    static final String AUTHORIZATON_CODE = "authorization_code";
	    static final String REFRESH_TOKEN = "refresh_token";
	    static final String IMPLICIT = "implicit";
	    static final String SCOPE_READ = "read";
	    static final String SCOPE_WRITE = "write";
	    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
	    static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;
	    
	    @Autowired
	    private TokenStore tokenStore;

	    @Autowired
	    private UserApprovalHandler userApprovalHandler;

	    @Autowired
	    private AuthenticationManager authenticationManager;
	    
	    @Override
	    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

	        configurer
	                .inMemory()
	                .withClient(CLIENT_ID)
	                .secret(CLIENT_SECRET)
	                .authorizedGrantTypes(GRANT_TYPE, AUTHORIZATON_CODE, REFRESH_TOKEN, IMPLICIT)
	                .scopes(SCOPE_READ, SCOPE_WRITE)
	                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
	                refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
	    }

	    
	    @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
	        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
	                .authenticationManager(authenticationManager);
	    }
	    
	    

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer.allowFormAuthenticationForClients();
		}

}
