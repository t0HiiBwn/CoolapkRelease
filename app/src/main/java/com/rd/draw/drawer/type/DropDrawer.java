package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.DropAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class DropDrawer extends BaseDrawer {
    public DropDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(Canvas canvas, Value value, int i, int i2) {
        if (value instanceof DropAnimationValue) {
            DropAnimationValue dropAnimationValue = (DropAnimationValue) value;
            int unselectedColor = this.indicator.getUnselectedColor();
            int selectedColor = this.indicator.getSelectedColor();
            this.paint.setColor(unselectedColor);
            canvas.drawCircle((float) i, (float) i2, (float) this.indicator.getRadius(), this.paint);
            this.paint.setColor(selectedColor);
            if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
                canvas.drawCircle((float) dropAnimationValue.getWidth(), (float) dropAnimationValue.getHeight(), (float) dropAnimationValue.getRadius(), this.paint);
            } else {
                canvas.drawCircle((float) dropAnimationValue.getHeight(), (float) dropAnimationValue.getWidth(), (float) dropAnimationValue.getRadius(), this.paint);
            }
        }
    }
}
