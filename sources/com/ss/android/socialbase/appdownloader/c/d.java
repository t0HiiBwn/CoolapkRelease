package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: IAppDownloadEventHandler */
public interface d {
    void a(int i, int i2, String str, int i3, long j);

    void a(int i, int i2, String str, String str2, String str3);

    void a(Context context, String str);

    void a(DownloadInfo downloadInfo);

    boolean a();

    boolean a(int i, boolean z);
}
