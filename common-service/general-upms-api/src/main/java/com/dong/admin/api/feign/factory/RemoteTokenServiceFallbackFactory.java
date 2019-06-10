

package com.dong.admin.api.feign.factory;

import com.dong.admin.api.feign.fallback.RemoteTokenServiceFallbackImpl;
import com.dong.admin.api.feign.RemoteTokenService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhoupeilong
 * @date 2018/9/4
 */
@Component
public class RemoteTokenServiceFallbackFactory implements FallbackFactory<RemoteTokenService> {

	@Override
	public RemoteTokenService create(Throwable throwable) {
		RemoteTokenServiceFallbackImpl remoteTokenServiceFallback = new RemoteTokenServiceFallbackImpl();
		remoteTokenServiceFallback.setCause(throwable);
		return remoteTokenServiceFallback;
	}
}
