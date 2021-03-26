package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class ArcView extends ShapeOfView {
    public static final int CROP_INSIDE = 1;
    public static final int CROP_OUTSIDE = 2;
    public static final int POSITION_BOTTOM = 1;
    public static final int POSITION_LEFT = 3;
    public static final int POSITION_RIGHT = 4;
    public static final int POSITION_TOP = 2;
    private float arcHeightPx = 0.0f;
    private int arcPosition = 2;

    public @interface ArcPosition {
    }

    public @interface CropDirection {
    }

    public ArcView(Context context) {
        super(context);
        init(context, null);
    }

    public ArcView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ArcView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcView);
            this.arcHeightPx = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ArcView_shape_arc_height, (int) this.arcHeightPx);
            this.arcPosition = obtainStyledAttributes.getInteger(R.styleable.ArcView_shape_arc_position, this.arcPosition);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.ArcView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return false;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                Path path = new Path();
                boolean z = ArcView.this.getCropDirection() == 1;
                float abs = Math.abs(ArcView.this.arcHeightPx);
                int i3 = ArcView.this.arcPosition;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                if (z) {
                                    path.moveTo(0.0f, 0.0f);
                                    float f = (float) i;
                                    path.lineTo(f, 0.0f);
                                    float f2 = (float) i2;
                                    path.quadTo(f - (abs * 2.0f), (float) (i2 / 2), f, f2);
                                    path.lineTo(0.0f, f2);
                                    path.close();
                                } else {
                                    path.moveTo(0.0f, 0.0f);
                                    float f3 = (float) i;
                                    float f4 = f3 - abs;
                                    path.lineTo(f4, 0.0f);
                                    float f5 = (float) i2;
                                    path.quadTo(f3 + abs, (float) (i2 / 2), f4, f5);
                                    path.lineTo(0.0f, f5);
                                    path.close();
                                }
                            }
                        } else if (z) {
                            float f6 = (float) i;
                            path.moveTo(f6, 0.0f);
                            path.lineTo(0.0f, 0.0f);
                            float f7 = (float) i2;
                            path.quadTo(abs * 2.0f, (float) (i2 / 2), 0.0f, f7);
                            path.lineTo(f6, f7);
                            path.close();
                        } else {
                            float f8 = (float) i;
                            path.moveTo(f8, 0.0f);
                            path.lineTo(abs, 0.0f);
                            float f9 = (float) i2;
                            path.quadTo(-abs, (float) (i2 / 2), abs, f9);
                            path.lineTo(f8, f9);
                            path.close();
                        }
                    } else if (z) {
                        float f10 = (float) i2;
                        path.moveTo(0.0f, f10);
                        path.lineTo(0.0f, 0.0f);
                        float f11 = (float) i;
                        path.quadTo((float) (i / 2), abs * 2.0f, f11, 0.0f);
                        path.lineTo(f11, f10);
                        path.close();
                    } else {
                        path.moveTo(0.0f, abs);
                        float f12 = (float) i;
                        path.quadTo((float) (i / 2), -abs, f12, abs);
                        float f13 = (float) i2;
                        path.lineTo(f12, f13);
                        path.lineTo(0.0f, f13);
                        path.close();
                    }
                } else if (z) {
                    path.moveTo(0.0f, 0.0f);
                    float f14 = (float) i2;
                    path.lineTo(0.0f, f14);
                    float f15 = (float) i;
                    path.quadTo((float) (i / 2), f14 - (abs * 2.0f), f15, f14);
                    path.lineTo(f15, 0.0f);
                    path.close();
                } else {
                    path.moveTo(0.0f, 0.0f);
                    float f16 = (float) i2;
                    float f17 = f16 - abs;
                    path.lineTo(0.0f, f17);
                    float f18 = (float) i;
                    path.quadTo((float) (i / 2), f16 + abs, f18, f17);
                    path.lineTo(f18, 0.0f);
                    path.close();
                }
                return path;
            }
        });
    }

    public int getArcPosition() {
        return this.arcPosition;
    }

    public void setArcPosition(int i) {
        this.arcPosition = i;
        requiresShapeUpdate();
    }

    public int getCropDirection() {
        return this.arcHeightPx > 0.0f ? 2 : 1;
    }

    public float getArcHeight() {
        return this.arcHeightPx;
    }

    public void setArcHeight(float f) {
        this.arcHeightPx = f;
        requiresShapeUpdate();
    }

    public float getArcHeightDp() {
        return pxToDp(this.arcHeightPx);
    }

    public void setArcHeightDp(float f) {
        setArcHeight(dpToPx(f));
    }
}
