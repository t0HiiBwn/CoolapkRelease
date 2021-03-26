package com.bytedance.sdk.openadsdk.i.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.i.b.c;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.i.g.d;
import java.io.File;

/* compiled from: DiskCache */
public class b extends a {
    public final File a;

    public void a() {
        d.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.i.a.b.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                b.this.b();
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.i.d.c().d();
        Context a2 = e.a();
        if (a2 != null) {
            c.a(a2).a(1);
        }
        for (File file : this.a.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File c(String str) {
        return e(str);
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File d(String str) {
        return e(str);
    }

    File e(String str) {
        return new File(this.a, str);
    }
}
