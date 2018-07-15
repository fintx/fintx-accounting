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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Accounting voucher
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Getter
@Setter
@Builder(builderClassName = "Builder")
public class Voucher {

    /**
     * 凭证ID
     */
    private String voucherId;
    /**
     * 凭证号码
     */
    private String voucherNo;

    /**
     * 凭证Offset
     */
    private ZoneOffset zoneOffset;
    /**
     * 凭证日期
     */
    private LocalDate voucherDate;
    /**
     * 币种
     */
    private String currency;
    /**
     * 汇率
     */
    private String exchangeRate;
    /**
     * 原币种
     */
    private String naturalCurrency;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 订单日期
     */
    private LocalDate orderDate;

    /**
     * 辅助核算项目
     */
    private String auxiliaryItem;
    /**
     * 款项 现金、银行存款以及其他视同现金和银行存款的银行汇票存款、银行本票存款、信用卡存款、信用证保证金存款、外埠存款和存出投资款等 三方备付金。
     */
    private String cashType;
    /**
     * 凭证种类: 1 receiving 收款凭证(现金银行) 2 payment 付款凭证(现金银行) 3 transfer 转账凭证(非现金银行)
     */
    private String voucherType;

    /**
     * （经办）操作机构号
     */
    private String operatorOrgNo;
    /**
     * （经办）操作员号
     */
    private String operatorNo;

    /**
     * 复核操作员号
     */
    private String checkOperatorOrgNo;
    /**
     * 复核操作员号
     */
    private String checkOperatorNo;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 说明
     */
    private String comment;
    /**
     * 备注
     */
    private String remark;
    /**
     * 产品号
     */
    private String productNo;
    /**
     * 扩展字段1
     */
    private String extend1;
    /**
     * 扩展字段2
     */
    private String extend2;

    /**
     * 是否已结算
     */
    private Boolean settlement;

    /**
     * 业务码
     */
    private String businessCode;
    // /**
    // * 渠道号
    // */
    // private String channelId;

    // private String paymenttype;

    /**
     * original business Id 原业务ID
     */
    private String originBizId;
    /**
     * business date业务日期
     */
    private LocalDate originBizDate;
    /**
     * business Id
     */
    private String businessId;
    /**
     * business date业务日期
     */
    private LocalDate businessDate;
    /**
     * 1 post 记账 1 flash 冲正 2 cancel 撤销
     */
    private String voucherflag;

    /**
     * 1 flash 冲正 2 cancel 撤销
     */
    private String originVoucherId;

    /**
     * 入账标识
     */
    // private String effective;
    /**
     * transaction date 交易日期就是businessDate X--transaction date 应该在创建transaction 时确定
     */
    // private LocalDate transactionDate;

    /**
     * 借方金额
     */
    private BigDecimal debitRecordAmt;
    /**
     * 贷方金额
     */
    private BigDecimal creditRecordAmt;
    /**
     * 收方金额
     */
    private BigDecimal receiptRecordAmt;
    /**
     * 付方金额
     */
    private BigDecimal payRecordAmt;

}
