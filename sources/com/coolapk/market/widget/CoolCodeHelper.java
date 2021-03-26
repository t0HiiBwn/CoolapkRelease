package com.coolapk.market.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Handler;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.event.ApplicationVisibleEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UriActionUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/widget/CoolCodeHelper;", "", "()V", "KEY_CLIPBOARD_HASHCODE", "", "clipboard", "Landroid/content/ClipboardManager;", "handler", "Landroid/os/Handler;", "lastClipBoardHashcode", "", "maybeHasNext", "", "checkLastClipboardCode", "", "activity", "Landroid/app/Activity;", "handleCoolApkUrl", "Lcom/coolapk/market/view/base/BaseActivity;", "url", "init", "context", "Landroid/app/Application;", "isCoolApkInternalUrl", "onApplicationVisibleChange", "event", "Lcom/coolapk/market/event/ApplicationVisibleEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolCodeHelper.kt */
public final class CoolCodeHelper {
    public static final CoolCodeHelper INSTANCE;
    public static final String KEY_CLIPBOARD_HASHCODE = "LAST_CLIPBOARD_HASHCODE";
    private static ClipboardManager clipboard;
    private static final Handler handler = new Handler();
    private static int lastClipBoardHashcode;
    private static boolean maybeHasNext = true;

    static {
        CoolCodeHelper coolCodeHelper = new CoolCodeHelper();
        INSTANCE = coolCodeHelper;
        EventBus.getDefault().register(coolCodeHelper);
    }

    private CoolCodeHelper() {
    }

    @Subscribe
    public final void onApplicationVisibleChange(ApplicationVisibleEvent applicationVisibleEvent) {
        Intrinsics.checkNotNullParameter(applicationVisibleEvent, "event");
        if (!applicationVisibleEvent.isShown()) {
            maybeHasNext = true;
        }
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        Object systemService = application.getSystemService("clipboard");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        clipboard = (ClipboardManager) systemService;
        application.registerActivityLifecycleCallbacks(new CoolCodeHelper$init$1());
        lastClipBoardHashcode = DataManager.getInstance().getPreferencesInt("LAST_CLIPBOARD_HASHCODE", 0);
    }

    /* access modifiers changed from: private */
    public final void checkLastClipboardCode(Activity activity) {
        ClipData.Item itemAt;
        CharSequence text;
        String obj;
        if (!activity.isFinishing() && !activity.isDestroyed() && UserPermissionChecker.INSTANCE.getCanReadClipBoard() && maybeHasNext) {
            boolean z = false;
            maybeHasNext = false;
            if (lastClipBoardHashcode != 0) {
                z = true;
            }
            ClipboardManager clipboardManager = clipboard;
            if (clipboardManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clipboard");
            }
            if (clipboardManager.hasPrimaryClip() && (activity instanceof BaseActivity)) {
                ClipboardManager clipboardManager2 = clipboard;
                if (clipboardManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clipboard");
                }
                ClipData primaryClip = clipboardManager2.getPrimaryClip();
                if (primaryClip != null) {
                    Intrinsics.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
                    ClipDescription description = primaryClip.getDescription();
                    if (description.hasMimeType("text/plain")) {
                        Intrinsics.checkNotNullExpressionValue(description, "description");
                        if (!Intrinsics.areEqual(description.getLabel(), "textFromCoolapk") && (itemAt = primaryClip.getItemAt(primaryClip.getItemCount() - 1)) != null && (text = itemAt.getText()) != null && (obj = text.toString()) != null) {
                            int hashCode = (description.toString() + obj).hashCode();
                            if (!z || hashCode != lastClipBoardHashcode) {
                                lastClipBoardHashcode = hashCode;
                                DataManager instance = DataManager.getInstance();
                                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                                instance.getPreferencesEditor().putInt("LAST_CLIPBOARD_HASHCODE", lastClipBoardHashcode).apply();
                                String extraUrl = StringUtils.getExtraUrl(activity, obj);
                                if (UriUtils.isCoolApkHost(extraUrl)) {
                                    Intrinsics.checkNotNullExpressionValue(extraUrl, "url");
                                    if (isCoolApkInternalUrl(extraUrl)) {
                                        handleCoolApkUrl((BaseActivity) activity, extraUrl);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final boolean isCoolApkInternalUrl(String str) {
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        UriActionUtils.UriAction findUriAction = UriActionUtils.findUriAction(parse);
        if (findUriAction == null || !(!Intrinsics.areEqual(findUriAction.getActionType(), "else")) || !(!Intrinsics.areEqual(findUriAction.getActionType(), "web"))) {
            return false;
        }
        return true;
    }

    private final void handleCoolApkUrl(BaseActivity baseActivity, String str) {
        BaseActivity baseActivity2 = baseActivity;
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity2);
        AlertDialog create = builder.setMessage("检测到你刚刚复制了酷安的链接\n\n" + str + "\n\n是否打开?").setCancelable(true).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton("打开", new CoolCodeHelper$handleCoolApkUrl$1(baseActivity, str)).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(baseActivity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }
}
