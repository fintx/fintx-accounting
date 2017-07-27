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
package org.fintx.ledger.service;

import org.fintx.ledger.entity.Account;
import org.fintx.ledger.entity.OperationEntry;
import org.fintx.ledger.entity.TransactionEntry;

import java.util.List;

/**
 * Ledger ing interface
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
public interface Ledger {
    public void post(Transaction transaction);
    public void post(Operation operation);
    public Account  auditAccount(String accountNo);
    public List<TransactionEntry>  auditTransaction(String accountNo,String date);
    public List<OperationEntry>  auditOperation(String accountNo,String date);
}
