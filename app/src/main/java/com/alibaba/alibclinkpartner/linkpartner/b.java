package com.alibaba.alibclinkpartner.linkpartner;

import android.app.Application;
import android.content.Context;
import com.alibaba.alibclinkpartner.linkpartner.param.ALPJumpFailedStrategy;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;

public class b {
    public static synchronized int init(Application application) {
        int init;
        synchronized (b.class) {
            init = init(application, null);
        }
        return init;
    }

    public static synchronized int init(Application application, String str) {
        int init;
        synchronized (b.class) {
            init = ALSLSmartLinkSDK.init(application, str);
        }
        return init;
    }

    public static void jumpApp(Context context, ALPTBJumpParam aLPTBJumpParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a.a(context, aLPTBJumpParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }
}
