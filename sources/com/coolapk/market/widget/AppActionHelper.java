package com.coolapk.market.widget;

import android.app.Application;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.StateUtils;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0018\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ$\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\"H\u0002J\u0014\u0010#\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\"J\u0006\u0010%\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/coolapk/market/widget/AppActionHelper;", "", "actionButton", "Lcom/coolapk/market/widget/ActionButton;", "updateSelf", "", "(Lcom/coolapk/market/widget/ActionButton;Z)V", "buttonStyle", "Lcom/coolapk/market/widget/ProgressStyle;", "getButtonStyle", "()Lcom/coolapk/market/widget/ProgressStyle;", "downloadText", "", "keys", "", "getKeys", "()[Ljava/lang/String;", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "getServiceApp", "()Lcom/coolapk/market/model/ServiceApp;", "setServiceApp", "(Lcom/coolapk/market/model/ServiceApp;)V", "stateEventChanged", "com/coolapk/market/widget/AppActionHelper$stateEventChanged$1", "Lcom/coolapk/market/widget/AppActionHelper$stateEventChanged$1;", "upgradeText", "onAttach", "", "onDetach", "setProgress", "downloadState", "Lcom/coolapk/market/model/DownloadState;", "callback", "Lkotlin/Function0;", "startDownloadAnim", "animEnd", "updateWithApp", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class AppActionHelper {
    private final ActionButton actionButton;
    private final String downloadText;
    public ServiceApp serviceApp;
    private final AppActionHelper$stateEventChanged$1 stateEventChanged = new AppActionHelper$stateEventChanged$1(this);
    private final boolean updateSelf;
    private final String upgradeText;

    public AppActionHelper(ActionButton actionButton2, boolean z) {
        Intrinsics.checkNotNullParameter(actionButton2, "actionButton");
        this.actionButton = actionButton2;
        this.updateSelf = z;
        String string = AppHolder.getApplication().getString(2131886155);
        Intrinsics.checkNotNullExpressionValue(string, "AppHolder.getApplication…(R.string.action_upgrade)");
        this.upgradeText = string;
        String string2 = AppHolder.getApplication().getString(2131886128);
        Intrinsics.checkNotNullExpressionValue(string2, "AppHolder.getApplication…R.string.action_download)");
        this.downloadText = string2;
    }

    public final ServiceApp getServiceApp() {
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        return serviceApp2;
    }

    public final void setServiceApp(ServiceApp serviceApp2) {
        Intrinsics.checkNotNullParameter(serviceApp2, "<set-?>");
        this.serviceApp = serviceApp2;
    }

    private final ProgressStyle getButtonStyle() {
        Style buttonStyle = this.actionButton.getButtonStyle();
        Objects.requireNonNull(buttonStyle, "null cannot be cast to non-null type com.coolapk.market.widget.ProgressStyle");
        return (ProgressStyle) buttonStyle;
    }

    private final String[] getKeys() {
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        String[] urlMd5s = ActionButtonBindingAdapters.getUrlMd5s(serviceApp2);
        Intrinsics.checkNotNullExpressionValue(urlMd5s, "ActionButtonBindingAdapters.getUrlMd5s(serviceApp)");
        return urlMd5s;
    }

    public final void startDownloadAnim(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "animEnd");
        String[] keys = getKeys();
        setProgress(StateUtils.findLatestDownloadState((String[]) Arrays.copyOf(keys, keys.length)), function0);
    }

    public final void updateWithApp() {
        String[] keys = getKeys();
        DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState((String[]) Arrays.copyOf(keys, keys.length));
        String actionButtonBackground = StateUtils.getActionButtonBackground(findLatestDownloadState);
        if (actionButtonBackground != null && actionButtonBackground.hashCode() == 1427818632 && actionButtonBackground.equals("download")) {
            setProgress$default(this, findLatestDownloadState, null, 2, null);
        } else {
            getButtonStyle().resetProgress();
        }
        Application application = AppHolder.getApplication();
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        String packageName = serviceApp2.getPackageName();
        ServiceApp serviceApp3 = this.serviceApp;
        if (serviceApp3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        String packageName2 = serviceApp3.getPackageName();
        String[] keys2 = getKeys();
        String actionText = StateUtils.getActionText(application, packageName, packageName2, (String[]) Arrays.copyOf(keys2, keys2.length));
        this.actionButton.setText(actionText);
        if (!getButtonStyle().getShowSize()) {
            return;
        }
        if (Intrinsics.areEqual(this.downloadText, actionText) || Intrinsics.areEqual(this.upgradeText, actionText)) {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            ServiceApp serviceApp4 = this.serviceApp;
            if (serviceApp4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            sb.append(serviceApp4.getApkSizeFormat());
            sb.append(')');
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new RelativeSizeSpan(0.857f), 0, spannableString.length(), 33);
            this.actionButton.append(spannableString);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.widget.AppActionHelper */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void setProgress$default(AppActionHelper appActionHelper, DownloadState downloadState, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        appActionHelper.setProgress(downloadState, function0);
    }

    private final void setProgress(DownloadState downloadState, Function0<Unit> function0) {
        getButtonStyle().setProgress(Math.max(0, (downloadState == null || downloadState.getTotalLength() == 0) ? 0 : (int) ((downloadState.getCurrentLength() * ((long) 10000)) / downloadState.getTotalLength())), false, function0);
    }

    public final void onAttach() {
        if (this.updateSelf) {
            this.stateEventChanged.onAttach();
        }
    }

    public final void onDetach() {
        if (this.updateSelf) {
            this.stateEventChanged.onDetach();
        }
    }
}
