package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tea.crash.h;

/* compiled from: SettingManager */
public final class j {
    private SharedPreferences a;

    public j(Context context) {
        this.a = context.getSharedPreferences("npth", 0);
    }

    public void a(String str) {
        this.a.edit().putString("device_id", str).apply();
    }

    public String a() {
        String e = h.a().e();
        if (TextUtils.isEmpty(e) || "0".equals(e)) {
            return this.a.getString("device_id", "0");
        }
        return e;
    }
}
