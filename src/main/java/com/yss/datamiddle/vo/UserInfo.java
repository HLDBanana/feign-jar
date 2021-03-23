
package com.yss.datamiddle.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author flj
 * <p>
 * commit('SET_ROLES', data)
 * commit('SET_NAME', data)
 * commit('SET_AVATAR', data)
 * commit('SET_INTRODUCTION', data)
 * commit('SET_PERMISSIONS', data)
 */
@Data
public class UserInfo implements Serializable {
	/**
	 * 用户基本信息
	 */
	@ApiModelProperty(value = "用户基本信息", example = "11111" , required = false)
	private SysUser sysUser;
	/**
	 * 权限标识集合
	 */
	@ApiModelProperty(value = "权限标识集合", example = "11111" , required = false)
	private String[] permissions;
	/**
	 * 角色集合
	 */
	@ApiModelProperty(value = "角色集合", example = "11111" , required = false)
	private Integer[] roles;
}
