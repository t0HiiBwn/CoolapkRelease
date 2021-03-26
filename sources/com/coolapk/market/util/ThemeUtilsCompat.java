package com.coolapk.market.util;

import com.coolapk.market.AppHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/coolapk/market/util/ThemeUtilsCompat;", "", "()V", "pickThemeColor", "", "nightColor", "lightColor", "elseColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ThemeUtilsCompat.kt */
public final class ThemeUtilsCompat {
    public static final ThemeUtilsCompat INSTANCE = new ThemeUtilsCompat();

    private ThemeUtilsCompat() {
    }

    public final int pickThemeColor(int i, int i2, int i3) {
        if (AppHolder.getAppTheme().isDarkTheme()) {
            return i;
        }
        return AppHolder.getAppTheme().isLightColorTheme() ? i2 : i3;
    }
}
