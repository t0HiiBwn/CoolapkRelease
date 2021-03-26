package com.amap.api.interfaces;

import android.graphics.Canvas;
import android.graphics.Typeface;
import com.amap.api.maps2d.model.LatLng;

public interface IText {
    void draw(Canvas canvas);

    @Override // com.amap.api.mapcore2d.ac
    int getAddIndex();

    int getAlignX();

    int getAlignY();

    int getBackgroundColor();

    int getFonrColor();

    int getFontSize();

    Object getObject();

    LatLng getPosition();

    float getRotate();

    String getText();

    Typeface getTypeface();

    @Override // com.amap.api.mapcore2d.ac
    float getZIndex();

    boolean isVisible();

    void remove();

    @Override // com.amap.api.mapcore2d.ac
    void setAddIndex(int i);

    void setAlign(int i, int i2);

    void setBackgroundColor(int i);

    void setFontColor(int i);

    void setFontSize(int i);

    void setObject(Object obj);

    void setPosition(LatLng latLng);

    void setRotate(float f);

    void setText(String str);

    void setTypeface(Typeface typeface);

    void setVisible(boolean z);

    void setZIndex(float f);
}
