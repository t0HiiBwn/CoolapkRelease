package com.tencent.msdk.dns.base.report;

import com.tencent.msdk.dns.base.report.IReporter.a;
import java.util.Map;

public interface IReporter<InitParameters extends a> {

    public interface a {
        public static final a c = new a() {
            /* class com.tencent.msdk.dns.base.report.IReporter.a.AnonymousClass1 */
        };
    }

    boolean canReport();

    String getName();

    boolean init(InitParameters initparameters);

    boolean report(int i, String str, Map<String, String> map);

    boolean setDebug(boolean z);
}
