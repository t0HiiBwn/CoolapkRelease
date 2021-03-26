package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.b.c.a;
import com.xiaomi.b.c.b;
import com.xiaomi.b.c.e;

public class ak implements Runnable {
    private e a;
    private Context b;

    public void a(Context context) {
        this.b = context;
    }

    public void a(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ao a2;
        String str;
        long currentTimeMillis;
        try {
            e eVar = this.a;
            if (eVar != null) {
                eVar.a();
            }
            c.c("begin read and send perf / event");
            e eVar2 = this.a;
            if (eVar2 instanceof a) {
                a2 = ao.a(this.b);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (eVar2 instanceof b) {
                a2 = ao.a(this.b);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else {
                return;
            }
            a2.a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e) {
            c.a(e);
        }
    }
}
