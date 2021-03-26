package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: UrlUtils */
public class e {
    public static a a(String str) {
        a aVar;
        a aVar2 = a.IMAGE;
        if (TextUtils.isEmpty(str)) {
            return aVar2;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path == null) {
                return aVar2;
            }
            if (path.endsWith(".css")) {
                aVar = a.CSS;
            } else if (path.endsWith(".js")) {
                aVar = a.JS;
            } else {
                if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp")) {
                    if (!path.endsWith(".ico")) {
                        if (!path.endsWith(".html")) {
                            return aVar2;
                        }
                        aVar = a.HTML;
                    }
                }
                aVar = a.IMAGE;
            }
            return aVar;
        } catch (Throwable unused) {
            return aVar2;
        }
    }

    /* compiled from: UrlUtils */
    public enum a {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");
        
        private String e;

        private a(String str) {
            this.e = str;
        }

        public String a() {
            return this.e;
        }
    }
}
