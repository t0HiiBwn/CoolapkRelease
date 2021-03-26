package com.alibaba.baichuan.trade.biz;

import android.app.Application;
import com.alibaba.baichuan.trade.biz.AlibcMiniTradeBiz;
import com.alibaba.baichuan.trade.biz.auth.AlibcAuth;
import com.alibaba.baichuan.trade.biz.monitor.InitMonitorPoint;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;

public class AlibcTradeBiz extends AlibcMiniTradeBiz {
    public static AlibcMiniTradeBiz.AlibcTradeBizResult init(Application application) {
        AlibcMiniTradeBiz.AlibcTradeBizResult alibcTradeBizResult = new AlibcMiniTradeBiz.AlibcTradeBizResult();
        InitMonitorPoint initMonitorPoint = new InitMonitorPoint();
        initMonitorPoint.startAllTimeRecord();
        AlibcTradeCommon.AlibcTradeCommonResult init = AlibcTradeCommon.init(application, systemVersion);
        String str = "未知错误";
        int i = 0;
        if (init == null || !init.isSuccess) {
            if (init != null) {
                i = init.errCode;
            }
            alibcTradeBizResult.errCode = i;
            if (init != null) {
                str = init.errMsg;
            }
            alibcTradeBizResult.errMsg = str;
            return alibcTradeBizResult;
        }
        AlibcMiniTradeBiz.AlibcTradeBizResult init2 = AlibcMiniTradeBiz.init();
        if (init2 == null || !init2.isSuccess) {
            if (init2 != null) {
                i = init2.errCode;
            }
            alibcTradeBizResult.errCode = i;
            if (init2 != null) {
                str = init2.errMsg;
            }
            alibcTradeBizResult.errMsg = str;
            return alibcTradeBizResult;
        } else if (!AlibcAuth.init()) {
            alibcTradeBizResult.errCode = 104;
            alibcTradeBizResult.errMsg = "授权服务初始化失败";
            return alibcTradeBizResult;
        } else {
            InitMonitorPoint.registerMonitorPoint();
            AlibcTradeCommon.setTTID(getTTID());
            if (!init2.isSuccess || !init.isSuccess) {
                alibcTradeBizResult.errCode = 105;
                alibcTradeBizResult.errMsg = "biz初始化出错";
                return alibcTradeBizResult;
            }
            initMonitorPoint.setSecurityInitTime(init.initMonitor.securityInitTime);
            initMonitorPoint.setUtInitTime(init.initMonitor.utInitTime);
            initMonitorPoint.stopAllTimeRecord();
            initMonitorPoint.send();
            alibcTradeBizResult.isSuccess = true;
            return alibcTradeBizResult;
        }
    }
}
