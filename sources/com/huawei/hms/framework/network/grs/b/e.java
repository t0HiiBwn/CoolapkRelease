package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.framework.network.grs.b.b.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    public static void a(final ArrayList<d> arrayList, final long j, final JSONArray jSONArray, final Context context) {
        if (context != null && arrayList != null && arrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new Runnable() {
                /* class com.huawei.hms.framework.network.grs.b.e.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    a aVar = new a();
                    aVar.put("total_time", j);
                    aVar.put("network_type", (long) NetworkUtil.getNetworkType(context));
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        d dVar = (d) it2.next();
                        if (dVar.h()) {
                            aVar.put(e.b(dVar));
                            it2.remove();
                            z = true;
                            break;
                        }
                    }
                    if (!z && arrayList.size() > 0) {
                        ArrayList arrayList = arrayList;
                        d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                        aVar.put(e.b(dVar2));
                        arrayList.remove(dVar2);
                    }
                    if (arrayList.size() > 0) {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            jSONArray.put(new JSONObject(e.b((d) it3.next())));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        aVar.put("failed_info", jSONArray.toString());
                    }
                    Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
                    HianalyticsHelper.getInstance().onEvent(aVar.get(), "networkkit_grs");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception j = dVar.j();
        if (j != null) {
            linkedHashMapPack.put("error_code", (long) ExceptionCode.getErrorCodeFromException(j));
            linkedHashMapPack.put("exception_name", j.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(j.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", (long) dVar.l());
            linkedHashMapPack.put("exception_name", (long) dVar.g());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.k()).getHost());
        } catch (MalformedURLException e) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e);
        }
        linkedHashMapPack.put("req_start_time", dVar.a());
        linkedHashMapPack.put("req_end_time", dVar.b());
        linkedHashMapPack.put("req_total_time", dVar.m());
        return linkedHashMapPack.getAll();
    }
}
