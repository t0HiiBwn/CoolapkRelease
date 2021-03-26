package com.coolapk.market.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.State;
import com.coolapk.market.model.UninstallState;
import com.coolapk.market.processor.FileProcessorFactory;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.Toast;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class StateUtils {

    public interface OnClickHandleCallback {
        boolean onClickHandle(int i);
    }

    public static DownloadState findLatestDownloadState(String... strArr) {
        DownloadState downloadState = null;
        if (!(strArr == null || strArr.length == 0)) {
            for (String str : strArr) {
                if (str != null) {
                    DownloadState downloadState2 = DataManager.getInstance().getDownloadState(str);
                    if (downloadState == null || (downloadState2 != null && downloadState2.getStartTime() >= downloadState.getStartTime())) {
                        downloadState = downloadState2;
                    }
                }
            }
        }
        return downloadState;
    }

    public static State findLatestState(String str, String... strArr) {
        DownloadState findLatestDownloadState = findLatestDownloadState(strArr);
        UninstallState uninstallState = null;
        InstallState installState = (findLatestDownloadState == null || !findLatestDownloadState.isSuccess()) ? null : DataManager.getInstance().getInstallState(findLatestDownloadState.getFilePathMd5());
        if (str != null) {
            uninstallState = DataManager.getInstance().getUninstallState(str);
        }
        return compareStartTime(findLatestDownloadState, installState, uninstallState);
    }

    private static State compareStartTime(State... stateArr) {
        State state = null;
        for (State state2 : stateArr) {
            if (state == null || (state2 != null && state2.getStartTime() >= state.getStartTime())) {
                state = state2;
            }
        }
        return state;
    }

    public static String getActionText(Context context, String str, String str2, String... strArr) {
        return getActionText(context, false, str, str2, strArr);
    }

    public static String getActionText(Context context, boolean z, String str, String str2, String... strArr) {
        String actionTextWithState = getActionTextWithState(context, z, str, findLatestState(str2, strArr));
        if (actionTextWithState != null) {
            return actionTextWithState;
        }
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(str);
        if (mobileAppExistFast == null || !mobileAppExistFast.isExist()) {
            return context.getString(2131886128);
        }
        if (mobileAppExistFast.canUpgrade()) {
            return context.getString(2131886155);
        }
        return context.getString(2131886142);
    }

    public static String getActionTextWithState(Context context, boolean z, String str, State state) {
        MobileApp mobileAppExistFast;
        MobileApp mobileAppExistFast2;
        if (state instanceof DownloadState) {
            DownloadState downloadState = (DownloadState) state;
            String url = downloadState.getUrl();
            Extra extra = downloadState.getExtra();
            int state2 = downloadState.getState();
            if (state2 == 1 || state2 == 2 || state2 == 3) {
                if (z) {
                    return StringUtils.formatPercent((float) downloadState.getCurrentLength(), (float) downloadState.getTotalLength());
                }
                return context.getString(2131886752);
            } else if (state2 != 5) {
                if (!downloadState.isSuccess() || TextUtils.isEmpty(downloadState.getFilePath())) {
                    return context.getString(2131886120);
                }
                if (!FileProcessorFactory.canHandleWith(CoolFileUtils.getFileExtension(downloadState.getFilePath()))) {
                    return context.getString(2131886142);
                }
                if (UriUtils.isCoolMarketHost(url) && extra != null && (mobileAppExistFast2 = DataManager.getInstance().getMobileAppExistFast(str)) != null && mobileAppExistFast2.isExist()) {
                    int i = extra.getInt("VERSION_CODE");
                    if (!mobileAppExistFast2.canUpgrade() && mobileAppExistFast2.getVersionCode() >= i) {
                        return context.getString(2131886142);
                    }
                }
                return context.getString(2131886137);
            } else if (downloadState.getExtra() == null || downloadState.getExtra().getBoolean("IS_DELETE")) {
                return null;
            } else {
                return context.getString(2131886120);
            }
        } else if (state instanceof InstallState) {
            InstallState installState = (InstallState) state;
            switch (installState.getState()) {
                case 1:
                    return context.getString(2131886862);
                case 2:
                    return context.getString(2131886862);
                case 3:
                    return context.getString(2131886859);
                case 4:
                    return context.getString(2131886860);
                case 5:
                    return context.getString(2131886861);
                case 6:
                    return context.getString(2131886858);
                case 7:
                    if (installState.hasError()) {
                        int errorCode = installState.getErrorCode();
                        if (errorCode == -8 || errorCode == -4 || errorCode == 0) {
                            return context.getString(2131886137);
                        }
                        return context.getString(2131886129);
                    }
                    if (installState.getExtra() != null) {
                        int i2 = installState.getExtra().getInt("VERSION_CODE");
                        if (!TextUtils.isEmpty(str) && (mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(str)) != null && mobileAppExistFast.getVersionCode() == i2) {
                            return context.getString(2131886142);
                        }
                    }
                    return context.getString(2131886137);
                default:
                    return null;
            }
        } else if (!(state instanceof UninstallState)) {
            return null;
        } else {
            int state3 = ((UninstallState) state).getState();
            if (state3 == 1 || state3 == 2) {
                return context.getString(2131887049);
            }
            return null;
        }
    }

    public static void handleClick(Activity activity, ClickInfo clickInfo, View view) {
        if (view instanceof ActionButtonFrameLayout) {
            handleClick(activity, clickInfo, (ActionButtonFrameLayout) view, null);
        } else if (view instanceof ActionButton) {
            handleClick(activity, clickInfo, null, (ActionButton) view);
        } else {
            handleClick(activity, clickInfo, null, null);
        }
    }

    public static void handleClick(final Activity activity, final ClickInfo clickInfo, final ActionButtonFrameLayout actionButtonFrameLayout, ActionButton actionButton) {
        int state;
        MobileApp mobileAppExistFast;
        String packageName = clickInfo.getPackageName();
        State findLatestState = findLatestState(clickInfo.getUninstallKey(), clickInfo.getDownloadKeyArray());
        StringBuilder sb = new StringBuilder();
        sb.append(findLatestState != null ? findLatestState.toString() : "[No state]");
        sb.append("\n");
        String str = null;
        if (findLatestState instanceof DownloadState) {
            DownloadState downloadState = (DownloadState) findLatestState;
            final String url = downloadState.getUrl();
            final Extra extra = downloadState.getExtra();
            sb.append("Handle download state: ");
            sb.append(downloadState.getState());
            sb.append("\n");
            int state2 = downloadState.getState();
            if (state2 == 1 || state2 == 2 || state2 == 3) {
                if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleStop(findLatestState)) {
                    ActionManager.stopDownload(activity, url);
                    return;
                }
                return;
            } else if (state2 != 5) {
                if (!downloadState.isSuccess() || TextUtils.isEmpty(downloadState.getFilePath())) {
                    sb.append("Download not success or path is null");
                    sb.append("\n");
                    if (clickInfo.getClickHandleListener() != null && clickInfo.getClickHandleListener().onClickHandleDownload(findLatestState)) {
                        return;
                    }
                    if (actionButton != null) {
                        actionButton.requireAppAction().startDownloadAnim(new Function0(activity, url, extra, actionButtonFrameLayout) {
                            /* class com.coolapk.market.util.$$Lambda$StateUtils$xstZikyOHPZSTThe0jC1UOxlMrs */
                            public final /* synthetic */ Activity f$0;
                            public final /* synthetic */ String f$1;
                            public final /* synthetic */ Extra f$2;
                            public final /* synthetic */ ActionButtonFrameLayout f$3;

                            {
                                this.f$0 = r1;
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StateUtils.lambda$handleClick$0(this.f$0, this.f$1, this.f$2, this.f$3);
                            }
                        });
                        return;
                    } else {
                        startDownloadWithAnim(downloadState, actionButtonFrameLayout, new AnimatorListenerAdapter() {
                            /* class com.coolapk.market.util.StateUtils.AnonymousClass1 */

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (!ActionManager.startDownload(activity, url, extra, 0)) {
                                    StateUtils.resetAnim(actionButtonFrameLayout);
                                }
                            }
                        });
                        return;
                    }
                } else {
                    sb.append("Download success and has path");
                    sb.append("\n");
                    if (!UriUtils.isCoolMarketHost(url) || extra == null) {
                        sb.append("Other file");
                        sb.append("\n");
                        if (FileProcessorFactory.canHandleWith(CoolFileUtils.getFileExtension(downloadState.getFilePath()))) {
                            sb.append("Can handle file");
                            sb.append("\n");
                            if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleInstall(findLatestState)) {
                                sb.append("install");
                                sb.append("\n");
                                ActionManager.install(activity, downloadState.getFilePath(), downloadState.getUrl(), downloadState.getExtra());
                            }
                        } else {
                            sb.append("Can not handle file");
                            sb.append("\n");
                            if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleOpen(findLatestState)) {
                                try {
                                    Uri fromFile = Uri.fromFile(new File(downloadState.getFilePath()));
                                    String mimeType = downloadState.getMimeType();
                                    if (TextUtils.isEmpty(mimeType)) {
                                        mimeType = "*/*";
                                    }
                                    ActionManager.startView(activity, fromFile, mimeType);
                                } catch (ActivityNotFoundException unused) {
                                    Toast.show(activity, 2131887189);
                                }
                            }
                        }
                    } else {
                        sb.append("Coolapk host");
                        sb.append("\n");
                        MobileApp mobileAppExistFast2 = DataManager.getInstance().getMobileAppExistFast(packageName);
                        if (mobileAppExistFast2 != null && mobileAppExistFast2.isExist()) {
                            sb.append("Mobile exist");
                            sb.append("\n");
                            int i = extra.getInt("VERSION_CODE");
                            if (!mobileAppExistFast2.canUpgrade()) {
                                sb.append("Can not upgrade");
                                sb.append("\n");
                                if (mobileAppExistFast2.getVersionCode() >= i) {
                                    sb.append("Version code");
                                    sb.append("\n");
                                    if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleOpen(findLatestState)) {
                                        Extra targetExtra = clickInfo.getTargetExtra();
                                        if (targetExtra != null) {
                                            str = targetExtra.getString("EXTRA_OPEN_LINK");
                                        }
                                        ActionManager.openApp(activity, packageName, str);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        sb.append("Ready to install");
                        sb.append("\n");
                        if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleInstall(findLatestState)) {
                            sb.append("install");
                            sb.append("\n");
                            ActionManager.install(activity, downloadState.getFilePath(), downloadState.getUrl(), downloadState.getExtra());
                        }
                    }
                    sb.append("End download none or success");
                    sb.append("\n");
                    return;
                }
            } else if (downloadState.getExtra() != null && !downloadState.getExtra().getBoolean("IS_DELETE")) {
                if (clickInfo.getClickHandleListener() != null && clickInfo.getClickHandleListener().onClickHandleDownload(findLatestState)) {
                    return;
                }
                if (actionButton != null) {
                    actionButton.requireAppAction().startDownloadAnim(new Function0(activity, url, extra, actionButtonFrameLayout) {
                        /* class com.coolapk.market.util.$$Lambda$StateUtils$FsVLEgpluweKBu7Ntg3k5nlLRGY */
                        public final /* synthetic */ Activity f$0;
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ Extra f$2;
                        public final /* synthetic */ ActionButtonFrameLayout f$3;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StateUtils.lambda$handleClick$1(this.f$0, this.f$1, this.f$2, this.f$3);
                        }
                    });
                    return;
                } else {
                    startDownloadWithAnim(downloadState, actionButtonFrameLayout, new AnimatorListenerAdapter() {
                        /* class com.coolapk.market.util.StateUtils.AnonymousClass2 */

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (!ActionManager.startDownload(activity, url, extra, 0)) {
                                StateUtils.resetAnim(actionButtonFrameLayout);
                            }
                        }
                    });
                    return;
                }
            }
        } else if (findLatestState instanceof InstallState) {
            InstallState installState = (InstallState) findLatestState;
            sb.append("Handle install state: ");
            sb.append(installState.getState());
            sb.append("\n");
            switch (installState.getState()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (clickInfo.getClickHandleListener() != null) {
                        clickInfo.getClickHandleListener().onClickHandleNone(findLatestState);
                        return;
                    }
                    return;
                case 7:
                    if (installState.hasError()) {
                        sb.append("Install state has error: ");
                        sb.append(installState.getErrorCode());
                        sb.append("\n");
                        int errorCode = installState.getErrorCode();
                        if (errorCode == -8 || errorCode == -4 || errorCode == 0) {
                            if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleInstall(findLatestState)) {
                                ActionManager.install(activity, installState.getPath(), installState.getFrom(), installState.getExtra());
                                return;
                            }
                            return;
                        }
                    } else {
                        sb.append("Install state without error");
                        sb.append("\n");
                        if (installState.getExtra() != null) {
                            int i2 = installState.getExtra().getInt("VERSION_CODE");
                            if (TextUtils.isEmpty(packageName) || (mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(packageName)) == null || mobileAppExistFast.getVersionCode() != i2) {
                                sb.append("Ready install");
                                sb.append("\n");
                                if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleInstall(findLatestState)) {
                                    sb.append("Install");
                                    sb.append("\n");
                                    ActionManager.install(activity, installState.getPath(), installState.getFrom(), installState.getExtra());
                                    return;
                                }
                                return;
                            } else if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleOpen(findLatestState)) {
                                Extra targetExtra2 = clickInfo.getTargetExtra();
                                if (targetExtra2 != null) {
                                    str = targetExtra2.getString("EXTRA_OPEN_LINK");
                                }
                                ActionManager.openApp(activity, packageName, str);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            if (clickInfo.getClickHandleListener() != null) {
                                clickInfo.getClickHandleListener().onClickHandleNone(findLatestState);
                            }
                            sb.append("Install nothing?");
                            sb.append("\n");
                            return;
                        }
                    }
                    break;
            }
            sb.append("Install state done: ");
            sb.append(installState.getState());
            sb.append("\n");
        } else if ((findLatestState instanceof UninstallState) && ((state = ((UninstallState) findLatestState).getState()) == 1 || state == 2)) {
            if (clickInfo.getClickHandleListener() != null) {
                clickInfo.getClickHandleListener().onClickHandleNone(findLatestState);
                return;
            }
            return;
        }
        sb.append("Handle click default action");
        sb.append("\n");
        MobileApp mobileAppExistFast3 = DataManager.getInstance().getMobileAppExistFast(packageName);
        if (mobileAppExistFast3 == null || mobileAppExistFast3.canUpgrade()) {
            if (clickInfo.getClickHandleListener() != null && clickInfo.getClickHandleListener().onClickHandleDownload(findLatestState)) {
                return;
            }
            if (actionButton != null) {
                actionButton.requireAppAction().startDownloadAnim(new Function0(activity, clickInfo, actionButtonFrameLayout) {
                    /* class com.coolapk.market.util.$$Lambda$StateUtils$1pisEtglRXX5HHYTD0hHvWhgFs */
                    public final /* synthetic */ Activity f$0;
                    public final /* synthetic */ ClickInfo f$1;
                    public final /* synthetic */ ActionButtonFrameLayout f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StateUtils.lambda$handleClick$2(this.f$0, this.f$1, this.f$2);
                    }
                });
            } else {
                startDownloadWithAnim(null, actionButtonFrameLayout, new AnimatorListenerAdapter() {
                    /* class com.coolapk.market.util.StateUtils.AnonymousClass3 */

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!ActionManager.startDownload(activity, clickInfo.getTargetUrl(), clickInfo.getTargetExtra(), clickInfo.getTargetFlag())) {
                            StateUtils.resetAnim(actionButtonFrameLayout);
                        }
                    }
                });
            }
        } else if (clickInfo.getClickHandleListener() == null || !clickInfo.getClickHandleListener().onClickHandleOpen(findLatestState)) {
            Extra targetExtra3 = clickInfo.getTargetExtra();
            if (targetExtra3 != null) {
                str = targetExtra3.getString("EXTRA_OPEN_LINK");
            }
            ActionManager.openApp(activity, packageName, str);
        }
    }

    static /* synthetic */ Unit lambda$handleClick$0(Activity activity, String str, Extra extra, ActionButtonFrameLayout actionButtonFrameLayout) {
        if (ActionManager.startDownload(activity, str, extra, 0)) {
            return null;
        }
        resetAnim(actionButtonFrameLayout);
        return null;
    }

    static /* synthetic */ Unit lambda$handleClick$1(Activity activity, String str, Extra extra, ActionButtonFrameLayout actionButtonFrameLayout) {
        if (ActionManager.startDownload(activity, str, extra, 0)) {
            return null;
        }
        resetAnim(actionButtonFrameLayout);
        return null;
    }

    static /* synthetic */ Unit lambda$handleClick$2(Activity activity, ClickInfo clickInfo, ActionButtonFrameLayout actionButtonFrameLayout) {
        if (ActionManager.startDownload(activity, clickInfo.getTargetUrl(), clickInfo.getTargetExtra(), clickInfo.getTargetFlag())) {
            return null;
        }
        resetAnim(actionButtonFrameLayout);
        return null;
    }

    private static void startDownloadWithAnim(DownloadState downloadState, ActionButtonFrameLayout actionButtonFrameLayout, Animator.AnimatorListener animatorListener) {
        if (actionButtonFrameLayout == null) {
            animatorListener.onAnimationEnd(null);
        } else {
            actionButtonFrameLayout.setActionBackground(Math.max(0, (downloadState == null || downloadState.getTotalLength() == 0) ? 0 : (int) ((downloadState.getCurrentLength() * 10000) / downloadState.getTotalLength())), animatorListener);
        }
    }

    /* access modifiers changed from: private */
    public static void resetAnim(ActionButtonFrameLayout actionButtonFrameLayout) {
        if (actionButtonFrameLayout != null) {
            actionButtonFrameLayout.setActionBackground(10000, null);
        }
    }

    public static String getActionButtonBackground(DownloadState downloadState) {
        InstallState installState;
        if (downloadState == null || (downloadState.isSuccess() && !TextUtils.isEmpty(downloadState.getFilePath()) && (installState = DataManager.getInstance().getInstallState(downloadState.getFilePathMd5())) != null && installState.getStartTime() > downloadState.getStartTime())) {
            return "normal";
        }
        int state = downloadState.getState();
        if (state == 1 || state == 2 || state == 3 || (state == 5 && downloadState.getExtra() != null && !downloadState.getExtra().getBoolean("IS_DELETE"))) {
            return "download";
        }
        return "normal";
    }

    public static int getActionButtonTextColor(DownloadState downloadState) {
        InstallState installState;
        if (downloadState != null) {
            if (downloadState.isSuccess() && !TextUtils.isEmpty(downloadState.getFilePath()) && (installState = DataManager.getInstance().getInstallState(downloadState.getFilePathMd5())) != null && installState.getStartTime() > downloadState.getStartTime()) {
                return ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099912);
            }
            int state = downloadState.getState();
            if (state == 1 || state == 2 || state == 3) {
                return AppHolder.getAppTheme().getTextColorPrimary();
            }
            if (state == 5 && downloadState.getExtra() != null && !downloadState.getExtra().getBoolean("IS_DELETE")) {
                return AppHolder.getAppTheme().getTextColorPrimary();
            }
        }
        return ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099912);
    }

    public static void updateActionProgress(DownloadState downloadState, Drawable drawable) {
        if (drawable instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable) drawable;
            if (!(rippleDrawable.getDrawable(0) instanceof LayerDrawable)) {
                return;
            }
            if (downloadState != null) {
                ((LayerDrawable) rippleDrawable.getDrawable(0)).findDrawableByLayerId(16908301).setLevel(downloadState.getTotalLength() != 0 ? (int) ((downloadState.getCurrentLength() * 10000) / downloadState.getTotalLength()) : 0);
            } else {
                LogUtils.w("DownloadState can't be null", new Object[0]);
            }
        }
    }

    public static class DownloadAgainConfirmDialog extends BaseDialogFragment {
        private static final String KEY_URL_MD5 = "URL_MD5";

        public static DownloadAgainConfirmDialog newInstance(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("URL_MD5", str);
            DownloadAgainConfirmDialog downloadAgainConfirmDialog = new DownloadAgainConfirmDialog();
            downloadAgainConfirmDialog.setArguments(bundle);
            return downloadAgainConfirmDialog;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new AlertDialog.Builder(getActivity()).setMessage(2131886724).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.util.StateUtils.DownloadAgainConfirmDialog.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownloadState downloadState = DataManager.getInstance().getDownloadState(DownloadAgainConfirmDialog.this.getArguments().getString("URL_MD5"));
                    if (downloadState != null) {
                        ActionManager.startDownload(DownloadAgainConfirmDialog.this.getActivity(), downloadState.getUrl(), downloadState.getExtra(), 0);
                    }
                }
            }).setNegativeButton(2131886140, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.util.StateUtils.DownloadAgainConfirmDialog.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create();
        }
    }
}
