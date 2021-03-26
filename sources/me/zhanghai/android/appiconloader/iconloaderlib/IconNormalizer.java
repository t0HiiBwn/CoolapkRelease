package me.zhanghai.android.appiconloader.iconloaderlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import java.nio.ByteBuffer;

public class IconNormalizer {
    private static final float BOUND_RATIO_MARGIN = 0.05f;
    private static final float CIRCLE_AREA_BY_RECT = 0.7853982f;
    private static final boolean DEBUG = false;
    public static final float ICON_VISIBLE_AREA_FACTOR = 0.92f;
    private static final float LINEAR_SCALE_SLOPE = 0.040449437f;
    private static final float MAX_CIRCLE_AREA_FACTOR = 0.6597222f;
    private static final float MAX_SQUARE_AREA_FACTOR = 0.6510417f;
    private static final int MIN_VISIBLE_ALPHA = 40;
    private static final float PIXEL_DIFF_PERCENTAGE_THRESHOLD = 0.005f;
    private static final float SCALE_NOT_INITIALIZED = 0.0f;
    private static final String TAG = "IconNormalizer";
    private final RectF mAdaptiveIconBounds = new RectF();
    private float mAdaptiveIconScale;
    private final Bitmap mBitmap;
    private final Rect mBounds = new Rect();
    private final Canvas mCanvas;
    private boolean mEnableShapeDetection;
    private final float[] mLeftBorder;
    private final Matrix mMatrix;
    private final int mMaxSize;
    private final Paint mPaintMaskShape;
    private final Paint mPaintMaskShapeOutline;
    private final byte[] mPixels;
    private final float[] mRightBorder;
    private final Path mShapePath;

    IconNormalizer(Context context, int i, boolean z) {
        int i2 = i * 2;
        this.mMaxSize = i2;
        Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ALPHA_8);
        this.mBitmap = createBitmap;
        this.mCanvas = new Canvas(createBitmap);
        this.mPixels = new byte[(i2 * i2)];
        this.mLeftBorder = new float[i2];
        this.mRightBorder = new float[i2];
        Paint paint = new Paint();
        this.mPaintMaskShape = paint;
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        Paint paint2 = new Paint();
        this.mPaintMaskShapeOutline = paint2;
        paint2.setStrokeWidth(context.getResources().getDisplayMetrics().density * 2.0f);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-16777216);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mShapePath = new Path();
        this.mMatrix = new Matrix();
        this.mAdaptiveIconScale = 0.0f;
        this.mEnableShapeDetection = z;
    }

    private static float getScale(float f, float f2, float f3) {
        float f4 = f / f2;
        float f5 = f4 < 0.7853982f ? 0.6597222f : ((1.0f - f4) * 0.040449437f) + 0.6510417f;
        float f6 = f / f3;
        if (f6 > f5) {
            return (float) Math.sqrt((double) (f5 / f6));
        }
        return 1.0f;
    }

    public static float normalizeAdaptiveIcon(Drawable drawable, int i, RectF rectF) {
        Rect rect = new Rect(drawable.getBounds());
        drawable.setBounds(0, 0, i, i);
        Path iconMask = ((AdaptiveIconDrawable) drawable).getIconMask();
        Region region = new Region();
        region.setPath(iconMask, new Region(0, 0, i, i));
        Rect bounds = region.getBounds();
        int area = GraphicsUtils.getArea(region);
        if (rectF != null) {
            float f = (float) i;
            rectF.set(((float) bounds.left) / f, ((float) bounds.top) / f, 1.0f - (((float) bounds.right) / f), 1.0f - (((float) bounds.bottom) / f));
        }
        drawable.setBounds(rect);
        float f2 = (float) area;
        return getScale(f2, f2, (float) (i * i));
    }

    private boolean isShape(Path path) {
        if (Math.abs((((float) this.mBounds.width()) / ((float) this.mBounds.height())) - 1.0f) > 0.05f) {
            return false;
        }
        this.mMatrix.reset();
        this.mMatrix.setScale((float) this.mBounds.width(), (float) this.mBounds.height());
        this.mMatrix.postTranslate((float) this.mBounds.left, (float) this.mBounds.top);
        path.transform(this.mMatrix, this.mShapePath);
        this.mCanvas.drawPath(this.mShapePath, this.mPaintMaskShape);
        this.mCanvas.drawPath(this.mShapePath, this.mPaintMaskShapeOutline);
        return isTransparentBitmap();
    }

    private boolean isTransparentBitmap() {
        ByteBuffer wrap = ByteBuffer.wrap(this.mPixels);
        wrap.rewind();
        this.mBitmap.copyPixelsToBuffer(wrap);
        int i = this.mBounds.top;
        int i2 = this.mMaxSize;
        int i3 = i * i2;
        int i4 = i2 - this.mBounds.right;
        int i5 = 0;
        while (i < this.mBounds.bottom) {
            int i6 = i3 + this.mBounds.left;
            for (int i7 = this.mBounds.left; i7 < this.mBounds.right; i7++) {
                if ((this.mPixels[i6] & 255) > 40) {
                    i5++;
                }
                i6++;
            }
            i3 = i6 + i4;
            i++;
        }
        if (((float) i5) / ((float) (this.mBounds.width() * this.mBounds.height())) < 0.005f) {
            return true;
        }
        return false;
    }

    public synchronized float getScale(Drawable drawable, RectF rectF, Path path, boolean[] zArr) {
        if (!BaseIconFactory.ATLEAST_OREO || !(drawable instanceof AdaptiveIconDrawable)) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                if (intrinsicWidth <= 0 || intrinsicWidth > this.mMaxSize) {
                    intrinsicWidth = this.mMaxSize;
                }
                if (intrinsicHeight <= 0 || intrinsicHeight > this.mMaxSize) {
                    intrinsicHeight = this.mMaxSize;
                }
            } else {
                int i = this.mMaxSize;
                if (intrinsicWidth > i || intrinsicHeight > i) {
                    int max = Math.max(intrinsicWidth, intrinsicHeight);
                    int i2 = this.mMaxSize;
                    intrinsicWidth = (intrinsicWidth * i2) / max;
                    intrinsicHeight = (i2 * intrinsicHeight) / max;
                }
            }
            this.mBitmap.eraseColor(0);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(this.mCanvas);
            ByteBuffer wrap = ByteBuffer.wrap(this.mPixels);
            wrap.rewind();
            this.mBitmap.copyPixelsToBuffer(wrap);
            int i3 = this.mMaxSize;
            int i4 = i3 + 1;
            int i5 = i3 - intrinsicWidth;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = 0;
            for (int i10 = 0; i10 < intrinsicHeight; i10++) {
                int i11 = -1;
                int i12 = -1;
                for (int i13 = 0; i13 < intrinsicWidth; i13++) {
                    if ((this.mPixels[i9] & 255) > 40) {
                        if (i11 == -1) {
                            i11 = i13;
                        }
                        i12 = i13;
                    }
                    i9++;
                }
                i9 += i5;
                this.mLeftBorder[i10] = (float) i11;
                this.mRightBorder[i10] = (float) i12;
                if (i11 != -1) {
                    if (i6 == -1) {
                        i6 = i10;
                    }
                    int min = Math.min(i4, i11);
                    i7 = Math.max(i7, i12);
                    i4 = min;
                    i8 = i10;
                }
            }
            if (i6 == -1 || i7 == -1) {
                return 1.0f;
            }
            convertToConvexArray(this.mLeftBorder, 1, i6, i8);
            convertToConvexArray(this.mRightBorder, -1, i6, i8);
            float f = 0.0f;
            for (int i14 = 0; i14 < intrinsicHeight; i14++) {
                float[] fArr = this.mLeftBorder;
                if (fArr[i14] > -1.0f) {
                    f += (this.mRightBorder[i14] - fArr[i14]) + 1.0f;
                }
            }
            this.mBounds.left = i4;
            this.mBounds.right = i7;
            this.mBounds.top = i6;
            this.mBounds.bottom = i8;
            if (rectF != null) {
                float f2 = (float) intrinsicWidth;
                float f3 = (float) intrinsicHeight;
                rectF.set(((float) this.mBounds.left) / f2, ((float) this.mBounds.top) / f3, 1.0f - (((float) this.mBounds.right) / f2), 1.0f - (((float) this.mBounds.bottom) / f3));
            }
            if (zArr != null && this.mEnableShapeDetection && zArr.length > 0) {
                zArr[0] = isShape(path);
            }
            return getScale(f, (float) (((i8 + 1) - i6) * ((i7 + 1) - i4)), (float) (intrinsicWidth * intrinsicHeight));
        }
        if (this.mAdaptiveIconScale == 0.0f) {
            this.mAdaptiveIconScale = normalizeAdaptiveIcon(drawable, this.mMaxSize, this.mAdaptiveIconBounds);
        }
        if (rectF != null) {
            rectF.set(this.mAdaptiveIconBounds);
        }
        return this.mAdaptiveIconScale;
    }

    private static void convertToConvexArray(float[] fArr, int i, int i2, int i3) {
        float[] fArr2 = new float[(fArr.length - 1)];
        int i4 = -1;
        float f = Float.MAX_VALUE;
        for (int i5 = i2 + 1; i5 <= i3; i5++) {
            if (fArr[i5] > -1.0f) {
                if (f == Float.MAX_VALUE) {
                    i4 = i2;
                } else {
                    float f2 = ((fArr[i5] - fArr[i4]) / ((float) (i5 - i4))) - f;
                    float f3 = (float) i;
                    if (f2 * f3 < 0.0f) {
                        while (i4 > i2) {
                            i4--;
                            if ((((fArr[i5] - fArr[i4]) / ((float) (i5 - i4))) - fArr2[i4]) * f3 >= 0.0f) {
                                break;
                            }
                        }
                    }
                }
                f = (fArr[i5] - fArr[i4]) / ((float) (i5 - i4));
                for (int i6 = i4; i6 < i5; i6++) {
                    fArr2[i6] = f;
                    fArr[i6] = fArr[i4] + (((float) (i6 - i4)) * f);
                }
                i4 = i5;
            }
        }
    }

    public static int getNormalizedCircleSize(int i) {
        return (int) Math.round(Math.sqrt(((double) ((((float) (i * i)) * 0.6597222f) * 4.0f)) / 3.141592653589793d));
    }
}
