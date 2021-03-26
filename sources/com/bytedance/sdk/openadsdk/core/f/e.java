package com.bytedance.sdk.openadsdk.core.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PermissionsResultAction */
public abstract class e {
    private static final String a = "e";
    private final Set<String> b = new HashSet(1);
    private Looper c = Looper.getMainLooper();

    public abstract void a();

    public abstract void a(String str);

    public synchronized boolean b(String str) {
        String str2 = a;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    protected final synchronized boolean a(String str, int i) {
        if (i == 0) {
            return a(str, c.GRANTED);
        }
        return a(str, c.DENIED);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.f.e$5  reason: invalid class name */
    /* compiled from: PermissionsResultAction */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected final synchronized boolean a(final String str, c cVar) {
        this.b.remove(str);
        int i = AnonymousClass5.a[cVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.c).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.f.e.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.a(str);
                    }
                });
                return true;
            } else if (i == 3) {
                if (!b(str)) {
                    new Handler(this.c).post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.core.f.e.AnonymousClass4 */

                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(str);
                        }
                    });
                    return true;
                } else if (this.b.isEmpty()) {
                    new Handler(this.c).post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.core.f.e.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a();
                        }
                    });
                    return true;
                }
            }
        } else if (this.b.isEmpty()) {
            new Handler(this.c).post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.f.e.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    e.this.a();
                }
            });
            return true;
        }
        return false;
    }

    protected final synchronized void a(String[] strArr) {
        Collections.addAll(this.b, strArr);
    }
}
