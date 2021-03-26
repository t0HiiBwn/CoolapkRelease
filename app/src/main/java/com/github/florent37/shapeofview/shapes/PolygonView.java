package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class PolygonView extends ShapeOfView {
    private int numberOfSides = 4;

    public PolygonView(Context context) {
        super(context);
        init(context, null);
    }

    public PolygonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PolygonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PolygonView);
            int integer = obtainStyledAttributes.getInteger(R.styleable.PolygonView_shape_polygon_noOfSides, this.numberOfSides);
            if (integer <= 3) {
                integer = this.numberOfSides;
            }
            this.numberOfSides = integer;
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.PolygonView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return true;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                float f = (float) (6.283185307179586d / ((double) PolygonView.this.numberOfSides));
                Path path = new Path();
                float f2 = (float) (i / 2);
                float min = (float) (Math.min(i, i2) / 2);
                float f3 = (float) (i2 / 2);
                path.moveTo((((float) Math.cos(0.0d)) * min) + f2, (((float) Math.sin(0.0d)) * min) + f3);
                for (int i3 = 1; i3 < PolygonView.this.numberOfSides; i3++) {
                    double d = (double) (((float) i3) * f);
                    path.lineTo((((float) Math.cos(d)) * min) + f2, (((float) Math.sin(d)) * min) + f3);
                }
                path.close();
                return path;
            }
        });
    }

    public int getNoOfSides() {
        return this.numberOfSides;
    }

    public void setNoOfSides(int i) {
        this.numberOfSides = i;
        requiresShapeUpdate();
    }
}
