package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;

public class APTrack {
    private Map<String, String> a;

    protected APTrack(String str) {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(LogField.APPKEY.toString(), str);
    }

    public void commitSuccess(final String str, final String str2) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.alarm_commitSuccess1(str, str2, APTrack.this.a);
                    } catch (Throwable th) {
                        i.a("APTrack", null, th);
                    }
                }
            });
        }
    }

    public void commitSuccess(final String str, final String str2, final String str3) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.alarm_commitSuccess2(str, str2, str3, APTrack.this.a);
                    } catch (Throwable th) {
                        i.a("APTrack", null, th);
                    }
                }
            });
        }
    }

    public void commitFail(final String str, final String str2, final String str3, final String str4) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.alarm_commitFail1(str, str2, str3, str4, APTrack.this.a);
                    } catch (Throwable th) {
                        i.a("APTrack", null, th);
                    }
                }
            });
        }
    }

    public void commitFail(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.alarm_commitFail2(str, str2, str3, str4, str5, APTrack.this.a);
                    } catch (Throwable th) {
                        i.a("APTrack", null, th);
                    }
                }
            });
        }
    }

    public void commit(final String str, final String str2, final double d) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.counter_commit1(str, str2, d, APTrack.this.a);
                    } catch (RemoteException e) {
                        i.a("APTrack", null, e);
                    }
                }
            });
        }
    }

    public void commit(final String str, final String str2, final String str3, final double d) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass6 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.counter_commit2(str, str2, str3, d, APTrack.this.a);
                    } catch (Throwable th) {
                        i.a("APTrack", null, th);
                    }
                }
            });
        }
    }

    public void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final double d) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass7 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.stat_commit2(str, str2, dimensionValueSet, d, APTrack.this.a);
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    public void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final MeasureValueSet measureValueSet) {
        if (AppMonitor.checkInit()) {
            AppMonitor.f18a.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.APTrack.AnonymousClass8 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f19a.stat_commit3(str, str2, dimensionValueSet, measureValueSet, APTrack.this.a);
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }
}
