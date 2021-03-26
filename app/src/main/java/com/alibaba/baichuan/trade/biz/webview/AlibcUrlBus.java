package com.alibaba.baichuan.trade.biz.webview;

import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfig;
import com.alibaba.baichuan.trade.biz.core.config.model.CodeDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.RequestBuilder;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlibcUrlBus {
    private static List<IUrlInterceptor> a = new ArrayList();

    public interface IUrlInterceptor {
        boolean interceptor(WebView webView, String str, InterceptorCallback interceptorCallback, UrlRequest urlRequest);
    }

    static synchronized boolean a(WebView webView, String str, InterceptorCallback interceptorCallback) {
        boolean z;
        synchronized (AlibcUrlBus.class) {
            z = false;
            UrlRequest buildInterceptRequest = RequestBuilder.buildInterceptRequest((ConfigDO) AlibcConfig.readObjectFromFile(AlibcTradeCommon.context, "bc_config"), new RequestBuildCallback() {
                /* class com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus.AnonymousClass1 */

                @Override // com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback
                public void onBuildComplete(UrlRequest urlRequest, int i) {
                }

                @Override // com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback
                public void onBuildFail(int i) {
                }
            }, new UrlRequest(str), new ParseCallback() {
                /* class com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus.AnonymousClass2 */

                @Override // com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback
                public void onGenUrl(UrlRequest urlRequest, CodeDO codeDO) {
                }
            });
            if (buildInterceptRequest != null) {
                Iterator<IUrlInterceptor> it2 = a.iterator();
                while (it2.hasNext() && !(z = it2.next().interceptor(webView, str, interceptorCallback, buildInterceptRequest))) {
                }
            }
        }
        return z;
    }

    public static synchronized void registInterceptor(IUrlInterceptor iUrlInterceptor) {
        synchronized (AlibcUrlBus.class) {
            if (iUrlInterceptor != null) {
                a.add(0, iUrlInterceptor);
            }
        }
    }
}
