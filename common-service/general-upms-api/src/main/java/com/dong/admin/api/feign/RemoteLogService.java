

package com.dong.admin.api.feign;

import com.dong.admin.api.entity.SysLog;
import com.dong.admin.api.feign.factory.RemoteLogServiceFallbackFactory;
import com.znzd.charging.common.core.constant.SecurityConstants;
import com.znzd.charging.common.core.constant.ServiceNameConstants;
import com.znzd.charging.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author zhoupeilong
 * @date 2018/6/28
 */
@FeignClient(value = ServiceNameConstants.UMPS_SERVICE, fallbackFactory = RemoteLogServiceFallbackFactory.class)
public interface RemoteLogService {
	/**
	 * 保存日志
	 *
	 * @param sysLog 日志实体
	 * @param from   是否内部调用
	 * @return succes、false
	 */
	@PostMapping("/log/save")
	R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);
}
