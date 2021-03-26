package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.XMJobService;

public class dy implements dw.a {
    Context a;
    JobScheduler b;
    private boolean c = false;

    dy(Context context) {
        this.a = context;
        this.b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.dw.a
    public void a() {
        this.c = false;
        this.b.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        c.c("schedule Job = " + build.getId() + " in " + j);
        this.b.schedule(builder.build());
    }

    @Override // com.xiaomi.push.dw.a
    public void a(boolean z) {
        if (z || this.c) {
            long c2 = (long) es.c();
            if (z) {
                a();
                c2 -= SystemClock.elapsedRealtime() % c2;
            }
            this.c = true;
            a(c2);
        }
    }

    @Override // com.xiaomi.push.dw.a
    public boolean b() {
        return this.c;
    }
}
