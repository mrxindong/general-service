

package com.dong.admin.api.feign;


import com.dong.admin.api.entity.SysUser;
import com.dong.admin.api.dto.UserDTO;
import com.dong.admin.api.dto.UserInfo;
import com.dong.admin.api.feign.factory.RemoteUserServiceFallbackFactory;
import com.znzd.charging.common.core.constant.SecurityConstants;
import com.znzd.charging.common.core.constant.ServiceNameConstants;
import com.znzd.charging.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhoupeilong
 * @date 2018/6/22
 */
@FeignClient(value = ServiceNameConstants.UMPS_SERVICE, fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {
	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @param username 用户名
	 * @param from     调用标志
	 * @return R
	 */
	@GetMapping("/user/info/{username}")
	R<UserInfo> info(@PathVariable("username") String username
			, @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 通过社交账号或手机号查询用户、角色信息
	 *
	 * @param inStr appid@code
	 * @param from  调用标志
	 * @return
	 */
	@GetMapping("/social/info/{inStr}")
	R<UserInfo> social(@PathVariable("inStr") String inStr
			, @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 查询上级部门的用户信息
	 *
	 * @param username 用户名
	 * @return R
	 */
	@GetMapping("/user/ancestor/{username}")
	R<List<SysUser>> ancestorUsers(@PathVariable("username") String username);

	/**
	 * 根据条件批量查询用户信息
	 * <p>
	 * //	 * @param page 分页对象
	 * //	 * @param userDTO 用户条件
	 *
	 * @return R
	 */
	@PostMapping("/user/getUsersInfo")
	R<List<SysUser>> getUsersInfo(UserDTO userDTO, @RequestHeader(SecurityConstants.FROM) String from);


	/**
	 * 保存用户并返回userId
	 * @param sysUser
	 * @return
	 */
	@PostMapping("/user/sysUser")
	 R<SysUser> saveSysUser(UserDTO sysUser);

	/**
	 * 更新用户信息
	 * @param sysUser
	 * @return
	 */
	@PutMapping("/user/sysUser")
	R<Boolean> updateSysUser(SysUser sysUser);


}

