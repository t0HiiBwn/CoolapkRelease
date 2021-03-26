package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;

public class DownloadHandleService extends Service {
    private static final String a = "DownloadHandleService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        a(intent);
        return 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r4 = r4.getIntExtra("extra_download_id", 0);
     */
    private void a(Intent intent) {
        final int intExtra;
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || intExtra == 0) {
                return;
            }
            if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
                b.l().execute(new Runnable() {
                    /* class com.ss.android.socialbase.downloader.impls.DownloadHandleService.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c.a().o(intExtra);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
                c.a().q(intExtra);
            } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
                b.b();
            }
        }
    }
}
