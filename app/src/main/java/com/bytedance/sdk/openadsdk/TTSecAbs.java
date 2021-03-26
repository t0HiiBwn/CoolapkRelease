package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.HashMap;
import java.util.Map;

public abstract class TTSecAbs {
    public String NM_getAppKey() {
        return "df979cdb-05a7-448c-bece-92d5005a1247";
    }

    public String NM_getInstallId() {
        return null;
    }

    public abstract String NM_pullSg();

    public abstract String NM_pullVer(String str);

    public abstract void NM_reportNow(String str);

    public abstract void NM_setParams(String str);

    public String NM_getDeviceId() {
        return k.a(p.a());
    }

    public Map<String, Object> NM_getCustomInfo() {
        if (i.d().f() == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", i.d().f());
        return hashMap;
    }
}
