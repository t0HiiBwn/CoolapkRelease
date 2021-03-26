package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BUGLY */
public final class a implements NativeExceptionHandler {
    private final Context a;
    private final b b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final com.tencent.bugly.crashreport.common.strategy.a d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean l2 = c.a().l();
        if (l2) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.c.h();
        crashDetailBean.f = this.c.k;
        crashDetailBean.g = this.c.q();
        crashDetailBean.m = this.c.g();
        crashDetailBean.n = str3;
        String str13 = "";
        crashDetailBean.o = l2 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : str13;
        crashDetailBean.p = str4;
        if (str5 != null) {
            str13 = str5;
        }
        crashDetailBean.q = str13;
        crashDetailBean.r = j;
        crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.c.s();
        crashDetailBean.h = this.c.p();
        crashDetailBean.i = this.c.B();
        crashDetailBean.v = str8;
        NativeCrashHandler instance = NativeCrashHandler.getInstance();
        String dumpFilePath = instance != null ? instance.getDumpFilePath() : null;
        String a2 = b.a(dumpFilePath, str8);
        if (!z.a(a2)) {
            crashDetailBean.V = a2;
        }
        crashDetailBean.W = b.b(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.e, null, false);
        crashDetailBean.x = b.a(str10, c.e, null, true);
        crashDetailBean.J = str7;
        crashDetailBean.K = str6;
        crashDetailBean.L = str11;
        crashDetailBean.F = this.c.k();
        crashDetailBean.G = this.c.j();
        crashDetailBean.H = this.c.l();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = z.a(this.a, c.e, (String) null);
            }
            crashDetailBean.y = y.a();
            crashDetailBean.M = this.c.a;
            crashDetailBean.N = this.c.a();
            crashDetailBean.z = z.a(c.f, false);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.q.length()) {
                String substring = crashDetailBean.q.substring(i, crashDetailBean.q.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i);
                    crashDetailBean.q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.c.d;
            }
            this.b.d(crashDetailBean);
            crashDetailBean.Q = this.c.z();
            crashDetailBean.R = this.c.A();
            crashDetailBean.S = this.c.t();
            crashDetailBean.T = this.c.y();
        } else {
            crashDetailBean.C = -1;
            crashDetailBean.D = -1;
            crashDetailBean.E = -1;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.M = -1;
            crashDetailBean.Q = -1;
            crashDetailBean.R = -1;
            crashDetailBean.S = map;
            crashDetailBean.T = this.c.y();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        x.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException2(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7, String[] strArr) {
        Throwable th;
        String str8;
        String str9;
        String str10;
        boolean z;
        boolean z2;
        x.a("Native Crash Happen v2", new Object[0]);
        try {
            String a2 = b.a(str3);
            String str11 = "UNKNOWN";
            if (i3 > 0) {
                str8 = str + "(" + str5 + ")";
                str9 = str11;
                str10 = "KERNEL";
            } else {
                if (i4 > 0) {
                    str11 = AppInfo.a(i4);
                }
                str9 = !str11.equals(String.valueOf(i4)) ? str11 + "(" + i4 + ")" : str11;
                str8 = str;
                str10 = str5;
            }
            HashMap hashMap = new HashMap();
            if (strArr != null) {
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    String str12 = strArr[i7];
                    if (str12 != null) {
                        x.a("Extra message[%d]: %s", Integer.valueOf(i7), str12);
                        String[] split = str12.split("=");
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        } else {
                            x.d("bad extraMsg %s", str12);
                        }
                    }
                }
            } else {
                x.c("not found extraMsg", new Object[0]);
            }
            String str13 = (String) hashMap.get("HasPendingException");
            if (str13 == null || !str13.equals("true")) {
                z = false;
            } else {
                x.a("Native crash happened with a Java pending exception.", new Object[0]);
                z = true;
            }
            String str14 = (String) hashMap.get("ExceptionProcessName");
            if (str14 == null || str14.length() == 0) {
                str14 = this.c.d;
            } else {
                x.c("Name of crash process: %s", str14);
            }
            String str15 = (String) hashMap.get("ExceptionThreadName");
            if (str15 == null || str15.length() == 0) {
                Thread currentThread = Thread.currentThread();
                str15 = currentThread.getName() + "(" + currentThread.getId() + ")";
            } else {
                x.c("Name of crash thread: %s", str15);
                Iterator<Thread> it2 = Thread.getAllStackTraces().keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                    Thread next = it2.next();
                    if (next.getName().equals(str15)) {
                        str15 = str15 + "(" + next.getId() + ")";
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    str15 = str15 + "(" + i2 + ")";
                }
            }
            long j3 = (j * 1000) + (j2 / 1000);
            String str16 = (String) hashMap.get("SysLogPath");
            String str17 = (String) hashMap.get("JniLogPath");
            if (!this.d.b()) {
                x.d("no remote but still store!", new Object[0]);
            }
            if (this.d.c().e || !this.d.b()) {
                try {
                    CrashDetailBean packageCrashDatas = packageCrashDatas(str14, str15, j3, str8, str2, a2, str10, str9, str4, str16, str17, str7, null, null, true, z);
                    if (packageCrashDatas == null) {
                        x.e("pkg crash datas fail!", new Object[0]);
                        return;
                    }
                    b.a("NATIVE_CRASH", z.a(), str14, str15, str8 + "\n" + str2 + "\n" + a2, packageCrashDatas);
                    try {
                        boolean z3 = !this.b.b(packageCrashDatas);
                        String str18 = null;
                        NativeCrashHandler instance = NativeCrashHandler.getInstance();
                        if (instance != null) {
                            str18 = instance.getDumpFilePath();
                        }
                        b.a(true, str18);
                        if (z3) {
                            this.b.a(packageCrashDatas, 3000L, true);
                        }
                        this.b.c(packageCrashDatas);
                    } catch (Throwable th2) {
                        th = th2;
                        if (!x.a(th)) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (!x.a(th)) {
                    }
                }
            } else {
                x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a("NATIVE_CRASH", z.a(), str14, str15, str8 + "\n" + str2 + "\n" + a2, null);
                z.b(str4);
            }
        } catch (Throwable th4) {
            th = th4;
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }
}
