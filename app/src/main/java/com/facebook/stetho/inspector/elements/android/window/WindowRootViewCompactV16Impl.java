package com.facebook.stetho.inspector.elements.android.window;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class WindowRootViewCompactV16Impl extends WindowRootViewCompat {
    private Context mContext;

    WindowRootViewCompactV16Impl(Context context) {
        this.mContext = context;
    }

    @Override // com.facebook.stetho.inspector.elements.android.window.WindowRootViewCompat
    public List<View> getRootViews() {
        return getWindowViews(getOuter((WindowManager) this.mContext.getSystemService("window")));
    }

    private static Object getOuter(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mWindowManager");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            declaredField.setAccessible(false);
            return obj2;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static List<View> getWindowViews(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mViews");
            declaredField.setAccessible(true);
            return Collections.unmodifiableList(Arrays.asList((View[]) declaredField.get(obj)));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }
}
