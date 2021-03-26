package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ClientExceptionHandler;
import com.coolapk.market.manager.DataParseException;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.UninstallState;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.CoolApkRuntimeException;
import com.coolapk.market.network.EmitNullException;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ToastUtils;
import com.google.android.material.snackbar.Snackbar;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Toast.kt */
public final class Toast {
    public static final Toast INSTANCE = new Toast();

    public static final void show(Context context, String str) {
        show$default(context, str, 0, false, 12, null);
    }

    public static final void show(Context context, String str, int i) {
        show$default(context, str, i, false, 8, null);
    }

    private Toast() {
    }

    private final Context getTopActivityOrApplication() {
        Context currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = AppHolder.getApplication();
            Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getApplication()");
        }
        return currentActivity;
    }

    public static final void show(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        show$default(context, AppHolder.getApplication().getString(i), 0, false, 8, null);
    }

    public static /* synthetic */ void show$default(Context context, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        show(context, str, i, z);
    }

    public static final void show(Context context, String str, int i, boolean z) {
        if (str == null) {
            return;
        }
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            AppHolder.getMainThreadHandler().post(new Toast$show$1(context, str, i));
            return;
        }
        String limitLength = KotlinExtendKt.limitLength(str, 140);
        Toast toast = INSTANCE;
        Context topActivityOrApplication = toast.getTopActivityOrApplication();
        android.widget.Toast createToast = toast.createToast(topActivityOrApplication, limitLength, i);
        if (z) {
            createToast.setGravity(17, 0, 0);
        } else {
            createToast.setGravity(80, 0, NumberExtendsKt.getDp((Number) 72));
        }
        ToastUtils.INSTANCE.show(topActivityOrApplication, createToast);
    }

    public static final void show(View view, String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (view != null && view.getContext() != null) {
            Snackbar.make(view, str, -1).show();
        }
    }

    public static final void show(View view, int i) {
        if (view != null && view.getContext() != null) {
            Snackbar.make(view, i, -1).show();
        }
    }

    public static final void error(Context context, Throwable th) {
        Throwable mayBeCause;
        if (th != null && (mayBeCause = ToastKt.getMayBeCause(th)) != null) {
            Toast toast = INSTANCE;
            Context topActivityOrApplication = toast.getTopActivityOrApplication();
            LogUtils.e(th);
            if (mayBeCause instanceof ClientException) {
                if (!ClientExceptionHandler.handleException(topActivityOrApplication, (ClientException) mayBeCause)) {
                    show$default(topActivityOrApplication, mayBeCause.getMessage(), 0, false, 12, null);
                }
            } else if (mayBeCause instanceof SocketTimeoutException) {
                show(topActivityOrApplication, 2131887266);
            } else if ((mayBeCause instanceof ConnectException) || (mayBeCause instanceof UnknownHostException)) {
                show(topActivityOrApplication, 2131887257);
            } else if (mayBeCause instanceof SocketException) {
                show(topActivityOrApplication, 2131887258);
            } else if (mayBeCause instanceof EmitNullException) {
                show$default(topActivityOrApplication, topActivityOrApplication.getString(2131886752), 0, false, 12, null);
            } else if (mayBeCause instanceof CoolApkRuntimeException) {
                show$default(topActivityOrApplication, mayBeCause.getMessage(), 0, false, 12, null);
            } else {
                String message = mayBeCause.getMessage();
                if (message == null) {
                    message = "";
                }
                if (StringsKt.contains$default((CharSequence) message, (CharSequence) "End of input at line 1 column 1 ", false, 2, (Object) null)) {
                    show$default(topActivityOrApplication, "网络连接错误，请检查网络环境", 0, false, 12, null);
                } else {
                    show$default(topActivityOrApplication, topActivityOrApplication.getString(2131887268) + " " + mayBeCause.getMessage(), 0, false, 12, null);
                }
            }
            toast.uploadErrorIfNeed(mayBeCause);
            com.blankj.utilcode.util.LogUtils.file("TOAST_ERROR", th);
        }
    }

    private final void uploadErrorIfNeed(Throwable th) {
        String message = th.getMessage();
        if (message != null) {
            if (StringsKt.startsWith$default(message, "Attempt to invoke virtual method", false, 2, (Object) null) || StringsKt.startsWith$default(message, "Parameter specified as non-null is null", false, 2, (Object) null)) {
                th = new ClientInterceptedException(message, th);
            }
            if ((th instanceof DataParseException) || (th instanceof ClientInterceptedException)) {
                AppHolder.getThirdPartUtils().markException(th);
            }
        }
    }

    public static final void errorInstall(Context context, InstallState installState, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(installState, "state");
        Intrinsics.checkNotNullParameter(str, "defaultTitle");
        if (installState.hasError()) {
            int errorCode = installState.getErrorCode();
            int i = 2131887269;
            if (errorCode == -5) {
                i = 2131887260;
            } else if (errorCode == -4) {
                i = 2131887264;
            } else if (errorCode == -3) {
                i = 2131887262;
            } else if (errorCode == -2) {
                i = 2131887259;
            }
            String str2 = null;
            if (installState.getExtra() != null) {
                Extra extra = installState.getExtra();
                Intrinsics.checkNotNull(extra);
                str2 = extra.getString("TITLE");
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            show$default(context, context.getString(i, str), 0, false, 12, null);
        }
    }

    public static final void errorUninstall(Context context, UninstallState uninstallState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uninstallState, "state");
        if (uninstallState.hasError()) {
            uninstallState.getErrorCode();
            show$default(context, context.getString(2131887267, uninstallState.getTitle()), 0, false, 12, null);
        }
    }

    static /* synthetic */ android.widget.Toast createToast$default(Toast toast, Context context, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return toast.createToast(context, charSequence, i);
    }

    private final android.widget.Toast createToast(Context context, CharSequence charSequence, int i) {
        android.widget.Toast makeText = android.widget.Toast.makeText(context, "", i);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor((int) 3862575674L);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 24));
        Unit unit = Unit.INSTANCE;
        textView.setBackground(gradientDrawable);
        textView.setText(charSequence);
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        textView.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 12));
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(textView);
        Unit unit3 = Unit.INSTANCE;
        makeText.setView(linearLayout);
        Intrinsics.checkNotNullExpressionValue(makeText, "AndroidToast.makeText(co…)\n            }\n        }");
        return makeText;
    }
}
