package com.yss.datamiddle.vo;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author flj
 */
@Data
public class ReturnUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Integer userId;
	/**
	 * 用户名
	 */
	private String username;


	public static ReturnUsers po2vo(SysUser user){
		ReturnUsers vo = new ReturnUsers();
		BeanUtils.copyProperties(user,vo);
		return vo;
	}
}
