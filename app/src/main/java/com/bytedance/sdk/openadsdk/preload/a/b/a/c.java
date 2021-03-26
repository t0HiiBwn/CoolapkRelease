package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.e;
import com.bytedance.sdk.openadsdk.preload.a.b.j;
import com.bytedance.sdk.openadsdk.preload.a.c.a;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter */
public final class c extends v<Date> {
    public static final w a = new w() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.c.AnonymousClass1 */

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new c();
            }
            return null;
        }
    };
    private final List<DateFormat> b;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (e.b()) {
            arrayList.add(j.a(2, 2));
        }
    }

    /* renamed from: a */
    public Date b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() != b.NULL) {
            return a(aVar.h());
        }
        aVar.j();
        return null;
    }

    private synchronized Date a(String str) {
        for (DateFormat dateFormat : this.b) {
            try {
                return dateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return com.bytedance.sdk.openadsdk.preload.a.b.a.a.a.a(str, new ParsePosition(0));
        } catch (ParseException e) {
            throw new t(str, e);
        }
    }

    public synchronized void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
        } else {
            cVar.b(this.b.get(0).format(date));
        }
    }
}
