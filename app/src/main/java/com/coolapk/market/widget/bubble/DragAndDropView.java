package com.coolapk.market.widget.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.AnimationDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.bubble.DragAndDropHelper;

class DragAndDropView extends FrameLayout {
    public static final int ID = View.generateViewId();
    private PointF mCenterDistant = new PointF();
    private PointF mCurrentLocation = new PointF();
    private float mFurtherDistant;
    private boolean mIgnorePendingEvent;
    private PointF mInitLocation = new PointF();
    private PointF mLastTouch = new PointF();
    private DragAndDropHelper.DragAndDrawListener mListener;
    private float mMaxRadius;
    private boolean mOutOfRange;
    private Paint mPaint;
    private Path mPath;
    private View mTarget;
    private Bitmap mTargetBitmap;

    public DragAndDropView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mFurtherDistant = (float) DisplayUtils.dp2px(context, 60.0f);
        this.mPath = new Path();
        setWillNotDraw(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L_0x0105;
     */
    public void onDragTargetView(DragAndDropHelper.Builder builder, MotionEvent motionEvent) {
        if (!this.mIgnorePendingEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        this.mCurrentLocation.x += motionEvent.getRawX() - this.mLastTouch.x;
                        this.mCurrentLocation.y += motionEvent.getRawY() - this.mLastTouch.y;
                        if (!this.mOutOfRange && ((float) Math.sqrt(Math.pow((double) (this.mCurrentLocation.x - this.mInitLocation.x), 2.0d) + Math.pow((double) (this.mCurrentLocation.y - this.mInitLocation.y), 2.0d))) > this.mFurtherDistant) {
                            this.mOutOfRange = true;
                        }
                        invalidate();
                    }
                }
                this.mIgnorePendingEvent = true;
                if (!this.mOutOfRange) {
                    alwaysInRangeUp();
                } else if (getDragDistant() > this.mFurtherDistant) {
                    outRangeUp();
                } else {
                    cancelRangeUp();
                }
            } else {
                this.mTarget = builder.getTarget();
                this.mListener = builder.getListener();
                this.mPaint.setColor(builder.getColor());
                this.mTargetBitmap = UiUtils.takeSnapshot(this.mTarget);
                this.mTarget.setVisibility(4);
                this.mTarget.getParent().requestDisallowInterceptTouchEvent(true);
                int[] iArr = new int[2];
                this.mTarget.getLocationOnScreen(iArr);
                this.mInitLocation.x = (float) (iArr[0] + (this.mTargetBitmap.getWidth() / 2));
                this.mInitLocation.y = (float) (iArr[1] + (this.mTargetBitmap.getHeight() / 2));
                this.mCurrentLocation.x = this.mInitLocation.x;
                this.mCurrentLocation.y = this.mInitLocation.y;
                this.mMaxRadius = (float) (Math.min(this.mTargetBitmap.getWidth(), this.mTargetBitmap.getHeight()) / 2);
                setClickable(true);
                invalidate();
            }
            this.mLastTouch.x = motionEvent.getRawX();
            this.mLastTouch.y = motionEvent.getRawY();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PointF[] pointFArr;
        PointF[] pointFArr2;
        super.draw(canvas);
        if (this.mTargetBitmap != null) {
            if (!this.mOutOfRange) {
                float drawCircleRadius = getDrawCircleRadius();
                canvas.drawCircle(this.mInitLocation.x, this.mInitLocation.y, drawCircleRadius, this.mPaint);
                this.mCenterDistant.x = (this.mInitLocation.x + this.mCurrentLocation.x) / 2.0f;
                this.mCenterDistant.y = (this.mInitLocation.y + this.mCurrentLocation.y) / 2.0f;
                float f = this.mCurrentLocation.y - this.mInitLocation.y;
                float f2 = this.mCurrentLocation.x - this.mInitLocation.x;
                if (f2 != 0.0f) {
                    double d = (double) (-1.0f / (f / f2));
                    pointFArr = GeometryUtil.getIntersectionPoints(this.mCurrentLocation, this.mMaxRadius, Double.valueOf(d));
                    pointFArr2 = GeometryUtil.getIntersectionPoints(this.mInitLocation, drawCircleRadius, Double.valueOf(d));
                } else {
                    pointFArr = GeometryUtil.getIntersectionPoints(this.mCurrentLocation, this.mMaxRadius, Double.valueOf(0.0d));
                    pointFArr2 = GeometryUtil.getIntersectionPoints(this.mInitLocation, drawCircleRadius, Double.valueOf(0.0d));
                }
                this.mPath.reset();
                this.mPath.moveTo(pointFArr2[0].x, pointFArr2[0].y);
                this.mPath.quadTo(this.mCenterDistant.x, this.mCenterDistant.y, pointFArr[0].x, pointFArr[0].y);
                this.mPath.lineTo(pointFArr[1].x, pointFArr[1].y);
                this.mPath.quadTo(this.mCenterDistant.x, this.mCenterDistant.y, pointFArr2[1].x, pointFArr2[1].y);
                this.mPath.close();
                canvas.drawPath(this.mPath, this.mPaint);
            }
            canvas.drawBitmap(this.mTargetBitmap, this.mCurrentLocation.x - ((float) (this.mTargetBitmap.getWidth() / 2)), this.mCurrentLocation.y - ((float) (this.mTargetBitmap.getHeight() / 2)), this.mPaint);
        }
    }

    private float getDrawCircleRadius() {
        float dragDistant = getDragDistant() / this.mFurtherDistant;
        if (dragDistant > 1.0f) {
            return 0.0f;
        }
        float dp2px = (float) DisplayUtils.dp2px(getContext(), 3.0f);
        return dp2px + ((this.mMaxRadius - dp2px) * (1.0f - dragDistant));
    }

    private float getDragDistant() {
        return (float) Math.sqrt(Math.pow((double) (this.mCurrentLocation.x - this.mInitLocation.x), 2.0d) + Math.pow((double) (this.mCurrentLocation.y - this.mInitLocation.y), 2.0d));
    }

    private void alwaysInRangeUp() {
        final PointF pointF = new PointF(this.mCurrentLocation.x, this.mCurrentLocation.y);
        final PointF pointF2 = new PointF(this.mInitLocation.x, this.mInitLocation.y);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.coolapk.market.widget.bubble.DragAndDropView.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF pointByPercent = GeometryUtil.getPointByPercent(pointF, pointF2, valueAnimator.getAnimatedFraction());
                DragAndDropView.this.mCurrentLocation.set(pointByPercent.x, pointByPercent.y);
                DragAndDropView.this.invalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.coolapk.market.widget.bubble.DragAndDropView.AnonymousClass2 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                DragAndDropView.this.cancelRangeUp();
            }
        });
        ofFloat.setInterpolator(new OvershootInterpolator(4.0f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private void outRangeUp() {
        this.mTargetBitmap = null;
        final ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(2131231804);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        int intrinsicWidth = imageView.getDrawable().getIntrinsicWidth();
        int intrinsicHeight = imageView.getDrawable().getIntrinsicHeight();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 51;
        imageView.setAdjustViewBounds(true);
        imageView.setTranslationX(this.mCurrentLocation.x - ((float) (intrinsicWidth / 2)));
        imageView.setTranslationY(this.mCurrentLocation.y - ((float) (intrinsicHeight / 2)));
        long animDuration = GeometryUtil.getAnimDuration(animationDrawable);
        addView(imageView, layoutParams);
        animationDrawable.start();
        imageView.postDelayed(new Runnable() {
            /* class com.coolapk.market.widget.bubble.DragAndDropView.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                animationDrawable.stop();
                imageView.clearAnimation();
                DragAndDropView.this.removeView(imageView);
                if (DragAndDropView.this.mListener != null) {
                    DragAndDropView.this.mListener.onTargetDrop(DragAndDropView.this.mTarget);
                }
                DragAndDropView.this.cleanUp();
            }
        }, animDuration);
    }

    /* access modifiers changed from: private */
    public void cancelRangeUp() {
        View view = this.mTarget;
        if (view != null) {
            view.setVisibility(0);
        }
        cleanUp();
    }

    /* access modifiers changed from: private */
    public void cleanUp() {
        this.mIgnorePendingEvent = false;
        setClickable(false);
        this.mTargetBitmap = null;
        this.mTarget = null;
        this.mListener = null;
        this.mOutOfRange = false;
        ViewExtendsKt.detachFromParent(this);
    }
}
