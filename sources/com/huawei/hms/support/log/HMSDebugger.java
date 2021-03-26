package com.huawei.hms.support.log;

import android.content.Context;

public final class HMSDebugger {
    public static void init(Context context, int i) {
        HMSLog.init(context, i, "HMSSdk");
    }
}
