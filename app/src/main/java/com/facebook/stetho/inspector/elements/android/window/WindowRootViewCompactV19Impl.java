package com.facebook.stetho.inspector.elements.android.window;

import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

class WindowRootViewCompactV19Impl extends WindowRootViewCompat {
    private List<View> mRootViews;

    WindowRootViewCompactV19Impl() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            this.mRootViews = (List) declaredField.get(invoke);
            declaredField.setAccessible(false);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        } catch (NoSuchFieldException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // com.facebook.stetho.inspector.elements.android.window.WindowRootViewCompat
    public List<View> getRootViews() {
        return Collections.unmodifiableList(this.mRootViews);
    }
}
