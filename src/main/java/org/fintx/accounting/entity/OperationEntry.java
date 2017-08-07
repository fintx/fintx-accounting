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

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Getter
@Setter
@Builder
public class OperationEntry {
    private String accountsCode;

    private String customerNo;
    private String organizationNo;
    private String productNo;
    
    private String accountNo;

    private String operationId;

    private String operatorOrgNo;

    private String operatorNo;

    private String operationDate;

    private String transactionCode;

   

    /*
     * dr:debit record/cr:credit record/rr:receipt record/pr:payment record/or:operation record 借/贷/收/付/操作
     */
    private short symbol;
  
    private String originbusinessId;
    private String originbusinessDate;
    
    private BigDecimal amount;

    private String summary;
    
    /*
     * extend column
     */
    private String extend1;
    /*
     * extend column
     */
    private String extend2;
    
    private String businessCode;
    private String businessId; 
    private String businessDate; 
    private String changeflag;
    /*
     * DAC: Data Anti Change
     */
    private String checksum;
}
