package com.ypz.bangscreentools;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

public class PBangScreen implements BangScreenSupport {
    @Override // com.ypz.bangscreentools.BangScreenSupport
    public boolean hasNotBangScreen(Window window) {
        View decorView;
        List<Rect> boundingRects;
        if (window == null || (decorView = window.getDecorView()) == null) {
            return false;
        }
        WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
        if (rootWindowInsets == null) {
            Log.i("BangScreenTools", "insets == null");
            return false;
        }
        DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(displayCutout == null));
        sb.append("dct");
        Log.i("BangScreenTools", sb.toString());
        if (displayCutout == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.size() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public List<Rect> getBangSize(Window window) {
        View decorView;
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        ArrayList arrayList = new ArrayList();
        if (!(window == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null)) {
            arrayList.addAll(displayCutout.getBoundingRects());
        }
        return arrayList;
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void extendStatusCutout(Window window, Context context) {
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void setWindowLayoutBlockNotch(Window window) {
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 2;
            window.setAttributes(attributes);
        }
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void transparentStatusCutout(Window window, Context context) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public void fullscreen(Window window, Context context) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
    }
}
