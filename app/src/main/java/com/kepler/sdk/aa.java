package com.kepler.sdk;

import android.content.Context;
import com.kepler.jd.login.KeplerApiManager;

public class aa {
    public static Context a() {
        return KeplerApiManager.getWebViewService().getApplicatonContext();
    }
}
