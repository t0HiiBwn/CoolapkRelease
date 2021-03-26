package com.huawei.hms.framework.network.grs;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hianalytics.RCEventListener;
import com.huawei.hms.framework.network.restclient.hwhttp.Interceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.RealInterceptorChain;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.url.HttpUrl;

public class e implements PluginInterceptor {
    private static final String a = "e";

    public Response intercept(Interceptor.Chain chain) {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        String url = request.getUrl().getUrl();
        if (!GrsManager.isGRSSchema(url)) {
            return realInterceptorChain.proceed(request);
        }
        String str = a;
        Logger.v(str, "request url is grs schema.");
        RCEventListener rCEventListener = realInterceptorChain.getRCEventListener();
        rCEventListener.convertGrsStart(url);
        String parseGrs = GrsManager.getInstance().parseGrs(url);
        Request build = request.newBuilder().url(new HttpUrl(parseGrs)).build();
        Logger.v(str, "origin url is grs schema and by intercepted,and now request is:%s", build.toString());
        rCEventListener.convertGrsEnd(parseGrs);
        return realInterceptorChain.proceed(build);
    }

    public String pluginName() {
        return getClass().getSimpleName();
    }
}
