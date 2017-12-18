package org.fintx.accounting.repository;

import java.math.BigDecimal;

import org.fintx.accounting.entity.Account;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 
 *
 */
@Repository
public interface AccountRepo {

    int save(Account account);

    int minusToFrozenAmt(BigDecimal amount);

    int plusToFrozenAmt(BigDecimal amount);

    Account lockAccount(String accountNo);

    int modifyBalance(Account account);
  
    Account getByAccountNo(String accountNo);

    
    BigDecimal selectAcctTitleSumAmtList(String accountsNo, String orderId);

}
