package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class BubbleView extends ShapeOfView {
    public static final int POSITION_BOTTOM = 1;
    public static final int POSITION_LEFT = 3;
    public static final int POSITION_RIGHT = 4;
    public static final int POSITION_TOP = 2;
    private float arrowHeightPx;
    private float arrowWidthPx;
    private float borderRadiusPx;
    private float defPositionPer = 0.5f;
    private int position = 1;
    private float positionPer;

    public @interface Position {
    }

    public BubbleView(Context context) {
        super(context);
        init(context, null);
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BubbleView);
            this.borderRadiusPx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.BubbleView_shape_bubble_borderRadius, (int) dpToPx(10.0f));
            this.position = obtainStyledAttributes.getInteger(R.styleable.BubbleView_shape_bubble_arrowPosition, this.position);
            this.arrowHeightPx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.BubbleView_shape_bubble_arrowHeight, (int) dpToPx(10.0f));
            this.arrowWidthPx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.BubbleView_shape_bubble_arrowWidth, (int) dpToPx(10.0f));
            this.positionPer = obtainStyledAttributes.getFloat(R.styleable.BubbleView_arrow_posititon_percent, this.defPositionPer);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.BubbleView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return false;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
                BubbleView bubbleView = BubbleView.this;
                return bubbleView.drawBubble(rectF, bubbleView.borderRadiusPx, BubbleView.this.borderRadiusPx, BubbleView.this.borderRadiusPx, BubbleView.this.borderRadiusPx);
            }
        });
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        requiresShapeUpdate();
    }

    public float getBorderRadius() {
        return this.borderRadiusPx;
    }

    public float getBorderRadiusDp() {
        return pxToDp(getBorderRadius());
    }

    public void setBorderRadius(float f) {
        this.borderRadiusPx = f;
        requiresShapeUpdate();
    }

    public void setBorderRadiusDp(float f) {
        this.borderRadiusPx = dpToPx(f);
        requiresShapeUpdate();
    }

    public float getArrowHeight() {
        return this.arrowHeightPx;
    }

    public float getArrowHeightDp() {
        return pxToDp(getArrowHeight());
    }

    public void setArrowHeight(float f) {
        this.arrowHeightPx = f;
        requiresShapeUpdate();
    }

    public void setArrowHeightDp(float f) {
        setArrowHeight(dpToPx(f));
    }

    public float getArrowWidth() {
        return this.arrowWidthPx;
    }

    public void setArrowWidth(float f) {
        this.arrowWidthPx = f;
        requiresShapeUpdate();
    }

    public void setArrowWidthDp(float f) {
        setArrowWidth(dpToPx(f));
    }

    public void setPositionPer(float f) {
        this.positionPer = f;
        requiresShapeUpdate();
    }

    /* access modifiers changed from: private */
    public Path drawBubble(RectF rectF, float f, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = 0.0f;
        float f6 = f < 0.0f ? 0.0f : f;
        float f7 = f2 < 0.0f ? 0.0f : f2;
        float f8 = f4 < 0.0f ? 0.0f : f4;
        float f9 = f3 < 0.0f ? 0.0f : f3;
        int i = this.position;
        float f10 = i == 3 ? this.arrowHeightPx : 0.0f;
        float f11 = i == 2 ? this.arrowHeightPx : 0.0f;
        float f12 = i == 4 ? this.arrowHeightPx : 0.0f;
        if (i == 1) {
            f5 = this.arrowHeightPx;
        }
        float f13 = f10 + rectF.left;
        float f14 = f11 + rectF.top;
        float f15 = rectF.right - f12;
        float f16 = rectF.bottom - f5;
        float f17 = (rectF.left + rectF.right) * this.positionPer;
        float f18 = f6 / 2.0f;
        float f19 = f13 + f18;
        path.moveTo(f19, f14);
        if (this.position == 2) {
            path.lineTo(f17 - this.arrowWidthPx, f14);
            path.lineTo(f17, rectF.top);
            path.lineTo(this.arrowWidthPx + f17, f14);
        }
        float f20 = f7 / 2.0f;
        path.lineTo(f15 - f20, f14);
        path.quadTo(f15, f14, f15, f20 + f14);
        if (this.position == 4) {
            path.lineTo(f15, (f16 - ((1.0f - this.positionPer) * f16)) - this.arrowWidthPx);
            path.lineTo(rectF.right, f16 - ((1.0f - this.positionPer) * f16));
            path.lineTo(f15, (f16 - ((1.0f - this.positionPer) * f16)) + this.arrowWidthPx);
        }
        float f21 = f9 / 2.0f;
        path.lineTo(f15, f16 - f21);
        path.quadTo(f15, f16, f15 - f21, f16);
        if (this.position == 1) {
            path.lineTo(this.arrowWidthPx + f17, f16);
            path.lineTo(f17, rectF.bottom);
            path.lineTo(f17 - this.arrowWidthPx, f16);
        }
        float f22 = f8 / 2.0f;
        path.lineTo(f13 + f22, f16);
        path.quadTo(f13, f16, f13, f16 - f22);
        if (this.position == 3) {
            path.lineTo(f13, (f16 - ((1.0f - this.positionPer) * f16)) + this.arrowWidthPx);
            path.lineTo(rectF.left, f16 - ((1.0f - this.positionPer) * f16));
            path.lineTo(f13, (f16 - ((1.0f - this.positionPer) * f16)) - this.arrowWidthPx);
        }
        path.lineTo(f13, f18 + f14);
        path.quadTo(f13, f14, f19, f14);
        path.close();
        return path;
    }
}
