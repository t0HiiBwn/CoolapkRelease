package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
public final class b implements ac {
    private static b m;
    private AtomicInteger a = new AtomicInteger(0);
    private long b = -1;
    private final Context c;
    private final a d;
    private final w e;
    private String f;
    private final com.tencent.bugly.crashreport.crash.b g;
    private FileObserver h;
    private boolean i = true;
    private ab j;
    private int k;
    private ActivityManager.ProcessErrorStateInfo l;

    public static b a(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, a aVar2, w wVar, p pVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        if (m == null) {
            m = new b(context, aVar, aVar2, wVar, bVar);
        }
        return m;
    }

    private b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, a aVar2, w wVar, com.tencent.bugly.crashreport.crash.b bVar) {
        this.c = z.a(context);
        this.f = context.getDir("bugly", 0).getAbsolutePath();
        this.d = aVar2;
        this.e = wVar;
        this.g = bVar;
        this.l = new ActivityManager.ProcessErrorStateInfo();
    }

    private ActivityManager.ProcessErrorStateInfo a(Context context, long j2) {
        try {
            x.c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int i2 = 0;
            while (true) {
                x.c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            x.c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                z.b(500);
                int i3 = i2 + 1;
                if (((long) i2) >= 20) {
                    x.c("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            x.b(e2);
            return null;
        } catch (OutOfMemoryError e3) {
            this.l.pid = Process.myPid();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = this.l;
            processErrorStateInfo2.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e3.getMessage();
            return this.l;
        }
    }

    private CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.F = this.d.k();
            crashDetailBean.G = this.d.j();
            crashDetailBean.H = this.d.l();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                crashDetailBean.w = z.a(this.c, c.e, (String) null);
            }
            crashDetailBean.b = 3;
            crashDetailBean.e = this.d.h();
            crashDetailBean.f = this.d.k;
            crashDetailBean.g = this.d.q();
            crashDetailBean.m = this.d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.q = aVar.g;
            crashDetailBean.P = new HashMap();
            crashDetailBean.P.put("BUGLY_CR_01", aVar.e);
            int i2 = -1;
            if (crashDetailBean.q != null) {
                i2 = crashDetailBean.q.indexOf("\n");
            }
            crashDetailBean.p = i2 > 0 ? crashDetailBean.q.substring(0, i2) : "GET_FAIL";
            crashDetailBean.r = aVar.c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = aVar.b;
            crashDetailBean.A = aVar.a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.d.s();
            crashDetailBean.h = this.d.p();
            crashDetailBean.i = this.d.B();
            crashDetailBean.v = aVar.d;
            crashDetailBean.L = this.d.o;
            crashDetailBean.M = this.d.a;
            crashDetailBean.N = this.d.a();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                this.g.d(crashDetailBean);
            }
            crashDetailBean.Q = this.d.z();
            crashDetailBean.R = this.d.A();
            crashDetailBean.S = this.d.t();
            crashDetailBean.T = this.d.y();
            crashDetailBean.y = y.a();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0133 A[Catch:{ all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015f A[SYNTHETIC, Splitter:B:59:0x015f] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0171 A[SYNTHETIC, Splitter:B:67:0x0171] */
    private static boolean a(String str, String str2, String str3) {
        Throwable th;
        IOException e2;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.d == null || readTargetDumpInfo.d.size() <= 0) {
            x.e("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                x.e("backup file create fail %s", str2);
                return false;
            }
            BufferedWriter bufferedWriter = null;
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                try {
                    String[] strArr = readTargetDumpInfo.d.get("main");
                    int i2 = 3;
                    if (strArr != null && strArr.length >= 3) {
                        String str4 = strArr[0];
                        String str5 = strArr[1];
                        String str6 = strArr[2];
                        bufferedWriter2.write("\"main\" tid=" + str6 + " :\n" + str4 + "\n" + str5 + "\n\n");
                        bufferedWriter2.flush();
                    }
                    for (Map.Entry<String, String[]> entry : readTargetDumpInfo.d.entrySet()) {
                        if (!entry.getKey().equals("main")) {
                            if (entry.getValue() != null && entry.getValue().length >= i2) {
                                String str7 = entry.getValue()[0];
                                String str8 = entry.getValue()[1];
                                String str9 = entry.getValue()[2];
                                bufferedWriter2.write("\"" + entry.getKey() + "\" tid=" + str9 + " :\n" + str7 + "\n" + str8 + "\n\n");
                                bufferedWriter2.flush();
                            }
                            i2 = 3;
                        }
                    }
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e3) {
                        if (!x.a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                    return true;
                } catch (IOException e4) {
                    e2 = e4;
                    bufferedWriter = bufferedWriter2;
                    try {
                        if (!x.a(e2)) {
                        }
                        x.e("dump trace fail %s", e2.getClass().getName() + ":" + e2.getMessage());
                        if (bufferedWriter != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e5) {
                                if (!x.a(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                if (!x.a(e2)) {
                    e2.printStackTrace();
                }
                x.e("dump trace fail %s", e2.getClass().getName() + ":" + e2.getMessage());
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e7) {
                        if (!x.a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                }
                return false;
            }
        } catch (Exception e8) {
            if (!x.a(e8)) {
                e8.printStackTrace();
            }
            x.e("backup file create error! %s  %s", e8.getClass().getName() + ":" + e8.getMessage(), str2);
            return false;
        }
    }

    public final boolean a() {
        return this.a.get() != 0;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x009a: APUT  
      (r12v6 java.lang.Object[])
      (6 ??[int, float, short, byte, char])
      (wrap: java.lang.Integer : 0x0096: INVOKE  (r3v4 java.lang.Integer) = (r3v3 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    private boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        a aVar = new a();
        aVar.c = j2;
        aVar.a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(Process.myPid());
        String str2 = "";
        aVar.f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : str2;
        if (processErrorStateInfo != null) {
            str2 = processErrorStateInfo.longMsg;
        }
        aVar.e = str2;
        aVar.b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it2 = map.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (next.startsWith(thread.getName())) {
                    aVar.g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.g)) {
            aVar.g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(aVar.c);
        objArr[1] = aVar.d;
        objArr[2] = aVar.a;
        objArr[3] = aVar.g;
        objArr[4] = aVar.f;
        objArr[5] = aVar.e;
        objArr[6] = Integer.valueOf(aVar.b == null ? 0 : aVar.b.size());
        x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        x.a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean a2 = a(aVar);
        if (a2 == null) {
            x.e("pack anr fail!", new Object[0]);
            return false;
        }
        c.a().a(a2);
        if (a2.a >= 0) {
            x.a("backup anr record success!", new Object[0]);
        } else {
            x.d("backup anr record fail!", new Object[0]);
        }
        if (str == null || !new File(str).exists()) {
            File h2 = h();
            x.a("traceFile is %s", h2);
            if (h2 != null) {
                a2.v = h2.getAbsolutePath();
            }
        } else {
            String str3 = this.f;
            aVar.d = new File(str3, "bugly_trace_" + j2 + ".txt").getAbsolutePath();
            this.a.set(3);
            if (a(str, aVar.d, aVar.a)) {
                x.a("backup trace success", new Object[0]);
            }
        }
        com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), aVar.a, "main", aVar.g, a2);
        if (!this.g.a(a2)) {
            this.g.a(a2, 3000L, true);
        }
        this.g.c(a2);
        return true;
    }

    public final void a(String str) {
        synchronized (this) {
            if (this.a.get() != 0) {
                x.c("trace started return ", new Object[0]);
                return;
            }
            this.a.set(1);
        }
        try {
            x.c("read trace first dump for create time!", new Object[0]);
            TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
            long j2 = readFirstDumpInfo != null ? readFirstDumpInfo.c : -1;
            if (j2 == -1) {
                x.d("trace dump fail could not get time!", new Object[0]);
                j2 = System.currentTimeMillis();
            }
            if (Math.abs(j2 - this.b) < 10000) {
                x.d("should not process ANR too Fre in %d", 10000);
            } else {
                this.b = j2;
                this.a.set(1);
                try {
                    Map<String, String> a2 = z.a(c.f, false);
                    if (a2 == null || a2.size() <= 0) {
                        x.d("can't get all thread skip this anr", new Object[0]);
                    } else {
                        ActivityManager.ProcessErrorStateInfo a3 = a(this.c, 10000);
                        this.l = a3;
                        if (a3 == null) {
                            x.c("proc state is unvisiable!", new Object[0]);
                        } else if (a3.pid != Process.myPid()) {
                            x.c("not mind proc!", this.l.processName);
                        } else {
                            x.a("found visiable anr , start to process!", new Object[0]);
                            a(this.c, str, this.l, j2, a2);
                        }
                    }
                } catch (Throwable th) {
                    x.a(th);
                    x.e("get all thread stack fail!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            this.a.set(0);
            throw th2;
        }
        this.a.set(0);
    }

    private synchronized void d() {
        if (f()) {
            x.d("start when started!", new Object[0]);
            return;
        }
        AnonymousClass1 r0 = new FileObserver("/data/anr/", 8) {
            /* class com.tencent.bugly.crashreport.crash.anr.b.AnonymousClass1 */

            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str != null) {
                    String str2 = "/data/anr/" + str;
                    x.d("watching file %s", str2);
                    if (!str2.contains("trace")) {
                        x.d("not anr file %s", str2);
                    } else {
                        b.this.a(str2);
                    }
                }
            }
        };
        this.h = r0;
        try {
            r0.startWatching();
            x.a("start anr monitor!", new Object[0]);
            this.e.a(new Runnable() {
                /* class com.tencent.bugly.crashreport.crash.anr.b.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b();
                }
            });
        } catch (Throwable th) {
            this.h = null;
            x.d("start anr monitor failed!", new Object[0]);
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized void e() {
        if (!f()) {
            x.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.h.stopWatching();
            this.h = null;
            x.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            x.d("stop anr monitor failed!", new Object[0]);
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized boolean f() {
        return this.h != null;
    }

    private synchronized void b(boolean z) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z) {
                d();
            } else {
                e();
            }
        } else if (z) {
            i();
        } else {
            j();
        }
    }

    private synchronized boolean g() {
        return this.i;
    }

    private synchronized void c(boolean z) {
        if (this.i != z) {
            x.a("user change anr %b", Boolean.valueOf(z));
            this.i = z;
        }
    }

    public final void a(boolean z) {
        c(z);
        boolean g2 = g();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            g2 = g2 && a2.c().e;
        }
        if (g2 != f()) {
            x.a("anr changed to %b", Boolean.valueOf(g2));
            b(g2);
        }
    }

    protected final void b() {
        long b2 = z.b() - c.g;
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return;
                }
                if (listFiles.length != 0) {
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        x.c("Number Trace file : " + name, new Object[0]);
                        if (name.startsWith("bugly_trace_")) {
                            try {
                                int indexOf = name.indexOf(".txt");
                                if (indexOf > 0 && Long.parseLong(name.substring(12, indexOf)) >= b2) {
                                }
                            } catch (Throwable unused) {
                                x.c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    x.c("Number of overdue trace files that has deleted: " + i2, new Object[0]);
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    public final synchronized void c() {
        x.d("customer decides whether to open or close.", new Object[0]);
    }

    @Override // com.tencent.bugly.proguard.ac
    public final boolean a(aa aaVar) {
        Map<String, String> hashMap = new HashMap<>();
        if (aaVar.e().equals(Looper.getMainLooper())) {
            try {
                hashMap = z.a(200000, false);
            } catch (Throwable th) {
                x.b(th);
                hashMap.put("main", th.getMessage());
            }
            x.c("onThreadBlock found visiable anr , start to process!", new Object[0]);
            a(this.c, "", null, System.currentTimeMillis(), hashMap);
        } else {
            x.c("anr handler onThreadBlock only care main thread ,current thread is: %s", aaVar.d());
        }
        return true;
    }

    private File h() {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return null;
                }
                if (listFiles.length == 0) {
                    return null;
                }
                int i2 = 12;
                int length = listFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file2 = listFiles[i3];
                    String name = file2.getName();
                    if (name.startsWith("bugly_trace_")) {
                        try {
                            int indexOf = name.indexOf(".txt");
                            if (indexOf > 0) {
                                long parseLong = Long.parseLong(name.substring(i2, indexOf));
                                long j2 = (currentTimeMillis - parseLong) / 1000;
                                x.c("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                                x.c("current time minus trace time is %d s", Long.valueOf(j2));
                                if (j2 < 30) {
                                    return file2;
                                }
                            } else {
                                continue;
                            }
                        } catch (Throwable unused) {
                            x.c("Trace file that has invalid format: " + name, new Object[0]);
                        }
                    }
                    i3++;
                    i2 = 12;
                }
            } catch (Throwable th) {
                x.a(th);
                return null;
            }
        }
        return null;
    }

    private synchronized void i() {
        if (f()) {
            x.d("start when started!", new Object[0]);
        } else if (!TextUtils.isEmpty(this.f)) {
            ab abVar = this.j;
            if (abVar == null || !abVar.isAlive()) {
                ab abVar2 = new ab();
                this.j = abVar2;
                StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                int i2 = this.k;
                this.k = i2 + 1;
                sb.append(i2);
                abVar2.setName(sb.toString());
                this.j.a();
                this.j.a(this);
                this.j.d();
                w wVar = this.e;
                if (wVar != null) {
                    wVar.a(new Runnable() {
                        /* class com.tencent.bugly.crashreport.crash.anr.b.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.b();
                        }
                    });
                }
            }
            AnonymousClass4 r0 = new FileObserver(this.f, 256) {
                /* class com.tencent.bugly.crashreport.crash.anr.b.AnonymousClass4 */

                @Override // android.os.FileObserver
                public final void onEvent(int i, String str) {
                    if (str != null) {
                        x.d("startWatchingPrivateAnrDir %s", str);
                        String str2 = "/data/anr/" + str;
                        if (!str2.contains("trace")) {
                            x.d("not anr file %s", str2);
                        } else if (b.this.j != null) {
                            b.this.j.a(true);
                        }
                    }
                }
            };
            this.h = r0;
            try {
                r0.startWatching();
                x.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f);
                this.e.a(new Runnable() {
                    /* class com.tencent.bugly.crashreport.crash.anr.b.AnonymousClass5 */

                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.b();
                    }
                });
            } catch (Throwable th) {
                this.h = null;
                x.d("startWatchingPrivateAnrDir failed!", new Object[0]);
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private synchronized void j() {
        if (!f()) {
            x.d("close when closed!", new Object[0]);
            return;
        }
        ab abVar = this.j;
        if (abVar != null) {
            abVar.c();
            this.j.b();
            this.j.b(this);
            this.j = null;
        }
        x.a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.h.stopWatching();
            this.h = null;
            x.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            x.d("stop anr monitor failed!", new Object[0]);
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }
}
