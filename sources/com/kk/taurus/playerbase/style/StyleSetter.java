package com.kk.taurus.playerbase.style;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;

public final class StyleSetter implements IStyleSetter {
    private View mView;

    public StyleSetter(View view) {
        this.mView = view;
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setRoundRectShape(float f) {
        setRoundRectShape(null, f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setRoundRectShape(Rect rect, float f) {
        this.mView.setClipToOutline(true);
        this.mView.setOutlineProvider(new ViewRoundRectOutlineProvider(f, rect));
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setOvalRectShape() {
        setOvalRectShape(null);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setOvalRectShape(Rect rect) {
        this.mView.setClipToOutline(true);
        this.mView.setOutlineProvider(new ViewOvalRectOutlineProvider(rect));
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void clearShapeStyle() {
        this.mView.setClipToOutline(false);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setElevationShadow(float f) {
        setElevationShadow(-16777216, f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setElevationShadow(int i, float f) {
        this.mView.setBackgroundColor(i);
        ViewCompat.setElevation(this.mView, f);
        this.mView.invalidate();
    }
}
