package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

final class u implements Runnable {
    final /* synthetic */ Context a;

    u(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 4612);
            t.c(this.a);
            t.d(this.a, packageInfo);
            t.c(this.a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
