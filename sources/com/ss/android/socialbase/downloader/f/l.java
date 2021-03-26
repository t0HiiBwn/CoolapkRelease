package com.ss.android.socialbase.downloader.f;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.e;
import java.io.IOException;

/* compiled from: SegmentOutput */
class l implements e {
    private final i a;
    private final e b;
    private final e c;

    public l(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.a = iVar;
        this.b = a(downloadInfo, iVar);
        this.c = new h(bVar, this);
    }

    public e a() {
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(a aVar) throws IOException {
        this.b.a(aVar.a, 0, aVar.c);
        this.a.b((long) aVar.c);
    }

    public void b() throws IOException {
        this.b.b();
    }

    public void c() throws IOException {
        this.b.c();
    }

    public void d() {
        com.ss.android.socialbase.downloader.i.e.a(this.b);
    }

    public i e() {
        return this.a;
    }

    private e a(DownloadInfo downloadInfo, i iVar) throws BaseException {
        e a2 = com.ss.android.socialbase.downloader.i.e.a(downloadInfo.getTempPath(), downloadInfo.getTempName(), a.a(downloadInfo.getId()).a("flush_buffer_size_byte", -1));
        try {
            a2.a(iVar.d());
            return a2;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }
}
