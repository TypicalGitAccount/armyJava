package com.jdxarmy.back.exceptions;

public class UnitIsDeadException extends  Exception {
    String deadUnitName;

    public UnitIsDeadException(String errMsg, String deadUnitName) {
        super(errMsg);
        this.deadUnitName = deadUnitName;
    }

    public String getDeadUnitName() { return this.deadUnitName; }
}
