package com.huawei.hms.update.a;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.utils.Checker;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ThreadWrapper */
public class c implements a {
    private static final Executor a = Executors.newSingleThreadExecutor();
    private final a b;

    public c(a aVar) {
        Checker.checkNonNull(aVar, "update must not be null.");
        this.b = aVar;
    }

    /* access modifiers changed from: private */
    public static b b(final b bVar) {
        return new b() {
            /* class com.huawei.hms.update.a.c.AnonymousClass1 */

            @Override // com.huawei.hms.update.a.a.b
            public void a(final int i, final com.huawei.hms.update.a.a.c cVar) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.huawei.hms.update.a.c.AnonymousClass1.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        bVar.a(i, cVar);
                    }
                });
            }

            @Override // com.huawei.hms.update.a.a.b
            public void a(final int i, final int i2, final int i3, final File file) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.huawei.hms.update.a.c.AnonymousClass1.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        bVar.a(i, i2, i3, file);
                    }
                });
            }
        };
    }

    @Override // com.huawei.hms.update.a.a.a
    public void a() {
        this.b.a();
    }

    @Override // com.huawei.hms.update.a.a.a
    public void a(final b bVar, final com.huawei.hms.update.a.a.c cVar) {
        a.execute(new Runnable() {
            /* class com.huawei.hms.update.a.c.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                c.this.b.a(c.b(bVar), cVar);
            }
        });
    }
}
