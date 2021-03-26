package com.bytedance.tea.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.tea.crash.a.f;
import com.bytedance.tea.crash.d.c;
import com.bytedance.tea.crash.e.a.e;
import com.bytedance.tea.crash.e.h;
import com.bytedance.tea.crash.g.a;
import com.bytedance.tea.crash.upload.d;
import java.util.Map;

/* compiled from: Npth */
public final class g {
    private static boolean a;
    private static boolean b;
    private static boolean c;
    private static boolean d;

    public static synchronized void a(Context context, d dVar, boolean z, boolean z2) {
        synchronized (g.class) {
            a(context, dVar, z, false, z2);
        }
    }

    public static synchronized void a(Context context, d dVar, boolean z, boolean z2, boolean z3) {
        synchronized (g.class) {
            a(context, dVar, z, z, z2, z3);
        }
    }

    public static synchronized void a(final Context context, d dVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        synchronized (g.class) {
            if (!a) {
                if (context == null) {
                    throw new IllegalArgumentException("context must be not null.");
                } else if (dVar != null) {
                    if (!(context instanceof Application)) {
                        context = context.getApplicationContext();
                    }
                    if (!a.c(context)) {
                        h.a(context, dVar);
                        e.a(context);
                        if (z || z2) {
                            com.bytedance.tea.crash.d.a a2 = com.bytedance.tea.crash.d.a.a();
                            if (z) {
                                a2.a(new c(context));
                            }
                            b = true;
                        }
                        d = z3;
                        a = true;
                        c = z4;
                        h.b().post(new Runnable() {
                            /* class com.bytedance.tea.crash.g.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.tea.crash.b.a.a().a(context);
                                d.a(context);
                                if (z4) {
                                    f.a(context).a();
                                }
                            }
                        });
                    }
                } else {
                    throw new IllegalArgumentException("params must be not null.");
                }
            }
        }
    }

    public static void a(f fVar) {
        h.b().a(fVar);
    }

    public static void a(Map<? extends String, ? extends String> map) {
        if (map != null && !map.isEmpty()) {
            h.b().a(map);
        }
    }
}
