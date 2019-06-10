

package com.dong.admin.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoupeilong
 * @date 2017年11月9日23:33:45
 */
@Data
public class TreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Integer id;
	protected Integer parentId;
	protected List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
	}
}
