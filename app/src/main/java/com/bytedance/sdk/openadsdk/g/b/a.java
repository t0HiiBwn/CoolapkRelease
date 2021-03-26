package com.bytedance.sdk.openadsdk.g.b;

import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.a.b;
import com.bytedance.sdk.openadsdk.j.c;
import com.bytedance.sdk.openadsdk.utils.u;

/* compiled from: ReportThreadLogServiceImp */
public class a implements c {
    @Override // com.bytedance.sdk.openadsdk.j.c
    public void a(com.bytedance.sdk.openadsdk.j.a.c cVar) {
        if (cVar != null && cVar.a() != null) {
            com.bytedance.sdk.openadsdk.g.a.c b = com.bytedance.sdk.openadsdk.g.a.c.b().a("tt_pangle_thread_pool").b(cVar.a().toString());
            p.i().a(b, false);
            u.c("ReportThreadLogServiceI", "execReportThreadPoolLog: " + b.a());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.c
    public void a(b bVar) {
        if (bVar != null && bVar.a() != null) {
            com.bytedance.sdk.openadsdk.g.a.c b = com.bytedance.sdk.openadsdk.g.a.c.b().a("tt_pangle_sdk_thread_state").b(bVar.a().toString());
            p.i().a(b, false);
            u.c("ReportThreadLogServiceI", "execReportSdkThreadLog: " + b.a());
        }
    }
}
