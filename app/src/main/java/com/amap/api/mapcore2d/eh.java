package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.mapcore2d.eb;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* compiled from: Utils */
public class eh {
    private static boolean a(dt dtVar, ea eaVar) {
        try {
            List<ee> a = eb.a.a(dtVar, eaVar.c, "used");
            if (a == null || a.size() <= 0 || a(a.get(0).e(), eaVar.e) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            a(th, "dDownLoad", "isUsed");
        }
    }

    static boolean a(Context context, ea eaVar, da daVar) {
        dt dtVar = new dt(context, ed.c());
        if (a(dtVar, eaVar)) {
            return true;
        }
        ee a = eb.a.a(dtVar, eaVar.b);
        if (a != null) {
            return a(context, dtVar, a, eaVar, daVar);
        }
        return false;
    }

    private static boolean a(final Context context, final dt dtVar, ee eeVar, ea eaVar, final da daVar) {
        String str = eaVar.c;
        String str2 = eaVar.d;
        final String str3 = eaVar.e;
        if ("errorstatus".equals(eeVar.f())) {
            a(context, dtVar, daVar);
            return true;
        }
        final String a = eb.a(context, eaVar.b);
        if (!new File(a).exists()) {
            return false;
        }
        List b = dtVar.b(ee.a(eb.a(context, str, str2), str, str2, str3), ee.class);
        if (b != null && b.size() > 0) {
            return true;
        }
        eb.a(context, str, daVar.b());
        try {
            eg.b().a().submit(new Runnable() {
                /* class com.amap.api.mapcore2d.eh.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        eb.a(context, dtVar, daVar, a, str3);
                        eb.a(context, daVar);
                    } catch (Throwable th) {
                        eh.a(th, "dDownLoad", "processDownloadedFile()");
                    }
                }
            });
        } catch (Throwable unused) {
        }
        return true;
    }

    private static void a(final Context context, dt dtVar, final da daVar) {
        try {
            if (!new File(eb.b(context, daVar.a(), daVar.b())).exists() && !TextUtils.isEmpty(eb.a(context, dtVar, daVar))) {
                eg.b().a().submit(new Runnable() {
                    /* class com.amap.api.mapcore2d.eh.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            eb.a(context, daVar);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    static boolean a(Context context) {
        return cu.r(context) == 1;
    }

    static boolean a(Context context, boolean z) {
        return z || a(context);
    }

    static boolean a(ea eaVar) {
        return Build.VERSION.SDK_INT >= eaVar.g && Build.VERSION.SDK_INT <= eaVar.f;
    }

    static boolean a(da daVar, ea eaVar) {
        return daVar != null && daVar.a().equals(eaVar.c) && daVar.b().equals(eaVar.d);
    }

    static boolean a(Context context, da daVar, ea eaVar) {
        if (eaVar.e()) {
            return true;
        }
        return !db.a(context, eaVar.f());
    }

    static PublicKey a() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(cv.b("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
            try {
                PublicKey publicKey = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                try {
                    a(byteArrayInputStream);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return publicKey;
            } catch (Throwable th3) {
                th = th3;
                try {
                    a(th, "DyLoader", "init");
                    try {
                        a(byteArrayInputStream);
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    return null;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
            a(th, "DyLoader", "init");
            a(byteArrayInputStream);
            return null;
        }
        throw th;
    }

    public static int a(String str, String str2) {
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            int i = 0;
            for (int i2 = 0; i2 < min; i2++) {
                i = split[i2].length() - split2[i2].length();
                if (!(i == 0 && (i = split[i2].compareTo(split2[i2])) == 0)) {
                    break;
                }
            }
            return i != 0 ? i : split.length - split2.length;
        } catch (Exception e) {
            dl.a(e, "Utils", "compareVersion");
            return -1;
        }
    }

    static void a(List<ee> list) {
        int i = 0;
        while (i < list.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                ee eeVar = list.get(i);
                ee eeVar2 = list.get(i3);
                if (a(eeVar2.e(), eeVar.e()) > 0) {
                    list.set(i, eeVar2);
                    list.set(i3, eeVar);
                }
            }
            i = i2;
        }
    }

    static boolean b(String str, String str2) {
        String a = cx.a(str);
        return a != null && a.equalsIgnoreCase(str2);
    }

    static boolean a(Context context, dt dtVar, String str, da daVar) {
        return a(dtVar, str, eb.a(context, str), daVar);
    }

    static boolean a(dt dtVar, String str, String str2, da daVar) {
        ee a = eb.a.a(dtVar, str);
        if (a == null || !daVar.b().equals(a.d()) || !b(str2, a.b())) {
            return false;
        }
        return true;
    }

    public static void a(Throwable th, String str, String str2) {
        dl.a(th, str, str2);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
