package org.fintx.ledger.impl;

import org.fintx.ledger.Ledger;
import org.fintx.ledger.Operation;
import org.fintx.ledger.Transaction;
import org.fintx.ledger.entity.Account;
import org.fintx.ledger.entity.OperationEntry;
import org.fintx.ledger.entity.TransactionEntry;

import java.util.List;

public class LedgerImpl implements Ledger {

    @Override
    public void post(Transaction transaction) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void post(Operation operation) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Account auditAccount(String accountNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TransactionEntry> auditTransaction(String accountNo, String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OperationEntry> auditOperation(String accountNo, String date) {
        // TODO Auto-generated method stub
        return null;
    }


}
