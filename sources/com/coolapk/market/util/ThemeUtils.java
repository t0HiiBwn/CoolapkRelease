package com.coolapk.market.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.view.base.BaseActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.EventBus;

public class ThemeUtils {
    public static boolean isNavigationBarTranslucent(Activity activity) {
        return false;
    }

    public static int getStatusBarColor() {
        AppTheme appTheme = AppHolder.getAppTheme();
        if (AppHolder.getAppSetting().getBooleanPref("transparent_status_bar")) {
            return appTheme.getColorPrimary();
        }
        return appTheme.getColorPrimaryDark();
    }

    public static int getStatusBarOverlayColor() {
        return ColorUtils.calculateOverlayColor(AppHolder.getAppTheme().getColorPrimaryDark(), AppHolder.getAppTheme().getColorPrimary());
    }

    public static void setDarkStatusIconBar(Activity activity, boolean z) {
        setDarkStatusIconBar(activity, z, 0);
    }

    public static void setDarkStatusIconBar(Activity activity, final boolean z, int i) {
        if (DarkStatusBarHandler.getInstance().canHandleDarkMode()) {
            if (i == 0) {
                DarkStatusBarHandler.getInstance().setDarkMode(activity, z);
                return;
            }
            final WeakReference weakReference = new WeakReference(activity);
            AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
                /* class com.coolapk.market.util.ThemeUtils.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null && !activity.isDestroyed()) {
                        DarkStatusBarHandler.getInstance().setDarkMode(activity, z);
                    }
                }
            }, (long) i);
        }
    }

    public static void setStatusBarColor(CollapsingToolbarLayout collapsingToolbarLayout, int i) {
        Activity activity = UiUtils.getActivity(collapsingToolbarLayout.getContext());
        if (Build.VERSION.SDK_INT >= 21) {
            setStatusBarColor(activity, 0);
            collapsingToolbarLayout.setStatusBarScrimColor(i);
        } else if (Build.VERSION.SDK_INT == 19) {
            setStatusBarColor(activity, i);
        }
    }

    public static void setStatusBarColor(DrawerLayout drawerLayout, int i) {
        Activity activity = UiUtils.getActivity(drawerLayout.getContext());
        if (Build.VERSION.SDK_INT >= 21) {
            setStatusBarColor(activity, 0);
            drawerLayout.setStatusBarBackgroundColor(i);
        } else if (Build.VERSION.SDK_INT == 19) {
            setStatusBarColor(activity, i);
        }
    }

    public static void setSystemBarDrawFlags(Activity activity) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().getDecorView().setSystemUiVisibility(1280);
    }

    public static void setNavigationBarColor(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21 && activity != null) {
            activity.getWindow().setNavigationBarColor(i);
        }
    }

    public static void setNavigationBarLightIcon(Activity activity, boolean z) {
        View decorView = activity.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & -17);
    }

    public static void compatDrawShortcut(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
    }

    public static void neverDrawShortcut(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
    }

    public static void compatDisplayCutoutForMiui(Activity activity) {
        activity.getWindow().getClass();
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 768);
        } catch (Exception unused) {
        }
    }

    public static void setTaskDescription(Activity activity, Bitmap bitmap, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (bitmap == null) {
                    Drawable drawable = activity.getDrawable(2131689481);
                    if (drawable instanceof BitmapDrawable) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                    }
                }
                activity.setTaskDescription(new ActivityManager.TaskDescription(activity.getString(2131886251), bitmap, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setTranslucentNavigationBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setNavigationBarColor(0);
        } else if (Build.VERSION.SDK_INT == 19) {
            activity.getWindow().addFlags(134217728);
        }
    }

    public static void setTranslucentStatusBar(Activity activity) {
        setStatusBarColor(activity, 0);
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setStatusBarColor(i);
        } else if (Build.VERSION.SDK_INT == 19) {
            activity.getWindow().addFlags(67108864);
            setStatusBarTint(activity, i);
        }
    }

    private static void setStatusBarTint(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity, true);
        }
    }

    private static void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    public static void startThemeChangeAlphaAnimation(Activity activity) {
        if (activity != null) {
            final ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            final View view = new View(activity);
            view.setBackground(new BitmapDrawable(activity.getResources(), UiUtils.takeSnapshot(viewGroup)));
            view.setClickable(true);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            view.animate().alpha(0.0f).setDuration(400).setListener(new AnimatorListenerAdapter() {
                /* class com.coolapk.market.util.ThemeUtils.AnonymousClass2 */

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ThemeUtils.postThemeChangeEvent();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewGroup.removeView(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewGroup.removeView(view);
                }
            }).start();
        }
    }

    public static void startThemeChangeRevealAnimation(final Activity activity, View view) {
        if (activity != null) {
            final ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            Bitmap takeSnapshot = UiUtils.takeSnapshot(viewGroup);
            final ImageView imageView = new ImageView(activity);
            imageView.setImageDrawable(new BitmapDrawable(activity.getResources(), takeSnapshot));
            viewGroup.addView(imageView, 0, new ViewGroup.LayoutParams(-1, -1));
            final View view2 = new View(activity);
            view2.setClickable(true);
            viewGroup.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = iArr[0] + (view.getWidth() / 2);
            int height = iArr[1] + (view.getHeight() / 2);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(viewGroup.getChildAt(1), width, height, (float) ((Math.max(view.getWidth(), view.getHeight()) / 2) + DisplayUtils.dp2px(activity, 16.0f)), (float) ((int) Math.sqrt(Math.pow((double) Math.max(width, viewGroup.getWidth() - width), 2.0d) + Math.pow((double) Math.max(height, viewGroup.getHeight() - height), 2.0d))));
            createCircularReveal.setDuration(600);
            createCircularReveal.addListener(new AnimatorListenerAdapter() {
                /* class com.coolapk.market.util.ThemeUtils.AnonymousClass3 */

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ThemeUtils.postThemeChangeEvent();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewGroup.removeView(imageView);
                    viewGroup.removeView(view2);
                    Activity activity = activity;
                    if (activity instanceof BaseActivity) {
                        ((BaseActivity) activity).checkStatusBarDarkMode();
                    }
                }
            });
            createCircularReveal.start();
        }
    }

    public static void postThemeChangeEvent() {
        EventBus.getDefault().post(AppHolder.getAppTheme());
    }

    public static void setTabLayoutItemColor(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.setTabTextColors(ResourceUtils.resolveData(tabLayout.getContext(), 2130969533), ResourceUtils.resolveData(tabLayout.getContext(), 2130969532));
            tabLayout.setSelectedTabIndicatorColor(AppHolder.getAppTheme().getTabIndicatorColor(tabLayout.getContext()));
        }
    }

    public static void setTabLayoutItemColor(com.coolapk.market.widget.view.TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.setTabTextColors(ResourceUtils.resolveData(tabLayout.getContext(), 2130969533), ResourceUtils.resolveData(tabLayout.getContext(), 2130969532));
            tabLayout.setSelectedTabIndicatorColor(AppHolder.getAppTheme().getTabIndicatorColor(tabLayout.getContext()));
        }
    }

    public static void setRatingBarColor(RatingBar ratingBar) {
        setRatingBarColor(ratingBar, AppHolder.getAppTheme().getColorAccent());
    }

    public static void setRatingBarColor(RatingBar ratingBar, int i) {
        ratingBar.setBackgroundTintList(ColorStateList.valueOf(i));
        ratingBar.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
        ratingBar.setProgressBackgroundTintList(ColorStateList.valueOf(i));
        ratingBar.setProgressBackgroundTintMode(PorterDuff.Mode.SRC_IN);
        ratingBar.setProgressTintList(ColorStateList.valueOf(i));
        ratingBar.setProgressTintMode(PorterDuff.Mode.SRC_IN);
        ratingBar.setSecondaryProgressTintList(ColorStateList.valueOf(i));
        ratingBar.setSecondaryProgressTintMode(PorterDuff.Mode.SRC_IN);
    }

    public static Drawable drawableToInverse(Context context, int i) {
        return drawableToInverse(ContextCompat.getDrawable(context, i));
    }

    public static Drawable drawableToInverse(Drawable drawable) {
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(mutate, AppHolder.getAppTheme().getTextColorSecondary());
        return mutate;
    }

    public static void setTranslucentForImageView(Activity activity, boolean z) {
        activity.getWindow().setStatusBarColor(0);
        if (z) {
            activity.getWindow().setNavigationBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            return;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(1280);
    }
}
