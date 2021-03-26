package com.facebook.stetho.inspector.elements.android.window;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.facebook.stetho.common.Util;
import java.util.List;

public abstract class WindowRootViewCompat {
    private static WindowRootViewCompat sInstance;

    public abstract List<View> getRootViews();

    public static WindowRootViewCompat get(Context context) {
        WindowRootViewCompat windowRootViewCompat = sInstance;
        if (windowRootViewCompat != null) {
            return windowRootViewCompat;
        }
        Util.throwIfNull(context);
        if (Build.VERSION.SDK_INT >= 19) {
            sInstance = new WindowRootViewCompactV19Impl();
        } else if (Build.VERSION.SDK_INT == 17 || Build.VERSION.SDK_INT == 18) {
            sInstance = new WindowRootViewCompactV18Impl();
        } else {
            sInstance = new WindowRootViewCompactV16Impl(context.getApplicationContext());
        }
        return sInstance;
    }
}
