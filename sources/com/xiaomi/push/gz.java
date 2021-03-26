package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gz {
    private static HashMap<String, ArrayList<hg>> a(Context context, List<hg> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<hg>> hashMap = new HashMap<>();
        for (hg hgVar : list) {
            a(context, hgVar);
            ArrayList<hg> arrayList = hashMap.get(hgVar.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(hgVar.c(), arrayList);
            }
            arrayList.add(hgVar);
        }
        return hashMap;
    }

    private static void a(Context context, hb hbVar, HashMap<String, ArrayList<hg>> hashMap) {
        for (Map.Entry<String, ArrayList<hg>> entry : hashMap.entrySet()) {
            try {
                ArrayList<hg> value = entry.getValue();
                if (value != null) {
                    if (value.size() != 0) {
                        hbVar.a(value, value.get(0).e(), entry.getKey());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, hb hbVar, List<hg> list) {
        HashMap<String, ArrayList<hg>> a = a(context, list);
        if (a == null || a.size() == 0) {
            b.m41a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
            return;
        }
        a(context, hbVar, a);
    }

    private static void a(Context context, hg hgVar) {
        if (hgVar.f551a) {
            hgVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(hgVar.d())) {
            hgVar.f(bl.a());
        }
        hgVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(hgVar.e())) {
            hgVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(hgVar.c())) {
            hgVar.e(hgVar.e());
        }
    }
}
