package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum AccountsLevelEnum implements Codeable<Integer> {
    ONE(1), TWO(2), THREE(3);
    private Integer code;

    private AccountsLevelEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
