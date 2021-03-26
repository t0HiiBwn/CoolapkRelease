package com.ss.android.downloadlib.addownload.b;

import android.content.SharedPreferences;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: SharedPrefsManager */
public class i {

    /* compiled from: SharedPrefsManager */
    private static class a {
        private static i a = new i();
    }

    public static i a() {
        return a.a;
    }

    private i() {
    }

    /* access modifiers changed from: private */
    public SharedPreferences c() {
        return k.a().getSharedPreferences("sp_ad_download_event", 0);
    }

    ConcurrentHashMap<Long, b> b() {
        ConcurrentHashMap<Long, b> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = c().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = Long.valueOf(entry.getKey()).longValue();
                    b b = b.b(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && b != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    public void a(b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        a((Collection<b>) arrayList);
    }

    public synchronized void a(final Collection<b> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                d.a().a((Runnable) new Runnable() {
                    /* class com.ss.android.downloadlib.addownload.b.i.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = i.this.c().edit();
                        for (b bVar : collection) {
                            if (!(bVar == null || bVar.b() == 0)) {
                                edit.putString(String.valueOf(bVar.b()), bVar.ad().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    public void a(final List<String> list) {
        if (list != null && !list.isEmpty()) {
            d.a().a((Runnable) new Runnable() {
                /* class com.ss.android.downloadlib.addownload.b.i.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    SharedPreferences.Editor edit = i.this.c().edit();
                    for (String str : list) {
                        edit.remove(str);
                    }
                    edit.apply();
                }
            }, true);
        }
    }
}
