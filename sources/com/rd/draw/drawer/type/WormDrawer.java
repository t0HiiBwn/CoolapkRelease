package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.WormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class WormDrawer extends BaseDrawer {
    public RectF rect = new RectF();

    public WormDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(Canvas canvas, Value value, int i, int i2) {
        if (value instanceof WormAnimationValue) {
            WormAnimationValue wormAnimationValue = (WormAnimationValue) value;
            int rectStart = wormAnimationValue.getRectStart();
            int rectEnd = wormAnimationValue.getRectEnd();
            int radius = this.indicator.getRadius();
            int unselectedColor = this.indicator.getUnselectedColor();
            int selectedColor = this.indicator.getSelectedColor();
            if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
                this.rect.left = (float) rectStart;
                this.rect.right = (float) rectEnd;
                this.rect.top = (float) (i2 - radius);
                this.rect.bottom = (float) (i2 + radius);
            } else {
                this.rect.left = (float) (i - radius);
                this.rect.right = (float) (i + radius);
                this.rect.top = (float) rectStart;
                this.rect.bottom = (float) rectEnd;
            }
            this.paint.setColor(unselectedColor);
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = (float) radius;
            canvas.drawCircle(f, f2, f3, this.paint);
            this.paint.setColor(selectedColor);
            canvas.drawRoundRect(this.rect, f3, f3, this.paint);
        }
    }
}
