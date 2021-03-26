package com.kk.taurus.playerbase.style;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.kk.taurus.playerbase.utils.RectUtils;

public class ViewOvalRectOutlineProvider extends ViewOutlineProvider {
    private Rect mRect;

    public ViewOvalRectOutlineProvider(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect = this.mRect;
        if (rect == null) {
            Rect rect2 = new Rect();
            view.getGlobalVisibleRect(rect2);
            rect = RectUtils.getOvalRect(rect2);
        }
        outline.setOval(rect);
    }
}
