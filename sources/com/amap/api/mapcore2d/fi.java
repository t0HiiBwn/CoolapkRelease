package com.amap.api.mapcore2d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy */
public class fi extends fo {
    ByteArrayOutputStream a = new ByteArrayOutputStream();

    public fi() {
    }

    public fi(fo foVar) {
        super(foVar);
    }

    @Override // com.amap.api.mapcore2d.fo
    protected byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.mapcore2d.fo
    public void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
