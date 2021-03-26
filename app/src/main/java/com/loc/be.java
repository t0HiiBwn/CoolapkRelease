package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy */
public final class be extends bk {
    ByteArrayOutputStream a = new ByteArrayOutputStream();

    public be() {
    }

    public be(bk bkVar) {
        super(bkVar);
    }

    @Override // com.loc.bk
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

    @Override // com.loc.bk
    public final void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
