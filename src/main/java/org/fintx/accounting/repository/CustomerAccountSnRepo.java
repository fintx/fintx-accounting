package org.fintx.accounting.repository;

import org.fintx.accounting.entity.CustomerAccountSn;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountSnRepo {

    
    public int save(CustomerAccountSn record) throws Exception;

    
    public void modifyCustomer(CustomerAccountSn custAccount) throws Exception;
}
