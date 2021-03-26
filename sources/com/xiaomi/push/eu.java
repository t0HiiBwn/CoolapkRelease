package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.es;
import com.xiaomi.push.service.XMJobService;

public class eu implements es.a {
    JobScheduler a;

    /* renamed from: a  reason: collision with other field name */
    Context f416a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f417a = false;

    eu(Context context) {
        this.f416a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.es.a
    /* renamed from: a */
    public void mo311a() {
        this.f417a = false;
        this.a.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f416a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        b.c("schedule Job = " + build.getId() + " in " + j);
        this.a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.es.a
    public void a(boolean z) {
        if (z || this.f417a) {
            long b = (long) fo.b();
            if (z) {
                mo311a();
                b -= SystemClock.elapsedRealtime() % b;
            }
            this.f417a = true;
            a(b);
        }
    }

    @Override // com.xiaomi.push.es.a
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo312a() {
        return this.f417a;
    }
}
