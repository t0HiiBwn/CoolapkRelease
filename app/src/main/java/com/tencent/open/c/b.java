package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class b extends WebView {
    public b(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings settings = getSettings();
        if (settings != null) {
            try {
                Method method = settings.getClass().getMethod("removeJavascriptInterface", String.class);
                if (method != null) {
                    method.invoke(this, "searchBoxJavaBridge_");
                }
            } catch (Exception unused) {
            }
        }
    }
}
