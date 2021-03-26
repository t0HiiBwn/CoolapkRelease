package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.ScaleAnimationValue;
import com.rd.draw.data.Indicator;

public class ScaleDrawer extends BaseDrawer {
    public ScaleDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(Canvas canvas, Value value, int i, int i2, int i3) {
        if (value instanceof ScaleAnimationValue) {
            ScaleAnimationValue scaleAnimationValue = (ScaleAnimationValue) value;
            float radius = (float) this.indicator.getRadius();
            int selectedColor = this.indicator.getSelectedColor();
            int selectedPosition = this.indicator.getSelectedPosition();
            int selectingPosition = this.indicator.getSelectingPosition();
            int lastSelectedPosition = this.indicator.getLastSelectedPosition();
            if (this.indicator.isInteractiveAnimation()) {
                if (i == selectingPosition) {
                    radius = (float) scaleAnimationValue.getRadius();
                    selectedColor = scaleAnimationValue.getColor();
                } else if (i == selectedPosition) {
                    radius = (float) scaleAnimationValue.getRadiusReverse();
                    selectedColor = scaleAnimationValue.getColorReverse();
                }
            } else if (i == selectedPosition) {
                radius = (float) scaleAnimationValue.getRadius();
                selectedColor = scaleAnimationValue.getColor();
            } else if (i == lastSelectedPosition) {
                radius = (float) scaleAnimationValue.getRadiusReverse();
                selectedColor = scaleAnimationValue.getColorReverse();
            }
            this.paint.setColor(selectedColor);
            canvas.drawCircle((float) i2, (float) i3, radius, this.paint);
        }
    }
}
