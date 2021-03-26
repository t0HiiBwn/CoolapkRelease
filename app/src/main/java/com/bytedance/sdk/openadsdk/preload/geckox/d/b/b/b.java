package com.bytedance.sdk.openadsdk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.h;

/* compiled from: CheckPatchZipMD5Interceptor */
public class b extends d<Pair<a, UpdatePackage>, Pair<a, UpdatePackage>> {
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check patch zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        aVar.b(0);
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        try {
            h.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), updatePackage.getPatch().getMd5());
            return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<a, UpdatePackage>>) pair);
        } catch (Throwable th) {
            throw new com.bytedance.sdk.openadsdk.preload.geckox.b.b("check patch zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
