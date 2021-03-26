package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bd;
import com.xiaomi.push.es;

public class XMJobService extends Service {
    static Service a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f896a = null;

    static class a extends JobService {
        Binder a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f897a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        private static class HandlerC0157a extends Handler {
            JobService a;

            HandlerC0157a(JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    b.m41a("Job finished " + jobParameters.getJobId());
                    this.a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        es.a(false);
                    }
                }
            }
        }

        a(Service service) {
            this.a = null;
            this.a = (Binder) bd.a((Object) this, "onBind", new Intent());
            bd.a((Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            b.m41a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f897a == null) {
                this.f897a = new HandlerC0157a(this);
            }
            Handler handler = this.f897a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            b.m41a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f896a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f896a = new a(this).a;
        }
        a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}
