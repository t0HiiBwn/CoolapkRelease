package com.coolapk.market.util;

public class CoolMarketHook {
    private static final boolean DEBUG_HOOK = false;
    private static CoolMarketHook sInstance = new CoolMarketHook();

    public boolean isSupportCustomTab(boolean z, String str) {
        return z;
    }

    public boolean shouldChangeNightMode(boolean z) {
        return z;
    }

    private CoolMarketHook() {
    }

    public static CoolMarketHook getInstance() {
        return sInstance;
    }
}
