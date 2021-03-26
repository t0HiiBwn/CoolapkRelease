package com.xiaomi.push;

import java.net.InetSocketAddress;

public final class bo {
    private String a;
    private int b;

    public bo(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static bo a(String str, int i) {
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
        return new bo(str, i);
    }

    public static InetSocketAddress b(String str, int i) {
        bo a2 = a(str, i);
        return new InetSocketAddress(a2.b(), a2.a());
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        if (this.b <= 0) {
            return this.a;
        }
        return this.a + ":" + this.b;
    }
}
