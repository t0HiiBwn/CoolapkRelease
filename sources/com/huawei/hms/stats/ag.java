package com.huawei.hms.stats;

import android.util.Log;

public class ag {
    private boolean a = false;
    private int b = 4;

    private static String a() {
        return "HiAnalyticsSDK_2.2.0.305" + br.a();
    }

    public void a(int i) {
        Log.i("HiAnalyticsSDK", "\n=======================================\n " + a() + "\n=======================================");
        this.b = i;
        this.a = true;
    }

    public void a(int i, String str, String str2) {
        b(i, "HiAnalyticsSDK", str + "=> " + str2);
    }

    public void b(int i, String str, String str2) {
        if (i != 3) {
            if (i != 4) {
                if (i == 5) {
                    Log.w(str, str2);
                    return;
                } else if (i == 6) {
                    Log.e(str, str2);
                    return;
                }
            }
            Log.i(str, str2);
            return;
        }
        Log.d(str, str2);
    }

    public boolean b(int i) {
        return this.a && i >= this.b;
    }
}
