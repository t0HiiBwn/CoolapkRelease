package com.alibaba.baichuan.trade.common;

import android.app.Application;
import com.alibaba.baichuan.trade.common.adapter.mtop.AlibcMtop;
import com.alibaba.baichuan.trade.common.adapter.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.monitor.CommonInitMonitor;
import com.ut.device.UTDevice;

public class AlibcTradeCommon extends AlibcMiniTradeCommon {

    public static class AlibcTradeCommonResult {
        public int errCode;
        public String errMsg;
        public CommonInitMonitor initMonitor = new CommonInitMonitor();
        public boolean isSuccess = false;
    }

    public static String getAppKey() {
        return b;
    }

    public static Environment getEnvironment() {
        return e;
    }

    public static String getUtdid() {
        return a;
    }

    public static AlibcTradeCommonResult init(Application application, String str) {
        String str2;
        AlibcTradeCommonResult alibcTradeCommonResult = new AlibcTradeCommonResult();
        if (application == null) {
            return alibcTradeCommonResult;
        }
        context = application;
        if (str == null) {
            str = "99";
        }
        systemVersion = str;
        a = UTDevice.getUtdid(application);
        alibcTradeCommonResult.initMonitor.startSecurityInitRecord();
        AlibcSecurityGuard.a init = AlibcSecurityGuard.getInstance().init();
        alibcTradeCommonResult.initMonitor.stopSecurityInitRecord();
        if (init == null || init.a == 1) {
            alibcTradeCommonResult.errCode = 1;
            str2 = "安全初始化失败";
        } else {
            b = AlibcSecurityGuard.getInstance().getAppKey();
            alibcTradeCommonResult.initMonitor.startUTInitRecord();
            AlibcUserTracker.AlibcUserTrackerResult init2 = AlibcUserTracker.getInstance().init();
            alibcTradeCommonResult.initMonitor.stopUTInitRecord();
            if (init2.result == 1) {
                alibcTradeCommonResult.errCode = 2;
                str2 = "UT初始化失败";
            } else if (AlibcMtop.getInstance().init() == 1) {
                alibcTradeCommonResult.errCode = 3;
                str2 = "mtop初始化失败";
            } else {
                alibcTradeCommonResult.isSuccess = true;
                return alibcTradeCommonResult;
            }
        }
        alibcTradeCommonResult.errMsg = str2;
        return alibcTradeCommonResult;
    }

    public static boolean isDebug() {
        return c;
    }

    public static void setChannel(String str) {
        AlibcUserTracker.getInstance().setChannel(str);
    }

    public static void setTTID(String str) {
        AlibcMiniTradeCommon.setTTID(str);
    }

    public static void turnOffDebug() {
        c = false;
        AlibcMtop.getInstance().turnOffDebug();
        AlibcUserTracker.getInstance().turnOffDebug();
    }

    public static void turnOnDebug() {
        c = true;
        AlibcMtop.getInstance().turnOnDebug();
        AlibcUserTracker.getInstance().turnOnDebug();
    }
}
