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
import java.util.HashMap;
import java.util.Map;

import org.fintx.accounting.constant.TransactionFlagEnum;
import org.fintx.accounting.entity.TransactionEntry;
import org.fintx.accounting.entity.Voucher;
import org.fintx.accounting.util.Ids;
import org.fintx.util.UniqueId;

import lombok.Data;
import lombok.NonNull;

/**
 * This class is not thread safe
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Data
public class Transaction {
    private Transaction() {

    }

    private Voucher voucher;
    private String transactionId = UniqueId.get().toString();
    private ZonedDateTime transactionDateTime = ZonedDateTime.now();
    /*
     * 1 post 记账 1 flash 冲账 2 cancel 抹账
     */
    private TransactionFlagEnum transactionflag = TransactionFlagEnum.RECORD;
    private ArrayList<TransactionEntry> creditEntries;
    private ArrayList<TransactionEntry> debitEntries;
    private ArrayList<TransactionEntry> receiptEntries;
    private ArrayList<TransactionEntry> payEntries;
    private Map<String, RestrictionVisitor> restrictEntries;

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
        private Verifier<Transaction> verifer = null;
        private static final Verifier<Transaction> defaultVerifer = new TransactionVerifer();

        private Builder() {
        }

        public Builder associate(Voucher voucher) {
            transaction.voucher = voucher;
            return this;
        }

        public Builder debit(String accountsNo, String accountNo, BigDecimal amount) {
            return this;
        }

        public Builder credit(String accountsNo, String accountNo, BigDecimal amount) {
            // if (null == transaction.creditEntries) {
            // synchronized (transaction) {
            // if (null == transaction.creditEntries) {
            // transaction.creditEntries = new ArrayList<TransactionEntry>(5);
            // }
            // }
            // }

            if (null == transaction.creditEntries) {
                transaction.creditEntries = new ArrayList<TransactionEntry>(5);
            }

            // transaction.creditEntries.add(new TransactionEntry(accountNo, amount));
            return this;
        }

        public Builder receipt(@NonNull final String accountNo, @NonNull final BigDecimal amount) {
            if (null == transaction.receiptEntries) {
                transaction.receiptEntries = new ArrayList<TransactionEntry>(5);
            }
            // TransactionEntry receipt = new TransactionEntry(Ids.getId(), accountNo);
            // receipt.setAmount(amount);
            // transaction.receiptEntries.add(receipt);
            return this;
        }

        public Builder pay(@NonNull final String accountNo, @NonNull final BigDecimal amount) {
            if (null == transaction.payEntries) {
                transaction.payEntries = new ArrayList<TransactionEntry>(5);
            }
            // TransactionEntry pay = new TransactionEntry(Ids.getId(), accountNo);
            // pay.setAmount(amount.multiply(new BigDecimal(-1)));
            // transaction.payEntries.add(pay);
            return this;
        }

        public Builder restrict(@NonNull final String accountNo, @NonNull final RestrictionVisitor res) {
            if (null == transaction.restrictEntries) {
                transaction.restrictEntries = new HashMap<>(4);
            }
            transaction.restrictEntries.put(accountNo, res);
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
        public Builder transactionDateTime(ZonedDateTime transactionDateTime) {
            this.transaction.transactionDateTime = transactionDateTime;
            return this;
        }

        /*
         * if transactionDate is different with voucher's businessDate
         */
        public Builder transactionFlag(TransactionFlagEnum transactionFlag) {
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
            if (verifer.verify(transaction)) {
                for (TransactionEntry e : transaction.payEntries) {
                    e.setTransactionId(transaction.transactionId);
                    e.setZoneOffset(transaction.transactionDateTime.getOffset());
                    e.setTransactionDate(transaction.transactionDateTime.toLocalDate());
                }

                for (TransactionEntry e : transaction.receiptEntries) {
                    e.setTransactionId(transaction.transactionId);
                    e.setZoneOffset(transaction.transactionDateTime.getOffset());
                    e.setTransactionDate(transaction.transactionDateTime.toLocalDate());
                }
                return transaction;
            } else {
                // TODO add special Exception
                throw new RuntimeException("Fail to verify the transaction info");
            }
        };

        public static class TransactionVerifer implements Verifier<Transaction> {

            public boolean verify(Transaction txn) {
                // accountNo type length?? on the setting
                // amount ??on the setting
                // one debit one credit:every dr entry match cr entry
                // one to many: dr entry single or cr entry is single
                // many to many: not allowed

                if (null == txn.transactionId) {
                    throw new RuntimeException("transactionId should not be null!");
                }

                if (null == txn.transactionDateTime) {
                    throw new RuntimeException("transactionDateTime should not be null!");
                }

                BigDecimal totalCredit = new BigDecimal("0.00");
                BigDecimal totalDebit = new BigDecimal("0.00");
                int creditCount = 0;
                int debitCount = 0;
                for (TransactionEntry e : txn.creditEntries) {
                    totalCredit = totalCredit.add(e.getAmount());
                    creditCount++;
                }

                for (TransactionEntry e : txn.debitEntries) {
                    totalDebit = totalDebit.add(e.getAmount());
                    debitCount++;
                }

                // Total credit must equals to total debit.
                // Only one credit or one debit.
                if (totalCredit.compareTo(totalDebit) == 0 && (1 == creditCount || 1 == debitCount)) {
                    return true;
                } else {
                    return false;
                }

            };

        }
    }

}
