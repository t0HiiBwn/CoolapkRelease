package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.common.a;

/* compiled from: IDFATracker */
public class c extends a {
    private static final String a = "idfa";
    private Context b;

    public c(Context context) {
        super("idfa");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        String a2 = FieldManager.allow("header_tracking_idfa") ? a.a(this.b) : null;
        return a2 == null ? "" : a2;
    }
}
