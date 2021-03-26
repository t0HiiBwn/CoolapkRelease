package com.alibaba.mtl.log.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetworkUtil */
public class l {
    private static a a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static b f64a = new b();

    /* renamed from: a  reason: collision with other field name */
    private static String[] f65a = {"Unknown", "Unknown"};

    private static String a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    public static String w() {
        NetworkInfo activeNetworkInfo;
        Context context = com.alibaba.mtl.log.a.getContext();
        if (context == null) {
            return "Unknown";
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return a(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable unused) {
        }
        return "Unknown";
    }

    public static boolean isConnected() {
        Context context = com.alibaba.mtl.log.a.getContext();
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String[] getNetworkState(Context context) {
        return f65a;
    }

    public static void b(Context context) {
        if (context != null) {
            context.registerReceiver(f64a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public static void c(Context context) {
        b bVar;
        if (context != null && (bVar = f64a) != null) {
            context.unregisterReceiver(bVar);
        }
    }

    /* compiled from: NetworkUtil */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            r.a().b(l.a.a(context));
        }
    }

    /* compiled from: NetworkUtil */
    private static class a implements Runnable {
        private Context a;

        private a() {
        }

        public a a(Context context) {
            this.a = context;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.a;
            if (context != null) {
                try {
                    if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.a.getPackageName()) != 0) {
                        l.f65a[0] = "Unknown";
                        return;
                    }
                    ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        l.f65a[0] = "Unknown";
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        if (1 == activeNetworkInfo.getType()) {
                            l.f65a[0] = "Wi-Fi";
                        } else if (activeNetworkInfo.getType() == 0) {
                            l.f65a[0] = "2G/3G";
                            l.f65a[1] = activeNetworkInfo.getSubtypeName();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
