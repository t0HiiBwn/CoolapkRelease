package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class et extends em {
    protected Exception o = null;
    protected Socket p;
    String q = null;
    protected XMPushService r;
    protected volatile long s = 0;
    protected volatile long t = 0;
    protected volatile long u = 0;
    private String v;
    private int w;

    public et(XMPushService xMPushService, en enVar) {
        super(xMPushService, enVar);
        this.r = xMPushService;
    }

    private void a(en enVar) {
        a(enVar.e(), enVar.d());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d8, code lost:
        r24.u = android.os.SystemClock.elapsedRealtime();
        com.xiaomi.a.a.a.c.a("connected to " + r8 + " in " + r24.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00fc, code lost:
        r18 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x011e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011f, code lost:
        r22 = r8;
        r9 = r12;
        r8 = r13;
        r20 = r14;
        r18 = r10;
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x012a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x012b, code lost:
        r22 = r8;
        r9 = r12;
        r8 = r13;
        r20 = r14;
        r23 = r15;
        r18 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0277, code lost:
        if (android.text.TextUtils.equals(r5, com.xiaomi.push.aa.k(r24.r)) == false) goto L_0x027e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x012a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0287 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0288  */
    private void a(String str, int i) {
        StringBuilder sb;
        boolean z;
        bm bmVar;
        String str2;
        String str3;
        Throwable th;
        String str4;
        Iterator<String> it2;
        String str5;
        Exception e;
        String str6;
        Throwable th2;
        this.o = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = c.e("get bucket for host : " + str).intValue();
        bm b = b(str);
        c.a(Integer.valueOf(intValue));
        int i2 = 1;
        if (b != null) {
            arrayList = b.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.u = 0;
        String k = aa.k(this.r);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it3 = arrayList.iterator();
        boolean z2 = false;
        while (true) {
            if (!it3.hasNext()) {
                sb = sb2;
                z = z2;
                break;
            }
            String next = it3.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.b += i2;
            try {
                c.a("begin to connect to " + next);
                this.p = s();
                this.p.connect(bo.b(next, i), 8000);
                c.a("tcp connected");
                this.p.setTcpNoDelay(true);
                this.v = next;
                c();
                try {
                    this.c = System.currentTimeMillis() - currentTimeMillis;
                    this.j = k;
                    if (b == null) {
                        sb = sb2;
                        str3 = next;
                        break;
                    }
                    it2 = it3;
                    sb = sb2;
                    str3 = next;
                    bmVar = b;
                    str6 = k;
                    try {
                        b.b(next, this.c, 0);
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str6;
                        z = true;
                        try {
                            this.o = e;
                            if (!z) {
                            }
                            str5 = str2;
                            z2 = z;
                            k = str5;
                            sb2 = sb;
                            b = bmVar;
                            it3 = it2;
                            i2 = 1;
                        } catch (Throwable th3) {
                            th = th3;
                            if (!z) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        z = true;
                        try {
                            this.o = new Exception("abnormal exception", th2);
                            c.a(th2);
                            if (!z) {
                            }
                            str5 = str2;
                            z2 = z;
                            k = str5;
                            sb2 = sb;
                            b = bmVar;
                            it3 = it2;
                            i2 = 1;
                        } catch (Throwable th5) {
                            th = th5;
                            str2 = str6;
                            if (!z) {
                                c.d("SMACK: Could not connect to:" + str3);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(str3);
                                sb.append(" port:");
                                sb.append(i);
                                sb.append(" err:");
                                sb.append(this.o.getClass().getSimpleName());
                                sb.append("\n");
                                gc.a(str3, this.o);
                                if (bmVar != null) {
                                    str4 = str2;
                                    bmVar.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, this.o);
                                } else {
                                    str4 = str2;
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    it2 = it3;
                    sb = sb2;
                    str3 = next;
                    bmVar = b;
                    str2 = k;
                    z = true;
                    this.o = e;
                    if (!z) {
                        c.d("SMACK: Could not connect to:" + str3);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(str3);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.o.getClass().getSimpleName());
                        sb.append("\n");
                        gc.a(str3, this.o);
                        if (bmVar != null) {
                            str5 = str2;
                            bmVar.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, this.o);
                        } else {
                            str5 = str2;
                        }
                        if (!TextUtils.equals(str5, aa.k(this.r))) {
                            bq.a().i();
                            if (!z) {
                            }
                        } else {
                            z2 = z;
                            k = str5;
                            sb2 = sb;
                            b = bmVar;
                            it3 = it2;
                            i2 = 1;
                        }
                    }
                    str5 = str2;
                    z2 = z;
                    k = str5;
                    sb2 = sb;
                    b = bmVar;
                    it3 = it2;
                    i2 = 1;
                } catch (Throwable th6) {
                    th2 = th6;
                    it2 = it3;
                    sb = sb2;
                    str3 = next;
                    bmVar = b;
                    str6 = k;
                    z = true;
                    this.o = new Exception("abnormal exception", th2);
                    c.a(th2);
                    if (!z) {
                        c.d("SMACK: Could not connect to:" + str3);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(str3);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.o.getClass().getSimpleName());
                        sb.append("\n");
                        gc.a(str3, this.o);
                        if (bmVar != null) {
                            bmVar.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, this.o);
                        }
                        str2 = str6;
                        if (!TextUtils.equals(str2, aa.k(this.r))) {
                            bq.a().i();
                            if (!z) {
                            }
                        }
                    } else {
                        str2 = str6;
                    }
                    str5 = str2;
                    z2 = z;
                    k = str5;
                    sb2 = sb;
                    b = bmVar;
                    it3 = it2;
                    i2 = 1;
                }
            } catch (Exception e4) {
                e = e4;
                it2 = it3;
                sb = sb2;
                str3 = next;
                bmVar = b;
                str2 = k;
                z = z2;
                this.o = e;
                if (!z) {
                }
                str5 = str2;
                z2 = z;
                k = str5;
                sb2 = sb;
                b = bmVar;
                it3 = it2;
                i2 = 1;
            } catch (Throwable th7) {
            }
            z2 = z;
            k = str5;
            sb2 = sb;
            b = bmVar;
            it3 = it2;
            i2 = 1;
        }
        bq.a().i();
        if (!z) {
            throw new ey(sb.toString());
        }
    }

    protected synchronized void a(int i, Exception exc) {
        if (l() != 2) {
            a(2, i, exc);
            this.i = "";
            try {
                this.p.close();
            } catch (Throwable unused) {
            }
            this.s = 0;
            this.t = 0;
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.u < 300000) {
            if (aa.c(this.r)) {
                int i = this.w + 1;
                this.w = i;
                if (i >= 2) {
                    String e = e();
                    c.a("max short conn time reached, sink down current host:" + e);
                    a(e, 0, exc);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.w = 0;
    }

    protected void a(String str, long j, Exception exc) {
        bm a = bq.a().a(en.a(), false);
        if (a != null) {
            a.b(str, j, 0, exc);
            bq.a().i();
        }
    }

    protected abstract void a(boolean z);

    @Override // com.xiaomi.push.em
    public void a(ef[] efVarArr) {
        throw new ey("Don't support send Blob");
    }

    bm b(String str) {
        bm a = bq.a().a(str, false);
        if (!a.b()) {
            fq.a(new ex(this, str));
        }
        return a;
    }

    @Override // com.xiaomi.push.em
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.u != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.em
    public void b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        a(z);
        if (!z) {
            this.r.a(new ev(this, 13, currentTimeMillis), 10000);
        }
    }

    protected synchronized void c() {
    }

    public void c(int i, Exception exc) {
        this.r.a(new ew(this, 2, i, exc));
    }

    @Override // com.xiaomi.push.em
    public String e() {
        return this.v;
    }

    public String q() {
        return this.i;
    }

    public synchronized void r() {
        try {
            if (!j()) {
                if (!i()) {
                    a(0, 0, (Exception) null);
                    a(this.l);
                    return;
                }
            }
            c.a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new ey(e);
        }
    }

    public Socket s() {
        return new Socket();
    }

    public void t() {
        this.s = SystemClock.elapsedRealtime();
    }

    public void u() {
        this.t = SystemClock.elapsedRealtime();
    }
}
