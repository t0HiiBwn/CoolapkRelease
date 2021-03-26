package com.xiaomi.push;

public class ir extends ia {
    protected int a = 0;

    public ir() {
    }

    public ir(int i) {
        this.a = i;
    }

    public ir(int i, String str) {
        super(str);
        this.a = i;
    }

    public ir(int i, Throwable th) {
        super(th);
        this.a = i;
    }

    public ir(String str) {
        super(str);
    }
}
