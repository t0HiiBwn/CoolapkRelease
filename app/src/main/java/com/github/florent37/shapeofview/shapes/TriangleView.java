package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class TriangleView extends ShapeOfView {
    private float percentBottom = 0.5f;
    private float percentLeft = 0.0f;
    private float percentRight = 0.0f;

    public TriangleView(Context context) {
        super(context);
        init(context, null);
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TriangleView);
            this.percentBottom = obtainStyledAttributes.getFloat(R.styleable.TriangleView_shape_triangle_percentBottom, this.percentBottom);
            this.percentLeft = obtainStyledAttributes.getFloat(R.styleable.TriangleView_shape_triangle_percentLeft, this.percentLeft);
            this.percentRight = obtainStyledAttributes.getFloat(R.styleable.TriangleView_shape_triangle_percentRight, this.percentRight);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.TriangleView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return false;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                Path path = new Path();
                float f = (float) i2;
                path.moveTo(0.0f, TriangleView.this.percentLeft * f);
                float f2 = (float) i;
                path.lineTo(TriangleView.this.percentBottom * f2, f);
                path.lineTo(f2, TriangleView.this.percentRight * f);
                path.close();
                return path;
            }
        });
    }

    public float getPercentBottom() {
        return this.percentBottom;
    }

    public void setPercentBottom(float f) {
        this.percentBottom = f;
        requiresShapeUpdate();
    }

    public float getPercentLeft() {
        return this.percentLeft;
    }

    public void setPercentLeft(float f) {
        this.percentLeft = f;
        requiresShapeUpdate();
    }

    public float getPercentRight() {
        return this.percentRight;
    }

    public void setPercentRight(float f) {
        this.percentRight = f;
        requiresShapeUpdate();
    }
}
