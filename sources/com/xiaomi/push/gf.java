package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gf {
    private static HashMap<String, ArrayList<gm>> a(Context context, List<gm> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<gm>> hashMap = new HashMap<>();
        for (gm gmVar : list) {
            a(context, gmVar);
            ArrayList<gm> arrayList = hashMap.get(gmVar.k());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(gmVar.k(), arrayList);
            }
            arrayList.add(gmVar);
        }
        return hashMap;
    }

    private static void a(Context context, gh ghVar, HashMap<String, ArrayList<gm>> hashMap) {
        for (Map.Entry<String, ArrayList<gm>> entry : hashMap.entrySet()) {
            try {
                ArrayList<gm> value = entry.getValue();
                if (value != null) {
                    if (value.size() != 0) {
                        ghVar.a(value, value.get(0).p(), entry.getKey());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, gh ghVar, List<gm> list) {
        HashMap<String, ArrayList<gm>> a = a(context, list);
        if (a == null || a.size() == 0) {
            c.a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
            return;
        }
        a(context, ghVar, a);
    }

    private static void a(Context context, gm gmVar) {
        if (gmVar.f) {
            gmVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(gmVar.m())) {
            gmVar.f(ak.a());
        }
        gmVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(gmVar.p())) {
            gmVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(gmVar.k())) {
            gmVar.e(gmVar.p());
        }
    }
}
