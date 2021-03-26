package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
public class c extends a {
    protected HashMap<String, byte[]> d = null;
    private HashMap<String, Object> e = new HashMap<>();
    private i f = new i();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void c() {
        this.d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(String str, T t) {
        if (this.d == null) {
            super.a(str, t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            j jVar = new j();
            jVar.a(this.b);
            jVar.a((Object) t, 0);
            this.d.put(str, l.a(jVar.a()));
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    public final <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.d;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.e.containsKey(str)) {
                return (T) this.e.get(str);
            }
            try {
                this.f.a(this.d.get(str));
                this.f.a(this.b);
                T t2 = (T) this.f.a((i) t, 0, true);
                if (t2 != null) {
                    this.e.put(str, t2);
                }
                return t2;
            } catch (Exception e2) {
                throw new b(e2);
            }
        } else if (!this.a.containsKey(str)) {
            return null;
        } else {
            if (this.e.containsKey(str)) {
                return (T) this.e.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator it2 = ((HashMap) this.a.get(str)).entrySet().iterator();
            if (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                entry.getKey();
                bArr = (byte[]) entry.getValue();
            }
            try {
                this.f.a(bArr);
                this.f.a(this.b);
                T t3 = (T) this.f.a((i) t, 0, true);
                this.e.put(str, t3);
                return t3;
            } catch (Exception e3) {
                throw new b(e3);
            }
        }
    }

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.d == null) {
            return super.a();
        }
        j jVar = new j(0);
        jVar.a(this.b);
        jVar.a((Map) this.d, 0);
        return l.a(jVar.a());
    }

    @Override // com.tencent.bugly.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f.a(bArr);
            this.f.a(this.b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.d = this.f.a((Map) hashMap, 0, false);
        }
    }
}
