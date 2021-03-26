package com.bytedance.sdk.openadsdk.core;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.e;
import com.bytedance.sdk.openadsdk.utils.j;
import com.pgl.sys.ces.out.ISdkInfo;
import com.pgl.sys.ces.out.ISdkLite;
import com.pgl.sys.ces.out.StcSDKLiteFactory;
import java.util.HashMap;
import java.util.List;

/* compiled from: SecSdkHelperInner */
public class t {
    private static t a;
    private ISdkLite b = StcSDKLiteFactory.getSDK(p.a(), "df979cdb-05a7-448c-bece-92d5005a1247", 0, c());
    private volatile boolean c = false;
    private String d = null;

    private t(String str) {
        this.d = str;
        if (!TextUtils.isEmpty(str)) {
            this.b.setParams(str, null);
        }
        if (i.d().f() != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("app_id", i.d().f());
            this.b.setCustomInfo(hashMap);
        }
    }

    private ISdkInfo c() {
        final TTCustomController e = i.d().e();
        return new ISdkInfo() {
            /* class com.bytedance.sdk.openadsdk.core.t.AnonymousClass1 */

            @Override // com.pgl.sys.ces.out.ISdkInfo
            public String getDeviceId() {
                return "";
            }

            @Override // com.pgl.sys.ces.out.ISdkInfo
            public String getSubscriberId() {
                TTCustomController tTCustomController = e;
                if (tTCustomController == null || tTCustomController.isCanUsePhoneState()) {
                    return k.f(p.a());
                }
                return null;
            }

            @Override // com.pgl.sys.ces.out.ISdkInfo
            public WifiInfo getConnectionInfo() {
                WifiManager wifiManager;
                TTCustomController tTCustomController = e;
                if ((tTCustomController == null || tTCustomController.isCanUseWifiState()) && (wifiManager = (WifiManager) p.a().getSystemService("wifi")) != null) {
                    return wifiManager.getConnectionInfo();
                }
                return null;
            }

            @Override // com.pgl.sys.ces.out.ISdkInfo
            public List<ScanResult> getScanResults() {
                WifiManager wifiManager;
                TTCustomController tTCustomController = e;
                if ((tTCustomController == null || tTCustomController.isCanUseWifiState()) && (wifiManager = (WifiManager) p.a().getSystemService("wifi")) != null) {
                    return wifiManager.getScanResults();
                }
                return null;
            }

            @Override // com.pgl.sys.ces.out.ISdkInfo
            public String getHardwareAddress() {
                TTCustomController tTCustomController = e;
                if (tTCustomController == null || tTCustomController.isCanUseWifiState()) {
                    return k.h(p.a());
                }
                return null;
            }

            @Override // com.pgl.sys.ces.out.ISdkInfo
            public String getLongitude() {
                TTCustomController tTCustomController = e;
                if (tTCustomController == null || tTCustomController.isCanUseLocation()) {
                    if (d.a(p.a()) == null) {
                        return null;
                    }
                    return String.valueOf(d.a(p.a()).b);
                } else if (e.getTTLocation() == null) {
                    return null;
                } else {
                    return String.valueOf(e.getTTLocation().getLongitude());
                }
            }

            @Override // com.pgl.sys.ces.out.ISdkInfo
            public String getLatitude() {
                TTCustomController tTCustomController = e;
                if (tTCustomController == null || tTCustomController.isCanUseLocation()) {
                    if (d.a(p.a()) == null) {
                        return null;
                    }
                    return String.valueOf(d.a(p.a()).a);
                } else if (e.getTTLocation() == null) {
                    return null;
                } else {
                    return String.valueOf(e.getTTLocation().getLatitude());
                }
            }
        };
    }

    public String a() {
        return this.b.onEvent();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.d)) {
                this.d = str;
                this.b.setParams(str, null);
            }
            if (i.d().f() != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("app_id", i.d().f());
                this.b.setCustomInfo(hashMap);
            }
        }
    }

    public static t b(String str) {
        if (a == null) {
            synchronized (t.class) {
                if (a == null) {
                    a = new t(str);
                }
            }
        }
        return a;
    }

    public void c(String str) {
        if (!this.c) {
            this.b.reportNow(str);
            this.c = true;
        }
    }

    public String b() {
        try {
            String pullSg = this.b.pullSg();
            if (e(pullSg)) {
                return pullSg.toUpperCase();
            }
            String a2 = e.a(p.a());
            if (e(a2)) {
                return a2.toUpperCase();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private boolean e(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length < 20) {
            return false;
        }
        for (String str2 : split) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a2 = j.a(str);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return this.b.pullVer(a2);
    }
}
