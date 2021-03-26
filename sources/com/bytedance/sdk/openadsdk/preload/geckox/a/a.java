package com.bytedance.sdk.openadsdk.preload.geckox.a;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import com.bytedance.sdk.openadsdk.preload.geckox.i.c;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import com.bytedance.sdk.openadsdk.preload.geckox.model.ComponentModel;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AbandonChannelClenUtils */
public class a {
    public static void a(final Context context, Map<String, ComponentModel.b> map, File file, final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (map != null && !map.isEmpty()) {
            final List<C0063a> list = null;
            try {
                list = a(map, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (list != null) {
                f.a().execute(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.preload.geckox.a.a.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.b(context, list, aVar);
                        } catch (Exception e) {
                            b.a("clean-channel", "", e);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, List<C0063a> list, com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (!(list == null || list.isEmpty())) {
            for (C0063a aVar2 : list) {
                File file = aVar2.e;
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean a = d.a(file);
                long uptimeMillis2 = SystemClock.uptimeMillis();
                if (a) {
                    if (aVar != null) {
                        aVar.b(aVar2.b);
                    }
                    b.a(context).a(aVar2.a, aVar2.b, aVar2.c, 200, aVar2.d, 0, null, uptimeMillis2 - uptimeMillis, 1);
                } else {
                    b.a(context).a(aVar2.a, aVar2.b, aVar2.c, 201, aVar2.d, 601, "delete failed", uptimeMillis2 - uptimeMillis, 1);
                }
            }
        }
    }

    private static List<C0063a> a(Map<String, ComponentModel.b> map, File file) {
        ComponentModel.b value;
        Iterator<Map.Entry<String, ComponentModel.b>> it2;
        File file2;
        Iterator<ComponentModel.a> it3;
        List<Long> b;
        Iterator<Long> it4;
        File file3;
        List<Long> b2;
        Iterator<Map.Entry<String, ComponentModel.b>> it5;
        File file4;
        File file5;
        Iterator<ComponentModel.a> it6;
        List<Long> list;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, ComponentModel.b>> it7 = map.entrySet().iterator();
        while (it7.hasNext()) {
            Map.Entry<String, ComponentModel.b> next = it7.next();
            String key = next.getKey();
            File file6 = new File(file, key);
            if (file6.isDirectory() && (value = next.getValue()) != null && value.a != null && !value.a.isEmpty()) {
                List<ComponentModel.a> list2 = value.a;
                HashSet hashSet = new HashSet();
                Iterator<ComponentModel.a> it8 = list2.iterator();
                while (it8.hasNext()) {
                    ComponentModel.a next2 = it8.next();
                    String str3 = next2.a;
                    if (!hashSet.contains(str3)) {
                        hashSet.add(str3);
                        int i = next2.b;
                        List<Long> list3 = next2.c;
                        File file7 = new File(file6, str3);
                        String str4 = "";
                        String str5 = "--pending-delete";
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    File file8 = new File(file6, str3);
                                    File file9 = new File(file6, str3 + str5);
                                    file8.renameTo(file9);
                                    arrayList.add(new C0063a(key, str3, i, 0, file9));
                                }
                            } else if (!(list3 == null || (b2 = k.b(file7)) == null || b2.isEmpty())) {
                                for (Long l : b2) {
                                    if (list3.get(0).longValue() > l.longValue()) {
                                        File file10 = new File(file7, l + str5);
                                        it5 = it7;
                                        new File(file7, l + str4).renameTo(file10);
                                        it6 = it8;
                                        str2 = str5;
                                        file5 = file7;
                                        file4 = file6;
                                        str = str4;
                                        list = list3;
                                        arrayList.add(new C0063a(key, str3, i, l.longValue(), file10));
                                    } else {
                                        it5 = it7;
                                        it6 = it8;
                                        str2 = str5;
                                        file5 = file7;
                                        list = list3;
                                        file4 = file6;
                                        str = str4;
                                    }
                                    it7 = it5;
                                    str5 = str2;
                                    str4 = str;
                                    list3 = list;
                                    it8 = it6;
                                    file7 = file5;
                                    file6 = file4;
                                }
                            }
                            it2 = it7;
                            it3 = it8;
                            file2 = file6;
                        } else {
                            it2 = it7;
                            it3 = it8;
                            File file11 = file7;
                            file2 = file6;
                            if (!(list3 == null || (b = k.b(file11)) == null || b.isEmpty())) {
                                Iterator<Long> it9 = b.iterator();
                                while (it9.hasNext()) {
                                    Long next3 = it9.next();
                                    if (list3.contains(next3)) {
                                        File file12 = new File(file11, next3 + str5);
                                        new File(file11, next3 + str4).renameTo(file12);
                                        it4 = it9;
                                        file3 = file11;
                                        arrayList.add(new C0063a(key, str3, i, next3.longValue(), file12));
                                    } else {
                                        it4 = it9;
                                        file3 = file11;
                                    }
                                    file11 = file3;
                                    it9 = it4;
                                }
                            }
                        }
                        it7 = it2;
                        it8 = it3;
                        file6 = file2;
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<StatisticModel.PackageStatisticModel> a(Context context) {
        return b.a(context).a();
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        if (bVar.c()) {
            Common common = new Common(bVar.j(), bVar.n(), bVar.q(), com.bytedance.sdk.openadsdk.preload.geckox.utils.a.b(bVar.a()), i.a(bVar.a()), bVar.k(), bVar.l());
            StatisticModel statisticModel = new StatisticModel();
            statisticModel.common = common;
            statisticModel.packages.addAll(a(bVar.a()));
            if (!statisticModel.packages.isEmpty()) {
                String str = "https://" + bVar.i() + "/gecko/server/packages/stats";
                String a = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(statisticModel);
                for (int i = 0; i < 3; i++) {
                    try {
                        a(bVar, str, a);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                b.a("clean-channel", "upload failed", a);
            }
        }
    }

    private static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, String str, String str2) throws Exception {
        c a = bVar.h().a(str, str2);
        if (a.c != 200) {
            throw new NetworkErrorException("net work get failed, code: " + a.c + ", url:" + str);
        } else if (new JSONObject(a.b).getInt("status") != 0) {
            throw new RuntimeException("upload failed");
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a$a  reason: collision with other inner class name */
    /* compiled from: AbandonChannelClenUtils */
    private static class C0063a {
        String a;
        String b;
        int c;
        long d;
        File e;

        C0063a(String str, String str2, int i, long j, File file) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = j;
            this.e = file;
        }
    }
}
