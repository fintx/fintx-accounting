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

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
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
    private String acctsCode;

    private String orgNo;

    private String custNo;

    private String acctSn;

    private String acctNo;

    private String productNo;

    private String symbol;
    /*
     * 1 normal 2closed
     */
    private String acctStatus;

    private BigDecimal overdraftLimit;

    private BigDecimal frozenAmt;

    private BigDecimal lastfrozenamt;
/*
 * control amount
 */
    private BigDecimal ctrlAmt;
/*
 * last control amount
 */
 //   private BigDecimal lastCtrlAmt;
/*
 * account control characters
 */
    private String acctCtrl;

    private BigDecimal balance;

    private BigDecimal lastBalance;

    private BigDecimal drBalance;

    private BigDecimal lastDrBalance;

    private BigDecimal drTxnAmt;

    private BigDecimal lastDrTxnAmt;

    private BigDecimal crTxnAmt;

    private BigDecimal lastCrTxnAmt;

    private String txnDate;

    private String acctType;

    private String openDate;

    private String closeDate;
    /*
     * DAC
     */
    private String checksum;

    /*
     * extend column
     */
    private String extend1;
    /*
     * extend column
     */
}
