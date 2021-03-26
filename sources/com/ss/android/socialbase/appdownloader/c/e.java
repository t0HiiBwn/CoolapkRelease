package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: IAppDownloadEventListener */
public interface e {
    String a();

    void a(int i, String str, int i2, long j);

    void a(int i, String str, String str2, String str3);

    void a(Context context, String str);

    void a(DownloadInfo downloadInfo);

    boolean a(boolean z);
}
