package com.ali.auth.third.ut;

import android.app.Application;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import java.util.HashMap;
import java.util.Map;

public class UserTrackerImpl implements UserTrackerService {
    public UserTrackerImpl() {
        try {
            UTAnalytics.getInstance().setContext(KernelContext.context);
            UTAnalytics.getInstance().setAppApplicationInstance((Application) KernelContext.context.getApplicationContext());
            UTAnalytics.getInstance().setRequestAuthentication(new UTSecuritySDKRequestAuthentication(KernelContext.getAppKey(), ""));
            a();
        } catch (Exception unused) {
        }
    }

    private void a() {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("80001");
        HashMap hashMap = new HashMap();
        hashMap.put("model", "auth");
        hashMap.put("version", ConfigManager.SDK_VERSION.toString());
        uTCustomHitBuilder.setProperties(hashMap);
        UTAnalytics.getInstance().getTracker("25").send(uTCustomHitBuilder.build());
    }

    private static Map<String, String> b() {
        return new HashMap();
    }

    @Override // com.ali.auth.third.core.service.UserTrackerService
    public void send(String str, Map<String, String> map) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str);
        Map<String, String> b = b();
        if (map != null) {
            b.putAll(map);
        }
        uTCustomHitBuilder.setProperties(b);
        UTAnalytics.getInstance().getTracker("onesdk").send(uTCustomHitBuilder.build());
    }
}
