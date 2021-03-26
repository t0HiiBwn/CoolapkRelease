package com.github.florent37.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.florent37.shapeofview.R;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class DiagonalView extends ShapeOfView {
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int POSITION_BOTTOM = 1;
    public static final int POSITION_LEFT = 3;
    public static final int POSITION_RIGHT = 4;
    public static final int POSITION_TOP = 2;
    private float diagonalAngle = 0.0f;
    private int diagonalPosition = 2;

    public @interface DiagonalDirection {
    }

    public @interface DiagonalPosition {
    }

    public DiagonalView(Context context) {
        super(context);
        init(context, null);
    }

    public DiagonalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public DiagonalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DiagonalView);
            this.diagonalAngle = obtainStyledAttributes.getFloat(R.styleable.DiagonalView_shape_diagonal_angle, this.diagonalAngle);
            this.diagonalPosition = obtainStyledAttributes.getInteger(R.styleable.DiagonalView_shape_diagonal_position, this.diagonalPosition);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            /* class com.github.florent37.shapeofview.shapes.DiagonalView.AnonymousClass1 */

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public boolean requiresBitmap() {
                return false;
            }

            @Override // com.github.florent37.shapeofview.manager.ClipPathManager.ClipPathCreator
            public Path createClipPath(int i, int i2) {
                Path path = new Path();
                float abs = Math.abs(DiagonalView.this.diagonalAngle);
                boolean z = DiagonalView.this.getDiagonalDirection() == 1;
                float tan = (float) (((double) i) * Math.tan(Math.toRadians((double) abs)));
                int i3 = DiagonalView.this.diagonalPosition;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                if (z) {
                                    path.moveTo((float) DiagonalView.this.getPaddingLeft(), (float) DiagonalView.this.getPaddingTop());
                                    path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) DiagonalView.this.getPaddingTop());
                                    path.lineTo(((float) (i - DiagonalView.this.getPaddingRight())) - tan, (float) (i2 - DiagonalView.this.getPaddingBottom()));
                                    path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                                    path.close();
                                } else {
                                    path.moveTo((float) DiagonalView.this.getPaddingLeft(), (float) DiagonalView.this.getPaddingTop());
                                    path.lineTo(((float) (i - DiagonalView.this.getPaddingRight())) - tan, (float) DiagonalView.this.getPaddingTop());
                                    path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                                    path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                                    path.close();
                                }
                            }
                        } else if (z) {
                            path.moveTo(((float) DiagonalView.this.getPaddingLeft()) + tan, (float) DiagonalView.this.getPaddingTop());
                            path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) DiagonalView.this.getPaddingTop());
                            path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                            path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                            path.close();
                        } else {
                            path.moveTo((float) DiagonalView.this.getPaddingLeft(), (float) DiagonalView.this.getPaddingTop());
                            path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) DiagonalView.this.getPaddingTop());
                            path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                            path.lineTo(((float) DiagonalView.this.getPaddingLeft()) + tan, (float) (i2 - DiagonalView.this.getPaddingBottom()));
                            path.close();
                        }
                    } else if (z) {
                        path.moveTo((float) (i - DiagonalView.this.getPaddingRight()), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                        path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), ((float) DiagonalView.this.getPaddingTop()) + tan);
                        path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) DiagonalView.this.getPaddingTop());
                        path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                        path.close();
                    } else {
                        path.moveTo((float) (i - DiagonalView.this.getPaddingRight()), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                        path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) DiagonalView.this.getPaddingTop());
                        path.lineTo((float) DiagonalView.this.getPaddingLeft(), ((float) DiagonalView.this.getPaddingTop()) + tan);
                        path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                        path.close();
                    }
                } else if (z) {
                    path.moveTo((float) DiagonalView.this.getPaddingLeft(), (float) DiagonalView.this.getPaddingRight());
                    path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) DiagonalView.this.getPaddingTop());
                    path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (((float) i2) - tan) - ((float) DiagonalView.this.getPaddingBottom()));
                    path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                    path.close();
                } else {
                    path.moveTo((float) (i - DiagonalView.this.getPaddingRight()), (float) (i2 - DiagonalView.this.getPaddingBottom()));
                    path.lineTo((float) DiagonalView.this.getPaddingLeft(), (((float) i2) - tan) - ((float) DiagonalView.this.getPaddingBottom()));
                    path.lineTo((float) DiagonalView.this.getPaddingLeft(), (float) DiagonalView.this.getPaddingTop());
                    path.lineTo((float) (i - DiagonalView.this.getPaddingRight()), (float) DiagonalView.this.getPaddingTop());
                    path.close();
                }
                return path;
            }
        });
    }

    public void setDiagonalPosition(int i) {
        this.diagonalPosition = i;
        requiresShapeUpdate();
    }

    public int getDiagonalPosition() {
        return this.diagonalPosition;
    }

    public int getDiagonalDirection() {
        return this.diagonalAngle > 0.0f ? 1 : 2;
    }

    public float getDiagonalAngle() {
        return this.diagonalAngle;
    }

    public void setDiagonalAngle(float f) {
        this.diagonalAngle = f;
        requiresShapeUpdate();
    }
}
