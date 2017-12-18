package org.fintx.accounting.repository;

import org.fintx.accounting.entity.CustomerAccountNo;

import org.springframework.stereotype.Repository;
@Repository
public interface CustomerAccountNoRepo {
    int insert(CustomerAccountNo record);

    CustomerAccountNo selectByCustNoAndAcctTitleCode(String custNo, String acctTitleCode);
}
