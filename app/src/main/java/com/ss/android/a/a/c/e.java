package com.ss.android.a.a.c;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;

/* compiled from: DownloadShortInfo */
public class e {
    public long a = -1;
    public int b = -1;
    public long c = -1;
    public long d = -1;
    public String e;
    public int f = 0;
    public boolean g;

    public boolean equals(Object obj) {
        if (!(obj instanceof e) || obj == null) {
            return super.equals(obj);
        }
        e eVar = (e) obj;
        boolean z = this.a == eVar.a;
        boolean z2 = this.b == eVar.b;
        boolean z3 = this.c == eVar.c;
        boolean z4 = (TextUtils.isEmpty(this.e) && TextUtils.isEmpty(eVar.e)) || (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(eVar.e) && this.e.equals(eVar.e));
        if (!z || !z2 || !z3 || !z4) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(this.c), this.e});
    }

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            this.a = (long) downloadInfo.getId();
            this.b = downloadInfo.getStatus();
            this.d = downloadInfo.getCurBytes();
            this.c = downloadInfo.getTotalBytes();
            this.e = downloadInfo.getTargetFilePath();
            BaseException failedException = downloadInfo.getFailedException();
            if (failedException != null) {
                this.f = failedException.getErrorCode();
            } else {
                this.f = 0;
            }
            this.g = downloadInfo.isOnlyWifi();
        }
    }
}
