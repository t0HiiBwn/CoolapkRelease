package com.huawei.hms.stats;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class au implements av {
    private String a;
    private String b;
    private String c;
    private List<w> d;

    public au(List<w> list, String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    private void a() {
        ap.a(b.j(), "backup_event", bb.a(this.a, this.c, this.b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<w> list = this.d;
        if (list == null || list.size() == 0) {
            af.b("FailedEventHandlerTask", "failed events is empty");
            return;
        }
        if (ay.a(b.j(), "cached_v2_1", b.i() * 1048576)) {
            af.c("FailedEventHandlerTask", "The cacheFile is full,Can not writing data! reqID:" + this.b);
            return;
        }
        String a2 = bb.a(this.a, this.c);
        List<w> list2 = ad.b(b.j(), "cached_v2_1", a2).get(a2);
        if (!(list2 == null || list2.size() == 0)) {
            this.d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (w wVar : this.d) {
            try {
                jSONArray.put(wVar.d());
            } catch (JSONException unused) {
                af.c("FailedEventHandlerTask", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > b.h() * 1048576) {
            af.c("FailedEventHandlerTask", "this failed data is too long,can not writing it");
            this.d = null;
            return;
        }
        af.b("FailedEventHandlerTask", "data send failed, write to cache file...reqID:" + this.b);
        ap.a(b.j(), "cached_v2_1", a2, jSONArray2);
        a();
    }
}
