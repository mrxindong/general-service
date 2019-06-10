

package com.dong.admin.api.feign.fallback;

import com.dong.admin.api.dto.UserDTO;
import com.dong.admin.api.entity.SysUser;
import com.dong.admin.api.feign.RemoteUserService;
import com.dong.admin.api.dto.UserInfo;
import com.znzd.charging.common.core.util.R;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhoupeilong
 * @date 2018/6/26
 */
@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {
	@Setter
	private Throwable cause;

	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @param username 用户名
	 * @param from     内外标志
	 * @return R
	 */
	@Override
	public R<UserInfo> info(String username, String from) {
		log.error("feign 查询用户信息失败:{}", username, cause);
		return null;
	}

	/**
	 * 通过社交账号查询用户、角色信息
	 *
	 * @param inStr appid@code
	 * @param from  内外标志
	 * @return
	 */
	@Override
	public R<UserInfo> social(String inStr, String from) {
		log.error("feign 查询用户信息失败:{}", inStr, cause);
		return null;
	}

	/**
	 * 查询上级部门的用户信息
	 *
	 * @param username 用户名
	 * @return R
	 */
	@Override
	public R<List<SysUser>> ancestorUsers(String username) {
		log.error("feign 查询用户上级部门用户列失败:{}", username, cause);
		return null;
	}

	/**
	 * 根据条件批量查询用户信息
	 *
//	 * @param page 分页对象
//	 * @param userDTO 用户条件
	 * @return R
	 */
	@Override
	public R<List<SysUser>> getUsersInfo(UserDTO userDTO, String from){
		log.error("feign 根据条件批量查询用户信息失败:userDTO={}",userDTO.toString(), cause);
		return null;
	}
	/**
	 * 保存用户并返回userId
	 * @return
	 */
	@Override
	public R<SysUser> saveSysUser(UserDTO userDTO) {
		log.error("feign 添加用户信息失败:userDTO={}",userDTO.toString(), cause);
		return null;
	}
	/**
	 * 更新用户信息
	 * @param sysUser
	 * @return
	 */
	@Override
	public R<Boolean> updateSysUser(SysUser sysUser) {
		log.error("feign 更新用户信息失败:userDTO={}",sysUser.toString(), cause);
		return null;
	}
}
