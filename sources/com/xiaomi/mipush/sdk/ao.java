package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;

class ao implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ an f126a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f127a;

    ao(an anVar, String[] strArr, Context context) {
        this.f126a = anVar;
        this.f127a = strArr;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        while (true) {
            try {
                String[] strArr = this.f127a;
                if (i < strArr.length) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        if (i > 0) {
                            Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        }
                        PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.f127a[i], 4);
                        if (packageInfo != null) {
                            this.f126a.a(this.a, packageInfo);
                        }
                    }
                    i++;
                } else {
                    return;
                }
            } catch (Throwable th) {
                c.a(th);
                return;
            }
        }
    }
}
