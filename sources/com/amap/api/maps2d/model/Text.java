package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import com.amap.api.interfaces.IText;
import com.amap.api.mapcore2d.aj;

public final class Text {
    public static final int ALIGN_BOTTOM = 5;
    public static final int ALIGN_CENTER_HORIZONTAL = 3;
    public static final int ALIGN_CENTER_VERTICAL = 6;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 4;
    private IText a;

    public Text(aj ajVar) {
        this.a = ajVar;
    }

    public void setPosition(LatLng latLng) {
        this.a.setPosition(latLng);
    }

    public LatLng getPosition() {
        return this.a.getPosition();
    }

    public float getZIndex() {
        return this.a.getZIndex();
    }

    public void setZIndex(float f) {
        this.a.setZIndex(f);
    }

    public void remove() {
        this.a.remove();
    }

    public void setObject(Object obj) {
        this.a.setObject(obj);
    }

    public Object getObject() {
        return this.a.getObject();
    }

    public void setText(String str) {
        this.a.setText(str);
    }

    public String getText() {
        return this.a.getText();
    }

    public void setFontSize(int i) {
        this.a.setFontSize(i);
    }

    public int getFontSize() {
        return this.a.getFontSize();
    }

    public void setFontColor(int i) {
        this.a.setFontColor(i);
    }

    public int getFontColor() {
        return this.a.getFonrColor();
    }

    public void setRotate(float f) {
        this.a.setRotate(f);
    }

    public float getRotate() {
        return this.a.getRotate();
    }

    public void setBackgroundColor(int i) {
        this.a.setBackgroundColor(i);
    }

    public int getBackgroundColor() {
        return this.a.getBackgroundColor();
    }

    public void setTypeface(Typeface typeface) {
        this.a.setTypeface(typeface);
    }

    public Typeface getTypeface() {
        return this.a.getTypeface();
    }

    public int getAlignX() {
        return this.a.getAlignX();
    }

    public int getAlignY() {
        return this.a.getAlignY();
    }

    public void setAlign(int i, int i2) {
        this.a.setAlign(i, i2);
    }

    public void setVisible(boolean z) {
        this.a.setVisible(z);
    }

    public boolean isVisible() {
        return this.a.isVisible();
    }
}
