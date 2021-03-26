package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250;
    private static final long EXIT_ANIMATION_DURATION_MS = 150;
    private final View mContentView;

    BrowserActionsFallbackMenuDialog(Context context, View view) {
        super(context);
        this.mContentView = view;
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        startAnimation(true);
        super.show();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        startAnimation(false);
    }

    private void startAnimation(final boolean z) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        long j = z ? 250 : 150;
        this.mContentView.setScaleX(f2);
        this.mContentView.setScaleY(f2);
        this.mContentView.animate().scaleX(f).scaleY(f).setDuration(j).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() {
            /* class androidx.browser.browseractions.BrowserActionsFallbackMenuDialog.AnonymousClass1 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!z) {
                    BrowserActionsFallbackMenuDialog.super.dismiss();
                }
            }
        }).start();
    }
}
