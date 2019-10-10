package com.ztest.framework.core.base;

/**
 * 通用返回码枚举<br/>
 *
 * @author xiepeng
 * @version 1.0
 * @date 2018年1月8日 上午11:18:39
 */
public enum ResponseCode {

	//成功
	SUCCESS("200", "success", "success"),

	//系统级异常
	SYS_EXCEPTION("100", "网络开小差了，请稍候再试！", "系统异常"),
	TOKEN_INVALID("101", "TOKEN无效", "TOKEN无效"),
	SORT_TOKEN_INVALID("102", "短TOKEN过期", "短TOKEN过期"),
	LONG_TOKEN_INVALID("103", "长TOKEN过期", "长TOKEN过期"),
	USER_FROZEN("104", "用户被冻结", "用户被冻结"),

	//业务级异常
	BUSINESS_EXCEPTION("1000", "网络开小差了，请稍后再试", "业务逻辑异常"),
	VALIDATE_EXCEPTION("2000", "网络开小差了，请稍候再试！", "数据验证失败！"),

	//分布式锁异常
	LOCK_EXCEPTION("3000", "网络开小差了，请稍候再试！", "分布式锁异常");


	private String code;
	private String errorMsg;
	private String showMsg;

	/**
	 * @throws
	 */
	ResponseCode(String code, String errorMsg, String showMsg) {
		this.code = code;
		this.showMsg = showMsg;
		this.errorMsg = errorMsg;
	}

	/**
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}

	/**
	 * @return the showmsg
	 */
	public String getShowMsg() {
		return this.showMsg;
	}
}
