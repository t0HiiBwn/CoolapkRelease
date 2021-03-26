package com.ali.auth.third.ui.webview;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.trace.SDKLogger;
import java.lang.reflect.Method;

public class BridgeWebChromeClient extends WebChromeClient {
    private static final String a = "BridgeWebChromeClient";
    private static boolean b = (Build.VERSION.SDK_INT >= 19);

    private static class a implements Runnable {
        public WebView a;
        public String b;

        public a(WebView webView, String str) {
            this.a = webView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (BridgeWebChromeClient.b) {
                    try {
                        this.a.evaluateJavascript(this.b, null);
                        return;
                    } catch (Exception e) {
                        SDKLogger.e("ui", "fail to evaluate the script " + e.getMessage(), e);
                    }
                }
                String str = "javascript:" + this.b;
                WebView webView = this.a;
                if (webView instanceof AuthWebView) {
                    ((AuthWebView) webView).loadUrl(str);
                } else {
                    webView.loadUrl(str);
                }
            } catch (Exception unused) {
            }
        }
    }

    private a a(String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        int port = parse.getPort();
        String lastPathSegment = parse.getLastPathSegment();
        parse.getQuery();
        int indexOf = str.indexOf("?");
        String substring = indexOf == -1 ? null : str.substring(indexOf + 1);
        a aVar = new a();
        aVar.b = lastPathSegment;
        aVar.a = host;
        aVar.c = substring;
        aVar.d = port;
        return aVar;
    }

    private void a(WebView webView, String str) {
        try {
            int indexOf = str.indexOf(58, 9);
            webView.post(new a(webView, String.format("window.WindVane&&window.WindVane.onFailure(%s,'{\"ret\":\"HY_NO_HANDLER\"');", str.substring(indexOf + 1, str.indexOf(47, indexOf)))));
        } catch (Exception e) {
            SDKLogger.e("ui", "fail to handler windvane request, the error message is " + e.getMessage(), e);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x008a: APUT  (r1v11 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v8 java.lang.String) */
    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str3 == null) {
            return false;
        }
        if (str3.equals("wv_hybrid:")) {
            a(webView, str2);
        } else if (!TextUtils.equals(str3, "hv_hybrid:") || !(webView instanceof AuthWebView)) {
            return false;
        } else {
            AuthWebView authWebView = (AuthWebView) webView;
            a a2 = a(str2);
            com.ali.auth.third.ui.context.a aVar = new com.ali.auth.third.ui.context.a();
            aVar.e = a2.d;
            aVar.d = authWebView;
            Object bridgeObj = authWebView.getBridgeObj(a2.a);
            if (bridgeObj == null) {
                Message createMessage = MessageUtils.createMessage(10000, a2.a);
                SDKLogger.e(a, createMessage.toString());
                aVar.a(createMessage.code, createMessage.message);
            } else {
                try {
                    Method method = bridgeObj.getClass().getMethod(a2.b, com.ali.auth.third.ui.context.a.class, String.class);
                    if (method.isAnnotationPresent(BridgeMethod.class)) {
                        try {
                            Object[] objArr = new Object[2];
                            objArr[0] = aVar;
                            objArr[1] = TextUtils.isEmpty(a2.c) ? "{}" : a2.c;
                            method.invoke(bridgeObj, objArr);
                        } catch (Exception e) {
                            Message createMessage2 = MessageUtils.createMessage(10010, e.getMessage());
                            String str4 = a;
                            SDKLogger.e(str4, createMessage2.toString() + "," + e.toString());
                            aVar.a(createMessage2.code, createMessage2.message);
                        }
                    } else {
                        Message createMessage3 = MessageUtils.createMessage(952, a2.a, a2.b);
                        SDKLogger.e(a, createMessage3.toString());
                        aVar.a(createMessage3.code, createMessage3.message);
                    }
                    jsPromptResult.confirm("");
                    return true;
                } catch (NoSuchMethodException e2) {
                    Message createMessage4 = MessageUtils.createMessage(951, a2.a, a2.b);
                    String str5 = a;
                    SDKLogger.e(str5, createMessage4 + "," + e2.toString());
                    aVar.a(createMessage4.code, createMessage4.message);
                }
            }
        }
        jsPromptResult.confirm("");
        return true;
    }
}
