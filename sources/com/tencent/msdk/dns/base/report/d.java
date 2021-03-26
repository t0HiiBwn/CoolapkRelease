package com.tencent.msdk.dns.base.report;

import com.tencent.gcloud.httpdns.report.GCloudCoreReporter;
import com.tencent.msdk.dns.base.report.IReporter;
import java.util.Map;

/* compiled from: GCCReporterImpl */
final class d extends a<IReporter.a> {
    private static final String a = "d";

    d() {
    }

    @Override // com.tencent.msdk.dns.base.report.IReporter
    public String getName() {
        return a;
    }

    @Override // com.tencent.msdk.dns.base.report.IReporter
    public boolean canReport() {
        return true;
    }

    @Override // com.tencent.msdk.dns.base.report.a
    boolean a(int i, String str, Map<String, String> map) {
        try {
            return GCloudCoreReporter.reportEvent(i, str, map);
        } catch (Throwable unused) {
            return false;
        }
    }
}
