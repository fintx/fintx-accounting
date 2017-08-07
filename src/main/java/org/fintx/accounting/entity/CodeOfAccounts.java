package org.fintx.accounting.entity;

import org.fintx.accounting.enumeration.AccountSide;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeOfAccounts {
    /**
     * 科目代号
     */
    private String accountsCodeNo;

    /**
     * 系统科目号--用于内部科目修改
     */
    private String accountsCode;

    /**
     * 科目借贷方向
     */
    private AccountSide accountsSide;

    /**
     * 管理科目号
     */
    private String manageAcctsCode;

    /**
     * 账类 01-对私活期 02-对公活期 03-对私定期 04-对公定期 05-拨款、贷款 06-损益 07-现金 08-其他内部帐 09-其他 99-表外
     */
    private String accountType;

    /**
     * 父科目代号
     */
    private String parentAccountsCodeNo;

    /**
     * 科目级别
     */
    private String AccountsLevel;

    /**
     * 科目号控制
     */
    private String accountsControl;

    /**
     * 是否是叶子科目
     */
    private boolean leafAccounts;

}