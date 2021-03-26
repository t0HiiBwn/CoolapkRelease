package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*  JADX ERROR: Class process error: JadxRuntimeException
    jadx.core.utils.exceptions.JadxRuntimeException: Code generation error after restart
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:52)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
    	at jadx.core.ProcessClass.process(ProcessClass.java:64)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:88)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:263)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:226)
    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:297)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:263)
    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
      (wrap: com.tencent.open.b.g$6 : 0x0008: CONSTRUCTOR  (r6v0 com.tencent.open.b.g$6) = 
      (r7v0 'this' com.tencent.open.b.g A[IMMUTABLE_TYPE, THIS])
      (r10v0 'bundle' android.os.Bundle A[SKIP_ARG])
      (r8v0 'str' java.lang.String A[SKIP_ARG])
      (r11v0 'z' boolean A[SKIP_ARG])
      (r9v0 'str2' java.lang.String A[SKIP_ARG])
     call: com.tencent.open.b.g.6.<init>(com.tencent.open.b.g, android.os.Bundle, java.lang.String, boolean, java.lang.String):void type: CONSTRUCTOR)
     type: STATIC call: com.tencent.open.utils.i.a(java.lang.Runnable):void in method: com.tencent.open.b.g.a(java.lang.String, java.lang.String, android.os.Bundle, boolean):void, file: classes4.dex
    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:283)
    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:108)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:54)
    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:259)
    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:252)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:341)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:294)
    	... 5 more
    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r6v0 com.tencent.open.b.g$6) = 
      (r7v0 'this' com.tencent.open.b.g A[IMMUTABLE_TYPE, THIS])
      (r10v0 'bundle' android.os.Bundle A[SKIP_ARG])
      (r8v0 'str' java.lang.String A[SKIP_ARG])
      (r11v0 'z' boolean A[SKIP_ARG])
      (r9v0 'str2' java.lang.String A[SKIP_ARG])
     call: com.tencent.open.b.g.6.<init>(com.tencent.open.b.g, android.os.Bundle, java.lang.String, boolean, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.open.b.g.a(java.lang.String, java.lang.String, android.os.Bundle, boolean):void, file: classes4.dex
    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:283)
    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:953)
    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:778)
    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:395)
    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:277)
    	... 14 more
    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:297)
    	... 5 more
    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: IF  (r4v9 'i' int) >= (r1v3 'a2' int)  -> B:51:0x00e0 in method: com.tencent.open.b.g.6.run():void, file: classes4.dex
    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:283)
    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:108)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:54)
    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:97)
    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:97)
    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:304)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:259)
    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:252)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:341)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:294)
    	... 5 more
    Caused by: jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
    	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:632)
    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:277)
    	... 28 more
    */
/* compiled from: ProGuard */
public class g {
    protected static g a;
    protected Random b = new Random();
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected HandlerThread e = null;
    protected Handler f;
    protected Executor g = i.b();
    protected Executor h = i.b();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    private g() {
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new Handler(this.e.getLooper()) {
                /* class com.tencent.open.b.g.AnonymousClass1 */

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1000) {
                        g.this.b();
                    } else if (i == 1001) {
                        g.this.e();
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle != null) {
            f.a("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
            if (a("report_via", str) || z) {
                this.g.execute(new Runnable() {
                    /* class com.tencent.open.b.g.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("uin", "1000");
                            bundle.putString("imei", c.b(e.a()));
                            bundle.putString("imsi", c.c(e.a()));
                            bundle.putString("android_id", c.d(e.a()));
                            bundle.putString("mac", c.a());
                            bundle.putString("platform", "1");
                            bundle.putString("os_ver", Build.VERSION.RELEASE);
                            bundle.putString("position", j.c(e.a()));
                            bundle.putString("network", a.a(e.a()));
                            bundle.putString("language", c.b());
                            bundle.putString("resolution", c.a(e.a()));
                            bundle.putString("apn", a.b(e.a()));
                            bundle.putString("model_name", Build.MODEL);
                            bundle.putString("timezone", TimeZone.getDefault().getID());
                            bundle.putString("sdk_ver", "3.3.0.lite");
                            bundle.putString("qz_ver", j.d(e.a(), "com.qzone"));
                            bundle.putString("qq_ver", j.c(e.a(), "com.tencent.mobileqq"));
                            bundle.putString("qua", j.e(e.a(), e.b()));
                            bundle.putString("packagename", e.b());
                            bundle.putString("app_ver", j.d(e.a(), e.b()));
                            Bundle bundle2 = bundle;
                            if (bundle2 != null) {
                                bundle.putAll(bundle2);
                            }
                            g.this.d.add(new b(bundle));
                            int size = g.this.d.size();
                            int a2 = com.tencent.open.utils.f.a(e.a(), (String) null).a("Agent_ReportTimeInterval");
                            if (a2 == 0) {
                                a2 = 10000;
                            }
                            if (!g.this.a("report_via", size)) {
                                if (!z) {
                                    if (!g.this.f.hasMessages(1001)) {
                                        Message obtain = Message.obtain();
                                        obtain.what = 1001;
                                        g.this.f.sendMessageDelayed(obtain, (long) a2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            g.this.e();
                            g.this.f.removeMessages(1001);
                        } catch (Exception e) {
                            f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                        }
                    }
                });
            }
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(final String str, final long j, final long j2, final long j3, final int i, final String str2, final boolean z) {
        f.a("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", "" + i) || z) {
            this.h.execute(new Runnable() {
                /* class com.tencent.open.b.g.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
                        Bundle bundle = new Bundle();
                        String a2 = a.a(e.a());
                        bundle.putString("apn", a2);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=");
                        sb.append(a2);
                        sb.append('&');
                        sb.append("sdcard=");
                        int i = 1;
                        sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb.append('&');
                        sb.append("wifi=");
                        sb.append(a.e(e.a()));
                        bundle.putString("deviceInfo", sb.toString());
                        int a3 = 100 / g.this.a(i);
                        if (a3 > 0) {
                            i = a3 > 100 ? 100 : a3;
                        }
                        bundle.putString("frequency", i + "");
                        bundle.putString("reqSize", j2 + "");
                        bundle.putString("resultCode", i + "");
                        bundle.putString("rspSize", j3 + "");
                        bundle.putString("timeCost", elapsedRealtime + "");
                        bundle.putString("uin", "1000");
                        g.this.c.add(new b(bundle));
                        int size = g.this.c.size();
                        int a4 = com.tencent.open.utils.f.a(e.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a4 == 0) {
                            a4 = 10000;
                        }
                        if (!g.this.a("report_cgi", size)) {
                            if (!z) {
                                if (!g.this.f.hasMessages(1000)) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 1000;
                                    g.this.f.sendMessageDelayed(obtain, (long) a4);
                                    return;
                                }
                                return;
                            }
                        }
                        g.this.b();
                        g.this.f.removeMessages(1000);
                    } catch (Exception e2) {
                        f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    protected void b() {
        this.h.execute(new Runnable() {
            /* class com.tencent.open.b.g.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                /*
                    r14 = this;
                    java.lang.String r0 = "report_cgi"
                    java.lang.String r1 = "https://wspeed.qq.com/w.cgi"
                    java.lang.String r2 = "-->doReportCgi, doupload exception"
                    java.lang.String r3 = "openSDK_LOG.ReportManager"
                    com.tencent.open.b.g r4 = com.tencent.open.b.g.this     // Catch:{ Exception -> 0x00b8 }
                    android.os.Bundle r4 = r4.c()     // Catch:{ Exception -> 0x00b8 }
                    if (r4 != 0) goto L_0x0011
                    return
                L_0x0011:
                    android.content.Context r5 = com.tencent.open.utils.e.a()     // Catch:{ Exception -> 0x00b8 }
                    r6 = 0
                    com.tencent.open.utils.f r5 = com.tencent.open.utils.f.a(r5, r6)     // Catch:{ Exception -> 0x00b8 }
                    java.lang.String r7 = "Common_HttpRetryCount"
                    int r5 = r5.a(r7)     // Catch:{ Exception -> 0x00b8 }
                    if (r5 != 0) goto L_0x0023
                    r5 = 3
                L_0x0023:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8 }
                    r7.<init>()     // Catch:{ Exception -> 0x00b8 }
                    java.lang.String r8 = "-->doReportCgi, retryCount: "
                    r7.append(r8)     // Catch:{ Exception -> 0x00b8 }
                    r7.append(r5)     // Catch:{ Exception -> 0x00b8 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00b8 }
                    com.tencent.open.a.f.b(r3, r7)     // Catch:{ Exception -> 0x00b8 }
                    r7 = 0
                    r8 = 0
                L_0x0039:
                    r9 = 1
                    int r8 = r8 + r9
                    android.content.Context r10 = com.tencent.open.utils.e.a()     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    org.apache.http.client.HttpClient r10 = com.tencent.open.utils.HttpUtils.getHttpClient(r10, r6, r1)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    org.apache.http.client.methods.HttpPost r11 = new org.apache.http.client.methods.HttpPost     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r11.<init>(r1)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    java.lang.String r12 = "Accept-Encoding"
                    java.lang.String r13 = "gzip"
                    r11.addHeader(r12, r13)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    java.lang.String r12 = "Content-Type"
                    java.lang.String r13 = "application/x-www-form-urlencoded"
                    r11.setHeader(r12, r13)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    java.lang.String r12 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    byte[] r12 = com.tencent.open.utils.j.i(r12)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    org.apache.http.entity.ByteArrayEntity r13 = new org.apache.http.entity.ByteArrayEntity     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r13.<init>(r12)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r11.setEntity(r13)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    org.apache.http.HttpResponse r10 = r10.execute(r11)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    org.apache.http.StatusLine r10 = r10.getStatusLine()     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    int r10 = r10.getStatusCode()     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r11.<init>()     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    java.lang.String r12 = "-->doReportCgi, statusCode: "
                    r11.append(r12)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r11.append(r10)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    java.lang.String r11 = r11.toString()     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    com.tencent.open.a.f.b(r3, r11)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r11 = 200(0xc8, float:2.8E-43)
                    if (r10 != r11) goto L_0x00a3
                    com.tencent.open.b.f r10 = com.tencent.open.b.f.a()     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r10.b(r0)     // Catch:{ ConnectTimeoutException -> 0x009d, SocketTimeoutException -> 0x0098, Exception -> 0x0093 }
                    r7 = 1
                    goto L_0x00a3
                L_0x0093:
                    r1 = move-exception
                    com.tencent.open.a.f.b(r3, r2, r1)
                    goto L_0x00a3
                L_0x0098:
                    r9 = move-exception
                    com.tencent.open.a.f.b(r3, r2, r9)
                    goto L_0x00a1
                L_0x009d:
                    r9 = move-exception
                    com.tencent.open.a.f.b(r3, r2, r9)
                L_0x00a1:
                    if (r8 < r5) goto L_0x0039
                L_0x00a3:
                    if (r7 != 0) goto L_0x00b0
                    com.tencent.open.b.f r1 = com.tencent.open.b.f.a()
                    com.tencent.open.b.g r2 = com.tencent.open.b.g.this
                    java.util.List<java.io.Serializable> r2 = r2.c
                    r1.a(r0, r2)
                L_0x00b0:
                    com.tencent.open.b.g r0 = com.tencent.open.b.g.this
                    java.util.List<java.io.Serializable> r0 = r0.c
                    r0.clear()
                    goto L_0x00be
                L_0x00b8:
                    r0 = move-exception
                    java.lang.String r1 = "-->doReportCgi, doupload exception out."
                    com.tencent.open.a.f.b(r3, r1, r0)
                L_0x00be:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass4.run():void");
            }
        });
    }

    protected boolean a(String str, String str2) {
        int i;
        f.b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 100;
        if (str.equals("report_cgi")) {
            try {
                i = a(Integer.parseInt(str2));
                if (this.b.nextInt(100) < i) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                i = e.a(str2);
                if (this.b.nextInt(100) < i) {
                    i2 = i;
                    z = true;
                }
            }
            f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
            return z;
        }
        i2 = i;
        f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r0 == 0) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        if (r0 == 0) goto L_0x0038;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062 A[RETURN] */
    protected boolean a(String str, int i) {
        int a2;
        int i2 = 5;
        if (str.equals("report_cgi")) {
            a2 = com.tencent.open.utils.f.a(e.a(), (String) null).a("Common_CGIReportMaxcount");
        } else {
            if (str.equals("report_via")) {
                a2 = com.tencent.open.utils.f.a(e.a(), (String) null).a("Agent_ReportBatchCount");
            } else {
                i2 = 0;
            }
            f.b("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
            if (i < i2) {
                return true;
            }
            return false;
        }
        i2 = a2;
        f.b("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        if (i < i2) {
        }
    }

    protected int a(int i) {
        if (i == 0) {
            int a2 = com.tencent.open.utils.f.a(e.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = com.tencent.open.utils.f.a(e.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    protected Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        b bVar = (b) this.c.get(0);
        if (bVar == null) {
            f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.a.get("appid");
        List<Serializable> a2 = f.a().a("report_cgi");
        if (a2 != null) {
            this.c.addAll(a2);
        }
        f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", "OpenSdk_3.3.0.lite");
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", "V1_AND_OpenSDK_3.3.0.lite_1077_RDM_B");
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.c.size(); i++) {
                b bVar2 = (b) this.c.get(i);
                bundle.putString(i + "_1", bVar2.a.get("apn"));
                bundle.putString(i + "_2", bVar2.a.get("frequency"));
                bundle.putString(i + "_3", bVar2.a.get("commandid"));
                bundle.putString(i + "_4", bVar2.a.get("resultCode"));
                bundle.putString(i + "_5", bVar2.a.get("timeCost"));
                bundle.putString(i + "_6", bVar2.a.get("reqSize"));
                bundle.putString(i + "_7", bVar2.a.get("rspSize"));
                bundle.putString(i + "_8", bVar2.a.get("detail"));
                bundle.putString(i + "_9", bVar2.a.get("uin"));
                bundle.putString(i + "_10", c.e(e.a()) + "&" + bVar2.a.get("deviceInfo"));
            }
            f.a("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e2) {
            f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e2);
            return null;
        }
    }

    protected Bundle d() {
        List<Serializable> a2 = f.a().a("report_via");
        if (a2 != null) {
            this.d.addAll(a2);
        }
        f.b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Serializable> it2 = this.d.iterator();
        while (it2.hasNext()) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) it2.next();
            for (String str : bVar.a.keySet()) {
                try {
                    String str2 = bVar.a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        f.a("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e3) {
            f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
            return null;
        }
    }

    protected void e() {
        this.g.execute(new Runnable() {
            /* class com.tencent.open.b.g.AnonymousClass5 */

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
                r7 = -4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
                r0 = r4;
                r6 = -6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
                r6 = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(r0);
                r0 = r16;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
                r6 = java.lang.Integer.parseInt(r0.getMessage().replace("http status code error:", ""));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0086, code lost:
                r17.a.d.clear();
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
                r9 = android.os.SystemClock.elapsedRealtime();
                r0 = r16;
                r6 = -8;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
                r9 = android.os.SystemClock.elapsedRealtime();
                r0 = r16;
                r6 = -7;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:21:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:8:0x0038] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[ExcHandler: IOException (r0v24 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:8:0x0038] */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[ExcHandler: HttpStatusException (r0v21 'e' com.tencent.open.utils.HttpUtils$HttpStatusException A[CUSTOM_DECLARE]), Splitter:B:8:0x0038] */
            /* JADX WARNING: Removed duplicated region for block: B:28:? A[ExcHandler: NetworkUnavailableException (unused com.tencent.open.utils.HttpUtils$NetworkUnavailableException), SYNTHETIC, Splitter:B:8:0x0038] */
            /* JADX WARNING: Removed duplicated region for block: B:34:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:8:0x0038] */
            /* JADX WARNING: Removed duplicated region for block: B:36:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:8:0x0038] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3  */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00cb  */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x00b1 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle d = g.this.d();
                    if (d != null) {
                        f.a("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d.toString());
                        int a2 = e.a();
                        int i = 0;
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        boolean z = false;
                        int i2 = 0;
                        long j = 0;
                        long j2 = 0;
                        do {
                            int i3 = i + 1;
                            try {
                                j.a openUrl2 = HttpUtils.openUrl2(e.a(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d);
                                int i4 = j.d(openUrl2.a).getInt("ret");
                                if (i4 == 0 || !TextUtils.isEmpty(openUrl2.a)) {
                                    i3 = a2;
                                    z = true;
                                }
                                j = openUrl2.b;
                                j2 = openUrl2.c;
                                i = i3;
                                continue;
                            } catch (ConnectTimeoutException unused) {
                            } catch (SocketTimeoutException unused2) {
                            } catch (JSONException unused3) {
                                i = i3;
                                i2 = -4;
                                j = 0;
                                j2 = 0;
                                continue;
                                if (i >= a2) {
                                }
                            } catch (HttpUtils.NetworkUnavailableException unused4) {
                            } catch (HttpUtils.HttpStatusException e) {
                            } catch (IOException e2) {
                            } catch (Exception unused5) {
                            }
                        } while (i >= a2);
                        g.this.a("mapp_apptrace_sdk", elapsedRealtime, j, j2, i2, null, false);
                        if (!z) {
                            f.a().b("report_via");
                        } else {
                            f.a().a("report_via", g.this.d);
                        }
                        g.this.d.clear();
                        f.b("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
                    }
                } catch (Exception e3) {
                    f.b("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
                }
            }
        });
    }

    public void a(final String str, final String str2, final Bundle bundle, final boolean z) {
        i.a(new Runnable() {
            /* class com.tencent.open.b.g.AnonymousClass6 */

            /*  JADX ERROR: IF instruction can be used only in fallback mode
                jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
                	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:632)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:277)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:108)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:54)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:97)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:97)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:304)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:259)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:252)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:341)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:294)
                */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00e2  */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x00e8  */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x00e0 A[EDGE_INSN: B:51:0x00e0->B:42:0x00e0 ?: BREAK  , SYNTHETIC] */
            @Override // java.lang.Runnable
            public void run() {
                /*
                // Method dump skipped, instructions count: 250
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass6.run():void");
            }
        });
    }
}
