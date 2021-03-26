package com.ali.auth.third.core.message;

public class Message implements Cloneable {
    public String action;
    public int code;
    public String message;
    public String type;

    public static Message create(int i, Object... objArr) {
        return MessageUtils.createMessage(i, objArr);
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
