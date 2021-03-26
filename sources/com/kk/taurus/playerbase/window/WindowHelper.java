package com.kk.taurus.playerbase.window;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.kk.taurus.playerbase.utils.PUtils;
import com.kk.taurus.playerbase.window.IWindow;

public class WindowHelper implements IWindow {
    private boolean defaultAnimation;
    private boolean firstTouch = true;
    private int floatX;
    private int floatY;
    private boolean isWindowShow;
    private AnimatorSet mCloseAnimatorSet;
    private float mDownX;
    private float mDownY;
    private boolean mDragEnable = true;
    private IWindow.OnWindowListener mOnWindowListener;
    private AnimatorSet mShowAnimatorSet;
    private View mWindowView;
    private int wX;
    private int wY;
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;

    public WindowHelper(Context context, View view, FloatWindowParams floatWindowParams) {
        this.mWindowView = view;
        this.wm = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.wmParams = layoutParams;
        layoutParams.type = floatWindowParams.getWindowType();
        this.wmParams.gravity = floatWindowParams.getGravity();
        this.wmParams.format = floatWindowParams.getFormat();
        this.wmParams.flags = floatWindowParams.getFlag();
        this.wmParams.width = floatWindowParams.getWidth();
        this.wmParams.height = floatWindowParams.getHeight();
        this.wmParams.x = floatWindowParams.getX();
        this.wmParams.y = floatWindowParams.getY();
        this.defaultAnimation = floatWindowParams.isDefaultAnimation();
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void setOnWindowListener(IWindow.OnWindowListener onWindowListener) {
        this.mOnWindowListener = onWindowListener;
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void setDragEnable(boolean z) {
        this.mDragEnable = z;
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void updateWindowViewLayout(int i, int i2) {
        this.wmParams.x = i;
        this.wmParams.y = i2;
        this.wm.updateViewLayout(this.mWindowView, this.wmParams);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public boolean isWindowShow() {
        return this.isWindowShow;
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public boolean show() {
        return show(this.defaultAnimation ? getDefaultAnimators(true) : null);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public boolean show(Animator... animatorArr) {
        if (!addToWindow()) {
            return false;
        }
        ViewParent parent = this.mWindowView.getParent();
        if (parent != null) {
            parent.requestLayout();
        }
        if (animatorArr != null && animatorArr.length > 0) {
            cancelCloseAnimation();
            cancelShowAnimation();
            AnimatorSet animatorSet = new AnimatorSet();
            this.mShowAnimatorSet = animatorSet;
            animatorSet.playTogether(animatorArr);
            this.mShowAnimatorSet.addListener(new AnimatorListenerAdapter() {
                /* class com.kk.taurus.playerbase.window.WindowHelper.AnonymousClass1 */

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    WindowHelper.this.mShowAnimatorSet.removeAllListeners();
                }
            });
            this.mShowAnimatorSet.start();
        }
        IWindow.OnWindowListener onWindowListener = this.mOnWindowListener;
        if (onWindowListener == null) {
            return true;
        }
        onWindowListener.onShow();
        return true;
    }

    private void cancelShowAnimation() {
        AnimatorSet animatorSet = this.mShowAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mShowAnimatorSet.removeAllListeners();
        }
    }

    private boolean addToWindow() {
        if (this.wm != null) {
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    if (this.mWindowView.getParent() == null) {
                        this.wm.addView(this.mWindowView, this.wmParams);
                        this.isWindowShow = true;
                    }
                    return true;
                } catch (Exception unused) {
                }
            } else if (this.mWindowView.isAttachedToWindow()) {
                return false;
            } else {
                this.wm.addView(this.mWindowView, this.wmParams);
                this.isWindowShow = true;
                return true;
            }
        }
        return false;
    }

    private Animator[] getDefaultAnimators(boolean z) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        return new Animator[]{ObjectAnimator.ofFloat(this.mWindowView, "scaleX", f2, f).setDuration(200L), ObjectAnimator.ofFloat(this.mWindowView, "scaleY", f2, f).setDuration(200L), ObjectAnimator.ofFloat(this.mWindowView, "alpha", f2, f).setDuration(200L)};
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void close() {
        close(this.defaultAnimation ? getDefaultAnimators(false) : null);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void close(Animator... animatorArr) {
        if (animatorArr == null || animatorArr.length <= 0) {
            removeFromWindow();
            return;
        }
        cancelShowAnimation();
        cancelCloseAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        this.mCloseAnimatorSet = animatorSet;
        animatorSet.playTogether(animatorArr);
        this.mCloseAnimatorSet.addListener(new AnimatorListenerAdapter() {
            /* class com.kk.taurus.playerbase.window.WindowHelper.AnonymousClass2 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                WindowHelper.this.mCloseAnimatorSet.removeAllListeners();
                WindowHelper.this.removeFromWindow();
            }
        });
        this.mCloseAnimatorSet.start();
    }

    private void cancelCloseAnimation() {
        AnimatorSet animatorSet = this.mCloseAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mCloseAnimatorSet.removeAllListeners();
        }
    }

    /* access modifiers changed from: private */
    public boolean removeFromWindow() {
        IWindow.OnWindowListener onWindowListener;
        boolean z = true;
        if (this.wm != null) {
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    if (this.mWindowView.getParent() != null) {
                        this.wm.removeViewImmediate(this.mWindowView);
                        this.isWindowShow = false;
                        onWindowListener.onClose();
                        return z;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (this.mWindowView.isAttachedToWindow()) {
                this.wm.removeViewImmediate(this.mWindowView);
                this.isWindowShow = false;
                if (z && (onWindowListener = this.mOnWindowListener) != null) {
                    onWindowListener.onClose();
                }
                return z;
            }
        }
        z = false;
        onWindowListener.onClose();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mDragEnable) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownX = motionEvent.getRawX();
            this.mDownY = motionEvent.getRawY();
        } else if (action == 2) {
            if (Math.abs(motionEvent.getRawX() - this.mDownX) > 20.0f || Math.abs(motionEvent.getRawY() - this.mDownY) > 20.0f) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mDragEnable) {
            return false;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 1) {
            this.firstTouch = true;
        } else if (action == 2) {
            if (this.firstTouch) {
                this.floatX = (int) motionEvent.getX();
                this.floatY = (int) (motionEvent.getY() + ((float) PUtils.getStatusBarHeight(this.mWindowView.getContext())));
                this.firstTouch = false;
            }
            int i = rawX - this.floatX;
            this.wX = i;
            int i2 = rawY - this.floatY;
            this.wY = i2;
            updateWindowViewLayout(i, i2);
        }
        return false;
    }
}
