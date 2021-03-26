package com.meg7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public abstract class BaseImageView extends ImageView {
    private static final String TAG = "BaseImageView";
    private static final Xfermode sXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Context mContext;
    private Bitmap mMaskBitmap;
    private Paint mPaint;
    private WeakReference<Bitmap> mWeakBitmap;

    public abstract Bitmap getBitmap();

    public BaseImageView(Context context) {
        super(context);
        sharedConstructor(context);
    }

    public BaseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        sharedConstructor(context);
    }

    public BaseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sharedConstructor(context);
    }

    private void sharedConstructor(Context context) {
        this.mContext = context;
        this.mPaint = new Paint(1);
    }

    @Override // android.view.View
    public void invalidate() {
        this.mWeakBitmap = null;
        Bitmap bitmap = this.mMaskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        if (!isInEditMode()) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            try {
                WeakReference<Bitmap> weakReference = this.mWeakBitmap;
                Bitmap bitmap = weakReference != null ? weakReference.get() : null;
                if ((bitmap == null || bitmap.isRecycled()) && (drawable = getDrawable()) != null) {
                    bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmap);
                    drawable.setBounds(0, 0, getWidth(), getHeight());
                    drawable.draw(canvas2);
                    Bitmap bitmap2 = this.mMaskBitmap;
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        this.mMaskBitmap = getBitmap();
                    }
                    this.mPaint.reset();
                    this.mPaint.setFilterBitmap(false);
                    this.mPaint.setXfermode(sXfermode);
                    canvas2.drawBitmap(this.mMaskBitmap, 0.0f, 0.0f, this.mPaint);
                    this.mWeakBitmap = new WeakReference<>(bitmap);
                }
                if (bitmap != null) {
                    this.mPaint.setXfermode(null);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
                    canvas.restoreToCount(saveLayer);
                    return;
                }
            } catch (Exception e) {
                System.gc();
                Log.e(TAG, String.format("Failed to draw, Id :: %s. Error occurred :: %s", Integer.valueOf(getId()), e.toString()));
            } catch (Throwable th) {
                canvas.restoreToCount(saveLayer);
                throw th;
            }
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.onDraw(canvas);
    }
}
