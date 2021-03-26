package com.tencent.msdk.dns.base.report;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.report.IReporter;
import com.tencent.msdk.dns.base.report.IReporter.a;
import java.util.Map;

/* compiled from: AbsReporter */
public abstract class a<InitParameters extends IReporter.a> implements IReporter<InitParameters> {
    abstract boolean a(int i, String str, Map<String, String> map);

    @Override // com.tencent.msdk.dns.base.report.IReporter
    public boolean init(InitParameters initparameters) {
        return true;
    }

    @Override // com.tencent.msdk.dns.base.report.IReporter
    public boolean setDebug(boolean z) {
        return true;
    }

    @Override // com.tencent.msdk.dns.base.report.IReporter
    public boolean report(int i, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return false;
        }
        return a(i, str, map);
    }
}
