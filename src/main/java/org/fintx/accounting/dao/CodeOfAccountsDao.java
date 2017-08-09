package org.fintx.accounting.dao;

import java.util.List;

import org.fintx.accounting.entity.CodeOfAccounts;

public interface CodeOfAccountsDao {
    int save(CodeOfAccounts record);

    CodeOfAccounts getByAccountsCodeNo(String accountsCodeNo);

    List<CodeOfAccounts> getAll();
}