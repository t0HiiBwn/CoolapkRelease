package com.alibaba.baichuan.android.trade;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.alibaba.baichuan.android.trade.model.InitResult;
import com.alibaba.baichuan.android.trade.model.InitState;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContextManager;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.alibaba.baichuan.trade.biz.core.usertracker.AlibcTradeBizUT;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.biz.utils.AlibcParamUtils;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class a {
    private static String a = AlibcTradeSDK.class.getName();
    public static InitResult initResult;
    public static InitState initState = new InitState();
    public static List<AlibcTradeInitCallback> pendingInitCallbacks = Collections.synchronizedList(new ArrayList());

    protected static void a(final AlibcTradeInitCallback alibcTradeInitCallback, final InitResult initResult2) {
        initState.setState(3);
        ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
            /* class com.alibaba.baichuan.android.trade.a.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                InitResult initResult = initResult2;
                if (initResult == null) {
                    initResult = InitResult.newFailureResult(0, "未知错误");
                }
                alibcTradeInitCallback.onFailure(initResult.errorCode, initResult.errorMessage);
                for (AlibcTradeInitCallback alibcTradeInitCallback : a.pendingInitCallbacks) {
                    alibcTradeInitCallback.onFailure(initResult.errorCode, initResult.errorMessage);
                }
                a.pendingInitCallbacks.clear();
                a.b(false, initResult.errorCode);
            }
        });
    }

    protected static boolean a(final AlibcTradeInitCallback alibcTradeInitCallback) {
        if (initState.isInitializing()) {
            pendingInitCallbacks.add(alibcTradeInitCallback);
            return false;
        } else if (!initState.isInitialized()) {
            return true;
        } else {
            ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
                /* class com.alibaba.baichuan.android.trade.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    alibcTradeInitCallback.onSuccess();
                }
            });
            return false;
        }
    }

    protected static void b(final AlibcTradeInitCallback alibcTradeInitCallback) {
        AlibcLogger.i(a, "AlibcTradeSDK初始化成功");
        initState.setState(2);
        ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
            /* class com.alibaba.baichuan.android.trade.a.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                alibcTradeInitCallback.onSuccess();
                for (AlibcTradeInitCallback alibcTradeInitCallback : a.pendingInitCallbacks) {
                    alibcTradeInitCallback.onSuccess();
                }
                a.pendingInitCallbacks.clear();
                a.b(true, 0);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void b(boolean z, int i) {
        HashMap hashMap = new HashMap();
        String appKey = AlibcTradeCommon.getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            hashMap.put("appkey", appKey);
        }
        hashMap.put("ttid", AlibcTradeBiz.getTTID());
        hashMap.put("sdkType", "standard");
        hashMap.put("isSuccess", z ? "1" : "0");
        hashMap.put("errorCode", String.valueOf(i));
        AlibcUserTracker.getInstance().sendCustomHit(UserTrackerConstants.E_SDK_INIT, "", hashMap);
        AlibcTradeBizUT.sendInitHit4DAU();
    }

    public static void destory() {
        AlibcTradeContextManager.cleanMap();
    }

    public static void setChannel(String str, String str2) {
        AlibcTradeBiz.setChannel(AlibcParamUtils.getChannel(str, str2));
    }

    public static boolean setISVCode(String str) {
        return AlibcConfigService.getInstance().setIsvCode(str);
    }

    public static void setISVVersion(String str) {
        AlibcTradeCommon.setIsvVersion(str);
    }

    public static void setIsAuthVip(boolean z) {
        AlibcContext.isVip = z;
    }

    public static boolean setShouldUseAlipay(boolean z) {
        return AlibcConfigService.getInstance().setShouldUseAlipay(z);
    }

    public static boolean setSyncForTaoke(boolean z) {
        return AlibcConfigService.getInstance().setIsSyncForTaoke(z);
    }

    public static void setTaokeParams(AlibcTaokeParams alibcTaokeParams) {
        AlibcConfigService.getInstance().setTaokeParams(alibcTaokeParams);
    }
}
