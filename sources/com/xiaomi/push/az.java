package com.xiaomi.push;

public class az implements bb {
    private final String a;
    private final String b;

    public az(String str, String str2) {
        if (str != null) {
            this.a = str;
            this.b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    @Override // com.xiaomi.push.bb
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.bb
    public String b() {
        return this.b;
    }
}
