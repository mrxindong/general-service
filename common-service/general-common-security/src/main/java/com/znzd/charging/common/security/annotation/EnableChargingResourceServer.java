

package com.znzd.charging.common.security.annotation;

import com.znzd.charging.common.security.component.ChargingResourceServerAutoConfiguration;
import com.znzd.charging.common.security.component.ChargingSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author zhoupeilong
 * @date 2018/11/10
 * <p>
 * 资源服务注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ChargingResourceServerAutoConfiguration.class, ChargingSecurityBeanDefinitionRegistrar.class})
public @interface EnableChargingResourceServer {

	/**
	 * false：上下文获取用户名
	 * true： 上下文获取全部用户信息
	 *
	 * @return
	 */
	boolean details() default false;
}
