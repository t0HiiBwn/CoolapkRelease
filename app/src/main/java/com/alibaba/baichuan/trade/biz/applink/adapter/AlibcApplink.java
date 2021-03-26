package com.alibaba.baichuan.trade.biz.applink.adapter;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.ALPTBLinkPartnerSDK;
import com.alibaba.alibclinkpartner.linkpartner.param.ALPJumpFailedStrategy;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPDetailParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPShopParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPURIParam;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.applink.AlibcAppLinkInterceptor;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcPluginManager;
import com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Map;

public class AlibcApplink {
    public static final int ERR_CODE = 101;
    public static final String ERR_MSG = "Applink初始化失败";
    private static volatile AlibcApplink b;
    private boolean a;

    /* renamed from: com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplink$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AlibcFailModeType.values().length];
            a = iArr;
            try {
                iArr[AlibcFailModeType.AlibcNativeFailModeNONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AlibcFailModeType.AlibcNativeFailModeJumpH5.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AlibcFailModeType.AlibcNativeFailModeJumpBROWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AlibcFailModeType.AlibcNativeFailModeJumpDOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class AlibcApplinkResult {
        public static final int APPLINK_INIT_AD = 2;
        public static final int APPLINK_INIT_FAIL = 1;
        public static final int APPLINK_INIT_SUCCESS = 0;
        public int errorCode;
        public String errorMessage;
        public int result;

        public AlibcApplinkResult() {
            this.result = 0;
        }

        public AlibcApplinkResult(int i) {
            this.result = 0;
            this.result = i;
        }

        public AlibcApplinkResult(int i, String str) {
            this.result = 0;
            this.result = 1;
            this.errorCode = i;
            this.errorMessage = str;
        }
    }

    private AlibcApplink() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r4 != 4) goto L_0x0029;
     */
    private ALPJumpFailedStrategy a(AlibcFailModeType alibcFailModeType) {
        ALPJumpFailedStrategy aLPJumpFailedStrategy = new ALPJumpFailedStrategy();
        int i = 5;
        aLPJumpFailedStrategy.mode = 5;
        if (alibcFailModeType == null) {
            return aLPJumpFailedStrategy;
        }
        int i2 = AnonymousClass1.a[alibcFailModeType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                i = 3;
                if (i2 == 3) {
                    aLPJumpFailedStrategy.mode = 6;
                }
            } else {
                aLPJumpFailedStrategy.mode = 4;
            }
            return aLPJumpFailedStrategy;
        }
        aLPJumpFailedStrategy.mode = i;
        return aLPJumpFailedStrategy;
    }

    private void a(ALPTBJumpParam aLPTBJumpParam, String str, String str2, String str3, AlibcTradeTaokeParam alibcTradeTaokeParam, Map<String, String> map) {
        if (aLPTBJumpParam != null) {
            if (!TextUtils.isEmpty(str)) {
                aLPTBJumpParam.backUrl = str;
            }
            if (!TextUtils.isEmpty(str3)) {
                aLPTBJumpParam.linkKey = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                aLPTBJumpParam.h5Url = str2;
            }
            aLPTBJumpParam.bcFlSrc = "bc_standard_android";
            if (alibcTradeTaokeParam != null) {
                if (!TextUtils.isEmpty(alibcTradeTaokeParam.pid)) {
                    aLPTBJumpParam.putParam("pid", alibcTradeTaokeParam.pid);
                }
                if (!TextUtils.isEmpty(alibcTradeTaokeParam.subPid)) {
                    aLPTBJumpParam.putParam("subpid", alibcTradeTaokeParam.subPid);
                }
                if (!TextUtils.isEmpty(alibcTradeTaokeParam.unionId)) {
                    aLPTBJumpParam.putParam("unionId", alibcTradeTaokeParam.unionId);
                }
            }
            if (map != null && !TextUtils.isEmpty(map.get("isv_code"))) {
                aLPTBJumpParam.putParam("tag", map.get("isv_code"));
            }
            if (map != null) {
                aLPTBJumpParam.putParams(map);
            }
        }
    }

    public static synchronized AlibcApplink getInstance() {
        AlibcApplink alibcApplink;
        synchronized (AlibcApplink.class) {
            if (b == null) {
                b = new AlibcApplink();
            }
            alibcApplink = b;
        }
        return alibcApplink;
    }

    public static boolean isApplinkSupported(String str) {
        return ALPTBLinkPartnerSDK.isSupportLinkKey(str);
    }

    public AlibcApplinkResult init() {
        if (this.a) {
            return new AlibcApplinkResult(2);
        }
        ALPTBLinkPartnerSDK.setDebugStatus(AlibcTradeCommon.isDebug(), AlibcTradeCommon.isDebug());
        ALPTBLinkPartnerSDK.setTTID(AlibcTradeBiz.getTTID());
        if (2 != ALPTBLinkPartnerSDK.init(AlibcTradeCommon.context, AlibcTradeCommon.getAppKey()) / 100) {
            return new AlibcApplinkResult(1);
        }
        ALPTBLinkPartnerSDK.setSupportJumpFailedOpenTaobao(true);
        AlibcPluginManager.registerPlugin(AlibcApplinkPlugin.API_NAME, AlibcApplinkPlugin.class, true);
        AlibcUrlBus.registInterceptor(AlibcAppLinkInterceptor.getInstance());
        this.a = true;
        return new AlibcApplinkResult(0);
    }

    public void jumpDetail(Context context, String str, String str2, AlibcFailModeType alibcFailModeType, String str3, String str4, AlibcTradeTaokeParam alibcTradeTaokeParam, Map<String, String> map, ALPSmartLinkCallback aLPSmartLinkCallback) {
        ALPDetailParam aLPDetailParam = new ALPDetailParam(str);
        a(aLPDetailParam, str3, str2, str4, alibcTradeTaokeParam, map);
        try {
            ALPTBLinkPartnerSDK.jumpDetail(context, aLPDetailParam, a(alibcFailModeType), aLPSmartLinkCallback);
        } catch (Exception e) {
            AlibcLogger.e("AliTradeApplinkServiceImp", "Applink調用jumpDetail失败：" + e.getMessage());
        }
    }

    public void jumpShop(Context context, String str, String str2, AlibcFailModeType alibcFailModeType, String str3, String str4, AlibcTradeTaokeParam alibcTradeTaokeParam, Map<String, String> map, ALPSmartLinkCallback aLPSmartLinkCallback) {
        ALPShopParam aLPShopParam = new ALPShopParam(str);
        a(aLPShopParam, str3, str2, str4, alibcTradeTaokeParam, map);
        try {
            ALPTBLinkPartnerSDK.jumpShop(context, aLPShopParam, a(alibcFailModeType), aLPSmartLinkCallback);
        } catch (Exception e) {
            AlibcLogger.e("AliTradeApplinkServiceImp", "Applink調用jumpShop失败：" + e.getMessage());
        }
    }

    public void jumpTBURI(Context context, String str, String str2, AlibcFailModeType alibcFailModeType, String str3, String str4, AlibcTradeTaokeParam alibcTradeTaokeParam, Map<String, String> map, ALPSmartLinkCallback aLPSmartLinkCallback) {
        if (!TextUtils.isEmpty(str)) {
            ALPURIParam aLPURIParam = new ALPURIParam(str);
            a(aLPURIParam, str3, str2, str4, alibcTradeTaokeParam, map);
            try {
                ALPTBLinkPartnerSDK.jumpURI(context, aLPURIParam, a(alibcFailModeType), aLPSmartLinkCallback);
            } catch (Exception e) {
                AlibcLogger.e("AliTradeApplinkServiceImp", "Applink調用jumpDetail失败：" + e.getMessage());
            }
        }
    }

    public void setTTID(String str) {
        ALPTBLinkPartnerSDK.setTTID(str);
    }

    public void turnOffDebug() {
        ALPTBLinkPartnerSDK.setDebugStatus(false, false);
    }

    public void turnOnDebug() {
        ALPTBLinkPartnerSDK.setDebugStatus(true, true);
    }
}
