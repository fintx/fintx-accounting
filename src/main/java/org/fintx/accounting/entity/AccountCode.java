package org.fintx.accounting.entity;

import org.fintx.accounting.constant.AccountOwnerFlag;
import org.fintx.accounting.constant.AccountsSide;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCode {
    /**
     * 科目代号
     */
    private String accountCodeNo;

    /**
     * 系统科目编码--用于内部科目修改
     */
    private String accountCode;

    /**
     * 科目借贷方向
     */
    private AccountsSide accountSide;

    /**
     * 管理科目编码
     */
    private String manageAccountCode;

    /**
     * 账类 01-对私活期 02-对公活期 03-对私定期 04-对公定期 05-拨款、贷款 06-损益 07-现金 08-其他内部帐 09-其他 99-表外
     */
    private String accountType;

    /**
     * 父科目号
     */
    private String parentAccountCodeNo;

    /**
     * 科目级别
     */
    private String AccountCodeLevel;

    /**
     * 科目控制
     */
    private String accountControl;
    
    
    
    private AccountOwnerFlag accountOwnerFlag;

    /**
     * 是否是叶子科目
     */
    private boolean leafAccountCode;

}