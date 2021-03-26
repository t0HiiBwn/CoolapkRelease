package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.c.a;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TimeTypeAdapter */
public final class k extends v<Time> {
    public static final w a = new w() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.k.AnonymousClass1 */

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new k();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: a */
    public synchronized Time b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Time(this.b.parse(aVar.h()).getTime());
        } catch (ParseException e) {
            throw new t(e);
        }
    }

    public synchronized void a(c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.b.format((Date) time));
    }
}
