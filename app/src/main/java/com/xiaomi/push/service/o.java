package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class o {
    private static ArrayList<Pair<String, byte[]>> a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Map<String, byte[]> f1030a = new HashMap();

    public static void a(Context context, int i, String str) {
        Map<String, byte[]> map = f1030a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                a(context, str2, f1030a.get(str2), i, str);
            }
            f1030a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, x.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            Map<String, byte[]> map = f1030a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    x.a(xMPushService, str, f1030a.get(str));
                }
                f1030a.clear();
            }
        } catch (ft e) {
            b.d("fail to deal with pending register request. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = f1030a;
        synchronized (map) {
            map.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (a) {
                arrayList = a;
                a = new ArrayList<>();
            }
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<Pair<String, byte[]>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair<String, byte[]> next = it2.next();
                x.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (ft e) {
            b.d("meet error when process pending message. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (a) {
            a.add(new Pair<>(str, bArr));
            if (a.size() > 50) {
                a.remove(0);
            }
        }
    }
}
