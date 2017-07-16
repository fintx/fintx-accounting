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
 * Accounting voucher
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
public class Voucher {

    private Boolean settlement;
    private String voucherId;
    private String voucherDate;
    private String currency;
    private String exchangeRate;
    private String naturalCurrency;
    private String billType;
    private String billId;
    private String billDate;
    /*
     * 辅助核算项目
     */
    private String auxiliaryItem;
    private Boolean cash; //现金标识
    /*
     * 1 receiving 收款凭证（现金银行） 2 payment 付款凭证（现金银行） 3 transfer 转账凭证（非现金银行）
     */
    private String voucherType; // ƾ֤����
    private String voucherNo; // ƾ֤����
    private String operOrgNo; // ����������
    private String operatorNo; // �����˺�
    private String summary; // ժҪ
    private String comment; // ��ע    
    private String productNo;// ��Ʒ��
    private String extend1; // �����ֶ�1
    private String extend2; // �����ֶ�2
    private String extend3; // �����ֶ�3
    private String bizCode; // ҵ����
    private String channelId;// ֧������
    private String paymenttype;// ֧����ʽ
    private String bizId; // ҵ��Id
    private String bizDate; // ҵ������
    private String changeflag; // �����ʶ 0 δ���  1����  2����
    private String countflag; // ���˱�ʶ
    private String txnDate; // ��������
    private String drAmount;
    private String crAmount;
}
