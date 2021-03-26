package com.qq.e.comm.adevent;

public class ADEvent {
    private final int a;
    private final Object[] b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.a = i;
        this.b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.a;
    }
}
