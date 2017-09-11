package org.fintx.accounting.dao;

import java.math.BigDecimal;

import org.fintx.accounting.entity.Account;

/**
 * 
 * @author 
 *
 */
public interface AccountDao {

    int save(Account account);

    int minusToFrozenAmt(BigDecimal amount);

    int plusToFrozenAmt(BigDecimal amount);

    Account lockAccount(String accountNo);

    int modifyBalance(Account account);
  
    Account getByAccountNo(String accountNo);

    
    BigDecimal selectAcctTitleSumAmtList(String accountsNo, String orderId);

}
