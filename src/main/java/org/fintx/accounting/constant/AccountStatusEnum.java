package org.fintx.accounting.constant;

import org.fintx.lang.Codeable;

public enum AccountStatusEnum  implements Codeable<Integer>{
    NORMAL(1), CLOSED(2);
    private Integer code;

    private AccountStatusEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
