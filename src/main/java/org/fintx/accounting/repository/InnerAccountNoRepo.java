package org.fintx.accounting.repository;

import org.fintx.accounting.entity.InnerAccountNo;

import org.springframework.stereotype.Repository;

@Repository
public interface InnerAccountNoRepo {
    int insert(InnerAccountNo record);

    public InnerAccountNo selectInnerByOrgCodeAndAcctTi(String orgCode, String acctTi, String productNo);

    public int countInnerByOrgCodeAndProductNo(String orgCode, String productNo);
}
