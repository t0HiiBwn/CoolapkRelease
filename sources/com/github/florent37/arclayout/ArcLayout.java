package com.github.florent37.arclayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.florent37.arclayout.manager.ClipPathManager;

public class ArcLayout extends ShapeOfView {
    public static final int CROP_INSIDE = 1;
    public static final int CROP_OUTSIDE = 2;
    public static final int POSITION_BOTTOM = 1;
    public static final int POSITION_LEFT = 3;
    public static final int POSITION_RIGHT = 4;
    public static final int POSITION_TOP = 2;
    private int arcHeight = 0;
    private int arcPosition = 2;
    private int cropDirection = 1;

    public @interface ArcPosition {
    }

    public @interface CropDirection {
    }

    public ArcLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ArcLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ArcLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcLayout);
            this.arcHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ArcLayout_arc_height, this.arcHeight);
            this.arcPosition = obtainStyledAttributes.getInteger(R.styleable.ArcLayout_arc_position, this.arcPosition);
            this.cropDirection = obtainStyledAttributes.getInteger(R.styleable.ArcLayout_arc_cropDirection, this.cropDirection);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.arclayout.ArcLayout.AnonymousClass1 */

            @Override // com.github.florent37.arclayout.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return false;
            }

            @Override // com.github.florent37.arclayout.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                Path path = new Path();
                boolean z = ArcLayout.this.cropDirection == 1;
                int i3 = ArcLayout.this.arcPosition;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                if (z) {
                                    path.moveTo(0.0f, 0.0f);
                                    float f = (float) i;
                                    path.lineTo(f, 0.0f);
                                    float f2 = (float) i2;
                                    path.quadTo((float) (i - (ArcLayout.this.arcHeight * 2)), (float) (i2 / 2), f, f2);
                                    path.lineTo(0.0f, f2);
                                    path.close();
                                } else {
                                    path.moveTo(0.0f, 0.0f);
                                    path.lineTo((float) (i - ArcLayout.this.arcHeight), 0.0f);
                                    float f3 = (float) i2;
                                    path.quadTo((float) (ArcLayout.this.arcHeight + i), (float) (i2 / 2), (float) (i - ArcLayout.this.arcHeight), f3);
                                    path.lineTo(0.0f, f3);
                                    path.close();
                                }
                            }
                        } else if (z) {
                            float f4 = (float) i;
                            path.moveTo(f4, 0.0f);
                            path.lineTo(0.0f, 0.0f);
                            float f5 = (float) i2;
                            path.quadTo((float) (ArcLayout.this.arcHeight * 2), (float) (i2 / 2), 0.0f, f5);
                            path.lineTo(f4, f5);
                            path.close();
                        } else {
                            float f6 = (float) i;
                            path.moveTo(f6, 0.0f);
                            path.lineTo((float) ArcLayout.this.arcHeight, 0.0f);
                            float f7 = (float) i2;
                            path.quadTo((float) (-ArcLayout.this.arcHeight), (float) (i2 / 2), (float) ArcLayout.this.arcHeight, f7);
                            path.lineTo(f6, f7);
                            path.close();
                        }
                    } else if (z) {
                        float f8 = (float) i2;
                        path.moveTo(0.0f, f8);
                        path.lineTo(0.0f, 0.0f);
                        float f9 = (float) i;
                        path.quadTo((float) (i / 2), (float) (ArcLayout.this.arcHeight * 2), f9, 0.0f);
                        path.lineTo(f9, f8);
                        path.close();
                    } else {
                        path.moveTo(0.0f, (float) ArcLayout.this.arcHeight);
                        float f10 = (float) i;
                        path.quadTo((float) (i / 2), (float) (-ArcLayout.this.arcHeight), f10, (float) ArcLayout.this.arcHeight);
                        float f11 = (float) i2;
                        path.lineTo(f10, f11);
                        path.lineTo(0.0f, f11);
                        path.close();
                    }
                } else if (z) {
                    path.moveTo(0.0f, 0.0f);
                    float f12 = (float) i2;
                    path.lineTo(0.0f, f12);
                    float f13 = (float) i;
                    path.quadTo((float) (i / 2), (float) (i2 - (ArcLayout.this.arcHeight * 2)), f13, f12);
                    path.lineTo(f13, 0.0f);
                    path.close();
                } else {
                    path.moveTo(0.0f, 0.0f);
                    path.lineTo(0.0f, (float) (i2 - ArcLayout.this.arcHeight));
                    float f14 = (float) i;
                    path.quadTo((float) (i / 2), (float) (ArcLayout.this.arcHeight + i2), f14, (float) (i2 - ArcLayout.this.arcHeight));
                    path.lineTo(f14, 0.0f);
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
        return this.cropDirection;
    }

    public void setCropDirection(int i) {
        this.cropDirection = i;
        requiresShapeUpdate();
    }

    public int getArcHeight() {
        return this.arcHeight;
    }

    public void setArcHeight(int i) {
        this.arcHeight = i;
        requiresShapeUpdate();
    }
}
