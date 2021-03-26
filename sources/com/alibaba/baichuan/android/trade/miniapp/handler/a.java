package com.alibaba.baichuan.android.trade.miniapp.handler;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.b;
import com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeShowParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTrackParam;
import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcAidComponent;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback;
import com.alibaba.baichuan.trade.biz.urlroute.AlibcUriContext;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends UrlHandler {
    /* access modifiers changed from: private */
    public void a(int i, final com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar, final String str, final UrlRequest urlRequest, final AlibcTradeContext alibcTradeContext, final com.alibaba.baichuan.android.trade.miniapp.a aVar2, final Map<String, String> map, final AlibcTradeShowParam alibcTradeShowParam) {
        AlibcLogger.d("AppInnerHandler", "淘客打点流程回调,type = " + i + "\n openUrl = " + str);
        if (aVar != null) {
            if (i == 1) {
                aVar.a = "sync";
                aVar.f();
            } else {
                aVar.a = "async";
                aVar.j();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
                /* class com.alibaba.baichuan.android.trade.miniapp.handler.a.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.a(urlRequest, alibcTradeContext, aVar.a(str, map, aVar), aVar, alibcTradeShowParam.isProxyWebview(), aVar2);
                }
            });
        } else {
            alibcTradeContext.callback.onFailure(-1, "openH5 url is null");
        }
    }

    private void a(final com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar, AlibcTradeTaokeParam alibcTradeTaokeParam, final AlibcTradeShowParam alibcTradeShowParam, final UrlRequest urlRequest, final AlibcTradeContext alibcTradeContext, final com.alibaba.baichuan.android.trade.miniapp.a aVar2) {
        if (aVar != null) {
            aVar.e();
        }
        final AlibcTradeTrackParam alibcTradeTrackParam = alibcTradeContext.urlParam;
        AlibcAidComponent.genTaokeUrl(alibcTradeShowParam.getOriginalOpenType() == AlibcTradeShowParam.OpenType.Native, alibcTradeTrackParam, urlRequest.getUrl(), alibcTradeTaokeParam, new AlibcTaokeTraceCallback() {
            /* class com.alibaba.baichuan.android.trade.miniapp.handler.a.AnonymousClass1 */

            @Override // com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback
            public void getTaokeUrl(int i, String str) {
                a.this.a(i, aVar, str, urlRequest, alibcTradeContext, aVar2, alibcTradeTrackParam, alibcTradeShowParam);
            }
        });
    }

    private void a(UrlRequest urlRequest, com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar, AlibcTradeContext alibcTradeContext, com.alibaba.baichuan.android.trade.miniapp.a aVar2) {
        AlibcTradeShowParam alibcTradeShowParam = alibcTradeContext.showParam;
        AlibcTradeTaokeParam alibcTradeTaokeParam = alibcTradeContext.taokeParam;
        if (aVar != null) {
            aVar.b();
        }
        if (!a(alibcTradeTaokeParam, urlRequest)) {
            a(urlRequest, alibcTradeContext, a(urlRequest.getUrl(), alibcTradeContext.urlParam, aVar), aVar, alibcTradeShowParam.isProxyWebview(), aVar2);
        } else if (!alibcTradeTaokeParam.isAdZoneIdExist() || !a(urlRequest)) {
            b(aVar, alibcTradeTaokeParam, alibcTradeShowParam, urlRequest, alibcTradeContext, aVar2);
        } else {
            a(aVar, alibcTradeTaokeParam, alibcTradeShowParam, urlRequest, alibcTradeContext, aVar2);
        }
    }

    /* access modifiers changed from: private */
    public void a(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, String str, com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar, boolean z, com.alibaba.baichuan.android.trade.miniapp.a aVar2) {
        Activity activity;
        WebViewClient webViewClient;
        WebChromeClient webChromeClient;
        Map<String, String> additionalHttpHeaders;
        WebView webView = alibcTradeContext.webview.get();
        if (webView != null) {
            AlibcLogger.d("AppInnerHandler", "采用三方webview进行打开");
            int d = aVar2.d();
            if (d == 100) {
                b c = aVar2.c();
                activity = alibcTradeContext.activity.get();
                webViewClient = alibcTradeContext.getWebViewClient();
                webChromeClient = alibcTradeContext.getWebChromeClient();
                additionalHttpHeaders = c.e();
            } else if (d == 200) {
                AlibcBasePage b = aVar2.b();
                activity = alibcTradeContext.activity.get();
                webViewClient = alibcTradeContext.getWebViewClient();
                webChromeClient = alibcTradeContext.getWebChromeClient();
                additionalHttpHeaders = b.getAdditionalHttpHeaders();
            } else {
                return;
            }
            com.alibaba.baichuan.android.trade.component.a.a(activity, str, webView, webViewClient, webChromeClient, alibcTradeContext, additionalHttpHeaders, aVar, z);
            return;
        }
        AlibcLogger.d("AppInnerHandler", "采用百川webview进行打开");
        com.alibaba.baichuan.android.trade.component.a.a(alibcTradeContext.activity.get(), str, alibcTradeContext, aVar);
    }

    private boolean a(AlibcTradeTaokeParam alibcTradeTaokeParam, UrlRequest urlRequest) {
        if ("detail".equals(urlRequest.getPageType()) && alibcTradeTaokeParam != null) {
            return true;
        }
        if (!"shop".equals(urlRequest.getPageType()) || alibcTradeTaokeParam == null || !alibcTradeTaokeParam.isAdZoneIdExist()) {
            return a(urlRequest.getUrl()) && alibcTradeTaokeParam != null && alibcTradeTaokeParam.isAdZoneIdExist();
        }
        return true;
    }

    private boolean a(String str) {
        return AlibcURLCheck.regular.check(AlibcContext.tunionUrlPatterns, str);
    }

    private void b(final com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar, AlibcTradeTaokeParam alibcTradeTaokeParam, final AlibcTradeShowParam alibcTradeShowParam, final UrlRequest urlRequest, final AlibcTradeContext alibcTradeContext, final com.alibaba.baichuan.android.trade.miniapp.a aVar2) {
        if (aVar != null) {
            aVar.e();
        }
        final AlibcTradeTrackParam alibcTradeTrackParam = alibcTradeContext.urlParam;
        int d = aVar2.d();
        if (d == 100) {
            aVar2.c().a(alibcTradeTaokeParam, alibcTradeContext, new AlibcTaokeTraceCallback() {
                /* class com.alibaba.baichuan.android.trade.miniapp.handler.a.AnonymousClass2 */

                @Override // com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback
                public void getTaokeUrl(int i, String str) {
                    a.this.a(i, aVar, str, urlRequest, alibcTradeContext, aVar2, alibcTradeTrackParam, alibcTradeShowParam);
                }
            });
        } else if (d == 200) {
            aVar2.b().taokeTraceAndGenUrl(alibcTradeTaokeParam, urlRequest, alibcTradeContext, new AlibcTaokeTraceCallback() {
                /* class com.alibaba.baichuan.android.trade.miniapp.handler.a.AnonymousClass3 */

                @Override // com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback
                public void getTaokeUrl(int i, String str) {
                    a.this.a(i, aVar, str, urlRequest, alibcTradeContext, aVar2, alibcTradeTrackParam, alibcTradeShowParam);
                }
            });
        }
    }

    public String a(String str, Map<String, String> map, com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar) {
        AlibcLogger.d("AppInnerHandler", "首次进入加参，参数： urlParams = " + map + "  url=" + str);
        if (aVar != null) {
            aVar.g();
        }
        if (!AlibcUriContext.isTradeAddParamURL(str)) {
            if (aVar != null) {
                aVar.h();
            }
            return str;
        }
        String addParamsUrl = new AlibcUriContext(str).getAddParamsUrl(map);
        if (aVar != null) {
            aVar.h();
        }
        return addParamsUrl;
    }

    public boolean a(UrlRequest urlRequest) {
        return !"addCart".equals(urlRequest.getPageType());
    }

    @Override // com.alibaba.baichuan.android.trade.miniapp.handler.UrlHandler
    protected void handleInternal(UrlRequest urlRequest, UrlCallBack urlCallBack, AlibcTradeContext alibcTradeContext, com.alibaba.baichuan.android.trade.miniapp.a aVar) {
        String performancePageType;
        HashMap<String, Object> fields = urlRequest.getFields();
        if (!fields.containsKey("urlType")) {
            return;
        }
        if ("miniapp".equals(fields.get("urlType"))) {
            AlibcLogger.i("AppInnerHandler", "小程序的链接类型");
        } else if ("h5".equals(fields.get("urlType"))) {
            com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar2 = new com.alibaba.baichuan.android.trade.usertracker.monitor.a();
            int d = aVar.d();
            if (d == 100) {
                performancePageType = aVar.c().f();
            } else {
                if (d == 200) {
                    performancePageType = aVar.b().getPerformancePageType();
                }
                aVar2.c();
                aVar2.a();
                a(urlRequest, aVar2, alibcTradeContext, aVar);
            }
            aVar2.b = performancePageType;
            aVar2.c();
            aVar2.a();
            a(urlRequest, aVar2, alibcTradeContext, aVar);
        }
    }

    @Override // com.alibaba.baichuan.android.trade.miniapp.handler.UrlHandler
    protected boolean shouldHandle(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, com.alibaba.baichuan.android.trade.miniapp.a aVar, boolean z) {
        List<ActionDO> actionPriorityList;
        if (!z || (actionPriorityList = urlRequest.getActionPriorityList()) == null || actionPriorityList.size() == 0) {
            return true;
        }
        return !alibcTradeContext.showParam.getOpenType().equals(AlibcTradeShowParam.OpenType.Native);
    }
}
