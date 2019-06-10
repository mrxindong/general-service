

package com.znzd.charging.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.znzd.charging.common.security.component.ChargingAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author zhoupeilong
 * @date 2018/7/8
 */
@JsonSerialize(using = ChargingAuth2ExceptionSerializer.class)
public class ForbiddenException extends ChargingAuth2Exception {

	public ForbiddenException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "access_denied";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.FORBIDDEN.value();
	}

}

