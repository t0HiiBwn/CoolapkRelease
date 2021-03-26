package com.tencent.beacon.core.c;

import android.content.Context;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.b.e;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.event.o;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import java.util.HashMap;

/* compiled from: AbstractUploadDatas */
public abstract class a {
    protected final int a;
    protected final int b;
    protected Context c;
    protected String d;
    protected int e;
    protected String f;
    protected AbstractC0121a g;

    /* renamed from: com.tencent.beacon.core.c.a$a  reason: collision with other inner class name */
    /* compiled from: AbstractUploadDatas */
    public interface AbstractC0121a {
        void a(boolean z);
    }

    public abstract RequestPackage a();

    public abstract void b(boolean z);

    public a(Context context, int i, int i2, String str) {
        this.c = context;
        this.a = i2;
        this.b = i;
        this.f = str;
    }

    public a(Context context, String str, AbstractC0121a aVar) {
        this.c = context;
        this.a = 102;
        this.b = 0;
        this.f = str;
        this.g = aVar;
    }

    public final int c() {
        return this.a;
    }

    public final synchronized String d() {
        return this.d;
    }

    public final String e() {
        try {
            if (this.b == 0) {
                return StrategyQueryModule.getInstance(this.c).getStrategy().b();
            }
            return StrategyQueryModule.getInstance(this.c).getStrategy().b(this.b).b();
        } catch (Throwable th) {
            b.c("[strategy] get strategy error:%s", th.toString());
            b.a(th);
            return null;
        }
    }

    public static RequestPackage a(int i, byte[] bArr, String str) {
        b.b("[event] origin events byte size: %d", Integer.valueOf(bArr.length));
        try {
            return a(i, com.tencent.beacon.core.b.b.a(o.a), bArr, 2, 3, str);
        } catch (Throwable th) {
            b.c("[event] encode request package error:%s", th.toString());
            b.a(th);
            return null;
        }
    }

    public final synchronized int f() {
        return this.e;
    }

    public void b() {
        b.c("[db] encode failed, clear db data", new Object[0]);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0143: INVOKE  (r9v7 int) = 
      (wrap: android.content.Context : 0x013f: INVOKE  (r9v6 android.content.Context) = (r9v0 com.tencent.beacon.core.b.b) type: VIRTUAL call: com.tencent.beacon.core.b.b.i():android.content.Context)
     type: STATIC call: com.tencent.beacon.core.b.a.h(android.content.Context):int)] */
    public static RequestPackage a(int i, com.tencent.beacon.core.b.b bVar, byte[] bArr, int i2, int i3, String str) {
        if (bVar == null) {
            b.d("error no com info! ", new Object[0]);
            return null;
        }
        try {
            RequestPackage requestPackage = new RequestPackage();
            requestPackage.model = bVar.d();
            requestPackage.osVersion = bVar.e();
            requestPackage.platformId = bVar.f();
            requestPackage.appkey = str;
            requestPackage.appVersion = bVar.b(str);
            requestPackage.sdkId = bVar.b();
            requestPackage.sdkVersion = bVar.c();
            requestPackage.reserved = "";
            if (i == 100) {
                HashMap hashMap = new HashMap();
                hashMap.put("A1", o.b((String) null));
                d a2 = d.a(bVar.i());
                hashMap.put("A2", a2.a());
                hashMap.put("A4", a2.c());
                hashMap.put("A6", a2.b());
                hashMap.put("A7", a2.d());
                hashMap.put("A3", a2.f());
                hashMap.put("A23", bVar.a((String) null));
                hashMap.put("A31", a2.e());
                e.a(bVar.i());
                hashMap.put("A33", e.j(bVar.i()));
                if (com.tencent.beacon.core.b.a.g(bVar.i())) {
                    hashMap.put("A66", "F");
                } else {
                    hashMap.put("A66", "B");
                }
                hashMap.put("A67", com.tencent.beacon.core.b.a.i(bVar.i()));
                StringBuilder sb = new StringBuilder();
                sb.append(com.tencent.beacon.core.b.a.h(bVar.i()));
                hashMap.put("A68", sb.toString());
                hashMap.put("A85", com.tencent.beacon.core.b.a.a ? "Y" : "N");
                requestPackage.reserved = com.tencent.beacon.core.d.a.a(hashMap);
            }
            if (i == 4 || i == 2 || i == 1) {
                requestPackage.reserved = com.tencent.beacon.core.d.a.a(o.d(str));
            }
            requestPackage.cmd = i;
            requestPackage.encryType = (byte) i3;
            requestPackage.zipType = (byte) i2;
            if (bArr == null) {
                bArr = "".getBytes();
            }
            requestPackage.sBuffer = bArr;
            return requestPackage;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }
}
