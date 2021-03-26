package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import java.util.Map;

/* compiled from: Response */
public class m<T> {
    public final T a;
    public final a.C0035a b;
    public final VAdError c;
    public boolean d;
    public long e;
    public long f;
    public Map<String, Object> g;
    public long h;

    /* compiled from: Response */
    public interface a<T> {
        void a(m<T> mVar);

        void b(m<T> mVar);
    }

    public static <T> m<T> a(T t, a.C0035a aVar) {
        return new m<>(t, aVar);
    }

    public static <T> m<T> a(VAdError vAdError) {
        return new m<>(vAdError);
    }

    public Object a(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.g) == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean a() {
        return this.c == null;
    }

    private m(T t, a.C0035a aVar) {
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.h = 0;
        this.a = t;
        this.b = aVar;
        this.c = null;
        if (aVar != null) {
            this.h = (long) aVar.a;
        }
    }

    private m(VAdError vAdError) {
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.h = 0;
        this.a = null;
        this.b = null;
        this.c = vAdError;
        if (0 == 0 && vAdError != null && vAdError.networkResponse != null) {
            this.h = (long) vAdError.networkResponse.a;
        }
    }

    public m a(long j) {
        this.e = j;
        return this;
    }

    public m b(long j) {
        this.f = j;
        return this;
    }

    public String a(String str, String str2) {
        String str3;
        a.C0035a aVar = this.b;
        return (aVar == null || aVar.h == null || (str3 = this.b.h.get(str)) == null) ? str2 : str3;
    }
}
