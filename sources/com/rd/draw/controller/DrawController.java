package com.rd.draw.controller;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.rd.animation.data.Value;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.Drawer;
import com.rd.utils.CoordinatesUtils;

public class DrawController {
    private Drawer drawer;
    private Indicator indicator;
    private ClickListener listener;
    private Value value;

    public interface ClickListener {
        void onIndicatorClicked(int i);
    }

    public DrawController(Indicator indicator2) {
        this.indicator = indicator2;
        this.drawer = new Drawer(indicator2);
    }

    public void updateValue(Value value2) {
        this.value = value2;
    }

    public void setClickListener(ClickListener clickListener) {
        this.listener = clickListener;
    }

    public void touch(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            onIndicatorTouched(motionEvent.getX(), motionEvent.getY());
        }
    }

    private void onIndicatorTouched(float f, float f2) {
        int position;
        if (this.listener != null && (position = CoordinatesUtils.getPosition(this.indicator, f, f2)) >= 0) {
            this.listener.onIndicatorClicked(position);
        }
    }

    public void draw(Canvas canvas) {
        int count = this.indicator.getCount();
        for (int i = 0; i < count; i++) {
            drawIndicator(canvas, i, CoordinatesUtils.getXCoordinate(this.indicator, i), CoordinatesUtils.getYCoordinate(this.indicator, i));
        }
    }

    private void drawIndicator(Canvas canvas, int i, int i2, int i3) {
        boolean isInteractiveAnimation = this.indicator.isInteractiveAnimation();
        int selectedPosition = this.indicator.getSelectedPosition();
        int selectingPosition = this.indicator.getSelectingPosition();
        boolean z = true;
        boolean z2 = !isInteractiveAnimation && (i == selectedPosition || i == this.indicator.getLastSelectedPosition());
        if (!isInteractiveAnimation || !(i == selectedPosition || i == selectingPosition)) {
            z = false;
        }
        boolean z3 = z2 | z;
        this.drawer.setup(i, i2, i3);
        if (this.value == null || !z3) {
            this.drawer.drawBasic(canvas, z3);
        } else {
            drawWithAnimation(canvas);
        }
    }

    /* renamed from: com.rd.draw.controller.DrawController$1  reason: invalid class name */
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
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rd$animation$type$AnimationType[AnimationType.FILL.ordinal()] = 6;
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

    private void drawWithAnimation(Canvas canvas) {
        switch (AnonymousClass1.$SwitchMap$com$rd$animation$type$AnimationType[this.indicator.getAnimationType().ordinal()]) {
            case 1:
                this.drawer.drawBasic(canvas, true);
                return;
            case 2:
                this.drawer.drawColor(canvas, this.value);
                return;
            case 3:
                this.drawer.drawScale(canvas, this.value);
                return;
            case 4:
                this.drawer.drawWorm(canvas, this.value);
                return;
            case 5:
                this.drawer.drawSlide(canvas, this.value);
                return;
            case 6:
                this.drawer.drawFill(canvas, this.value);
                return;
            case 7:
                this.drawer.drawThinWorm(canvas, this.value);
                return;
            case 8:
                this.drawer.drawDrop(canvas, this.value);
                return;
            case 9:
                this.drawer.drawSwap(canvas, this.value);
                return;
            case 10:
                this.drawer.drawScaleDown(canvas, this.value);
                return;
            default:
                return;
        }
    }
}
