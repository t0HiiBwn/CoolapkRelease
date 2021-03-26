package com.bytedance.sdk.openadsdk.preload.geckox.d.b.a;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* compiled from: RenameFullZipChannelInterceptor */
public class c extends d<Pair<File, UpdatePackage>, Pair<String, Long>> {
    /* renamed from: a */
    public Object a_(b<Pair<String, Long>> bVar, Pair<File, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start active full zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        File parentFile = ((File) pair.first).getParentFile();
        long version = ((UpdatePackage) pair.second).getVersion();
        File parentFile2 = parentFile.getParentFile();
        File file = new File(parentFile2, version + "");
        com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
        if (parentFile.renameTo(file)) {
            return bVar.a((b<Pair<String, Long>>) new Pair<>(((UpdatePackage) pair.second).getChannel(), Long.valueOf(version)));
        }
        throw new RuntimeException("active full zip file failed:" + parentFile.getAbsolutePath());
    }
}
