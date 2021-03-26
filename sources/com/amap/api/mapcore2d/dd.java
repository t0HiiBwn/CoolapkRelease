package com.amap.api.mapcore2d;

/* compiled from: ADDNumEncryptProcessor */
public class dd extends df {
    dd() {
    }

    public dd(df dfVar) {
        super(dfVar);
    }

    @Override // com.amap.api.mapcore2d.df
    protected byte[] a(byte[] bArr) {
        return db.a(db.a(bArr) + "||1");
    }
}
