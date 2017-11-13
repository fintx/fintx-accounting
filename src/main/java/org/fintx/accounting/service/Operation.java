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
package org.fintx.accounting.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.fintx.accounting.entity.OperationEntry;
import org.fintx.accounting.enumeration.OperationFlag;
import org.fintx.util.UniqueId;

import lombok.Getter;

/**
 * This class is not thread safe
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 */
@Getter
public class Operation {
    private Operation() {

    }
    private String authorizerNo;
    private String operatorNo;
    private String operationId=UniqueId.get().toString();
    private LocalDate operationDate;
    /*
     * 1 post 记账 1 flash 冲正 2 cancel 撤销
     */
    private OperationFlag operationflag;

    private ArrayList<OperationEntry> closeAcctEntrys;
    private ArrayList<OperationEntry> freezeEntrys;
    private ArrayList<OperationEntry> unfreezeEntrys;
    private ArrayList<OperationEntry> controlEntrys;

    // control and buff should be a configuration not a function
    // private ArrayList controlCreditEntrys;
    // private ArrayList controlDebitEntrys;
    // private ArrayList buffCreditEntrys;
    // private ArrayList buffDebitEntrys;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Operation operation = new Operation();
        private Verifer<Operation> verifer = null;
        private static final Verifer<Operation> defaultVerifer = new OperationVerifer();

        private Builder() {
        }
        
        public Builder authorizerNo(String authorizerNo) {

            return this;
        }

        public Builder operateNo(String operatorNo) {

            return this;
        }

        public Builder operationDate(String operatorNo) {

            return this;
        }

        public Builder freeze(String acctNo, BigDecimal amt) {
            return this;
        }

        public Builder unfreeze(String acctNo, BigDecimal amt) {
            return this;
        }

        public Builder control(String acctNo, String accountCtrl) {
            return this;
        }

        public Builder closeAccount(String acctNo) {
            return this;
        }
        
        /*
         * if operationDate is different with voucher's businessDate
         */
         public Builder operationId(String operationId) {
         return this;
         }
        
        /*
         * if operationFlag is not post
         */
        public Builder operationFlag(OperationFlag operationFlag) {
            return this;
        }

        public Builder operationVerifer(OperationVerifer verifer) {
            this.verifer = verifer;
            return this;
        }

        public Operation build() {
            if (null == verifer) {
                verifer = defaultVerifer;
            }
            if(verifer.verify(operation)) {
                return operation; 
            }else {
                //TODO add special Exception
                throw new RuntimeException("Fail to verify the transaction info");
            }
        };

        public static class OperationVerifer implements Verifer<Operation> {

            public boolean verify(Operation txn) {
                // acctno type length?? on the setting
                // amount ??on the setting
                // one debit one credit:every dr entry match cr entry
                // one to many: dr entry single or cr entry is single
                // many to many: not allowed
                return true;
            };

        }
    }

}
