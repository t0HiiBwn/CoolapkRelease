package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class ThinWormAnimationValue extends WormAnimationValue implements Value {
    private int height;

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }
}
