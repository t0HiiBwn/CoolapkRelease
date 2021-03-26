package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.b.b;
import com.tencent.beacon.core.b.e;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;

public class UserEventModule extends c {
    private static UserEventModule mInstance;
    private n sensorManager;
    private boolean uploadMode = true;

    public static synchronized UserEventModule getInstance(Context context) {
        UserEventModule userEventModule;
        synchronized (UserEventModule.class) {
            if (mInstance == null) {
                mInstance = new UserEventModule(context);
            }
            userEventModule = mInstance;
        }
        return userEventModule;
    }

    public static synchronized UserEventModule getInstance() {
        UserEventModule userEventModule;
        synchronized (UserEventModule.class) {
            userEventModule = mInstance;
        }
        return userEventModule;
    }

    public void setUploadMode(boolean z) {
        if (z != this.uploadMode) {
            this.uploadMode = z;
            if (z) {
                new g(this.mContext).b();
                startAppLaunched();
                return;
            }
            g.a(this.mContext);
        }
    }

    protected UserEventModule(Context context) {
        super(context);
        b.a(this.mContext);
        d.a();
        this.sensorManager = new n();
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStarted() {
        super.onModuleStarted();
        com.tencent.beacon.core.d.b.b("[event] start userEvent module > heartbeat & launched", new Object[0]);
        new g(this.mContext).b();
        startAppLaunched();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00a1: INVOKE  (r3v4 int) = 
      (wrap: android.content.Context : 0x009f: IGET  (r3v3 android.content.Context) = (r11v0 'this' com.tencent.beacon.core.event.UserEventModule A[IMMUTABLE_TYPE, THIS]) com.tencent.beacon.core.event.UserEventModule.mContext android.content.Context)
     type: STATIC call: com.tencent.beacon.core.b.a.h(android.content.Context):int)] */
    public void startAppLaunched() {
        if (d.a().j()) {
            if (h.a().equals(com.tencent.beacon.core.a.c.a(this.mContext).a("LAUEVE_DENGTA", ""))) {
                com.tencent.beacon.core.d.b.a("[event] AppLaunchedEvent has been uploaded!", new Object[0]);
                return;
            }
        }
        if (e.a(this.mContext) == null) {
            com.tencent.beacon.core.d.b.d("[event] DeviceInfo is null then return", new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("A33", e.j(this.mContext));
        hashMap.put("A133", e.f(this.mContext));
        String str = "Y";
        hashMap.put("A63", str);
        if (a.a(this.mContext)) {
            hashMap.put("A21", str);
        } else {
            hashMap.put("A21", "N");
        }
        if (StrategyQueryModule.getInstance(this.mContext).isAppFirstRun()) {
            hashMap.put("A45", str);
        } else {
            hashMap.put("A45", "N");
        }
        if (a.g(this.mContext)) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a.h(this.mContext));
        hashMap.put("A68", sb.toString());
        if (!a.a) {
            str = "N";
        }
        hashMap.put("A85", str);
        hashMap.put("A9", e.e());
        hashMap.put("A14", e.f());
        hashMap.put("A20", e.g(this.mContext));
        hashMap.put("A69", e.h(this.mContext));
        if (UserAction.onUserAction("rqd_applaunched", true, 0, 0, hashMap, true)) {
            com.tencent.beacon.core.a.c.a(this.mContext).a().a("LAUEVE_DENGTA", (Object) h.a()).b();
        }
        sensorEvent();
    }

    public void onAppResumed() {
        sensorEvent();
    }

    public void sensorEvent() {
        this.sensorManager.a(this.mContext);
    }

    public void onAppStop() {
        n.a();
    }
}
