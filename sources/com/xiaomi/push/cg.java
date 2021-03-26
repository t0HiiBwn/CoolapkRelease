package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class cg implements Application.ActivityLifecycleCallbacks {
    private String a = "";
    private String b;
    private Context c;

    public cg(Context context, String str) {
        this.c = context;
        this.a = str;
    }

    private void a(String str) {
        gq gqVar = new gq();
        gqVar.a(str);
        gqVar.a(System.currentTimeMillis());
        gqVar.a(gk.ActivityActiveTimeStamp);
        cw.a(this.c, gqVar);
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
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(localClassName)) {
            this.b = "";
            if (TextUtils.isEmpty("") || TextUtils.equals(this.b, localClassName)) {
                a(this.c.getPackageName() + "|" + localClassName + ":" + this.a + "," + String.valueOf(System.currentTimeMillis() / 1000));
                this.a = "";
                this.b = "";
                return;
            }
            this.a = "";
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.a = String.valueOf(System.currentTimeMillis() / 1000);
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
