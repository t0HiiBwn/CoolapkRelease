package com.bytedance.sdk.openadsdk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.b;
import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.BsPatch;
import java.io.File;

/* compiled from: MergePatchZipInterceptor */
public class d extends com.bytedance.sdk.openadsdk.preload.b.d<Pair<a, UpdatePackage>, Pair<a, UpdatePackage>> {
    private b d;

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    protected void a(Object... objArr) {
        super.a(objArr);
        this.d = (b) objArr[0];
    }

    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start merge patch zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        File f = aVar.f();
        aVar.a();
        aVar.e();
        File parentFile = f.getParentFile().getParentFile();
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        File file = new File(parentFile, updatePackage.getLocalVersion() + File.separator + "res.zip");
        File file2 = new File(f.getParentFile(), "res.zip");
        com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file2);
        try {
            BsPatch.a(file, f, file2.getParentFile(), file2.getName());
            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(f);
            a a = com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl.a.a(this.d.a(), file2, file2.length());
            try {
                return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<a, UpdatePackage>>) new Pair<>(a, updatePackage));
            } finally {
                a.e();
            }
        } catch (Exception e) {
            throw new RuntimeException("merged patch zip file failed, channel：" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + e.getMessage(), e);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(f);
            throw th;
        }
    }
}
