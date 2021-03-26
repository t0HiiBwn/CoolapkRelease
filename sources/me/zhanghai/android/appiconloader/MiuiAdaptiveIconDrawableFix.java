package me.zhanghai.android.appiconloader;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.lang.reflect.Field;

class MiuiAdaptiveIconDrawableFix {
    private MiuiAdaptiveIconDrawableFix() {
    }

    public static void apply() {
        try {
            Field declaredField = Class.forName("android.graphics.drawable.AdaptiveIconDrawableInjector").getDeclaredField("MASK_PAINT");
            declaredField.setAccessible(true);
            ((Paint) declaredField.get(null)).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
        } catch (Exception unused) {
        }
    }
}
