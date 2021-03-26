package com.ali.auth.third.ui.context;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.auth.third.core.context.KernelContext;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public WebView d;
    public int e;

    /* access modifiers changed from: private */
    public void d(String str) {
        WebView webView = this.d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    /* access modifiers changed from: private */
    public static String e(String str) {
        return str.replace("\\", "\\\\");
    }

    public Activity a() {
        return (Activity) this.d.getContext();
    }

    public void a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            b(jSONObject.toString());
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void a(final String str) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.ui.context.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(TextUtils.isEmpty(str) ? String.format("javascript:window.HavanaBridge.onSuccess(%s);", Integer.valueOf(a.this.e)) : String.format("javascript:window.HavanaBridge.onSuccess(%s,'%s');", Integer.valueOf(a.this.e), a.e(str)));
            }
        });
    }

    public void b(final String str) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.ui.context.a.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(TextUtils.isEmpty(str) ? String.format("javascript:window.HavanaBridge.onFailure(%s,'');", Integer.valueOf(a.this.e)) : String.format("javascript:window.HavanaBridge.onFailure(%s,'%s');", Integer.valueOf(a.this.e), a.e(str)));
            }
        });
    }
}
