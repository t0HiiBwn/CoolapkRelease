package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.d;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.core.strategy.a;
import com.tencent.beacon.upload.TunnelInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TunnelModule extends c {
    private static volatile TunnelModule INSTANCE;
    private static List<com.tencent.beacon.event.a<Map<String, String>>> cacheAdditionInfo = Collections.synchronizedList(new ArrayList(5));
    private static List<c> cacheEvents = Collections.synchronizedList(new ArrayList(5));
    private static List<TunnelInfo> cacheTunnel = Collections.synchronizedList(new ArrayList(5));
    private static List<com.tencent.beacon.event.a<String>> cacheUserId = Collections.synchronizedList(new ArrayList(5));
    public static b netConsumeUtil;
    private e appDefaultEventTunnel;
    private Context context;
    public boolean isEnable;
    private Map<String, e> tunnelMap = new HashMap();

    private interface a {
        void a(e eVar);
    }

    public interface b {
        long a();
    }

    public TunnelModule(Context context2) {
        super(context2);
        this.context = context2;
        this.appDefaultEventTunnel = new e(context2, com.tencent.beacon.core.b.b.a(context2).a());
        dealCacheTunnel();
        dealCacheAdditionalInfo();
        dealCacheUserId();
    }

    private void dealCacheTunnel() {
        for (TunnelInfo tunnelInfo : cacheTunnel) {
            this.tunnelMap.put(tunnelInfo.appKey, createTunnel(this.context, tunnelInfo));
        }
        cacheTunnel.clear();
    }

    private void dealCacheAdditionalInfo() {
        for (com.tencent.beacon.event.a<Map<String, String>> aVar : cacheAdditionInfo) {
            setAdditionalInfoInstance(aVar.a, aVar.b);
        }
        cacheAdditionInfo.clear();
    }

    private void dealCacheUserId() {
        for (com.tencent.beacon.event.a<String> aVar : cacheUserId) {
            setUserIdInstance(aVar.a, aVar.b);
        }
        cacheUserId.clear();
    }

    public static TunnelModule getInstance() {
        return INSTANCE;
    }

    public static TunnelModule getInstance(Context context2) {
        if (INSTANCE == null) {
            synchronized (TunnelModule.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TunnelModule(context2);
                }
            }
        }
        return INSTANCE;
    }

    @Override // com.tencent.beacon.core.c
    public void onStrategyQueryFinished() {
        super.onStrategyQueryFinished();
        allTunnel(new a() {
            /* class com.tencent.beacon.core.event.TunnelModule.AnonymousClass1 */

            @Override // com.tencent.beacon.core.event.TunnelModule.a
            public final void a(e eVar) {
                eVar.d();
            }
        });
        dealCacheEvent();
    }

    public synchronized void dealCacheEvent() {
        List<c> list = cacheEvents;
        if (list != null && list.size() > 0) {
            for (c cVar : cacheEvents) {
                onUserAction(cVar.g, cVar.a, cVar.b, cVar.c, cVar.d, cVar.e, cVar.f);
            }
            cacheEvents.clear();
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onStrategyUpdated(com.tencent.beacon.core.strategy.a aVar) {
        a.C0141a b2;
        super.onStrategyUpdated(aVar);
        if (aVar != null && (b2 = aVar.b(1)) != null) {
            boolean a2 = b2.a();
            com.tencent.beacon.core.d.b.f("[strategy] setEnable: %b", Boolean.valueOf(a2));
            setEnable(a2);
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStrategyUpdated(int i, Map<String, String> map) {
        super.onModuleStrategyUpdated(i, map);
        if (i == 1 && map != null && map.size() > 0 && d.a() != null) {
            d.a().a(map);
        }
    }

    public static boolean isModuleAble() {
        d a2;
        b bVar;
        TunnelModule instance = getInstance();
        if (instance == null) {
            com.tencent.beacon.core.d.b.d("[module] this module not ready!", new Object[0]);
            return false;
        }
        boolean z = instance.isEnable;
        if (z) {
            z = StrategyQueryModule.getInstance(instance.context).isAtLeastAComQueryEnd();
        }
        if (!z || (a2 = d.a()) == null || (bVar = netConsumeUtil) == null || bVar.a() < ((long) a2.k())) {
            return z;
        }
        com.tencent.beacon.core.d.b.c("[strategy] reach daily consume limited! %d ", Integer.valueOf(a2.k()));
        return false;
    }

    public static void setNetConsumeProtocol(b bVar) {
        netConsumeUtil = bVar;
    }

    public void setAppKey(String str) {
        e eVar = this.appDefaultEventTunnel;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    public synchronized void setEnable(final boolean z) {
        this.isEnable = z;
        allTunnel(new a() {
            /* class com.tencent.beacon.core.event.TunnelModule.AnonymousClass2 */

            @Override // com.tencent.beacon.core.event.TunnelModule.a
            public final void a(e eVar) {
                if (z != eVar.a) {
                    eVar.a(z);
                }
            }
        });
    }

    public void setModuleUserEnable(boolean z) {
        a.C0141a b2;
        StrategyQueryModule instance = StrategyQueryModule.getInstance(this.mContext);
        if (instance != null && (b2 = instance.getStrategy().b(1)) != null && b2.a() != z) {
            b2.a(z);
            setEnable(z);
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onSDKInit(Context context2) {
        super.onSDKInit(context2);
        setModuleUserEnable(true);
        new d().a(context2);
    }

    public static void doUploadRecentCommonData(final boolean z) {
        TunnelModule instance = getInstance();
        if (instance != null && isModuleAble()) {
            instance.allTunnel(new a() {
                /* class com.tencent.beacon.core.event.TunnelModule.AnonymousClass3 */

                @Override // com.tencent.beacon.core.event.TunnelModule.a
                public final void a(e eVar) {
                    eVar.b(z);
                }
            });
        }
    }

    public static void doUploadAllEventsData() {
        TunnelModule instance = getInstance();
        if (instance != null && isModuleAble()) {
            instance.allTunnel(new a() {
                /* class com.tencent.beacon.core.event.TunnelModule.AnonymousClass4 */

                @Override // com.tencent.beacon.core.event.TunnelModule.a
                public final void a(e eVar) {
                    eVar.c();
                }
            });
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onAppFirstRun() {
        Context context2 = this.mContext;
        String f = this.appDefaultEventTunnel.f();
        com.tencent.beacon.core.d.b.b("[db] start", new Object[0]);
        com.tencent.beacon.core.d.b.e("[event] ua first clean :%d", Integer.valueOf(com.tencent.beacon.core.a.a.b.a(context2, f, new int[]{1, 2, 3, 4})));
        com.tencent.beacon.core.d.b.e("[event] ua remove strategy :%d", Integer.valueOf(com.tencent.beacon.core.strategy.b.b(this.mContext)));
    }

    public static void flushObjectsToDB(final boolean z) {
        TunnelModule instance = getInstance();
        if (instance != null) {
            instance.allTunnel(new a() {
                /* class com.tencent.beacon.core.event.TunnelModule.AnonymousClass5 */

                @Override // com.tencent.beacon.core.event.TunnelModule.a
                public final void a(e eVar) {
                    h a2 = eVar.a();
                    if (a2 != null) {
                        a2.b(z);
                    }
                    h b = eVar.b();
                    if (b != null) {
                        b.b(z);
                    }
                }
            });
        }
    }

    public void setUploadMode(boolean z) {
        if (i.a(this.mContext) != null && z != i.a(this.mContext).b()) {
            if (z) {
                i.a(this.mContext).b(true);
            } else {
                i.a(this.mContext).b(false);
            }
        }
    }

    public static boolean onUserAction(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        return onUserAction(str, str2, z, j, j2, map, z2, false);
    }

    public static boolean onUserAction(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        StrategyQueryModule instance = StrategyQueryModule.getInstance();
        if (instance == null || !instance.isAtLeastAComQueryEnd()) {
            com.tencent.beacon.core.d.b.a("[event] [%s] add to cache events list.", str2);
            List<c> list = cacheEvents;
            if (list != null) {
                list.add(new c(str, str2, z, j, j2, map, z2));
            }
            return true;
        } else if (!isModuleAble()) {
            com.tencent.beacon.core.d.b.d("[event] UserEventModule is disable (false).", new Object[0]);
            return false;
        } else {
            TunnelModule instance2 = getInstance();
            if (instance2 != null) {
                e tunnelByAppKey = instance2.getTunnelByAppKey(str);
                if (tunnelByAppKey != null) {
                    return tunnelByAppKey.a(str2, z, j, j2, map, z2, z3);
                }
                com.tencent.beacon.core.d.b.d("onUserAction failed, tunnel of %s not found", str);
            }
            return false;
        }
    }

    private e getTunnelByAppKey(String str) {
        if (g.a(str) || str.equals(this.appDefaultEventTunnel.f())) {
            return this.appDefaultEventTunnel;
        }
        return this.tunnelMap.get(str);
    }

    public void updateSchedule() {
        allTunnel(new a() {
            /* class com.tencent.beacon.core.event.TunnelModule.AnonymousClass6 */

            @Override // com.tencent.beacon.core.event.TunnelModule.a
            public final void a(e eVar) {
                eVar.e();
            }
        });
    }

    public static void registerTunnel(TunnelInfo tunnelInfo) {
        if (g.a(tunnelInfo.appKey)) {
            com.tencent.beacon.core.d.b.d("[event] registerTunnel failed. appKey is empty", new Object[0]);
            return;
        }
        TunnelModule instance = getInstance();
        if (instance == null) {
            cacheTunnel.add(tunnelInfo);
        } else {
            instance.addTunnel(tunnelInfo);
        }
    }

    private synchronized void addTunnel(TunnelInfo tunnelInfo) {
        if (tunnelInfo.appKey.equals(this.appDefaultEventTunnel.f())) {
            com.tencent.beacon.core.d.b.d("[event] can not register app default appkey: %s", tunnelInfo.appKey);
        } else if (this.tunnelMap.get(tunnelInfo.appKey) != null) {
            com.tencent.beacon.core.d.b.d("[event] registerTunnel failed. EventTunnel already exists :%s", tunnelInfo.appKey);
        } else {
            this.tunnelMap.put(tunnelInfo.appKey, createTunnel(this.context, tunnelInfo));
        }
    }

    private e createTunnel(Context context2, TunnelInfo tunnelInfo) {
        tunnelInfo.channel = com.tencent.beacon.core.d.a.a(tunnelInfo.channel);
        e eVar = new e(context2, tunnelInfo.appKey);
        eVar.a(true);
        com.tencent.beacon.core.b.b.a(context2).a(tunnelInfo.appKey, tunnelInfo);
        return eVar;
    }

    private void allTunnel(a aVar) {
        if (aVar != null) {
            e eVar = this.appDefaultEventTunnel;
            if (eVar != null) {
                aVar.a(eVar);
            }
            for (e eVar2 : this.tunnelMap.values()) {
                aVar.a(eVar2);
            }
        }
    }

    public static Map<String, String> getAdditionalInfo(String str) {
        TunnelModule instance = getInstance();
        if (instance == null) {
            com.tencent.beacon.core.d.b.d("getAdditionalInfo failed, sdk is not ready", new Object[0]);
            return null;
        }
        e tunnelByAppKey = instance.getTunnelByAppKey(str);
        if (tunnelByAppKey != null) {
            return tunnelByAppKey.g();
        }
        com.tencent.beacon.core.d.b.d("getAdditionalInfo failed, tunnel of %s not found", str);
        return null;
    }

    public static String getUserId(String str) {
        TunnelModule instance = getInstance();
        if (instance == null) {
            com.tencent.beacon.core.d.b.d("getUserId failed, sdk is not ready", new Object[0]);
            return null;
        }
        e tunnelByAppKey = instance.getTunnelByAppKey(str);
        if (tunnelByAppKey != null) {
            return tunnelByAppKey.h();
        }
        com.tencent.beacon.core.d.b.d("getUserId failed, tunnel of %s not found", str);
        return null;
    }

    public static void setAdditionalInfo(String str, Map<String, String> map) {
        TunnelModule instance = getInstance();
        if (instance == null) {
            cacheAdditionInfo.add(new com.tencent.beacon.event.a<>(str, map));
        } else {
            instance.setAdditionalInfoInstance(str, map);
        }
    }

    private void setAdditionalInfoInstance(String str, Map<String, String> map) {
        e tunnelByAppKey = getTunnelByAppKey(str);
        if (tunnelByAppKey == null) {
            com.tencent.beacon.core.d.b.d("setAdditionalInfo failed, tunnel of %s not found", str);
        } else {
            tunnelByAppKey.a(map);
        }
    }

    public static void setUserId(String str, String str2) {
        TunnelModule instance = getInstance();
        if (instance == null) {
            cacheUserId.add(new com.tencent.beacon.event.a<>(str, str2));
            return;
        }
        String str3 = "10000";
        if (g.a(str2)) {
            str2 = str3;
        }
        String trim = str2.replace('|', '_').trim();
        if (com.tencent.beacon.core.d.a.b(trim)) {
            if (trim.length() < 5) {
                com.tencent.beacon.core.d.b.c("[core] userID length should < 5!", new Object[0]);
            }
            str3 = trim.length() > 128 ? trim.substring(0, 128) : trim;
        } else {
            com.tencent.beacon.core.d.b.c("[core] userID should be ASCII code in 32-126! userID:" + str2, new Object[0]);
        }
        instance.setUserIdInstance(str, str3);
    }

    private void setUserIdInstance(String str, String str2) {
        e tunnelByAppKey = getTunnelByAppKey(str);
        if (tunnelByAppKey == null) {
            com.tencent.beacon.core.d.b.d("setUserId failed, tunnel of %s not found", str);
        } else {
            tunnelByAppKey.b(str2);
        }
    }
}
