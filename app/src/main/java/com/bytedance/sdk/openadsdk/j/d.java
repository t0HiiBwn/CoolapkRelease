package com.bytedance.sdk.openadsdk.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.j.a.a;
import com.bytedance.sdk.openadsdk.j.a.b;
import com.bytedance.sdk.openadsdk.j.a.c;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PoolTaskStatistics */
public class d {
    private static final ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    public static void a(a aVar, long j, long j2) {
        if (aVar != null) {
            a.offer(new a(aVar.a(), aVar.getCorePoolSize(), aVar.getMaximumPoolSize(), j, j2));
            a(false);
        }
    }

    public static void a(boolean z) {
        a[] aVarArr;
        int i;
        c f = e.f();
        if ((z || a.size() >= 60) && f != null) {
            ConcurrentLinkedQueue<a> concurrentLinkedQueue = a;
            synchronized (concurrentLinkedQueue) {
                if (!concurrentLinkedQueue.isEmpty()) {
                    aVarArr = (a[]) concurrentLinkedQueue.toArray(new a[concurrentLinkedQueue.size()]);
                    concurrentLinkedQueue.clear();
                } else {
                    return;
                }
            }
            int i2 = 0;
            if (aVarArr.length != 0) {
                HashMap hashMap = new HashMap();
                for (a aVar : aVarArr) {
                    String a2 = a(aVar.a(), aVar.b(), aVar.c());
                    c cVar = (c) hashMap.get(a2);
                    if (cVar == null) {
                        hashMap.put(a2, new c(aVar.a(), aVar.b(), aVar.c(), aVar.d(), aVar.d(), aVar.e(), aVar.e(), 1));
                    } else {
                        if (aVar.d() > cVar.c()) {
                            cVar.a(aVar.d());
                        }
                        cVar.b(aVar.d());
                        if (aVar.e() > cVar.d()) {
                            cVar.c(aVar.e());
                        }
                        cVar.d(aVar.e());
                        cVar.a(1);
                    }
                }
                for (c cVar2 : hashMap.values()) {
                    if (cVar2.e() > 0 && !TextUtils.isEmpty(cVar2.b())) {
                        String b = cVar2.b();
                        b.hashCode();
                        if (b.equals("io")) {
                            cVar2.b(((ThreadPoolExecutor) e.a()).getLargestPoolSize());
                        } else if (b.equals("aidl")) {
                            cVar2.b(((ThreadPoolExecutor) e.b()).getLargestPoolSize());
                        }
                        f.a(cVar2);
                    }
                }
            }
            Set<Thread> keySet = Thread.getAllStackTraces().keySet();
            HashMap hashMap2 = new HashMap();
            int i3 = 0;
            for (Thread thread : keySet) {
                String name = thread.getName();
                if (!TextUtils.isEmpty(name) && name.startsWith("tt_pangle_thread_")) {
                    i3++;
                    Integer num = (Integer) hashMap2.get(name);
                    if (num == null) {
                        i = 1;
                    } else {
                        i = Integer.valueOf(num.intValue() + 1);
                    }
                    hashMap2.put(name, i);
                }
            }
            JSONArray jSONArray = new JSONArray();
            for (String str : hashMap2.keySet()) {
                try {
                    jSONArray.put(i2, ((Integer) hashMap2.get(str)) + "_" + str);
                    i2++;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            f.a(new b(i3, jSONArray.toString()));
        }
    }

    private static String a(String str, int i, int i2) {
        return str + "_core_" + i + "_max_" + i2;
    }
}
