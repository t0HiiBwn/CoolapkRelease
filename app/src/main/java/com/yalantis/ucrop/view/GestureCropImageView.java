package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;

public class GestureCropImageView extends CropImageView {
    private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
    private int mDoubleTapScaleSteps;
    private GestureDetector mGestureDetector;
    private boolean mIsRotateEnabled;
    private boolean mIsScaleEnabled;
    private float mMidPntX;
    private float mMidPntY;
    private RotationGestureDetector mRotateDetector;
    private ScaleGestureDetector mScaleDetector;

    public GestureCropImageView(Context context) {
        super(context);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    public void setScaleEnabled(boolean z) {
        this.mIsScaleEnabled = z;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public void setRotateEnabled(boolean z) {
        this.mIsRotateEnabled = z;
    }

    public boolean isRotateEnabled() {
        return this.mIsRotateEnabled;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.mDoubleTapScaleSteps = i;
    }

    public int getDoubleTapScaleSteps() {
        return this.mDoubleTapScaleSteps;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mMidPntX = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.mMidPntY = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (this.mIsScaleEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsRotateEnabled) {
            this.mRotateDetector.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds();
        }
        return true;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    protected void init() {
        super.init();
        setupGestureListeners();
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow((double) (getMaxScale() / getMinScale()), (double) (1.0f / ((float) this.mDoubleTapScaleSteps))));
    }

    private void setupGestureListeners() {
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(), null, true);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        this.mRotateDetector = new RotationGestureDetector(new RotateListener());
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.postScale(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
            return true;
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.zoomImageToPosition(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.postTranslate(-f, -f2);
            return true;
        }
    }

    private class RotateListener extends RotationGestureDetector.SimpleOnRotationGestureListener {
        private RotateListener() {
        }

        @Override // com.yalantis.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener, com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            GestureCropImageView.this.postRotate(rotationGestureDetector.getAngle(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
            return true;
        }
    }
}
