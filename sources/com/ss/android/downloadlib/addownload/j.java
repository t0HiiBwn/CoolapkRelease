package com.ss.android.downloadlib.addownload;

import com.ss.android.a.a.c.e;
import com.ss.android.socialbase.downloader.g.a;

/* compiled from: DownloadPercentHelper */
public class j {
    public static int a(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !a(i)) ? i2 : (int) (Math.sqrt((double) i2) * 10.0d);
    }

    public static long a(int i, long j, long j2) {
        if (!a(i)) {
            return j;
        }
        if (j <= 0) {
            return 0;
        }
        if (j2 <= 0) {
            return j;
        }
        return (j2 * ((long) a(i, (int) ((j * 100) / j2)))) / 100;
    }

    public static e a(e eVar) {
        if (eVar != null && a((int) eVar.a)) {
            eVar.d = a((int) eVar.a, eVar.d, eVar.c);
        }
        return eVar;
    }

    private static boolean a(int i) {
        if (a.a(i).a("pause_optimise_pretend_download_percent_switch", 0) == 1 && a.a(i).a("pause_optimise_switch", 0) == 1) {
            return true;
        }
        return false;
    }
}
