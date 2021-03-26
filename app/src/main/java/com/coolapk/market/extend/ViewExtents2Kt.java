package com.coolapk.market.extend;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ReflectUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.view.splash.SplashActivity;
import com.coolapk.market.view.video.VideoDetailListActivity;
import com.coolapk.market.view.video.VideoFullScreenActivity;
import com.coolapk.market.view.wallpaper.coolpic.CoolPicDetailActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a \u0010\t\u001a\u00020\n*\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0016\u0010\u0010\u001a\u00020\n*\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u001a3\u0010\u0011\u001a\u00020\n*\u00020\u00032!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\n0\u0013H\bø\u0001\u0000\u001a\f\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u0003\u001a\u0010\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b*\u00020\u0003\u001a\u001e\u0010\u001c\u001a\u00020\n*\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\n0\u0013\u001a\n\u0010\u001f\u001a\u00020\n*\u00020\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"parentSequence", "Lkotlin/sequences/Sequence;", "Landroid/view/ViewParent;", "Landroid/view/View;", "getParentSequence", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "canHandleActivity", "", "Lcom/coolapk/market/app/TranslucentActivity;", "checkAndOpenKeyboard", "", "Landroid/widget/EditText;", "activity", "Landroid/app/Activity;", "tryCount", "", "delayOpenKeyboard", "forEachParent", "action", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "viewGroup", "getOnApplyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", "iteratorParent", "", "tryListenWindowsInset", "callback", "Landroid/graphics/Rect;", "updateNavigationBar", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ViewExtents2.kt */
public final class ViewExtents2Kt {
    public static final void forEachParent(View view, Function1<? super ViewGroup, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$forEachParent");
        Intrinsics.checkNotNullParameter(function1, "action");
        ViewParent parent = view.getParent();
        while (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            function1.invoke(viewGroup);
            parent = viewGroup.getParent();
        }
    }

    public static final Iterator<ViewParent> iteratorParent(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$iteratorParent");
        return new ViewExtents2Kt$iteratorParent$1(view);
    }

    public static final Sequence<ViewParent> getParentSequence(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$parentSequence");
        return new ViewExtents2Kt$parentSequence$1(view);
    }

    public static final void tryListenWindowsInset(View view, Function1<? super Rect, Unit> function1) {
        WrapOnApplyWindowInsetsListener wrapOnApplyWindowInsetsListener;
        WindowInsets rootWindowInsets;
        Intrinsics.checkNotNullParameter(view, "$this$tryListenWindowsInset");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Sequence filter = SequencesKt.filter(getParentSequence(view), ViewExtents2Kt$tryListenWindowsInset$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = (DrawSystemBarFrameLayout) SequencesKt.firstOrNull(filter);
        if (drawSystemBarFrameLayout != null) {
            ViewExtents2Kt$tryListenWindowsInset$insetsListener$1 viewExtents2Kt$tryListenWindowsInset$insetsListener$1 = new ViewExtents2Kt$tryListenWindowsInset$insetsListener$1(function1);
            Rect lastInsetsRect = drawSystemBarFrameLayout.getLastInsetsRect();
            if ((lastInsetsRect.top == 0 && lastInsetsRect.bottom == 0 && lastInsetsRect.left == 0 && lastInsetsRect.right == 0) ? false : true) {
                Intrinsics.checkNotNullExpressionValue(lastInsetsRect, "lastRect");
                function1.invoke(lastInsetsRect);
            }
            drawSystemBarFrameLayout.addOnInsetChangeListener(viewExtents2Kt$tryListenWindowsInset$insetsListener$1);
            view.addOnAttachStateChangeListener(new ViewExtents2Kt$tryListenWindowsInset$$inlined$doOnNextDetach$1(view, drawSystemBarFrameLayout, viewExtents2Kt$tryListenWindowsInset$insetsListener$1));
            return;
        }
        Sequence filter2 = SequencesKt.filter(getParentSequence(view), ViewExtents2Kt$tryListenWindowsInset$$inlined$filterIsInstance$2.INSTANCE);
        Objects.requireNonNull(filter2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) SequencesKt.firstOrNull(filter2);
        if (coordinatorLayout != null) {
            if (Build.VERSION.SDK_INT >= 23 && (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) != null) {
                function1.invoke(new Rect(rootWindowInsets.getSystemWindowInsetLeft(), rootWindowInsets.getSystemWindowInsetTop(), rootWindowInsets.getSystemWindowInsetRight(), rootWindowInsets.getSystemWindowInsetBottom()));
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = getOnApplyWindowInsetsListener(coordinatorLayout);
            if (onApplyWindowInsetsListener instanceof WrapOnApplyWindowInsetsListener) {
                wrapOnApplyWindowInsetsListener = (WrapOnApplyWindowInsetsListener) onApplyWindowInsetsListener;
            } else {
                WrapOnApplyWindowInsetsListener wrapOnApplyWindowInsetsListener2 = new WrapOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
                coordinatorLayout.setOnApplyWindowInsetsListener(wrapOnApplyWindowInsetsListener2);
                wrapOnApplyWindowInsetsListener = wrapOnApplyWindowInsetsListener2;
            }
            wrapOnApplyWindowInsetsListener.getCallbacks().add(function1);
            view.addOnAttachStateChangeListener(new ViewExtents2Kt$tryListenWindowsInset$$inlined$doOnNextDetach$2(view, wrapOnApplyWindowInsetsListener, function1));
        }
    }

    public static final View.OnApplyWindowInsetsListener getOnApplyWindowInsetsListener(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$getOnApplyWindowInsetsListener");
        try {
            return (View.OnApplyWindowInsetsListener) ReflectUtils.wrap(view).callMethod("getListenerInfo", new Object[0]).getChildField("mOnApplyWindowInsetsListener").getAs(View.OnApplyWindowInsetsListener.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final boolean canHandleActivity(TranslucentActivity translucentActivity) {
        boolean z;
        Intrinsics.checkNotNullParameter(translucentActivity, "$this$canHandleActivity");
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        Class<?>[] clsArr = {PhotoViewActivity.class, CoolPicDetailActivity.class, SplashActivity.class, VideoDetailListActivity.class, VideoFullScreenActivity.class};
        int i = 0;
        while (true) {
            if (i >= 5) {
                z = false;
                break;
            } else if (translucentActivity.getClass().isAssignableFrom(clsArr[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    public static final void updateNavigationBar(TranslucentActivity translucentActivity) {
        Intrinsics.checkNotNullParameter(translucentActivity, "$this$updateNavigationBar");
        if ((translucentActivity instanceof AppCompatActivity) && UiUtils.getNavigationBarHeight((Context) translucentActivity) >= NumberExtendsKt.getDp((Number) 25)) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) translucentActivity;
            Window window = appCompatActivity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "this.window");
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "this.window.decorView");
            if (translucentActivity.isNavigationBarTranslucent()) {
                Window window2 = appCompatActivity.getWindow();
                Intrinsics.checkNotNullExpressionValue(window2, "this.window");
                window2.setNavigationBarColor(ColorUtils.adjustAlpha(AppHolder.getAppTheme().getContentBackgroundColor(), 0.6f));
                if (!AppHolder.getAppTheme().isDarkTheme()) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
                    }
                } else if (Build.VERSION.SDK_INT >= 26) {
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -17);
                }
            }
        }
    }

    public static /* synthetic */ void checkAndOpenKeyboard$default(EditText editText, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            Context context = editText.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
            activity = UiUtils.getActivityNullable(context);
        }
        if ((i2 & 2) != 0) {
            i = 3;
        }
        checkAndOpenKeyboard(editText, activity, i);
    }

    public static final void checkAndOpenKeyboard(EditText editText, Activity activity, int i) {
        Rect lastInsetsRect;
        Intrinsics.checkNotNullParameter(editText, "$this$checkAndOpenKeyboard");
        Sequence filter = SequencesKt.filter(getParentSequence(editText), ViewExtents2Kt$checkAndOpenKeyboard$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = (DrawSystemBarFrameLayout) SequencesKt.firstOrNull(filter);
        Integer valueOf = (drawSystemBarFrameLayout == null || (lastInsetsRect = drawSystemBarFrameLayout.getLastInsetsRect()) == null) ? null : Integer.valueOf(lastInsetsRect.bottom);
        LogUtils.d("checking keyboard, keyboardHeight:" + valueOf + ", tryCount: " + i, new Object[0]);
        if (valueOf == null) {
            delayOpenKeyboard(editText, activity);
        } else if (valueOf.intValue() < NumberExtendsKt.getDp((Number) 64) && i > 0) {
            delayOpenKeyboard(editText, activity);
            editText.postDelayed(new ViewExtents2Kt$checkAndOpenKeyboard$1(editText, activity, i), 200);
        }
    }

    public static /* synthetic */ void delayOpenKeyboard$default(EditText editText, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            Context context = editText.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
            activity = UiUtils.getActivityNullable(context);
        }
        delayOpenKeyboard(editText, activity);
    }

    public static final void delayOpenKeyboard(EditText editText, Activity activity) {
        Intrinsics.checkNotNullParameter(editText, "$this$delayOpenKeyboard");
        editText.postDelayed(new ViewExtents2Kt$delayOpenKeyboard$1(editText, activity), 100);
    }
}
