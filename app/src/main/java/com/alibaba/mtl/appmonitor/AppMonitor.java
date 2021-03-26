package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.IMonitor;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.d.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class AppMonitor {
    public static final String TAG = "AppMonitor";
    private static Application a;

    /* renamed from: a  reason: collision with other field name */
    private static ServiceConnection f15a = new ServiceConnection() {
        /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass5 */

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (b.Service == AppMonitor.f17a) {
                AppMonitor.f19a = IMonitor.Stub.asInterface(iBinder);
                if (AppMonitor.f23b && AppMonitor.f18a != null) {
                    AppMonitor.f18a.postAtFrontOfQueue(new Runnable() {
                        /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass5.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            AppMonitor.restart();
                        }
                    });
                }
            }
            synchronized (AppMonitor.f20a) {
                AppMonitor.f20a.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            i.a("AppMonitor", "[onServiceDisconnected]");
            synchronized (AppMonitor.f20a) {
                AppMonitor.f20a.notifyAll();
            }
            boolean unused = AppMonitor.f23b = true;
        }
    };

    /* renamed from: a  reason: collision with other field name */
    private static HandlerThread f16a;

    /* renamed from: a  reason: collision with other field name */
    private static b f17a = b.Local;

    /* renamed from: a  reason: collision with other field name */
    protected static c f18a;

    /* renamed from: a  reason: collision with other field name */
    protected static IMonitor f19a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f20a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f21a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f22a;
    private static Map<String, APTrack> b = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with other field name */
    private static boolean f23b = false;
    private static boolean c;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static Context mContext;

    enum b {
        Local,
        Service
    }

    static {
        try {
            System.loadLibrary("ut_c_api");
            Log.i("AppMonitor", "load ut_c_api.so success");
        } catch (Throwable unused) {
            Log.w("AppMonitor", "load ut_c_api.so failed");
        }
    }

    public static synchronized void init(Application application) {
        synchronized (AppMonitor.class) {
            i.a("AppMonitor", "[init]");
            try {
                if (!f22a) {
                    a = application;
                    if (application != null) {
                        mContext = application.getApplicationContext();
                    }
                    HandlerThread handlerThread = new HandlerThread("AppMonitor_Client");
                    f16a = handlerThread;
                    handlerThread.start();
                    f18a = new c(f16a.getLooper());
                    if (f17a == b.Local) {
                        m10a();
                    } else if (m12a()) {
                        f18a.a(true);
                    }
                    a().run();
                    f22a = true;
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Deprecated
    public static synchronized void destroy() {
        synchronized (AppMonitor.class) {
            if (checkInit()) {
                f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.destroy();
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    @Deprecated
    public static synchronized void triggerUpload() {
        synchronized (AppMonitor.class) {
            if (f22a) {
                f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass10 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.triggerUpload();
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    public static void setStatisticsInterval(final int i2) {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass11 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.setStatisticsInterval1(i2);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void setSampling(final int i2) {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass12 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.setSampling(i2);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void enableLog(final boolean z) {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass13 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.enableLog(z);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet) {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass14 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.register1(str, str2, measureSet);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
            m11a(str, str2, measureSet, (DimensionSet) null, false);
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final boolean z) {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass15 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.register2(str, str2, measureSet, z);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
            m11a(str, str2, measureSet, (DimensionSet) null, z);
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet) {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass16 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        i.a("AppMonitor", "[register]:", AppMonitor.f19a);
                        AppMonitor.f19a.register3(str, str2, measureSet, dimensionSet);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
            m11a(str, str2, measureSet, dimensionSet, false);
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        if (checkInit()) {
            registerInternal(str, str2, measureSet, dimensionSet, z, false);
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002a: APUT  (r0v1 java.lang.Object[]), (4 ??[int, float, short, byte, char]), (r4v1 java.lang.String) */
    public static void register(String str, String str2, String[] strArr, String[] strArr2, boolean z) {
        Object[] objArr = new Object[9];
        objArr[0] = "[register]";
        objArr[1] = "module:";
        objArr[2] = str;
        objArr[3] = "measures:";
        String str3 = "null";
        objArr[4] = strArr == null ? str3 : new JSONArray((Collection) Arrays.asList(strArr)).toString();
        objArr[5] = "dimensions:";
        if (strArr2 != null) {
            str3 = new JSONArray((Collection) Arrays.asList(strArr2)).toString();
        }
        objArr[6] = str3;
        objArr[7] = "isCommitDetail:";
        objArr[8] = Boolean.valueOf(z);
        i.a("AppMonitor", objArr);
        if (strArr != null) {
            MeasureSet create = MeasureSet.create();
            for (String str4 : strArr) {
                create.addMeasure(str4);
            }
            DimensionSet dimensionSet = null;
            if (strArr2 != null) {
                dimensionSet = DimensionSet.create();
                for (String str5 : strArr2) {
                    dimensionSet.addDimension(str5);
                }
            }
            register(str, str2, create, dimensionSet, z);
            return;
        }
        i.a("AppMonitor", "register failed:no mearsure");
    }

    public static void updateMeasure(final String str, final String str2, final String str3, final double d, final double d2, final double d3) {
        i.a("AppMonitor", "[updateMeasure]");
        if (checkInit()) {
            f18a.post(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass17 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.updateMeasure(str, str2, str3, d, d2, d3);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void registerInternal(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z, boolean z2) {
        if (checkInit()) {
            i.a("AppMonitor", "[registerInternal] : module:", str, "monitorPoint:", str2, "measures:", measureSet, "dimensions:", dimensionSet, "isCommitDetail:", Boolean.valueOf(z), "isInternal:", Boolean.valueOf(z2));
            if (!z2) {
                m11a(str, str2, measureSet, dimensionSet, z);
            }
            f18a.a(a(str, str2, measureSet, dimensionSet, z));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m11a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            a aVar = new a();
            aVar.o = str;
            aVar.p = str2;
            aVar.f38b = measureSet;
            aVar.b = dimensionSet;
            aVar.g = z;
            f21a.add(aVar);
        } catch (Throwable unused) {
        }
    }

    public static class Alarm {
        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.alarm_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.alarm_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f19a == null) {
                return false;
            }
            try {
                return AppMonitor.f19a.alarm_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void commitSuccess(final String str, final String str2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.alarm_commitSuccess1(str, str2, null);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.alarm_commitSuccess2(str, str2, str3, null);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass5 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.alarm_commitFail1(str, str2, str3, str4, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4, final String str5) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass6 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.alarm_commitFail2(str, str2, str3, str4, str5, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }
    }

    public static class Counter {
        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.counter_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.counter_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f19a == null) {
                return false;
            }
            try {
                return AppMonitor.f19a.counter_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.counter_commit1(str, str2, d, null);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final String str3, final double d) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.counter_commit2(str, str2, str3, d, null);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    public static class OffLineCounter {
        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.offlinecounter_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.offlinecounter_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f19a == null) {
                return false;
            }
            try {
                return AppMonitor.f19a.offlinecounter_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.offlinecounter_commit(str, str2, d);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    public static class Stat {
        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.stat_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.stat_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f19a == null) {
                return false;
            }
            try {
                return AppMonitor.f19a.stat_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void begin(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.stat_begin(str, str2, str3);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void end(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.stat_end(str, str2, str3);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(f.STAT.a()), str, str2, dimensionValueSet);
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet, String str3) {
            return new Transaction(Integer.valueOf(f.STAT.a()), str, str2, dimensionValueSet, str3);
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, (DimensionValueSet) null, d);
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final double d) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass5 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.stat_commit2(str, str2, dimensionValueSet, d, null);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            DimensionValueSet dimensionValueSet;
            i.a("AppMonitor", "[commit from jni]");
            MeasureValueSet measureValueSet = null;
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                dimensionValueSet = null;
            } else {
                dimensionValueSet = DimensionValueSet.create();
                for (int i = 0; i < strArr2.length; i++) {
                    dimensionValueSet.setValue(strArr[i], strArr2[i]);
                }
            }
            if (strArr3 == null || strArr4 == null || strArr3.length != strArr4.length) {
                i.a("AppMonitor", "measure is null ,or lenght not match");
            } else {
                measureValueSet = MeasureValueSet.create();
                for (int i2 = 0; i2 < strArr4.length; i2++) {
                    double d = 0.0d;
                    if (!TextUtils.isEmpty(strArr4[i2])) {
                        try {
                            d = Double.valueOf(strArr4[i2]).doubleValue();
                        } catch (Exception unused) {
                            i.a("AppMonitor", "measure's value cannot convert to double. measurevalue:" + strArr4[i2]);
                        }
                    }
                    measureValueSet.setValue(strArr3[i2], d);
                }
            }
            commit(str, str2, dimensionValueSet, measureValueSet);
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final MeasureValueSet measureValueSet) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f18a.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass6 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f19a.stat_commit3(str, str2, dimensionValueSet, measureValueSet, null);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    public static void setStatisticsInterval(f fVar, final int i2) {
        if (checkInit()) {
            final int a2 = a(fVar);
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.setStatisticsInterval2(a2, i2);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    private static int a(f fVar) {
        return fVar.a();
    }

    public static void setRequestAuthInfo(boolean z, String str, String str2, String str3) {
        if (checkInit()) {
            f18a.a(a(z, str, str2, str3));
            c = z;
            g = str;
            h = str2;
            i = str3;
        }
    }

    public static void setChannel(String str) {
        if (checkInit()) {
            f18a.a(a(str));
            f = str;
        }
    }

    public static void turnOnRealTimeDebug(final Map<String, String> map) {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.turnOnRealTimeDebug(map);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void turnOffRealTimeDebug() {
        if (checkInit()) {
            f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.turnOffRealTimeDebug();
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m12a() {
        Application application = a;
        if (application == null) {
            return false;
        }
        boolean bindService = application.getApplicationContext().bindService(new Intent(a.getApplicationContext(), AppMonitorService.class), f15a, 1);
        if (!bindService) {
            m10a();
        }
        i.a("AppMonitor", "bindsuccess:", Boolean.valueOf(bindService));
        return bindService;
    }

    static class c extends Handler {
        private boolean h = false;

        public c(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = runnable;
                    sendMessage(obtain);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.h) {
                    this.h = false;
                    synchronized (AppMonitor.f20a) {
                        try {
                            AppMonitor.f20a.wait(5000);
                        } catch (InterruptedException unused) {
                            AppMonitor.m10a();
                        }
                    }
                }
                if (message.obj != null && (message.obj instanceof Runnable)) {
                    ((Runnable) message.obj).run();
                }
            } catch (Throwable unused2) {
            }
            super.handleMessage(message);
        }

        public void a(boolean z) {
            this.h = true;
        }
    }

    /* access modifiers changed from: private */
    public static void a(Exception exc) {
        i.a("AppMonitor", "", exc);
        if (exc instanceof DeadObjectException) {
            restart();
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void restart() {
        synchronized (AppMonitor.class) {
            i.a("AppMonitor", "[restart]");
            try {
                if (f23b) {
                    f23b = false;
                    m10a();
                    a().run();
                    a(c, g, h, i).run();
                    a(f).run();
                    synchronized (f21a) {
                        for (int i2 = 0; i2 < f21a.size(); i2++) {
                            a aVar = f21a.get(i2);
                            if (aVar != null) {
                                try {
                                    a(aVar.o, aVar.p, aVar.f38b, aVar.b, aVar.g).run();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m10a() {
        f19a = new Monitor(a);
        f17a = b.Local;
        i.a("AppMonitor", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    static class a {
        public DimensionSet b;

        /* renamed from: b  reason: collision with other field name */
        public MeasureSet f38b;
        public boolean g;
        public String o;
        public String p;

        a() {
        }
    }

    public static boolean checkInit() {
        if (!f22a) {
            i.a("AppMonitor", "Please call UTAnalytics.getInstance().setAppApplicationInstance()||.setAppApplicationInstance4sdk() before call other method");
        }
        return f22a;
    }

    private static Runnable a() {
        return new Runnable() {
            /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f19a.init();
                } catch (RemoteException unused) {
                    AppMonitor.m10a();
                    AppMonitor.f19a.init();
                } catch (Throwable unused2) {
                }
            }
        };
    }

    private static Runnable a(final boolean z, final String str, final String str2, final String str3) {
        return new Runnable() {
            /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass7 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f19a.setRequestAuthInfo(z, str, str2, str3);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable a(final String str) {
        return new Runnable() {
            /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass8 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f19a.setChannel(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable a(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z) {
        return new Runnable() {
            /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass9 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    i.a("AppMonitor", "register stat event. module: ", str, " monitorPoint: ", str2);
                    AppMonitor.f19a.register4(str, str2, measureSet, dimensionSet, z);
                } catch (RemoteException e2) {
                    AppMonitor.a(e2);
                }
            }
        };
    }

    public static APTrack getTrackByAppkey(String str) {
        if (!checkInit()) {
            return null;
        }
        if (!b.containsKey(str)) {
            b.put(str, new APTrack(str));
        }
        return b.get(str);
    }
}
