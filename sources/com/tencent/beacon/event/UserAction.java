package com.tencent.beacon.event;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tencent.beacon.cover.UserActionProxy;
import com.tencent.beacon.cover.g;
import com.tencent.beacon.cover.h;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserAction {
    private static boolean a = false;
    private static boolean b = false;
    private static Context c = null;
    private static boolean d = true;
    private static long e;
    private static InitHandleListener f;
    private static UploadHandleListener g;
    private static Boolean h;
    private static Boolean i;
    private static Boolean j;
    private static String k;

    /* renamed from: l  reason: collision with root package name */
    private static String f1428l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static Boolean r;
    private static long s;
    private static Map<String, String> t;
    private static final List<a> u = Collections.synchronizedList(new ArrayList());
    private static final List<TunnelInfo> v = Collections.synchronizedList(new ArrayList());
    private static final List<a<Map<String, String>>> w = Collections.synchronizedList(new ArrayList());
    private static final List<a<String>> x = Collections.synchronizedList(new ArrayList());
    private static ClassLoader y;
    private static UserActionProxy z;

    public static String getSDKVersion() {
        return "3.1.2";
    }

    @Deprecated
    public static void setSDKVersion(String str) {
    }

    @Deprecated
    public static boolean testSpeedDomain(List<String> list) {
        return false;
    }

    @Deprecated
    public static boolean testSpeedIp(List<String> list) {
        return false;
    }

    public static void onCompLoaded(ClassLoader classLoader) {
        if (y == null) {
            y = classLoader;
            if (a() && c != null) {
                if (!a) {
                    b();
                }
                initUserAction(c, d, e, f, g);
                if (!a) {
                    c();
                }
                a = true;
                c = null;
            }
        }
    }

    private static boolean a() {
        if (z != null) {
            return true;
        }
        ClassLoader classLoader = y;
        if (classLoader == null) {
            return false;
        }
        try {
            z = (UserActionProxy) classLoader.loadClass("com.tencent.beacon.core.UserActionProxyImpl").newInstance();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (z != null) {
            return true;
        }
        return false;
    }

    private static void b() {
        String str;
        if (z != null) {
            Boolean bool = h;
            if (!(bool == null || j == null)) {
                setLogAble(bool.booleanValue(), j.booleanValue());
                h = null;
                j = null;
            }
            Boolean bool2 = i;
            if (bool2 != null) {
                enablePagePath(bool2.booleanValue());
                i = null;
            }
            List<a<Map<String, String>>> list = w;
            if (list != null) {
                for (a<Map<String, String>> aVar : list) {
                    setAdditionalInfo(aVar.a, aVar.b);
                }
                w.clear();
            }
            String str2 = k;
            if (str2 != null) {
                setAppkey(str2);
                k = null;
            }
            String str3 = f1428l;
            if (str3 != null) {
                setAppVersion(str3);
                f1428l = null;
            }
            String str4 = m;
            if (str4 != null) {
                setChannelID(str4);
                m = null;
            }
            String str5 = n;
            if (str5 != null) {
                setQQ(str5);
                n = null;
            }
            List<a<String>> list2 = x;
            if (list2 != null) {
                for (a<String> aVar2 : list2) {
                    setUserID(aVar2.a, aVar2.b);
                }
                x.clear();
            }
            String str6 = q;
            if (str6 != null) {
                b(str6);
                q = null;
            }
            String str7 = o;
            if (!(str7 == null || (str = p) == null)) {
                setReportDomain(str7, str);
                o = null;
                p = null;
            }
        }
    }

    private static void c() {
        Boolean bool = r;
        if (bool != null) {
            loginEvent(bool.booleanValue(), s, t);
            r = null;
            t = null;
        }
        List<a> list = u;
        synchronized (list) {
            for (a aVar : list) {
                onUserAction(aVar.a, aVar.b, aVar.c, 0, aVar.d, aVar.e, aVar.f);
            }
            u.clear();
        }
        List<TunnelInfo> list2 = v;
        synchronized (list2) {
            for (TunnelInfo tunnelInfo : list2) {
                registerTunnel(tunnelInfo);
            }
            v.clear();
        }
    }

    public static void initUserAction(Context context) {
        initUserAction(context, true);
    }

    public static void initUserAction(Context context, boolean z2) {
        initUserAction(context, z2, 0);
    }

    public static void initUserAction(Context context, boolean z2, long j2) {
        initUserAction(context, z2, j2, null);
    }

    public static void initUserAction(Context context, boolean z2, long j2, InitHandleListener initHandleListener) {
        initUserAction(context, z2, j2, initHandleListener, null);
    }

    public static void initUserAction(Context context, boolean z2, long j2, InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) {
        if (z != null) {
            if (!a) {
                b();
            }
            z.initUserAction(context, z2, j2, initHandleListener, uploadHandleListener);
            if (!a) {
                c();
            }
            a = true;
            return;
        }
        if (!b) {
            new Thread(h.a(context)).start();
            b = true;
        }
        c = context;
        d = z2;
        e = j2;
        f = initHandleListener;
        g = uploadHandleListener;
    }

    public static boolean onUserAction(String str, boolean z2, long j2, long j3, Map<String, String> map, boolean z3) {
        return onUserAction(str, z2, j2, j3, map, z3, false);
    }

    public static boolean onUserAction(String str, boolean z2, long j2, long j3, Map<String, String> map, boolean z3, boolean z4) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            return userActionProxy.onUserAction(str, z2, j2, j3, map, z3, z4);
        }
        a aVar = new a((byte) 0);
        aVar.a = str;
        aVar.b = z2;
        aVar.c = j2;
        aVar.d = map;
        aVar.e = z3;
        aVar.f = z4;
        List<a> list = u;
        synchronized (list) {
            if (list.size() < 100) {
                list.add(aVar);
            }
        }
        return false;
    }

    public static boolean loginEvent(boolean z2, long j2, Map<String, String> map) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            return userActionProxy.loginEvent(z2, j2, map);
        }
        r = Boolean.valueOf(z2);
        s = j2;
        t = map;
        return false;
    }

    public static void setLogAble(boolean z2, boolean z3) {
        g.a = z2;
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setLogAble(z2, z3);
            return;
        }
        h = Boolean.valueOf(z2);
        j = Boolean.valueOf(z3);
    }

    public static void enablePagePath(boolean z2) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.enablePagePath(z2);
        } else {
            i = Boolean.valueOf(z2);
        }
    }

    public static String getQIMEI() {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            return userActionProxy.getQIMEI();
        }
        Context context = c;
        return context != null ? getRtQIMEI(context) : "";
    }

    public static String getRtQIMEI(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DENGTA_META", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("QIMEI_DENGTA", "");
        }
        return "";
    }

    public static void setUploadMode(boolean z2) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setUploadMode(z2);
        }
    }

    public static void setAppKey(String str) {
        h.a = str;
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setAppKey(str);
        } else {
            k = str;
        }
    }

    public static void setAppVersion(String str) {
        h.b = str;
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setAppVersion(str);
        } else {
            f1428l = str;
        }
    }

    public static void setChannelID(String str) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setChannelID(str);
        } else {
            m = str;
        }
    }

    public static void setUserID(String str) {
        setUserID(null, str);
    }

    public static void setUserID(String str, String str2) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setUserID(str, str2);
        } else {
            x.add(new a<>(str, str2));
        }
    }

    public static void setQQ(String str) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setQQ(str);
        } else {
            n = str;
        }
    }

    public static void setAdditionalInfo(Map<String, String> map) {
        setAdditionalInfo(null, map);
    }

    public static void setAdditionalInfo(String str, Map<String, String> map) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setAdditionalInfo(str, map);
        } else {
            w.add(new a<>(str, map));
        }
    }

    public static void doUploadRecords() {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.doUploadRecords();
        }
    }

    public static void flushObjectsToDB(boolean z2) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.flushObjectsToDB(z2);
        }
    }

    public static String getCloudParas(String str) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            return userActionProxy.getCloudParas(str);
        }
        return null;
    }

    public static void setReportDomain(String str, String str2) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setReportDomain(str, str2);
            return;
        }
        o = str;
        p = str2;
    }

    @Deprecated
    public static void setAPPVersion(String str) {
        h.b = str;
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setAPPVersion(str);
        } else {
            f1428l = str;
        }
    }

    @Deprecated
    public static void setAppkey(String str) {
        h.a = str;
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setAppkey(str);
        } else {
            k = str;
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.setJsClientId(str);
        } else {
            q = str;
        }
    }

    public static void configBeaconJs(WebView webView) {
        if (webView != null) {
            webView.addJavascriptInterface(new BeaconJsBridge(), "beacon");
            webView.getSettings().setDomStorageEnabled(true);
        }
    }

    private static class BeaconJsBridge {
        private BeaconJsBridge() {
        }

        @JavascriptInterface
        public void onSetJsClientID(String str) {
            UserAction.b(str);
        }
    }

    private static class a {
        String a;
        boolean b;
        long c;
        Map<String, String> d;
        boolean e;
        boolean f;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void onPageIn(String str) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.onPageIn(str);
        }
    }

    public static void onPageOut(String str) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.onPageOut(str);
        }
    }

    public static boolean onUserActionToTunnel(String str, String str2, boolean z2, long j2, long j3, Map<String, String> map, boolean z3, boolean z4) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            return userActionProxy.onUserActionToTunnel(str, str2, z2, j2, j3, map, z3, z4);
        }
        return false;
    }

    public static boolean onUserActionToTunnel(String str, String str2, Map<String, String> map, boolean z2, boolean z3) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            return userActionProxy.onUserActionToTunnel(str, str2, map, z2, z3);
        }
        return false;
    }

    public static boolean onUserAction(String str, Map<String, String> map, boolean z2, boolean z3) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            return userActionProxy.onUserAction(str, map, z2, z3);
        }
        return false;
    }

    public static void registerTunnel(TunnelInfo tunnelInfo) {
        UserActionProxy userActionProxy = z;
        if (userActionProxy != null) {
            userActionProxy.registerTunnel(tunnelInfo);
            return;
        }
        List<TunnelInfo> list = v;
        synchronized (list) {
            list.add(tunnelInfo);
        }
    }
}
