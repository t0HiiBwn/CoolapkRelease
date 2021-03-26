package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a.a;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.d.e;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: TNCManager */
public class f implements c {
    private static f c;
    Handler a = new Handler(Looper.getMainLooper()) {
        /* class com.bytedance.sdk.adnet.c.f.AnonymousClass1 */

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10000) {
                f.this.a(message.arg1 != 0);
            }
        }
    };
    private long b = 0;
    private boolean d = false;
    private Context e;
    private e f;
    private int g = 0;
    private long h = 19700101000L;
    private int i = 0;
    private HashMap<String, Integer> j = new HashMap<>();
    private HashMap<String, Integer> k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private int f1281l = 0;
    private HashMap<String, Integer> m = new HashMap<>();
    private HashMap<String, Integer> n = new HashMap<>();
    private boolean o = true;
    private Map<String, Integer> p = new HashMap();

    private boolean a(int i2) {
        return i2 >= 200 && i2 < 400;
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (c == null) {
                c = new f();
            }
            fVar = c;
        }
        return fVar;
    }

    private f() {
    }

    public void b() {
        this.p.clear();
    }

    public synchronized void a(Context context, boolean z) {
        if (!this.d) {
            this.e = context;
            this.o = z;
            this.f = new e(context, z);
            if (z) {
                f();
            }
            c.b("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.g + " probeVersion: " + this.h);
            this.d = true;
        }
    }

    private void f() {
        SharedPreferences sharedPreferences = this.e.getSharedPreferences("ttnet_tnc_config", 0);
        this.g = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.h = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    public d c() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public Map<String, String> d() {
        d c2 = c();
        if (c2 != null) {
            return c2.d;
        }
        return null;
    }

    public e e() {
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    public String a(String str) {
        String str2;
        Throwable th;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String str3 = null;
            try {
                URL url = new URL(str);
                str2 = url.getProtocol();
                try {
                    str3 = url.getHost();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = null;
                th.printStackTrace();
                if (!d(str3)) {
                }
            }
            if (!TextUtils.isEmpty(str2) && (("http".equals(str2) || "https".equals(str2)) && !TextUtils.isEmpty(str3))) {
                if (!d(str3)) {
                    c.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str3);
                    return str;
                }
                Map<String, String> d2 = d();
                if (d2 == null || !d2.containsKey(str3)) {
                    c.b("TNCManager", "handleHostMapping, nomatch: " + str3);
                } else {
                    String str4 = d2.get(str3);
                    if (TextUtils.isEmpty(str4)) {
                        return str;
                    }
                    c.b("TNCManager", "handleHostMapping, match, origin: " + str);
                    String str5 = str2 + "://" + str3;
                    String str6 = str2 + "://" + str4;
                    if (str.startsWith(str5)) {
                        str = str.replaceFirst(str5, str6);
                    }
                    c.b("TNCManager", "handleHostMapping, target: " + str);
                    return str;
                }
            }
        }
        return str;
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, m mVar) {
        if (request != null && mVar != null) {
            if (this.o) {
                if (e.a(this.e)) {
                    URL url = null;
                    try {
                        url = new URL(request.getUrl());
                    } catch (Exception unused) {
                    }
                    if (url != null) {
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String ipAddrStr = request.getIpAddrStr();
                        int i2 = (int) mVar.h;
                        if (!"http".equals(protocol) && !"https".equals(protocol)) {
                            return;
                        }
                        if (!TextUtils.isEmpty(ipAddrStr)) {
                            c.b("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2);
                            d c2 = c();
                            if (c2 != null && c2.b) {
                                a(mVar, host);
                            }
                            if (c2 != null) {
                                c.b("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2 + " " + this.i + "#" + this.j.size() + "#" + this.k.size() + " " + this.f1281l + "#" + this.m.size() + "#" + this.n.size());
                                if (i2 > 0) {
                                    if (a(i2)) {
                                        if (this.i > 0 || this.f1281l > 0) {
                                            g();
                                        }
                                        c(host);
                                    } else if (!b(i2)) {
                                        this.f1281l++;
                                        this.m.put(path, 0);
                                        this.n.put(ipAddrStr, 0);
                                        if (this.f1281l >= c2.h && this.m.size() >= c2.i && this.n.size() >= c2.j) {
                                            c.b("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2);
                                            a(false, 0L);
                                            g();
                                        }
                                        b(host);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(String str) {
        Map<String, String> d2;
        if (TextUtils.isEmpty(str) || (d2 = d()) == null || !d2.containsValue(str)) {
            return;
        }
        if (this.p.get(str) == null) {
            this.p.put(str, 1);
        } else {
            this.p.put(str, Integer.valueOf(this.p.get(str).intValue() + 1));
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.p.containsKey(str)) {
            this.p.put(str, 0);
        }
    }

    private boolean d(String str) {
        Map<String, String> d2 = d();
        if (d2 == null) {
            return false;
        }
        String str2 = d2.get(str);
        if (TextUtils.isEmpty(str2) || this.p.get(str2) == null || this.p.get(str2).intValue() < 3) {
            return false;
        }
        c.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, Exception exc) {
        if (request != null && exc != null) {
            if (this.o) {
                if (e.a(this.e)) {
                    URL url = null;
                    try {
                        url = new URL(request.getUrl());
                    } catch (Exception unused) {
                    }
                    if (url != null) {
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String ipAddrStr = request.getIpAddrStr();
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            d c2 = c();
                            if (c2 != null) {
                                c.b("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "# " + this.i + "#" + this.j.size() + "#" + this.k.size() + " " + this.f1281l + "#" + this.m.size() + "#" + this.n.size());
                                this.i = this.i + 1;
                                this.j.put(path, 0);
                                this.k.put(ipAddrStr, 0);
                                if (this.i >= c2.e && this.j.size() >= c2.f && this.k.size() >= c2.g) {
                                    c.b("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + ipAddrStr);
                                    a(false, 0L);
                                    g();
                                }
                                b(host);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    private void a(m mVar, String str) {
        long j2;
        int i2;
        d c2;
        Throwable th;
        if (mVar != null && this.o) {
            String a2 = mVar.a("tnc-cmd", (String) null);
            if (TextUtils.isEmpty(a2)) {
                c.b("TNCManager", "handleTncProbe, no probeProto, " + str);
                return;
            }
            String[] split = a2.split("@");
            if (split == null || split.length != 2) {
                c.b("TNCManager", "handleTncProbe, probeProto err, " + str);
                return;
            }
            long j3 = 0;
            try {
                i2 = Integer.parseInt(split[0]);
                try {
                    j2 = Long.parseLong(split[1]);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                i2 = 0;
                th.printStackTrace();
                c.b("TNCManager", "handleTncProbe, probeProto except, " + str);
                j2 = 0;
                c.b("TNCManager", "handleTncProbe, local: " + this.g + "@" + this.h + " svr: " + i2 + "@" + j2 + " " + str);
                if (j2 <= this.h) {
                }
            }
            c.b("TNCManager", "handleTncProbe, local: " + this.g + "@" + this.h + " svr: " + i2 + "@" + j2 + " " + str);
            if (j2 <= this.h) {
                this.g = i2;
                this.h = j2;
                this.e.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", i2).putLong("tnc_probe_version", j2).apply();
                if (this.g == 10000 && (c2 = c()) != null) {
                    Random random = new Random(System.currentTimeMillis());
                    if (c2.f1280l > 0) {
                        j3 = ((long) random.nextInt(c2.f1280l)) * 1000;
                    }
                    c.b("TNCManager", "handleTncProbe, updateConfig delay: " + j3 + " " + str);
                    a(true, j3);
                }
            }
        }
    }

    private void a(boolean z, long j2) {
        if (!this.a.hasMessages(10000)) {
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.what = 10000;
            obtainMessage.arg1 = z ? 1 : 0;
            if (j2 > 0) {
                this.a.sendMessageDelayed(obtainMessage, j2);
            } else {
                this.a.sendMessage(obtainMessage);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        d c2 = c();
        if (c2 != null) {
            c.b("TNCManager", "doUpdateRemote, " + z);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.b + (((long) c2.k) * 1000) <= elapsedRealtime) {
                this.b = elapsedRealtime;
                a.a(this.e).b(e.a(this.e));
                return;
            }
            c.b("TNCManager", "doUpdateRemote, time limit");
        }
    }

    private void g() {
        c.b("TNCManager", "resetTNCControlState");
        this.i = 0;
        this.j.clear();
        this.k.clear();
        this.f1281l = 0;
        this.m.clear();
        this.n.clear();
    }

    private boolean b(int i2) {
        if (i2 < 100 || i2 >= 1000) {
            return true;
        }
        d c2 = c();
        if (c2 == null || TextUtils.isEmpty(c2.m)) {
            return false;
        }
        String str = c2.m;
        if (str.contains("" + i2)) {
            return true;
        }
        return false;
    }
}
