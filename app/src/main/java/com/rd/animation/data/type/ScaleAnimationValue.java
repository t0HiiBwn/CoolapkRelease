package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class ScaleAnimationValue extends ColorAnimationValue implements Value {
    private int radius;
    private int radiusReverse;

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
}
