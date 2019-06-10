

package com.znzd.charging.auth;


import com.znzd.charging.common.security.annotation.EnableChargingFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author zhoupeilong
 * @date 2018年06月21日
 * 认证授权中心
 */
@SpringCloudApplication
@EnableChargingFeignClients
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
}
