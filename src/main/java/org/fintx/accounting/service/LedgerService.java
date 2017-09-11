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

import org.fintx.accounting.entity.Account;
import org.fintx.accounting.entity.OperationEntry;
import org.fintx.accounting.entity.TransactionEntry;

import java.util.List;

/**
 * Ledger accounting interface
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
public interface LedgerService {
    public String createInnerAccount(String accountsNo, String organizationNo, String productNo, String transactionDate);

    public String createCustomerAccount(String accountsNo, String organizationNo, String custNo, String productNo, String transactionDate);

    public void post(Transaction transaction);

    public void cancel(String transactionId);

    public void flush(String transactionId, String transactionDate);

    public void post(Operation operation);

    public Account auditAccount(String accountNo);

    public List<TransactionEntry> auditTransaction(String accountNo, String date);

    public List<OperationEntry> auditOperation(String accountNo, String date);
}
