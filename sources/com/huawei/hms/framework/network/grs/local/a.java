package com.huawei.hms.framework.network.grs.local;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.c.c;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public abstract class a {
    protected com.huawei.hms.framework.network.grs.local.model.a a;
    protected List<b> b;
    protected Map<String, String> c = new ConcurrentHashMap(16);
    protected boolean d = false;
    protected Set<String> e = new HashSet(16);

    private Map<String, String> a(List<b> list, GrsBaseInfo grsBaseInfo) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (b bVar : list) {
            if (bVar.b().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.a());
            }
            if (bVar.b().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.a());
            }
            if (bVar.b().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.a());
            }
        }
        return concurrentHashMap;
    }

    private int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int c2 = c(str);
        if (c2 != 0) {
            return c2;
        }
        int a2 = a(str);
        return a2 != 0 ? a2 : b(str);
    }

    private int e(String str) {
        int c2;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        List<b> list = this.b;
        return ((list == null || list.isEmpty()) && (c2 = c(str)) != 0) ? c2 : b(str);
    }

    public abstract int a(String str);

    int a(String str, Context context) {
        int i;
        if (d(c.a(str, context)) == 0) {
            Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success.");
            i = 0;
        } else {
            i = -1;
        }
        try {
            String[] list = context.getAssets().list("");
            if (list != null && list.length > 0) {
                for (String str2 : list) {
                    if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str2) && e(c.a(str2, context)) == 0) {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE sucess.");
                        i = 0;
                    }
                }
            }
        } catch (IOException unused) {
            Logger.w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
        }
        return i;
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.a;
    }

    public String a(GrsBaseInfo grsBaseInfo, String str, String str2) {
        Map<String, String> a2 = a(grsBaseInfo, str);
        if (a2 != null) {
            return a2.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str) {
        if (!this.d) {
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c b2 = this.a.b(str);
        if (b2 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String a2 = e.a(b2.b(), grsBaseInfo);
        if (a2 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", b2.b());
            return null;
        }
        List<b> c2 = b2.c();
        d b3 = b2.b(((c2 == null || c2.size() == 0) ? this.c : a(c2, grsBaseInfo)).get(a2));
        if (b3 == null) {
            return null;
        }
        return b3.b();
    }

    public boolean a(GrsBaseInfo grsBaseInfo) {
        List<b> list = this.b;
        if (list == null || list.isEmpty()) {
            return false;
        }
        this.c.put("no_route_country", "no-country");
        for (b bVar : this.b) {
            if (bVar.b().contains(grsBaseInfo.getIssueCountry())) {
                this.c.put(grsBaseInfo.getIssueCountry(), bVar.a());
            }
            if (bVar.b().contains(grsBaseInfo.getRegCountry())) {
                this.c.put(grsBaseInfo.getRegCountry(), bVar.a());
            }
            if (bVar.b().contains(grsBaseInfo.getSerCountry())) {
                this.c.put(grsBaseInfo.getSerCountry(), bVar.a());
            }
        }
        return true;
    }

    public abstract int b(String str);

    public boolean b() {
        return this.d;
    }

    public abstract int c(String str);
}
