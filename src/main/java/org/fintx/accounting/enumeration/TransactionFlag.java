package org.fintx.accounting.enumeration;

import org.fintx.lang.Codeable;

public enum TransactionFlag  implements Codeable<Integer> {
    RECORD(1), CANCEL(2), FLASH(3);
    private Integer code;

    private TransactionFlag(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
