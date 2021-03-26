package com.alibaba.baichuan.trade.biz;

import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplink;
import com.alibaba.baichuan.trade.biz.core.a.f;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcPluginManager;
import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;
import com.alibaba.baichuan.trade.biz.urlroute.a;
import com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus;
import com.alibaba.baichuan.trade.biz.webview.AlibcWebViewProxy;
import com.alibaba.baichuan.trade.common.AlibcMiniTradeCommon;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.concurrent.CountDownLatch;

public class AlibcMiniTradeBiz {
    private static String a = null;
    private static CountDownLatch b = null;
    public static String channel = "0";
    public static String systemVersion = "4.0.0.13";

    public static class AlibcTradeBizResult {
        public int errCode;
        public String errMsg;
        public boolean isSuccess = false;
    }

    public static String getTTID() {
        String format = String.format("2014_%s_%s@baichuan_android_%s", channel, AlibcMiniTradeCommon.getAppKey(), AlibcTradeBiz.systemVersion);
        a = format;
        return format;
    }

    public static AlibcTradeBizResult init() {
        String str;
        AlibcTradeBizResult alibcTradeBizResult = new AlibcTradeBizResult();
        b = new CountDownLatch(1);
        AlibcWebViewProxy.init();
        AlibcConfigService.getInstance().init(AlibcTradeCommon.context, "100");
        AlibcUrlBus.registInterceptor(a.a());
        final boolean[] zArr = {false};
        AlibcLogin.getInstance().init(new AlibcLoginCallback() {
            /* class com.alibaba.baichuan.trade.biz.AlibcMiniTradeBiz.AnonymousClass1 */

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onFailure(int i, String str) {
                zArr[0] = false;
                AlibcMiniTradeBiz.b.countDown();
            }

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onSuccess(int i, String str, String str2) {
                zArr[0] = true;
                AlibcMiniTradeBiz.b.countDown();
            }
        });
        AlibcPluginManager.registerPlugin(f.a, f.class, true);
        AlibcApplink.AlibcApplinkResult init = AlibcApplink.getInstance().init();
        if (init == null || init.result != 0) {
            alibcTradeBizResult.errCode = 101;
            str = "Applink初始化失败";
        } else {
            try {
                b.await();
                if (!zArr[0]) {
                    alibcTradeBizResult.errCode = 102;
                    str = "登录初始化失败";
                } else {
                    alibcTradeBizResult.isSuccess = true;
                    return alibcTradeBizResult;
                }
            } catch (InterruptedException e) {
                AlibcLogger.e("init", "闭锁超时", e);
                alibcTradeBizResult.errCode = 102;
                str = "登录初始化没有返回";
            }
        }
        alibcTradeBizResult.errMsg = str;
        return alibcTradeBizResult;
    }

    public static void setChannel(String str) {
        AlibcTradeBiz.channel = str;
        a = String.format("2014_%s_%s@baichuan_android_%s", str, AlibcMiniTradeCommon.getAppKey(), systemVersion);
        AlibcApplink.getInstance().setTTID(a);
        AlibcMiniTradeCommon.setTTID(a);
    }

    public static void turnOffDebug() {
        AlibcLogin.getInstance().turnOffDebug();
        AlibcApplink.getInstance().turnOffDebug();
    }

    public static void turnOnDebug() {
        AlibcLogin.getInstance().turnOnDebug();
        AlibcApplink.getInstance().turnOnDebug();
    }
}
