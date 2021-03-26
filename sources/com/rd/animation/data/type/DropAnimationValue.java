package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class DropAnimationValue implements Value {
    private int height;
    private int radius;
    private int width;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int i) {
        this.radius = i;
    }
}
