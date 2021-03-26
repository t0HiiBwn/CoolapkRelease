package com.bytedance.sdk.openadsdk.preload.geckox.d.b.b;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.b;
import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* compiled from: DownloadPatchZipInterceptor */
public class c extends d<Pair<Uri, UpdatePackage>, Pair<a, UpdatePackage>> {
    private b d;
    private File e;

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    protected void a(Object... objArr) {
        super.a(objArr);
        this.d = (b) objArr[0];
        this.e = (File) objArr[1];
    }

    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start download patch zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        String uri = ((Uri) pair.first).toString();
        long length = updatePackage.getPatch().getLength();
        File file = this.e;
        File file2 = new File(file, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
        file2.mkdirs();
        a a = com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl.a.a(this.d.a(), new File(file2, "patch.tmp"), length);
        try {
            this.d.h().a(uri, length, new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b(a));
            try {
                return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<a, UpdatePackage>>) new Pair<>(a, updatePackage));
            } finally {
                a.e();
            }
        } catch (Throwable th) {
            a.e();
            throw new com.bytedance.sdk.openadsdk.preload.geckox.b.a("download patch zip failed, url:" + uri + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
