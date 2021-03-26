package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.TextOptions;

/* compiled from: TextDelegateImp */
public class bp implements aj {
    private b a;
    private at b;
    private String c;
    private int d;
    private int e;
    private LatLng f;
    private float g;
    private int h;
    private Typeface i;
    private boolean j;
    private float k;

    /* renamed from: l  reason: collision with root package name */
    private int f1224l;
    private int m;
    private Object n;
    private int o;

    public bp(y yVar, TextOptions textOptions, at atVar) {
        this.b = atVar;
        this.c = textOptions.getText();
        this.d = textOptions.getFontSize();
        this.e = textOptions.getFontColor();
        this.f = textOptions.getPosition();
        this.g = textOptions.getRotate();
        this.h = textOptions.getBackgroundColor();
        this.i = textOptions.getTypeface();
        this.j = textOptions.isVisible();
        this.k = textOptions.getZIndex();
        this.f1224l = textOptions.getAlignX();
        this.m = textOptions.getAlignY();
        this.n = textOptions.getObject();
        this.a = (b) yVar;
    }

    @Override // com.amap.api.interfaces.IText
    public void remove() {
        at atVar = this.b;
        if (atVar != null) {
            atVar.b(this);
        }
    }

    @Override // com.amap.api.interfaces.IText
    public void setZIndex(float f2) {
        this.k = f2;
        this.b.d();
    }

    @Override // com.amap.api.interfaces.IText, com.amap.api.mapcore2d.ac
    public float getZIndex() {
        return this.k;
    }

    @Override // com.amap.api.interfaces.IText
    public void setVisible(boolean z) {
        this.j = z;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public boolean isVisible() {
        return this.j;
    }

    @Override // com.amap.api.interfaces.IText
    public void draw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        if (!TextUtils.isEmpty(this.c) && this.f != null) {
            TextPaint textPaint = new TextPaint();
            if (this.i == null) {
                this.i = Typeface.DEFAULT;
            }
            textPaint.setTypeface(this.i);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize((float) this.d);
            float measureText = textPaint.measureText(this.c);
            float f4 = (float) this.d;
            textPaint.setColor(this.h);
            w wVar = new w((int) (this.f.latitude * 1000000.0d), (int) (this.f.longitude * 1000000.0d));
            Point point = new Point();
            this.a.d().a(wVar, point);
            canvas.save();
            canvas.rotate(-(this.g % 360.0f), (float) point.x, (float) point.y);
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int i3 = this.f1224l;
            if (i3 < 1 || i3 > 3) {
                this.f1224l = 3;
            }
            int i4 = this.m;
            if (i4 < 4 || i4 > 6) {
                this.m = 6;
            }
            int i5 = this.f1224l;
            int i6 = 0;
            if (i5 != 1) {
                if (i5 == 2) {
                    f3 = ((float) point.x) - measureText;
                } else if (i5 != 3) {
                    i2 = 0;
                } else {
                    f3 = ((float) point.x) - (measureText / 2.0f);
                }
                i2 = (int) f3;
            } else {
                i2 = point.x;
            }
            int i7 = this.m;
            if (i7 != 4) {
                if (i7 == 5) {
                    f2 = ((float) point.y) - f4;
                } else if (i7 == 6) {
                    f2 = ((float) point.y) - (f4 / 2.0f);
                }
                i6 = (int) f2;
            } else {
                i6 = point.y;
            }
            float f5 = (float) i2;
            float f6 = ((float) i6) + f4 + 2.0f;
            canvas.drawRect((float) (i2 - 1), (float) (i6 - 1), f5 + measureText + 2.0f, f6, textPaint);
            textPaint.setColor(this.e);
            canvas.drawText(this.c, f5, f6 - fontMetrics.bottom, textPaint);
            canvas.restore();
        }
    }

    @Override // com.amap.api.interfaces.IText
    public void setText(String str) {
        this.c = str;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public String getText() {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IText
    public void setFontSize(int i2) {
        this.d = i2;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public int getFontSize() {
        return this.d;
    }

    @Override // com.amap.api.interfaces.IText
    public void setFontColor(int i2) {
        this.e = i2;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public int getFonrColor() {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IText
    public void setPosition(LatLng latLng) {
        this.f = latLng;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public LatLng getPosition() {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IText
    public void setRotate(float f2) {
        this.g = f2;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public float getRotate() {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IText
    public void setBackgroundColor(int i2) {
        this.h = i2;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public int getBackgroundColor() {
        return this.h;
    }

    @Override // com.amap.api.interfaces.IText
    public void setTypeface(Typeface typeface) {
        this.i = typeface;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public Typeface getTypeface() {
        return this.i;
    }

    @Override // com.amap.api.interfaces.IText
    public int getAlignX() {
        return this.f1224l;
    }

    @Override // com.amap.api.interfaces.IText
    public int getAlignY() {
        return this.m;
    }

    @Override // com.amap.api.interfaces.IText
    public void setAlign(int i2, int i3) {
        this.f1224l = i2;
        this.m = i3;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public void setObject(Object obj) {
        this.n = obj;
    }

    @Override // com.amap.api.interfaces.IText
    public Object getObject() {
        return this.n;
    }

    @Override // com.amap.api.interfaces.IText, com.amap.api.mapcore2d.ac
    public void setAddIndex(int i2) {
        this.o = i2;
    }

    @Override // com.amap.api.interfaces.IText, com.amap.api.mapcore2d.ac
    public int getAddIndex() {
        return this.o;
    }
}
