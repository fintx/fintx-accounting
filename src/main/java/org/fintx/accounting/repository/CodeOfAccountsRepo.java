package org.fintx.accounting.repository;

import java.util.List;

import org.fintx.accounting.entity.CodeOfLedger;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeOfAccountsRepo {
    int save(CodeOfLedger record);

    CodeOfLedger getByAccountsCodeNo(String accountsCodeNo);

    List<CodeOfLedger> getAll();
}