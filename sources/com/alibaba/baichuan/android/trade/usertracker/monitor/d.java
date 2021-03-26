package com.alibaba.baichuan.android.trade.usertracker.monitor;

import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcDimensionSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasureSet;

public class d {
    public static void a() {
        AlibcDimensionSet addDimension = AlibcDimensionSet.create().addDimension("appkey").addDimension("app_version").addDimension("sdk_version").addDimension("platform");
        AlibcUserTracker.getInstance().registerPerformancePoint("BCTradeSDK", "urlLoad", AlibcMeasureSet.create().addMeasure("urlHandleTime").addMeasure("urlLoadTime").addMeasure("allTime"), addDimension);
    }
}
