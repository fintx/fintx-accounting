/**
 *  Copyright 2017 FinTx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.organization/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fintx.accounting.service;

import org.fintx.accounting.constant.OperationSymbol;
import org.fintx.accounting.constant.TransactionFlag;
import org.fintx.accounting.constant.TransactionSymbol;
import org.fintx.accounting.entity.Account;
import org.fintx.accounting.entity.OperationEntry;
import org.fintx.accounting.entity.TransactionEntry;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Nonnull;

/**
 * Ledger accounting interface
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
public interface AccountService {

    /**
     * 冲正 金额必须为负 更新余额 流水入账 撤销 金额必须为负 更新余额 流水不入账
     * 
     * @param transaction
     */
    public Account update(@Nonnull final TransactionEntry entry,@Nonnull final Restriction res);
    

    /**
     * 冲正 金额必须为负 更新余额 流水入账 撤销 金额必须为负 更新余额 流水不入账
     * 
     * @param transaction
     */
    public Account update(@Nonnull final OperationEntry entry);
    
    public void wipe(@NonNull final TransactionEntry entry);

    public void strike(@NonNull final TransactionEntry entry);

    public Account get(@Nonnull final String codeOfAccounts, @Nonnull final String accountNo);

    public List<TransactionEntry> getTransactions(@Nonnull final String codeOfAccounts, @Nonnull final LocalDate date, final String accountNo,
            final TransactionFlag[] flag, final TransactionSymbol[] symbol, final String businessId);

    public List<OperationEntry> getOperations(@Nonnull final String codeOfAccounts, @Nonnull final LocalDate date, final String accountNo,
            final OperationSymbol[] symbol, final String businessId);
}
