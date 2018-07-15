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

import org.fintx.accounting.entity.CustomerAccountNo;
import org.fintx.accounting.entity.InnerAccountNo;

import javax.annotation.Nonnull;

/**
 * AccountNo service interface
 * 
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
public interface AccountNoService {

    public String createAccountNo(@Nonnull final AccountNoSection section);

    public String getAccountNo(@Nonnull final AccountNoSection section);

    public CustomerAccountNo getCustomerAccountNo(@Nonnull final AccountNoSection section);

    public int getCustomerAccountSn(@Nonnull final String customerNo);

    public InnerAccountNo getInnerAccountNo(@Nonnull final AccountNoSection section);

    public int getInnerAccountSn(@Nonnull final String organizationNo);

}
