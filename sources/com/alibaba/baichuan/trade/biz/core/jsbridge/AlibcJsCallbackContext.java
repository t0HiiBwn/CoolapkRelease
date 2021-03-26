package com.alibaba.baichuan.trade.biz.core.jsbridge;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class AlibcJsCallbackContext {
    private static boolean g = (Build.VERSION.SDK_INT >= 19);
    WebView a;
    String b;
    String c;
    String d;
    boolean e = false;
    String f = null;

    public AlibcJsCallbackContext(WebView webView) {
        this.a = webView;
    }

    public AlibcJsCallbackContext(WebView webView, String str, String str2, String str3) {
        this.a = webView;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    private static String a(String str) {
        if (str.contains(" ")) {
            try {
                str = str.replace(" ", "\\u2028");
            } catch (Exception unused) {
            }
        }
        if (str.contains(" ")) {
            try {
                str = str.replace(" ", "\\u2029");
            } catch (Exception unused2) {
            }
        }
        return str.replace("\\", "\\\\").replace("'", "\\'");
    }

    private static void a(final WebView webView, String str, String str2) {
        if (AlibcTradeCommon.isDebug() && !TextUtils.isEmpty(str2)) {
            try {
                new JSONObject(str2);
            } catch (JSONException unused) {
                AlibcLogger.e("AlibcJsCallbackContext", "return param is not a valid json!\n" + str + "\n" + str2);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        try {
            final String format = String.format(str, a(str2));
            webView.post(new Runnable() {
                /* class com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsCallbackContext.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    AlibcJsCallbackContext.evaluateJavascript(webView, format);
                }
            });
        } catch (Exception e2) {
            AlibcLogger.e("AlibcJsCallbackContext", "callback error. " + e2.getMessage());
        }
    }

    public static void evaluateJavascript(WebView webView, String str) {
        evaluateJavascript(webView, str, null);
    }

    public static void evaluateJavascript(WebView webView, String str, ValueCallback<String> valueCallback) {
        if (webView != null && webView != null) {
            if (str != null && str.length() > 10 && "javascript:".equals(str.substring(0, 11).toLowerCase())) {
                str = str.substring(11);
            }
            if (g) {
                try {
                    webView.evaluateJavascript(str, valueCallback);
                } catch (IllegalStateException | NoSuchMethodError unused) {
                    g = false;
                    evaluateJavascript(webView, str, valueCallback);
                }
            } else if (valueCallback == null) {
                try {
                    webView.loadUrl("javascript:" + str);
                } catch (Throwable th) {
                    AlibcLogger.e("Alibc", "evaluateJavascript", th);
                }
            }
        }
    }

    public static void fireEvent(WebView webView, String str, String str2) {
        a(webView, String.format("window.AliBCBridge && window.AliBCBridge.fireEvent('%s', '%%s', %s);", str, null), str2);
    }

    public void error(AlibcJsResult alibcJsResult) {
        AlibcLogger.d("AlibcJsCallbackContext", "call error ");
        a(this.a, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onFailure(%s,'%%s');", this.b), alibcJsResult.toJsonString());
    }

    public void error(String str) {
        AlibcLogger.d("AlibcJsCallbackContext", "call error ");
        a(this.a, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onFailure(%s,'%%s');", this.b), str);
    }

    public void fireEvent(String str, String str2) {
        a(this.a, String.format("window.AliBCBridge && window.AliBCBridge.fireEvent('%s', '%%s', %s);", str, this.b), str2);
    }

    public WebView getWebview() {
        return this.a;
    }

    public void setNeedfireNativeEvent(String str, boolean z) {
        this.f = str;
        this.e = z;
        AlibcLogger.e("AlibcJsCallbackContext", "setNeedfireNativeEvent : " + str);
    }

    public void success() {
        AlibcJsResult alibcJsResult = new AlibcJsResult();
        alibcJsResult.setSuccess();
        success(alibcJsResult);
    }

    public void success(AlibcJsResult alibcJsResult) {
        a(this.a, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onSuccess(%s,'%%s');", this.b), alibcJsResult.toJsonString());
    }

    public void success(String str) {
        a(this.a, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onSuccess(%s,'%%s');", this.b), str);
    }
}
