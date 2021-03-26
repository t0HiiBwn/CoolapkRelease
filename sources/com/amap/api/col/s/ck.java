package com.amap.api.col.s;

/* compiled from: ADDNumEncryptProcessor */
public final class ck extends cm {
    ck() {
    }

    public ck(cm cmVar) {
        super(cmVar);
    }

    @Override // com.amap.api.col.s.cm
    protected final byte[] a(byte[] bArr) {
        return bs.a(bs.a(bArr) + "||1");
    }
}
