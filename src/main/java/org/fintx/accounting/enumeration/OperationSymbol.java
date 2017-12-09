package org.fintx.accounting.enumeration;

import org.fintx.lang.Codeable;

public enum OperationSymbol  implements Codeable<Integer> {
    OPEN(1),CLOSE(2), FREEZE(3),RELEASE(4),CONTROL(5),LOCK(6),FREE(7);
    private Integer code;

    private OperationSymbol(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }
}
