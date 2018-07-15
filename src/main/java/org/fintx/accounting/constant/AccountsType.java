package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum AccountsType implements Codeable<Integer> {
    // 账类
    /**
     * 01-对私活期 02-对公活期 03-对私定期 04-对公定期 05-拨款、贷款 06-损益 07-现金 08-其他内部帐 09-其他 99-表外
     */
    ONE(1), TWO(2), THREE(3);
    private Integer code;

    private AccountsType(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
