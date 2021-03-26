package cn.bertsir.zbar.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import cn.bertsir.zbar.R;

public class ScanLineView extends View {
    private static final String TAG = "ScanView";
    public static final int style_gridding = 0;
    public static final int style_hybrid = 2;
    public static final int style_line = 3;
    public static final int style_radar = 1;
    private float animatedValue;
    private Path mBoundaryLinePath;
    private float mCornerLineLen;
    private Rect mFrame;
    private int mGriddingDensity;
    private float mGriddingLineWidth;
    private Path mGriddingPath;
    private LinearGradient mLinearGradient_Gridding;
    private LinearGradient mLinearGradient_Radar;
    private LinearGradient mLinearGradient_line;
    private int mScanAnimatorDuration;
    private Matrix mScanMatrix;
    private Paint mScanPaint_Gridding;
    private Paint mScanPaint_Line;
    private Paint mScanPaint_Radio;
    private int mScanStyle;
    private int mScancolor;
    private ValueAnimator mValueAnimator;

    public ScanLineView(Context context) {
        this(context, null);
    }

    public ScanLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGriddingLineWidth = 2.0f;
        this.mGriddingDensity = 40;
        this.mCornerLineLen = 50.0f;
        this.mScanAnimatorDuration = 1800;
        this.mScanStyle = 0;
        init();
    }

    private void init() {
        Paint paint = new Paint(1);
        this.mScanPaint_Gridding = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mScanPaint_Gridding.setStrokeWidth(this.mGriddingLineWidth);
        Paint paint2 = new Paint(1);
        this.mScanPaint_Radio = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mScancolor = getResources().getColor(R.color.common_color);
        Paint paint3 = new Paint();
        this.mScanPaint_Line = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mScanPaint_Line.setStrokeWidth(10.0f);
        this.mScanPaint_Line.setAntiAlias(true);
        Matrix matrix = new Matrix();
        this.mScanMatrix = matrix;
        matrix.setTranslate(0.0f, 30.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mFrame = new Rect(i, i2, i3, i4);
        initBoundaryAndAnimator();
    }

    private void initBoundaryAndAnimator() {
        if (this.mBoundaryLinePath == null) {
            Path path = new Path();
            this.mBoundaryLinePath = path;
            path.moveTo((float) this.mFrame.left, ((float) this.mFrame.top) + this.mCornerLineLen);
            this.mBoundaryLinePath.lineTo((float) this.mFrame.left, (float) this.mFrame.top);
            this.mBoundaryLinePath.lineTo(((float) this.mFrame.left) + this.mCornerLineLen, (float) this.mFrame.top);
            this.mBoundaryLinePath.moveTo(((float) this.mFrame.right) - this.mCornerLineLen, (float) this.mFrame.top);
            this.mBoundaryLinePath.lineTo((float) this.mFrame.right, (float) this.mFrame.top);
            this.mBoundaryLinePath.lineTo((float) this.mFrame.right, ((float) this.mFrame.top) + this.mCornerLineLen);
            this.mBoundaryLinePath.moveTo((float) this.mFrame.right, ((float) this.mFrame.bottom) - this.mCornerLineLen);
            this.mBoundaryLinePath.lineTo((float) this.mFrame.right, (float) this.mFrame.bottom);
            this.mBoundaryLinePath.lineTo(((float) this.mFrame.right) - this.mCornerLineLen, (float) this.mFrame.bottom);
            this.mBoundaryLinePath.moveTo(((float) this.mFrame.left) + this.mCornerLineLen, (float) this.mFrame.bottom);
            this.mBoundaryLinePath.lineTo((float) this.mFrame.left, (float) this.mFrame.bottom);
            this.mBoundaryLinePath.lineTo((float) this.mFrame.left, ((float) this.mFrame.bottom) - this.mCornerLineLen);
        }
        if (this.mValueAnimator == null) {
            initScanValueAnim(this.mFrame.height());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mFrame != null && this.mBoundaryLinePath != null) {
            int i = this.mScanStyle;
            if (i == 0) {
                initGriddingPathAndStyle();
                canvas.drawPath(this.mGriddingPath, this.mScanPaint_Gridding);
            } else if (i == 1) {
                initRadarStyle();
                canvas.drawRect(this.mFrame, this.mScanPaint_Radio);
            } else if (i != 3) {
                initGriddingPathAndStyle();
                initRadarStyle();
                canvas.drawPath(this.mGriddingPath, this.mScanPaint_Gridding);
                canvas.drawRect(this.mFrame, this.mScanPaint_Radio);
            } else {
                initLineStyle();
                canvas.drawLine(0.0f, ((float) this.mFrame.height()) - Math.abs(this.animatedValue), (float) getMeasuredWidth(), ((float) this.mFrame.height()) - Math.abs(this.animatedValue), this.mScanPaint_Line);
            }
        }
    }

    /* access modifiers changed from: private */
    public void initRadarStyle() {
        if (this.mLinearGradient_Radar == null) {
            LinearGradient linearGradient = new LinearGradient(0.0f, (float) this.mFrame.top, 0.0f, ((float) this.mFrame.bottom) + (((float) this.mFrame.height()) * 0.01f), new int[]{0, 0, this.mScancolor, 0}, new float[]{0.0f, 0.85f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.mLinearGradient_Radar = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Radio.setShader(this.mLinearGradient_Radar);
        }
    }

    /* access modifiers changed from: private */
    public void initLineStyle() {
        if (this.mLinearGradient_line == null) {
            String valueOf = String.valueOf(Integer.toHexString(this.mScancolor));
            String substring = valueOf.substring(valueOf.length() - 6, valueOf.length() - 0);
            float measuredWidth = (float) getMeasuredWidth();
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, measuredWidth, 0.0f, new int[]{Color.parseColor("#00" + substring), this.mScancolor, Color.parseColor("#00" + substring)}, (float[]) null, Shader.TileMode.CLAMP);
            this.mLinearGradient_line = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Line.setShader(this.mLinearGradient_line);
        }
    }

    /* access modifiers changed from: private */
    public void initGriddingPathAndStyle() {
        if (this.mGriddingPath == null) {
            this.mGriddingPath = new Path();
            float width = ((float) this.mFrame.width()) / (((float) this.mGriddingDensity) + 0.0f);
            float height = ((float) this.mFrame.height()) / (((float) this.mGriddingDensity) + 0.0f);
            for (int i = 0; i <= this.mGriddingDensity; i++) {
                float f = ((float) i) * width;
                this.mGriddingPath.moveTo(((float) this.mFrame.left) + f, (float) this.mFrame.top);
                this.mGriddingPath.lineTo(((float) this.mFrame.left) + f, (float) this.mFrame.bottom);
            }
            for (int i2 = 0; i2 <= this.mGriddingDensity; i2++) {
                float f2 = ((float) i2) * height;
                this.mGriddingPath.moveTo((float) this.mFrame.left, ((float) this.mFrame.top) + f2);
                this.mGriddingPath.lineTo((float) this.mFrame.right, ((float) this.mFrame.top) + f2);
            }
        }
        if (this.mLinearGradient_Gridding == null) {
            LinearGradient linearGradient = new LinearGradient(0.0f, (float) this.mFrame.top, 0.0f, ((float) this.mFrame.bottom) + (((float) this.mFrame.height()) * 0.01f), new int[]{0, 0, this.mScancolor, 0}, new float[]{0.0f, 0.5f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.mLinearGradient_Gridding = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Gridding.setShader(this.mLinearGradient_Gridding);
        }
    }

    public void initScanValueAnim(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mValueAnimator = valueAnimator;
        valueAnimator.setDuration((long) this.mScanAnimatorDuration);
        this.mValueAnimator.setFloatValues((float) (-i), 0.0f);
        this.mValueAnimator.setRepeatMode(1);
        this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class cn.bertsir.zbar.view.ScanLineView.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ScanLineView.this.mLinearGradient_Gridding == null) {
                    ScanLineView.this.initGriddingPathAndStyle();
                }
                if (ScanLineView.this.mLinearGradient_Radar == null) {
                    ScanLineView.this.initRadarStyle();
                }
                if (ScanLineView.this.mLinearGradient_line == null) {
                    ScanLineView.this.initLineStyle();
                }
                if (ScanLineView.this.mScanMatrix != null) {
                    ScanLineView.this.animatedValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ScanLineView.this.mScanMatrix.setTranslate(0.0f, ScanLineView.this.animatedValue);
                    ScanLineView.this.mLinearGradient_Gridding.setLocalMatrix(ScanLineView.this.mScanMatrix);
                    ScanLineView.this.mLinearGradient_Radar.setLocalMatrix(ScanLineView.this.mScanMatrix);
                    ScanLineView.this.mLinearGradient_line.setLocalMatrix(ScanLineView.this.mScanMatrix);
                    ScanLineView.this.invalidate();
                }
            }
        });
        this.mValueAnimator.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        super.onDetachedFromWindow();
    }

    public void setScancolor(int i) {
        this.mScancolor = i;
    }

    public void setScanAnimatorDuration(int i) {
        this.mScanAnimatorDuration = i;
    }

    public void setScanStyle(int i) {
        this.mScanStyle = i;
    }

    public void setScanGriddingStyle(float f, int i) {
        this.mGriddingLineWidth = f;
        this.mGriddingDensity = i;
    }
}
