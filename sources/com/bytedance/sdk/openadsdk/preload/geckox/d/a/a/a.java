package com.bytedance.sdk.openadsdk.preload.geckox.d.a.a;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.h;
import java.io.File;

/* compiled from: CheckFullSingleFileMD5Interceptor */
public class a extends d<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>, Pair<File, UpdatePackage>> {
    /* renamed from: a */
    public Object a_(b<Pair<File, UpdatePackage>> bVar, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check full single file channel:", ((UpdatePackage) pair.second).getChannel());
        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar = (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) pair.first;
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        aVar.b(0);
        try {
            h.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), updatePackage.getFullPackage().getMd5());
            aVar.a();
            return bVar.a((b<Pair<File, UpdatePackage>>) new Pair<>(aVar.f(), updatePackage));
        } catch (Throwable th) {
            throw new com.bytedance.sdk.openadsdk.preload.geckox.b.b("check full single file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
