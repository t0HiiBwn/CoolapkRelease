package com.rd.animation;

import com.rd.animation.controller.AnimationController;
import com.rd.animation.controller.ValueController;
import com.rd.draw.data.Indicator;

public class AnimationManager {
    private AnimationController animationController;

    public AnimationManager(Indicator indicator, ValueController.UpdateListener updateListener) {
        this.animationController = new AnimationController(indicator, updateListener);
    }

    public void basic() {
        AnimationController animationController2 = this.animationController;
        if (animationController2 != null) {
            animationController2.end();
            this.animationController.basic();
        }
    }

    public void interactive(float f) {
        AnimationController animationController2 = this.animationController;
        if (animationController2 != null) {
            animationController2.interactive(f);
        }
    }

    public void end() {
        AnimationController animationController2 = this.animationController;
        if (animationController2 != null) {
            animationController2.end();
        }
    }
}
