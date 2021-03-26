package com.kk.taurus.playerbase.style;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

public class ViewRoundRectOutlineProvider extends ViewOutlineProvider {
    private float mRadius;
    private Rect mRect;

    public ViewRoundRectOutlineProvider(float f) {
        this.mRadius = f;
    }

    public ViewRoundRectOutlineProvider(float f, Rect rect) {
        this.mRadius = f;
        this.mRect = rect;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0);
        Rect rect3 = this.mRect;
        if (rect3 != null) {
            rect2 = rect3;
        }
        outline.setRoundRect(rect2, this.mRadius);
    }
}
