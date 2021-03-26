package com.huawei.hms.stats;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

public class at implements av {
    private Context a = b.j();
    private String b;
    private String c;
    private String d;

    public at(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    private void a(String str, List<w> list) {
        Pair<String, String> a2 = bb.a(str);
        new aa(list, (String) a2.first, (String) a2.second, this.d).a();
    }

    @Override // java.lang.Runnable
    public void run() {
        af.b("EventReportTask", "eventReportTask is running");
        boolean a2 = ay.a(this.a);
        if (a2) {
            af.b("EventReportTask", "workKey is refresh,begin report all data");
            this.c = "alltype";
        }
        Map<String, List<w>> a3 = ad.a(this.a, this.b, this.c);
        if (a3.size() == 0) {
            af.a("EventReportTask", "no have events to report: tag:%s : type:%s", this.b, this.c);
            return;
        }
        for (Map.Entry<String, List<w>> entry : a3.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
        if ("alltype".equals(this.c)) {
            ap.a(this.a, "stat_v2_1", new String[0]);
            ap.a(this.a, "cached_v2_1", new String[0]);
        } else {
            String a4 = bb.a(this.b, this.c);
            ap.a(this.a, "stat_v2_1", a4);
            ap.a(this.a, "cached_v2_1", a4);
        }
        if (a2) {
            af.b("EventReportTask", "refresh local key");
            am.a().b();
            z.a().a(z.a().b());
        }
    }
}
