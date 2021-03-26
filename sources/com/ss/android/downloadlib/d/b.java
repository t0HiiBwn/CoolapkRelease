package com.ss.android.downloadlib.d;

import com.ss.android.a.a.a.l;
import com.ss.android.a.a.d.a;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* compiled from: ApkUpdateManager */
public class b implements m {
    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) throws BaseException {
        l j = k.j();
        if (downloadInfo != null && j != null) {
            String packageName = downloadInfo.getPackageName();
            String targetFilePath = downloadInfo.getTargetFilePath();
            File a = a(packageName, targetFilePath);
            com.ss.android.downloadad.a.b.b a2 = f.a().a(downloadInfo);
            j.a(packageName, targetFilePath, a, a2 != null ? com.ss.android.downloadlib.h.k.a(a2.g()) : null);
            downloadInfo.setMimeType("application/vnd.android.package-archive");
            downloadInfo.setName(a.getName());
            downloadInfo.setMd5(null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return a.a(com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File a(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
