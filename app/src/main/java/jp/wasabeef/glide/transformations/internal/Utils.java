package jp.wasabeef.glide.transformations.internal;

import android.content.res.Resources;

public final class Utils {
    private Utils() {
    }

    public static int toDp(int i) {
        return i * ((int) Resources.getSystem().getDisplayMetrics().density);
    }
}
