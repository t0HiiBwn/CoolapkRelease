package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.push.bm;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class b implements IPerfProcessor {
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, a>> f124a;

    public b(Context context) {
        this.a = context;
    }

    public static String a(a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }

    private String b(a aVar) {
        String str;
        int i = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i) + "#" + str2;
        }
        File externalFilesDir = this.a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            com.xiaomi.channel.commonutils.logger.b.d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    private String c(a aVar) {
        String b = b(aVar);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = b + i;
            if (bm.m144a(this.a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bm.a(this.a, "perf", "perfUploading");
        File[] a2 = bm.m145a(this.a, "perfUploading");
        if (a2 != null && a2.length > 0) {
            for (File file : a2) {
                if (file != null) {
                    List<String> a3 = e.a(this.a, file.getAbsolutePath());
                    file.delete();
                    a(a3);
                }
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo46a(a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f124a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a2 = a((a) perfClientReport);
            String a3 = e.a(perfClientReport);
            HashMap<String, a> hashMap = this.f124a.get(a2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a3);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a3, perfClientReport);
            this.f124a.put(a2, hashMap);
        }
    }

    public void a(List<String> list) {
        bm.a(this.a, list);
    }

    public void a(a[] aVarArr) {
        String c = c(aVarArr[0]);
        if (!TextUtils.isEmpty(c)) {
            e.a(c, aVarArr);
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, a>> hashMap = this.f124a;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.f124a.keySet()) {
                    HashMap<String, a> hashMap2 = this.f124a.get(str);
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        a[] aVarArr = new a[hashMap2.size()];
                        hashMap2.values().toArray(aVarArr);
                        a(aVarArr);
                    }
                }
            }
            this.f124a.clear();
        }
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, a>> hashMap) {
        this.f124a = hashMap;
    }
}
