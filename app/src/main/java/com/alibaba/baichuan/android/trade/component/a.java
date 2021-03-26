package com.alibaba.baichuan.android.trade.component;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.b.b;
import com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContextManager;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeShowParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTrackParam;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.biz.webview.AlibcWebViewProxy;
import java.util.Map;

public class a {
    public static void a(Activity activity, String str, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, AlibcTradeContext alibcTradeContext, Map<String, String> map, com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar, boolean z) {
        alibcTradeContext.setActivity(activity);
        alibcTradeContext.setWebview(webView);
        AlibcTradeContextManager.setContext(alibcTradeContext);
        AlibcWebViewProxy.initAlibcWebViewProxy(activity, webView, webViewClient, webChromeClient, z, new InterceptorCallback() {
            /* class com.alibaba.baichuan.android.trade.component.a.AnonymousClass1 */

            @Override // com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback
            public void onFail(int i) {
            }

            @Override // com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback
            public void onInterceptor(AlibcTradeContext alibcTradeContext, UrlRequest urlRequest) {
                AlibcTradeShowParam alibcTradeShowParam = alibcTradeContext.showParam;
                AlibcTradeTaokeParam alibcTradeTaokeParam = alibcTradeContext.taokeParam;
                AlibcTradeTrackParam alibcTradeTrackParam = alibcTradeContext.urlParam;
                AlibcTrade.openByUrl(alibcTradeContext.activity.get(), alibcTradeTrackParam != null ? (String) alibcTradeTrackParam.get("identity") : "", urlRequest.getUrl(), alibcTradeContext.webview.get(), alibcTradeContext.getWebViewClient(), alibcTradeContext.getWebChromeClient(), b.a(alibcTradeShowParam), b.a(alibcTradeTaokeParam), alibcTradeTrackParam, new AlibcH5Component$1$1(this));
            }
        });
        if (aVar != null) {
            aVar.i();
        }
        if (map != null) {
            webView.loadUrl(str, map);
        } else {
            webView.loadUrl(str);
        }
    }

    public static void a(Activity activity, String str, AlibcTradeContext alibcTradeContext, com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar) {
        AlibcWebViewActivity.a(alibcTradeContext);
        AlibcWebViewActivity.a(aVar);
        Intent intent = new Intent(activity, AlibcWebViewActivity.class);
        intent.putExtra("url", str);
        if (!(alibcTradeContext == null || alibcTradeContext.showParam == null)) {
            intent.putExtra("bc_webview_activity_title", alibcTradeContext.showParam.getTitle());
        }
        activity.startActivity(intent);
    }
}
