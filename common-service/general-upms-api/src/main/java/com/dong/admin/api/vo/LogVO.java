

package com.dong.admin.api.vo;

import com.dong.admin.api.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhoupeilong
 * @date 2017/11/20
 */
@Data
public class LogVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private SysLog sysLog;
	private String username;
}
