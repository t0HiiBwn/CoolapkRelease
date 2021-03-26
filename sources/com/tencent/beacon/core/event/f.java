package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FragmentTime */
public final class f {
    private static Map<String, Long> a;

    public static void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a == null) {
            a = new HashMap();
        }
        a.put(str, Long.valueOf(currentTimeMillis));
        b.b("[page] onPageIn cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void b(final String str) {
        final long currentTimeMillis = System.currentTimeMillis();
        Map<String, Long> map = a;
        if (map == null) {
            b.c("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        Long l2 = map.get(str);
        if (l2 == null) {
            b.c("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        final long longValue = currentTimeMillis - l2.longValue();
        com.tencent.beacon.core.a.b.a().a(new Runnable() {
            /* class com.tencent.beacon.core.event.f.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("A110", String.valueOf(currentTimeMillis));
                hashMap.put("A111", str);
                hashMap.put("A112", String.valueOf(longValue));
                UserAction.onUserAction("rqd_page_fgt", true, 0, 0, hashMap, false);
                if (longValue >= 30000) {
                    b.b("[page] force flush page_fgt events in db.", new Object[0]);
                    UserAction.flushObjectsToDB(true);
                }
            }
        });
        a.remove(str);
        b.b("[page] onPageOut cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
