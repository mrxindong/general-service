

package com.znzd.charging.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.znzd.charging.common.security.component.ChargingAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author zhoupeilong
 * @date 2018/7/8
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = ChargingAuth2ExceptionSerializer.class)
public class ChargingAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public ChargingAuth2Exception(String msg) {
		super(msg);
	}

	public ChargingAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
