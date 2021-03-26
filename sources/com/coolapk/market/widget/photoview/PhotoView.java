package com.coolapk.market.widget.photoview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;

public class PhotoView extends AppCompatImageView {
    private static final int ANIMA_DURING = 340;
    private static final float MAX_SCALE = 2.5f;
    private static final int MIN_ROTATE = 35;
    private int MAX_ANIM_FROM_WAITE = 500;
    private int MAX_FLING_OVER_SCROLL = 0;
    private int MAX_OVER_RESISTANCE = 0;
    private int MAX_OVER_SCROLL = 0;
    private boolean canRotate;
    private boolean hasDrawable;
    private boolean hasMultiTouch;
    private boolean hasOverTranslate;
    private boolean imgLargeHeight;
    private boolean imgLargeWidth;
    private boolean isEnable = false;
    private boolean isInit;
    private boolean isKnowSize;
    private boolean isRotateEnable = false;
    private boolean isZoonUp;
    private boolean mAdjustViewBounds;
    private int mAnimaDuring;
    private Matrix mAnimaMatrix = new Matrix();
    private Matrix mBaseMatrix = new Matrix();
    private RectF mBaseRect = new RectF();
    private View.OnClickListener mClickListener;
    private Runnable mClickRunnable = new Runnable() {
        /* class com.coolapk.market.widget.photoview.PhotoView.AnonymousClass3 */

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoView.this.mClickListener != null) {
                PhotoView.this.mClickListener.onClick(PhotoView.this);
            }
        }
    };
    private RectF mClip;
    private RectF mCommonRect = new RectF();
    private Runnable mCompleteCallBack;
    private float mDegrees;
    private GestureDetector mDetector;
    private Info mFromInfo;
    private GestureDetector.OnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {
        /* class com.coolapk.market.widget.photoview.PhotoView.AnonymousClass4 */

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoView.this.mLongClick != null) {
                PhotoView.this.mLongClick.onLongClick(PhotoView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            PhotoView.this.hasOverTranslate = false;
            PhotoView.this.hasMultiTouch = false;
            PhotoView.this.canRotate = false;
            PhotoView photoView = PhotoView.this;
            photoView.removeCallbacks(photoView.mClickRunnable);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (PhotoView.this.hasMultiTouch) {
                return false;
            }
            if ((!PhotoView.this.imgLargeWidth && !PhotoView.this.imgLargeHeight) || PhotoView.this.mTranslate.isRuning) {
                return false;
            }
            float f3 = (((float) Math.round(PhotoView.this.mImgRect.left)) >= PhotoView.this.mWidgetRect.left || ((float) Math.round(PhotoView.this.mImgRect.right)) <= PhotoView.this.mWidgetRect.right) ? 0.0f : f;
            float f4 = (((float) Math.round(PhotoView.this.mImgRect.top)) >= PhotoView.this.mWidgetRect.top || ((float) Math.round(PhotoView.this.mImgRect.bottom)) <= PhotoView.this.mWidgetRect.bottom) ? 0.0f : f2;
            if (PhotoView.this.canRotate || PhotoView.this.mDegrees % 90.0f != 0.0f) {
                float f5 = (float) (((int) (PhotoView.this.mDegrees / 90.0f)) * 90);
                float f6 = PhotoView.this.mDegrees % 90.0f;
                if (f6 > 45.0f) {
                    f5 += 90.0f;
                } else if (f6 < -45.0f) {
                    f5 -= 90.0f;
                }
                PhotoView.this.mTranslate.withRotate((int) PhotoView.this.mDegrees, (int) f5);
                PhotoView.this.mDegrees = f5;
            }
            PhotoView photoView = PhotoView.this;
            photoView.doTranslateReset(photoView.mImgRect);
            PhotoView.this.mTranslate.withFling(f3, f4);
            PhotoView.this.mTranslate.start();
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (PhotoView.this.mTranslate.isRuning) {
                PhotoView.this.mTranslate.stop();
            }
            if (PhotoView.this.canScrollHorizontallySelf(f)) {
                if (f < 0.0f && PhotoView.this.mImgRect.left - f > PhotoView.this.mWidgetRect.left) {
                    f = PhotoView.this.mImgRect.left;
                }
                if (f > 0.0f && PhotoView.this.mImgRect.right - f < PhotoView.this.mWidgetRect.right) {
                    f = PhotoView.this.mImgRect.right - PhotoView.this.mWidgetRect.right;
                }
                PhotoView.this.mAnimaMatrix.postTranslate(-f, 0.0f);
                PhotoView photoView = PhotoView.this;
                photoView.mTranslateX = (int) (((float) photoView.mTranslateX) - f);
            } else if (PhotoView.this.imgLargeWidth || PhotoView.this.hasMultiTouch || PhotoView.this.hasOverTranslate) {
                PhotoView.this.checkRect();
                if (!PhotoView.this.hasMultiTouch) {
                    if (f < 0.0f && PhotoView.this.mImgRect.left - f > PhotoView.this.mCommonRect.left) {
                        PhotoView photoView2 = PhotoView.this;
                        f = photoView2.resistanceScrollByX(photoView2.mImgRect.left - PhotoView.this.mCommonRect.left, f);
                    }
                    if (f > 0.0f && PhotoView.this.mImgRect.right - f < PhotoView.this.mCommonRect.right) {
                        PhotoView photoView3 = PhotoView.this;
                        f = photoView3.resistanceScrollByX(photoView3.mImgRect.right - PhotoView.this.mCommonRect.right, f);
                    }
                }
                PhotoView photoView4 = PhotoView.this;
                photoView4.mTranslateX = (int) (((float) photoView4.mTranslateX) - f);
                PhotoView.this.mAnimaMatrix.postTranslate(-f, 0.0f);
                PhotoView.this.hasOverTranslate = true;
            }
            if (PhotoView.this.canScrollVerticallySelf(f2)) {
                if (f2 < 0.0f && PhotoView.this.mImgRect.top - f2 > PhotoView.this.mWidgetRect.top) {
                    f2 = PhotoView.this.mImgRect.top;
                }
                if (f2 > 0.0f && PhotoView.this.mImgRect.bottom - f2 < PhotoView.this.mWidgetRect.bottom) {
                    f2 = PhotoView.this.mImgRect.bottom - PhotoView.this.mWidgetRect.bottom;
                }
                PhotoView.this.mAnimaMatrix.postTranslate(0.0f, -f2);
                PhotoView photoView5 = PhotoView.this;
                photoView5.mTranslateY = (int) (((float) photoView5.mTranslateY) - f2);
            } else if (PhotoView.this.imgLargeHeight || PhotoView.this.hasOverTranslate || PhotoView.this.hasMultiTouch) {
                PhotoView.this.checkRect();
                if (!PhotoView.this.hasMultiTouch) {
                    if (f2 < 0.0f && PhotoView.this.mImgRect.top - f2 > PhotoView.this.mCommonRect.top) {
                        PhotoView photoView6 = PhotoView.this;
                        f2 = photoView6.resistanceScrollByY(photoView6.mImgRect.top - PhotoView.this.mCommonRect.top, f2);
                    }
                    if (f2 > 0.0f && PhotoView.this.mImgRect.bottom - f2 < PhotoView.this.mCommonRect.bottom) {
                        PhotoView photoView7 = PhotoView.this;
                        f2 = photoView7.resistanceScrollByY(photoView7.mImgRect.bottom - PhotoView.this.mCommonRect.bottom, f2);
                    }
                }
                PhotoView.this.mAnimaMatrix.postTranslate(0.0f, -f2);
                PhotoView photoView8 = PhotoView.this;
                photoView8.mTranslateY = (int) (((float) photoView8.mTranslateY) - f2);
                PhotoView.this.hasOverTranslate = true;
            }
            PhotoView.this.executeTranslate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            PhotoView photoView = PhotoView.this;
            photoView.postDelayed(photoView.mClickRunnable, 250);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            float f;
            float f2;
            PhotoView.this.mTranslate.stop();
            float width = PhotoView.this.mImgRect.left + (PhotoView.this.mImgRect.width() / 2.0f);
            float height = PhotoView.this.mImgRect.top + (PhotoView.this.mImgRect.height() / 2.0f);
            PhotoView.this.mScaleCenter.set(width, height);
            PhotoView.this.mRotateCenter.set(width, height);
            PhotoView.this.mTranslateX = 0;
            PhotoView.this.mTranslateY = 0;
            if (PhotoView.this.isZoonUp) {
                f = PhotoView.this.mScale;
                f2 = 1.0f;
            } else {
                float f3 = PhotoView.this.mScale;
                float f4 = PhotoView.this.mMaxScale;
                PhotoView.this.mScaleCenter.set(motionEvent.getX(), motionEvent.getY());
                f = f3;
                f2 = f4;
            }
            PhotoView.this.mTmpMatrix.reset();
            PhotoView.this.mTmpMatrix.postTranslate(-PhotoView.this.mBaseRect.left, -PhotoView.this.mBaseRect.top);
            PhotoView.this.mTmpMatrix.postTranslate(PhotoView.this.mRotateCenter.x, PhotoView.this.mRotateCenter.y);
            PhotoView.this.mTmpMatrix.postTranslate(-PhotoView.this.mHalfBaseRectWidth, -PhotoView.this.mHalfBaseRectHeight);
            PhotoView.this.mTmpMatrix.postRotate(PhotoView.this.mDegrees, PhotoView.this.mRotateCenter.x, PhotoView.this.mRotateCenter.y);
            PhotoView.this.mTmpMatrix.postScale(f2, f2, PhotoView.this.mScaleCenter.x, PhotoView.this.mScaleCenter.y);
            PhotoView.this.mTmpMatrix.postTranslate((float) PhotoView.this.mTranslateX, (float) PhotoView.this.mTranslateY);
            PhotoView.this.mTmpMatrix.mapRect(PhotoView.this.mTmpRect, PhotoView.this.mBaseRect);
            PhotoView photoView = PhotoView.this;
            photoView.doTranslateReset(photoView.mTmpRect);
            PhotoView photoView2 = PhotoView.this;
            photoView2.isZoonUp = !photoView2.isZoonUp;
            PhotoView.this.mTranslate.withScale(f, f2);
            PhotoView.this.mTranslate.start();
            return false;
        }
    };
    private float mHalfBaseRectHeight;
    private float mHalfBaseRectWidth;
    private RectF mImgRect = new RectF();
    private long mInfoTime;
    private View.OnLongClickListener mLongClick;
    private float mMaxScale;
    private int mMinRotate;
    private PointF mRotateCenter = new PointF();
    private RotateGestureDetector mRotateDetector;
    private float mRotateFlag;
    private OnRotateListener mRotateListener = new OnRotateListener() {
        /* class com.coolapk.market.widget.photoview.PhotoView.AnonymousClass1 */

        @Override // com.coolapk.market.widget.photoview.OnRotateListener
        public void onRotate(float f, float f2, float f3) {
            PhotoView.this.mRotateFlag += f;
            if (PhotoView.this.canRotate) {
                PhotoView.this.mDegrees += f;
                PhotoView.this.mAnimaMatrix.postRotate(f, f2, f3);
            } else if (Math.abs(PhotoView.this.mRotateFlag) >= ((float) PhotoView.this.mMinRotate)) {
                PhotoView.this.canRotate = true;
                PhotoView.this.mRotateFlag = 0.0f;
            }
        }
    };
    private float mScale = 1.0f;
    private PointF mScaleCenter = new PointF();
    private ScaleGestureDetector mScaleDetector;
    private ScaleGestureDetector.OnScaleGestureListener mScaleListener = new ScaleGestureDetector.OnScaleGestureListener() {
        /* class com.coolapk.market.widget.photoview.PhotoView.AnonymousClass2 */

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            PhotoView.this.mScale *= scaleFactor;
            PhotoView.this.mAnimaMatrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            PhotoView.this.executeTranslate();
            return true;
        }
    };
    private ImageView.ScaleType mScaleType;
    private PointF mScreenCenter = new PointF();
    private Matrix mSynthesisMatrix = new Matrix();
    private Matrix mTmpMatrix = new Matrix();
    private RectF mTmpRect = new RectF();
    private Transform mTranslate = new Transform();
    private int mTranslateX;
    private int mTranslateY;
    private RectF mWidgetRect = new RectF();

    public interface ClipCalculate {
        float calculateTop();
    }

    public int getDefaultAnimaDuring() {
        return 340;
    }

    public PhotoView(Context context) {
        super(context);
        init();
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.mScaleType == null) {
            this.mScaleType = ImageView.ScaleType.CENTER_INSIDE;
        }
        this.mRotateDetector = new RotateGestureDetector(this.mRotateListener);
        this.mDetector = new GestureDetector(getContext(), this.mGestureListener);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), this.mScaleListener);
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (30.0f * f);
        this.MAX_OVER_SCROLL = i;
        this.MAX_FLING_OVER_SCROLL = i;
        this.MAX_OVER_RESISTANCE = (int) (f * 140.0f);
        this.mMinRotate = 35;
        this.mAnimaDuring = 340;
        this.mMaxScale = 2.5f;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mClickListener = onClickListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != ImageView.ScaleType.MATRIX && scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            if (this.isInit) {
                initBase();
            }
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClick = onLongClickListener;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mTranslate.setInterpolator(interpolator);
    }

    public int getAnimaDuring() {
        return this.mAnimaDuring;
    }

    public void setAnimaDuring(int i) {
        this.mAnimaDuring = i;
    }

    public void setMaxScale(float f) {
        this.mMaxScale = f;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public void enable() {
        this.isEnable = true;
    }

    public void disenable() {
        this.isEnable = false;
    }

    public void enableRotate() {
        this.isRotateEnable = true;
    }

    public void disableRotate() {
        this.isRotateEnable = false;
    }

    public void setMaxAnimFromWaiteTime(int i) {
        this.MAX_ANIM_FROM_WAITE = i;
    }

    public boolean getIsZoonUp() {
        return this.isZoonUp;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        Drawable drawable;
        try {
            drawable = getResources().getDrawable(i);
        } catch (Exception unused) {
            drawable = null;
        }
        setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable == null) {
            this.hasDrawable = false;
        } else if (hasSize(drawable)) {
            if (!this.hasDrawable) {
                this.hasDrawable = true;
            }
            initBase();
        }
    }

    private boolean hasSize(Drawable drawable) {
        if (drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            return true;
        }
        if (drawable.getMinimumWidth() <= 0 || drawable.getMinimumHeight() <= 0) {
            return drawable.getBounds().width() > 0 && drawable.getBounds().height() > 0;
        }
        return true;
    }

    private static int getDrawableWidth(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = drawable.getMinimumWidth();
        }
        return intrinsicWidth <= 0 ? drawable.getBounds().width() : intrinsicWidth;
    }

    private static int getDrawableHeight(Drawable drawable) {
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = drawable.getMinimumHeight();
        }
        return intrinsicHeight <= 0 ? drawable.getBounds().height() : intrinsicHeight;
    }

    private void initBase() {
        if (this.hasDrawable && this.isKnowSize) {
            this.mBaseMatrix.reset();
            this.mAnimaMatrix.reset();
            this.isZoonUp = false;
            Drawable drawable = getDrawable();
            int width = getWidth();
            int height = getHeight();
            int drawableWidth = getDrawableWidth(drawable);
            int drawableHeight = getDrawableHeight(drawable);
            float f = (float) drawableWidth;
            float f2 = (float) drawableHeight;
            this.mBaseRect.set(0.0f, 0.0f, f, f2);
            int i = (width - drawableWidth) / 2;
            int i2 = (height - drawableHeight) / 2;
            float f3 = 1.0f;
            float f4 = drawableWidth > width ? ((float) width) / f : 1.0f;
            if (drawableHeight > height) {
                f3 = ((float) height) / f2;
            }
            if (f4 >= f3) {
                f4 = f3;
            }
            this.mBaseMatrix.reset();
            this.mBaseMatrix.postTranslate((float) i, (float) i2);
            this.mBaseMatrix.postScale(f4, f4, this.mScreenCenter.x, this.mScreenCenter.y);
            this.mBaseMatrix.mapRect(this.mBaseRect);
            this.mHalfBaseRectWidth = this.mBaseRect.width() / 2.0f;
            this.mHalfBaseRectHeight = this.mBaseRect.height() / 2.0f;
            this.mScaleCenter.set(this.mScreenCenter);
            this.mRotateCenter.set(this.mScaleCenter);
            executeTranslate();
            switch (AnonymousClass6.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                case 1:
                    initCenter();
                    break;
                case 2:
                    initCenterCrop();
                    break;
                case 3:
                    initCenterInside();
                    break;
                case 4:
                    initFitCenter();
                    break;
                case 5:
                    initFitStart();
                    break;
                case 6:
                    initFitEnd();
                    break;
                case 7:
                    initFitXY();
                    break;
            }
            this.isInit = true;
            if (this.mFromInfo != null && System.currentTimeMillis() - this.mInfoTime < ((long) this.MAX_ANIM_FROM_WAITE)) {
                animaFrom(this.mFromInfo);
            }
            this.mFromInfo = null;
        }
    }

    /* renamed from: com.coolapk.market.widget.photoview.PhotoView$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void initCenter() {
        if (this.hasDrawable && this.isKnowSize) {
            Drawable drawable = getDrawable();
            int drawableWidth = getDrawableWidth(drawable);
            int drawableHeight = getDrawableHeight(drawable);
            float f = (float) drawableWidth;
            if (f > this.mWidgetRect.width() || ((float) drawableHeight) > this.mWidgetRect.height()) {
                float width = f / this.mImgRect.width();
                float height = ((float) drawableHeight) / this.mImgRect.height();
                if (width <= height) {
                    width = height;
                }
                this.mScale = width;
                this.mAnimaMatrix.postScale(width, width, this.mScreenCenter.x, this.mScreenCenter.y);
                executeTranslate();
                resetBase();
            }
        }
    }

    private void initCenterCrop() {
        if (this.mImgRect.width() < this.mWidgetRect.width() || this.mImgRect.height() < this.mWidgetRect.height()) {
            float width = this.mWidgetRect.width() / this.mImgRect.width();
            float height = this.mWidgetRect.height() / this.mImgRect.height();
            if (width <= height) {
                width = height;
            }
            this.mScale = width;
            this.mAnimaMatrix.postScale(width, width, this.mScreenCenter.x, this.mScreenCenter.y);
            executeTranslate();
            resetBase();
        }
    }

    private void initCenterInside() {
        if (this.mImgRect.width() > this.mWidgetRect.width() || this.mImgRect.height() > this.mWidgetRect.height()) {
            float width = this.mWidgetRect.width() / this.mImgRect.width();
            float height = this.mWidgetRect.height() / this.mImgRect.height();
            if (width >= height) {
                width = height;
            }
            this.mScale = width;
            this.mAnimaMatrix.postScale(width, width, this.mScreenCenter.x, this.mScreenCenter.y);
            executeTranslate();
            resetBase();
        }
    }

    private void initFitCenter() {
        if (this.mImgRect.width() < this.mWidgetRect.width()) {
            float width = this.mWidgetRect.width() / this.mImgRect.width();
            this.mScale = width;
            this.mAnimaMatrix.postScale(width, width, this.mScreenCenter.x, this.mScreenCenter.y);
            executeTranslate();
            resetBase();
        }
    }

    private void initFitStart() {
        initFitCenter();
        float f = -this.mImgRect.top;
        this.mAnimaMatrix.postTranslate(0.0f, f);
        executeTranslate();
        resetBase();
        this.mTranslateY = (int) (((float) this.mTranslateY) + f);
    }

    private void initFitEnd() {
        initFitCenter();
        float f = this.mWidgetRect.bottom - this.mImgRect.bottom;
        this.mTranslateY = (int) (((float) this.mTranslateY) + f);
        this.mAnimaMatrix.postTranslate(0.0f, f);
        executeTranslate();
        resetBase();
    }

    private void initFitXY() {
        this.mAnimaMatrix.postScale(this.mWidgetRect.width() / this.mImgRect.width(), this.mWidgetRect.height() / this.mImgRect.height(), this.mScreenCenter.x, this.mScreenCenter.y);
        executeTranslate();
        resetBase();
    }

    private void resetBase() {
        Drawable drawable = getDrawable();
        this.mBaseRect.set(0.0f, 0.0f, (float) getDrawableWidth(drawable), (float) getDrawableHeight(drawable));
        this.mBaseMatrix.set(this.mSynthesisMatrix);
        this.mBaseMatrix.mapRect(this.mBaseRect);
        this.mHalfBaseRectWidth = this.mBaseRect.width() / 2.0f;
        this.mHalfBaseRectHeight = this.mBaseRect.height() / 2.0f;
        this.mScale = 1.0f;
        this.mTranslateX = 0;
        this.mTranslateY = 0;
        this.mAnimaMatrix.reset();
    }

    /* access modifiers changed from: private */
    public void executeTranslate() {
        this.mSynthesisMatrix.set(this.mBaseMatrix);
        this.mSynthesisMatrix.postConcat(this.mAnimaMatrix);
        setImageMatrix(this.mSynthesisMatrix);
        this.mAnimaMatrix.mapRect(this.mImgRect, this.mBaseRect);
        boolean z = true;
        this.imgLargeWidth = this.mImgRect.width() > this.mWidgetRect.width();
        if (this.mImgRect.height() <= this.mWidgetRect.height()) {
            z = false;
        }
        this.imgLargeHeight = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.hasDrawable) {
            super.onMeasure(i, i2);
            return;
        }
        Drawable drawable = getDrawable();
        int drawableWidth = getDrawableWidth(drawable);
        int drawableHeight = getDrawableHeight(drawable);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        if (layoutParams.width != -1 ? mode != 1073741824 && (mode != Integer.MIN_VALUE || drawableWidth <= size) : mode == 0) {
            size = drawableWidth;
        }
        if (layoutParams.height != -1 ? mode2 != 1073741824 && (mode2 != Integer.MIN_VALUE || drawableHeight <= size2) : mode2 == 0) {
            size2 = drawableHeight;
        }
        if (this.mAdjustViewBounds) {
            float f = (float) drawableWidth;
            float f2 = (float) drawableHeight;
            float f3 = (float) size;
            float f4 = (float) size2;
            if (f / f2 != f3 / f4) {
                float f5 = f4 / f2;
                float f6 = f3 / f;
                if (f5 >= f6) {
                    f5 = f6;
                }
                if (layoutParams.width != -1) {
                    size = (int) (f * f5);
                }
                if (layoutParams.height != -1) {
                    size2 = (int) (f2 * f5);
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        super.setAdjustViewBounds(z);
        this.mAdjustViewBounds = z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidgetRect.set(0.0f, 0.0f, (float) i, (float) i2);
        this.mScreenCenter.set((float) (i / 2), (float) (i2 / 2));
        if (!this.isKnowSize) {
            this.isKnowSize = true;
            initBase();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        RectF rectF = this.mClip;
        if (rectF != null) {
            canvas.clipRect(rectF);
            this.mClip = null;
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnable) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (motionEvent.getPointerCount() >= 2) {
            this.hasMultiTouch = true;
        }
        this.mDetector.onTouchEvent(motionEvent);
        if (this.isRotateEnable) {
            this.mRotateDetector.onTouchEvent(motionEvent);
        }
        this.mScaleDetector.onTouchEvent(motionEvent);
        if (actionMasked == 1 || actionMasked == 3) {
            onUp();
        }
        return true;
    }

    private void onUp() {
        if (!this.mTranslate.isRuning) {
            if (this.canRotate || this.mDegrees % 90.0f != 0.0f) {
                float f = this.mDegrees;
                float f2 = (float) (((int) (f / 90.0f)) * 90);
                float f3 = f % 90.0f;
                if (f3 > 45.0f) {
                    f2 += 90.0f;
                } else if (f3 < -45.0f) {
                    f2 -= 90.0f;
                }
                this.mTranslate.withRotate((int) f, (int) f2);
                this.mDegrees = f2;
            }
            float f4 = this.mScale;
            if (f4 < 1.0f) {
                this.mTranslate.withScale(f4, 1.0f);
                f4 = 1.0f;
            } else {
                float f5 = this.mMaxScale;
                if (f4 > f5) {
                    this.mTranslate.withScale(f4, f5);
                    f4 = f5;
                }
            }
            float width = this.mImgRect.left + (this.mImgRect.width() / 2.0f);
            float height = this.mImgRect.top + (this.mImgRect.height() / 2.0f);
            this.mScaleCenter.set(width, height);
            this.mRotateCenter.set(width, height);
            this.mTranslateX = 0;
            this.mTranslateY = 0;
            this.mTmpMatrix.reset();
            this.mTmpMatrix.postTranslate(-this.mBaseRect.left, -this.mBaseRect.top);
            this.mTmpMatrix.postTranslate(width - this.mHalfBaseRectWidth, height - this.mHalfBaseRectHeight);
            this.mTmpMatrix.postScale(f4, f4, width, height);
            this.mTmpMatrix.postRotate(this.mDegrees, width, height);
            this.mTmpMatrix.mapRect(this.mTmpRect, this.mBaseRect);
            doTranslateReset(this.mTmpRect);
            this.mTranslate.start();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6  */
    public void doTranslateReset(RectF rectF) {
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        int i2 = 0;
        if (rectF.width() > this.mWidgetRect.width()) {
            if (rectF.left > this.mWidgetRect.left) {
                f3 = rectF.left;
                f4 = this.mWidgetRect.left;
            } else if (rectF.right < this.mWidgetRect.right) {
                f3 = rectF.right;
                f4 = this.mWidgetRect.right;
            }
            i = (int) (f3 - f4);
            if (rectF.height() > this.mWidgetRect.height()) {
            }
            if (i == 0) {
            }
            if (!this.mTranslate.mFlingScroller.isFinished()) {
            }
            this.mTranslate.withTranslate(this.mTranslateX, this.mTranslateY, -i, -i2);
        } else if (!isImageCenterWidth(rectF)) {
            i = -((int) (((this.mWidgetRect.width() - rectF.width()) / 2.0f) - rectF.left));
            if (rectF.height() > this.mWidgetRect.height()) {
                if (rectF.top > this.mWidgetRect.top) {
                    f = rectF.top;
                    f2 = this.mWidgetRect.top;
                } else if (rectF.bottom < this.mWidgetRect.bottom) {
                    f = rectF.bottom;
                    f2 = this.mWidgetRect.bottom;
                }
                i2 = (int) (f - f2);
            } else if (!isImageCenterHeight(rectF)) {
                i2 = -((int) (((this.mWidgetRect.height() - rectF.height()) / 2.0f) - rectF.top));
            }
            if (i == 0 || i2 != 0) {
                if (!this.mTranslate.mFlingScroller.isFinished()) {
                    this.mTranslate.mFlingScroller.abortAnimation();
                }
                this.mTranslate.withTranslate(this.mTranslateX, this.mTranslateY, -i, -i2);
            }
            return;
        }
        i = 0;
        if (rectF.height() > this.mWidgetRect.height()) {
        }
        if (i == 0) {
        }
        if (!this.mTranslate.mFlingScroller.isFinished()) {
        }
        this.mTranslate.withTranslate(this.mTranslateX, this.mTranslateY, -i, -i2);
    }

    private boolean isImageCenterHeight(RectF rectF) {
        return Math.abs(((float) Math.round(rectF.top)) - ((this.mWidgetRect.height() - rectF.height()) / 2.0f)) < 1.0f;
    }

    private boolean isImageCenterWidth(RectF rectF) {
        return Math.abs(((float) Math.round(rectF.left)) - ((this.mWidgetRect.width() - rectF.width()) / 2.0f)) < 1.0f;
    }

    /* access modifiers changed from: private */
    public float resistanceScrollByX(float f, float f2) {
        return f2 * (Math.abs(Math.abs(f) - ((float) this.MAX_OVER_RESISTANCE)) / ((float) this.MAX_OVER_RESISTANCE));
    }

    /* access modifiers changed from: private */
    public float resistanceScrollByY(float f, float f2) {
        return f2 * (Math.abs(Math.abs(f) - ((float) this.MAX_OVER_RESISTANCE)) / ((float) this.MAX_OVER_RESISTANCE));
    }

    private void mapRect(RectF rectF, RectF rectF2, RectF rectF3) {
        float f = rectF.left > rectF2.left ? rectF.left : rectF2.left;
        float f2 = rectF.right < rectF2.right ? rectF.right : rectF2.right;
        if (f > f2) {
            rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        float f3 = rectF.top > rectF2.top ? rectF.top : rectF2.top;
        float f4 = rectF.bottom < rectF2.bottom ? rectF.bottom : rectF2.bottom;
        if (f3 > f4) {
            rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            rectF3.set(f, f3, f2, f4);
        }
    }

    /* access modifiers changed from: private */
    public void checkRect() {
        if (!this.hasOverTranslate) {
            mapRect(this.mWidgetRect, this.mImgRect, this.mCommonRect);
        }
    }

    public void manualZoomUp(float f, float f2) {
        float f3;
        float f4;
        this.mTranslate.stop();
        float width = this.mImgRect.left + (this.mImgRect.width() / 2.0f);
        float height = this.mImgRect.top + (this.mImgRect.height() / 2.0f);
        this.mScaleCenter.set(width, height);
        this.mRotateCenter.set(width, height);
        this.mTranslateX = 0;
        this.mTranslateY = 0;
        if (this.isZoonUp) {
            f4 = this.mScale;
            f3 = 1.0f;
        } else {
            float f5 = this.mScale;
            float f6 = this.mMaxScale;
            this.mScaleCenter.set(f, f2);
            f4 = f5;
            f3 = f6;
        }
        this.mTmpMatrix.reset();
        this.mTmpMatrix.postTranslate(-this.mBaseRect.left, -this.mBaseRect.top);
        this.mTmpMatrix.postTranslate(this.mRotateCenter.x, this.mRotateCenter.y);
        this.mTmpMatrix.postTranslate(-this.mHalfBaseRectWidth, -this.mHalfBaseRectHeight);
        this.mTmpMatrix.postRotate(this.mDegrees, this.mRotateCenter.x, this.mRotateCenter.y);
        this.mTmpMatrix.postScale(f3, f3, this.mScaleCenter.x, this.mScaleCenter.y);
        this.mTmpMatrix.postTranslate((float) this.mTranslateX, (float) this.mTranslateY);
        this.mTmpMatrix.mapRect(this.mTmpRect, this.mBaseRect);
        doTranslateReset(this.mTmpRect);
        this.isZoonUp = !this.isZoonUp;
        this.mTranslate.withScale(f4, f3);
        this.mTranslate.start();
    }

    public boolean canScrollHorizontallySelf(float f) {
        if (this.mImgRect.width() <= this.mWidgetRect.width()) {
            return false;
        }
        if (f < 0.0f && ((float) Math.round(this.mImgRect.left)) - f >= this.mWidgetRect.left) {
            return false;
        }
        if (f <= 0.0f || ((float) Math.round(this.mImgRect.right)) - f > this.mWidgetRect.right) {
            return true;
        }
        return false;
    }

    public boolean canScrollVerticallySelf(float f) {
        if (this.mImgRect.height() <= this.mWidgetRect.height()) {
            return false;
        }
        if (f < 0.0f && ((float) Math.round(this.mImgRect.top)) - f >= this.mWidgetRect.top) {
            return false;
        }
        if (f <= 0.0f || ((float) Math.round(this.mImgRect.bottom)) - f > this.mWidgetRect.bottom) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.hasMultiTouch) {
            return true;
        }
        return canScrollHorizontallySelf((float) i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (this.hasMultiTouch) {
            return true;
        }
        return canScrollVerticallySelf((float) i);
    }

    private class InterpolatorProxy implements Interpolator {
        private Interpolator mTarget;

        private InterpolatorProxy() {
            this.mTarget = new DecelerateInterpolator();
        }

        public void setTargetInterpolator(Interpolator interpolator) {
            this.mTarget = interpolator;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            Interpolator interpolator = this.mTarget;
            return interpolator != null ? interpolator.getInterpolation(f) : f;
        }
    }

    private class Transform implements Runnable {
        ClipCalculate C;
        boolean isRuning;
        RectF mClipRect = new RectF();
        Scroller mClipScroller;
        OverScroller mFlingScroller;
        InterpolatorProxy mInterpolatorProxy;
        int mLastFlingX;
        int mLastFlingY;
        int mLastTranslateX;
        int mLastTranslateY;
        Scroller mRotateScroller;
        Scroller mScaleScroller;
        OverScroller mTranslateScroller;

        Transform() {
            this.mInterpolatorProxy = new InterpolatorProxy();
            Context context = PhotoView.this.getContext();
            this.mTranslateScroller = new OverScroller(context, this.mInterpolatorProxy);
            this.mScaleScroller = new Scroller(context, this.mInterpolatorProxy);
            this.mFlingScroller = new OverScroller(context, this.mInterpolatorProxy);
            this.mClipScroller = new Scroller(context, this.mInterpolatorProxy);
            this.mRotateScroller = new Scroller(context, this.mInterpolatorProxy);
        }

        public void setInterpolator(Interpolator interpolator) {
            this.mInterpolatorProxy.setTargetInterpolator(interpolator);
        }

        void withTranslate(int i, int i2, int i3, int i4) {
            this.mLastTranslateX = 0;
            this.mLastTranslateY = 0;
            this.mTranslateScroller.startScroll(0, 0, i3, i4, PhotoView.this.mAnimaDuring);
        }

        void withScale(float f, float f2) {
            this.mScaleScroller.startScroll((int) (f * 10000.0f), 0, (int) ((f2 - f) * 10000.0f), 0, PhotoView.this.mAnimaDuring);
        }

        void withClip(float f, float f2, float f3, float f4, int i, ClipCalculate clipCalculate) {
            this.mClipScroller.startScroll((int) (f * 10000.0f), (int) (f2 * 10000.0f), (int) (f3 * 10000.0f), (int) (f4 * 10000.0f), i);
            this.C = clipCalculate;
        }

        void withRotate(int i, int i2) {
            this.mRotateScroller.startScroll(i, 0, i2 - i, 0, PhotoView.this.mAnimaDuring);
        }

        void withRotate(int i, int i2, int i3) {
            this.mRotateScroller.startScroll(i, 0, i2 - i, 0, i3);
        }

        void withFling(float f, float f2) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            this.mLastFlingX = i5 < 0 ? Integer.MAX_VALUE : 0;
            int i6 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            RectF rectF = PhotoView.this.mImgRect;
            int abs = (int) (i6 > 0 ? Math.abs(rectF.left) : rectF.right - PhotoView.this.mWidgetRect.right);
            if (i5 < 0) {
                abs = Integer.MAX_VALUE - abs;
            }
            int i7 = i5 < 0 ? abs : 0;
            int i8 = i5 < 0 ? Integer.MAX_VALUE : abs;
            if (i5 < 0) {
                abs = Integer.MAX_VALUE - i7;
            }
            int i9 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            this.mLastFlingY = i9 < 0 ? Integer.MAX_VALUE : 0;
            int i10 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            RectF rectF2 = PhotoView.this.mImgRect;
            int abs2 = (int) (i10 > 0 ? Math.abs(rectF2.top) : rectF2.bottom - PhotoView.this.mWidgetRect.bottom);
            if (i9 < 0) {
                abs2 = Integer.MAX_VALUE - abs2;
            }
            int i11 = i9 < 0 ? abs2 : 0;
            int i12 = i9 < 0 ? Integer.MAX_VALUE : abs2;
            if (i9 < 0) {
                abs2 = Integer.MAX_VALUE - i11;
            }
            if (i6 == 0) {
                i2 = 0;
                i = 0;
            } else {
                i2 = i7;
                i = i8;
            }
            if (i10 == 0) {
                i4 = 0;
                i3 = 0;
            } else {
                i4 = i11;
                i3 = i12;
            }
            this.mFlingScroller.fling(this.mLastFlingX, this.mLastFlingY, (int) f, (int) f2, i2, i, i4, i3, Math.abs(abs) < PhotoView.this.MAX_FLING_OVER_SCROLL * 2 ? 0 : PhotoView.this.MAX_FLING_OVER_SCROLL, Math.abs(abs2) < PhotoView.this.MAX_FLING_OVER_SCROLL * 2 ? 0 : PhotoView.this.MAX_FLING_OVER_SCROLL);
        }

        void start() {
            this.isRuning = true;
            postExecute();
        }

        void stop() {
            PhotoView.this.removeCallbacks(this);
            this.mTranslateScroller.abortAnimation();
            this.mScaleScroller.abortAnimation();
            this.mFlingScroller.abortAnimation();
            this.mRotateScroller.abortAnimation();
            this.isRuning = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2 = true;
            boolean z3 = false;
            if (this.mScaleScroller.computeScrollOffset()) {
                PhotoView.this.mScale = ((float) this.mScaleScroller.getCurrX()) / 10000.0f;
                z = false;
            } else {
                z = true;
            }
            if (this.mTranslateScroller.computeScrollOffset()) {
                int currX = this.mTranslateScroller.getCurrX() - this.mLastTranslateX;
                int currY = this.mTranslateScroller.getCurrY() - this.mLastTranslateY;
                PhotoView.this.mTranslateX += currX;
                PhotoView.this.mTranslateY += currY;
                this.mLastTranslateX = this.mTranslateScroller.getCurrX();
                this.mLastTranslateY = this.mTranslateScroller.getCurrY();
                z = false;
            }
            if (this.mFlingScroller.computeScrollOffset()) {
                int currX2 = this.mFlingScroller.getCurrX() - this.mLastFlingX;
                int currY2 = this.mFlingScroller.getCurrY() - this.mLastFlingY;
                this.mLastFlingX = this.mFlingScroller.getCurrX();
                this.mLastFlingY = this.mFlingScroller.getCurrY();
                PhotoView.this.mTranslateX += currX2;
                PhotoView.this.mTranslateY += currY2;
                z = false;
            }
            if (this.mRotateScroller.computeScrollOffset()) {
                PhotoView.this.mDegrees = (float) this.mRotateScroller.getCurrX();
                z = false;
            }
            if (this.mClipScroller.computeScrollOffset() || PhotoView.this.mClip != null) {
                float currX3 = ((float) this.mClipScroller.getCurrX()) / 10000.0f;
                float currY3 = ((float) this.mClipScroller.getCurrY()) / 10000.0f;
                PhotoView.this.mTmpMatrix.setScale(currX3, currY3, (PhotoView.this.mImgRect.left + PhotoView.this.mImgRect.right) / 2.0f, this.C.calculateTop());
                PhotoView.this.mTmpMatrix.mapRect(this.mClipRect, PhotoView.this.mImgRect);
                if (currX3 == 1.0f) {
                    this.mClipRect.left = PhotoView.this.mWidgetRect.left;
                    this.mClipRect.right = PhotoView.this.mWidgetRect.right;
                }
                if (currY3 == 1.0f) {
                    this.mClipRect.top = PhotoView.this.mWidgetRect.top;
                    this.mClipRect.bottom = PhotoView.this.mWidgetRect.bottom;
                }
                PhotoView.this.mClip = this.mClipRect;
            }
            if (!z) {
                applyAnima();
                postExecute();
                return;
            }
            this.isRuning = false;
            if (PhotoView.this.imgLargeWidth) {
                if (PhotoView.this.mImgRect.left > 0.0f) {
                    PhotoView photoView = PhotoView.this;
                    photoView.mTranslateX = (int) (((float) photoView.mTranslateX) - PhotoView.this.mImgRect.left);
                } else if (PhotoView.this.mImgRect.right < PhotoView.this.mWidgetRect.width()) {
                    PhotoView.this.mTranslateX -= (int) (PhotoView.this.mWidgetRect.width() - PhotoView.this.mImgRect.right);
                }
                z3 = true;
            }
            if (!PhotoView.this.imgLargeHeight) {
                z2 = z3;
            } else if (PhotoView.this.mImgRect.top > 0.0f) {
                PhotoView photoView2 = PhotoView.this;
                photoView2.mTranslateY = (int) (((float) photoView2.mTranslateY) - PhotoView.this.mImgRect.top);
            } else if (PhotoView.this.mImgRect.bottom < PhotoView.this.mWidgetRect.height()) {
                PhotoView.this.mTranslateY -= (int) (PhotoView.this.mWidgetRect.height() - PhotoView.this.mImgRect.bottom);
            }
            if (z2) {
                applyAnima();
            }
            PhotoView.this.invalidate();
            if (PhotoView.this.mCompleteCallBack != null) {
                PhotoView.this.mCompleteCallBack.run();
                PhotoView.this.mCompleteCallBack = null;
            }
        }

        private void applyAnima() {
            PhotoView.this.mAnimaMatrix.reset();
            PhotoView.this.mAnimaMatrix.postTranslate(-PhotoView.this.mBaseRect.left, -PhotoView.this.mBaseRect.top);
            PhotoView.this.mAnimaMatrix.postTranslate(PhotoView.this.mRotateCenter.x, PhotoView.this.mRotateCenter.y);
            PhotoView.this.mAnimaMatrix.postTranslate(-PhotoView.this.mHalfBaseRectWidth, -PhotoView.this.mHalfBaseRectHeight);
            PhotoView.this.mAnimaMatrix.postRotate(PhotoView.this.mDegrees, PhotoView.this.mRotateCenter.x, PhotoView.this.mRotateCenter.y);
            PhotoView.this.mAnimaMatrix.postScale(PhotoView.this.mScale, PhotoView.this.mScale, PhotoView.this.mScaleCenter.x, PhotoView.this.mScaleCenter.y);
            PhotoView.this.mAnimaMatrix.postTranslate((float) PhotoView.this.mTranslateX, (float) PhotoView.this.mTranslateY);
            PhotoView.this.executeTranslate();
        }

        private void postExecute() {
            if (this.isRuning) {
                PhotoView.this.post(this);
            }
        }
    }

    public Info getInfo() {
        RectF rectF = new RectF();
        int[] iArr = new int[2];
        getLocation(this, iArr);
        rectF.set(((float) iArr[0]) + this.mImgRect.left, ((float) iArr[1]) + this.mImgRect.top, ((float) iArr[0]) + this.mImgRect.right, ((float) iArr[1]) + this.mImgRect.bottom);
        return new Info(rectF, this.mImgRect, this.mWidgetRect, this.mBaseRect, this.mScreenCenter, this.mScale, this.mDegrees, this.mScaleType);
    }

    public static Info getImageViewInfo(ImageView imageView) {
        int[] iArr = new int[2];
        getLocation(imageView, iArr);
        Drawable drawable = imageView.getDrawable();
        Matrix imageMatrix = imageView.getImageMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, (float) getDrawableWidth(drawable), (float) getDrawableHeight(drawable));
        imageMatrix.mapRect(rectF);
        RectF rectF2 = new RectF(((float) iArr[0]) + rectF.left, ((float) iArr[1]) + rectF.top, ((float) iArr[0]) + rectF.right, ((float) iArr[1]) + rectF.bottom);
        RectF rectF3 = new RectF(0.0f, 0.0f, (float) imageView.getWidth(), (float) imageView.getHeight());
        return new Info(rectF2, rectF, rectF3, new RectF(rectF3), new PointF(rectF3.width() / 2.0f, rectF3.height() / 2.0f), 1.0f, 0.0f, imageView.getScaleType());
    }

    private static void getLocation(View view, int[] iArr) {
        iArr[0] = iArr[0] + view.getLeft();
        iArr[1] = iArr[1] + view.getTop();
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() != 16908290) {
                iArr[0] = iArr[0] - view2.getScrollX();
                iArr[1] = iArr[1] - view2.getScrollY();
                iArr[0] = iArr[0] + view2.getLeft();
                iArr[1] = iArr[1] + view2.getTop();
                parent = view2.getParent();
            } else {
                return;
            }
        }
        iArr[0] = (int) (((float) iArr[0]) + 0.5f);
        iArr[1] = (int) (((float) iArr[1]) + 0.5f);
    }

    private void reset() {
        this.mAnimaMatrix.reset();
        executeTranslate();
        this.mScale = 1.0f;
        this.mTranslateX = 0;
        this.mTranslateY = 0;
    }

    public class START implements ClipCalculate {
        public START() {
        }

        @Override // com.coolapk.market.widget.photoview.PhotoView.ClipCalculate
        public float calculateTop() {
            return PhotoView.this.mImgRect.top;
        }
    }

    public class END implements ClipCalculate {
        public END() {
        }

        @Override // com.coolapk.market.widget.photoview.PhotoView.ClipCalculate
        public float calculateTop() {
            return PhotoView.this.mImgRect.bottom;
        }
    }

    public class OTHER implements ClipCalculate {
        public OTHER() {
        }

        @Override // com.coolapk.market.widget.photoview.PhotoView.ClipCalculate
        public float calculateTop() {
            return (PhotoView.this.mImgRect.top + PhotoView.this.mImgRect.bottom) / 2.0f;
        }
    }

    public void animaFrom(Info info) {
        if (this.isInit) {
            reset();
            Info info2 = getInfo();
            float width = info.mImgRect.width() / info2.mImgRect.width();
            float height = info.mImgRect.height() / info2.mImgRect.height();
            if (width >= height) {
                width = height;
            }
            float width2 = info.mRect.left + (info.mRect.width() / 2.0f);
            float height2 = info.mRect.top + (info.mRect.height() / 2.0f);
            float width3 = info2.mRect.left + (info2.mRect.width() / 2.0f);
            float height3 = info2.mRect.top + (info2.mRect.height() / 2.0f);
            this.mAnimaMatrix.reset();
            float f = width2 - width3;
            float f2 = height2 - height3;
            this.mAnimaMatrix.postTranslate(f, f2);
            this.mAnimaMatrix.postScale(width, width, width2, height2);
            this.mAnimaMatrix.postRotate(info.mDegrees, width2, height2);
            executeTranslate();
            this.mScaleCenter.set(width2, height2);
            this.mRotateCenter.set(width2, height2);
            this.mTranslate.withTranslate(0, 0, (int) (-f), (int) (-f2));
            this.mTranslate.withScale(width, 1.0f);
            this.mTranslate.withRotate((int) info.mDegrees, 0);
            if (info.mWidgetRect.width() < info.mImgRect.width() || info.mWidgetRect.height() < info.mImgRect.height()) {
                float width4 = info.mWidgetRect.width() / info.mImgRect.width();
                float height4 = info.mWidgetRect.height() / info.mImgRect.height();
                if (width4 > 1.0f) {
                    width4 = 1.0f;
                }
                if (height4 > 1.0f) {
                    height4 = 1.0f;
                }
                ClipCalculate start = info.mScaleType == ImageView.ScaleType.FIT_START ? new START() : info.mScaleType == ImageView.ScaleType.FIT_END ? new END() : new OTHER();
                this.mTranslate.withClip(width4, height4, 1.0f - width4, 1.0f - height4, this.mAnimaDuring / 3, start);
                this.mTmpMatrix.setScale(width4, height4, (this.mImgRect.left + this.mImgRect.right) / 2.0f, start.calculateTop());
                this.mTmpMatrix.mapRect(this.mTranslate.mClipRect, this.mImgRect);
                this.mClip = this.mTranslate.mClipRect;
            }
            this.mTranslate.start();
            return;
        }
        this.mFromInfo = info;
        this.mInfoTime = System.currentTimeMillis();
    }

    public void animaTo(Info info, Runnable runnable) {
        if (this.isInit) {
            this.mTranslate.stop();
            this.mTranslateX = 0;
            this.mTranslateY = 0;
            float width = info.mRect.left + (info.mRect.width() / 2.0f);
            float height = info.mRect.top + (info.mRect.height() / 2.0f);
            this.mScaleCenter.set(this.mImgRect.left + (this.mImgRect.width() / 2.0f), this.mImgRect.top + (this.mImgRect.height() / 2.0f));
            this.mRotateCenter.set(this.mScaleCenter);
            this.mAnimaMatrix.postRotate(-this.mDegrees, this.mScaleCenter.x, this.mScaleCenter.y);
            this.mAnimaMatrix.mapRect(this.mImgRect, this.mBaseRect);
            float width2 = info.mImgRect.width() / this.mBaseRect.width();
            float height2 = info.mImgRect.height() / this.mBaseRect.height();
            if (width2 <= height2) {
                width2 = height2;
            }
            this.mAnimaMatrix.postRotate(this.mDegrees, this.mScaleCenter.x, this.mScaleCenter.y);
            this.mAnimaMatrix.mapRect(this.mImgRect, this.mBaseRect);
            this.mDegrees %= 360.0f;
            this.mTranslate.withTranslate(0, 0, (int) (width - this.mScaleCenter.x), (int) (height - this.mScaleCenter.y));
            this.mTranslate.withScale(this.mScale, width2);
            this.mTranslate.withRotate((int) this.mDegrees, (int) info.mDegrees, (this.mAnimaDuring * 2) / 3);
            if (info.mWidgetRect.width() < info.mRect.width() || info.mWidgetRect.height() < info.mRect.height()) {
                final float width3 = info.mWidgetRect.width() / info.mRect.width();
                final float height3 = info.mWidgetRect.height() / info.mRect.height();
                if (width3 > 1.0f) {
                    width3 = 1.0f;
                }
                if (height3 > 1.0f) {
                    height3 = 1.0f;
                }
                final ClipCalculate start = info.mScaleType == ImageView.ScaleType.FIT_START ? new START() : info.mScaleType == ImageView.ScaleType.FIT_END ? new END() : new OTHER();
                postDelayed(new Runnable() {
                    /* class com.coolapk.market.widget.photoview.PhotoView.AnonymousClass5 */

                    @Override // java.lang.Runnable
                    public void run() {
                        PhotoView.this.mTranslate.withClip(1.0f, 1.0f, width3 - 4.0f, height3 - 4.0f, PhotoView.this.mAnimaDuring / 2, start);
                    }
                }, (long) (this.mAnimaDuring / 2));
            }
            this.mCompleteCallBack = runnable;
            this.mTranslate.start();
        }
    }

    public void rotate(float f) {
        this.mDegrees += f;
        this.mAnimaMatrix.postRotate(f, (float) ((int) (this.mWidgetRect.left + (this.mWidgetRect.width() / 2.0f))), (float) ((int) (this.mWidgetRect.top + (this.mWidgetRect.height() / 2.0f))));
        executeTranslate();
    }
}
