package com.soundcloud.android.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

abstract class ImageViewTouchBase extends ImageView {
    private static final float SCALE_RATE = 1.25f;
    protected Matrix baseMatrix;
    protected final RotateBitmap bitmapDisplayed;
    private final Matrix displayMatrix;
    protected Handler handler;
    private final float[] matrixValues;
    float maxZoom;
    private Runnable onLayoutRunnable;
    private Recycler recycler;
    protected Matrix suppMatrix;
    int thisHeight;
    int thisWidth;

    public interface Recycler {
        void recycle(Bitmap bitmap);
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new RotateBitmap(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new RotateBitmap(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new RotateBitmap(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }

    public void setRecycler(Recycler recycler2) {
        this.recycler = recycler2;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.thisWidth = i3 - i;
        this.thisHeight = i4 - i2;
        Runnable runnable = this.onLayoutRunnable;
        if (runnable != null) {
            this.onLayoutRunnable = null;
            runnable.run();
        }
        if (this.bitmapDisplayed.getBitmap() != null) {
            getProperBaseMatrix(this.bitmapDisplayed, this.baseMatrix, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    @Override // android.view.KeyEvent.Callback, android.view.View
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.KeyEvent.Callback, android.view.View
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        zoomTo(1.0f);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, 0);
    }

    private void setImageBitmap(Bitmap bitmap, int i) {
        Recycler recycler2;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmap2 = this.bitmapDisplayed.getBitmap();
        this.bitmapDisplayed.setBitmap(bitmap);
        this.bitmapDisplayed.setRotation(i);
        if (bitmap2 != null && bitmap2 != bitmap && (recycler2 = this.recycler) != null) {
            recycler2.recycle(bitmap2);
        }
    }

    public void clear() {
        setImageBitmapResetBase(null, true);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        setImageRotateBitmapResetBase(new RotateBitmap(bitmap, 0), z);
    }

    public void setImageRotateBitmapResetBase(final RotateBitmap rotateBitmap, final boolean z) {
        if (getWidth() <= 0) {
            this.onLayoutRunnable = new Runnable() {
                /* class com.soundcloud.android.crop.ImageViewTouchBase.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    ImageViewTouchBase.this.setImageRotateBitmapResetBase(rotateBitmap, z);
                }
            };
            return;
        }
        if (rotateBitmap.getBitmap() != null) {
            getProperBaseMatrix(rotateBitmap, this.baseMatrix, true);
            setImageBitmap(rotateBitmap.getBitmap(), rotateBitmap.getRotation());
        } else {
            this.baseMatrix.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.suppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.maxZoom = calculateMaxZoom();
    }

    protected void center() {
        Bitmap bitmap = this.bitmapDisplayed.getBitmap();
        if (bitmap != null) {
            Matrix imageViewMatrix = getImageViewMatrix();
            RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            imageViewMatrix.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            postTranslate(centerHorizontal(rectF, width, 0.0f), centerVertical(rectF, height, 0.0f));
            setImageMatrix(getImageViewMatrix());
        }
    }

    private float centerVertical(RectF rectF, float f, float f2) {
        float height = (float) getHeight();
        if (f < height) {
            return ((height - f) / 2.0f) - rectF.top;
        }
        if (rectF.top > 0.0f) {
            return -rectF.top;
        }
        return rectF.bottom < height ? ((float) getHeight()) - rectF.bottom : f2;
    }

    private float centerHorizontal(RectF rectF, float f, float f2) {
        float f3;
        float width = (float) getWidth();
        if (f < width) {
            width = (width - f) / 2.0f;
            f3 = rectF.left;
        } else if (rectF.left > 0.0f) {
            return -rectF.left;
        } else {
            if (rectF.right >= width) {
                return f2;
            }
            f3 = rectF.right;
        }
        return width - f3;
    }

    private void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    protected float getValue(Matrix matrix, int i) {
        matrix.getValues(this.matrixValues);
        return this.matrixValues[i];
    }

    protected float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    protected float getScale() {
        return getScale(this.suppMatrix);
    }

    private void getProperBaseMatrix(RotateBitmap rotateBitmap, Matrix matrix, boolean z) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float width2 = (float) rotateBitmap.getWidth();
        float height2 = (float) rotateBitmap.getHeight();
        matrix.reset();
        float min = Math.min(Math.min(width / width2, 3.0f), Math.min(height / height2, 3.0f));
        if (z) {
            matrix.postConcat(rotateBitmap.getRotateMatrix());
        }
        matrix.postScale(min, min);
        matrix.postTranslate((width - (width2 * min)) / 2.0f, (height - (height2 * min)) / 2.0f);
    }

    protected Matrix getImageViewMatrix() {
        this.displayMatrix.set(this.baseMatrix);
        this.displayMatrix.postConcat(this.suppMatrix);
        return this.displayMatrix;
    }

    public Matrix getUnrotatedMatrix() {
        Matrix matrix = new Matrix();
        getProperBaseMatrix(this.bitmapDisplayed, matrix, false);
        matrix.postConcat(this.suppMatrix);
        return matrix;
    }

    protected float calculateMaxZoom() {
        if (this.bitmapDisplayed.getBitmap() == null) {
            return 1.0f;
        }
        return Math.max(((float) this.bitmapDisplayed.getWidth()) / ((float) this.thisWidth), ((float) this.bitmapDisplayed.getHeight()) / ((float) this.thisHeight)) * 4.0f;
    }

    protected void zoomTo(float f, float f2, float f3) {
        float f4 = this.maxZoom;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        this.suppMatrix.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        center();
    }

    protected void zoomTo(float f, final float f2, final float f3, final float f4) {
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        this.handler.post(new Runnable() {
            /* class com.soundcloud.android.crop.ImageViewTouchBase.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                float min = Math.min(f4, (float) (System.currentTimeMillis() - currentTimeMillis));
                ImageViewTouchBase.this.zoomTo(scale2 + (scale * min), f2, f3);
                if (min < f4) {
                    ImageViewTouchBase.this.handler.post(this);
                }
            }
        });
    }

    protected void zoomTo(float f) {
        zoomTo(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    protected void zoomIn() {
        zoomIn(1.25f);
    }

    protected void zoomOut() {
        zoomOut(1.25f);
    }

    protected void zoomIn(float f) {
        if (getScale() < this.maxZoom && this.bitmapDisplayed.getBitmap() != null) {
            this.suppMatrix.postScale(f, f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void zoomOut(float f) {
        if (this.bitmapDisplayed.getBitmap() != null) {
            float width = ((float) getWidth()) / 2.0f;
            float height = ((float) getHeight()) / 2.0f;
            Matrix matrix = new Matrix(this.suppMatrix);
            float f2 = 1.0f / f;
            matrix.postScale(f2, f2, width, height);
            if (getScale(matrix) < 1.0f) {
                this.suppMatrix.setScale(1.0f, 1.0f, width, height);
            } else {
                this.suppMatrix.postScale(f2, f2, width, height);
            }
            setImageMatrix(getImageViewMatrix());
            center();
        }
    }

    protected void postTranslate(float f, float f2) {
        this.suppMatrix.postTranslate(f, f2);
    }

    protected void panBy(float f, float f2) {
        postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }
}
