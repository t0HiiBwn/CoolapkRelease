package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UTHybridHelper {
    private static UTHybridHelper a = new UTHybridHelper();

    public static UTHybridHelper getInstance() {
        return a;
    }

    public void setH5Url(String str) {
        if (str != null) {
            UTMIVariables.getInstance().setH5Url(str);
        }
    }

    public void h5UT(Map<String, String> map, Object obj) {
        if (map == null || map.size() == 0) {
            i.a("h5UT", "dataMap is empty");
            return;
        }
        String str = map.get("functype");
        if (str == null) {
            i.a("h5UT", "funcType is null");
            return;
        }
        String str2 = map.get("utjstype");
        if (str2 == null || str2.equals("0") || str2.equals("1")) {
            map.remove("functype");
            Date date = new Date();
            if (str.equals("2001")) {
                a(date, map, obj);
            } else if (str.equals("2101")) {
                a(date, map);
            }
        } else {
            i.a("h5UT", "utjstype should be 1 or 0 or null");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3  */
    private void a(Date date, Map<String, String> map, Object obj) {
        Map<String, String> map2;
        int i;
        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder;
        Map<String, String> c;
        UTTracker defaultTracker;
        Map<String, String> map3;
        if (map != null && map.size() != 0) {
            String b = b(map.get("urlpagename"), map.get("url"));
            if (b == null || TextUtils.isEmpty(b)) {
                i.a("h5Page", "pageName is null,return");
                return;
            }
            String refPage = UTMIVariables.getInstance().getRefPage();
            String str = map.get("utjstype");
            map.remove("utjstype");
            if (str == null || str.equals("0")) {
                map3 = c(map);
            } else if (str.equals("1")) {
                map3 = d(map);
            } else {
                map2 = null;
                i = 2006;
                if (UTPageHitHelper.getInstance().m38a(obj)) {
                    i = 2001;
                }
                uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(b, i, refPage, null, null, map2);
                if (2001 == i) {
                    UTMIVariables.getInstance().setRefPage(b);
                }
                c = UTPageHitHelper.getInstance().c();
                if (c != null && c.size() > 0) {
                    uTOriginalCustomHitBuilder.setProperties(c);
                }
                defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker == null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                } else {
                    i.a("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
                }
                UTPageHitHelper.getInstance().m37a(obj);
            }
            map2 = map3;
            i = 2006;
            if (UTPageHitHelper.getInstance().m38a(obj)) {
            }
            uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(b, i, refPage, null, null, map2);
            if (2001 == i) {
            }
            c = UTPageHitHelper.getInstance().c();
            uTOriginalCustomHitBuilder.setProperties(c);
            defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker == null) {
            }
            UTPageHitHelper.getInstance().m37a(obj);
        }
    }

    private void a(Date date, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            String b = b(map.get("urlpagename"), map.get("url"));
            if (b == null || TextUtils.isEmpty(b)) {
                i.a("h5Ctrl", "pageName is null,return");
                return;
            }
            String str = map.get("logkey");
            if (str == null || TextUtils.isEmpty(str)) {
                i.a("h5Ctrl", "logkey is null,return");
                return;
            }
            Map<String, String> map2 = null;
            String str2 = map.get("utjstype");
            map.remove("utjstype");
            if (str2 == null || str2.equals("0")) {
                map2 = e(map);
            } else if (str2.equals("1")) {
                map2 = f(map);
            }
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(b, 2101, str, null, null, map2);
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(uTOriginalCustomHitBuilder.build());
            } else {
                i.a("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
        }
    }

    private Map<String, String> c(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        String str2 = "";
        hashMap.put("_h5url", str == null ? str2 : str);
        if (str != null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("spm");
            if (queryParameter == null || TextUtils.isEmpty(queryParameter)) {
                hashMap.put("spm", "0.0.0.0");
            } else {
                hashMap.put("spm", queryParameter);
            }
            String queryParameter2 = parse.getQueryParameter("scm");
            if (queryParameter2 != null && !TextUtils.isEmpty(queryParameter2)) {
                hashMap.put("scm", queryParameter2);
            }
        } else {
            hashMap.put("spm", "0.0.0.0");
        }
        String str3 = map.get("spmcnt");
        if (str3 == null) {
            str3 = str2;
        }
        hashMap.put("_spmcnt", str3);
        String str4 = map.get("spmpre");
        if (str4 == null) {
            str4 = str2;
        }
        hashMap.put("_spmpre", str4);
        String str5 = map.get("lzsid");
        if (str5 == null) {
            str5 = str2;
        }
        hashMap.put("_lzsid", str5);
        String str6 = map.get("extendargs");
        if (str6 == null) {
            str6 = str2;
        }
        hashMap.put("_h5ea", str6);
        String str7 = map.get("cna");
        if (str7 != null) {
            str2 = str7;
        }
        hashMap.put("_cna", str2);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> d(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        hashMap.put("_h5url", str);
        String str3 = map.get("extendargs");
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put("_h5ea", str2);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> e(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("logkeyargs");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        hashMap.put("_lka", str);
        String str3 = map.get("cna");
        if (str3 == null) {
            str3 = str2;
        }
        hashMap.put("_cna", str3);
        String str4 = map.get("extendargs");
        if (str4 != null) {
            str2 = str4;
        }
        hashMap.put("_h5ea", str2);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> f(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("extendargs");
        if (str == null) {
            str = "";
        }
        hashMap.put("_h5ea", str);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private String b(String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        int indexOf = str2.indexOf("?");
        return indexOf == -1 ? str2 : str2.substring(0, indexOf);
    }
}
