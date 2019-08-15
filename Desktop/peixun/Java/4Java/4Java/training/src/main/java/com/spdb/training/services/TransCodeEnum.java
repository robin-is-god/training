package com.spdb.training.services;
/**
 * 交易码枚举
 * @author wanglw2
 *
 */
public enum TransCodeEnum {
	OR01("OR01","商品库存查询"),
	OR02("OR02","商品购买");
	/**
	 * 交易代码
	 */
	private String transCode;
	/**
	 * 交易名称
	 */
	private String transName;
	TransCodeEnum(String transCode,String transName){
		this.transCode = transCode;
		this.transName = transName;
	}
	public String getTransName() {
		return transName;
	}
	public void setTransName(String transName) {
		this.transName = transName;
	}
	public String getTransCode() {
		return transCode;
	}
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
}
