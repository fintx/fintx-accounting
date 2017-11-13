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

import org.fintx.accounting.entity.AccountOpeningEntry;
import org.fintx.accounting.entity.OperationEntry;
import org.fintx.accounting.entity.Voucher;
import org.fintx.accounting.enumeration.OperationFlag;
import org.fintx.accounting.service.Transaction.Builder;
import org.fintx.util.UniqueId;

import lombok.Getter;

/**
 * This class is not thread safe
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 */
@Getter
public class AccountOpening {
    private AccountOpening() {

    }
//    private String accountsCodeNo;
//
//    private String organizationNo;
//
//    private String customerNo;
//
//    //private String accountSn;
//
//    private String accountNo;
//
//    private String productNo;
    private String accountOpeningId=UniqueId.get().toString();
    
    private Voucher voucher;

    private ArrayList<AccountOpeningEntry> innerAccountOpeningEntrys;
    private ArrayList<AccountOpeningEntry> customerAccountOpeningEntrys;
    

    // control and buff should be a configuration not a function
    // private ArrayList controlCreditEntrys;
    // private ArrayList controlDebitEntrys;
    // private ArrayList buffCreditEntrys;
    // private ArrayList buffDebitEntrys;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private AccountOpening accountOpening = new AccountOpening();
        private Verifer<AccountOpening> verifer = null;
        private static final Verifer<AccountOpening> defaultVerifer = new AccountOpeningVerifer();

        public Builder associate(Voucher voucher) {
            accountOpening.voucher=voucher;
            return this;
        }
        
        private Builder() {
        }
        

        public Builder inner(String accountNo,String organizationNo, String productNo, String businessId) {

            return this;
        }

        public Builder customer(String organizationNo, String productNo, String customerNo, String businessId) {

            return this;
        }

     
        
        /*
         * if operationDate is different with voucher's businessDate
         */
         public Builder accountOpeningId(String accountOpeningId) {
         return this;
         }
        
      

        public Builder accountOpeningVerifer(Verifer verifer) {
            this.verifer = verifer;
            return this;
        }

        public AccountOpening build() {
            if (null == verifer) {
                verifer = defaultVerifer;
            }
            if(verifer.verify(accountOpening)) {
                return accountOpening; 
            }else {
                //TODO add special Exception
                throw new RuntimeException("Fail to verify the accountOpening info");
            }
            
        };

        public static class AccountOpeningVerifer implements Verifer<AccountOpening> {

            public boolean verify(AccountOpening txn) {
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
