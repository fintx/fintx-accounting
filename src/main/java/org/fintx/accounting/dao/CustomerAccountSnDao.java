package org.fintx.accounting.dao;

import org.fintx.accounting.entity.CustomerAccountSn;


public interface CustomerAccountSnDao {

    
    public int save(CustomerAccountSn record) throws Exception;

    
    public void modifyCustomer(CustomerAccountSn custAccount) throws Exception;
}
