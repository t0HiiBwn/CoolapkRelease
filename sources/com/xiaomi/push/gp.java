package com.xiaomi.push;

public enum gp {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    
    private final int e;

    private gp(int i) {
        this.e = i;
    }

    public static gp a(int i) {
        if (i == 1) {
            return INT;
        }
        if (i == 2) {
            return LONG;
        }
        if (i == 3) {
            return STRING;
        }
        if (i != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
