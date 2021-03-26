package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.c.a;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter */
public final class j extends v<Date> {
    public static final w a = new w() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.j.AnonymousClass1 */

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: a */
    public synchronized Date b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Date(this.b.parse(aVar.h()).getTime());
        } catch (ParseException e) {
            throw new t(e);
        }
    }

    public synchronized void a(c cVar, Date date) throws IOException {
        cVar.b(date == null ? null : this.b.format((java.util.Date) date));
    }
}
