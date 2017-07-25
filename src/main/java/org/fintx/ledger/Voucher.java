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
package org.fintx.ledger;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Accounting voucher
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Getter
@Setter
@Builder
public class Voucher {
/*
 * 是否已结算
 */
    private Boolean settlement;
    /*
     * 凭证ID
     */
    private String voucherId;
    /*
     * 凭证日期
     */
    private String voucherDate;
    /*
     * 币种
     */
    private String currency;
    /*
     * 汇率
     */
    private String exchangeRate;
    /*
     * 原币种
     */
    private String naturalCurrency;
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
    private String orderDate;
    /*
     * 辅助核算项目
     */
    private String auxiliaryItem;
    /*
     * 款项 现金、银行存款以及其他视同现金和银行存款的银行汇票存款、银行本票存款、信用卡存款、信用证保证金存款、外埠存款和存出投资款等 三方备付金。
     */
    private String cashType;
    /*
     * 凭证种类: 1 receiving 收款凭证(现金银行) 2 payment 付款凭证(现金银行) 3 transfer 转账凭证(非现金银行)
     */
    private String voucherType;
    /*
     * 凭证号码
     */
    private String voucherNo;
    /*
     * 操作机构号
     */
    private String operatorOrgNo;
    /*
     * 操作员号
     */
    private String operatorNo;
    /*
     * 摘要
     */
    private String summary;
    /*
     * 说明
     */
    private String comment;
    /*
     * 备注
     */
    private String remark;
    /*
     * 产品号
     */
    private String productNo;
    /*
     * 扩展字段1
     */
    private String extend1;
    /*
     * 扩展字段2
     */
    private String extend2;
   
    /*
     * 业务码
     */
    private String bizCode;
//    /*
//     * 渠道号
//     */
//    private String channelId;
    
    //private String paymenttype;
    /*
     * business Id
     */
    private String bizId;
    /*
     * business date业务日期
     */
    private String bizDate;
    /*
     * 修改标识
     */
    private String changeflag;
    /*
     * 入账标识
     */
//    private String effective;
    /*
     * transaction date 交易日期
     */
    private String txnDate;
    /*
     * 借方金额
     */
    private BigDecimal drAmount;
    /*
     * 收方金额
     */
    private BigDecimal rrAmount;
    /*
     * 收方金额
     */
    private BigDecimal prAmount;
}
