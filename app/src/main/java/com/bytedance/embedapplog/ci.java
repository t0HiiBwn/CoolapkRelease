package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;

final class ci {
    private final SharedPreferences a;

    ci(Context context) {
        this.a = context.getSharedPreferences("device_register_oaid_refine", 0);
    }

    void a(ch chVar) {
        if (chVar != null) {
            this.a.edit().putString("oaid", chVar.b().toString()).apply();
        }
    }

    ch a() {
        return ch.a(this.a.getString("oaid", ""));
    }
}
