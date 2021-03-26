package com.huawei.hms.framework.network.grs.c;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static Map<String, a> a = new ConcurrentHashMap(16);

    public static class a {
        private long a;
        private long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.b <= this.a;
        }
    }

    public static a a(String str) {
        Logger.v("RequestUtil", "map size of get is before:" + a.size());
        a aVar = a.get(str);
        Logger.v("RequestUtil", "map size of get is after:" + a.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        Logger.v("RequestUtil", "map size of put is before:" + a.size());
        a.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after:" + a.size());
    }
}
