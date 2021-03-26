package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* compiled from: RetryDelayTimeParamCalculator */
public class q implements com.ss.android.socialbase.downloader.downloader.q {
    private final long[] a;

    public q(String str) {
        this.a = a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public long a(int i, int i2) {
        long[] jArr = this.a;
        if (jArr == null || jArr.length <= 0) {
            return 0;
        }
        int i3 = i - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > jArr.length - 1) {
            i3 = jArr.length - 1;
        }
        return jArr[i3];
    }

    private long[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i = 0; i < split.length; i++) {
                jArr[i] = Long.parseLong(split[i]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
