package com.alibaba.baichuan.trade.common.adapter.ut;

import com.alibaba.baichuan.trade.common.AlibcTradeCommon;

public class AlibcUserTradeHelper {
    public static String getArgs() {
        ArgsInfo argsInfo = new ArgsInfo();
        argsInfo.appKey = AlibcTradeCommon.getAppKey();
        argsInfo.sdkVersion = AlibcTradeCommon.systemVersion;
        return argsInfo.getJSONString();
    }

    public static void sendUsabilityFailure(String str, String str2, String str3) {
        AlibcUserTracker.getInstance().sendUsabilityFailure("BCTradeSDK", str, getArgs(), str3, str2);
    }

    public static void sendUsabilitySuccess(String str) {
        AlibcUserTracker.getInstance().sendUsabilitySuccess("BCTradeSDK", str, getArgs());
    }
}
