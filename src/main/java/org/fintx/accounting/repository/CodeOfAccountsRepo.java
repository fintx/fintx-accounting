package org.fintx.accounting.repository;

import java.util.List;

import org.fintx.accounting.entity.AccountsCode;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeOfAccountsRepo {
    int save(AccountsCode record);

    AccountsCode getByAccountsCodeNo(String accountsCodeNo);

    List<AccountsCode> getAll();
}