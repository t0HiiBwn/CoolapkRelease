package com.kk.taurus.playerbase.style;

import android.graphics.Rect;

public interface IStyleSetter {
    void clearShapeStyle();

    void setElevationShadow(float f);

    void setElevationShadow(int i, float f);

    void setOvalRectShape();

    void setOvalRectShape(Rect rect);

    void setRoundRectShape(float f);

    void setRoundRectShape(Rect rect, float f);
}
