package com.xiaomi.push;

public class x implements z {
    private final String a;
    private final String b;

    public x(String str, String str2) {
        if (str != null) {
            this.a = str;
            this.b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    @Override // com.xiaomi.push.z
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.z
    public String b() {
        return this.b;
    }
}
