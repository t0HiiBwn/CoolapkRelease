package com.bytedance.tea.crash.e.a;

import android.content.Context;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CrashContextAssembly */
public class e {
    private static volatile e a;
    private Context b;
    private Map<c, c> c = new HashMap();
    private b d;
    private d e;

    private e(Context context) {
        this.b = context;
        this.d = new b(context);
        this.e = new d(this.b);
    }

    public static e a() {
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void a(Context context) {
        if (a == null) {
            a = new e(context);
        }
    }

    private c a(c cVar) {
        c cVar2 = this.c.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i = AnonymousClass1.a[cVar.ordinal()];
        if (i == 1) {
            cVar2 = new g(this.b, this.d, this.e);
        } else if (i == 2) {
            cVar2 = new a(this.b, this.d, this.e);
        } else if (i == 3) {
            cVar2 = new f(this.b, this.d, this.e);
        }
        if (cVar2 != null) {
            this.c.put(cVar, cVar2);
        }
        return cVar2;
    }

    /* renamed from: com.bytedance.tea.crash.e.a.e$1  reason: invalid class name */
    /* compiled from: CrashContextAssembly */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a a(c cVar, a aVar) {
        c a2;
        return (cVar == null || (a2 = a(cVar)) == null) ? aVar : a2.a(aVar);
    }
}
