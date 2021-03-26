package com.bytedance.tea.crash.g;

import android.app.ActivityManager;
import android.os.Build;

/* compiled from: JellyBeanV16Compat */
public class g {
    static final a a;

    /* compiled from: JellyBeanV16Compat */
    private static class a {
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0;
        }

        private a() {
        }
    }

    /* compiled from: JellyBeanV16Compat */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.bytedance.tea.crash.g.g.a
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }
}
