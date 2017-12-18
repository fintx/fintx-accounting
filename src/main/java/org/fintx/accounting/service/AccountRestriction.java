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

import lombok.Builder;

import java.math.BigDecimal;

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Builder(builderClassName="Builder")
public class AccountRestriction {
    /**
     * 透支限制-->使用MinBalanceLimit
     */
    //private BigDecimal overdraftLimit;
    /**
     * 借发生额限制，如每天累计买入不超过5万
     */
    private BigDecimal drTransAmtLimit;
    /**
     * 借发生额限制，如每天累计买入不超过5万
     */
    private BigDecimal crTransAmtLimit;
    /**
     * ？？发生额限制
     */
    private BigDecimal transAmtLimit;

    /**
     * 余额额限制，如小额账户
     */
    private BigDecimal MaxBalanceLimit;
    /**
     * 余额额限制，如小额账户
     */
    private BigDecimal MinBalanceLimit;

}
