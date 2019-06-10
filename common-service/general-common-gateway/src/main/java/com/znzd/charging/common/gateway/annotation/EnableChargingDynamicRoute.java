

package com.znzd.charging.common.gateway.annotation;

import com.znzd.charging.common.gateway.configuration.DynamicRouteAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhoupeilong
 * @date 2018/11/5
 * <p>
 * 开启charging 动态路由
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DynamicRouteAutoConfiguration.class)
public @interface EnableChargingDynamicRoute {
}
