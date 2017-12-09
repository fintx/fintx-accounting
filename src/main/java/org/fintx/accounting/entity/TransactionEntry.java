/**
 *  Copyright 2017 FinTx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fintx.accounting.entity;

import org.fintx.accounting.enumeration.TransactionFlag;
import org.fintx.accounting.enumeration.TransactionSymbol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Getter
@Setter
@Builder
public class TransactionEntry {

    private String accountsCodeNo;

    private String coAccountsCodeNo;

    private String customerNo;

    private String coCustomerNo;
    /*
     * 原账户机构??是否需要 账户中有原账户机构--需要，是凭证必备属性，记账应校验
     */
    private String organizationNo;

    private String productNo;

    private String accountNo;

    private String coAccountNo;

    private String transactionId;
    /*
     * 操作账户机构
     */
    private String operatorOrgNo;

    private String operatorNo;

    private LocalDate transactionDate;

    private String transactionCode;

    private BigDecimal amount;

    private BigDecimal balance;

    private BigDecimal balanceAccum;
    /*
     * record cancel flash 记账/抹账/冲账
     */
    private TransactionFlag flag;

    /*
     * dr:debit record/cr:credit record/rr:receipt record/pr:payment record 借/贷/收/付
     */
    private TransactionSymbol symbol;
    /*
     * is this accounting entry effective to account
     */
    private boolean effective;

    private String voucherType;

    private String voucherId;
    /*
     * 凭证号码
     */
    private String voucherNo;
    /*
     * 凭证日期
     */
    private LocalDate voucherDate;
    
    private ZoneOffset zoneOffset;

    /*
     * 款项 现金、银行存款以及其他视同现金和银行存款的银行汇票存款、银行本票存款、信用卡存款、信用证保证金存款、外埠存款和存出投资款等 三方备付金。
     */
    private String cashType;
    private String originBizId;
    private LocalDate originBizDate;

    private String businessCode;
    private String businessId;

    // it is transaction date
    // private String businessDate;

    /*
     * 
     */
    private String changeflag;

    /*
     * 是否已结算
     */
    private Boolean settlement;

    /*
     * 币种
     */
    private String currency;

    /*
     * 原币种
     */
    private String naturalCurrency;
    /*
     * 汇率
     */
    private String exchangeRate;
    /*
     * 订单类型
     */
    private String orderType;
    /*
     * 订单Id
     */
    private String orderId;
    /*
     * 订单日期
     */
    private LocalDate orderDate;
    /*
     * 辅助核算项目
     */
    private String auxiliaryItem;

    private String summary;

    /*
     * 备注
     */
    private String remark;
    /*
     * 说明 用于程序使用
     */
    private String comment;
    /*
     * extend column
     */
    private String extend1;
    /*
     * extend column
     */
    private String extend2;

    /*
     * DAC: Data Anti Change
     */
    private String checksum;
}
