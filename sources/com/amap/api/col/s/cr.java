package com.amap.api.col.s;

import java.util.Map;

/* compiled from: ADIURequest */
public final class cr extends cy {
    private byte[] a;
    private Map<String, String> b;

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    public cr(byte[] bArr, Map<String, String> map) {
        this.a = bArr;
        this.b = map;
    }

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> e() {
        return this.b;
    }

    @Override // com.amap.api.col.s.cy
    public final byte[] g() {
        return this.a;
    }
}
