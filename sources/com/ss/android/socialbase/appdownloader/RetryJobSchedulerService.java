package com.ss.android.socialbase.appdownloader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

public class RetryJobSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        a.c("RetrySchedulerService", "onStartJob, id = " + jobId);
        r.a().a(jobId);
        return false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (b.j()) {
            return 2;
        }
        return onStartCommand;
    }

    static void a(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context L;
        long j2;
        p reserveWifiStatusListener;
        p reserveWifiStatusListener2;
        if (downloadInfo != null && j > 0 && (L = b.L()) != null) {
            int i2 = 2;
            if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(b.L()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener2.a(downloadInfo, 2, 3);
            }
            try {
                JobScheduler jobScheduler = (JobScheduler) L.getSystemService("jobscheduler");
                if (jobScheduler != null) {
                    try {
                        jobScheduler.cancel(downloadInfo.getId());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (i == 0 || (z && i != 2)) {
                        j = 1000;
                        j2 = 0;
                    } else {
                        j2 = 60000 + j;
                    }
                    JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(L.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
                    if (!z) {
                        i2 = 1;
                    }
                    JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
                    if (j2 > 0) {
                        requiresDeviceIdle.setOverrideDeadline(j2);
                    }
                    int schedule = jobScheduler.schedule(requiresDeviceIdle.build());
                    if (schedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(b.L()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.a(downloadInfo, 3, 3);
                    }
                    if (schedule <= 0) {
                        a.d("RetrySchedulerService", "schedule err errCode = " + schedule);
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }
}
