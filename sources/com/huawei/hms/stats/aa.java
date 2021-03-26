package com.huawei.hms.stats;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class aa {
    private List<w> a;
    private String b;
    private String c;
    private String d;

    public aa(List<w> list, String str, String str2, String str3) {
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    private void a(List<w> list, String str, String str2) {
        if (!list.isEmpty()) {
            int size = (list.size() / 500) + 1;
            for (int i = 0; i < size; i++) {
                int i2 = i * 500;
                List<w> subList = list.subList(i2, Math.min(list.size(), i2 + 500));
                String replace = UUID.randomUUID().toString().replace("-", "");
                long currentTimeMillis = System.currentTimeMillis();
                long g = ((long) c.g(str2, str)) * 86400000;
                ArrayList arrayList = new ArrayList();
                for (w wVar : subList) {
                    if (!ay.a(wVar.b(), currentTimeMillis, g)) {
                        arrayList.add(wVar);
                    }
                }
                if (arrayList.size() > 0) {
                    new ab(str2, str, this.d, arrayList, replace).a();
                } else {
                    af.c("DataOrganizeHandler", "No data to report handler");
                }
            }
        }
    }

    public void a() {
        if ("_default_config_tag".equals(this.c)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (w wVar : this.a) {
                String a2 = wVar.a();
                if (TextUtils.isEmpty(a2) || "oper".equals(a2)) {
                    arrayList4.add(wVar);
                } else if ("maint".equals(a2)) {
                    arrayList.add(wVar);
                } else if ("preins".equals(a2)) {
                    arrayList2.add(wVar);
                } else if ("diffprivacy".equals(a2)) {
                    arrayList3.add(wVar);
                }
            }
            a(arrayList4, "oper", "_default_config_tag");
            a(arrayList, "maint", "_default_config_tag");
            a(arrayList2, "preins", "_default_config_tag");
            a(arrayList3, "diffprivacy", "_default_config_tag");
            return;
        }
        a(this.a, this.c, this.b);
    }
}
