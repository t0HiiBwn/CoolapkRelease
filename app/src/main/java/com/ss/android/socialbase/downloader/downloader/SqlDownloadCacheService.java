package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.ss.android.socialbase.downloader.impls.d;

public class SqlDownloadCacheService extends Service {
    private static final String a = "SqlDownloadCacheService";

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(a, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        r rVar;
        i x = b.x();
        if (x instanceof d) {
            rVar = ((d) x).e();
        } else {
            rVar = x instanceof r ? (r) x : null;
        }
        if (rVar instanceof IBinder) {
            return (IBinder) rVar;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (b.j()) {
            return 2;
        }
        return onStartCommand;
    }
}
