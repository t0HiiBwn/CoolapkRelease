package com.alibaba.baichuan.android.trade.usertracker.monitor;

import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcDimensionSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcDimensionValueSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasureSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasureValueSet;
import com.alibaba.baichuan.trade.common.utils.AlibcTradeCommonUtil;

public class c extends BaseTradeMonitorPoint {
    public long e;

    public static void g() {
        AlibcDimensionSet addDimension = AlibcDimensionSet.create().addDimension("appkey").addDimension("app_version").addDimension("sdk_version").addDimension("platform").addDimension("pageType");
        AlibcUserTracker.getInstance().registerPerformancePoint("BCTradeSDK", "showNative", AlibcMeasureSet.create().addMeasure("analysisTime").addMeasure("goTaobaoTime").addMeasure("allTime"), addDimension);
    }

    public void e() {
        this.e = System.currentTimeMillis();
    }

    public void f() {
        this.e = System.currentTimeMillis() - this.e;
    }

    public void h() {
        AlibcUserTracker.getInstance().sendPerfomancePoint("BCTradeSDK", "showNative", AlibcDimensionValueSet.create().setValue("appkey", AlibcTradeCommon.getAppKey()).setValue("app_version", AlibcTradeCommonUtil.getVersion(AlibcTradeCommon.context)).setValue("sdk_version", AlibcTradeCommon.systemVersion).setValue("platform", "android").setValue("pageType", this.b), AlibcMeasureValueSet.create().setValue("analysisTime", (double) this.c).setValue("goTaobaoTime", (double) this.e).setValue("allTime", (double) this.d));
    }
}
