package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class j {
    private static final String TAG = "X509CertificateUtil";
    private static final String an = "052root";
    private static final String ao = "hmsincas.bks";
    private static final String ap = "huawei cbg application integration ca";
    private static final String b = "bks";
    private static final String k = "hmsrootcas.bks";
    private static final String l = "";
    private Context u;

    public j(Context context) {
        this.u = context;
    }

    public X509Certificate f(String str, String str2) {
        Throwable th;
        Exception e;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            KeyStore instance = KeyStore.getInstance("bks");
            inputStream = this.u.getAssets().open(str);
            try {
                inputStream.reset();
                instance.load(inputStream, "".toCharArray());
                X509Certificate x509Certificate = (X509Certificate) instance.getCertificate(str2);
                f.c(inputStream);
                return x509Certificate;
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                e = e2;
                try {
                    g.e("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    f.c(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    f.c(inputStream2);
                    throw th;
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e3) {
            e = e3;
            inputStream = null;
            g.e("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            f.c(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            f.c(inputStream2);
            throw th;
        }
    }

    public X509Certificate l() {
        return f("hmsrootcas.bks", "052root");
    }

    public X509Certificate m() {
        return f("hmsincas.bks", "huawei cbg application integration ca");
    }
}
