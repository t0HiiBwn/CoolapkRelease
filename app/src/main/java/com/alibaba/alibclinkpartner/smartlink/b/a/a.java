package com.alibaba.alibclinkpartner.smartlink.b.a;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import java.util.HashMap;
import java.util.Map;

public abstract class a {
    public abstract String a();

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        String str = "unknown";
        hashMap.put("TTID", TextUtils.isEmpty(ALSLContext.instance().TTID) ? str : ALSLContext.instance().TTID);
        hashMap.put("appkey", TextUtils.isEmpty(ALSLContext.instance().appkey) ? str : ALSLContext.instance().appkey);
        hashMap.put("appName", TextUtils.isEmpty(ALSLContext.instance().appName) ? str : ALSLContext.instance().appName);
        hashMap.put("appVersion", TextUtils.isEmpty(ALSLContext.instance().appVersion) ? str : ALSLContext.instance().appVersion);
        hashMap.put("packageName", TextUtils.isEmpty(ALSLContext.instance().packageName) ? str : ALSLContext.instance().packageName);
        hashMap.put("sdkVersion", ALSLContext.instance().ALSLSDKVersion);
        if (!TextUtils.isEmpty(ALSLContext.instance().imei)) {
            str = ALSLContext.instance().imei;
        }
        hashMap.put("imei", str);
        hashMap.put("source", "alsl");
        return hashMap;
    }
}
