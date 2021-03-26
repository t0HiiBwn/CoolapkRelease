package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

final class bu {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static String b = "";

    static String a(SharedPreferences sharedPreferences) {
        if (a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            b = string;
            if (TextUtils.isEmpty(string)) {
                b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", b).apply();
            }
        }
        return b;
    }
}
