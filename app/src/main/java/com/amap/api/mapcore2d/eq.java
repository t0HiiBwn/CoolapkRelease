package com.amap.api.mapcore2d;

import java.util.Map;

/* compiled from: ADIURequest */
public class eq extends ew {
    private byte[] a;
    private Map<String, String> b;

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.mapcore2d.ew
    public String h() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    public eq(byte[] bArr, Map<String, String> map) {
        this.a = bArr;
        this.b = map;
    }

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> g() {
        return this.b;
    }

    @Override // com.amap.api.mapcore2d.ew
    public byte[] a_() {
        return this.a;
    }
}
