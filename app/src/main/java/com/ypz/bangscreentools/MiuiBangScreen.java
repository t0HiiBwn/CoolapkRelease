package com.ypz.bangscreentools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;

public class MiuiBangScreen implements BangScreenSupport {
    @Override // com.ypz.bangscreentools.BangScreenSupport
    public boolean hasNotBangScreen(Window window) {
        return "1".equals(SystemProperties.getSingle().get("ro.miui.notch"));
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public List<Rect> getBangSize(Window window) {
        ArrayList arrayList = new ArrayList();
        if (window == null) {
            return arrayList;
        }
        Context context = window.getContext();
        Resources resources = context.getResources();
        Rect rect = new Rect();
        if (resources != null) {
            rect.left = 0;
            rect.bottom = BangScreenTools.getBangScreenTools().getStatusBarHeight(context);
            rect.right = resources.getDisplayMetrics().widthPixels;
            rect.top = 0;
            arrayList.add(rect);
        }
        return arrayList;
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void extendStatusCutout(Window window, Context context) {
        if (window != null) {
            try {
                Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(window, 1792);
                window.setStatusBarColor(Color.parseColor("#D9D9D9"));
            } catch (Exception e) {
                Log.e("BangScreenTools", e.getMessage());
            }
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void setWindowLayoutBlockNotch(Window window) {
        if (window != null) {
            try {
                Window.class.getMethod("clearExtraFlags", Integer.TYPE).invoke(window, 1792);
            } catch (Exception e) {
                Log.e("BangScreenTools", e.getMessage());
            }
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void transparentStatusCutout(Window window, Context context) {
        if (window != null) {
            try {
                Window.class.getMethod("clearExtraFlags", Integer.TYPE).invoke(window, 1792);
            } catch (Exception e) {
                Log.e("BangScreenTools", e.getMessage());
            }
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void fullscreen(Window window, Context context) {
        if (window != null) {
            try {
                Window.class.getMethod("clearExtraFlags", Integer.TYPE).invoke(window, 1792);
            } catch (Exception e) {
                Log.e("BangScreenTools", e.getMessage());
            }
        }
    }
}
