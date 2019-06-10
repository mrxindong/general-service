

package com.znzd.charging.auth.config;

import com.znzd.charging.common.core.constant.SecurityConstants;
import com.znzd.charging.common.security.component.ChargingWebResponseExceptionTranslator;
import com.znzd.charging.common.security.service.ChargingClientDetailsService;
import com.znzd.charging.common.security.service.ChargingUser;
import com.znzd.charging.common.security.service.ChargingUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoupeilong
 * @date 2018/6/22
 * 认证服务器配置
 */
@Configuration
@AllArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	private final DataSource dataSource;
	private final ChargingUserDetailsService chargingUserDetailsService;
	private final AuthenticationManager authenticationManager;
	private final RedisConnectionFactory redisConnectionFactory;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		ChargingClientDetailsService clientDetailsService = new ChargingClientDetailsService(dataSource);
		clientDetailsService.setSelectClientDetailsSql(SecurityConstants.DEFAULT_SELECT_STATEMENT);
		clientDetailsService.setFindClientDetailsSql(SecurityConstants.DEFAULT_FIND_STATEMENT);
		clients.withClientDetails(clientDetailsService);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		oauthServer
				.allowFormAuthenticationForClients()
				.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints
				.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
				.tokenStore(tokenStore())
				.tokenEnhancer(tokenEnhancer())
				.userDetailsService(chargingUserDetailsService)
				.authenticationManager(authenticationManager)
				.reuseRefreshTokens(false)
				.exceptionTranslator(new ChargingWebResponseExceptionTranslator());
	}


	@Bean
	public TokenStore tokenStore() {
		RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
		tokenStore.setPrefix(SecurityConstants.PROJECT_PREFIX + SecurityConstants.OAUTH_PREFIX);
		return tokenStore;
	}

	@Bean
	public TokenEnhancer tokenEnhancer() {
		return (accessToken, authentication) -> {
			if("client_credentials".equals(authentication.getOAuth2Request().getGrantType())){
				return accessToken;
			}

			final Map<String, Object> additionalInfo = new HashMap<>(8);
			ChargingUser chargingUser = (ChargingUser) authentication.getUserAuthentication().getPrincipal();
			additionalInfo.put("user_id", chargingUser.getId());
			additionalInfo.put("username", chargingUser.getUsername());
			additionalInfo.put("dept_id", chargingUser.getDeptId());
			additionalInfo.put("tenant_id", chargingUser.getTenantId());
			additionalInfo.put("license", SecurityConstants.CHARGING_LICENSE);
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
			return accessToken;
		};
	}
}
