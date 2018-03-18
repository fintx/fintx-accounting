package org.fintx.accounting.service.impl;

import org.fintx.accounting.constant.AccountsSide;
import org.fintx.accounting.constant.OperationSymbol;
import org.fintx.accounting.constant.Operator;
import org.fintx.accounting.constant.TransactionFlag;
import org.fintx.accounting.constant.TransactionSymbol;
import org.fintx.accounting.entity.Account;
import org.fintx.accounting.entity.CodeOfAccounts;
import org.fintx.accounting.entity.CustomerAccountNo;
import org.fintx.accounting.entity.OperationEntry;
import org.fintx.accounting.entity.TransactionEntry;
import org.fintx.accounting.repository.AccountRepo;
import org.fintx.accounting.repository.CodeOfAccountsRepo;
import org.fintx.accounting.repository.CustomerAccountNoRepo;
import org.fintx.accounting.repository.CustomerAccountSnRepo;
import org.fintx.accounting.repository.InnerAccountNoRepo;
import org.fintx.accounting.repository.InnerAccountSnRepo;
import org.fintx.accounting.repository.OperationEntryRepo;
import org.fintx.accounting.repository.TransactionEntryRepo;
import org.fintx.accounting.service.Restriction;
import org.fintx.accounting.service.AccountNoService;
import org.fintx.accounting.service.AccountService;
import org.fintx.accounting.service.AccountingService;
import org.fintx.accounting.service.AccountsService;
import org.fintx.accounting.service.Operation;
import org.fintx.accounting.service.Transaction;
import org.fintx.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nonnull;

public class AccountingServiceImpl implements AccountingService {
    
    @Autowired
    AccountService accountService;
    
    @Autowired
    AccountsService accountsService;
    
    @Autowired
    AccountNoService accountNoService;

    /*
     * 冲正是否可为负
     *
     */
    // TODO 放入账户控制标识中
    public static Boolean flash_not_negative = false;

    /*
     * 是否验证昨日余额
     * 
     */
    // TODO 放入账户控制标识中
    public static Boolean check_last_balance = false;

    @Override
    public void post(Transaction trans) {
        TransactionEntry[] entries = null;
        if (trans.getPayEntries().addAll(trans.getReceiptEntries())) {
            // Sort AccountEentry by accountNo to prevent deadlock
            entries = trans.getPayEntries().toArray(new TransactionEntry[trans.getPayEntries().size()]);
            Arrays.sort(entries, (x, y) -> x.getAccountNo().compareTo(y.getAccountNo()));
            try {
                for (TransactionEntry e : entries) {
//                    // lock the account so the balance can be wipe if there is any exception.
//                    accountService.lock(e.getAccountNo(), trans.getTransactionId(), true);
                    Restriction res = trans.getRestrictEntries().get(e.getAccountNo());
                    accountService.update(e, res);
                }
            } catch (Throwable t) {
                for (TransactionEntry e : entries) {
                    try {
//                        accountService.lock(e.getAccountNo(), e.getTransactionId(), true);
                        accountService.wipe(e);
                    } catch (Throwable t1) {
                        // the lock can be re-enter
                        // if lock fail, there is no entry to be wipe
                        // Do nothing
                    }
                }
                throw t;
            } finally {
                if (null != entries) {
                    for (TransactionEntry e : entries) {
//                        accountService.lock(e.getAccountNo(), e.getTransactionId(), false);
                    }
                }
            }

        } else {
            throw new RuntimeException("Could not merge TransactionEntry list of pay and receipt");
        }

    }

    @Override
    public void post(Operation operation) {
        // TODO Auto-generated method stub

    }

    @Override
    public Account auditAccount(String codeOfAccounts, String accountNo) {
        return null;
    }

    @Override
    public List<TransactionEntry> auditTransaction(String codeOfAccounts, LocalDate date, String accountNo, TransactionFlag[] flag, TransactionSymbol[] symbol,
            String businessId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OperationEntry> auditOperation(String codeOfAccounts, LocalDate date, String accountNo, OperationSymbol[] symbol, String businessId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.fintx.accounting.service.AccountingService#auditAccounts(java.lang.String)
     */
    @Override
    public Account auditAccounts(String codeOfAccounts) {
        // TODO Auto-generated method stub
        return null;
    }
}
