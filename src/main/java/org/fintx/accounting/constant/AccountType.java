package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum AccountType implements Codeable<Integer> {
    /**
     * 甲 乙 丙  丁
     */
    A(1), B(2), C(3), D(3);
    private Integer code;

    private AccountType(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
