package com.rd.draw.controller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.RtlMode;
import com.rd.pageindicatorview.R;
import com.rd.utils.DensityUtils;

public class AttributeController {
    private Indicator indicator;

    public AttributeController(Indicator indicator2) {
        this.indicator = indicator2;
    }

    public void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageIndicatorView, 0, 0);
        initCountAttribute(obtainStyledAttributes);
        initColorAttribute(obtainStyledAttributes);
        initAnimationAttribute(obtainStyledAttributes);
        initSizeAttribute(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void initCountAttribute(TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(R.styleable.PageIndicatorView_piv_viewPager, -1);
        boolean z = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_autoVisibility, true);
        int i = 0;
        boolean z2 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_dynamicCount, false);
        int i2 = typedArray.getInt(R.styleable.PageIndicatorView_piv_count, -1);
        if (i2 == -1) {
            i2 = 3;
        }
        int i3 = typedArray.getInt(R.styleable.PageIndicatorView_piv_select, 0);
        if (i3 >= 0 && (i2 <= 0 || i3 <= i2 - 1)) {
            i = i3;
        }
        this.indicator.setViewPagerId(resourceId);
        this.indicator.setAutoVisibility(z);
        this.indicator.setDynamicCount(z2);
        this.indicator.setCount(i2);
        this.indicator.setSelectedPosition(i);
        this.indicator.setSelectingPosition(i);
        this.indicator.setLastSelectedPosition(i);
    }

    private void initColorAttribute(TypedArray typedArray) {
        int color = typedArray.getColor(R.styleable.PageIndicatorView_piv_unselectedColor, Color.parseColor("#33ffffff"));
        int color2 = typedArray.getColor(R.styleable.PageIndicatorView_piv_selectedColor, Color.parseColor("#ffffff"));
        this.indicator.setUnselectedColor(color);
        this.indicator.setSelectedColor(color2);
    }

    private void initAnimationAttribute(TypedArray typedArray) {
        int i = 0;
        boolean z = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_interactiveAnimation, false);
        int i2 = typedArray.getInt(R.styleable.PageIndicatorView_piv_animationDuration, 350);
        if (i2 >= 0) {
            i = i2;
        }
        AnimationType animationType = getAnimationType(typedArray.getInt(R.styleable.PageIndicatorView_piv_animationType, AnimationType.NONE.ordinal()));
        RtlMode rtlMode = getRtlMode(typedArray.getInt(R.styleable.PageIndicatorView_piv_rtl_mode, RtlMode.Off.ordinal()));
        this.indicator.setAnimationDuration((long) i);
        this.indicator.setInteractiveAnimation(z);
        this.indicator.setAnimationType(animationType);
        this.indicator.setRtlMode(rtlMode);
    }

    private void initSizeAttribute(TypedArray typedArray) {
        Orientation orientation;
        if (typedArray.getInt(R.styleable.PageIndicatorView_piv_orientation, Orientation.HORIZONTAL.ordinal()) == 0) {
            orientation = Orientation.HORIZONTAL;
        } else {
            orientation = Orientation.VERTICAL;
        }
        int dimension = (int) typedArray.getDimension(R.styleable.PageIndicatorView_piv_radius, (float) DensityUtils.dpToPx(6));
        int i = 0;
        if (dimension < 0) {
            dimension = 0;
        }
        int dimension2 = (int) typedArray.getDimension(R.styleable.PageIndicatorView_piv_padding, (float) DensityUtils.dpToPx(8));
        if (dimension2 < 0) {
            dimension2 = 0;
        }
        float f = typedArray.getFloat(R.styleable.PageIndicatorView_piv_scaleFactor, 0.7f);
        if (f < 0.3f) {
            f = 0.3f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        int dimension3 = (int) typedArray.getDimension(R.styleable.PageIndicatorView_piv_strokeWidth, (float) DensityUtils.dpToPx(1));
        if (dimension3 > dimension) {
            dimension3 = dimension;
        }
        if (this.indicator.getAnimationType() == AnimationType.FILL) {
            i = dimension3;
        }
        this.indicator.setRadius(dimension);
        this.indicator.setOrientation(orientation);
        this.indicator.setPadding(dimension2);
        this.indicator.setScaleFactor(f);
        this.indicator.setStroke(i);
    }

    private AnimationType getAnimationType(int i) {
        switch (i) {
            case 0:
                return AnimationType.NONE;
            case 1:
                return AnimationType.COLOR;
            case 2:
                return AnimationType.SCALE;
            case 3:
                return AnimationType.WORM;
            case 4:
                return AnimationType.SLIDE;
            case 5:
                return AnimationType.FILL;
            case 6:
                return AnimationType.THIN_WORM;
            case 7:
                return AnimationType.DROP;
            case 8:
                return AnimationType.SWAP;
            case 9:
                return AnimationType.SCALE_DOWN;
            default:
                return AnimationType.NONE;
        }
    }

    private RtlMode getRtlMode(int i) {
        if (i == 0) {
            return RtlMode.On;
        }
        if (i == 1) {
            return RtlMode.Off;
        }
        if (i != 2) {
            return RtlMode.Auto;
        }
        return RtlMode.Auto;
    }
}
