package com.xiaomi.push;

import java.net.InetSocketAddress;

public final class co {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f274a;

    public co(String str, int i) {
        this.f274a = str;
        this.a = i;
    }

    public static co a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new co(str, i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m183a(String str, int i) {
        co a2 = a(str, i);
        return new InetSocketAddress(a2.m184a(), a2.a());
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m184a() {
        return this.f274a;
    }

    public String toString() {
        if (this.a <= 0) {
            return this.f274a;
        }
        return this.f274a + ":" + this.a;
    }
}
