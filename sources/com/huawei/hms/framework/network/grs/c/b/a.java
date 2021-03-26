package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLSocketFactory;

public class a {
    public static SSLSocketFactory a(Context context) {
        try {
            return c.a(context, "grs_sp.bks");
        } catch (IOException e) {
            throw new AssertionError(e);
        } catch (CertificateException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        } catch (KeyStoreException e5) {
            throw new AssertionError(e5);
        } catch (KeyManagementException e6) {
            throw new AssertionError(e6);
        }
    }
}
