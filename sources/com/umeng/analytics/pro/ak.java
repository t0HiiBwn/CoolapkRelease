package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.cconfig.UMRemoteConfig;

/* compiled from: ActiveFetchConfigTask */
public class ak implements Runnable {
    private Context a;

    public ak(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            UMRemoteConfig.getInstance().handlerMessage(3, Boolean.valueOf(a()), null);
        } catch (Exception unused) {
        }
    }

    private boolean a() {
        boolean a2;
        try {
            af f = aa.a(this.a).f();
            if (!"0".equals(f.c())) {
                return false;
            }
            String a3 = f.a();
            if (TextUtils.isEmpty(a3) || !(a2 = aa.a(this.a).a(a3))) {
                return false;
            }
            aa.a(this.a).b(a3);
            return a2;
        } catch (Exception unused) {
            return false;
        }
    }
}
