package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LoadLocalChannelVersionInterceptorMulti */
public class e extends d<String, Map<String, List<Pair<String, Long>>>> {
    private File d;
    private List<String> e;

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    protected void a(Object... objArr) {
        super.a(objArr);
        this.d = (File) objArr[0];
        this.e = (List) objArr[1];
    }

    /* renamed from: a */
    public Object a_(b<Map<String, List<Pair<String, Long>>>> bVar, String str) throws Exception {
        Long a;
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", str);
        HashMap hashMap = new HashMap();
        for (String str2 : this.e) {
            File file = new File(this.d, str2);
            String[] list = file.list();
            ArrayList arrayList = new ArrayList();
            if (list != null && list.length > 0) {
                for (String str3 : list) {
                    File file2 = new File(file, str3);
                    if (file2.isDirectory() && (a = k.a(file2)) != null) {
                        arrayList.add(new Pair<>(str3, a));
                    }
                }
            }
            hashMap.put(str2, arrayList);
        }
        return bVar.a((b<Map<String, List<Pair<String, Long>>>>) hashMap);
    }
}
