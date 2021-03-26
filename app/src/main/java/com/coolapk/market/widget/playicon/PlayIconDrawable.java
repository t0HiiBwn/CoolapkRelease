package com.coolapk.market.widget.playicon;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class PlayIconDrawable extends Drawable implements PlayIcon {
    private static final float[] ANIMATED_PATH_CONTAINER = new float[8];
    public static final int DEFAULT_ANIMATION_DURATION = 400;
    public static final TimeInterpolator DEFAULT_ANIMATION_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    public static final int DEFAULT_COLOR = -1;
    public static final boolean DEFAULT_VISIBLE = true;
    private static final float FRACTION_PAUSE = 1.0f;
    private static final float FRACTION_PLAY = 0.0f;
    private float currentFraction = 0.0f;
    private IconState currentIconState = IconState.PLAY;
    private final ValueAnimator iconAnimator;
    private final Paint iconPaint;
    private final Path pathLeft = new Path();
    private float[] pathLeftPause;
    private float[] pathLeftPlay;
    private final Path pathRight = new Path();
    private float[] pathRightPause;
    private float[] pathRightPlay;
    private StateListener stateListener = null;
    private boolean visible = true;

    public enum IconState {
        PLAY,
        PAUSE
    }

    public interface StateListener {
        void onStateChanged(IconState iconState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public PlayIconDrawable() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iconAnimator = ofFloat;
        Paint paint = new Paint(1);
        this.iconPaint = paint;
        paint.setColor(-1);
        ofFloat.setInterpolator(DEFAULT_ANIMATION_INTERPOLATOR);
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.coolapk.market.widget.playicon.PlayIconDrawable.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayIconDrawable.this.setCurrentFraction(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.visible) {
            float f = this.currentFraction;
            float[] fArr = this.pathRightPlay;
            float[] fArr2 = this.pathRightPause;
            float[] fArr3 = ANIMATED_PATH_CONTAINER;
            drawPart(canvas, f, fArr, fArr2, fArr3, this.pathRight, this.iconPaint);
            drawPart(canvas, this.currentFraction, this.pathLeftPlay, this.pathLeftPause, fArr3, this.pathLeft, this.iconPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        initPathParts();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.iconPaint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.iconPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.iconAnimator.cancel();
        }
        this.currentFraction = iconState == IconState.PAUSE ? 1.0f : 0.0f;
        updateIconState(iconState);
        invalidateSelf();
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public IconState getIconState() {
        return this.currentIconState;
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void animateToState(IconState iconState) {
        if (isRunning()) {
            this.iconAnimator.cancel();
        }
        if (iconState == IconState.PAUSE) {
            this.iconAnimator.start();
        } else {
            this.iconAnimator.reverse();
        }
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setColor(int i) {
        this.iconPaint.setColor(i);
        invalidateSelf();
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setVisible(boolean z) {
        this.visible = z;
        invalidateSelf();
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setAnimationDuration(int i) {
        this.iconAnimator.setDuration((long) i);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.iconAnimator.setInterpolator(timeInterpolator);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        if (animatorListener == null) {
            this.iconAnimator.removeAllListeners();
        } else {
            this.iconAnimator.addListener(animatorListener);
        }
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setCurrentFraction(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalStateException("Fraction should be in a range of 0F..1F");
        }
        this.currentFraction = f;
        updateIconState(f < 0.5f ? IconState.PLAY : IconState.PAUSE);
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.iconAnimator.isRunning();
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void toggle(boolean z) {
        IconState iconState = this.currentIconState == IconState.PAUSE ? IconState.PLAY : IconState.PAUSE;
        if (z) {
            animateToState(iconState);
        } else {
            setIconState(iconState);
        }
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setStateListener(StateListener stateListener2) {
        this.stateListener = stateListener2;
    }

    private void drawPart(Canvas canvas, float f, float[] fArr, float[] fArr2, float[] fArr3, Path path, Paint paint) {
        Graphics.animatePath(fArr3, fArr, fArr2, f);
        Graphics.inRect(path, fArr3);
        canvas.drawPath(path, paint);
    }

    private void initPathParts() {
        this.pathLeftPlay = new float[]{0.0f, 0.0f, (float) ((int) getCenterX()), ((float) getHeight()) * 0.25f, (float) ((int) getCenterX()), ((float) getHeight()) * 0.75f, 0.0f, (float) getHeight()};
        this.pathLeftPause = new float[]{0.0f, 0.0f, (float) (getWidth() / 3), 0.0f, (float) (getWidth() / 3), (float) getHeight(), 0.0f, (float) getHeight()};
        this.pathRightPlay = new float[]{(float) ((int) getCenterX()), ((float) getHeight()) * 0.25f, (float) getWidth(), getCenterY(), (float) getWidth(), getCenterY(), (float) ((int) getCenterX()), ((float) getHeight()) * 0.75f};
        this.pathRightPause = new float[]{(float) ((getWidth() * 2) / 3), 0.0f, (float) getWidth(), 0.0f, (float) getWidth(), (float) getHeight(), (float) ((getWidth() * 2) / 3), (float) getHeight()};
    }

    private void updateIconState(IconState iconState) {
        StateListener stateListener2 = this.stateListener;
        if (!(stateListener2 == null || this.currentIconState == iconState)) {
            stateListener2.onStateChanged(iconState);
        }
        this.currentIconState = iconState;
    }

    private float getCenterX() {
        return getBounds().exactCenterX();
    }

    private float getCenterY() {
        return getBounds().exactCenterY();
    }

    private int getHeight() {
        return getBounds().height();
    }

    private int getWidth() {
        return getBounds().width();
    }

    public static PlayIconBuilder builder() {
        return new PlayIconBuilder();
    }

    public static final class PlayIconBuilder {
        private Animator.AnimatorListener animatorListener = null;
        private int color = -1;
        private int duration = 400;
        private TimeInterpolator interpolator = PlayIconDrawable.DEFAULT_ANIMATION_INTERPOLATOR;
        private IconState state = IconState.PLAY;
        private StateListener stateListener = null;

        public PlayIconBuilder withInitialState(IconState iconState) {
            this.state = iconState;
            return this;
        }

        public PlayIconBuilder withColor(int i) {
            this.color = i;
            return this;
        }

        public PlayIconBuilder withDuration(int i) {
            this.duration = i;
            return this;
        }

        public PlayIconBuilder withInterpolator(TimeInterpolator timeInterpolator) {
            this.interpolator = timeInterpolator;
            return this;
        }

        public PlayIconBuilder withAnimatorListener(Animator.AnimatorListener animatorListener2) {
            this.animatorListener = animatorListener2;
            return this;
        }

        public PlayIconBuilder withStateListener(StateListener stateListener2) {
            this.stateListener = stateListener2;
            return this;
        }

        public PlayIconDrawable into(ImageView imageView) {
            PlayIconDrawable build = build();
            imageView.setImageDrawable(build);
            return build;
        }

        public PlayIconDrawable build() {
            PlayIconDrawable playIconDrawable = new PlayIconDrawable();
            playIconDrawable.setIconState(this.state);
            playIconDrawable.setAnimationDuration(this.duration);
            playIconDrawable.setColor(this.color);
            playIconDrawable.setInterpolator(this.interpolator);
            playIconDrawable.setAnimationListener(this.animatorListener);
            playIconDrawable.setStateListener(this.stateListener);
            return playIconDrawable;
        }
    }
}
