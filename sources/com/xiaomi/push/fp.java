package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class fp extends fi {
    protected Exception a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Socket f478a;
    protected XMPushService b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    String f479c = null;
    private String d;
    protected volatile long e = 0;
    protected volatile long f = 0;
    protected volatile long g = 0;

    public fp(XMPushService xMPushService, fj fjVar) {
        super(xMPushService, fjVar);
        this.b = xMPushService;
    }

    private void a(fj fjVar) {
        a(fjVar.c(), fjVar.mo337a());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d8, code lost:
        r24.g = android.os.SystemClock.elapsedRealtime();
        com.xiaomi.channel.commonutils.logger.b.m41a("connected to " + r8 + " in " + r24.f460a);
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
        if (android.text.TextUtils.equals(r5, com.xiaomi.push.bc.m129a((android.content.Context) r24.b)) == false) goto L_0x027e;
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
        cm cmVar;
        String str2;
        String str3;
        Throwable th;
        String str4;
        Iterator<String> it2;
        String str5;
        Exception e2;
        String str6;
        Throwable th2;
        this.a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = b.a("get bucket for host : " + str).intValue();
        cm a2 = a(str);
        b.a(Integer.valueOf(intValue));
        int i2 = 1;
        if (a2 != null) {
            arrayList = a2.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.g = 0;
        String a3 = bc.m129a((Context) this.b);
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
            this.f459a += i2;
            try {
                b.m41a("begin to connect to " + next);
                this.f478a = mo342a();
                this.f478a.connect(co.m183a(next, i), 8000);
                b.m41a("tcp connected");
                this.f478a.setTcpNoDelay(true);
                this.d = next;
                mo343a();
                try {
                    this.f460a = System.currentTimeMillis() - currentTimeMillis;
                    this.f469b = a3;
                    if (a2 == null) {
                        sb = sb2;
                        str3 = next;
                        break;
                    }
                    it2 = it3;
                    sb = sb2;
                    str3 = next;
                    cmVar = a2;
                    str6 = a3;
                    try {
                        a2.b(next, this.f460a, 0);
                        break;
                    } catch (Exception e3) {
                        e2 = e3;
                        str2 = str6;
                        z = true;
                        try {
                            this.a = e2;
                            if (!z) {
                            }
                            str5 = str2;
                            z2 = z;
                            a3 = str5;
                            sb2 = sb;
                            a2 = cmVar;
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
                            this.a = new Exception("abnormal exception", th2);
                            b.a(th2);
                            if (!z) {
                            }
                            str5 = str2;
                            z2 = z;
                            a3 = str5;
                            sb2 = sb;
                            a2 = cmVar;
                            it3 = it2;
                            i2 = 1;
                        } catch (Throwable th5) {
                            th = th5;
                            str2 = str6;
                            if (!z) {
                                b.d("SMACK: Could not connect to:" + str3);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(str3);
                                sb.append(" port:");
                                sb.append(i);
                                sb.append(" err:");
                                sb.append(this.a.getClass().getSimpleName());
                                sb.append("\n");
                                gw.a(str3, this.a);
                                if (cmVar != null) {
                                    str4 = str2;
                                    cmVar.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, this.a);
                                } else {
                                    str4 = str2;
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    it2 = it3;
                    sb = sb2;
                    str3 = next;
                    cmVar = a2;
                    str2 = a3;
                    z = true;
                    this.a = e2;
                    if (!z) {
                        b.d("SMACK: Could not connect to:" + str3);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(str3);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.a.getClass().getSimpleName());
                        sb.append("\n");
                        gw.a(str3, this.a);
                        if (cmVar != null) {
                            str5 = str2;
                            cmVar.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, this.a);
                        } else {
                            str5 = str2;
                        }
                        if (!TextUtils.equals(str5, bc.m129a((Context) this.b))) {
                            cq.a().m193c();
                            if (!z) {
                            }
                        } else {
                            z2 = z;
                            a3 = str5;
                            sb2 = sb;
                            a2 = cmVar;
                            it3 = it2;
                            i2 = 1;
                        }
                    }
                    str5 = str2;
                    z2 = z;
                    a3 = str5;
                    sb2 = sb;
                    a2 = cmVar;
                    it3 = it2;
                    i2 = 1;
                } catch (Throwable th6) {
                    th2 = th6;
                    it2 = it3;
                    sb = sb2;
                    str3 = next;
                    cmVar = a2;
                    str6 = a3;
                    z = true;
                    this.a = new Exception("abnormal exception", th2);
                    b.a(th2);
                    if (!z) {
                        b.d("SMACK: Could not connect to:" + str3);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(str3);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.a.getClass().getSimpleName());
                        sb.append("\n");
                        gw.a(str3, this.a);
                        if (cmVar != null) {
                            cmVar.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, this.a);
                        }
                        str2 = str6;
                        if (!TextUtils.equals(str2, bc.m129a((Context) this.b))) {
                            cq.a().m193c();
                            if (!z) {
                            }
                        }
                    } else {
                        str2 = str6;
                    }
                    str5 = str2;
                    z2 = z;
                    a3 = str5;
                    sb2 = sb;
                    a2 = cmVar;
                    it3 = it2;
                    i2 = 1;
                }
            } catch (Exception e5) {
                e2 = e5;
                it2 = it3;
                sb = sb2;
                str3 = next;
                cmVar = a2;
                str2 = a3;
                z = z2;
                this.a = e2;
                if (!z) {
                }
                str5 = str2;
                z2 = z;
                a3 = str5;
                sb2 = sb;
                a2 = cmVar;
                it3 = it2;
                i2 = 1;
            } catch (Throwable th7) {
            }
            z2 = z;
            a3 = str5;
            sb2 = sb;
            a2 = cmVar;
            it3 = it2;
            i2 = 1;
        }
        cq.a().m193c();
        if (!z) {
            throw new ft(sb.toString());
        }
    }

    @Override // com.xiaomi.push.fi
    cm a(String str) {
        cm a2 = cq.a().a(str, false);
        if (!a2.b()) {
            gl.a(new fs(this, str));
        }
        return a2;
    }

    @Override // com.xiaomi.push.fi
    /* renamed from: a */
    public String mo328a() {
        return this.d;
    }

    @Override // com.xiaomi.push.fi
    /* renamed from: a  reason: collision with other method in class */
    public Socket mo342a() {
        return new Socket();
    }

    @Override // com.xiaomi.push.fi
    /* renamed from: a  reason: collision with other method in class */
    protected synchronized void mo343a() {
    }

    protected synchronized void a(int i, Exception exc) {
        if (b() != 2) {
            a(2, i, exc);
            this.f464a = "";
            try {
                this.f478a.close();
            } catch (Throwable unused) {
            }
            this.e = 0;
            this.f = 0;
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (bc.b(this.b)) {
                int i = this.c + 1;
                this.c = i;
                if (i >= 2) {
                    String a2 = mo328a();
                    b.m41a("max short conn time reached, sink down current host:" + a2);
                    a(a2, 0, exc);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.c = 0;
    }

    protected void a(String str, long j, Exception exc) {
        cm a2 = cq.a().a(fj.a(), false);
        if (a2 != null) {
            a2.b(str, j, 0, exc);
            cq.a().m193c();
        }
    }

    /* renamed from: a */
    protected abstract void mo327a(boolean z);

    @Override // com.xiaomi.push.fi
    public void a(fb[] fbVarArr) {
        throw new ft("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fi
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fi
    public void b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo327a(z);
        if (!z) {
            this.b.a(new fq(this, 13, currentTimeMillis), 10000);
        }
    }

    @Override // com.xiaomi.push.fi
    public String c() {
        return this.f464a;
    }

    public void c(int i, Exception exc) {
        this.b.a(new fr(this, 2, i, exc));
    }

    public synchronized void e() {
        try {
            if (!c()) {
                if (!b()) {
                    a(0, 0, (Exception) null);
                    a(this.f461a);
                    return;
                }
            }
            b.m41a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new ft(e2);
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }
}
