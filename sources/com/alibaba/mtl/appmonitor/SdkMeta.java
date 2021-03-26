package com.alibaba.mtl.appmonitor;

import android.content.Context;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.d.i;
import java.util.HashMap;
import java.util.Map;

public class SdkMeta {
    public static final String SDK_VERSION = "2.6.4.5_for_bc";
    private static final Map<String, String> d;

    public static Map<String, String> getSDKMetaData() {
        a.getContext();
        Map<String, String> map = d;
        if (!map.containsKey("sdk-version")) {
            map.put("sdk-version", "2.6.4.5_for_bc");
        }
        return map;
    }

    static {
        HashMap hashMap = new HashMap();
        d = hashMap;
        hashMap.put("sdk-version", "2.6.4.5_for_bc");
    }

    public static void setExtra(Map<String, String> map) {
        if (map != null) {
            d.putAll(map);
        }
    }

    public static String getString(Context context, String str) {
        if (context == null) {
            return null;
        }
        int i = 0;
        try {
            i = context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Throwable th) {
            i.a("SdkMeta", "getString Id error", th);
        }
        if (i != 0) {
            return context.getString(i);
        }
        return null;
    }
}
