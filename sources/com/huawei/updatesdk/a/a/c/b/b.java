package com.huawei.updatesdk.a.a.c.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class b {
    private static String a = "NetworkUtil";
    private static int b = -1;
    private static int c = -1;
    private static Proxy d;

    private static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (1 == type || 13 == type) {
                return 1;
            }
            if (type == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                }
            }
        }
        return 0;
    }

    public static Proxy a() {
        return d;
    }

    private static void a(int i) {
        c = i;
    }

    private static void a(Proxy proxy) {
        d = proxy;
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    private static boolean a(NetworkInfo networkInfo, Context context) {
        int type = networkInfo.getType();
        boolean b2 = a.b(context);
        if (type != 0 || !b2) {
            return false;
        }
        String host = android.net.Proxy.getHost(context);
        int port = android.net.Proxy.getPort(context);
        Proxy proxy = null;
        if (!(host == null || host.length() <= 0 || port == -1)) {
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
        }
        a(proxy);
        return true;
    }

    public static boolean b(Context context) {
        if (-1 == c) {
            c(context);
        }
        return c == -3;
    }

    public static int c(Context context) {
        if (-1 == b) {
            a.a(a, "getPsType() need init");
            if (context != null) {
                e(context);
            }
        }
        return b;
    }

    public static Proxy d(Context context) {
        if (b(context)) {
            return a();
        }
        return null;
    }

    private static void e(Context context) {
        a(0);
        NetworkInfo f = f(context);
        if (f == null) {
            a.a(a, "setPsType() info = null");
            return;
        }
        int a2 = a(f);
        b = a2;
        if (1 != a2) {
            a(a(f, context) ? -3 : -2);
        }
    }

    private static NetworkInfo f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }
}
