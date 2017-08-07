package org.fintx.accounting.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.fintx.accounting.entity.Account;
import org.fintx.accounting.entity.TransactionEntry;

import org.apache.ibatis.annotations.Param;


public interface AccountDao {
	
	int save(Account record);



	
	int minusToFrozenAmt(BigDecimal amount);


	int plusToFrozenAmt(BigDecimal amount);


	Account lockAccount(String accountNo);

	
	int updateBalance(Account account);


	/**
	 * @param mapkey
	 *            :tableName,acctNo
	 * @return
	 */
	Account getByAcctNo(String accountNo);

	/**
	 * 某一个科目流水中某一个定单的发生金额(订单)
	 * 
	 * @param acctTitleService
	 * @param productNo
	 * @param dueBillNo
	 * @return
	 */
	BigDecimal selectAcctTitleSumAmtList(String accountsNo, String orderId);


}
