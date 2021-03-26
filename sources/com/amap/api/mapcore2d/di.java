package com.amap.api.mapcore2d;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: RSAAESEncryptProcessor */
public class di extends df {
    public di() {
    }

    public di(df dfVar) {
        super(dfVar);
    }

    @Override // com.amap.api.mapcore2d.df
    protected byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return cv.a(bArr);
    }
}
