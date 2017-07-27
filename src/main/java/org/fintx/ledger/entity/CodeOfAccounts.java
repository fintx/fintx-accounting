package org.fintx.ledger.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeOfAccounts {
	/**
	 * 科目代号
	 */
	private String accountsNo;

	/**
	 * 系统科目号--用于内部科目修改
	 */
	private String accountsCode;

	/**
	 * 科目借贷方向
	 */
	private String accountsSide;

	/**
	 * 管理科目号
	 */
	private String manageAcctsCode;

	/**
	 * 账号类型
	 */
	private String acctsType;

	/**
	 * 父科目代号
	 */
	private String parentaccountNo;

	

	/**
	 * 科目级别
	 */
	private String accountsLevel;



	/**
	 * 科目号控制
	 */
	private String accttitlectrl;

	/**
	 * 是否是叶子科目
	 */
	private boolean leafAccounts;

}