

package com.znzd.charging.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author zhoupeilong
 * @date 2018年06月22日16:22:03
 * 403 授权拒绝
 */
@NoArgsConstructor
public class ChargingDeniedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ChargingDeniedException(String message) {
		super(message);
	}

	public ChargingDeniedException(Throwable cause) {
		super(cause);
	}

	public ChargingDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChargingDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
