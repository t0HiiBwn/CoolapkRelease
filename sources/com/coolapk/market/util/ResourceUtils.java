package com.coolapk.market.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import com.coolapk.market.AppHolder;

public class ResourceUtils {
    public static int resolveData(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public static int resolveResId(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public static CharSequence resolveString(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.string;
    }

    public static int getColorInt(Context context, int i) {
        return ResourcesCompat.getColor(context.getResources(), i, context.getTheme());
    }

    public static Drawable getDrawable(Context context, int i) {
        return ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme());
    }

    public static int getDimen(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int getDayNightPlaceHolder(int i) {
        if (!AppHolder.getAppTheme().isDarkTheme()) {
            return i;
        }
        if (i == 2131231152) {
            i = 2131231153;
        }
        if (i == 2131231271) {
            i = 2131231272;
        }
        if (i == 2131231363) {
            i = 2131231364;
        }
        if (i == 2131231691) {
            i = 2131231692;
        }
        if (i == 2131231696) {
            return 2131231697;
        }
        return i;
    }
}
