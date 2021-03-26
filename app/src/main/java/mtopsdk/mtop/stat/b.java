package mtopsdk.mtop.stat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: PrefetchStatistics */
public final class b {
    private static volatile AtomicBoolean b = new AtomicBoolean(false);
    private IUploadStats a;
    private String c = "";

    public b(IUploadStats iUploadStats) {
        this.a = iUploadStats;
    }

    public final void a(String str, HashMap<String, String> hashMap) {
        int i;
        if (hashMap != null) {
            String str2 = hashMap.get("data_seq");
            this.c = str2;
            if (this.a == null) {
                TBSdkLog.e("mtopsdk.PrefetchStatistics", str2, "[doPrefetchCommit]register MtopStats error, uploadStats=null");
                return;
            }
            if ("TYPE_HIT".equals(str)) {
                i = 1;
            } else if ("TYPE_MISS".equals(str)) {
                i = 2;
            } else if ("TYPE_EXPIRE".equals(str)) {
                i = 3;
            } else {
                i = "TYPE_CLEAR".equals(str) ? 4 : 0;
            }
            if (b.compareAndSet(false, true)) {
                try {
                    if (this.a == null) {
                        TBSdkLog.e("mtopsdk.PrefetchStatistics", this.c, "[registerPrefetchStats]register MtopStats error, uploadStats=null");
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add("api");
                        hashSet.add("version");
                        hashSet.add("key");
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add("time");
                        hashSet2.add("type");
                        IUploadStats iUploadStats = this.a;
                        if (iUploadStats != null) {
                            iUploadStats.onRegister("mtopsdk", "mtopPrefetch", hashSet, hashSet2, false);
                        }
                    }
                } catch (Throwable th) {
                    String str3 = this.c;
                    TBSdkLog.e("mtopsdk.PrefetchStatistics", str3, "[registerPrefetchStats] register MtopStats error ---" + th.toString());
                }
            }
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("api", hashMap.get("data_api"));
                hashMap2.put("version", hashMap.get("data_version"));
                hashMap2.put("key", hashMap.get("data_key"));
                HashMap hashMap3 = new HashMap();
                hashMap3.put("time", Double.valueOf(Double.parseDouble(hashMap.get("data_cost_time"))));
                hashMap3.put("type", Double.valueOf((double) i));
                this.a.onCommit("mtopsdk", "mtopPrefetch", hashMap2, hashMap3);
            } catch (Throwable th2) {
                String str4 = this.c;
                TBSdkLog.e("mtopsdk.PrefetchStatistics", str4, "[doPrefetchCommit] commit mtopStats error ---" + th2.toString());
            }
        }
    }
}
