package com.ypz.bangscreentools;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class VivoBangScreen implements BangScreenSupport {
    private Class vivo;
    private Method vivoMethod;

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void fullscreen(Window window, Context context) {
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void transparentStatusCutout(Window window, Context context) {
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public boolean hasNotBangScreen(Window window) {
        if (window == null) {
            return false;
        }
        Class cls = this.vivo;
        if (cls == null) {
            try {
                Class<?> loadClass = window.getContext().getClassLoader().loadClass("android.util.FtFeature");
                this.vivo = loadClass;
                Method method = loadClass.getMethod("isFeatureSupport", Integer.TYPE);
                this.vivoMethod = method;
                return ((Boolean) method.invoke(this.vivo, 32)).booleanValue();
            } catch (ClassNotFoundException e) {
                logError(e);
                return false;
            } catch (NoSuchMethodException e2) {
                logError(e2);
                return false;
            } catch (IllegalAccessException e3) {
                logError(e3);
                return false;
            } catch (InvocationTargetException e4) {
                logError(e4);
                return false;
            }
        } else {
            if (this.vivoMethod == null) {
                try {
                    Method method2 = cls.getMethod("isFeatureSupport", Integer.TYPE);
                    this.vivoMethod = method2;
                    try {
                        return ((Boolean) method2.invoke(this.vivo, 32)).booleanValue();
                    } catch (IllegalAccessException e5) {
                        logError(e5);
                        return false;
                    } catch (InvocationTargetException e6) {
                        logError(e6);
                        return false;
                    }
                } catch (NoSuchMethodException e7) {
                    logError(e7);
                }
            }
            return false;
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public List<Rect> getBangSize(Window window) {
        ArrayList arrayList = new ArrayList();
        if (window == null) {
            return arrayList;
        }
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = window.getContext().getResources().getDisplayMetrics();
        int applyDimension = (int) TypedValue.applyDimension(1, 100.0f, displayMetrics);
        rect.left = (displayMetrics.widthPixels - applyDimension) / 2;
        rect.right = rect.left + applyDimension;
        rect.top = 0;
        rect.bottom = (int) TypedValue.applyDimension(1, 27.0f, displayMetrics);
        arrayList.add(rect);
        return arrayList;
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void extendStatusCutout(Window window, Context context) {
        if (window != null) {
            Log.i("BangScreenTools", "next");
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void setWindowLayoutBlockNotch(Window window) {
        if (window != null) {
            window.clearFlags(1024);
            window.clearFlags(67108864);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(1024 & decorView.getSystemUiVisibility() & 256);
        }
    }

    private void logError(Exception exc) {
        Log.e("BangScreenTools", exc.getMessage());
    }
}
