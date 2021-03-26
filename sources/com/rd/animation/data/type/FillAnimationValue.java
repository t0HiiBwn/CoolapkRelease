package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class FillAnimationValue extends ColorAnimationValue implements Value {
    private int radius;
    private int radiusReverse;
    private int stroke;
    private int strokeReverse;

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int i) {
        this.radius = i;
    }

    public int getRadiusReverse() {
        return this.radiusReverse;
    }

    public void setRadiusReverse(int i) {
        this.radiusReverse = i;
    }

    public int getStroke() {
        return this.stroke;
    }

    public void setStroke(int i) {
        this.stroke = i;
    }

    public int getStrokeReverse() {
        return this.strokeReverse;
    }

    public void setStrokeReverse(int i) {
        this.strokeReverse = i;
    }
}
