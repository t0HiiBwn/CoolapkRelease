package com.alibaba.mtl.log.upload;

import com.alibaba.mtl.log.a.a;
import com.alibaba.mtl.log.d.b;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.r;
import java.util.Random;

public class UploadEngine {
    static UploadEngine a = new UploadEngine();
    private int B;
    private boolean G = false;
    protected long z = a.a();

    public static UploadEngine getInstance() {
        return a;
    }

    public synchronized void start() {
        this.G = true;
        if (r.a().b(2)) {
            r.a().f(2);
        }
        c();
        Random random = new Random();
        if (!a.isRunning()) {
            r.a().a(2, new a() {
                /* class com.alibaba.mtl.log.upload.UploadEngine.AnonymousClass1 */

                @Override // com.alibaba.mtl.log.upload.a
                public void H() {
                    if (UploadEngine.this.G) {
                        com.alibaba.mtl.log.b.a.D();
                        UploadEngine.this.c();
                        i.a("UploadTask", "mPeriod:", Long.valueOf(UploadEngine.this.z));
                        if (r.a().b(2)) {
                            r.a().f(2);
                        }
                        if (!a.isRunning()) {
                            r.a().a(2, this, UploadEngine.this.z);
                        }
                    }
                }

                @Override // com.alibaba.mtl.log.upload.a
                public void I() {
                    UploadEngine.this.refreshInterval();
                }
            }, (long) random.nextInt((int) this.z));
        }
    }

    public void refreshInterval() {
        if (this.B == 0) {
            this.B = 7000;
        } else {
            this.B = 0;
        }
    }

    public synchronized void stop() {
        this.G = false;
        r.a().f(2);
    }

    /* access modifiers changed from: private */
    public long c() {
        int i;
        long j;
        i.a("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(com.alibaba.mtl.log.a.o), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(b.b(com.alibaba.mtl.log.a.getContext())));
        com.alibaba.mtl.log.a.o = !b.b(com.alibaba.mtl.log.a.getContext());
        boolean z2 = com.alibaba.mtl.log.a.o;
        a.a();
        if (z2) {
            j = a.b();
            i = this.B;
        } else {
            j = a.a();
            i = this.B;
        }
        this.z = j + ((long) i);
        if (a.e()) {
            this.z = 3000;
        }
        return this.z;
    }
}
