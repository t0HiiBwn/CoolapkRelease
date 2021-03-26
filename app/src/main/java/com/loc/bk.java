package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy */
public abstract class bk {
    bk c;
    byte[] d = null;

    bk() {
    }

    bk(bk bkVar) {
        this.c = bkVar;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        bk bkVar = this;
        while (true) {
            byte[] a = bkVar.a(bkVar.d);
            bkVar = bkVar.c;
            if (bkVar == null) {
                return a;
            }
            bkVar.d = a;
        }
    }

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] bArr) {
    }
}
