package com.alibaba.baichuan.trade.biz.core.jsbridge;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsBridgeService;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcPluginManager;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

public class a implements Handler.Callback {
    private static a a;
    private static Handler b;
    private boolean c = true;
    private boolean d;
    private boolean e = false;

    private a() {
        b = new Handler(Looper.getMainLooper(), this);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private b a(String str) {
        if (str != null && str.startsWith("bchybrid:///")) {
            try {
                b bVar = new b();
                int indexOf = str.indexOf(58, 12);
                bVar.d = str.substring(12, indexOf);
                int indexOf2 = str.indexOf(47, indexOf);
                bVar.g = str.substring(indexOf + 1, indexOf2);
                int indexOf3 = str.indexOf(63, indexOf2);
                int i = indexOf2 + 1;
                if (indexOf3 > 0) {
                    bVar.e = str.substring(i, indexOf3);
                    bVar.f = str.substring(indexOf3 + 1);
                } else {
                    bVar.e = str.substring(i);
                }
                if (bVar.d.length() > 0 && bVar.g.length() > 0 && bVar.e.length() > 0) {
                    return bVar;
                }
            } catch (StringIndexOutOfBoundsException unused) {
            }
        }
        return null;
    }

    public static void a(int i, b bVar) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = bVar;
        b.sendMessage(obtain);
    }

    public static void a(b bVar, String str) {
        int i;
        AlibcApiPlugin createPlugin = AlibcPluginManager.createPlugin(bVar.d, bVar.b, bVar.a);
        if (createPlugin == null || !(createPlugin instanceof AlibcApiPlugin)) {
            AlibcLogger.w("AlibcJsBridge", "callMethod: Plugin " + bVar.d + " didn't found, you should call WVPluginManager.registerPlugin first.");
            i = 2;
        } else {
            AlibcLogger.i("AlibcJsBridge", "call new method execute.");
            bVar.c = createPlugin;
            i = 0;
        }
        a(i, bVar);
    }

    /* access modifiers changed from: private */
    public void b(b bVar, String str) {
        AlibcLogger.d("AlibcJsBridge", String.format("callMethod-obj:%s method:%s param:%s sid:%s", bVar.d, bVar.e, bVar.f, bVar.g));
        if (!this.c || bVar.a == null) {
            AlibcLogger.w("AlibcJsBridge", "jsbridge is closed.");
            a(4, bVar);
            return;
        }
        if (!this.d && AlibcJsBridgeService.a() != null && !AlibcJsBridgeService.a().isEmpty()) {
            for (AlibcJsBridgeService.AlibcJSAPIAuthCheck alibcJSAPIAuthCheck : AlibcJsBridgeService.a()) {
                if (!alibcJSAPIAuthCheck.a(str, bVar.d, bVar.e, bVar.f)) {
                    AlibcLogger.w("AlibcJsBridge", "preprocessor call fail, callMethod cancel.");
                    a(3, bVar);
                    return;
                }
            }
        }
        a(bVar, str);
    }

    public void a(WebView webView, int i) {
    }

    public void a(WebView webView, String str) {
    }

    public void a(WebView webView, String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    public void a(WebView webView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (j2 < 20971520) {
            quotaUpdater.updateQuota(j2);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public boolean a(WebView webView, ConsoleMessage consoleMessage) {
        try {
            String message = consoleMessage.message();
            if (!TextUtils.isEmpty(message)) {
                Uri parse = Uri.parse(message);
                if (message.startsWith("bcNativeCallback")) {
                    String substring = message.substring(message.indexOf("/") + 1);
                    int indexOf = substring.indexOf("/");
                    String substring2 = substring.substring(0, indexOf);
                    String substring3 = substring.substring(indexOf + 1);
                    ValueCallback<String> a2 = c.a(substring2);
                    if (a2 != null) {
                        a2.onReceiveValue(substring3);
                        c.b(substring2);
                    } else {
                        Log.e("alibc", "NativeCallback failed: " + substring3);
                    }
                    return true;
                } else if ("bchybrid".equals(parse.getScheme())) {
                    a().b(webView, message);
                    return true;
                }
            } else {
                AlibcLogger.e("AlibcJsBridge", "onConsoleMessage: transfer data is null");
            }
        } catch (Exception e2) {
            AlibcLogger.e("AlibcJsBridge", "onConsoleMessage: data handle exception: msg = " + e2.getMessage());
        }
        return false;
    }

    public boolean a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str3 == null || !str3.equals("bc_hybrid:")) {
            return false;
        }
        a().b(webView, str2);
        jsPromptResult.confirm("");
        return true;
    }

    public boolean a(WebView webView, String str, String str2, String str3, JsResult jsResult) {
        try {
            if (TextUtils.isEmpty(str2)) {
                AlibcLogger.e("AlibcJsBridge", "onJsConfirm: transfer data is null");
                return false;
            } else if (!"bchybrid".equals(Uri.parse(str2).getScheme())) {
                return false;
            } else {
                a().b(webView, str2);
                jsResult.confirm();
                return true;
            }
        } catch (Exception e2) {
            AlibcLogger.e("AlibcJsBridge", "onJsConfirm: data handle exception: msg = " + e2.getMessage());
            return false;
        }
    }

    public synchronized void b() {
        this.e = true;
    }

    public void b(WebView webView, String str) {
        AlibcLogger.d("AlibcJsBridge", "callMethod: url=" + str);
        if (!this.e) {
            AlibcLogger.w("AlibcJsBridge", "jsbridge is not init.");
            return;
        }
        final b a2 = a(str);
        if (a2 == null) {
            AlibcLogger.w("AlibcJsBridge", "url format error and call canceled. url=" + str);
            return;
        }
        a2.a = webView;
        final String url = webView.getUrl();
        new Thread(new Runnable() {
            /* class com.alibaba.baichuan.trade.biz.core.jsbridge.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a2, url);
            }
        }).start();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AlibcJsResult alibcJsResult;
        b bVar = (b) message.obj;
        if (bVar == null) {
            AlibcLogger.e("AlibcJsBridge", "CallMethodContext is null, and do nothing.");
            return false;
        }
        AlibcJsCallbackContext alibcJsCallbackContext = new AlibcJsCallbackContext(bVar.a, bVar.g, bVar.d, bVar.e);
        int i = message.what;
        if (i != 0) {
            if (i == 2) {
                alibcJsResult = AlibcJsResult.RET_NO_METHOD;
            } else if (i == 3) {
                alibcJsResult = AlibcJsResult.RET_NO_PERMISSION;
            } else if (i != 4) {
                return false;
            } else {
                alibcJsResult = AlibcJsResult.RET_CLOSED;
            }
            alibcJsCallbackContext.error(alibcJsResult);
            return true;
        }
        if (!((AlibcApiPlugin) bVar.c).execute(bVar.e, TextUtils.isEmpty(bVar.f) ? "{}" : bVar.f, alibcJsCallbackContext)) {
            AlibcLogger.w("AlibcJsBridge", "AlibcApiPlugin execute failed. method: " + bVar.e);
            a(2, bVar);
        }
        return true;
    }
}
