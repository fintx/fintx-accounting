package org.fintx.accounting.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * CustomerAccountSn CustomerAccountNo InnerAccountSn InnerAccountNo could put in seperated database.
 * they should use in transaction scope.
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Getter
@Setter
public class CustomerAccountSn {
    /**
     * 客户号
     */
    private String customerNo;

    /**
     * 账户序号
     */
    private int accountSn;

}