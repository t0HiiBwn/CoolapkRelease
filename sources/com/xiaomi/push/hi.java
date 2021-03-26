package com.xiaomi.push;

public enum hi {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f562a;

    private hi(int i) {
        this.f562a = i;
    }

    public static hi a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }

    public int a() {
        return this.f562a;
    }
}
