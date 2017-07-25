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
    private String acctsCode;

    private String coAcctsCode;

    private String custNo;
/*
    private String custType;
*/
    private String coCustNo;
/*
    private String acctSn;

    private String coAcctSn;
*/
   
    private String orgNo;

    private String productNo;
    
    private String acctNo;

    private String coAcctNo;

    private String txnId;

    private String operOrgNo;

    private String operNo;

  

    private String txnDate;

    private String txnCode;

    private BigDecimal txnAmt;

    private BigDecimal balance;

    private BigDecimal balAccum;

    /*
     * dr:debit record/cr:credit record/rr:receipt record/pr:payment record/or:operation record 借/贷/收/付
     */
    private short symbol;
    /*
     * is this accounting entry effective to account
     */
    private boolean effective;

    private String cashortxfr;

    private String voucherType;

    private String voucherId;

    private String channelCode;

    private String sourceBizId;
    private String sourceBizDate;

    private String summary;
    
    /*
     * extend column
     */
    private String extend1;
    /*
     * extend column
     */
    private String extend2;
    
    private String bizCode;
    private String bizId; 
    private String bizDate; 
    private String changeflag;
    /*
     * DAC: Data Anti Change
     */
    private String checksum;
}
