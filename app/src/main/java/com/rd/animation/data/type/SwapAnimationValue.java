package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class SwapAnimationValue implements Value {
    private int coordinate;
    private int coordinateReverse;

    public int getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(int i) {
        this.coordinate = i;
    }

    public int getCoordinateReverse() {
        return this.coordinateReverse;
    }

    public void setCoordinateReverse(int i) {
        this.coordinateReverse = i;
    }
}
