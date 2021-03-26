package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class StarView extends ShapeOfView {
    private int noOfPoints = 5;

    public StarView(Context context) {
        super(context);
        init(context, null);
    }

    public StarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public StarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StarView);
            int integer = obtainStyledAttributes.getInteger(R.styleable.StarView_shape_star_noOfPoints, this.noOfPoints);
            if (integer <= 2) {
                integer = this.noOfPoints;
            }
            this.noOfPoints = integer;
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.StarView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return true;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                int i3 = StarView.this.noOfPoints * 2;
                float f = 6.2831855f / ((float) i3);
                int i4 = (i2 <= i ? i2 : i) / 2;
                float f2 = (float) (i / 2);
                float f3 = (float) (i2 / 2);
                Path path = new Path();
                for (int i5 = i3 + 1; i5 != 0; i5--) {
                    double d = (double) (((float) i5) * f);
                    double d2 = (double) ((float) ((((i5 % 2) + 1) * i4) / 2));
                    path.lineTo(((float) (Math.sin(d) * d2)) + f2, ((float) (d2 * Math.cos(d))) + f3);
                }
                path.close();
                return path;
            }
        });
    }

    public void setNoOfPoints(int i) {
        this.noOfPoints = i;
        requiresShapeUpdate();
    }

    public int getNoOfPoints() {
        return this.noOfPoints;
    }
}
