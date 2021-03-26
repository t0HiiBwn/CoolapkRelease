package com.soundcloud.android.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;

class RotateBitmap {
    private Bitmap bitmap;
    private int rotation;

    public RotateBitmap(Bitmap bitmap2, int i) {
        this.bitmap = bitmap2;
        this.rotation = i % 360;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    public int getRotation() {
        return this.rotation;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public Matrix getRotateMatrix() {
        Matrix matrix = new Matrix();
        Bitmap bitmap2 = this.bitmap;
        if (!(bitmap2 == null || this.rotation == 0)) {
            matrix.preTranslate((float) (-(bitmap2.getWidth() / 2)), (float) (-(this.bitmap.getHeight() / 2)));
            matrix.postRotate((float) this.rotation);
            matrix.postTranslate((float) (getWidth() / 2), (float) (getHeight() / 2));
        }
        return matrix;
    }

    public boolean isOrientationChanged() {
        return (this.rotation / 90) % 2 != 0;
    }

    public int getHeight() {
        if (this.bitmap == null) {
            return 0;
        }
        if (isOrientationChanged()) {
            return this.bitmap.getWidth();
        }
        return this.bitmap.getHeight();
    }

    public int getWidth() {
        if (this.bitmap == null) {
            return 0;
        }
        if (isOrientationChanged()) {
            return this.bitmap.getHeight();
        }
        return this.bitmap.getWidth();
    }

    public void recycle() {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.bitmap = null;
        }
    }
}
