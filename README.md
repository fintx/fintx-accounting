## FinTx Accounting Project


[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.fintx/fintx-accounting/badge.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/org.fintx/fintx-accounting/)
[![GitHub release](https://img.shields.io/github/release/fintx/fintx-accounting.svg)](https://github.com/fintx/fintx-accounting/releases)
![Apache 2](http://img.shields.io/badge/license-Apache%202-red.svg)
[![Join the chat at https://gitter.im/fintx/fintx-accounting](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/fintx/fintx-accounting?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Coverage Status](https://coveralls.io/repos/github/fintx/fintx-accounting/badge.svg)](https://coveralls.io/github/fintx/fintx-accounting)
[![Dependency Status](https://www.versioneye.com/user/projects/598c0fd5368b0838d3a25438/badge.svg?style=flat)](https://www.versioneye.com/user/projects/598c0fd5368b0838d3a25438)

# FinTx[1]

## What's is FinTx?

FinTx is an open source group focus on financial technologies.

## What's is fintx-accounting

fintx-accounting is general accounting project for all fintx projects. It supports:
Double entry accounting/booking;
Single entry accounting/booking;
Account operation/control;

## Using
This is something that you get for free just by adding the following dependency inside your project:

```xml
<dependency>
    <groupId>org.fintx</groupId>
    <artifactId>fintx-accounting</artifactId>
    <version>${latest.version></version>
</dependency>
```
## Example

```java
        //build and persist accountNo
        AccountNoSection.Builder accountNoSectionBuilder=AccountNoSection.builder();
        //...
        AccountNoSection acocuntNoSection=accountNoSectionBuilder.build();
        String accountNo1 = accountNoService.createAccountNo(acocuntNoSection);
        //
        accountNo1=accountNoService.getAccountNo(acocuntNoSection);
        
        //Open account
        AccountOpening.Builder accountOpeningBuilder=AccountOpening.builder();
        //..
        AccountOpening accountOpening=accountOpeningBuilder.build();
        detailLedgerService.post(accountOpening);
        
        //audit accountOpening
        AccountOpeningEntry accountingOpeningEntry=detailLedgerService.auditAccountOpening(accountNo1);
        
        //audit opened account
        Account account1=detailLedgerService.auditAccount(accountNo1);
        
        //build voucher
        Voucher.Builder voucherBuilder=Voucher.builder();
        //...
        Voucher voucher = voucherBuilder.build();
        
        //post transaction for associated voucher
        String accountsCode = "11223344";
        String accountNo2 = "1122334455667777";
        String accountNo3 = "1122334455667788";
        Transaction.Builder transactionBuilder = Transaction.builder();
        transactionBuilder.associate(voucher);
        transactionBuilder.credit(accountsCode,accountNo1, new BigDecimal("100.00"));
        transactionBuilder.debit(accountsCode,accountNo2, new BigDecimal("50.00"));
        transactionBuilder.debit(accountsCode,accountNo3, new BigDecimal("50.00"));
        Transaction transaction = transactionBuilder.build();
        detailLedgerService.post(transaction);
        
        //audit transaction
        List<TransactionEntry> transactionEntries=detailLedgerService.auditTransaction(accountNo1, LocalDate.now(), voucher.getBusinessId());
        
        //operate account
        Operation.Builder operationBuilder=Operation.builder();
        operationBuilder.freeze(accountNo1, new BigDecimal("50.00"));
        operationBuilder.lock(accountNo1, voucher.getBusinessId());
        //...
        Operation operation=operationBuilder.build();
        detailLedgerService.post(operation);
        
        //audit operation
        List<OperationEntry> operationEntries= detailLedgerService.auditOperation(accountNo1, LocalDate.now(), voucher.getBusinessId());
      
```


[1] FinTx https://www.fintx.org/    
[2] Maven https://maven.apache.org/
