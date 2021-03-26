package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.q;

/* compiled from: DefaultRetryDelayTimeCalculator */
public class j implements q {
    @Override // com.ss.android.socialbase.downloader.downloader.q
    public long a(int i, int i2) {
        if (i == 1) {
            return 3000;
        }
        if (i == 2) {
            return 15000;
        }
        if (i == 3) {
            return 30000;
        }
        return i > 3 ? 300000 : 0;
    }
}
