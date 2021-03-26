package com.alibaba.baichuan.android.trade;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.b.b;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.miniapp.a;
import com.alibaba.baichuan.android.trade.miniapp.handler.c;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.config.model.CodeDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.RequestBuilder;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.alibaba.baichuan.trade.biz.utils.AlibcTradeHelper;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlarmUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;
import java.util.Map;

public class AlibcTrade {
    public static final String ALI_URL = "^(?:https?):\\/\\/(([^/\\?#]+\\.)*((taobao|tmall|juhuasuan|xiami|amap|taobaocdn|alipay|etao|alibaba|aliyun|alimama|weibo|tanx|laiwang|alicdn|mmstat|yunos|alibaba-inc|alitrip|aliloan|kanbox|wirlesshare|dingtalk|alimei|cnzz|kuaidadi|autonavi|m\\.yintai|polyinno|spdyidea|h5util|h5tool|5945i|miaostreet|1688|cainiao|taohua|m\\.dfkhgj|m\\.edcdfg|liangxinyao|taopiaopiao)\\.com|(tb|tbcdn|weibo|mashort|mybank|ba\\.ugame\\.uc|game\\.uc)\\.cn|(fastidea|juzone)\\.(me|cc)|lwurl\\.to|(taobao|alipay|cnzz)\\.net|tdd\\.la|yao\\.95095\\.com|(tmall|alipay)\\.hk|ahd\\.so|atb\\.so|mshare\\.cc|juhs\\.me|xianyu\\.mobi)([\\?|#|/].*)?)$";
    public static final String ERRCODE_APPLINK_FAIL = "03";
    public static final String ERRCODE_PAGE_H5 = "12";
    public static final String ERRCODE_PAGE_NATIVE = "11";
    public static final String ERRCODE_PARAM_ERROR = "01";
    public static final String ERRMSG_APPLINK_FAIL = "applink调用失败";
    public static final String ERRMSG_LOAD_FAIL = "加载失败";
    public static final String ERRMSG_PARAM_ERROR = "参数错误";
    public static final String MONITOR_POINT_H5 = "Page_H5";
    public static final String MONITOR_POINT_NATIVE = "Page_Native";
    public static final int SHOW_FAILURE = -1;
    public static final int SHOW_H5 = 1;
    public static final int SHOW_MINIAPP = 2;
    public static final int SHOW_NATIVE = 0;

    private static class MyAlibcTradeCallback implements AlibcTradeContext.AlibcTradeCallback {
        AlibcTradeCallback tradeProcessCallback;

        public MyAlibcTradeCallback(AlibcTradeCallback alibcTradeCallback) {
            this.tradeProcessCallback = alibcTradeCallback;
        }

        @Override // com.alibaba.baichuan.trade.biz.context.AlibcTradeContext.AlibcTradeCallback
        public void onFailure(int i, String str) {
            AlibcTradeCallback alibcTradeCallback = this.tradeProcessCallback;
            if (alibcTradeCallback != null) {
                alibcTradeCallback.onFailure(i, str);
            }
        }

        @Override // com.alibaba.baichuan.trade.biz.context.AlibcTradeContext.AlibcTradeCallback
        public void onTradeSuccess(AlibcTradeResult alibcTradeResult) {
            AlibcTradeCallback alibcTradeCallback = this.tradeProcessCallback;
            if (alibcTradeCallback != null) {
                alibcTradeCallback.onTradeSuccess(alibcTradeResult);
            }
        }
    }

    private static AlibcTradeContext a(Activity activity, a aVar, UrlRequest urlRequest, WebView webView, AlibcShowParams alibcShowParams, Map<String, String> map, AlibcTaokeParams alibcTaokeParams, AlibcTradeCallback alibcTradeCallback) {
        int d;
        AlibcBasePage b;
        b c;
        if (alibcShowParams == null) {
            alibcShowParams = new AlibcShowParams();
        }
        Map<String, String> createUrlParams = AlibcTradeHelper.createUrlParams(map);
        AlibcLogger.d("AlibcTrade", "构造urlParams = " + createUrlParams);
        if (alibcTaokeParams == null && AlibcConfigService.getInstance().getGlobalTaokeParams() != null) {
            alibcTaokeParams = AlibcConfigService.getInstance().getGlobalTaokeParams();
            AlibcLogger.d("AlibcTrade", "流程淘客参数为空,全局淘客参数不为空,采用全局淘客参数,taokeParams = " + alibcTaokeParams);
        }
        if (alibcTaokeParams != null && alibcTaokeParams.isAdZoneIdExist() && ((d = aVar.d()) != 100 ? !(d != 200 || (b = aVar.b()) == null || !b.supportAid()) : !((c = aVar.c()) == null || !c.c()))) {
            alibcTaokeParams.pid = null;
        }
        if (urlRequest == null) {
            return null;
        }
        HashMap<String, Object> fields = urlRequest.getFields();
        if (!fields.containsKey("urlType")) {
            return null;
        }
        if ("miniapp".equals(fields.get("urlType"))) {
            return new AlibcTradeContext(activity, b.a(alibcShowParams), b.a(alibcTaokeParams), b.a(createUrlParams), new MyAlibcTradeCallback(alibcTradeCallback));
        }
        if ("h5".equals(fields.get("urlType"))) {
            return new AlibcTradeContext(activity, webView, b.a(alibcShowParams), b.a(alibcTaokeParams), b.a(createUrlParams), new MyAlibcTradeCallback(alibcTradeCallback));
        }
        return null;
    }

    private static String a(String str) {
        String str2;
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("?")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "&ttid=";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "?ttid=";
        }
        sb.append(str2);
        sb.append(AlibcTradeCommon.ttid);
        return sb.toString();
    }

    private static Map<String, String> a(Map<String, String> map, String str) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("identity", str);
        return map;
    }

    private static void a(Activity activity, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, UrlRequest urlRequest, a aVar, AlibcTradeCallback alibcTradeCallback) {
        AlibcTradeContext a = a(activity, aVar, urlRequest, webView, alibcShowParams, map, alibcTaokeParams, alibcTradeCallback);
        if (a != null) {
            a.setWebViewClient(webViewClient);
            a.setWebChromeClient(webChromeClient);
            Map<String, String> createUrlParams = AlibcTradeHelper.createUrlParams(map);
            AlibcLogger.i("AlibcTrade", "params=" + createUrlParams);
            a(urlRequest, a, aVar);
        }
    }

    private static void a(final Activity activity, String str, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, final AlibcTradeCallback alibcTradeCallback) {
        int i;
        String str2;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (a(config)) {
            AlibcLogger.i("AlibcTrade", config.getEm());
            i = 1300;
            str2 = config.getEm();
        } else {
            UrlRequest buildRequest = RequestBuilder.buildRequest(config, new RequestBuildCallback() {
                /* class com.alibaba.baichuan.android.trade.AlibcTrade.AnonymousClass1 */

                @Override // com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback
                public void onBuildComplete(UrlRequest urlRequest, int i) {
                    AlibcLogger.i("AlibcTrade", "request build complete: result code =" + i);
                }

                @Override // com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback
                public void onBuildFail(int i) {
                    if (i == 1000) {
                        Toast.makeText(activity, "该页面不支持url的开发方式，请使用code方式~", 0).show();
                        alibcTradeCallback.onFailure(1000, "该页面不支持url的打开方式，请采用code的方式打开~");
                    }
                    if (i == 1600) {
                        alibcTradeCallback.onFailure(1600, "url为空");
                    }
                    if (i == 1100) {
                        alibcTradeCallback.onFailure(1100, "获取配置数据为空");
                    }
                }
            }, new UrlRequest(str), new ParseCallback() {
                /* class com.alibaba.baichuan.android.trade.AlibcTrade.AnonymousClass2 */

                @Override // com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback
                public void onGenUrl(UrlRequest urlRequest, CodeDO codeDO) {
                }
            });
            if (buildRequest != null) {
                com.alibaba.baichuan.android.trade.miniapp.b.a(new c(AlibcTradeCommon.context, buildRequest));
                b bVar = new b(str);
                buildRequest.setUrl(bVar.b());
                if (!a(bVar, activity, alibcTradeCallback)) {
                    AlibcLogger.d("AlibcTrade", "检查参数错误, 页面打开流程结束");
                    i = 500;
                    str2 = "参数错误";
                } else {
                    a a = a.a();
                    a.a(bVar);
                    a.a(100);
                    a(activity, webView, webViewClient, webChromeClient, alibcShowParams, alibcTaokeParams, map, buildRequest, a, alibcTradeCallback);
                    return;
                }
            } else {
                return;
            }
        }
        alibcTradeCallback.onFailure(i, str2);
    }

    private static void a(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, a aVar) {
        com.alibaba.baichuan.android.trade.miniapp.b.a(urlRequest, alibcTradeContext, aVar);
    }

    private static boolean a(b bVar, Activity activity, AlibcTradeCallback alibcTradeCallback) {
        a.C0010a a;
        if (alibcTradeCallback == null) {
            a = a.C0010a.a(14, "tradeProcessCallback");
        } else if (activity == null) {
            a = a.C0010a.a(14, "Activity");
        } else if (bVar != null && bVar.a()) {
            return true;
        } else {
            a = a.C0010a.a(14, "AlibcPage");
        }
        com.alibaba.baichuan.android.trade.b.c.a(alibcTradeCallback, a);
        return false;
    }

    private static boolean a(AlibcBasePage alibcBasePage, Activity activity, AlibcTradeCallback alibcTradeCallback) {
        a.C0010a a;
        if (alibcTradeCallback == null) {
            a = a.C0010a.a(14, "tradeProcessCallback");
        } else if (activity == null) {
            a = a.C0010a.a(14, "Activity");
        } else if (alibcBasePage != null && alibcBasePage.checkParams()) {
            return true;
        } else {
            a = a.C0010a.a(14, "AlibcPage");
        }
        com.alibaba.baichuan.android.trade.b.c.a(alibcTradeCallback, a);
        return false;
    }

    private static boolean a(ConfigDO configDO) {
        return configDO != null && configDO.getSt() == 0;
    }

    public static void openByBizCode(Activity activity, final AlibcBasePage alibcBasePage, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, String str, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, final AlibcTradeCallback alibcTradeCallback) {
        int i;
        String str2;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (a(config)) {
            AlibcLogger.i("AlibcTrade", config.getEm());
            i = 1300;
            str2 = config.getEm();
        } else {
            UrlRequest urlRequest = new UrlRequest("");
            urlRequest.setBizCode(str);
            com.alibaba.baichuan.android.trade.miniapp.a a = com.alibaba.baichuan.android.trade.miniapp.a.a();
            a.a(alibcBasePage);
            a.a(200);
            if (!a(alibcBasePage, activity, alibcTradeCallback)) {
                AlibcLogger.d("AlibcTrade", "检查参数错误, 页面打开流程结束");
                if (alibcBasePage == null) {
                    AlarmUtils.alarm("AlibcTrade", "sendUsabilityFailure", "tradePage is null!");
                    AlibcLogger.e("AlibcTrade", "tradePage is null");
                }
                i = 500;
                str2 = "参数错误";
            } else {
                UrlRequest buildRequest = RequestBuilder.buildRequest(config, new RequestBuildCallback() {
                    /* class com.alibaba.baichuan.android.trade.AlibcTrade.AnonymousClass3 */

                    @Override // com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback
                    public void onBuildComplete(UrlRequest urlRequest, int i) {
                        AlibcLogger.i("AlibcTrade", "build request finish");
                    }

                    @Override // com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback
                    public void onBuildFail(int i) {
                        AlibcLogger.i("AlibcTrade", "build request fail");
                        if (i == 1200) {
                            alibcTradeCallback.onFailure(1200, "该code不存在~");
                        }
                        if (i == 1600) {
                            alibcTradeCallback.onFailure(1600, "url为空");
                        }
                        if (i == 1100) {
                            alibcTradeCallback.onFailure(1100, "获取配置数据为空");
                        }
                    }
                }, urlRequest, new ParseCallback() {
                    /* class com.alibaba.baichuan.android.trade.AlibcTrade.AnonymousClass4 */

                    @Override // com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback
                    public void onGenUrl(UrlRequest urlRequest, CodeDO codeDO) {
                        StringBuilder sb;
                        String str;
                        String genOpenUrl = alibcBasePage.genOpenUrl(codeDO.getUrl());
                        if (!TextUtils.isEmpty(genOpenUrl)) {
                            if (genOpenUrl.contains("?")) {
                                sb = new StringBuilder();
                                sb.append(genOpenUrl);
                                str = "&ttid=";
                            } else {
                                sb = new StringBuilder();
                                sb.append(genOpenUrl);
                                str = "?ttid=";
                            }
                            sb.append(str);
                            sb.append(AlibcTradeCommon.ttid);
                            genOpenUrl = sb.toString();
                        }
                        urlRequest.setUrl(genOpenUrl);
                        urlRequest.setPageType(codeDO.getName());
                    }
                });
                if (buildRequest != null) {
                    com.alibaba.baichuan.android.trade.miniapp.b.a(new c(AlibcTradeCommon.context, buildRequest));
                    a(activity, webView, webViewClient, webChromeClient, alibcShowParams, alibcTaokeParams, map, buildRequest, a, alibcTradeCallback);
                    return;
                }
                return;
            }
        }
        alibcTradeCallback.onFailure(i, str2);
    }

    public static void openByUrl(Activity activity, String str, String str2, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, AlibcTradeCallback alibcTradeCallback) {
        a(activity, a(str2), webView, webViewClient, webChromeClient, alibcShowParams, alibcTaokeParams, a(map, str), alibcTradeCallback);
    }
}
