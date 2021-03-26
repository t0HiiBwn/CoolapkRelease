package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.p;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class UTTracker {
    private static Pattern a = Pattern.compile("(\\|\\||[\t\r\n])+");
    private Map<String, String> D = new HashMap();
    private String am = null;
    private String g;

    void p(String str) {
        this.am = str;
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            i.a("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        } else {
            this.D.put(str, str2);
        }
    }

    public synchronized String getGlobalProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.D.get(str);
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            if (this.D.containsKey(str)) {
                this.D.remove(str);
            }
        }
    }

    private static String e(String str) {
        return (str == null || "".equals(str)) ? str : a.matcher(str).replaceAll("");
    }

    private static String c(String str) {
        return e(str);
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> it2 = map.keySet().iterator();
        if (it2 != null) {
            while (it2.hasNext()) {
                String next = it2.next();
                if (next != null) {
                    hashMap.put(next, c(map.get(next)));
                }
            }
        }
        return hashMap;
    }

    public void send(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.D);
            hashMap.putAll(map);
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(LogField.APPKEY.toString(), this.g);
            }
            Map<String, String> g2 = g((Map<String, String>) hashMap);
            if (!TextUtils.isEmpty(this.am)) {
                g2.put("_track_id", this.am);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(g2);
            d(g2);
            m39g(g2);
            h(g2);
            a.a(g2.remove(LogField.PAGE.toString()), g2.remove(LogField.EVENTID.toString()), g2.remove(LogField.ARG1.toString()), g2.remove(LogField.ARG2.toString()), g2.remove(LogField.ARG3.toString()), g2);
        }
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(LogField.IMEI.toString())) {
                map.remove(LogField.IMEI.toString());
            }
            if (map.containsKey(LogField.IMSI.toString())) {
                map.remove(LogField.IMSI.toString());
            }
            if (map.containsKey(LogField.CARRIER.toString())) {
                map.remove(LogField.CARRIER.toString());
            }
            if (map.containsKey(LogField.ACCESS.toString())) {
                map.remove(LogField.ACCESS.toString());
            }
            if (map.containsKey(LogField.ACCESS_SUBTYPE.toString())) {
                map.remove(LogField.ACCESS_SUBTYPE.toString());
            }
            if (map.containsKey(LogField.CHANNEL.toString())) {
                map.remove(LogField.CHANNEL.toString());
            }
            if (map.containsKey(LogField.LL_USERNICK.toString())) {
                map.remove(LogField.LL_USERNICK.toString());
            }
            if (map.containsKey(LogField.USERNICK.toString())) {
                map.remove(LogField.USERNICK.toString());
            }
            if (map.containsKey(LogField.LL_USERID.toString())) {
                map.remove(LogField.LL_USERID.toString());
            }
            if (map.containsKey(LogField.USERID.toString())) {
                map.remove(LogField.USERID.toString());
            }
            if (map.containsKey(LogField.SDKVERSION.toString())) {
                map.remove(LogField.SDKVERSION.toString());
            }
            if (map.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
                map.remove(LogField.START_SESSION_TIMESTAMP.toString());
            }
            if (map.containsKey(LogField.UTDID.toString())) {
                map.remove(LogField.UTDID.toString());
            }
            if (map.containsKey(LogField.SDKTYPE.toString())) {
                map.remove(LogField.SDKTYPE.toString());
            }
            if (map.containsKey(LogField.RESERVE2.toString())) {
                map.remove(LogField.RESERVE2.toString());
            }
            if (map.containsKey(LogField.RESERVE3.toString())) {
                map.remove(LogField.RESERVE3.toString());
            }
            if (map.containsKey(LogField.RESERVE4.toString())) {
                map.remove(LogField.RESERVE4.toString());
            }
            if (map.containsKey(LogField.RESERVE5.toString())) {
                map.remove(LogField.RESERVE5.toString());
            }
            if (map.containsKey(LogField.RESERVES.toString())) {
                map.remove(LogField.RESERVES.toString());
            }
            if (map.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
                map.remove(LogField.RECORD_TIMESTAMP.toString());
            }
        }
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey("_field_os")) {
                map.remove("_field_os");
                map.put(LogField.OS.toString(), map.get("_field_os"));
            }
            if (map.containsKey("_field_os_version")) {
                map.remove("_field_os_version");
                map.put(LogField.OSVERSION.toString(), map.get("_field_os_version"));
            }
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private static void m39g(Map<String, String> map) {
        map.put(LogField.SDKTYPE.toString(), "mini");
    }

    private static void h(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey("_track_id")) {
            String str = map.get("_track_id");
            map.remove("_track_id");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("_tkid", str);
            }
        }
        if (hashMap.size() > 0) {
            map.put(LogField.RESERVES.toString(), p.d(hashMap));
        }
        if (!map.containsKey(LogField.PAGE.toString())) {
            map.put(LogField.PAGE.toString(), "UT");
        }
    }

    public void pageAppear(Object obj) {
        UTPageHitHelper.getInstance().pageAppear(obj);
    }

    public void pageAppearDonotSkip(Object obj) {
        UTPageHitHelper.getInstance().a(obj, null, true);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        UTPageHitHelper.getInstance().a(obj, str, true);
    }

    public void pageAppear(Object obj, String str) {
        UTPageHitHelper.getInstance().pageAppear(obj, str);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updatePageName(Object obj, String str) {
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }

    protected void q(String str) {
        this.g = str;
    }
}
