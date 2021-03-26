package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class ColorAnimationValue implements Value {
    private int color;
    private int colorReverse;

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public int getColorReverse() {
        return this.colorReverse;
    }

    public void setColorReverse(int i) {
        this.colorReverse = i;
    }
}
