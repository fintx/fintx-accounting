package org.fintx.accounting.repository;

import org.fintx.accounting.entity.OperationEntry;

import org.springframework.stereotype.Repository;

@Repository
public interface OperationEntryRepo {
    int save(OperationEntry record);
}
