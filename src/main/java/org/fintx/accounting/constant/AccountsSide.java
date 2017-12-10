package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum AccountsSide implements Codeable<Integer> {
    DEBTOR(1), CREDITOR(2),NONE(3);
    
    private Integer code;

    private AccountsSide(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
