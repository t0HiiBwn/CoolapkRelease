package com.rd.animation.controller;

import com.rd.animation.controller.ValueController;
import com.rd.animation.type.AnimationType;
import com.rd.animation.type.BaseAnimation;
import com.rd.animation.type.DropAnimation;
import com.rd.animation.type.WormAnimation;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.utils.CoordinatesUtils;

public class AnimationController {
    private Indicator indicator;
    private boolean isInteractive;
    private ValueController.UpdateListener listener;
    private float progress;
    private BaseAnimation runningAnimation;
    private ValueController valueController;

    public AnimationController(Indicator indicator2, ValueController.UpdateListener updateListener) {
        this.valueController = new ValueController(updateListener);
        this.listener = updateListener;
        this.indicator = indicator2;
    }

    public void interactive(float f) {
        this.isInteractive = true;
        this.progress = f;
        animate();
    }

    public void basic() {
        this.isInteractive = false;
        this.progress = 0.0f;
        animate();
    }

    public void end() {
        BaseAnimation baseAnimation = this.runningAnimation;
        if (baseAnimation != null) {
            baseAnimation.end();
        }
    }

    /* renamed from: com.rd.animation.controller.AnimationController$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rd$animation$type$AnimationType;

        static {
            int[] iArr = new int[AnimationType.values().length];
            $SwitchMap$com$rd$animation$type$AnimationType = iArr;
            try {
                iArr[AnimationType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.WORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.FILL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.SLIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.THIN_WORM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.DROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.SWAP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.SCALE_DOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private void animate() {
        switch (AnonymousClass1.$SwitchMap$com$rd$animation$type$AnimationType[this.indicator.getAnimationType().ordinal()]) {
            case 1:
                this.listener.onValueUpdated(null);
                return;
            case 2:
                colorAnimation();
                return;
            case 3:
                scaleAnimation();
                return;
            case 4:
                wormAnimation();
                return;
            case 5:
                fillAnimation();
                return;
            case 6:
                slideAnimation();
                return;
            case 7:
                thinWormAnimation();
                return;
            case 8:
                dropAnimation();
                return;
            case 9:
                swapAnimation();
                return;
            case 10:
                scaleDownAnimation();
                return;
            default:
                return;
        }
    }

    private void colorAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        BaseAnimation duration = this.valueController.color().with(unselectedColor, selectedColor).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void scaleAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        int radius = this.indicator.getRadius();
        float scaleFactor = this.indicator.getScaleFactor();
        BaseAnimation duration = this.valueController.scale().with(unselectedColor, selectedColor, radius, scaleFactor).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void wormAnimation() {
        int selectedPosition = this.indicator.isInteractiveAnimation() ? this.indicator.getSelectedPosition() : this.indicator.getLastSelectedPosition();
        int selectingPosition = this.indicator.isInteractiveAnimation() ? this.indicator.getSelectingPosition() : this.indicator.getSelectedPosition();
        WormAnimation duration = this.valueController.worm().with(CoordinatesUtils.getCoordinate(this.indicator, selectedPosition), CoordinatesUtils.getCoordinate(this.indicator, selectingPosition), this.indicator.getRadius(), selectingPosition > selectedPosition).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void slideAnimation() {
        BaseAnimation duration = this.valueController.slide().with(CoordinatesUtils.getCoordinate(this.indicator, this.indicator.isInteractiveAnimation() ? this.indicator.getSelectedPosition() : this.indicator.getLastSelectedPosition()), CoordinatesUtils.getCoordinate(this.indicator, this.indicator.isInteractiveAnimation() ? this.indicator.getSelectingPosition() : this.indicator.getSelectedPosition())).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void fillAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        int radius = this.indicator.getRadius();
        int stroke = this.indicator.getStroke();
        BaseAnimation duration = this.valueController.fill().with(unselectedColor, selectedColor, radius, stroke).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void thinWormAnimation() {
        int selectedPosition = this.indicator.isInteractiveAnimation() ? this.indicator.getSelectedPosition() : this.indicator.getLastSelectedPosition();
        int selectingPosition = this.indicator.isInteractiveAnimation() ? this.indicator.getSelectingPosition() : this.indicator.getSelectedPosition();
        WormAnimation duration = this.valueController.thinWorm().with(CoordinatesUtils.getCoordinate(this.indicator, selectedPosition), CoordinatesUtils.getCoordinate(this.indicator, selectingPosition), this.indicator.getRadius(), selectingPosition > selectedPosition).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void dropAnimation() {
        int selectedPosition = this.indicator.isInteractiveAnimation() ? this.indicator.getSelectedPosition() : this.indicator.getLastSelectedPosition();
        int selectingPosition = this.indicator.isInteractiveAnimation() ? this.indicator.getSelectingPosition() : this.indicator.getSelectedPosition();
        int coordinate = CoordinatesUtils.getCoordinate(this.indicator, selectedPosition);
        int coordinate2 = CoordinatesUtils.getCoordinate(this.indicator, selectingPosition);
        int paddingTop = this.indicator.getPaddingTop();
        int paddingLeft = this.indicator.getPaddingLeft();
        if (this.indicator.getOrientation() != Orientation.HORIZONTAL) {
            paddingTop = paddingLeft;
        }
        int radius = this.indicator.getRadius();
        DropAnimation with = this.valueController.drop().duration(this.indicator.getAnimationDuration()).with(coordinate, coordinate2, (radius * 3) + paddingTop, radius + paddingTop, radius);
        if (this.isInteractive) {
            with.progress(this.progress);
        } else {
            with.start();
        }
        this.runningAnimation = with;
    }

    private void swapAnimation() {
        BaseAnimation duration = this.valueController.swap().with(CoordinatesUtils.getCoordinate(this.indicator, this.indicator.isInteractiveAnimation() ? this.indicator.getSelectedPosition() : this.indicator.getLastSelectedPosition()), CoordinatesUtils.getCoordinate(this.indicator, this.indicator.isInteractiveAnimation() ? this.indicator.getSelectingPosition() : this.indicator.getSelectedPosition())).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void scaleDownAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        int radius = this.indicator.getRadius();
        float scaleFactor = this.indicator.getScaleFactor();
        BaseAnimation duration = this.valueController.scaleDown().with(unselectedColor, selectedColor, radius, scaleFactor).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
}
