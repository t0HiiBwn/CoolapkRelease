package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LoadLocalChannelVersionInterceptor */
public class d extends com.bytedance.sdk.openadsdk.preload.b.d<List<String>, List<Pair<String, Long>>> {
    private File d;
    private String e;

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    protected void a(Object... objArr) {
        super.a(objArr);
        this.d = (File) objArr[0];
        this.e = (String) objArr[1];
    }

    /* renamed from: a */
    public Object a_(b<List<Pair<String, Long>>> bVar, List<String> list) throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", list);
        File file = new File(this.d, this.e);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Long a = k.a(new File(file, str));
            arrayList.add(new Pair<>(str, Long.valueOf(a == null ? 0 : a.longValue())));
        }
        return bVar.a((b<List<Pair<String, Long>>>) arrayList);
    }
}
