package com.tencent.msdk.dns.base.report;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.base.report.IReporter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: ReportManager */
public final class e {
    private static List<IReporter> a = Collections.emptyList();
    private static List<IReporter> b = Collections.emptyList();

    public static void a(int i) {
        a = f.a(i);
    }

    public static synchronized void a(IReporter iReporter) {
        synchronized (e.class) {
            if (iReporter != null) {
                if (iReporter.canReport()) {
                    if (b.isEmpty()) {
                        b = new ArrayList();
                    }
                    b.add(iReporter);
                }
            }
        }
    }

    public static boolean a() {
        return !a.isEmpty() || !b.isEmpty();
    }

    public static <InitParameters extends IReporter.a> void a(int i, InitParameters initparameters) {
        IReporter b2 = f.b(i);
        if (b2 == null) {
            b.b("Get builtIn reporter from channel: %d failed", Integer.valueOf(i));
        } else if (!b2.init(initparameters)) {
            b.b("%s init failed", b2.getName());
        }
    }

    public static void a(int i, String str, Map<String, String> map) {
        if (!(TextUtils.isEmpty(str) || map == null)) {
            b.b("HTTPDNS_SDK_VER:3.3.0a, Try to report %s", str);
            if (b.b(2)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    b.a("%s: %s", entry.getKey(), entry.getValue());
                }
            }
            for (IReporter iReporter : a) {
                if (!iReporter.report(i, str, map)) {
                    b.b("%s report failed", iReporter.getName());
                }
            }
            for (IReporter iReporter2 : b) {
                if (!iReporter2.report(i, str, map)) {
                    b.b("%s report failed", iReporter2.getName());
                }
            }
        }
    }
}
