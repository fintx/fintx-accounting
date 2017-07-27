package org.fintx.ledger.incubate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeOfOperation {
    private String operationCode;

    private String operationName;

    private String operationCtrl;
    /*
     * for freeze and unfreeze
     */
    private String freezeAccountsNo;

    private String controlAccountsNo;
}