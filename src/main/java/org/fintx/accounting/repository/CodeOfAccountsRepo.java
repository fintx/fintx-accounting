package org.fintx.accounting.repository;

import java.util.List;

import org.fintx.accounting.entity.AccountCode;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeOfAccountsRepo {
    int save(AccountCode record);

    AccountCode getByAccountsCodeNo(String accountsCodeNo);

    List<AccountCode> getAll();
}