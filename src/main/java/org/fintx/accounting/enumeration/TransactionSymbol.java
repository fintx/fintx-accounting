package org.fintx.accounting.enumeration;

import org.fintx.lang.Codeable;

public enum TransactionSymbol  implements Codeable<Integer>{
    DEBIT(1), CREDIT(2), RECEIPT(3), PAY(4);
    private Integer code;

    private TransactionSymbol(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
