package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum TransactionSymbolEnum implements Codeable<Integer> {
    DEBIT(1), CREDIT(2), RECEIPT(3), PAY(4);
    private Integer code;

    private TransactionSymbolEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
