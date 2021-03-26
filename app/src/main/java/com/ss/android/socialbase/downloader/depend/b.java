package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* compiled from: AbsDownloadForbiddenCallback */
public abstract class b implements w {
    private boolean a = false;

    @Override // com.ss.android.socialbase.downloader.depend.w
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.a = true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.w
    public boolean a() {
        return this.a;
    }
}
