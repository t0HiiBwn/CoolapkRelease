package com.ypz.bangscreentools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HuaWeiBangScreen implements BangScreenSupport {
    private Class hwBangSizeUtil;
    private boolean isBangScreen;
    private boolean isHaveResult;

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public boolean hasNotBangScreen(Window window) {
        if (this.isHaveResult) {
            return this.isBangScreen;
        }
        try {
            Class<?> loadClass = window.getContext().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method method = loadClass.getMethod("hasNotchInScreen", new Class[0]);
            this.isHaveResult = true;
            boolean booleanValue = ((Boolean) method.invoke(loadClass, new Object[0])).booleanValue();
            this.isBangScreen = booleanValue;
            this.isHaveResult = true;
            return booleanValue;
        } catch (ClassNotFoundException unused) {
            Log.e("BangScreenTools", "hasNotchInScreen ClassNotFoundException");
        } catch (NoSuchMethodException unused2) {
            Log.e("BangScreenTools", "hasNotchInScreen NoSuchMethodException");
        } catch (Exception unused3) {
            Log.e("BangScreenTools", "hasNotchInScreen Exception");
        } catch (Throwable unused4) {
        }
        this.isHaveResult = true;
        return this.isBangScreen;
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public List<Rect> getBangSize(Window window) {
        int[] iArr;
        Resources resources;
        ArrayList arrayList = new ArrayList();
        if (window != null) {
            Rect rect = new Rect();
            try {
                Context context = window.getContext();
                if (this.hwBangSizeUtil == null && context != null) {
                    this.hwBangSizeUtil = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                }
                Class cls = this.hwBangSizeUtil;
                if (!(cls == null || (iArr = (int[]) cls.getMethod("getNotchSize", new Class[0]).invoke(this.hwBangSizeUtil, new Object[0])) == null || (resources = context.getResources()) == null)) {
                    rect.left = (resources.getDisplayMetrics().widthPixels - iArr[0]) / 2;
                    rect.bottom = iArr[1];
                    rect.right = rect.left + iArr[0];
                    rect.top = 0;
                    arrayList.add(rect);
                }
                return arrayList;
            } catch (Exception e) {
                Log.e("BangScreenTools", e.getMessage());
            }
        }
        return arrayList;
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void extendStatusCutout(Window window, Context context) {
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            } catch (Exception e) {
                Log.e("BangScreenTools", "exception:" + e.getMessage());
            }
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void setWindowLayoutBlockNotch(Window window) {
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("clearHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            } catch (Exception e) {
                Log.e("BangScreenTools", e.getMessage());
            }
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void transparentStatusCutout(Window window, Context context) {
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            } catch (Exception e) {
                Log.e("BangScreenTools", "exception:" + e.getMessage());
            }
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void fullscreen(Window window, Context context) {
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            } catch (Exception e) {
                Log.e("BangScreenTools", "exception:" + e.getMessage());
            }
        }
    }
}
