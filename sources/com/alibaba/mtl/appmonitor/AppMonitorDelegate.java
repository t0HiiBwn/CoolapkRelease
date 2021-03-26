package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.b.b;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.l;
import com.alibaba.mtl.log.sign.BaseRequestAuth;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppMonitorDelegate {
    public static final String DEFAULT_VALUE = "defaultValue";
    public static boolean IS_DEBUG = false;
    public static final String MAX_VALUE = "maxValue";
    public static final String MIN_VALUE = "minValue";
    public static final String TAG = "AppMonitorDelegate";
    private static Application b;
    static volatile boolean i;

    public static synchronized void init(Application application) {
        synchronized (AppMonitorDelegate.class) {
            i.a("AppMonitorDelegate", "start init");
            try {
                if (!i) {
                    b = application;
                    a.a(application.getApplicationContext());
                    b.init();
                    c.init();
                    a.init(application);
                    l.b(application.getApplicationContext());
                    i = true;
                }
            } catch (Throwable unused) {
                destroy();
            }
        }
    }

    public static synchronized void destroy() {
        synchronized (AppMonitorDelegate.class) {
            try {
                i.a("AppMonitorDelegate", "start destory");
                if (i) {
                    c.d();
                    c.destroy();
                    b.destroy();
                    Application application = b;
                    if (application != null) {
                        l.c(application.getApplicationContext());
                    }
                    i = false;
                }
            } catch (Throwable th) {
                b.m9a(th);
            }
        }
        return;
    }

    public static synchronized void triggerUpload() {
        synchronized (AppMonitorDelegate.class) {
            try {
                i.a("AppMonitorDelegate", "triggerUpload");
                if (i && com.alibaba.mtl.log.a.a.f()) {
                    c.d();
                }
            } catch (Throwable th) {
                b.m9a(th);
            }
        }
        return;
    }

    public static void setStatisticsInterval(int i2) {
        f[] values = f.values();
        for (f fVar : values) {
            fVar.setStatisticsInterval(i2);
            setStatisticsInterval(fVar, i2);
        }
    }

    public static void setSampling(int i2) {
        i.a("AppMonitorDelegate", "[setSampling]");
        f[] values = f.values();
        for (f fVar : values) {
            fVar.c(i2);
            j.a().a(fVar, i2);
        }
    }

    public static void enableLog(boolean z) {
        i.a("AppMonitorDelegate", "[enableLog]");
        i.d(z);
    }

    public static void register(String str, String str2, MeasureSet measureSet) {
        register(str, str2, measureSet, (DimensionSet) null);
    }

    public static void register(String str, String str2, MeasureSet measureSet, boolean z) {
        register(str, str2, measureSet, null, z);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        register(str, str2, measureSet, dimensionSet, false);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (i) {
                if (!com.alibaba.mtl.appmonitor.f.b.d(str)) {
                    if (!com.alibaba.mtl.appmonitor.f.b.d(str2)) {
                        MetricRepo.getRepo().add(new Metric(str, str2, measureSet, dimensionSet, z));
                        return;
                    }
                }
                i.a("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (IS_DEBUG) {
                    throw new com.alibaba.mtl.appmonitor.b.a("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            b.m9a(th);
        }
    }

    public static void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) {
        i.a("AppMonitorDelegate", "[updateMeasure]");
        try {
            if (i && !com.alibaba.mtl.appmonitor.f.b.d(str)) {
                if (!com.alibaba.mtl.appmonitor.f.b.d(str2)) {
                    Metric metric = MetricRepo.getRepo().getMetric(str, str2);
                    if (metric != null && metric.getMeasureSet() != null) {
                        metric.getMeasureSet().upateMeasure(new Measure(str3, Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static class Alarm {
        public static void setStatisticsInterval(int i) {
            f.ALARM.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.ALARM, i);
        }

        public static void setSampling(int i) {
            j.a().a(f.ALARM, i);
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.ALARM, str, str2);
        }

        public static void commitSuccess(String str, String str2, Map<String, String> map) {
            commitSuccess(str, str2, null, map);
        }

        public static void commitSuccess(String str, String str2, String str3, Map<String, String> map) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    i.a("AppMonitorDelegate", "module & monitorPoint must not null");
                    return;
                }
                com.alibaba.mtl.log.b.a.A();
                if (!AppMonitorDelegate.i || !com.alibaba.mtl.log.a.a.f() || !f.ALARM.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(str, str2, (Boolean) true, (Map<String, String>) null))) {
                    i.a("log discard !", "");
                    return;
                }
                i.a("AppMonitorDelegate", "commitSuccess module:", str, " monitorPoint:", str2);
                com.alibaba.mtl.log.b.a.B();
                e.a().a(f.ALARM.a(), str, str2, str3, map);
            } catch (Throwable th) {
                b.m9a(th);
            }
        }

        public static void commitFail(String str, String str2, String str3, String str4, Map<String, String> map) {
            commitFail(str, str2, null, str3, str4, map);
        }

        public static void commitFail(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    i.a("AppMonitorDelegate", "module & monitorPoint must not null");
                    return;
                }
                com.alibaba.mtl.log.b.a.A();
                HashMap hashMap = new HashMap();
                hashMap.put("_status", "0");
                if (!AppMonitorDelegate.i || !com.alibaba.mtl.log.a.a.f() || !f.ALARM.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(str, str2, (Boolean) false, (Map<String, String>) hashMap))) {
                    i.a("log discard !", "");
                    return;
                }
                i.a("AppMonitorDelegate", "commitFail module:", str, " monitorPoint:", str2, " errorCode:", str4, "errorMsg:", str5);
                com.alibaba.mtl.log.b.a.B();
                e.a().a(f.ALARM.a(), str, str2, str3, str4, str5, map);
            } catch (Throwable th) {
                b.m9a(th);
            }
        }
    }

    public static class Counter {
        public static void setStatisticsInterval(int i) {
            f.COUNTER.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.COUNTER, i);
        }

        public static void setSampling(int i) {
            j.a().a(f.COUNTER, i);
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d, Map<String, String> map) {
            commit(str, str2, null, d, map);
        }

        public static void commit(String str, String str2, String str3, double d, Map<String, String> map) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    i.a("AppMonitorDelegate", "module & monitorPoint must not null");
                    return;
                }
                com.alibaba.mtl.log.b.a.y();
                if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.f() && f.COUNTER.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.COUNTER, str, str2)) {
                        i.a("AppMonitorDelegate", "commitCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                        com.alibaba.mtl.log.b.a.z();
                        e.a().a(f.COUNTER.a(), str, str2, str3, d, map);
                    }
                }
            } catch (Throwable th) {
                b.m9a(th);
            }
        }
    }

    public static class OffLineCounter {
        public static void setStatisticsInterval(int i) {
            f.OFFLINE_COUNTER.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.OFFLINE_COUNTER, i);
        }

        public static void setSampling(int i) {
            j.a().a(f.OFFLINE_COUNTER, i);
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.OFFLINE_COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    i.a("AppMonitorDelegate", "module & monitorPoint must not null");
                    return;
                }
                com.alibaba.mtl.log.b.a.w();
                if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.f() && f.OFFLINE_COUNTER.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.OFFLINE_COUNTER, str, str2)) {
                        i.a("AppMonitorDelegate", "commitOffLineCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                        com.alibaba.mtl.log.b.a.x();
                        e.a().a(f.OFFLINE_COUNTER.a(), str, str2, (String) null, d, (Map<String, String>) null);
                    }
                }
            } catch (Throwable th) {
                b.m9a(th);
            }
        }
    }

    public static class Stat {
        public static void setStatisticsInterval(int i) {
            f.STAT.setStatisticsInterval(i);
            AppMonitorDelegate.setStatisticsInterval(f.STAT, i);
        }

        public static void setSampling(int i) {
            j.a().a(f.STAT, i);
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.STAT, str, str2);
        }

        public static void begin(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.f() && f.STAT.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, str, str2)) {
                        i.a("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        e.a().a(Integer.valueOf(f.STAT.a()), str, str2, str3);
                    }
                }
            } catch (Throwable th) {
                b.m9a(th);
            }
        }

        public static void end(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.f() && f.STAT.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, str, str2)) {
                        i.a("AppMonitorDelegate", "statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        e.a().a(str, str2, str3);
                    }
                }
            } catch (Throwable th) {
                b.m9a(th);
            }
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(f.STAT.a()), str, str2, dimensionValueSet);
        }

        public static void commit(String str, String str2, double d, Map<String, String> map) {
            commit(str, str2, (DimensionValueSet) null, d, map);
        }

        public static void commit(String str, String str2, DimensionValueSet dimensionValueSet, double d, Map<String, String> map) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    i.a("AppMonitorDelegate", "module & monitorPoint must not null");
                    return;
                }
                com.alibaba.mtl.log.b.a.u();
                if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.f() && f.STAT.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, str, str2)) {
                        i.a("AppMonitorDelegate", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
                        com.alibaba.mtl.log.b.a.v();
                        if (metric != null) {
                            List<Measure> measures = metric.getMeasureSet().getMeasures();
                            if (measures.size() == 1) {
                                commit(str, str2, dimensionValueSet, ((MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0])).setValue(measures.get(0).getName(), d), map);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                b.m9a(th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            if (com.alibaba.mtl.appmonitor.d.j.a(com.alibaba.mtl.appmonitor.a.f.STAT, r10, r11, r12 != null ? r12.getMap() : null) != false) goto L_0x003e;
         */
        public static void commit(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.alibaba.mtl.log.b.a.u();
                        if (AppMonitorDelegate.i && com.alibaba.mtl.log.a.a.f() && f.STAT.isOpen()) {
                            if (!AppMonitorDelegate.IS_DEBUG) {
                            }
                            i.a("statEvent commit success", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                            com.alibaba.mtl.log.b.a.v();
                            e.a().a(f.STAT.a(), str, str2, measureValueSet, dimensionValueSet, map);
                            return;
                        }
                        i.a("statEvent commit failed,log discard", " ,. module: ", str, " monitorPoint: ", str2);
                        return;
                    }
                }
                i.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                b.m9a(th);
            }
        }
    }

    static void setStatisticsInterval(f fVar, int i2) {
        try {
            if (i && fVar != null) {
                c.a(fVar.a(), i2);
                if (i2 > 0) {
                    fVar.b(true);
                } else {
                    fVar.b(false);
                }
            }
        } catch (Throwable th) {
            b.m9a(th);
        }
    }

    public static void setRequestAuthInfo(boolean z, String str, String str2, String str3) {
        IRequestAuth iRequestAuth;
        if (z) {
            iRequestAuth = new SecurityRequestAuth(str, str3);
        } else {
            iRequestAuth = new BaseRequestAuth(str, str2, "1".equalsIgnoreCase(str3));
        }
        a.a(iRequestAuth);
        com.alibaba.mtl.log.a.a.a(b);
    }

    public static void setChannel(String str) {
        a.setChannel(str);
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        com.alibaba.mtl.log.a.a.turnOnRealTimeDebug(map);
    }

    public static void turnOffRealTimeDebug() {
        i.a("AppMonitorDelegate", "[turnOffRealTimeDebug]");
    }
}
