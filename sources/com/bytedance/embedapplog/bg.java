package com.bytedance.embedapplog;

import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class bg {
    static boolean a(WebView webView) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mProvider");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(webView);
            if ("android.webkit.WebViewClassic".equals(obj)) {
                return a(obj);
            }
            Field declaredField2 = obj.getClass().getDeclaredField("mAwContents");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("isDestroyed", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj2, 0);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            bo.c("isDestroyed(): ", e);
        }
    }

    private static boolean a(Object obj) {
        Field declaredField = obj.getClass().getDeclaredField("mWebViewCore");
        declaredField.setAccessible(true);
        if (declaredField.get(obj) == null) {
            return true;
        }
        return false;
    }
}
