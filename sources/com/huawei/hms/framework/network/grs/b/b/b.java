package com.huawei.hms.framework.network.grs.b.b;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.b.d;
import java.util.concurrent.Future;

public class b {
    private Future<d> a;
    private long b = SystemClock.elapsedRealtime();

    public b(Future<d> future) {
        this.a = future;
    }

    public Future<d> a() {
        return this.a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}
