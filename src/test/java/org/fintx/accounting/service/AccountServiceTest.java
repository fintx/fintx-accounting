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

import static org.junit.Assert.*;

import org.fintx.accounting.constant.OperationSymbolEnum;
import org.fintx.accounting.constant.TransactionFlagEnum;
import org.fintx.accounting.constant.TransactionSymbolEnum;
import org.fintx.accounting.entity.Account;
import org.fintx.accounting.entity.OperationEntry;
import org.fintx.accounting.entity.TransactionEntry;
import org.fintx.accounting.entity.Voucher;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
public class AccountServiceTest {
    @Autowired
    AccountNoService accountNoService = null;

    @Autowired
    AccountingService accountingService = null;

    @Test
    public void test() {
        // OffsetDateTime offsetDateTime = OffsetDateTime.now();
        // System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        // LocalDate localDate = offsetDateTime.toLocalDate();
        // System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        // offsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);
        // System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        // localDate = offsetDateTime.toLocalDate();
        // System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        // offsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.MAX);
        // System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        // localDate = offsetDateTime.toLocalDate();
        // System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));

        String accountsNo = "11223344";
        String organizationNo = "010101";
        String productNo = "010101";
        String customerNo = "120222";
        String accountNo2 = "1122334455667777";
        String accountNo3 = "1122334455667788";
        
        // build and persist accountNo
        AccountNoSection.Builder accountNoSectionBuilder = AccountNoSection.builder();
        accountNoSectionBuilder.accountsNo(accountsNo);
        accountNoSectionBuilder.organizationNo(organizationNo);
        accountNoSectionBuilder.productNo(productNo);
        accountNoSectionBuilder.customerNo(customerNo);
        // ...
        AccountNoSection acocuntNoSection = accountNoSectionBuilder.build();
        String accountNo1 = accountNoService.createAccountNo(acocuntNoSection);
        //
        accountNo1 = accountNoService.getAccountNo(acocuntNoSection);

        // Open account
        Operation.Builder operationBuilder = Operation.builder();
        operationBuilder.openCustomer(accountsNo, accountNo1, organizationNo, productNo, customerNo);
        // ...
        Operation operation = operationBuilder.build();
        accountingService.post(operation,null);
        

        // build voucher
        Voucher.Builder voucherBuilder = Voucher.builder();
        // ...
        Voucher voucher = voucherBuilder.build();

        // post transaction for associated voucher
        
        Transaction.Builder transactionBuilder = Transaction.builder();
        transactionBuilder.associate(voucher);
        transactionBuilder.credit(accountsNo, accountNo1, new BigDecimal("100.00"));
        transactionBuilder.debit(accountsNo, accountNo2, new BigDecimal("50.00"));
        transactionBuilder.debit(accountsNo, accountNo3, new BigDecimal("50.00"));
        Transaction transaction = transactionBuilder.build();
        accountingService.post(transaction,null);

        // audit transaction
        TransactionFlagEnum[] transflags = { TransactionFlagEnum.RECORD };
        TransactionSymbolEnum[] transSymbols = { TransactionSymbolEnum.CREDIT };
        List<TransactionEntry> transactionEntries =
                accountingService.auditTransaction(accountsNo,LocalDate.now(), accountNo1,  transflags, transSymbols, voucher.getBusinessId());

        // operate account
        operationBuilder = Operation.builder();
        operationBuilder.freeze(accountsNo, accountNo1, new BigDecimal("50.00"));
        operationBuilder.lock(accountsNo, accountNo1, voucher.getBusinessId());
        // ...
        operation = operationBuilder.build();
        accountingService.post(operation,null);

        // audit operation
        OperationSymbolEnum[] operSymbols= {OperationSymbolEnum.OPEN,OperationSymbolEnum.CLOSE};
        List<OperationEntry> operationEntries = accountingService.auditOperation(accountsNo, LocalDate.now(), accountNo3,operSymbols, voucher.getBusinessId());

    }

}
