package com.alibaba.baichuan.trade.biz.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.trade.biz.core.a.b;
import com.alibaba.baichuan.trade.biz.core.jsbridge.a;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ResourceUtils;
import com.alibaba.baichuan.trade.common.utils.network.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class AlibcWebViewProxy {
    private static final String a = (" AliApp(BC/" + AlibcTradeCommon.systemVersion + ")");
    private static final String b;
    private static ArrayList<String> c = new ArrayList<>();

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(" tae_sdk_");
        sb.append(AlibcTradeCommon.systemVersion);
        b = sb.toString();
    }

    private static void a(WebSettings webSettings) {
        StringBuilder sb = new StringBuilder();
        String userAgentString = webSettings.getUserAgentString();
        if (userAgentString != null) {
            sb.append(userAgentString);
        }
        sb.append(b);
        sb.append(a);
        sb.append(String.format(" AliBaichuan(%s/%s)", AlibcTradeCommon.ttid, AlibcTradeCommon.isvVersion));
        Iterator<String> it2 = c.iterator();
        while (it2.hasNext()) {
            sb.append(" " + it2.next());
        }
        AlibcLogger.i("AlibcWebViewProxy", "ua = " + sb.toString());
        webSettings.setUserAgentString(sb.toString());
    }

    private static void a(final WebView webView) {
        a(webView, true);
        try {
            webView.setTag(ResourceUtils.getIdentifier(AlibcTradeCommon.context, "id", "com_taobao_nb_sdk_webview_click"), false);
        } catch (Exception e) {
            AlibcLogger.e("AlibcWebViewProxy", "setTag exception: msg = " + e.getMessage());
        }
        webView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.alibaba.baichuan.trade.biz.webview.AlibcWebViewProxy.AnonymousClass1 */

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    webView.setTag(ResourceUtils.getIdentifier(AlibcTradeCommon.context, "id", "com_taobao_nb_sdk_webview_click"), true);
                    return false;
                } catch (Exception e) {
                    AlibcLogger.e("AlibcWebViewProxy", "onTouch setTag exception: msg = " + e.getMessage());
                    return false;
                }
            }
        });
    }

    private static void a(WebView webView, boolean z) {
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            settings.setSavePassword(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(webView.getContext().getApplicationContext().getDir("cache", 0).getPath());
            settings.setAllowFileAccess(false);
            settings.setAppCacheEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            if (NetworkUtils.isNetworkAvailable(webView.getContext())) {
                settings.setCacheMode(-1);
            } else {
                settings.setCacheMode(1);
            }
            settings.setBuiltInZoomControls(false);
            if (z) {
                a(settings);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            }
        }
    }

    public static void addWebviewUA(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.add(str);
        }
    }

    public static void init() {
        a.a().b();
        b.a();
    }

    public static void initAlibcWebViewProxy(Context context, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, boolean z, InterceptorCallback interceptorCallback) {
        a(webView);
        if (z) {
            webView.setWebViewClient(new AlibcWebViewClient(webView, webViewClient, context, interceptorCallback));
            webView.setWebChromeClient(new AlibcWebChromeClient(webView, webChromeClient));
        }
    }
}
