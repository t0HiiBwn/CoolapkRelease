package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy */
public final class dh extends dn {
    ByteArrayOutputStream a = new ByteArrayOutputStream();

    public dh() {
    }

    public dh(dn dnVar) {
        super(dnVar);
    }

    @Override // com.amap.api.col.s.dn
    protected final byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.s.dn
    public final void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
