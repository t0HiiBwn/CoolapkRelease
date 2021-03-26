package com.bytedance.tea.crash.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.tea.crash.upload.b;

/* compiled from: Net */
public final class i {
    public static String a(Context context) {
        return a(c(context));
    }

    /* renamed from: com.bytedance.tea.crash.g.i$1  reason: invalid class name */
    /* compiled from: Net */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.EnumC0070b.values().length];
            a = iArr;
            try {
                iArr[b.EnumC0070b.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.EnumC0070b.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.EnumC0070b.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.EnumC0070b.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.EnumC0070b.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String a(b.EnumC0070b bVar) {
        String str;
        try {
            int i = AnonymousClass1.a[bVar.ordinal()];
            if (i == 1) {
                str = "wifi";
            } else if (i == 2) {
                str = "2g";
            } else if (i == 3) {
                str = "3g";
            } else if (i == 4) {
                str = "4g";
            } else if (i != 5) {
                return "";
            } else {
                str = "mobile";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    private static b.EnumC0070b c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return b.EnumC0070b.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return b.EnumC0070b.WIFI;
                    }
                    if (type != 0) {
                        return b.EnumC0070b.MOBILE;
                    }
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return b.EnumC0070b.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return b.EnumC0070b.MOBILE;
                        case 13:
                            return b.EnumC0070b.MOBILE_4G;
                    }
                }
            }
            return b.EnumC0070b.NONE;
        } catch (Throwable unused) {
            return b.EnumC0070b.MOBILE;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
