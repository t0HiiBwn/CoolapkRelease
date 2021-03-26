package com.rd.utils;

import android.util.Pair;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class CoordinatesUtils {
    public static int getCoordinate(Indicator indicator, int i) {
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            return getXCoordinate(indicator, i);
        }
        return getYCoordinate(indicator, i);
    }

    public static int getXCoordinate(Indicator indicator, int i) {
        int i2;
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            i2 = getHorizontalCoordinate(indicator, i);
        } else {
            i2 = getVerticalCoordinate(indicator);
        }
        return i2 + indicator.getPaddingLeft();
    }

    public static int getYCoordinate(Indicator indicator, int i) {
        int i2;
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            i2 = getVerticalCoordinate(indicator);
        } else {
            i2 = getHorizontalCoordinate(indicator, i);
        }
        return i2 + indicator.getPaddingTop();
    }

    public static int getPosition(Indicator indicator, float f, float f2) {
        if (indicator == null) {
            return -1;
        }
        if (indicator.getOrientation() != Orientation.HORIZONTAL) {
            f2 = f;
            f = f2;
        }
        return getFitPosition(indicator, f, f2);
    }

    private static int getFitPosition(Indicator indicator, float f, float f2) {
        int i;
        int count = indicator.getCount();
        int radius = indicator.getRadius();
        int stroke = indicator.getStroke();
        int padding = indicator.getPadding();
        int height = indicator.getOrientation() == Orientation.HORIZONTAL ? indicator.getHeight() : indicator.getWidth();
        int i2 = 0;
        int i3 = 0;
        while (i2 < count) {
            if (i2 > 0) {
                i = padding;
            } else {
                i = padding / 2;
            }
            int i4 = (radius * 2) + (stroke / 2) + i + i3;
            boolean z = true;
            boolean z2 = f >= ((float) i3) && f <= ((float) i4);
            if (f2 < 0.0f || f2 > ((float) height)) {
                z = false;
            }
            if (z2 && z) {
                return i2;
            }
            i2++;
            i3 = i4;
        }
        return -1;
    }

    private static int getHorizontalCoordinate(Indicator indicator, int i) {
        int count = indicator.getCount();
        int radius = indicator.getRadius();
        int stroke = indicator.getStroke();
        int padding = indicator.getPadding();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            int i4 = stroke / 2;
            int i5 = i2 + radius + i4;
            if (i == i3) {
                return i5;
            }
            i2 = i5 + radius + padding + i4;
        }
        return indicator.getAnimationType() == AnimationType.DROP ? i2 + (radius * 2) : i2;
    }

    private static int getVerticalCoordinate(Indicator indicator) {
        int radius = indicator.getRadius();
        return indicator.getAnimationType() == AnimationType.DROP ? radius * 3 : radius;
    }

    public static Pair<Integer, Float> getProgress(Indicator indicator, int i, float f, boolean z) {
        int count = indicator.getCount();
        int selectedPosition = indicator.getSelectedPosition();
        if (z) {
            i = (count - 1) - i;
        }
        boolean z2 = false;
        if (i < 0) {
            i = 0;
        } else {
            int i2 = count - 1;
            if (i > i2) {
                i = i2;
            }
        }
        boolean z3 = i > selectedPosition;
        boolean z4 = !z ? i + 1 < selectedPosition : i + -1 < selectedPosition;
        if (z3 || z4) {
            indicator.setSelectedPosition(i);
            selectedPosition = i;
        }
        float f2 = 0.0f;
        if (selectedPosition == i && f != 0.0f) {
            z2 = true;
        }
        if (z2) {
            i = z ? i - 1 : i + 1;
        } else {
            f = 1.0f - f;
        }
        if (f > 1.0f) {
            f2 = 1.0f;
        } else if (f >= 0.0f) {
            f2 = f;
        }
        return new Pair<>(Integer.valueOf(i), Float.valueOf(f2));
    }
}
