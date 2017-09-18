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
String accountNo = ledgerService.createCustomerAccount(accountsNo, organizationNo, custNo, productNo, transactionDate);
Transaction.Builder builder = Transaction.builder();
builder.associate(voucher);
builder.credit(accountNo, new BigDecimal("100.00"));
builder.debit(accountNo1, new BigDecimal("50.00"));
builder.debit(accountNo2, new BigDecimal("50.00"));
Transaction transaction = builder.build();
ledgerService.post(transaction);

```


[1] FinTx https://www.fintx.org/    
[2] Maven https://maven.apache.org/
