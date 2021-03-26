package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class CutCornerView extends ShapeOfView {
    private float bottomLeftCutSizePx = 0.0f;
    private float bottomRightCutSizePx = 0.0f;
    private final RectF rectF = new RectF();
    private float topLeftCutSizePx = 0.0f;
    private float topRightCutSizePx = 0.0f;

    public CutCornerView(Context context) {
        super(context);
        init(context, null);
    }

    public CutCornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public CutCornerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CutCornerView);
            this.topLeftCutSizePx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CutCornerView_shape_cutCorner_topLeftSize, (int) this.topLeftCutSizePx);
            this.topRightCutSizePx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CutCornerView_shape_cutCorner_topRightSize, (int) this.topRightCutSizePx);
            this.bottomLeftCutSizePx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CutCornerView_shape_cutCorner_bottomLeftSize, (int) this.bottomLeftCutSizePx);
            this.bottomRightCutSizePx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CutCornerView_shape_cutCorner_bottomRightSize, (int) this.bottomRightCutSizePx);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.CutCornerView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return false;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                CutCornerView.this.rectF.set(0.0f, 0.0f, (float) i, (float) i2);
                CutCornerView cutCornerView = CutCornerView.this;
                return cutCornerView.generatePath(cutCornerView.rectF, CutCornerView.this.topLeftCutSizePx, CutCornerView.this.topRightCutSizePx, CutCornerView.this.bottomRightCutSizePx, CutCornerView.this.bottomLeftCutSizePx);
            }
        });
    }

    /* access modifiers changed from: private */
    public Path generatePath(RectF rectF2, float f, float f2, float f3, float f4) {
        Path path = new Path();
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        path.moveTo(rectF2.left + f, rectF2.top);
        path.lineTo(rectF2.right - f2, rectF2.top);
        path.lineTo(rectF2.right, rectF2.top + f2);
        path.lineTo(rectF2.right, rectF2.bottom - f3);
        path.lineTo(rectF2.right - f3, rectF2.bottom);
        path.lineTo(rectF2.left + f4, rectF2.bottom);
        path.lineTo(rectF2.left, rectF2.bottom - f4);
        path.lineTo(rectF2.left, rectF2.top + f);
        path.lineTo(rectF2.left + f, rectF2.top);
        path.close();
        return path;
    }

    public float getTopLeftCutSize() {
        return this.topLeftCutSizePx;
    }

    public void setTopLeftCutSize(float f) {
        this.topLeftCutSizePx = f;
        requiresShapeUpdate();
    }

    public float getTopLeftCutSizeDp() {
        return pxToDp(getTopLeftCutSize());
    }

    public void setTopLeftCutSizeDp(float f) {
        setTopLeftCutSize(dpToPx(f));
    }

    public float getTopRightCutSize() {
        return this.topRightCutSizePx;
    }

    public void setTopRightCutSize(float f) {
        this.topRightCutSizePx = f;
        requiresShapeUpdate();
    }

    public float getTopRightCutSizeDp() {
        return pxToDp(getTopRightCutSize());
    }

    public void setTopRightCutSizeDp(float f) {
        setTopRightCutSize(dpToPx(f));
    }

    public float getBottomRightCutSize() {
        return this.bottomRightCutSizePx;
    }

    public void setBottomRightCutSize(float f) {
        this.bottomRightCutSizePx = f;
        requiresShapeUpdate();
    }

    public float getBottomRightCutSizeDp() {
        return pxToDp(getBottomRightCutSize());
    }

    public void setBottomRightCutSizeDp(float f) {
        setBottomRightCutSize(dpToPx(f));
    }

    public float getBottomLeftCutSize() {
        return this.bottomLeftCutSizePx;
    }

    public void setBottomLeftCutSize(float f) {
        this.bottomLeftCutSizePx = f;
        requiresShapeUpdate();
    }

    public float getBottomLeftCutSizeDp() {
        return pxToDp(getBottomLeftCutSize());
    }

    public void setBottomLeftCutSizeDp(float f) {
        setBottomLeftCutSize(dpToPx(f));
    }
}
