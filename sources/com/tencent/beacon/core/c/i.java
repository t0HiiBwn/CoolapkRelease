package com.tencent.beacon.core.c;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.b.e;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.c;
import com.tencent.beacon.core.d.f;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.protocol.common.ResponsePackage;
import com.tencent.beacon.core.protocol.common.SocketResponsePackage;
import com.tencent.beacon.core.strategy.a;
import com.tencent.beacon.upload.UploadHandleListener;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: UploadHandlerImp */
public final class i implements h {
    private static i a;
    private SparseArray<g> b = new SparseArray<>(5);
    private List<UploadHandleListener> c = new ArrayList(5);
    private ArrayList<j> d = new ArrayList<>(5);
    private Context e;
    private boolean f;
    private boolean g;

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new i(context);
                b.h("[net] create upload handler successfully.", new Object[0]);
            }
            iVar = a;
        }
        return iVar;
    }

    private i(Context context) {
        Context context2 = null;
        this.e = null;
        this.f = true;
        this.g = true;
        context2 = context != null ? context.getApplicationContext() : context2;
        if (context2 != null) {
            this.e = context2;
        } else {
            this.e = context;
        }
    }

    @Override // com.tencent.beacon.core.c.h
    public final synchronized boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        this.b.append(101, gVar);
        return true;
    }

    public final synchronized boolean a(UploadHandleListener uploadHandleListener) {
        if (uploadHandleListener == null) {
            return false;
        }
        if (!this.c.contains(uploadHandleListener)) {
            this.c.add(uploadHandleListener);
        }
        return true;
    }

    @Override // com.tencent.beacon.core.c.h
    public final void a(a aVar) {
        CharSequence charSequence;
        d dVar;
        int i;
        Throwable th;
        a aVar2;
        Throwable th2;
        int i2;
        byte[] bArr;
        int i3;
        boolean z;
        String p;
        int c2 = aVar.c();
        boolean z2 = false;
        if (!a() || !b()) {
            if (c2 == 2) {
                b.h("[event] Not UpProc real event sync 2 DB done false", new Object[0]);
                aVar.b(false);
                return;
            }
            b.h("[event] NotUpProcess, don't upload, return!", new Object[0]);
        } else if (!c.b(this.e)) {
            b.c("[net] doUpload network is disabled or qimei is empty", new Object[0]);
            if (c2 == 2) {
                aVar.b(false);
            }
        } else {
            String e2 = aVar.e();
            if (e2 == null || "".equals(e2.trim())) {
                b.d("[net] url error", new Object[0]);
                if (c2 == 2) {
                    aVar.b(false);
                }
                a(c2, -1, 0, 0, false, "url error");
                return;
            }
            byte[] b2 = b(aVar);
            if (b2 == null) {
                b.c("[event] sendData is null", new Object[0]);
                a(c2, -1, 0, 0, false, "sendData error");
                return;
            }
            f e3 = e();
            if (e3 == null) {
                b.d("[net] reqH is null.", new Object[0]);
                a(c2, -1, 0, 0, false, "reqHandler error");
                return;
            }
            if (!e3.a()) {
                String d2 = aVar.d();
                String str = null;
                if (d2 != null) {
                    str = "?rid=" + d2;
                }
                a a2 = a.a();
                if (!(a2 == null || (p = a2.p()) == null || "".equals(p))) {
                    if (str == null) {
                        str = "?sid=" + p;
                    } else {
                        str = str + "&sid=" + p;
                    }
                }
                if (str != null) {
                    e2 = e2 + str;
                }
            }
            b.h("[net] start upload cmd: %d  url:%s  data type:%s", Integer.valueOf(c2), e2, aVar.getClass().getSimpleName());
            e.i(this.e);
            d dVar2 = new d();
            h.a(com.tencent.beacon.core.b.b.a(this.e).h());
            try {
                if (e3.a()) {
                    try {
                        i2 = 1;
                    } catch (Throwable th3) {
                        th = th3;
                        charSequence = "";
                        i = -1;
                        dVar = dVar2;
                        try {
                            long b3 = dVar.b();
                            try {
                                a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                                dVar.e();
                                aVar.f();
                                dVar.f();
                                dVar.d();
                                try {
                                    a(c2, b3);
                                    a.a().i();
                                    b.d("[net] req error  %s", th.toString());
                                    aVar.b(z2);
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    aVar2 = aVar;
                                    aVar2.b(z2);
                                    throw th2;
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                aVar2 = aVar;
                                aVar2.b(z2);
                                throw th2;
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            aVar2 = aVar;
                            aVar2.b(z2);
                            throw th2;
                        }
                    }
                    try {
                        bArr = e3.a(e2, a.a().k(), b2, aVar, dVar2);
                        if (bArr != null) {
                            SocketResponsePackage socketResponsePackage = new SocketResponsePackage();
                            socketResponsePackage.readFrom(new com.tencent.beacon.core.wup.a(bArr));
                            b.b("[net] received body size:%d |statusCode:%d |header:%s |msg:%s", Integer.valueOf(socketResponsePackage.body.length), Integer.valueOf(socketResponsePackage.statusCode), socketResponsePackage.header, socketResponsePackage.msg);
                            Map<String, String> map = socketResponsePackage.header;
                            if (map.containsKey("session_id") && map.containsKey("max_time")) {
                                a.a().a(this.e, map.get("session_id"), map.get("max_time"));
                            }
                            bArr = socketResponsePackage.body;
                        }
                        dVar2 = dVar2;
                    } catch (Throwable th7) {
                        th = th7;
                        charSequence = "";
                        dVar = dVar2;
                        i = -1;
                        long b3 = dVar.b();
                        a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                        dVar.e();
                        aVar.f();
                        dVar.f();
                        dVar.d();
                        a(c2, b3);
                        a.a().i();
                        b.d("[net] req error  %s", th.toString());
                        aVar.b(z2);
                    }
                } else {
                    i2 = 1;
                    byte[] a3 = e3.a(e2, b2, aVar, dVar2);
                    if (a3 == null) {
                        try {
                            if (aVar.c() == 100 && !"http://strategy.beacon.qq.com/analytics/upload".equals(e2)) {
                                a3 = e3.a("http://strategy.beacon.qq.com/analytics/upload", b2, aVar, dVar2);
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            charSequence = "";
                            i = -1;
                            dVar = dVar2;
                            long b3 = dVar.b();
                            a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                            dVar.e();
                            aVar.f();
                            dVar.f();
                            dVar.d();
                            a(c2, b3);
                            a.a().i();
                            b.d("[net] req error  %s", th.toString());
                            aVar.b(z2);
                        }
                    }
                    bArr = a3;
                }
                long b4 = dVar2.b();
                long c3 = dVar2.c();
                ResponsePackage a4 = a(bArr);
                if (a4 != null) {
                    int i4 = a4.cmd;
                    try {
                        boolean z3 = a4.result == 0;
                        try {
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(a4.cmd);
                            objArr[i2] = Byte.valueOf(a4.result);
                            b.b("[net] response cmd:%d result:%d", objArr);
                            i3 = i4;
                            z = z3;
                        } catch (Throwable th9) {
                            th = th9;
                            i = i4;
                            z2 = z3;
                            charSequence = "";
                            dVar = dVar2;
                            long b3 = dVar.b();
                            a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                            dVar.e();
                            aVar.f();
                            dVar.f();
                            dVar.d();
                            a(c2, b3);
                            a.a().i();
                            b.d("[net] req error  %s", th.toString());
                            aVar.b(z2);
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        i = i4;
                        charSequence = "";
                        dVar = dVar2;
                        long b3 = dVar.b();
                        a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                        dVar.e();
                        aVar.f();
                        dVar.f();
                        dVar.d();
                        a(c2, b3);
                        a.a().i();
                        b.d("[net] req error  %s", th.toString());
                        aVar.b(z2);
                    }
                } else {
                    z = false;
                    i3 = -1;
                }
                if (a4 != null) {
                    try {
                        com.tencent.beacon.core.b.b a5 = com.tencent.beacon.core.b.b.a(this.e);
                        if (a5 != null) {
                            if (a4.srcGatewayIp != null) {
                                try {
                                    a5.c(a4.srcGatewayIp.trim());
                                } catch (Throwable th11) {
                                    th = th11;
                                    z2 = z;
                                    charSequence = "";
                                    i = i3;
                                }
                            }
                            charSequence = "";
                            try {
                                a5.a(a4.serverTime - new Date().getTime());
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = a5.g();
                                objArr2[i2] = Long.valueOf(a5.h());
                                b.h("[net] fix ip:%s  tmgap: %d", objArr2);
                            } catch (Throwable th12) {
                                th = th12;
                                dVar = dVar2;
                                z2 = z;
                                i = i3;
                                long b3 = dVar.b();
                                a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                                dVar.e();
                                aVar.f();
                                dVar.f();
                                dVar.d();
                                a(c2, b3);
                                a.a().i();
                                b.d("[net] req error  %s", th.toString());
                                aVar.b(z2);
                            }
                        } else {
                            charSequence = "";
                        }
                        byte[] bArr2 = a4.sBuffer;
                        if (bArr2 == null) {
                            b.h("[net] no response! ", new Object[0]);
                        } else {
                            SparseArray<g> f2 = f();
                            if (f2 != null) {
                                if (f2.size() > 0) {
                                    int c4 = aVar.c();
                                    int i5 = a4.cmd;
                                    if (a4.result == 0 && c4 > 0 && c4 <= 5) {
                                        d.a(this.e);
                                    }
                                    if (i5 == 0) {
                                        b.h("[net] response with no data", new Object[0]);
                                    } else {
                                        if (c4 != 4) {
                                            if (c4 != 100) {
                                                if (c4 != 102) {
                                                    Object[] objArr3 = new Object[i2];
                                                    objArr3[0] = Integer.valueOf(c4);
                                                    b.c("[net] unknown req: %d ", objArr3);
                                                } else if (i5 != 103) {
                                                    Object[] objArr4 = new Object[2];
                                                    objArr4[0] = Integer.valueOf(c4);
                                                    objArr4[i2] = Integer.valueOf(i5);
                                                    b.c("[net] UNMATCH req: %d  , rep: %d", objArr4);
                                                }
                                            } else if (i5 != 101) {
                                                Object[] objArr5 = new Object[2];
                                                objArr5[0] = Integer.valueOf(c4);
                                                objArr5[i2] = Integer.valueOf(i5);
                                                b.c("[net] UNMATCH req: %d , rep: %d", objArr5);
                                            }
                                        } else if (i5 != 105) {
                                            Object[] objArr6 = new Object[2];
                                            objArr6[0] = Integer.valueOf(c4);
                                            objArr6[i2] = Integer.valueOf(i5);
                                            b.c("[net] UNMATCH req: %d , rep: %d", objArr6);
                                        }
                                        a(f2, i5, bArr2);
                                    }
                                }
                            }
                            b.h("[net] no handler! ", new Object[0]);
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        charSequence = "";
                        dVar = dVar2;
                        z2 = z;
                        i = i3;
                        long b3 = dVar.b();
                        a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                        dVar.e();
                        aVar.f();
                        dVar.f();
                        dVar.d();
                        a(c2, b3);
                        a.a().i();
                        b.d("[net] req error  %s", th.toString());
                        aVar.b(z2);
                    }
                } else {
                    charSequence = "";
                }
                dVar = dVar2;
                try {
                    a(c2, i3, b4, c3, z, null);
                    if (a4 != null) {
                        String.valueOf((int) a4.result);
                    }
                    dVar.e();
                    aVar.f();
                    dVar.f();
                    dVar.d();
                    a(c2, b4);
                    aVar.b(z);
                } catch (Throwable th14) {
                    th = th14;
                    z2 = z;
                    i = i3;
                    long b3 = dVar.b();
                    a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                    dVar.e();
                    aVar.f();
                    dVar.f();
                    dVar.d();
                    a(c2, b3);
                    if (a.a().h() && (th instanceof ConnectException)) {
                        a.a().i();
                    }
                    b.d("[net] req error  %s", th.toString());
                    aVar.b(z2);
                }
            } catch (Throwable th15) {
                th = th15;
                charSequence = "";
                dVar = dVar2;
                i = -1;
                z2 = false;
                long b3 = dVar.b();
                a(c2, i, b3, dVar.c(), false, th.toString().replace("java.lang.Exception: ", charSequence));
                dVar.e();
                aVar.f();
                dVar.f();
                dVar.d();
                a(c2, b3);
                a.a().i();
                b.d("[net] req error  %s", th.toString());
                aVar.b(z2);
            }
        }
    }

    private static byte[] b(a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            RequestPackage a2 = aVar.a();
            if (a2 == null) {
                return null;
            }
            b.b("[net] RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", a2.appkey, a2.sdkId, a2.appVersion, Integer.valueOf(a2.cmd));
            com.tencent.beacon.core.wup.c cVar = new com.tencent.beacon.core.wup.c();
            cVar.a.iRequestId = 1;
            cVar.a.sServantName = "test";
            cVar.a.sFuncName = "test";
            cVar.a("detail", a2);
            byte[] a3 = cVar.a();
            b.b("[event] reqPackage to wup byte size: %d", Integer.valueOf(a3.length));
            a a4 = a.a();
            if (a4 == null) {
                return null;
            }
            byte[] a5 = h.a(a3, a4.m(), a4.l(), a4.o());
            b.b("[event] wup through zip->encry byte size: %d", Integer.valueOf(a5.length));
            return a5;
        } catch (Throwable th) {
            b.d("[event] parseSendData error", new Object[0]);
            b.a(th);
            aVar.b();
            return null;
        }
    }

    private static ResponsePackage a(byte[] bArr) {
        byte[] bArr2;
        if (bArr != null) {
            try {
                a a2 = a.a();
                if (a2 != null) {
                    bArr2 = h.b(bArr, a2.m(), a2.l(), a2.o());
                } else {
                    bArr2 = null;
                }
                if (bArr2 != null) {
                    com.tencent.beacon.core.wup.c cVar = new com.tencent.beacon.core.wup.c();
                    cVar.a(bArr2);
                    return (ResponsePackage) cVar.b("detail", new ResponsePackage());
                }
            } catch (Throwable th) {
                b.a(th);
            }
        }
        return null;
    }

    private void a(int i, int i2, long j, long j2, boolean z, String str) {
        UploadHandleListener[] d2 = d();
        if (d2 != null) {
            for (UploadHandleListener uploadHandleListener : d2) {
                uploadHandleListener.onUploadEnd(i, i2, j, j2, z, str);
            }
        }
    }

    private synchronized UploadHandleListener[] d() {
        List<UploadHandleListener> list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (UploadHandleListener[]) this.c.toArray(new UploadHandleListener[0]);
    }

    private synchronized f e() {
        return f.a(this.e);
    }

    private synchronized SparseArray<g> f() {
        SparseArray<g> sparseArray = this.b;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        new f();
        return f.a(this.b);
    }

    private boolean a(SparseArray<g> sparseArray, int i, byte[] bArr) {
        if (!(sparseArray == null || bArr == null)) {
            if (i != 103) {
                g gVar = sparseArray.get(i);
                if (gVar == null) {
                    b.c("[net] no handler key:%d", Integer.valueOf(i));
                    return false;
                }
                try {
                    b.b("[net] key:%d  handler: %s", Integer.valueOf(i), gVar.getClass().toString());
                    gVar.a(i, bArr, true);
                    return true;
                } catch (Throwable th) {
                    b.a(th);
                    b.d("[net] handle error key:%d", Integer.valueOf(i));
                    return false;
                }
            } else {
                b.a("[net] process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
                d.a(this.e).g().updateQimei(bArr);
            }
        }
        return true;
    }

    public final synchronized boolean a() {
        return this.f;
    }

    public final synchronized void a(boolean z) {
        this.f = z;
    }

    public final synchronized boolean b() {
        return c.a(this.e) || this.g;
    }

    public final synchronized void b(boolean z) {
        this.g = z;
    }

    public final ArrayList<j> c() {
        return this.d;
    }

    private void a(int i, long j) {
        if (i != 0 && j != 0) {
            Iterator<j> it2 = this.d.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
