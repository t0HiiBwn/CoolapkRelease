package com.tencent.imsdk;

public class TIMElem {
    private static final String TAG = ("imsdk." + TIMElem.class.getSimpleName());
    protected TIMElemType type = TIMElemType.Invalid;

    public TIMElemType getType() {
        return this.type;
    }

    int getTypeValue() {
        return this.type.value();
    }
}
