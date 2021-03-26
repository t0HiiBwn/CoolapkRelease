package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadlib.f;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* compiled from: AdDownloadSecurityManager */
public class b {
    private static volatile b a;
    private Handler b = null;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void a(Context context, DownloadInfo downloadInfo) {
        if (b() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.b == null) {
                this.b = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.b.post(new Runnable() {
                /* class com.ss.android.downloadlib.addownload.b.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    k.d().a(3, k.a(), null, "下载失败，请重试！", null, 0);
                    f a2 = f.a().a(url);
                    if (a2 != null) {
                        a2.f();
                    }
                }
            });
        }
    }

    public boolean b() {
        return k.i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
