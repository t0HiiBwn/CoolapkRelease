package com.bytedance.sdk.openadsdk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.l;
import java.io.File;

/* compiled from: UnZipMergedZipInterceptor */
public class f extends d<Pair<a, UpdatePackage>, Pair<File, UpdatePackage>> {
    /* renamed from: a */
    public Object a_(b<Pair<File, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start unzip merged zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        aVar.b(0);
        File parentFile = aVar.f().getParentFile();
        try {
            l.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), parentFile.getAbsolutePath(), updatePackage.getChannel());
            aVar.a();
            File file = new File(parentFile, "res");
            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
            if (new File(parentFile, updatePackage.getChannel()).renameTo(file)) {
                return bVar.a((b<Pair<File, UpdatePackage>>) new Pair<>(aVar.f(), updatePackage));
            }
            throw new RuntimeException("rename unzip merged zip file failed:" + parentFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("unzip merged zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + e.getMessage(), e);
        }
    }
}
