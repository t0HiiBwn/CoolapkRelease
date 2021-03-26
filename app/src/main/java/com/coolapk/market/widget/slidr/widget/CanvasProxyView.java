package com.coolapk.market.widget.slidr.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.lang.ref.WeakReference;

public class CanvasProxyView extends View {
    private WeakReference<View> mProxyView;

    public CanvasProxyView(Context context) {
        super(context);
    }

    public void setProxyView(View view) {
        this.mProxyView = new WeakReference<>(view);
        invalidate();
    }

    public boolean hasProxyView() {
        WeakReference<View> weakReference = this.mProxyView;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        WeakReference<View> weakReference = this.mProxyView;
        if (weakReference != null && weakReference.get() != null) {
            this.mProxyView.get().draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mProxyView = null;
    }
}
