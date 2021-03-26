package com.amap.api.col.s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy */
public abstract class dn {
    dn c;
    byte[] d = null;

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] bArr) {
    }

    dn() {
    }

    dn(dn dnVar) {
        this.c = dnVar;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        dn dnVar = this;
        while (true) {
            byte[] a = dnVar.a(dnVar.d);
            dnVar = dnVar.c;
            if (dnVar == null) {
                return a;
            }
            dnVar.d = a;
        }
    }
}
