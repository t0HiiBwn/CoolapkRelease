package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: OaidTracking */
public class i extends a {
    public static final String a = "umeng_sp_oaid";
    public static final String b = "key_umeng_sp_oaid";
    public static final String c = "key_umeng_sp_oaid_required_time";
    private static final String d = "oaid";
    private Context e;

    public i(Context context) {
        super("oaid");
        this.e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow("header_device_oaid")) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.e.getSharedPreferences("umeng_sp_oaid", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString("key_umeng_sp_oaid", "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
