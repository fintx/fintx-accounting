package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum AccountsOwnerFlagEnum implements Codeable<Integer> {
    INNER(1), CUSTOMER(2);
    private Integer code;

    private AccountsOwnerFlagEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
