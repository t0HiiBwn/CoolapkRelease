package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class df implements Application.ActivityLifecycleCallbacks {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private String f315a = "";
    private String b;

    public df(Context context, String str) {
        this.a = context;
        this.f315a = str;
    }

    private void a(String str) {
        hk hkVar = new hk();
        hkVar.a(str);
        hkVar.a(System.currentTimeMillis());
        hkVar.a(he.ActivityActiveTimeStamp);
        ds.a(this.a, hkVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!TextUtils.isEmpty(this.f315a) && !TextUtils.isEmpty(localClassName)) {
            this.b = "";
            if (TextUtils.isEmpty("") || TextUtils.equals(this.b, localClassName)) {
                a(this.a.getPackageName() + "|" + localClassName + ":" + this.f315a + "," + String.valueOf(System.currentTimeMillis() / 1000));
                this.f315a = "";
                this.b = "";
                return;
            }
            this.f315a = "";
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.f315a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
