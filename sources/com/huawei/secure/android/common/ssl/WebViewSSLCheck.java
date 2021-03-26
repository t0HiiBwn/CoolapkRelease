package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.WebViewSSLCheckThread;
import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import java.security.cert.X509Certificate;

public class WebViewSSLCheck {
    private static final String TAG = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, null, context, null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        String str2 = TAG;
        g.c(str2, " error type : " + sslError.getPrimaryError());
        X509Certificate a = b.a(sslError.getCertificate());
        X509Certificate m = new j(context).m();
        g.b(str2, "checkServerCertificateNew: error certificate is : " + a);
        if (b.a(m, a)) {
            g.c(str2, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
            } else {
                sslErrorHandler.proceed();
            }
        } else {
            g.e(str2, "checkServerCertificateNew: cancel");
            if (callback != null) {
                callback.onCancel(context, str);
            } else {
                sslErrorHandler.cancel();
            }
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return b.a(x509Certificate, b.a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(b.d(str), sslError);
    }
}
