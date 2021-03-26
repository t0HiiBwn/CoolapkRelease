package com.bytedance.sdk.adnet.face;

import com.bytedance.sdk.adnet.core.Header;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: ICache */
public interface a {
    C0035a a(String str);

    void a();

    void a(String str, C0035a aVar);

    /* renamed from: com.bytedance.sdk.adnet.face.a$a  reason: collision with other inner class name */
    /* compiled from: ICache */
    public static class C0035a {
        public int a;
        public byte[] b;
        public String c;
        public long d;
        public long e;
        public long f;
        public long g;
        public Map<String, String> h = Collections.emptyMap();
        public List<Header> i;

        public boolean a() {
            return this.f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.g < System.currentTimeMillis();
        }
    }
}
