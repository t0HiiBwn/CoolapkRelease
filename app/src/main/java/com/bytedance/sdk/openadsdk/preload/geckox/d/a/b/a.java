package com.bytedance.sdk.openadsdk.preload.geckox.d.a.b;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.h;
import java.io.File;

/* compiled from: CheckMergedSingleFileMD5Interceptor */
public class a extends d<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>, Pair<File, UpdatePackage>> {
    /* renamed from: a */
    public Object a_(b<Pair<File, UpdatePackage>> bVar, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check merged single file, channel:", ((UpdatePackage) pair.second).getChannel());
        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar = (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) pair.first;
        aVar.b(0);
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        try {
            h.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), updatePackage.getFullPackage().getMd5());
            return bVar.a((b<Pair<File, UpdatePackage>>) new Pair<>(aVar.f(), updatePackage));
        } catch (Throwable th) {
            throw new RuntimeException("check merged single file failed, channel：" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
