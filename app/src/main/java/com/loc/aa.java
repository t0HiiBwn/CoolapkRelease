package com.loc;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public final class aa extends q {
    private byte[] a;
    private String b = "1";

    public aa(byte[] bArr, String str) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
    }

    @Override // com.loc.av
    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.a.length));
        return hashMap;
    }

    @Override // com.loc.av
    public final Map<String, String> b_() {
        return null;
    }

    @Override // com.loc.av
    public final String c() {
        String c = u.c(v.b);
        byte[] a2 = u.a(v.a);
        byte[] bArr = new byte[(a2.length + 50)];
        System.arraycopy(this.a, 0, bArr, 0, 50);
        System.arraycopy(a2, 0, bArr, 50, a2.length);
        return String.format(c, "1", this.b, "1", "open", r.a(bArr));
    }

    @Override // com.loc.av
    public final byte[] e() {
        return this.a;
    }
}
