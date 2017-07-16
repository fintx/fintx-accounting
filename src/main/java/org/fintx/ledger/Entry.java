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
public class Entry {
    private String accttitlecode;

    private String correspaccttitlecode;

    private String custno;

    private String custtype;

    private String correspcustno;

    private String acctsn;

    private String correspacctsn;

    private String acctno;

    private String orgcode;

    private String productno;

    private String correspacctno;

    private String txnsn;

    private String proxorgcode;

    private String proxoperno;


    private String channeldate;

    private String txndate;
//��ctime mtime
//    private String sysdate;
//
//    private Long systime;
//��ֹ����� �ʽ���Դȥ����  ����һ����  ���һ��  ��ʱ���Լ�齻���� 
    private String txncode;


    private BigDecimal txnamt;

    private BigDecimal balance;

    private BigDecimal balaccum;

    private String drorcr;

    private String counted;

    private String cashortxfr;

    private String vouchertype;

    private String voucherno;

    private String bizsn;

    private String bizcode;

    private String channelcode;

    private String channelbizsn;

    private String paymentchannel;

    private String paymenttype;

    private String summary;

    private String checksum;

    private String extend1; // �����ֶ�1
    private String extend2; // �����ֶ�1
    private String extend3; // �����ֶ�1
    
    private String bizId; // ҵ��Id  
    private String bizDate; // ҵ������
    private String changeflag; // �����ʶ 0 δ���  1����  2����
    private String countflag; // ���˱�ʶ
}
