package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.SwapAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class SwapDrawer extends BaseDrawer {
    public SwapDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    public void draw(Canvas canvas, Value value, int i, int i2, int i3) {
        if (value instanceof SwapAnimationValue) {
            SwapAnimationValue swapAnimationValue = (SwapAnimationValue) value;
            int selectedColor = this.indicator.getSelectedColor();
            int unselectedColor = this.indicator.getUnselectedColor();
            int radius = this.indicator.getRadius();
            int selectedPosition = this.indicator.getSelectedPosition();
            int selectingPosition = this.indicator.getSelectingPosition();
            int lastSelectedPosition = this.indicator.getLastSelectedPosition();
            int coordinate = swapAnimationValue.getCoordinate();
            if (this.indicator.isInteractiveAnimation()) {
                if (i == selectingPosition) {
                    coordinate = swapAnimationValue.getCoordinate();
                    this.paint.setColor(selectedColor);
                    if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
                        canvas.drawCircle((float) coordinate, (float) i3, (float) radius, this.paint);
                        return;
                    } else {
                        canvas.drawCircle((float) i2, (float) coordinate, (float) radius, this.paint);
                        return;
                    }
                } else if (i == selectedPosition) {
                    coordinate = swapAnimationValue.getCoordinateReverse();
                }
            } else if (i == lastSelectedPosition) {
                coordinate = swapAnimationValue.getCoordinate();
                this.paint.setColor(selectedColor);
                if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
                }
            } else if (i == selectedPosition) {
                coordinate = swapAnimationValue.getCoordinateReverse();
            }
            selectedColor = unselectedColor;
            this.paint.setColor(selectedColor);
            if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
            }
        }
    }
}
