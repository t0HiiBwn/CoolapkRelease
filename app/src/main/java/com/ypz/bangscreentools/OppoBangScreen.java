package com.ypz.bangscreentools;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;

public class OppoBangScreen implements BangScreenSupport {
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
        return window.getContext().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    @Override // com.ypz.bangscreentools.BangScreenSupport
    public List<Rect> getBangSize(Window window) {
        ArrayList arrayList = new ArrayList();
        if (window == null) {
            return arrayList;
        }
        DisplayMetrics displayMetrics = window.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = (displayMetrics.widthPixels - 324) / 2;
        rect.right = rect.left + 324;
        rect.bottom = 80;
        rect.top = 0;
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
            window.getDecorView().setSystemUiVisibility(1024 & window.getDecorView().getSystemUiVisibility() & 256);
        }
    }
}
