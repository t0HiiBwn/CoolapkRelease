package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.i.e;

/* compiled from: DefaultIdGenerator */
public class i implements j {
    @Override // com.ss.android.socialbase.downloader.downloader.j
    public int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String e = e.e(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(e)) {
            return 0;
        }
        return e.hashCode();
    }
}
