package com.aurelhubert.ahbottomnavigation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;

public class AHHelper {
    public static Drawable getTintDrawable(Drawable drawable, int i, boolean z) {
        if (z) {
            drawable.clearColorFilter();
            drawable.mutate().setColorFilter(i, PorterDuff.Mode.SRC_IN);
            drawable.invalidateSelf();
            return drawable;
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(mutate, i);
        return mutate;
    }

    public static void updateTopMargin(final View view, int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat((float) i, (float) i2);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (int) floatValue, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.requestLayout();
                }
            }
        });
        ofFloat.start();
    }

    public static void updateBottomMargin(final View view, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat((float) i, (float) i2);
        ofFloat.setDuration((long) i3);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass2 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (int) floatValue);
                    view.requestLayout();
                }
            }
        });
        ofFloat.start();
    }

    public static void updateLeftMargin(final View view, int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat((float) i, (float) i2);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass3 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins((int) floatValue, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.requestLayout();
                }
            }
        });
        ofFloat.start();
    }

    public static void updateTextSize(final TextView textView, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass4 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                textView.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    public static void updateAlpha(final View view, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass5 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    public static void updateTextColor(final TextView textView, int i, int i2) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
        ofObject.setDuration(150L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass6 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                textView.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.start();
    }

    public static void updateViewBackgroundColor(final View view, int i, int i2) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
        ofObject.setDuration(150L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass7 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.start();
    }

    public static void updateDrawableColor(Context context, final Drawable drawable, final ImageView imageView, int i, int i2, final boolean z) {
        if (z) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
            ofObject.setDuration(150L);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass8 */

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    imageView.setImageDrawable(AHHelper.getTintDrawable(drawable, ((Integer) valueAnimator.getAnimatedValue()).intValue(), z));
                    imageView.requestLayout();
                }
            });
            ofObject.start();
        }
    }

    public static void updateWidth(final View view, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.aurelhubert.ahbottomnavigation.AHHelper.AnonymousClass9 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = Math.round(((Float) valueAnimator.getAnimatedValue()).floatValue());
                view.setLayoutParams(layoutParams);
            }
        });
        ofFloat.start();
    }

    public static boolean isTranslucentStatusBar(Context context) {
        return (unwrap(context).getWindow().getAttributes().flags & 134217728) == 134217728;
    }

    public static int getSoftButtonsBarSizePort(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Window window = unwrap(context).getWindow();
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            window.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            if (i2 > i) {
                return i2 - i;
            }
        }
        return 0;
    }

    public static Activity unwrap(Context context) {
        while (!(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }
}
