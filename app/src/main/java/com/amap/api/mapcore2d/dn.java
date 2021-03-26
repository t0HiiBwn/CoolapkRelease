package com.amap.api.mapcore2d;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public class dn extends ew {
    private byte[] a;
    private String b = "1";

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> g() {
        return null;
    }

    public dn(byte[] bArr, String str) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
    }

    private String b() {
        byte[] a2 = db.a(dj.b);
        byte[] bArr = new byte[(a2.length + 50)];
        System.arraycopy(this.a, 0, bArr, 0, 50);
        System.arraycopy(a2, 0, bArr, 50, a2.length);
        return cx.a(bArr);
    }

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.a.length));
        return hashMap;
    }

    @Override // com.amap.api.mapcore2d.ew
    public String h() {
        return String.format(db.c(dj.c), "1", this.b, "1", "open", b());
    }

    @Override // com.amap.api.mapcore2d.ew
    public byte[] a_() {
        return this.a;
    }
}
