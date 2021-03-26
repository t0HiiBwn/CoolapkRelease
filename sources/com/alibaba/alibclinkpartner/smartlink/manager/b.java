package com.alibaba.alibclinkpartner.smartlink.manager;

import com.alibaba.alibclinkpartner.smartlink.b.a.a;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.e;
import java.util.Map;

public class b {
    private static boolean a = true;
    private static boolean b;

    public static void a(a aVar) {
        com.alibaba.alibclinkpartner.smartlink.a.a(new c(aVar));
    }

    /* access modifiers changed from: private */
    public static synchronized boolean b() {
        boolean z;
        synchronized (b.class) {
            if (a) {
                try {
                    Class.forName("com.ut.mini.UTAnalytics");
                    b = true;
                } catch (Exception e) {
                    ALSLLogUtil.e("ALSLUserTraceManager", "isUTExsist", "ut do not exist , errmsg =" + e.toString());
                    b = false;
                }
                a = false;
            }
            z = b;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static void d(a aVar) {
        Object a2 = e.a("com.ut.mini.UTHitBuilders$UTCustomHitBuilder", new String[]{"java.lang.String"}, new Object[]{aVar.a()});
        e.a("com.ut.mini.UTHitBuilders$UTCustomHitBuilder", "setProperties", new String[]{"java.util.Map"}, a2, new Object[]{aVar.b()});
        e.a("com.ut.mini.UTTracker", "send", new String[]{"java.util.Map"}, e.a("com.ut.mini.UTAnalytics", "getTracker", new String[]{"java.lang.String"}, e.a("com.ut.mini.UTAnalytics", "getInstance", null, null, null), new String[]{"ALPLinkPartnerSDK"}), new Object[]{(Map) e.a("com.ut.mini.UTHitBuilders$UTCustomHitBuilder", "build", null, a2, null)});
    }

    /* access modifiers changed from: private */
    public static void e(a aVar) {
        com.alibaba.alibclinkpartner.smartlink.b.a a2 = com.alibaba.alibclinkpartner.smartlink.b.a.a();
        a2.a(aVar.a());
        a2.a(aVar.b());
        a2.b();
    }
}
