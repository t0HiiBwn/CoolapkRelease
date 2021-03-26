package com.alibaba.baichuan.trade.biz.applink;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplink;
import com.alibaba.baichuan.trade.biz.context.AlibcResultType;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContextManager;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeShowParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ParamDO;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.biz.urlroute.AlibcUriContext;
import com.alibaba.baichuan.trade.biz.utils.AlibcTradeHelper;
import com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlarmUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AlibcAppLinkInterceptor implements AlibcUrlBus.IUrlInterceptor {
    private static AlibcAppLinkInterceptor a;
    private boolean b = false;

    private AlibcAppLinkInterceptor() {
    }

    private String a() {
        return "alisdk://" + AlibcTradeCommon.getAppKey() + ".nativeTaobao/handleraction";
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        this.b = z;
    }

    private boolean a(final WebView webView) {
        if (webView == null) {
            return false;
        }
        ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
            /* class com.alibaba.baichuan.trade.biz.applink.AlibcAppLinkInterceptor.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                AlibcTradeContext context = AlibcTradeContextManager.getContext(webView);
                if (context != null) {
                    AlibcTradeResult alibcTradeResult = new AlibcTradeResult();
                    alibcTradeResult.resultType = AlibcResultType.TYPECART;
                    if (context.callback != null) {
                        context.callback.onTradeSuccess(alibcTradeResult);
                    }
                    if (context.activity != null && context.activity.get() != null) {
                        context.activity.get().finish();
                    }
                }
            }
        });
        return true;
    }

    private boolean a(WebView webView, String str) {
        AlibcApplink.getInstance();
        if (!AlibcApplink.isApplinkSupported("taobao")) {
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setData(Uri.parse(str));
        webView.getContext().startActivity(intent);
        return true;
    }

    private boolean a(final WebView webView, String str, AlibcTradeContext alibcTradeContext) {
        if (alibcTradeContext.showParam == null || !alibcTradeContext.showParam.getOpenType().equals(AlibcTradeShowParam.OpenType.Auto)) {
            return false;
        }
        String str2 = str;
        String queryParameter = new AlibcUriContext(str2).getQueryParameter("shop_id");
        final AlibcTradeContext context = AlibcTradeContextManager.getContext(webView);
        if (context == null) {
            return false;
        }
        AlibcTradeTaokeParam alibcTradeTaokeParam = context.taokeParam;
        final AlibcTradeShowParam alibcTradeShowParam = context.showParam;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        String degradeUrl = alibcTradeShowParam.getDegradeUrl();
        if (!TextUtils.isEmpty(alibcTradeShowParam.getDegradeUrl())) {
            str2 = degradeUrl;
        }
        AlibcApplink.getInstance().jumpShop(context.activity.get(), queryParameter, str2, alibcTradeShowParam.getNativeOpenFailedMode(), a(), alibcTradeShowParam == null ? "taobao" : alibcTradeShowParam.getClientType(), alibcTradeTaokeParam, context.urlParam, new ALPSmartLinkCallback() {
            /* class com.alibaba.baichuan.trade.biz.applink.AlibcAppLinkInterceptor.AnonymousClass2 */

            @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
            public void getLinkUrl(boolean z, String str, String str2, int i) {
                AlibcAppLinkInterceptor.this.a(z);
                if (!z) {
                    String urlByFailMode = AlibcTradeHelper.setUrlByFailMode(alibcTradeShowParam.getNativeOpenFailedMode(), context.showParam.getDegradeUrl(), str2);
                    if (!TextUtils.isEmpty(urlByFailMode)) {
                        AlibcLogger.i("AlibcAppLinkInterceptor", "jump shop back to load url: " + urlByFailMode);
                        webView.loadUrl(urlByFailMode);
                    }
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            AlibcLogger.e("AlibcAppLinkInterceptor", "中断异常");
        }
        return this.b;
    }

    private boolean b(final WebView webView, String str, AlibcTradeContext alibcTradeContext) {
        if (alibcTradeContext.showParam == null || !alibcTradeContext.showParam.getOpenType().equals(AlibcTradeShowParam.OpenType.Auto)) {
            return false;
        }
        String str2 = str;
        String queryParameter = new AlibcUriContext(str2).getQueryParameter("id");
        final AlibcTradeContext context = AlibcTradeContextManager.getContext(webView);
        if (TextUtils.isEmpty(queryParameter) || context == null) {
            return false;
        }
        AlibcTradeTaokeParam alibcTradeTaokeParam = context.taokeParam;
        final AlibcTradeShowParam alibcTradeShowParam = context.showParam;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        String degradeUrl = alibcTradeShowParam.getDegradeUrl();
        if (!TextUtils.isEmpty(alibcTradeShowParam.getDegradeUrl())) {
            str2 = degradeUrl;
        }
        AlibcApplink.getInstance().jumpDetail(context.activity.get(), queryParameter, str2, alibcTradeShowParam.getNativeOpenFailedMode(), a(), alibcTradeShowParam == null ? "taobao" : alibcTradeShowParam.getClientType(), alibcTradeTaokeParam, context.urlParam, new ALPSmartLinkCallback() {
            /* class com.alibaba.baichuan.trade.biz.applink.AlibcAppLinkInterceptor.AnonymousClass3 */

            @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
            public void getLinkUrl(boolean z, String str, String str2, int i) {
                AlibcAppLinkInterceptor.this.a(z);
                if (!z) {
                    String urlByFailMode = AlibcTradeHelper.setUrlByFailMode(alibcTradeShowParam.getNativeOpenFailedMode(), context.showParam.getDegradeUrl(), str2);
                    if (!TextUtils.isEmpty(urlByFailMode)) {
                        AlibcLogger.i("AlibcAppLinkInterceptor", "jump detail back to load url: " + urlByFailMode);
                        webView.loadUrl(urlByFailMode);
                    }
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            AlibcLogger.e("AlibcAppLinkInterceptor", "中断异常");
        }
        return this.b;
    }

    private boolean c(final WebView webView, String str, AlibcTradeContext alibcTradeContext) {
        if (alibcTradeContext.showParam == null || !alibcTradeContext.showParam.getOpenType().equals(AlibcTradeShowParam.OpenType.Auto)) {
            return false;
        }
        final AlibcTradeContext context = AlibcTradeContextManager.getContext(webView);
        AlibcTradeTaokeParam alibcTradeTaokeParam = context.taokeParam;
        final AlibcTradeShowParam alibcTradeShowParam = context.showParam;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AlibcApplink.getInstance().jumpTBURI(context.activity.get(), str, TextUtils.isEmpty(alibcTradeShowParam.getDegradeUrl()) ? str : alibcTradeShowParam.getDegradeUrl(), alibcTradeShowParam.getNativeOpenFailedMode(), a(), alibcTradeShowParam == null ? "taobao" : alibcTradeShowParam.getClientType(), alibcTradeTaokeParam, context.urlParam, new ALPSmartLinkCallback() {
            /* class com.alibaba.baichuan.trade.biz.applink.AlibcAppLinkInterceptor.AnonymousClass4 */

            @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
            public void getLinkUrl(boolean z, String str, String str2, int i) {
                AlibcAppLinkInterceptor.this.a(z);
                if (!z) {
                    String urlByFailMode = AlibcTradeHelper.setUrlByFailMode(alibcTradeShowParam.getNativeOpenFailedMode(), context.showParam.getDegradeUrl(), str2);
                    if (!TextUtils.isEmpty(urlByFailMode)) {
                        AlibcLogger.i("AlibcAppLinkInterceptor", "jump url back to load url: " + urlByFailMode);
                        webView.loadUrl(urlByFailMode);
                    }
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            AlibcLogger.e("AlibcAppLinkInterceptor", "中断异常");
        }
        return this.b;
    }

    public static synchronized AlibcAppLinkInterceptor getInstance() {
        AlibcAppLinkInterceptor alibcAppLinkInterceptor;
        synchronized (AlibcAppLinkInterceptor.class) {
            if (a == null) {
                a = new AlibcAppLinkInterceptor();
            }
            alibcAppLinkInterceptor = a;
        }
        return alibcAppLinkInterceptor;
    }

    @Override // com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus.IUrlInterceptor
    public boolean interceptor(WebView webView, String str, InterceptorCallback interceptorCallback, UrlRequest urlRequest) {
        boolean z;
        AlibcTradeContext context = AlibcTradeContextManager.getContext(webView);
        if (str == null || webView == null || context == null) {
            AlarmUtils.alarm("TbopenHandlerAction", "execute", "url is null");
            return false;
        } else if (context.showParam == null || urlRequest == null) {
            return false;
        } else {
            if (AlibcTradeHelper.verifyUrl(AlibcConfigService.getInstance().getUrls(), urlRequest.getUrl())) {
                AlibcLogger.i("AlibcAppLinkInterceptor", "url not match pattern url list");
                return false;
            }
            List<ActionDO> actionPriorityList = urlRequest.getActionPriorityList();
            if (!(actionPriorityList == null || actionPriorityList.size() == 0)) {
                Iterator<ActionDO> it2 = actionPriorityList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if ("native".equals(it2.next().getOpenType())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!(z && context.showParam.getOpenType().equals(AlibcTradeShowParam.OpenType.Auto))) {
                    return false;
                }
                for (ActionDO actionDO : actionPriorityList) {
                    if ("native".equals(actionDO.getOpenType())) {
                        ParamDO param = actionDO.getParam();
                        return "detail".equals(param.getClientPage()) ? b(webView, str, context) : "shop".equals(param.getClientPage()) ? a(webView, str, context) : "add_cart".equals(param.getClientPage()) ? a(webView) : "tab_open".equals(param.getClientPage()) ? a(webView, str) : c(webView, str, context);
                    }
                }
            }
            return false;
        }
    }
}
