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

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
//TODO 对于账户的各种限制是否应该放在交易系统里面限制？？---不应在交易系统限制，应暴露出参数或方法开放给调用方
@Getter
@Setter
public class Account {
    // 分户账是明细核算的主要账簿，是总账各科目的详细记录，也是与单位对账的依据。
    //
    // 分户账中分别设置甲、乙、丙、丁四种账簿格式。
    // 甲种账
    // 设有借方、贷方发生额和余额三栏，适用于不计息或使用余额表计息的账户，以及商业银行内部财务核算的账户。
    // 乙种账
    // 设有借方、贷方、余额、积数四栏，适用于在账面上加计积数，并计算利息的账户。
    // 丙种账
    // 设有借方、贷方发生额和借方、贷方余额四栏，适用于借、贷双方反映余额的存贷往来账户。
    // 丁种账
    // 设有借方、贷方发生额、余额和销账四栏，适用于逐笔销账的一次性业务，并兼有分户核算作用的账户。
    private String accountCodeNo;

    private String organizationNo;
    
    /**
     * ?? 业务条线
     */
    //private String line;

    private String customerNo;

    //private String accountSn;

    private String accountNo;

    private String productNo;
    
    private String currency;
    /**
     * 1 debtor 2 creditor
     */
    private String accountSide;
    // 账类
    /**
     * 01-对私活期 02-对公活期 03-对私定期 04-对公定期 05-拨款、贷款 06-损益 07-现金 08-其他内部帐 09-其他 99-表外
     */
    private String accountingType;
    /**
     * 1 normal 2closed 3locked
     */
    private String accountStatus;

    


    private BigDecimal frozenAmt;
    /*
     * do not use double value
     */
    // private BigDecimal lastfrozenamt;
    /*
     * control amount
     */
    private BigDecimal ctrlAmt;
    /*
     * last control amount
     */
    // private BigDecimal lastCtrlAmt;
    /*
     * account control characters
     */
    private String accountCtrl;

    private BigDecimal balance;

    private BigDecimal lastBalance;

    /*
     * accumulation 积数
     **/
    private BigDecimal balanceAccum;
    /*
     * last balance accumulation 上期余额
     **/
    private BigDecimal lastBalanceAccum;

    private BigDecimal drBalance;

    private BigDecimal lastDrBalance;

    private BigDecimal crBalance;

    private BigDecimal lastCrBalance;

    private BigDecimal drTransAmt;

    private BigDecimal lastDrTransAmt;

    private BigDecimal crTransAmt;

    private BigDecimal lastCrTransAmt;

    //Calculate the interest is a business!
    //private BigDecimal rate;

    //private LocalDate interestSettleDate;
/**
 * 甲 乙 丙  丁
 */
    private String accountType;
    private LocalDate latestTransDate;
    
    /**
     * 记录最后一次持久化的 交易ID 未来可用于把account做为内存对象，定期持久化
     */
    
    private String latestTransId;
    /*
     * move to accountctrl // 销账类型 // 1-一次销账 2-多次销账 private String writeOffType;
     */
    // write off is a business
    //private String writeOff;

    private LocalDate openDate;

    private LocalDate closeDate;
    
    private int ZoneOffset;
    
    /**
     * 当前transId
     */
    private String transId;

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
    
    /**
     * 用于系统版本升级兼容
     */
    private short  version;
    
    /**
     * 用于系统版本升级兼容
     */
    private long  transaction_version;
    
    
}
