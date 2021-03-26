package com.rd.animation.data;

import com.rd.animation.data.type.ColorAnimationValue;
import com.rd.animation.data.type.DropAnimationValue;
import com.rd.animation.data.type.FillAnimationValue;
import com.rd.animation.data.type.ScaleAnimationValue;
import com.rd.animation.data.type.SwapAnimationValue;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.animation.data.type.WormAnimationValue;

public class AnimationValue {
    private ColorAnimationValue colorAnimationValue;
    private DropAnimationValue dropAnimationValue;
    private FillAnimationValue fillAnimationValue;
    private ScaleAnimationValue scaleAnimationValue;
    private SwapAnimationValue swapAnimationValue;
    private ThinWormAnimationValue thinWormAnimationValue;
    private WormAnimationValue wormAnimationValue;

    public ColorAnimationValue getColorAnimationValue() {
        if (this.colorAnimationValue == null) {
            this.colorAnimationValue = new ColorAnimationValue();
        }
        return this.colorAnimationValue;
    }

    public ScaleAnimationValue getScaleAnimationValue() {
        if (this.scaleAnimationValue == null) {
            this.scaleAnimationValue = new ScaleAnimationValue();
        }
        return this.scaleAnimationValue;
    }

    public WormAnimationValue getWormAnimationValue() {
        if (this.wormAnimationValue == null) {
            this.wormAnimationValue = new WormAnimationValue();
        }
        return this.wormAnimationValue;
    }

    public FillAnimationValue getFillAnimationValue() {
        if (this.fillAnimationValue == null) {
            this.fillAnimationValue = new FillAnimationValue();
        }
        return this.fillAnimationValue;
    }

    public ThinWormAnimationValue getThinWormAnimationValue() {
        if (this.thinWormAnimationValue == null) {
            this.thinWormAnimationValue = new ThinWormAnimationValue();
        }
        return this.thinWormAnimationValue;
    }

    public DropAnimationValue getDropAnimationValue() {
        if (this.dropAnimationValue == null) {
            this.dropAnimationValue = new DropAnimationValue();
        }
        return this.dropAnimationValue;
    }

    public SwapAnimationValue getSwapAnimationValue() {
        if (this.swapAnimationValue == null) {
            this.swapAnimationValue = new SwapAnimationValue();
        }
        return this.swapAnimationValue;
    }
}
