package com.alibaba.baichuan.trade.common.adapter.ut.impl;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcDimension;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcDimensionSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcDimensionValueSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasure;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasureSet;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasureValue;
import com.alibaba.baichuan.trade.common.adapter.ut.performance.AlibcMeasureValueSet;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.Dimension;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.UTTracker;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import java.util.HashMap;
import java.util.Map;

public class AppMonitorUserTracker extends AlibcBaseUserTracker {
    public static final String TRACKER_ID = "aliTradesdk";
    public static final String USER_ID = "user_id";
    public static final String USER_NICK = "user_nick";
    private boolean a = true;
    private String b;

    public String getMeasures(Map<String, MeasureValue> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, MeasureValue> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue().getValue()));
            }
        }
        return hashMap.toString();
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public boolean init() {
        try {
            UTAnalytics.getInstance().setContext(AlibcTradeCommon.context);
            UTAnalytics.getInstance().setAppApplicationInstance(AlibcTradeCommon.context);
            UTAnalytics.getInstance().setRequestAuthentication(new UTSecuritySDKRequestAuthentication(AlibcTradeCommon.getAppKey(), "baichuan"));
            if (AlibcTradeCommon.isDebug()) {
                turnOnDebug();
            }
            UTAnalytics.getInstance().turnOffAutoPageTrack();
            UTTracker tracker = UTAnalytics.getInstance().getTracker("aliTradesdk");
            if (tracker == null) {
                return true;
            }
            tracker.setGlobalProperty("sdk_version", AlibcTradeCommon.systemVersion);
            return true;
        } catch (Throwable unused) {
            this.a = false;
            return false;
        }
    }

    public boolean isThirdVersion() {
        return this.a;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void registerPerformancePoint(String str, String str2, AlibcMeasureSet alibcMeasureSet, AlibcDimensionSet alibcDimensionSet) {
        MeasureSet measureSet;
        DimensionSet dimensionSet = null;
        if (alibcMeasureSet != null) {
            measureSet = MeasureSet.create();
            for (AlibcMeasure alibcMeasure : alibcMeasureSet.getMeasures()) {
                measureSet.addMeasure(new Measure(alibcMeasure.getName(), alibcMeasure.getConstantValue(), alibcMeasure.getMin(), alibcMeasure.getMax()));
            }
        } else {
            measureSet = null;
        }
        if (alibcDimensionSet != null) {
            dimensionSet = DimensionSet.create();
            for (AlibcDimension alibcDimension : alibcDimensionSet.getDimensions()) {
                dimensionSet.addDimension(new Dimension(alibcDimension.getName(), alibcDimension.getConstantValue()));
            }
        }
        AppMonitor.register(str, str2, measureSet, dimensionSet);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, int i, String str2, long j, String str3, Map<String, String> map) {
        UTAnalytics.getInstance().getTracker("aliTradesdk").send(new UTOriginalCustomHitBuilder(str3, i, str, str2, String.valueOf(j), map).build());
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        UTAnalytics.getInstance().getTracker("aliTradesdk").send(new UTOriginalCustomHitBuilder(str, i, str2, str3, str4, map).build());
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, long j, Map<String, String> map) {
        sendCustomHit("aliTradesdk", str, str2, j, map);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, String str3, long j, Map<String, String> map) {
        try {
            if (AlibcTradeCommon.isDebug()) {
                AlibcLogger.d("AppMonitorUserTracker-CustomHit", "业务埋点信息为: trackId = " + str + "\n label = " + str2 + "\n page = " + str3 + "\n time = " + j + "\n prop = " + map);
            }
        } catch (Throwable unused) {
        }
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
        uTCustomHitBuilder.setDurationOnEvent(j);
        uTCustomHitBuilder.setEventPage(str3);
        uTCustomHitBuilder.setProperties(map);
        Map<String, String> build = uTCustomHitBuilder.build();
        if (!TextUtils.isEmpty(str)) {
            str = "aliTradesdk";
        }
        UTTracker tracker = UTAnalytics.getInstance().getTracker(str);
        if (tracker != null) {
            tracker.send(build);
        }
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, Map<String, String> map) {
        sendCustomHit(str, str2, 60, map);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendInitHit4DAU(String str, String str2) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("80001");
        HashMap hashMap = new HashMap();
        hashMap.put("model", "trade");
        hashMap.put("version", str2);
        uTCustomHitBuilder.setProperties(hashMap);
        UTAnalytics.getInstance().getTracker(str).send(uTCustomHitBuilder.build());
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendPerfomancePoint(String str, String str2, AlibcDimensionValueSet alibcDimensionValueSet, AlibcMeasureValueSet alibcMeasureValueSet) {
        DimensionValueSet dimensionValueSet;
        MeasureValueSet measureValueSet = null;
        if (alibcDimensionValueSet != null) {
            dimensionValueSet = DimensionValueSet.create();
            Map<String, String> map = alibcDimensionValueSet.getMap();
            if (map != null) {
                dimensionValueSet.setMap(map);
            }
        } else {
            dimensionValueSet = null;
        }
        if (alibcMeasureValueSet != null) {
            measureValueSet = MeasureValueSet.create();
            Map<String, AlibcMeasureValue> map2 = alibcMeasureValueSet.getMap();
            if (map2 != null) {
                for (Map.Entry<String, AlibcMeasureValue> entry : map2.entrySet()) {
                    AlibcMeasureValue value = entry.getValue();
                    if (value != null) {
                        MeasureValue create = MeasureValue.create();
                        create.setOffset(value.getOffset().doubleValue());
                        create.setValue(value.getValue());
                        measureValueSet.setValue(entry.getKey(), create);
                    }
                }
            }
        }
        try {
            if (AlibcTradeCommon.isDebug()) {
                AlibcLogger.d("AppMonitorUserTracker-PerfomancePoint", "性能埋点信息为: module = " + str + "\n monitorPoint = " + str2 + "\n dimensionValueSet = " + dimensionValueSet.getMap() + "\n measureValueSet = " + getMeasures(measureValueSet.getMap()));
            }
        } catch (Throwable unused) {
        }
        AppMonitor.Stat.commit(str, str2, dimensionValueSet, measureValueSet);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendUsabilityFailure(String str, String str2, String str3, String str4, String str5) {
        try {
            if (AlibcTradeCommon.isDebug()) {
                AlibcLogger.d("AppMonitorUserTracker-UseabilityPoint", "可用性埋点-success: module = " + str + "\n monitorPoint = " + str2 + "\n args = " + str3 + "\n errorCode = " + str4 + "\n errorMsg = " + str5);
            }
        } catch (Throwable unused) {
        }
        AppMonitor.Alarm.commitFail(str, str2, str3, str4, str5);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendUsabilitySuccess(String str, String str2, String str3) {
        try {
            if (AlibcTradeCommon.isDebug()) {
                AlibcLogger.d("AppMonitorUserTracker-UseabilityPoint", "可用性埋点-success: module = " + str + "\n monitorPoint = " + str2 + "\n args = " + str3);
            }
        } catch (Throwable unused) {
        }
        AppMonitor.Alarm.commitSuccess(str, str2, str3);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void setChannel(String str) {
        this.b = str;
        UTAnalytics.getInstance().setChannel(str);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void setSampling(int i) {
        AppMonitor.setSampling(i);
        AppMonitor.Stat.setSampling(i);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void turnOffDebug() {
        AppMonitor.enableLog(false);
        UTTeamWork.getInstance().turnOffRealTimeDebug();
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void turnOnDebug() {
        UTAnalytics.getInstance().turnOnDebug();
        AppMonitor.enableLog(true);
    }
}
