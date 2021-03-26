package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.KeyBoardLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/util/ToastUtils;", "", "()V", "iNotificationManagerObj", "lastToast", "Landroid/widget/Toast;", "Lcom/coolapk/market/widget/AndroidToast;", "isNotificationEnabled", "", "context", "Landroid/content/Context;", "setContextCompat", "", "view", "Landroid/view/View;", "show", "toast", "showSystemToast", "showToastInActivity", "activity", "Landroid/app/Activity;", "SafeToastContext", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ToastUtils.kt */
public final class ToastUtils {
    public static final ToastUtils INSTANCE = new ToastUtils();
    private static Object iNotificationManagerObj;
    private static Toast lastToast;

    private ToastUtils() {
    }

    public final void show(Context context, Toast toast) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toast, "toast");
        Toast toast2 = lastToast;
        if (toast2 != null) {
            toast2.cancel();
        }
        View view = toast.getView();
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullExpressionValue(view, "toast.view!!");
        setContextCompat(view, new SafeToastContext(context));
        if (isNotificationEnabled(context)) {
            lastToast = toast;
            toast.show();
            return;
        }
        Activity topActivity = AppHolder.getActivityStackManager().getTopActivity();
        if (!(topActivity instanceof BaseActivity) || !((BaseActivity) topActivity).isResume()) {
            showSystemToast(toast);
        } else {
            showToastInActivity(topActivity, toast);
        }
    }

    private final void setContextCompat(View view, Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                Intrinsics.checkNotNullExpressionValue(declaredField, "field");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final void showSystemToast(Toast toast) {
        try {
            Method declaredMethod = Toast.class.getDeclaredMethod("getService", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getServiceMethod");
            declaredMethod.setAccessible(true);
            if (iNotificationManagerObj == null) {
                iNotificationManagerObj = declaredMethod.invoke(null, new Object[0]);
                Object newProxyInstance = Proxy.newProxyInstance(toast.getClass().getClassLoader(), new Class[]{Class.forName("android.app.INotificationManager")}, ToastUtils$showSystemToast$iNotificationManagerProxy$1.INSTANCE);
                Field declaredField = Toast.class.getDeclaredField("sService");
                Intrinsics.checkNotNullExpressionValue(declaredField, "sServiceFiled");
                declaredField.setAccessible(true);
                declaredField.set(null, newProxyInstance);
            }
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final boolean isNotificationEnabled(Context context) {
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(context)");
        return from.areNotificationsEnabled();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/util/ToastUtils$SafeToastContext;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getApplicationContext", "ApplicationContextWrapper", "WindowManagerWrapper", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ToastUtils.kt */
    private static final class SafeToastContext extends ContextWrapper {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SafeToastContext(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "base");
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            Context baseContext = getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
            Context applicationContext = baseContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "baseContext.applicationContext");
            return new ApplicationContextWrapper(applicationContext);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/util/ToastUtils$SafeToastContext$ApplicationContextWrapper;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getSystemService", "", "name", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ToastUtils.kt */
        public static final class ApplicationContextWrapper extends ContextWrapper {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ApplicationContextWrapper(Context context) {
                super(context);
                Intrinsics.checkNotNullParameter(context, "base");
            }

            @Override // android.content.ContextWrapper, android.content.Context
            public Object getSystemService(String str) {
                Object obj;
                Intrinsics.checkNotNullParameter(str, "name");
                if (Intrinsics.areEqual("window", str)) {
                    Object systemService = getBaseContext().getSystemService(str);
                    Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                    obj = new WindowManagerWrapper((WindowManager) systemService);
                } else {
                    obj = super.getSystemService(str);
                }
                Intrinsics.checkNotNullExpressionValue(obj, "if (Context.WINDOW_SERVI…er.getSystemService(name)");
                return obj;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/util/ToastUtils$SafeToastContext$WindowManagerWrapper;", "Landroid/view/WindowManager;", "base", "(Landroid/view/WindowManager;)V", "addView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "getDefaultDisplay", "Landroid/view/Display;", "removeView", "removeViewImmediate", "updateViewLayout", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ToastUtils.kt */
        private static final class WindowManagerWrapper implements WindowManager {
            public static final Companion Companion = new Companion(null);
            private static final String TAG = "WindowManagerWrapper";
            private final WindowManager base;

            public WindowManagerWrapper(WindowManager windowManager) {
                Intrinsics.checkNotNullParameter(windowManager, "base");
                this.base = windowManager;
            }

            @Override // android.view.WindowManager
            public Display getDefaultDisplay() {
                Display defaultDisplay = this.base.getDefaultDisplay();
                Intrinsics.checkNotNullExpressionValue(defaultDisplay, "base.defaultDisplay");
                return defaultDisplay;
            }

            @Override // android.view.WindowManager
            public void removeViewImmediate(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.base.removeViewImmediate(view);
            }

            @Override // android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(layoutParams, "params");
                try {
                    Log.d(TAG, "WindowManager's addView(view, params) has been hooked.");
                    this.base.addView(view, layoutParams);
                } catch (WindowManager.BadTokenException unused) {
                    Log.d(TAG, "BadTokenException ignored");
                } catch (Throwable th) {
                    Log.e(TAG, "[addView]", th);
                }
            }

            @Override // android.view.ViewManager
            public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(layoutParams, "params");
                this.base.updateViewLayout(view, layoutParams);
            }

            @Override // android.view.ViewManager
            public void removeView(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.base.removeView(view);
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/util/ToastUtils$SafeToastContext$WindowManagerWrapper$Companion;", "", "()V", "TAG", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
            /* compiled from: ToastUtils.kt */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }
        }
    }

    private final void showToastInActivity(Activity activity, Toast toast) {
        FrameLayout contentView = UiUtils.getContentView(activity);
        int i = 0;
        if (23 <= Build.VERSION.SDK_INT) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
            if (rootWindowInsets != null) {
                i = rootWindowInsets.getSystemWindowInsetBottom();
            }
        } else {
            FrameLayout frameLayout = contentView;
            DrawSystemBarFrameLayout drawSystemBarFrameLayout = (DrawSystemBarFrameLayout) UiUtils.findFirstChildViewByType(frameLayout, DrawSystemBarFrameLayout.class);
            if (drawSystemBarFrameLayout != null) {
                i = drawSystemBarFrameLayout.getLastInsetsRect().bottom;
            } else {
                KeyBoardLayout keyBoardLayout = (KeyBoardLayout) UiUtils.findFirstChildViewByType(frameLayout, KeyBoardLayout.class);
                if (keyBoardLayout != null) {
                    i = keyBoardLayout.getKeyBoardHeight();
                }
            }
        }
        View view = toast.getView();
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullExpressionValue(view, "toast.view!!");
        contentView.addView(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        FrameLayout.LayoutParams layoutParams3 = layoutParams2;
        layoutParams3.leftMargin = NumberExtendsKt.getDp((Number) 32);
        layoutParams3.rightMargin = NumberExtendsKt.getDp((Number) 32);
        layoutParams3.gravity = 17;
        layoutParams3.bottomMargin = i / 2;
        view.setLayoutParams(layoutParams2);
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).setDuration(160).start();
        int duration = toast.getDuration();
        long j = 1500;
        if (duration != 0 && duration == 1) {
            j = 3000;
        }
        contentView.postDelayed(new ToastUtils$showToastInActivity$2(view, contentView), j);
    }
}
