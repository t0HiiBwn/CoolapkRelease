package com.coolapk.market.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/widget/PrivacyAlertDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "saveIntentAndVersion", "intent", "", "Callback", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PrivacyAlertDialog.kt */
public final class PrivacyAlertDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final String USER_PRIVACY_INTENT_AGREE = "AGREE";
    public static final String USER_PRIVACY_INTENT_VIEW_ONLY = "VIEW_ONLY";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/PrivacyAlertDialog$Callback;", "", "onPrivacyButtonClick", "", "intent", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PrivacyAlertDialog.kt */
    public interface Callback {
        void onPrivacyButtonClick(String str);
    }

    @JvmStatic
    public static final PrivacyAlertDialog newInstance() {
        return Companion.newInstance();
    }

    @JvmStatic
    public static final boolean shouldShowByFirstInstall() {
        return Companion.shouldShowByFirstInstall();
    }

    @JvmStatic
    public static final boolean shouldShowByIntent() {
        return Companion.shouldShowByIntent();
    }

    @JvmStatic
    public static final boolean shouldShowByVersion() {
        return Companion.shouldShowByVersion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/PrivacyAlertDialog$Companion;", "", "()V", "USER_PRIVACY_INTENT_AGREE", "", "USER_PRIVACY_INTENT_VIEW_ONLY", "newInstance", "Lcom/coolapk/market/widget/PrivacyAlertDialog;", "shouldShowByFirstInstall", "", "shouldShowByIntent", "shouldShowByVersion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PrivacyAlertDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean shouldShowByFirstInstall() {
            return DataManager.getInstance().getPreferencesString("USER_PRIVACY_INTENT", null) == null;
        }

        @JvmStatic
        public final boolean shouldShowByIntent() {
            return !Intrinsics.areEqual(DataManager.getInstance().getPreferencesString("USER_PRIVACY_INTENT", null), "AGREE");
        }

        @JvmStatic
        public final boolean shouldShowByVersion() {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            String optString = appSetting.getConfigJson().optString("UserPrivacy.Version", null);
            String preferencesString = DataManager.getInstance().getPreferencesString("USER_PRIVACY_VERSION", null);
            if (optString != null && !TextUtils.equals(optString, preferencesString)) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final PrivacyAlertDialog newInstance() {
            return new PrivacyAlertDialog();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        SpannableStringBuilder convert = LinkTextUtils.convert("根据相关法律法规要求，我们更新完善了《<a href=\"" + UriUtils.getCoolApkUserAgreementUrl() + "\">用户协议</a>》及《<a href=\"" + UriUtils.getCoolApkUserPrivacyUrl() + "\">隐私政策</a>》，建议您仔细阅读相关条款。在您同意并接受后，将可以正常使用酷安为您提供的全部功能。\n\n同时，我们为您提供了仅浏览模式，此模式下您可以正常浏览动态与下载安装应用，但无法登录注册与发布动态。", AppHolder.getAppTheme().getColorAccent(), null);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AlertDialog create = new AlertDialog.Builder(activity).setCancelable(false).setTitle("隐私政策提示").setMessage(convert).setNegativeButton("仅浏览", new PrivacyAlertDialog$onCreateDialog$1(this)).setPositiveButton("同意并继续", new PrivacyAlertDialog$onCreateDialog$2(this)).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        return create;
    }

    @Override // com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        try {
            Dialog dialog2 = getDialog();
            TextView textView = dialog2 != null ? (TextView) dialog2.findViewById(16908299) : null;
            if (textView != null) {
                textView.setMovementMethod(FixTouchLinkMovementMethod.getInstance());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void saveIntentAndVersion(String str) {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        String optString = appSetting.getConfigJson().optString("UserPrivacy.Version", null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("USER_PRIVACY_INTENT", str).putString("USER_PRIVACY_VERSION", optString).apply();
        FragmentActivity activity = getActivity();
        if (activity instanceof Callback) {
            ((Callback) activity).onPrivacyButtonClick(str);
        }
    }
}
