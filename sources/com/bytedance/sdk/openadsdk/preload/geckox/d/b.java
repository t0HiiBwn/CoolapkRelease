package com.bytedance.sdk.openadsdk.preload.geckox.d;

import com.bytedance.sdk.openadsdk.preload.b.j;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.util.List;

/* compiled from: FullPatchRetryInterceptor */
public class b extends j<UpdatePackage, UpdatePackage> {
    /* access modifiers changed from: protected */
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage) {
        UpdatePackage.Package patch = updatePackage.getPatch();
        if (patch == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        List<String> urlList = patch.getUrlList();
        if (urlList == null || urlList.isEmpty()) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
        return "patch";
    }

    /* access modifiers changed from: protected */
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage, Throwable th, String str) {
        if ("patch".equals(str)) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        throw new RuntimeException("full update failed, caused by:" + th.getMessage(), th);
    }
}
