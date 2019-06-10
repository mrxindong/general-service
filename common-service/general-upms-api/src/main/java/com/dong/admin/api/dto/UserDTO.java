

package com.dong.admin.api.dto;

import com.dong.admin.api.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

/**
 * @author zhoupeilong
 * @date 2017/11/5
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends SysUser {
	/**
	 * 角色ID
	 */
	private List<Integer> role;

	private Integer deptId;

	/**
	 * 用户Id集合
	 */
	private Set<Integer> userIdSet;

	/**
	 * 新密码
	 */
	private String newpassword1;
}
