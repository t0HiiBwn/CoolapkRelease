package com.svgandroid;

import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;

public class SVG {
    private RectF bounds;
    private RectF limits = null;
    private Picture picture;

    SVG(Picture picture2, RectF rectF) {
        this.picture = picture2;
        this.bounds = rectF;
    }

    void setLimits(RectF rectF) {
        this.limits = rectF;
    }

    public PictureDrawable createPictureDrawable() {
        return new PictureDrawable(this.picture);
    }

    public Picture getPicture() {
        return this.picture;
    }

    public RectF getBounds() {
        return this.bounds;
    }

    public RectF getLimits() {
        return this.limits;
    }
}
