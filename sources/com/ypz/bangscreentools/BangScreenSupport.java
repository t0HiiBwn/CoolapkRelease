package com.ypz.bangscreentools;

import android.content.Context;
import android.graphics.Rect;
import android.view.Window;
import java.util.List;

public interface BangScreenSupport {
    void extendStatusCutout(Window window, Context context);

    void fullscreen(Window window, Context context);

    List<Rect> getBangSize(Window window);

    boolean hasNotBangScreen(Window window);

    void setWindowLayoutBlockNotch(Window window);

    void transparentStatusCutout(Window window, Context context);
}
