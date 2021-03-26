package mtopsdk.mtop.intf;

import com.taobao.tao.remotebusiness.b.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.stat.b;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: MtopPrefetch */
public class f {
    private long a = 5000;
    private volatile long b = 0;
    private long c = 0;
    private mtopsdk.mtop.common.a d;
    private a e;
    private b f;

    public f(b bVar) {
        new AtomicBoolean(false);
        new ReentrantLock();
        new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.f = bVar;
        System.currentTimeMillis();
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(mtopsdk.mtop.common.a aVar) {
        this.d = aVar;
    }

    public final a a() {
        return this.e;
    }

    public final void a(a aVar) {
        this.e = aVar;
    }

    public static void a(Mtop mtop) {
        if (mtop != null && !mtop.getPrefetchBuilderMap().isEmpty() && 15000 < System.currentTimeMillis() - mtop.lastPrefetchResponseTime) {
            synchronized (f.class) {
                try {
                    if (!mtop.getPrefetchBuilderMap().isEmpty()) {
                        Iterator<String> it2 = mtop.getPrefetchBuilderMap().keySet().iterator();
                        while (it2.hasNext()) {
                            MtopBuilder mtopBuilder = mtop.getPrefetchBuilderMap().get(it2.next());
                            if (mtopBuilder != null && System.currentTimeMillis() - mtopBuilder.getMtopPrefetch().b > mtopBuilder.getMtopPrefetch().a) {
                                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                                    TBSdkLog.d("mtopsdk.MtopPrefetch", "clean prefetch cache " + mtopBuilder.request.getKey());
                                }
                                a("TYPE_CLEAR", mtopBuilder.getMtopPrefetch(), mtopBuilder.c, null);
                                it2.remove();
                            }
                        }
                    }
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.MtopPrefetch", "clean cache builder error ", th.toString());
                }
            }
        }
    }

    /* compiled from: MtopPrefetch */
    public interface a {
        default a() {
        }
    }

    public static void a(String str, f fVar, e eVar, HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2;
        if (fVar != null) {
            if (fVar == null || eVar == null) {
                hashMap2 = null;
            } else {
                try {
                    hashMap2 = new HashMap<>();
                    hashMap2.put("data_seq", eVar.h);
                    hashMap2.put("data_key", eVar.b.getKey());
                    hashMap2.put("data_api", eVar.b.getApiName());
                    hashMap2.put("data_version", eVar.b.getVersion());
                    hashMap2.put("data_cost_time", String.valueOf(-1L));
                    if ("TYPE_MISS".equals(str)) {
                        hashMap2.put("data_req_param", eVar.b.getData());
                    }
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.MtopPrefetch", "onPrefetch Error" + th.toString());
                    return;
                }
            }
            MtopSDKThreadPoolExecutorFactory.submit(new g(fVar, str, hashMap2));
            b bVar = fVar.f;
            if (bVar != null) {
                bVar.a(str, hashMap2);
            }
        }
    }
}
