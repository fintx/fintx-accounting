package org.fintx.accounting.dao;

import org.fintx.accounting.entity.InnerAccountSn;


public interface InnerAccountSnDao {

    
    public int insert(InnerAccountSn record) throws Exception;

   
    public void updateCustomer(InnerAccountSn custAccount) throws Exception;
}
