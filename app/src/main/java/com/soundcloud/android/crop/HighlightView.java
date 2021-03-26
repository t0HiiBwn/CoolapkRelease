package com.soundcloud.android.crop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;

class HighlightView {
    private static final int DEFAULT_HIGHLIGHT_COLOR = -13388315;
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    private static final float HANDLE_RADIUS_DP = 12.0f;
    public static final int MOVE = 32;
    private static final float OUTLINE_DP = 2.0f;
    RectF cropRect;
    Rect drawRect;
    private HandleMode handleMode = HandleMode.Changing;
    private final Paint handlePaint = new Paint();
    private float handleRadius;
    private int highlightColor;
    private RectF imageRect;
    private float initialAspectRatio;
    private boolean isFocused;
    private boolean maintainAspectRatio;
    Matrix matrix;
    private ModifyMode modifyMode = ModifyMode.None;
    private final Paint outlinePaint = new Paint();
    private float outlineWidth;
    private final Paint outsidePaint = new Paint();
    private boolean showCircle;
    private boolean showThirds;
    private View viewContext;

    enum HandleMode {
        Changing,
        Always,
        Never
    }

    enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view) {
        this.viewContext = view;
        initStyles(view.getContext());
    }

    private void initStyles(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.cropImageStyle, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, R.styleable.CropImageView);
        try {
            this.showThirds = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_showThirds, false);
            this.showCircle = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_showCircle, false);
            this.highlightColor = obtainStyledAttributes.getColor(R.styleable.CropImageView_highlightColor, -13388315);
            this.handleMode = HandleMode.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_showHandles, 0)];
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setup(Matrix matrix2, Rect rect, RectF rectF, boolean z) {
        this.matrix = new Matrix(matrix2);
        this.cropRect = rectF;
        this.imageRect = new RectF(rect);
        this.maintainAspectRatio = z;
        this.initialAspectRatio = this.cropRect.width() / this.cropRect.height();
        this.drawRect = computeLayout();
        this.outsidePaint.setARGB(125, 50, 50, 50);
        this.outlinePaint.setStyle(Paint.Style.STROKE);
        this.outlinePaint.setAntiAlias(true);
        this.outlineWidth = dpToPx(2.0f);
        this.handlePaint.setColor(this.highlightColor);
        this.handlePaint.setStyle(Paint.Style.FILL);
        this.handlePaint.setAntiAlias(true);
        this.handleRadius = dpToPx(12.0f);
        this.modifyMode = ModifyMode.None;
    }

    private float dpToPx(float f) {
        return f * this.viewContext.getResources().getDisplayMetrics().density;
    }

    protected void draw(Canvas canvas) {
        canvas.save();
        Path path = new Path();
        this.outlinePaint.setStrokeWidth(this.outlineWidth);
        if (!hasFocus()) {
            this.outlinePaint.setColor(-16777216);
            canvas.drawRect(this.drawRect, this.outlinePaint);
            return;
        }
        Rect rect = new Rect();
        this.viewContext.getDrawingRect(rect);
        path.addRect(new RectF(this.drawRect), Path.Direction.CW);
        this.outlinePaint.setColor(this.highlightColor);
        if (isClipPathSupported(canvas)) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, this.outsidePaint);
        } else {
            drawOutsideFallback(canvas);
        }
        canvas.restore();
        canvas.drawPath(path, this.outlinePaint);
        if (this.showThirds) {
            drawThirds(canvas);
        }
        if (this.showCircle) {
            drawCircle(canvas);
        }
        if (this.handleMode == HandleMode.Always || (this.handleMode == HandleMode.Changing && this.modifyMode == ModifyMode.Grow)) {
            drawHandles(canvas);
        }
    }

    private void drawOutsideFallback(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) this.drawRect.top, this.outsidePaint);
        canvas.drawRect(0.0f, (float) this.drawRect.bottom, (float) canvas.getWidth(), (float) canvas.getHeight(), this.outsidePaint);
        canvas.drawRect(0.0f, (float) this.drawRect.top, (float) this.drawRect.left, (float) this.drawRect.bottom, this.outsidePaint);
        canvas.drawRect((float) this.drawRect.right, (float) this.drawRect.top, (float) canvas.getWidth(), (float) this.drawRect.bottom, this.outsidePaint);
    }

    private boolean isClipPathSupported(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 17) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 15) {
            return true;
        }
        return !canvas.isHardwareAccelerated();
    }

    private void drawHandles(Canvas canvas) {
        int i = this.drawRect.left + ((this.drawRect.right - this.drawRect.left) / 2);
        float f = (float) (this.drawRect.top + ((this.drawRect.bottom - this.drawRect.top) / 2));
        canvas.drawCircle((float) this.drawRect.left, f, this.handleRadius, this.handlePaint);
        float f2 = (float) i;
        canvas.drawCircle(f2, (float) this.drawRect.top, this.handleRadius, this.handlePaint);
        canvas.drawCircle((float) this.drawRect.right, f, this.handleRadius, this.handlePaint);
        canvas.drawCircle(f2, (float) this.drawRect.bottom, this.handleRadius, this.handlePaint);
    }

    private void drawThirds(Canvas canvas) {
        this.outlinePaint.setStrokeWidth(1.0f);
        float f = (float) ((this.drawRect.right - this.drawRect.left) / 3);
        float f2 = (float) ((this.drawRect.bottom - this.drawRect.top) / 3);
        canvas.drawLine(((float) this.drawRect.left) + f, (float) this.drawRect.top, ((float) this.drawRect.left) + f, (float) this.drawRect.bottom, this.outlinePaint);
        float f3 = f * 2.0f;
        canvas.drawLine(((float) this.drawRect.left) + f3, (float) this.drawRect.top, ((float) this.drawRect.left) + f3, (float) this.drawRect.bottom, this.outlinePaint);
        canvas.drawLine((float) this.drawRect.left, ((float) this.drawRect.top) + f2, (float) this.drawRect.right, ((float) this.drawRect.top) + f2, this.outlinePaint);
        float f4 = f2 * 2.0f;
        canvas.drawLine((float) this.drawRect.left, ((float) this.drawRect.top) + f4, (float) this.drawRect.right, ((float) this.drawRect.top) + f4, this.outlinePaint);
    }

    private void drawCircle(Canvas canvas) {
        this.outlinePaint.setStrokeWidth(1.0f);
        canvas.drawOval(new RectF(this.drawRect), this.outlinePaint);
    }

    public void setMode(ModifyMode modifyMode2) {
        if (modifyMode2 != this.modifyMode) {
            this.modifyMode = modifyMode2;
            this.viewContext.invalidate();
        }
    }

    public int getHit(float f, float f2) {
        Rect computeLayout = computeLayout();
        boolean z = false;
        boolean z2 = f2 >= ((float) computeLayout.top) - 20.0f && f2 < ((float) computeLayout.bottom) + 20.0f;
        if (f >= ((float) computeLayout.left) - 20.0f && f < ((float) computeLayout.right) + 20.0f) {
            z = true;
        }
        int i = (Math.abs(((float) computeLayout.left) - f) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(((float) computeLayout.right) - f) < 20.0f && z2) {
            i |= 4;
        }
        if (Math.abs(((float) computeLayout.top) - f2) < 20.0f && z) {
            i |= 8;
        }
        if (Math.abs(((float) computeLayout.bottom) - f2) < 20.0f && z) {
            i |= 16;
        }
        if (i != 1 || !computeLayout.contains((int) f, (int) f2)) {
            return i;
        }
        return 32;
    }

    void handleMotion(int i, float f, float f2) {
        Rect computeLayout = computeLayout();
        if (i == 32) {
            moveBy(f * (this.cropRect.width() / ((float) computeLayout.width())), f2 * (this.cropRect.height() / ((float) computeLayout.height())));
            return;
        }
        if ((i & 6) == 0) {
            f = 0.0f;
        }
        if ((i & 24) == 0) {
            f2 = 0.0f;
        }
        float width = f * (this.cropRect.width() / ((float) computeLayout.width()));
        float height = f2 * (this.cropRect.height() / ((float) computeLayout.height()));
        int i2 = -1;
        float f3 = ((float) ((i & 2) != 0 ? -1 : 1)) * width;
        if ((i & 8) == 0) {
            i2 = 1;
        }
        growBy(f3, ((float) i2) * height);
    }

    void moveBy(float f, float f2) {
        Rect rect = new Rect(this.drawRect);
        this.cropRect.offset(f, f2);
        this.cropRect.offset(Math.max(0.0f, this.imageRect.left - this.cropRect.left), Math.max(0.0f, this.imageRect.top - this.cropRect.top));
        this.cropRect.offset(Math.min(0.0f, this.imageRect.right - this.cropRect.right), Math.min(0.0f, this.imageRect.bottom - this.cropRect.bottom));
        Rect computeLayout = computeLayout();
        this.drawRect = computeLayout;
        rect.union(computeLayout);
        float f3 = this.handleRadius;
        rect.inset(-((int) f3), -((int) f3));
        this.viewContext.invalidate(rect);
    }

    void growBy(float f, float f2) {
        if (this.maintainAspectRatio) {
            if (f != 0.0f) {
                f2 = f / this.initialAspectRatio;
            } else if (f2 != 0.0f) {
                f = this.initialAspectRatio * f2;
            }
        }
        RectF rectF = new RectF(this.cropRect);
        if (f > 0.0f && rectF.width() + (f * 2.0f) > this.imageRect.width()) {
            f = (this.imageRect.width() - rectF.width()) / 2.0f;
            if (this.maintainAspectRatio) {
                f2 = f / this.initialAspectRatio;
            }
        }
        if (f2 > 0.0f && rectF.height() + (f2 * 2.0f) > this.imageRect.height()) {
            f2 = (this.imageRect.height() - rectF.height()) / 2.0f;
            if (this.maintainAspectRatio) {
                f = this.initialAspectRatio * f2;
            }
        }
        rectF.inset(-f, -f2);
        float f3 = 25.0f;
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.maintainAspectRatio) {
            f3 = 25.0f / this.initialAspectRatio;
        }
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        if (rectF.left < this.imageRect.left) {
            rectF.offset(this.imageRect.left - rectF.left, 0.0f);
        } else if (rectF.right > this.imageRect.right) {
            rectF.offset(-(rectF.right - this.imageRect.right), 0.0f);
        }
        if (rectF.top < this.imageRect.top) {
            rectF.offset(0.0f, this.imageRect.top - rectF.top);
        } else if (rectF.bottom > this.imageRect.bottom) {
            rectF.offset(0.0f, -(rectF.bottom - this.imageRect.bottom));
        }
        this.cropRect.set(rectF);
        this.drawRect = computeLayout();
        this.viewContext.invalidate();
    }

    public Rect getScaledCropRect(float f) {
        return new Rect((int) (this.cropRect.left * f), (int) (this.cropRect.top * f), (int) (this.cropRect.right * f), (int) (this.cropRect.bottom * f));
    }

    private Rect computeLayout() {
        RectF rectF = new RectF(this.cropRect.left, this.cropRect.top, this.cropRect.right, this.cropRect.bottom);
        this.matrix.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public void invalidate() {
        this.drawRect = computeLayout();
    }

    public boolean hasFocus() {
        return this.isFocused;
    }

    public void setFocus(boolean z) {
        this.isFocused = z;
    }
}
