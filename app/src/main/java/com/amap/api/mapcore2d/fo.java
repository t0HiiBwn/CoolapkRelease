package com.amap.api.mapcore2d;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy */
public abstract class fo {
    fo c;
    byte[] d = null;

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] bArr) {
    }

    fo() {
    }

    fo(fo foVar) {
        this.c = foVar;
    }

    public byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] a = a(this.d);
        fo foVar = this.c;
        if (foVar == null) {
            return a;
        }
        foVar.c(a);
        return this.c.a();
    }

    void c(byte[] bArr) {
        this.d = bArr;
    }
}
