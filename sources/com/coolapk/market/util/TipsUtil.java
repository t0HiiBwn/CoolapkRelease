package com.coolapk.market.util;

import com.coolapk.market.manager.DataManager;

public class TipsUtil {
    public static void tipSign(String str, boolean z) {
        DataManager.getInstance().getPreferencesEditor().putBoolean(str, z).apply();
    }

    public static boolean getKeyTipsSign(String str) {
        return DataManager.getInstance().getPreferencesBoolean(str, false);
    }
}
