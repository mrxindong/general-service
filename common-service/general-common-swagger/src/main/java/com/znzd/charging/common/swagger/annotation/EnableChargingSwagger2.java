

package com.znzd.charging.common.swagger.annotation;

import com.znzd.charging.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhoupeilong
 * @date 2018/7/21
 * 开启charging swagger
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableChargingSwagger2 {
}
