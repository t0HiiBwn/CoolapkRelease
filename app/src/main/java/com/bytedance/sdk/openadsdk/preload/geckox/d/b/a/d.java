package com.bytedance.sdk.openadsdk.preload.geckox.d.b.a;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.l;
import java.io.File;

/* compiled from: UnzipFullZipInterceptor */
public class d extends com.bytedance.sdk.openadsdk.preload.b.d<Pair<a, UpdatePackage>, Pair<File, UpdatePackage>> {
    /* renamed from: a */
    public Object a_(b<Pair<File, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start unzip full zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        aVar.b(0);
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        File parentFile = aVar.f().getParentFile();
        try {
            l.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), parentFile.getAbsolutePath(), updatePackage.getChannel());
            aVar.a();
            File file = new File(parentFile, "res");
            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
            if (new File(parentFile, updatePackage.getChannel()).renameTo(file)) {
                return bVar.a((b<Pair<File, UpdatePackage>>) new Pair<>(aVar.f(), updatePackage));
            }
            throw new RuntimeException("rename unziped full zip file failed:" + parentFile.getAbsolutePath() + ", dest:" + file.getAbsolutePath() + ", exist?" + file.exists());
        } catch (Exception e) {
            throw new RuntimeException("unzip full zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", dir:" + parentFile.getAbsolutePath() + ", caused by:" + e.getMessage(), e);
        }
    }
}
