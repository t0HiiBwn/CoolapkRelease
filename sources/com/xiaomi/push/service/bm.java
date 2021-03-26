package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bm {
    private static final Map<String, byte[]> a = new HashMap();
    private static ArrayList<Pair<String, byte[]>> b = new ArrayList<>();

    public static void a(Context context, int i, String str) {
        Map<String, byte[]> map = a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                a(context, str2, a.get(str2), i, str);
            }
            a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, bu.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            Map<String, byte[]> map = a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    bu.a(xMPushService, str, a.get(str));
                }
                a.clear();
            }
        } catch (ey e) {
            c.a(e);
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = a;
        synchronized (map) {
            map.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (b) {
                arrayList = b;
                b = new ArrayList<>();
            }
            Iterator<Pair<String, byte[]>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair<String, byte[]> next = it2.next();
                bu.a(xMPushService, (String) next.first, (byte[]) next.second);
            }
        } catch (ey e) {
            c.a(e);
            xMPushService.a(10, e);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (b) {
            b.add(new Pair<>(str, bArr));
            if (b.size() > 50) {
                b.remove(0);
            }
        }
    }
}
