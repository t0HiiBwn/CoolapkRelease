package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;

class b implements Runnable {
    final /* synthetic */ EventClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f119a;

    b(a aVar, EventClientReport eventClientReport) {
        this.f119a = aVar;
        this.a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.a(this.f119a, this.a);
    }
}
