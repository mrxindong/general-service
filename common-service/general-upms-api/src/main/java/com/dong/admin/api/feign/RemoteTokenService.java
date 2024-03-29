

package com.dong.admin.api.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.admin.api.feign.factory.RemoteTokenServiceFallbackFactory;
import com.znzd.charging.common.core.constant.SecurityConstants;
import com.znzd.charging.common.core.constant.ServiceNameConstants;
import com.znzd.charging.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhoupeilong
 * @date 2018/9/4
 */
@FeignClient(value = ServiceNameConstants.AUTH_SERVICE, fallbackFactory = RemoteTokenServiceFallbackFactory.class)
public interface RemoteTokenService {
	/**
	 * 分页查询token 信息
	 *
	 * @param params 分页参数
	 * @return page
	 */
	@PostMapping("/token/page")
	R<Page> getTokenPage(@RequestBody Map<String, Object> params,@RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 删除token
	 *
	 * @param token token
	 * @return
	 */
	@DeleteMapping("/token/{token}")
	R<Boolean> removeTokenById(@PathVariable("token") String token,@RequestHeader(SecurityConstants.FROM) String from);
}
