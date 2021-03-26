package com.tencent.msdk.dns.base.report;

import com.tencent.beacon.event.UserAction;
import java.util.Map;

/* compiled from: BeaconReporterImpl */
final class b extends a<c> {
    private static final String a = "b";

    b() {
    }

    @Override // com.tencent.msdk.dns.base.report.IReporter
    public String getName() {
        return a;
    }

    @Override // com.tencent.msdk.dns.base.report.IReporter
    public boolean canReport() {
        return true;
    }

    /* renamed from: a */
    public boolean init(c cVar) {
        try {
            UserAction.initUserAction(cVar.a);
            UserAction.setAppKey(cVar.b);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.tencent.msdk.dns.base.report.a, com.tencent.msdk.dns.base.report.IReporter
    public boolean setDebug(boolean z) {
        try {
            UserAction.setLogAble(z, z);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.tencent.msdk.dns.base.report.a
    boolean a(int i, String str, Map<String, String> map) {
        try {
            return UserAction.onUserAction(str, true, 0, -1, map, true);
        } catch (Throwable unused) {
            return false;
        }
    }
}
