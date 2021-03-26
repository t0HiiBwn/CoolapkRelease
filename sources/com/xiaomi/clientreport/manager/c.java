package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;

class c implements Runnable {
    final /* synthetic */ PerfClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f120a;

    c(a aVar, PerfClientReport perfClientReport) {
        this.f120a = aVar;
        this.a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.a(this.f120a, this.a);
    }
}
