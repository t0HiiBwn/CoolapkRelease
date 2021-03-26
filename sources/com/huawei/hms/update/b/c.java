package com.huawei.hms.update.b;

import android.content.Context;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HttpsUtils */
public final class c {
    public static void a(HttpsURLConnection httpsURLConnection, Context context) {
        SocketFactory a = f.a(context);
        if (a instanceof SSLSocketFactory) {
            httpsURLConnection.setSSLSocketFactory((SSLSocketFactory) a);
        }
    }
}
