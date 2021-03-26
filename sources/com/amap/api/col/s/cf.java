package com.amap.api.col.s;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public final class cf extends bp {
    private byte[] a;
    private String b = "1";

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> e() {
        return null;
    }

    public cf(byte[] bArr, String str) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
    }

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.a.length));
        return hashMap;
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        String c = bs.c(cc.b);
        byte[] a2 = bs.a(cc.a);
        byte[] bArr = new byte[(a2.length + 50)];
        System.arraycopy(this.a, 0, bArr, 0, 50);
        System.arraycopy(a2, 0, bArr, 50, a2.length);
        return String.format(c, "1", this.b, "1", "open", bq.a(bArr));
    }

    @Override // com.amap.api.col.s.cy
    public final byte[] g() {
        return this.a;
    }
}
