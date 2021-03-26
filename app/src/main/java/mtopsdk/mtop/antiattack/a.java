package mtopsdk.mtop.antiattack;

import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SwitchConfig;

/* compiled from: ApiLockHelper */
public final class a {
    private static ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();

    public static boolean a(String str, long j) {
        boolean z = false;
        if (StringUtils.isBlank(str)) {
            return false;
        }
        b bVar = a.get(str);
        if (bVar != null) {
            if (Math.abs(j - bVar.a) < bVar.b) {
                z = true;
            } else {
                a.remove(str);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.w("mtopsdk.ApiLockHelper", "[iSApiLocked]remove apiKey=" + str);
                }
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                StringBuilder sb = new StringBuilder("[iSApiLocked] isLocked=");
                sb.append(z);
                sb.append(", ");
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append(", currentTime=");
                sb2.append(j);
                sb2.append(", lockEntity=");
                sb2.append(bVar.toString());
                sb.append((Object) sb2);
                TBSdkLog.w("mtopsdk.ApiLockHelper", sb.toString());
            }
        }
        return z;
    }

    public static void a(String str, long j, long j2) {
        if (!StringUtils.isBlank(str)) {
            b bVar = a.get(str);
            long individualApiLockInterval = j2 > 0 ? j2 / 1000 : SwitchConfig.getInstance().getIndividualApiLockInterval(str);
            if (individualApiLockInterval <= 0) {
                individualApiLockInterval = SwitchConfig.getInstance().getGlobalApiLockInterval();
                if (individualApiLockInterval <= 0) {
                    individualApiLockInterval = 10;
                }
            }
            if (bVar == null) {
                bVar = new b(str, j, individualApiLockInterval);
            } else {
                bVar.a = j;
                bVar.b = individualApiLockInterval;
            }
            a.put(str, bVar);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                StringBuilder sb = new StringBuilder("[lock]");
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append(", currentTime=");
                sb2.append(j);
                sb2.append(", lockEntity=");
                sb2.append(bVar.toString());
                sb.append((Object) sb2);
                TBSdkLog.w("mtopsdk.ApiLockHelper", sb.toString());
            }
        }
    }
}
