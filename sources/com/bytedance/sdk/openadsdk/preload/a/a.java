package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.b.e;
import com.bytedance.sdk.openadsdk.preload.a.b.j;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultDateTypeAdapter */
final class a extends v<Date> {
    private final Class<? extends Date> a;
    private final List<DateFormat> b;

    a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = a(cls);
        arrayList.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    public a(Class<? extends Date> cls, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = a(cls);
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (e.b()) {
            arrayList.add(j.a(i, i2));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    public void a(c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
            return;
        }
        synchronized (this.b) {
            cVar.b(this.b.get(0).format(date));
        }
    }

    /* renamed from: a */
    public Date b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.j();
            return null;
        }
        Date a2 = a(aVar.h());
        Class<? extends Date> cls = this.a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }

    private Date a(String str) {
        synchronized (this.b) {
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
    }

    public String toString() {
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
