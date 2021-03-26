package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.FillAnimationValue;
import com.rd.draw.data.Indicator;

public class FillDrawer extends BaseDrawer {
    private Paint strokePaint;

    public FillDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
        Paint paint2 = new Paint();
        this.strokePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.strokePaint.setAntiAlias(true);
    }

    public void draw(Canvas canvas, Value value, int i, int i2, int i3) {
        if (value instanceof FillAnimationValue) {
            FillAnimationValue fillAnimationValue = (FillAnimationValue) value;
            int unselectedColor = this.indicator.getUnselectedColor();
            float radius = (float) this.indicator.getRadius();
            int stroke = this.indicator.getStroke();
            int selectedPosition = this.indicator.getSelectedPosition();
            int selectingPosition = this.indicator.getSelectingPosition();
            int lastSelectedPosition = this.indicator.getLastSelectedPosition();
            if (this.indicator.isInteractiveAnimation()) {
                if (i == selectingPosition) {
                    unselectedColor = fillAnimationValue.getColor();
                    radius = (float) fillAnimationValue.getRadius();
                    stroke = fillAnimationValue.getStroke();
                } else if (i == selectedPosition) {
                    unselectedColor = fillAnimationValue.getColorReverse();
                    radius = (float) fillAnimationValue.getRadiusReverse();
                    stroke = fillAnimationValue.getStrokeReverse();
                }
            } else if (i == selectedPosition) {
                unselectedColor = fillAnimationValue.getColor();
                radius = (float) fillAnimationValue.getRadius();
                stroke = fillAnimationValue.getStroke();
            } else if (i == lastSelectedPosition) {
                unselectedColor = fillAnimationValue.getColorReverse();
                radius = (float) fillAnimationValue.getRadiusReverse();
                stroke = fillAnimationValue.getStrokeReverse();
            }
            this.strokePaint.setColor(unselectedColor);
            this.strokePaint.setStrokeWidth((float) this.indicator.getStroke());
            float f = (float) i2;
            float f2 = (float) i3;
            canvas.drawCircle(f, f2, (float) this.indicator.getRadius(), this.strokePaint);
            this.strokePaint.setStrokeWidth((float) stroke);
            canvas.drawCircle(f, f2, radius, this.strokePaint);
        }
    }
}
