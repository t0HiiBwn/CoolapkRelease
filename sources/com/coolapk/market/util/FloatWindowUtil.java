package com.coolapk.market.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/util/FloatWindowUtil;", "", "()V", "compatWindowsLayoutParamsApi", "", "layoutParams", "Landroid/view/WindowManager$LayoutParams;", "requestSettingCanDrawOverlays", "activity", "Landroid/app/Activity;", "showNeedFloatingPermissionDialog", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FloatWindowUtil.kt */
public final class FloatWindowUtil {
    public static final FloatWindowUtil INSTANCE = new FloatWindowUtil();

    private final void requestSettingCanDrawOverlays(Activity activity) {
    }

    private FloatWindowUtil() {
    }

    private final void compatWindowsLayoutParamsApi(WindowManager.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
    }

    public final void showNeedFloatingPermissionDialog(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        AlertDialog create = new AlertDialog.Builder(activity2).setTitle("小窗播放需要悬浮窗权限").setMessage("请点击：设置-应用管理-酷安，给予酷安悬浮窗权限").setPositiveButton("去设置", new FloatWindowUtil$showNeedFloatingPermissionDialog$1(activity)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }
}
