package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.cf;
import com.bytedance.embedapplog.cl;
import com.bytedance.embedapplog.cn;

final class bz implements cf {
    private static final bs<Boolean> a = new bs<Boolean>() {
        /* class com.bytedance.embedapplog.bz.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf(by.a((Context) objArr[0], "com.huawei.hwid"));
        }
    };

    bz() {
    }

    static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return a.b(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.cf
    public boolean a(Context context) {
        return c(context);
    }

    /* renamed from: d */
    public a b(Context context) {
        a aVar = new a();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    aVar.b = string;
                    aVar.c = Boolean.parseBoolean(string2);
                    aVar.a = 202003021704L;
                    return aVar;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Pair<String, Boolean> f = f(context);
        if (f != null) {
            aVar.b = (String) f.first;
            aVar.c = ((Boolean) f.second).booleanValue();
            aVar.a = (long) e(context);
        }
        return aVar;
    }

    private static int e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private static Pair<String, Boolean> f(Context context) {
        return (Pair) new cn(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new cn.b<cl, Pair<String, Boolean>>() {
            /* class com.bytedance.embedapplog.bz.AnonymousClass2 */

            /* renamed from: a */
            public cl b(IBinder iBinder) {
                return cl.a.a(iBinder);
            }

            public Pair<String, Boolean> a(cl clVar) {
                if (clVar == null) {
                    return null;
                }
                return new Pair<>(clVar.a(), Boolean.valueOf(clVar.b()));
            }
        }).a();
    }

    static class a extends cf.a {
        long a = 0;

        a() {
        }
    }
}
