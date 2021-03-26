package com.alibaba.baichuan.trade.biz.login;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.AlibcConstants;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContextManager;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.config.model.BizDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ResourceUtils;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import java.util.HashMap;

public class a implements AlibcUrlBus.IUrlInterceptor {
    private static String[] a = {"^http(s)?://oauth\\.(.*)\\.taobao.com/authorize?(.*)"};
    private static a b;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public void a(WebView webView, String str, boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", AlibcTradeCommon.getAppKey());
        if (AlibcLogin.getInstance().getSession() != null) {
            hashMap.put("userId", AlibcLogin.getInstance().getSession().openId);
        }
        hashMap.put("utdid", AlibcTradeCommon.getUtdid());
        hashMap.put("ttid", AlibcTradeBiz.getTTID());
        hashMap.put("ybhpss", b(webView));
        hashMap.put("isSuccess", z ? "1" : "0");
        hashMap.put("errorCode", String.valueOf(i));
        AlibcUserTracker.getInstance().sendCustomHit(str, "", hashMap);
    }

    private boolean a(final WebView webView) {
        AlibcLogger.d("AlibcLoginInterceptor", "拦截到loginUrl");
        if (AlibcConfigService.getInstance().getLoginDegrade(false)) {
            AlibcLogger.d("AlibcLoginInterceptor", "loginDegrade = false,直接采用H5进行登录");
            return false;
        }
        AlibcLogger.d("AlibcLoginInterceptor", "调用login sdk接口");
        AlibcLogin.getInstance().showLogin(new AlibcLoginCallback() {
            /* class com.alibaba.baichuan.trade.biz.login.a.AnonymousClass2 */

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onFailure(int i, String str) {
                if (webView != null) {
                    AlibcLogger.d("AlibcLoginInterceptor", "登录失败,进入到页面后退逻辑: code = " + i + ", msg = " + str);
                    AlibcConstants.LOGIN_COUNT = AlibcConstants.LOGIN_COUNT + 1;
                    Activity activity = (Activity) webView.getContext();
                    if (!StringUtils.obj2Boolean(webView.getTag(ResourceUtils.getIdentifier(activity, "id", "com_taobao_nb_sdk_webview_click")))) {
                        if (webView.canGoBack()) {
                            webView.goBack();
                        } else if (activity != null) {
                            activity.finish();
                        }
                    }
                    a.this.a(webView, UserTrackerConstants.E_SHOWLOGIN_FAIL, false, i);
                }
            }

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onSuccess(int i, String str, String str2) {
                AlibcLogger.d("AlibcLoginInterceptor", "登录成功,重新加载页面");
                AlibcConstants.LOGIN_COUNT = 0;
                webView.setTag(ResourceUtils.getIdentifier(AlibcTradeCommon.context, "id", "webviewload_monitor_cancel_point"), true);
                webView.reload();
                a.this.a(webView, UserTrackerConstants.E_SHOWLOGIN_SUCCESS, true, 0);
            }
        });
        return true;
    }

    private String b(WebView webView) {
        AlibcTradeContext context;
        if (!(webView == null || (context = AlibcTradeContextManager.getContext(webView)) == null || context.urlParam == null || context.urlParam.get("ybhpss") == null)) {
            Object obj = context.urlParam.get("ybhpss");
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    @Override // com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus.IUrlInterceptor
    public boolean interceptor(final WebView webView, String str, InterceptorCallback interceptorCallback, UrlRequest urlRequest) {
        if (AlibcConstants.LOGIN_COUNT > 2) {
            AlibcLogger.i("AlibcLoginInterceptor", "登录次数超过两次");
            return false;
        }
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config != null) {
            for (BizDO bizDO : config.getBizPattern()) {
                String bizCode = bizDO.getBizCode();
                if ("login".equals(bizCode)) {
                    if (AlibcURLCheck.regular.check(bizDO.getPattern(), str)) {
                        return a(webView);
                    }
                } else if ("logout".equals(bizCode) && AlibcURLCheck.regular.check(bizDO.getPattern(), str)) {
                    AlibcLogger.d("AlibcLoginInterceptor", "拦截到logoutUrl,调用login sdk登出接口");
                    AlibcLogin.getInstance().logout(new AlibcLoginCallback() {
                        /* class com.alibaba.baichuan.trade.biz.login.a.AnonymousClass1 */

                        @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
                        public void onFailure(int i, String str) {
                            AlibcLogger.d("AlibcLoginInterceptor", "登出失败");
                        }

                        @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
                        public void onSuccess(int i, String str, String str2) {
                            AlibcLogger.d("AlibcLoginInterceptor", "登出成功");
                            AlibcLogin.getInstance().showLogin(new AlibcLoginCallback() {
                                /* class com.alibaba.baichuan.trade.biz.login.a.AnonymousClass1.AnonymousClass1 */

                                @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
                                public void onFailure(int i, String str) {
                                    AlibcLogger.e("AlibcLoginInterceptor", "切换账号登录失败");
                                }

                                @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
                                public void onSuccess(int i, String str, String str2) {
                                    AlibcLogger.d("AlibcLoginInterceptor", "切换账号登录成功");
                                    webView.reload();
                                }
                            });
                        }
                    });
                    return true;
                }
            }
        }
        return false;
    }
}
