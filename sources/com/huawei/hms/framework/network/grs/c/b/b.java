package com.huawei.hms.framework.network.grs.c.b;

import android.os.Build;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class b {
    private static final String[] a = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};
    private static final String[] b = {"TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"};
    private static final String[] c = {"TLS_RSA", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
    private static final String[] d = {"TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
    private static final String[] e = {"CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static SSLContext a() {
        return SSLContext.getInstance(Build.VERSION.SDK_INT >= 29 ? "TLSv1.3" : Build.VERSION.SDK_INT >= 16 ? "TLSv1.2" : "TLS");
    }

    public static void a(SSLSocket sSLSocket) {
        if (sSLSocket != null && !b(sSLSocket)) {
            c(sSLSocket);
        }
    }

    private static boolean a(SSLSocket sSLSocket, boolean z) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        String[] strArr = z ? Build.VERSION.SDK_INT > 19 ? e : d : c;
        int length = enabledCipherSuites.length;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                break;
            }
            String str = enabledCipherSuites[i];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z2 = false;
                    break;
                } else if (upperCase.contains(strArr[i2].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                arrayList.add(str);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean b(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        Logger.v("SSLUtil", "before filter algriom: " + Arrays.asList(enabledCipherSuites));
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(b);
        List asList2 = Arrays.asList(a);
        for (String str : enabledCipherSuites) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            if (Build.VERSION.SDK_INT > 19) {
                if (!asList.contains(upperCase)) {
                }
            } else if (!asList2.contains(upperCase)) {
            }
            arrayList.add(str);
        }
        Logger.v("SSLUtil", "after filter algriom: " + arrayList);
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean c(SSLSocket sSLSocket) {
        return a(sSLSocket, false);
    }

    public static void d(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
            }
            if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 29) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            } else if (Build.VERSION.SDK_INT < 16) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
        }
    }

    public static void e(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            d(sSLSocket);
            a(sSLSocket);
            Logger.v("SSLUtil", "current platform level is{%d},protocols is{%s} and safeCipherSuites is{%s}", Integer.valueOf(Build.VERSION.SDK_INT), Arrays.toString(sSLSocket.getEnabledProtocols()), Arrays.toString(sSLSocket.getEnabledCipherSuites()));
        }
    }
}
