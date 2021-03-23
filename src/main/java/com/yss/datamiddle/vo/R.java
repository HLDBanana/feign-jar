package com.yss.datamiddle.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 响应信息主体
 *
 * @param <T>
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@ApiModelProperty("响应状态码 200 ：为成功 ;500 ：为失败")
	private int code;

	@Getter
	@Setter
	@ApiModelProperty("响应消息")
	private String msg;


	@Getter
	@Setter
	@ApiModelProperty("响应对象")
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, 200, "success");
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, 200, "success");
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, 200, msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, 500, "fail");
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, 500, msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, 500, null);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, 500, msg);
	}

	private static <T> R<T> restResult(T data, int code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}
}

