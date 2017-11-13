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
public class InnerAccountNo {
    private String accountNo;

    private String organizationNo;
    
    private String productNo;

    private String businessId;

    private String businessDate;

}