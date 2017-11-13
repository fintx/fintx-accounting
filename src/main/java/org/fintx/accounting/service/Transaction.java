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
import java.time.ZonedDateTime;
import java.util.ArrayList;

import org.fintx.accounting.entity.TransactionEntry;
import org.fintx.accounting.entity.Voucher;
import org.fintx.accounting.enumeration.TransactionFlag;
import org.fintx.util.UniqueId;

import lombok.Getter;

/**
 * This class is not thread safe
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Getter
public class Transaction {
    private Transaction() {

    }

    private Voucher voucher;
    private String transactionId=UniqueId.get().toString();
    private ZonedDateTime transactionDateTime=ZonedDateTime.now();
    /*
     * 1 post 记账 1 flash 冲正 2 cancel 撤销
     */
    private TransactionFlag transactionflag = TransactionFlag.POST;
    private ArrayList<TransactionEntry> creditEntrys;
    private ArrayList<TransactionEntry> debitEntrys;
    private ArrayList<TransactionEntry> receiptEntrys;
    private ArrayList<TransactionEntry> payEntrys;

    // control and buff should be a configuration not a function
    // private ArrayList controlCreditEntrys;
    // private ArrayList controlDebitEntrys;
    // private ArrayList buffCreditEntrys;
    // private ArrayList buffDebitEntrys;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Transaction transaction = new Transaction();
        private Verifer<Transaction> verifer = null;
        private static final Verifer<Transaction> defaultVerifer = new TransactionVerifer();

        private Builder() {
        }

        public Builder associate(Voucher voucher) {
            transaction.voucher=voucher;
            return this;
        }

        public Builder debit(String accountsCode,String accountNo, BigDecimal amount) {
            return this;
        }

        public Builder credit(String accountsCode,String accountNo, BigDecimal amount) {
            if (null == transaction.creditEntrys) {
                synchronized (transaction) {
                    if (null == transaction.creditEntrys) {
                        transaction.creditEntrys = new ArrayList<TransactionEntry>(5);
                    }
                }
            }
            // transaction.creditEntrys.add(new TransactionEntry(accountNo, amount));
            return this;
        }

        public Builder receipt(String accountsCode,String accountNo, BigDecimal amount) {
            return this;
        }

        public Builder pay(String accountsCode,String accountNo, BigDecimal amount) {
            return this;
        }

        /*
         * if transactionDate is different with voucher's businessDate
         */
         public Builder transactionId(String transactionId) {
         return this;
         }
        /*
         * if transactionDate is different with voucher's businessDate
         */
        public Builder transactionDate(String transactionDate) {
            return this;
        }
        
        /*
         * if transactionDate is different with voucher's businessDate
         */
        public Builder transactionFlag(TransactionFlag transactionFlag) {
            return this;
        }

        public Builder transactionVerifer(TransactionVerifer verifer) {
            this.verifer = verifer;
            return this;
        }

        public Transaction build() {
            if (null == verifer) {
                verifer = defaultVerifer;
            }
            if(verifer.verify(transaction)) {
                return transaction; 
            }else {
                //TODO add special Exception
                throw new RuntimeException("Fail to verify the transaction info");
            }
        };

        public static class TransactionVerifer implements Verifer<Transaction> {

            public boolean verify(Transaction txn) {
                // accountNo type length?? on the setting
                // amount ??on the setting
                // one debit one credit:every dr entry match cr entry
                // one to many: dr entry single or cr entry is single
                // many to many: not allowed
                return true;
            };

        }
    }

}
