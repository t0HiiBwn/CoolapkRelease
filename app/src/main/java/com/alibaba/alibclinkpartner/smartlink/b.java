package com.alibaba.alibclinkpartner.smartlink;

import com.alibaba.alibclinkpartner.smartlink.a.a;
import com.alibaba.alibclinkpartner.smartlink.data.SafeConfig;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.c;
import com.alibaba.alibclinkpartner.smartlink.util.f;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class b implements Runnable {
    b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alibaba.alibclinkpartner.smartlink.a.b a = a.a("https://userlink.alicdn.com/matrix_app/android/safe_package_config.json", (Map<String, String>) null);
        if (a.a == 200) {
            try {
                JSONObject jSONObject = new JSONObject(a.b);
                SafeConfig safeConfig = new SafeConfig();
                long j = jSONObject.getLong("validtime");
                List<String> a2 = c.a(jSONObject.getJSONArray("whiteList"));
                safeConfig.setValidtime(j);
                safeConfig.setWhiteList(a2);
                f.c("safe_package_config", safeConfig);
                f.a("safe_package_validate_time", Long.valueOf(j));
                f.a("last_safe_config_request_time", Long.valueOf(System.currentTimeMillis()));
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getBackUrlPackage", "拉到的包名数据：" + jSONObject);
            } catch (Exception unused) {
            }
        }
    }
}
