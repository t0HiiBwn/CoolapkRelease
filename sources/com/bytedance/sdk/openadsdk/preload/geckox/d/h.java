package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.k;
import com.bytedance.sdk.openadsdk.preload.geckox.b.a;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.util.List;

/* compiled from: RetryPatchDownloadInterceptor */
public class h extends k<UpdatePackage, Pair<Uri, UpdatePackage>> {
    private int d = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Pair<Uri, UpdatePackage> b() {
        UpdatePackage updatePackage = (UpdatePackage) g();
        List<String> urlList = updatePackage.getPatch().getUrlList();
        int i = this.d;
        this.d = i + 1;
        return new Pair<>(Uri.parse(urlList.get(i)), updatePackage);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.k
    protected boolean a(Throwable th) {
        b.a("gecko-debug-tag", "patch update failed", th);
        if (this.d >= ((UpdatePackage) g()).getPatch().getUrlList().size()) {
            return false;
        }
        if ((th instanceof a) || (th instanceof com.bytedance.sdk.openadsdk.preload.geckox.b.b)) {
            return true;
        }
        return false;
    }
}
