package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import com.bytedance.sdk.openadsdk.preload.geckox.model.ComponentModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Response;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.e;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: GetServerChannelVersionInterceptorMulti */
public class c extends d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {
    private com.bytedance.sdk.openadsdk.preload.geckox.b d;
    private Map<String, Map<String, Object>> e;
    private Map<String, List<CheckRequestBodyModel.TargetChannel>> f;
    private com.bytedance.sdk.openadsdk.preload.geckox.e.a g;
    private String h;
    private com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b i = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b();

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    protected void a(Object... objArr) {
        super.a(objArr);
        this.d = (com.bytedance.sdk.openadsdk.preload.geckox.b) objArr[0];
        this.e = (Map) objArr[1];
        this.f = (Map) objArr[2];
        this.g = (com.bytedance.sdk.openadsdk.preload.geckox.e.a) objArr[3];
        this.h = (String) objArr[4];
    }

    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Throwable {
        Throwable th;
        List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> list;
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start get server channel version[v3]... local channel version:", map);
        Map<String, List<UpdatePackage>> b2 = b(map);
        e.a(this.d, this.i);
        a(b2);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<UpdatePackage>> entry : b2.entrySet()) {
            arrayList.addAll(entry.getValue());
        }
        Object obj = null;
        try {
            list = c(arrayList);
            try {
                obj = bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<List<UpdatePackage>>) arrayList);
                b(list);
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", th);
                    b(list);
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    a(arrayList);
                    return obj;
                } catch (Throwable th3) {
                    b(list);
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            list = null;
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", th);
            b(list);
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
            a(arrayList);
            return obj;
        }
        a(arrayList);
        return obj;
    }

    private void a(List<UpdatePackage> list) {
        if (!(list == null || list.isEmpty())) {
            for (UpdatePackage updatePackage : list) {
                com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(new File(new File(this.d.m(), updatePackage.getAccessKey()), updatePackage.getChannel()).getAbsolutePath());
            }
        }
    }

    private void b(List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> list) {
        if (list != null) {
            for (Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a> pair : list) {
                try {
                    ((com.bytedance.sdk.openadsdk.preload.geckox.g.a) pair.second).a();
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "releaseLock:", e2);
                }
            }
        }
    }

    private List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> c(List<UpdatePackage> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UpdatePackage updatePackage : list) {
            try {
                File file = new File(new File(this.d.m(), updatePackage.getAccessKey()), updatePackage.getChannel());
                if (file.isFile()) {
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
                }
                if (!file.mkdirs()) {
                    if (!file.isDirectory()) {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "can not create channel dir：", file.getAbsolutePath());
                        throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                    }
                }
                com.bytedance.sdk.openadsdk.preload.geckox.g.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                if (a2 != null) {
                    arrayList.add(new Pair(updatePackage.getChannel(), a2));
                    arrayList2.add(updatePackage);
                } else {
                    a(this.g, updatePackage.getChannel());
                }
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", e2);
                a(updatePackage.getChannel(), this.g, e2);
            }
        }
        list.clear();
        list.addAll(arrayList2);
        return arrayList;
    }

    private void a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, String str) {
        if (aVar != null) {
            try {
                aVar.a(str);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "onUpdating:", th);
            }
        }
    }

    private void a(String str, com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, Exception exc) {
        if (aVar != null) {
            try {
                aVar.a(str, exc);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "onUpdateFailed:", th);
            }
        }
    }

    private void a(Map<String, List<UpdatePackage>> map) {
        for (Map.Entry<String, List<UpdatePackage>> entry : map.entrySet()) {
            Iterator<UpdatePackage> it2 = entry.getValue().iterator();
            while (it2.hasNext()) {
                UpdatePackage next = it2.next();
                long localVersion = next.getLocalVersion();
                long version = next.getVersion();
                if (version < localVersion) {
                    a(it2, next, localVersion, version);
                }
            }
        }
    }

    private void a(Iterator<UpdatePackage> it2, UpdatePackage updatePackage, long j, long j2) {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", updatePackage.getChannel(), "rollback：", Long.valueOf(j), "->", Long.valueOf(j2));
        File[] listFiles = new File(this.d.m(), updatePackage.getAccessKey() + File.separator + updatePackage.getChannel()).listFiles(new FileFilter() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.d.c.AnonymousClass1 */

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file : listFiles) {
                try {
                    int i2 = (Long.parseLong(file.getName()) > j2 ? 1 : (Long.parseLong(file.getName()) == j2 ? 0 : -1));
                    if (i2 > 0) {
                        final File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                        file.renameTo(file2);
                        f.a().execute(new Runnable() {
                            /* class com.bytedance.sdk.openadsdk.preload.geckox.d.c.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file2);
                            }
                        });
                    } else if (i2 == 0) {
                        it2.remove();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private Map<String, List<UpdatePackage>> b(Map<String, List<Pair<String, Long>>> map) throws Exception {
        String c = c(map);
        String str = "https://" + this.d.i() + "/gecko/server/v3/package";
        try {
            this.i.f = i.a(this.d.a());
            com.bytedance.sdk.openadsdk.preload.geckox.i.c a2 = this.d.h().a(str, c);
            this.i.g = a2.c;
            this.i.d = a2.d;
            this.i.e = com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b.a(a2.a);
            if (a2.c == 200) {
                String str2 = a2.b;
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "response:", str2);
                try {
                    Response response = (Response) com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(str2, new com.bytedance.sdk.openadsdk.preload.a.c.a<Response<ComponentModel>>() {
                        /* class com.bytedance.sdk.openadsdk.preload.geckox.d.c.AnonymousClass3 */
                    }.b());
                    if (response.status == 0) {
                        if (response.data != null) {
                            com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.d.a(), response.data.getUniversalStrategies(), this.d.m(), this.g);
                            Map<String, List<UpdatePackage>> packages = response.data.getPackages();
                            if (packages == null || packages.isEmpty()) {
                                com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.d);
                                return new HashMap();
                            }
                            for (String str3 : this.d.e()) {
                                List<UpdatePackage> list = packages.get(str3);
                                if (list != null && !list.isEmpty()) {
                                    for (UpdatePackage updatePackage : list) {
                                        updatePackage.setAccessKey(str3);
                                        updatePackage.setLocalVersion(a(map.get(str3), updatePackage.getChannel()));
                                    }
                                }
                            }
                            return packages;
                        }
                        this.i.d = "check update error：response.data==null";
                        e.a(this.d, this.i);
                        throw new a("check update error：response.data==null");
                    } else if (response.status == 2000) {
                        com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.d);
                        return new HashMap();
                    } else {
                        String str4 = "check update error，unknow status code，response.status：" + response.status;
                        this.i.d = str4;
                        e.a(this.d, this.i);
                        throw new a(str4);
                    }
                } catch (Exception e2) {
                    this.i.d = "json parse failed：" + e2.getMessage();
                    e.a(this.d, this.i);
                    throw new b("json parse failed：" + str2 + " caused by:" + e2.getMessage(), e2);
                }
            } else {
                throw new NetworkErrorException("net work get failed, code: " + a2.c + ", url:" + str);
            }
        } catch (Exception e3) {
            e.a(this.d, this.i);
            throw new C0065c("request failed：url:" + str + ", caused by:" + e3.getMessage(), e3);
        }
    }

    private long a(List<Pair<String, Long>> list, String str) {
        for (Pair<String, Long> pair : list) {
            if (((String) pair.first).equals(str)) {
                return ((Long) pair.second).longValue();
            }
        }
        return 0;
    }

    private String c(Map<String, List<Pair<String, Long>>> map) {
        List<CheckRequestBodyModel.TargetChannel> list;
        CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
        Context a2 = this.d.a();
        checkRequestBodyModel.setCommon(new Common(this.d.j(), this.d.n(), this.d.q(), com.bytedance.sdk.openadsdk.preload.geckox.utils.a.b(a2), i.a(a2), this.d.k(), this.d.l()));
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<Pair<String, Long>>> entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Pair<String, Long> pair : entry.getValue()) {
                CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                localChannel.localVersion = (Long) pair.second;
                hashMap2.put(pair.first, localChannel);
            }
            hashMap.put(entry.getKey(), hashMap2);
        }
        this.i.a = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(hashMap);
        checkRequestBodyModel.setLocal(hashMap);
        HashMap hashMap3 = new HashMap();
        for (String str : this.d.e()) {
            CheckRequestBodyModel.Group group2 = new CheckRequestBodyModel.Group();
            group2.groupName = this.h;
            Map<String, List<CheckRequestBodyModel.TargetChannel>> map2 = this.f;
            if (map2 != null && !map2.isEmpty() && (list = this.f.get(str)) != null && !list.isEmpty()) {
                group2.targetChannels = new ArrayList();
                group2.targetChannels.addAll(list);
            }
            hashMap3.put(str, group2);
        }
        this.i.b = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(hashMap3);
        checkRequestBodyModel.setDeployments(hashMap3);
        if (this.e != null) {
            this.i.c = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(this.e);
            checkRequestBodyModel.setCustom(this.e);
        }
        return com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(checkRequestBodyModel);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.d.c$c  reason: collision with other inner class name */
    /* compiled from: GetServerChannelVersionInterceptorMulti */
    public static class C0065c extends RuntimeException {
        C0065c(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: GetServerChannelVersionInterceptorMulti */
    public static class b extends RuntimeException {
        b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: GetServerChannelVersionInterceptorMulti */
    public static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }
}
