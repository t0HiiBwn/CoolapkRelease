package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.network.l;

/* compiled from: DefaultChunkAdjustCalculator */
public class b implements f {
    @Override // com.ss.android.socialbase.downloader.downloader.f
    public int a(int i, l lVar) {
        if (lVar.ordinal() <= l.MODERATE.ordinal()) {
            return 1;
        }
        return lVar == l.GOOD ? i - 1 : i;
    }
}
