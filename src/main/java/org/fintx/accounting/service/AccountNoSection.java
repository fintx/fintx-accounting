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

import org.fintx.accounting.constant.AccountsOwnerFlagEnum;
import org.fintx.accounting.constant.OperationSymbolEnum;
import org.fintx.accounting.entity.OperationEntry;
import org.fintx.accounting.entity.Voucher;
import org.fintx.accounting.service.Transaction.Builder;
import org.fintx.util.UniqueId;

import lombok.Getter;

/**
 * This class is not thread safe
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 */
@Getter
public class AccountNoSection {
    private AccountNoSection() {

    }

    private String accountsNo;

    private String organizationNo;

    private String productNo;

    private String customerNo;


    // private AccountOwnerFlag accountOwnerFlag;

    private String accountNoSectionId = UniqueId.get().toString();


    // control and buff should be a configuration not a function
    // private ArrayList controlCreditEntrys;
    // private ArrayList controlDebitEntrys;
    // private ArrayList buffCreditEntrys;
    // private ArrayList buffDebitEntrys;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private AccountNoSection accountNoSection = new AccountNoSection();
        private Verifier<AccountNoSection> verifer = null;
        private static final Verifier<AccountNoSection> defaultVerifer = new AccountOpeningVerifer();

        

        private Builder() {
        }

        public Builder accountsNo(String accountsCodeNo) {
            accountNoSection.accountsNo = accountsCodeNo;
            return this;
        }

        public Builder organizationNo(String organizationNo) {
            accountNoSection.organizationNo = organizationNo;
            return this;
        }

        public Builder productNo(String productNo) {
            accountNoSection.productNo = productNo;
            return this;
        }

        public Builder customerNo(String customerNo) {
            accountNoSection.customerNo = customerNo;
            return this;
        }

       

        /*
         * if operationDate is different with voucher's businessDate
         */
        public Builder accountNoSectionId(String accountNoSectionId) {
            accountNoSection.accountNoSectionId = accountNoSectionId;
            return this;
        }

        public Builder accountOpeningVerifer(Verifier verifer) {
            this.verifer = verifer;
            return this;
        }

        public AccountNoSection build() {
            if (null == verifer) {
                verifer = defaultVerifer;
            }
            if (verifer.verify(accountNoSection)) {
                return accountNoSection;
            } else {
                // TODO add special Exception
                throw new RuntimeException("Fail to verify the accountOpening info");
            }

        };

        public static class AccountOpeningVerifer implements Verifier<AccountNoSection> {

            public boolean verify(AccountNoSection txn) {
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
