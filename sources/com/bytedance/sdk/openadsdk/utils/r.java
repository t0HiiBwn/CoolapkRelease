package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.x;

/* compiled from: JsBridgeUtils */
public class r {
    public static void a(Uri uri, x xVar) {
        if (xVar != null && xVar.a(uri)) {
            try {
                xVar.b(uri);
            } catch (Exception e) {
                u.d("WebView", "TTAndroidObj handleUri exception: " + e);
            }
        }
    }

    public static String a(WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        return userAgentString + " open_news open_news_u_s/" + i;
    }
}
