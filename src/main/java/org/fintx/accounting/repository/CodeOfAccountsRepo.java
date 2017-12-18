package org.fintx.accounting.repository;

import java.util.List;

import org.fintx.accounting.entity.CodeOfAccounts;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeOfAccountsRepo {
    int save(CodeOfAccounts record);

    CodeOfAccounts getByAccountsCodeNo(String accountsCodeNo);

    List<CodeOfAccounts> getAll();
}