package com.ali.auth.third.core.config;

public class Version {
    private int a;
    private int b;
    private int c;

    public Version(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public String toString() {
        return this.a + "." + this.b + "." + this.c;
    }
}
