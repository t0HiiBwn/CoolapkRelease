package com.bytedance.sdk.openadsdk.preload.falconx.b;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: WebResourceUtils */
public class a {
    public static WebResourceResponse a(InputStream inputStream, Map<String, String> map) {
        if (inputStream != null) {
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Throwable th) {
                    Log.e("WebResourceUtils", "getResponseWithHeaders error", th);
                }
            }
            String str = map.get("content-type");
            if (TextUtils.isEmpty(str)) {
                str = map.get("Content-Type");
            }
            boolean z = false;
            if (str != null) {
                z = str.contains("font/ttf");
            }
            if (Build.VERSION.SDK_INT >= 21 && z) {
                return new WebResourceResponse(null, null, 200, "OK", map, inputStream);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(null, null, inputStream);
            if (Build.VERSION.SDK_INT >= 21) {
                webResourceResponse.setResponseHeaders(map);
                return webResourceResponse;
            }
            Field field = webResourceResponse.getClass().getField("mResponseHeaders");
            field.setAccessible(true);
            field.set(webResourceResponse, map);
            return webResourceResponse;
        }
        return null;
    }
}
