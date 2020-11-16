package com.rest.api.interview.enums;

import lombok.Getter;
import lombok.Setter;

public enum OperationEnum {

    VISTA(1l, "COMPRA A VISTA"),
    PARCELADA(2l, "COMPRA PARCELADA"),
    SAQUE(3l, "SAQUE"),
    PAGAMENTO(4l, "PAGAMENTO");

    private @Getter @Setter Long code;
    private @Getter @Setter String desc;

    private OperationEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OperationEnum getByCode(Long ch) {
        for (OperationEnum ts : OperationEnum.values()) {
            if (ch.equals(ts.getCode())) {
                return ts;
            }
        }
        return null;
    }
}