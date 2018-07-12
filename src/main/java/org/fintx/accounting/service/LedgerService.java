/**
 *  Copyright 2017 FinTx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fintx.accounting.service;

import org.fintx.accounting.entity.GeneralLedgerAccount;

import java.math.BigDecimal;

import javax.annotation.Nonnull;

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
public interface LedgerService {
    public GeneralLedgerAccount get(@Nonnull final String accountsNo);
    
    public void createDailyAccounts();

    public void post(@Nonnull final String accountsNo,@Nonnull final  BigDecimal amount);

    public void check();

}
