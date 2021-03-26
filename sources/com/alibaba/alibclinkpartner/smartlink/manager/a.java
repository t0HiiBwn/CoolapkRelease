package com.alibaba.alibclinkpartner.smartlink.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;

public class a implements Application.ActivityLifecycleCallbacks {
    private boolean a = true;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (!this.a) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "setVisible", "切到前台");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        boolean b = com.alibaba.alibclinkpartner.smartlink.util.a.b((Context) activity);
        this.a = b;
        if (!b) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "setVisible", "app在后台，拉取数据");
            ALSLSmartLinkSDK.getSmartLinkSwitch();
        }
    }
}
