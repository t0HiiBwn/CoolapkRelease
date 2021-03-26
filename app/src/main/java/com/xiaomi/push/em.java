package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.bl;
import com.xiaomi.push.service.bm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class em {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, hm> f400a;

    public interface a {
        void uploader(Context context, hg hgVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof hc) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof hm) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ew) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = an.a(context).a(hh.PerfUploadSwitch.a(), false);
        boolean a3 = an.a(context).a(hh.EventUploadNewSwitch.a(), false);
        int a4 = an.a(context).a(hh.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency((long) an.a(context).a(hh.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency((long) a4).build(context);
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport a2 = a(str);
        a2.eventId = str2;
        a2.eventType = i;
        a2.eventTime = j;
        a2.eventContent = str3;
        return a2;
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        PerfClientReport a2 = a();
        a2.code = i;
        a2.perfCounts = j;
        a2.perfLatencies = j2;
        return a2;
    }

    public static hg a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hg hgVar = new hg();
        hgVar.d("category_client_report_data");
        hgVar.a("push_sdk_channel");
        hgVar.a(1);
        hgVar.b(str);
        hgVar.a(true);
        hgVar.b(System.currentTimeMillis());
        hgVar.g(context.getPackageName());
        hgVar.e("com.xiaomi.xmsf");
        hgVar.f(bl.a());
        hgVar.c("quality_support");
        return hgVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hm m291a(String str) {
        if (f400a == null) {
            synchronized (hm.class) {
                if (f400a == null) {
                    f400a = new HashMap();
                    hm[] values = hm.values();
                    for (hm hmVar : values) {
                        f400a.put(hmVar.f576a.toLowerCase(), hmVar);
                    }
                }
            }
        }
        hm hmVar2 = f400a.get(str.toLowerCase());
        return hmVar2 != null ? hmVar2 : hm.Invalid;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m292a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m293a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new ek(context), new el(context));
    }

    private static void a(Context context, hg hgVar) {
        if (m294a(context.getApplicationContext())) {
            bm.a(context.getApplicationContext(), hgVar);
            return;
        }
        a aVar = a;
        if (aVar != null) {
            aVar.uploader(context, hgVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list != null) {
            try {
                for (String str : list) {
                    hg a2 = a(context, str);
                    if (!bl.a(a2, false)) {
                        a(context, a2);
                    }
                }
            } catch (Throwable th) {
                b.d(th.getMessage());
            }
        }
    }

    public static void a(a aVar) {
        a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m294a(Context context) {
        return context != null && !TextUtils.isEmpty(context.getPackageName()) && "com.xiaomi.xmsf".equals(context.getPackageName());
    }
}
