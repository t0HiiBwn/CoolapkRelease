package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.al;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import java.util.List;

/* compiled from: IDownloadProxy */
public interface l {
    int a(String str, String str2);

    List<DownloadInfo> a(String str);

    void a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, int i2, int i3, int i4);

    void a(int i, int i2, int i3, long j);

    void a(int i, int i2, long j);

    void a(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z);

    void a(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z, boolean z2);

    void a(int i, long j);

    void a(int i, Notification notification);

    void a(int i, ab abVar);

    void a(int i, List<b> list);

    void a(int i, boolean z);

    void a(al alVar);

    void a(DownloadTask downloadTask);

    void a(b bVar);

    void a(List<String> list);

    void a(boolean z, boolean z2);

    boolean a(DownloadInfo downloadInfo);

    DownloadInfo b(String str, String str2);

    List<DownloadInfo> b(String str);

    void b(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z);

    void b(int i, List<b> list);

    void b(int i, boolean z);

    void b(DownloadInfo downloadInfo);

    void b(DownloadTask downloadTask);

    void b(List<String> list);

    boolean b();

    boolean b(int i);

    List<DownloadInfo> c(String str);

    void c(int i);

    void c(int i, boolean z);

    boolean c();

    boolean c(DownloadInfo downloadInfo);

    List<DownloadInfo> d(String str);

    void d();

    void d(int i);

    long e(int i);

    List<DownloadInfo> e(String str);

    boolean e();

    int f(int i);

    void f();

    boolean g();

    boolean g(int i);

    DownloadInfo h(int i);

    List<b> i(int i);

    void j(int i);

    void k(int i);

    boolean l(int i);

    int m(int i);

    boolean n(int i);

    void o(int i);

    boolean p(int i);

    ab q(int i);

    ah r(int i);

    t s(int i);
}
