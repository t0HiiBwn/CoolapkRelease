package com.ss.android.downloadlib.addownload.c;

import android.content.Context;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* compiled from: ClearSpaceUtil */
public class c {
    public static void a() {
        List<DownloadInfo> a = d.j().a(k.a());
        if (a != null && a.size() > 0) {
            for (int i = 0; i < a.size(); i++) {
                DownloadInfo downloadInfo = a.get(i);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                long lastModified = file.lastModified();
                long a2 = ((long) a.a(downloadInfo.getId()).a("download_file_expire_hours", 0)) * 3600000;
                if (a2 <= 0) {
                    a2 = 604800000;
                }
                if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= a2) {
                    a(file);
                    Downloader.getInstance(k.a()).clearDownloadData(downloadInfo.getId());
                }
            }
        }
    }

    public static void b() {
        List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(k.a()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (!(successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty())) {
            for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
                DownloadInfo downloadInfo = successedDownloadInfosWithMimeType.get(i);
                if (downloadInfo != null) {
                    String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                    File file = new File(str);
                    if (file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                        long a = ((long) a.a(downloadInfo.getId()).a("download_complete_file_expire_hours", 0)) * 3600000;
                        if (a <= 0) {
                            a = 604800000;
                        }
                        boolean z = true;
                        if (currentTimeMillis < a && !com.ss.android.downloadlib.h.k.e(k.a(), str)) {
                            z = false;
                        }
                        if (z) {
                            a(file);
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        File externalCacheDir;
        if (context != null && (externalCacheDir = context.getExternalCacheDir()) != null) {
            try {
                a(externalCacheDir.getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030 A[SYNTHETIC, Splitter:B:22:0x0030] */
    public static void a(File file) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("1".getBytes());
                fileOutputStream.close();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            fileOutputStream = null;
            e = e3;
            try {
                e.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        file.delete();
    }

    private static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    if (str2 != null) {
                        String str3 = str.endsWith(File.separator) ? str + str2 : str + File.separator + str2;
                        File file2 = new File(str3);
                        if (file2.isFile()) {
                            file2.delete();
                        }
                        if (file2.isDirectory()) {
                            a(str3);
                        }
                    }
                }
                file.delete();
            }
        }
    }
}
