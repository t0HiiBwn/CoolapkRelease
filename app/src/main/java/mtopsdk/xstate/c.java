package mtopsdk.xstate;

import android.content.Context;
import android.content.IntentFilter;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.a.a;

/* compiled from: XStateDelegate */
public final class c {
    private static ConcurrentHashMap<String, String> a;
    private static a b;
    private static Context c;
    private static volatile boolean d;

    public static void a(Context context) {
        if (!d) {
            try {
                if (d) {
                    return;
                }
                if (context == null) {
                    TBSdkLog.e("mtopsdk.XStateDelegate", "[checkInit]parameter context for init(Context context) is null.");
                    return;
                }
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                c = context;
                if (b == null) {
                    b = new a();
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        context.registerReceiver(b, intentFilter);
                    } catch (Throwable th) {
                        TBSdkLog.e("mtopsdk.XStateDelegate", "[registerReceive]registerReceive failed", th);
                    }
                }
                d = true;
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.XStateDelegate", "[checkInit] init XState OK,isInit=" + d);
                }
            } catch (Throwable th2) {
                TBSdkLog.e("mtopsdk.XStateDelegate", "[checkInit] checkInit error --" + th2.toString());
            }
        }
    }

    public static void a() {
        if (d) {
            try {
                if (d) {
                    ConcurrentHashMap<String, String> concurrentHashMap = a;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.clear();
                        a = null;
                    }
                    Context context = c;
                    if (context == null) {
                        TBSdkLog.e("mtopsdk.XStateDelegate", "[unInit] context in Class XState is null.");
                        return;
                    }
                    try {
                        a aVar = b;
                        if (aVar != null) {
                            context.unregisterReceiver(aVar);
                            b = null;
                        }
                    } catch (Throwable th) {
                        TBSdkLog.e("mtopsdk.XStateDelegate", "[unRegisterReceive]unRegisterReceive failed", th);
                    }
                    d = false;
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i("mtopsdk.XStateDelegate", "[unInit] unInit XState OK,isInit=" + d);
                    }
                }
            } catch (Exception e) {
                TBSdkLog.e("mtopsdk.XStateDelegate", "[unInit] unInit error --" + e.toString());
            }
        }
    }

    public static String a(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = a;
        if (concurrentHashMap == null || str == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap = a;
        if (concurrentHashMap != null && str != null && str2 != null) {
            concurrentHashMap.put(str, str2);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("mtopsdk.XStateDelegate", "[setValue]set  XStateID succeed," + str + "=" + str2);
            }
        } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.XStateDelegate", "[setValue]set  XStateID failed,key=" + str + ",value=" + str2);
        }
    }

    public static String b(String str) {
        if (a == null || str == null) {
            return null;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.XStateDelegate", "remove XState key=" + str);
        }
        return a.remove(str);
    }
}
