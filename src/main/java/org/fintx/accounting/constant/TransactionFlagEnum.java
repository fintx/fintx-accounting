package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum TransactionFlagEnum  implements Codeable<Integer> {
    RECORD(1), CANCEL(2), FLASH(3);
    private Integer code;

    private TransactionFlagEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
