package mtopsdk.mtop.a.b.a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: OpenNetworkConverter */
public final class c extends a {
    private static final Map<String, String> a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        a = concurrentHashMap;
        concurrentHashMap.put("x-sid", "sid");
        concurrentHashMap.put("x-t", "t");
        concurrentHashMap.put("x-appkey", "appKey");
        concurrentHashMap.put("x-ttid", "ttid");
        concurrentHashMap.put("x-utdid", "utdid");
        concurrentHashMap.put("x-sign", "sign");
        concurrentHashMap.put("x-pv", "pv");
        concurrentHashMap.put("x-uid", "uid");
        concurrentHashMap.put("x-features", "x-features");
        concurrentHashMap.put("x-open-biz", "open-biz");
        concurrentHashMap.put("x-mini-appkey", "mini-appkey");
        concurrentHashMap.put("x-req-appkey", "req-appkey");
        concurrentHashMap.put("x-open-biz-data", "open-biz-data");
        concurrentHashMap.put("x-act", "accessToken");
        concurrentHashMap.put("x-app-ver", "x-app-ver");
        concurrentHashMap.put("user-agent", "user-agent");
        concurrentHashMap.put("x-sgext", "x-sgext");
        concurrentHashMap.put("x-umt", "umt");
        concurrentHashMap.put("x-mini-wua", "x-mini-wua");
    }

    @Override // mtopsdk.mtop.a.b.a.a
    protected final Map<String, String> a() {
        return a;
    }
}
