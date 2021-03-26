package com.alibaba.baichuan.android.trade.usertracker.monitor;

import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcDimensionSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasureSet;

public class a extends BaseTradeMonitorPoint {
    private long e;
    private long f;
    private long g;

    public static void k() {
        AlibcDimensionSet addDimension = AlibcDimensionSet.create().addDimension("appkey").addDimension("app_version").addDimension("sdk_version").addDimension("platform").addDimension("pageType").addDimension("taokeType");
        AlibcUserTracker.getInstance().registerPerformancePoint("BCTradeSDK", "showH5", AlibcMeasureSet.create().addMeasure("analysisTime").addMeasure("taokeTime").addMeasure("urlHandleTime").addMeasure("urlLoadTime").addMeasure("allTime"), addDimension);
    }

    public void e() {
        this.e = System.currentTimeMillis();
    }

    public void f() {
        this.e = System.currentTimeMillis() - this.e;
    }

    public void g() {
        this.f = System.currentTimeMillis();
    }

    public void h() {
        this.f = System.currentTimeMillis() - this.f;
    }

    public void i() {
        this.g = System.currentTimeMillis();
    }

    public void j() {
        this.e = 0;
    }
}
