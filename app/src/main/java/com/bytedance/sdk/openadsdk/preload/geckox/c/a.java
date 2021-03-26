package com.bytedance.sdk.openadsdk.preload.geckox.c;

import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.p;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;

/* compiled from: BooleanTypeAdapter */
public class a extends v<Boolean> {
    public void a(c cVar, Boolean bool) throws IOException {
        if (bool == null) {
            cVar.f();
        } else {
            cVar.a(bool);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.c.a$1  reason: invalid class name */
    /* compiled from: BooleanTypeAdapter */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: a */
    public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        b f = aVar.f();
        int i = AnonymousClass1.a[f.ordinal()];
        boolean z = true;
        if (i == 1) {
            return Boolean.valueOf(aVar.i());
        }
        if (i == 2) {
            aVar.j();
            return null;
        } else if (i == 3) {
            if (aVar.m() == 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else {
            throw new p("Expected BOOLEAN or NUMBER but was " + f);
        }
    }
}
