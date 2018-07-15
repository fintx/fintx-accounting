package org.fintx.accounting.repository;

import org.fintx.accounting.entity.InnerAccountSn;

import org.springframework.stereotype.Repository;

@Repository
public interface InnerAccountSnRepo {

    public int insert(InnerAccountSn record) throws Exception;

    public void updateCustomer(InnerAccountSn custAccount) throws Exception;
}
