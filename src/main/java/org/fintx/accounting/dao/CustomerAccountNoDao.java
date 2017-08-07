package org.fintx.accounting.dao;

import org.fintx.accounting.entity.CustomerAccountNo;

public interface CustomerAccountNoDao {
	int insert(CustomerAccountNo record);
	CustomerAccountNo selectByCustNoAndAcctTitleCode(String custNo,String acctTitleCode);
}
