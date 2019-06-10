

package com.znzd.charging.gateway;


import com.znzd.charging.common.gateway.annotation.EnableChargingDynamicRoute;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author zhoupeilong
 * @date 2018年06月21日
 * 网关应用
 */
@EnableChargingDynamicRoute
@SpringCloudApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
