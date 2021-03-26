package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class DottedEdgesCutCornerView extends ShapeOfView {
    public static final int POSITION_BOTTOM = 1;
    public static final int POSITION_LEFT = 4;
    public static final int POSITION_NONE = 0;
    public static final int POSITION_RIGHT = 8;
    public static final int POSITION_TOP = 2;
    private float bottomLeftCutSize = 0.0f;
    private float bottomRightCutSize = 0.0f;
    private int dotEdgePosition;
    private float dotRadius = 0.0f;
    private float dotSpacing = 0.0f;
    private final RectF rectF = new RectF();
    private float topLeftCutSize = 0.0f;
    private float topRightCutSize = 0.0f;

    public DottedEdgesCutCornerView(Context context) {
        super(context);
        init(context, null);
    }

    public DottedEdgesCutCornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public DottedEdgesCutCornerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DottedEdgesCutCornerView);
            this.topLeftCutSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.DottedEdgesCutCornerView_shape_dottedEdgesCutCorner_topLeftSize, (int) this.topLeftCutSize);
            this.topRightCutSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.DottedEdgesCutCornerView_shape_dottedEdgesCutCorner_topRightSize, (int) this.topRightCutSize);
            this.bottomLeftCutSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.DottedEdgesCutCornerView_shape_dottedEdgesCutCorner_bottomLeftSize, (int) this.bottomLeftCutSize);
            this.bottomRightCutSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.DottedEdgesCutCornerView_shape_dottedEdgesCutCorner_bottomRightSize, (int) this.bottomRightCutSize);
            this.dotEdgePosition = obtainStyledAttributes.getInteger(R.styleable.DottedEdgesCutCornerView_shape_edge_position, 0);
            this.dotRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.DottedEdgesCutCornerView_shape_dot_radius, (int) this.dotRadius);
            this.dotSpacing = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.DottedEdgesCutCornerView_shape_dot_spacing, (int) this.dotSpacing);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.DottedEdgesCutCornerView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return false;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                DottedEdgesCutCornerView.this.rectF.set(0.0f, 0.0f, (float) i, (float) i2);
                DottedEdgesCutCornerView dottedEdgesCutCornerView = DottedEdgesCutCornerView.this;
                return dottedEdgesCutCornerView.generatePath(dottedEdgesCutCornerView.rectF, DottedEdgesCutCornerView.this.topLeftCutSize, DottedEdgesCutCornerView.this.topRightCutSize, DottedEdgesCutCornerView.this.bottomRightCutSize, DottedEdgesCutCornerView.this.bottomLeftCutSize);
            }
        });
    }

    /* access modifiers changed from: private */
    public Path generatePath(RectF rectF2, float f, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = 0.0f;
        float f6 = f < 0.0f ? 0.0f : f;
        float f7 = f2 < 0.0f ? 0.0f : f2;
        float f8 = f4 < 0.0f ? 0.0f : f4;
        if (f3 >= 0.0f) {
            f5 = f3;
        }
        path.moveTo(rectF2.left + f6, rectF2.top);
        if (containsFlag(2)) {
            int i = (int) (rectF2.left + f6 + (this.dotSpacing * ((float) 1)) + (this.dotRadius * 2.0f * ((float) 0)));
            int i2 = 1;
            while (((float) i) + this.dotSpacing + (this.dotRadius * 2.0f) <= rectF2.right - f7) {
                i = (int) (rectF2.left + f6 + (this.dotSpacing * ((float) i2)) + (this.dotRadius * 2.0f * ((float) (i2 - 1))));
                float f9 = (float) i;
                path.lineTo(f9, rectF2.top);
                float f10 = rectF2.top;
                float f11 = this.dotRadius;
                path.quadTo(this.dotRadius + f9, f10 + f11, f9 + (f11 * 2.0f), rectF2.top);
                i2++;
            }
            path.lineTo(rectF2.right - f7, rectF2.top);
        } else {
            path.lineTo(rectF2.right - f7, rectF2.top);
        }
        path.lineTo(rectF2.right, rectF2.top + f7);
        if (containsFlag(8)) {
            path.lineTo(rectF2.right - this.dotRadius, rectF2.top + f7);
            path.lineTo(rectF2.right - this.dotRadius, rectF2.bottom - f5);
            path.lineTo(rectF2.right, rectF2.bottom - f5);
            int i3 = (int) (((rectF2.bottom - f5) - (this.dotSpacing * ((float) 1))) - ((this.dotRadius * 2.0f) * ((float) 0)));
            int i4 = 1;
            while ((((float) i3) - this.dotSpacing) - (this.dotRadius * 2.0f) >= rectF2.top + f7) {
                i3 = (int) (((rectF2.bottom - f5) - (this.dotSpacing * ((float) i4))) - ((this.dotRadius * 2.0f) * ((float) (i4 - 1))));
                float f12 = (float) i3;
                path.lineTo(rectF2.right, f12);
                float f13 = rectF2.right;
                float f14 = this.dotRadius;
                path.quadTo(f13 - f14, f12 - f14, rectF2.right, f12 - (this.dotRadius * 2.0f));
                i4++;
            }
            path.lineTo(rectF2.right, rectF2.top + f7);
            path.lineTo(rectF2.right - this.dotRadius, rectF2.top + f7);
            path.lineTo(rectF2.right - this.dotRadius, rectF2.bottom - f5);
            path.lineTo(rectF2.right, rectF2.bottom - f5);
        } else {
            path.lineTo(rectF2.right, rectF2.bottom - f5);
        }
        path.lineTo(rectF2.right - f5, rectF2.bottom);
        if (containsFlag(1)) {
            int i5 = (int) (((rectF2.right - f5) - (this.dotSpacing * ((float) 1))) - ((this.dotRadius * 2.0f) * ((float) 0)));
            int i6 = 1;
            while ((((float) i5) - this.dotSpacing) - (this.dotRadius * 2.0f) >= rectF2.left + f8) {
                i5 = (int) (((rectF2.right - f5) - (this.dotSpacing * ((float) i6))) - ((this.dotRadius * 2.0f) * ((float) (i6 - 1))));
                float f15 = (float) i5;
                path.lineTo(f15, rectF2.bottom);
                float f16 = rectF2.bottom;
                float f17 = this.dotRadius;
                path.quadTo(f15 - this.dotRadius, f16 - f17, f15 - (f17 * 2.0f), rectF2.bottom);
                i6++;
            }
            path.lineTo(rectF2.left + f8, rectF2.bottom);
        } else {
            path.lineTo(rectF2.left + f8, rectF2.bottom);
        }
        path.lineTo(rectF2.left, rectF2.bottom - f8);
        if (containsFlag(4)) {
            int i7 = (int) (((rectF2.bottom - f8) - (this.dotSpacing * ((float) 1))) - ((this.dotRadius * 2.0f) * ((float) 0)));
            int i8 = 1;
            while ((((float) i7) - this.dotSpacing) - (this.dotRadius * 2.0f) >= rectF2.top + f6) {
                i7 = (int) (((rectF2.bottom - f8) - (this.dotSpacing * ((float) i8))) - ((this.dotRadius * 2.0f) * ((float) (i8 - 1))));
                float f18 = (float) i7;
                path.lineTo(rectF2.left, f18);
                float f19 = rectF2.left;
                float f20 = this.dotRadius;
                path.quadTo(f19 + f20, f18 - f20, rectF2.left, f18 - (this.dotRadius * 2.0f));
                i8++;
            }
            path.lineTo(rectF2.left, rectF2.top + f6);
        } else {
            path.lineTo(rectF2.left, rectF2.top + f6);
        }
        path.lineTo(rectF2.left + f6, rectF2.top);
        path.close();
        return path;
    }

    private boolean containsFlag(int i) {
        int i2 = this.dotEdgePosition;
        return (i | i2) == i2;
    }

    public float getTopLeftCutSize() {
        return this.topLeftCutSize;
    }

    public void setTopLeftCutSize(float f) {
        this.topLeftCutSize = f;
        requiresShapeUpdate();
    }

    public float getTopLeftCutSizeDp() {
        return pxToDp(getTopLeftCutSize());
    }

    public void setTopLeftCutSizeDp(float f) {
        setTopLeftCutSize(dpToPx(f));
    }

    public float getTopRightCutSize() {
        return this.topRightCutSize;
    }

    public void setTopRightCutSize(float f) {
        this.topRightCutSize = f;
        requiresShapeUpdate();
    }

    public float getTopRightCutSizeDp() {
        return pxToDp(getTopRightCutSize());
    }

    public void setTopRightCutSizeDp(float f) {
        setTopRightCutSize(dpToPx(f));
    }

    public float getBottomRightCutSize() {
        return this.bottomRightCutSize;
    }

    public void setBottomRightCutSize(float f) {
        this.bottomRightCutSize = f;
        requiresShapeUpdate();
    }

    public float getBottomRightCutSizeDp() {
        return pxToDp(getBottomRightCutSize());
    }

    public void setBottomRightCutSizeDp(float f) {
        setBottomRightCutSize(dpToPx(f));
    }

    public float getBottomLeftCutSize() {
        return this.bottomLeftCutSize;
    }

    public void setBottomLeftCutSize(float f) {
        this.bottomLeftCutSize = f;
        requiresShapeUpdate();
    }

    public float getBottomLeftCutSizeDp() {
        return pxToDp(getBottomLeftCutSize());
    }

    public void setBottomLeftCutSizeDp(float f) {
        setBottomLeftCutSize(dpToPx(f));
    }

    public int getDotEdgePosition() {
        return this.dotEdgePosition;
    }

    public void addDotEdgePosition(int i) {
        this.dotEdgePosition = i | this.dotEdgePosition;
        requiresShapeUpdate();
    }

    public float getDotRadius() {
        return this.dotRadius;
    }

    public void setDotRadius(float f) {
        this.dotRadius = f;
        requiresShapeUpdate();
    }

    public float getDotRadiusDp() {
        return pxToDp(getDotRadius());
    }

    public void setDotRadiusDp(float f) {
        setDotRadius(dpToPx(f));
    }

    public float getDotSpacing() {
        return this.dotSpacing;
    }

    public void setDotSpacing(float f) {
        this.dotSpacing = f;
        requiresShapeUpdate();
    }

    public float getDotSpacingDp() {
        return pxToDp(this.dotSpacing);
    }

    public void setDotSpacingDp(float f) {
        setDotRadius(dpToPx(f));
    }
}
