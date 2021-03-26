package com.huawei.hms.stats;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class bd {
    private static bd a = new bd();
    private boolean b = false;
    private Context c = b.j();

    private bd() {
    }

    public static bd a() {
        return a;
    }

    public boolean b() {
        boolean z;
        if (!this.b) {
            if (this.c == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) this.c.getSystemService("user");
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.b = false;
                }
            } else {
                z = true;
            }
            this.b = z;
        }
        return this.b;
    }
}
