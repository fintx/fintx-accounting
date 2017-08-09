package org.fintx.accounting.dao;

import org.fintx.accounting.entity.InnerAccountNo;


public interface InnerAccountNoDao {
    int insert(InnerAccountNo record);

    
    public InnerAccountNo selectInnerByOrgCodeAndAcctTi(String orgCode, String acctTi, String productNo);

    
    public int countInnerByOrgCodeAndProductNo(String orgCode, String productNo);
}
