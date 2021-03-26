package com.alibaba.baichuan.trade.biz.urlroute;

import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContextManager;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTrackParam;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.biz.utils.CacheUtil;
import com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.List;

public class a implements AlibcUrlBus.IUrlInterceptor {
    private static a a;

    private a() {
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

    @Override // com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus.IUrlInterceptor
    public boolean interceptor(WebView webView, String str, InterceptorCallback interceptorCallback, UrlRequest urlRequest) {
        AlibcLogger.d("AlibcTradeParamInterceptor", "进入到加参数拦截器,url = " + str);
        AlibcTradeContext context = AlibcTradeContextManager.getContext(webView);
        if (context == null || urlRequest.getFields().get("urlType").equals("miniapp")) {
            return false;
        }
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null) {
            config = (ConfigDO) CacheUtil.getInstance().getContent("bc_config");
        }
        if (config != null) {
            List<String> addParamUrls = config.getAddParamUrls();
            if (!AlibcURLCheck.regular.check((String[]) addParamUrls.toArray(new String[addParamUrls.size()]), str)) {
                AlibcLogger.d("AlibcTradeParamInterceptor", "该url不满足匹配规则");
                return false;
            }
            AlibcTradeTrackParam alibcTradeTrackParam = context.urlParam;
            AlibcLogger.d("AlibcTradeParamInterceptor", "拦截加参的参数为, urlParams = " + alibcTradeTrackParam);
            String addParamsUrl = new AlibcUriContext(str).getAddParamsUrl(alibcTradeTrackParam);
            if (!TextUtils.isEmpty(addParamsUrl) && !addParamsUrl.equals(str)) {
                AlibcLogger.d("AlibcTradeParamInterceptor", "加参数后的url与原来的url不一样,重新调用webview.loadUrl,新的url = " + addParamsUrl);
                webView.loadUrl(addParamsUrl);
                return true;
            }
        }
        return false;
    }
}
