package com.ss.android.downloadlib.d;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.h.e;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* compiled from: ApkModifyNameManager */
public class a implements m {
    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo != null && c(downloadInfo)) {
            a(k.a(), downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return e.b(com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()));
        }
        return false;
    }

    private boolean c(DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        File file = new File(str);
        String a = com.ss.android.socialbase.appdownloader.f.a.e.a(k.a(), c.a(downloadInfo, file), str);
        boolean z = false;
        if (!TextUtils.isEmpty(a)) {
            String str2 = a + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                if (z) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    private void a(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() {
                /* class com.ss.android.downloadlib.d.a.AnonymousClass1 */

                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        b.x().a(downloadInfo);
                    }
                }
            });
        } else {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), (long) query.getInt(query.getColumnIndex("_id"))).toString());
        }
        com.ss.android.socialbase.downloader.i.e.a(query);
    }
}
