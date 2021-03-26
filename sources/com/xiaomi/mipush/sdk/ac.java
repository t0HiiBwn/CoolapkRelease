package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.ah;
import com.xiaomi.push.gw;
import com.xiaomi.push.it;
import java.util.HashMap;

class ac {
    public static HashMap<String, String> a(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("appToken", b.m54a(context).b());
            hashMap.put("regId", MiPushClient.getRegId(context));
            hashMap.put("appId", b.m54a(context).m55a());
            hashMap.put("regResource", b.m54a(context).e());
            if (!it.g()) {
                String g = gw.g(context);
                if (!TextUtils.isEmpty(g)) {
                    hashMap.put("imeiMd5", ah.a(g));
                }
            }
            hashMap.put("isMIUI", String.valueOf(it.a()));
            hashMap.put("miuiVersion", it.d());
            hashMap.put("devId", gw.a(context, true));
            hashMap.put("model", Build.MODEL);
            hashMap.put("pkgName", context.getPackageName());
            hashMap.put("sdkVersion", "3_7_5");
            hashMap.put("androidVersion", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            hashMap.put("andId", gw.e(context));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("clientInterfaceId", str);
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }
}
