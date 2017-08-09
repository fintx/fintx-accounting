package org.fintx.accounting.dao;

import org.fintx.accounting.entity.OperationEntry;

public interface OperationEntryDao {
    int save(OperationEntry record);
}
