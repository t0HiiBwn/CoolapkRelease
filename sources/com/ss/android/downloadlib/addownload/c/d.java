package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DownloadOptimizationManager */
public class d {
    private static volatile d a;
    private long b = 0;
    private ConcurrentHashMap<String, e> c = new ConcurrentHashMap<>();
    private HashMap<String, Integer> d = new HashMap<>();
    private List<String> e = new CopyOnWriteArrayList();

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(String str, e eVar) {
        if (!TextUtils.isEmpty(str)) {
            this.c.put(str, eVar);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.remove(str);
        }
    }

    long b() {
        return this.b;
    }

    void c() {
        this.b = System.currentTimeMillis();
    }

    public int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.d == null) {
            this.d = new HashMap<>();
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str).intValue();
        }
        return 0;
    }

    public static void a(b bVar) {
        DownloadInfo downloadInfo;
        if (bVar != null && bVar.b() > 0 && (downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s())) != null) {
            a(downloadInfo);
        }
    }

    public static void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null && a.a(downloadInfo.getId()).a("delete_file_after_install", 0) != 0) {
            try {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    if (file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
