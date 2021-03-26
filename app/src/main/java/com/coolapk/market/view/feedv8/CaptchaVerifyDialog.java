package com.coolapk.market.view.feedv8;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.coolapk.market.databinding.SubmitVertfiyCaptchaDialogBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

/* compiled from: MessageStatusHelper.kt */
public final class CaptchaVerifyDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private SubmitVertfiyCaptchaDialogBinding binding;
    private Function0<Unit> callback;
    private boolean isVerifying;

    public static final /* synthetic */ SubmitVertfiyCaptchaDialogBinding access$getBinding$p(CaptchaVerifyDialog captchaVerifyDialog) {
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding = captchaVerifyDialog.binding;
        if (submitVertfiyCaptchaDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return submitVertfiyCaptchaDialogBinding;
    }

    /* compiled from: MessageStatusHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CaptchaVerifyDialog newInstance(String str, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "message");
            CaptchaVerifyDialog captchaVerifyDialog = new CaptchaVerifyDialog();
            Bundle bundle = new Bundle();
            bundle.putString("message", str);
            Unit unit = Unit.INSTANCE;
            captchaVerifyDialog.setArguments(bundle);
            captchaVerifyDialog.callback = function0;
            return captchaVerifyDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559172, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…tcha_dialog, null, false)");
        this.binding = (SubmitVertfiyCaptchaDialogBinding) inflate;
        AlertDialog.Builder title = new AlertDialog.Builder(requireActivity()).setTitle("图形验证码");
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding = this.binding;
        if (submitVertfiyCaptchaDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = title.setView(submitVertfiyCaptchaDialogBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding = this.binding;
        if (submitVertfiyCaptchaDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = submitVertfiyCaptchaDialogBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(requireArguments().getString("message"));
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding2 = this.binding;
        if (submitVertfiyCaptchaDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = submitVertfiyCaptchaDialogBinding2.cancelButton;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.cancelButton");
        ViewExtendsKt.setUtilClickListener(textView2, new CaptchaVerifyDialog$onActivityCreated$1(this));
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding3 = this.binding;
        if (submitVertfiyCaptchaDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = submitVertfiyCaptchaDialogBinding3.okButton;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.okButton");
        ViewExtendsKt.setUtilClickListener(textView3, new CaptchaVerifyDialog$onActivityCreated$2(this));
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding4 = this.binding;
        if (submitVertfiyCaptchaDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = submitVertfiyCaptchaDialogBinding4.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
        ViewExtendsKt.setUtilClickListener(imageView, new CaptchaVerifyDialog$onActivityCreated$3(this));
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding5 = this.binding;
        if (submitVertfiyCaptchaDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitVertfiyCaptchaDialogBinding5.editText.postDelayed(new CaptchaVerifyDialog$onActivityCreated$4(this), 100);
        requestLoadCaptcha();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (!this.isVerifying) {
            super.dismiss();
        }
    }

    public final void requestLoadCaptcha() {
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding = this.binding;
        if (submitVertfiyCaptchaDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = submitVertfiyCaptchaDialogBinding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
        loadCaptchaInto(imageView, NumberExtendsKt.getDp((Number) 96), NumberExtendsKt.getDp((Number) 40));
    }

    static /* synthetic */ void loadCaptchaInto$default(CaptchaVerifyDialog captchaVerifyDialog, ImageView imageView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 288;
        }
        if ((i3 & 4) != 0) {
            i2 = 120;
        }
        captchaVerifyDialog.loadCaptchaInto(imageView, i, i2);
    }

    /* JADX WARN: Type inference failed for: r10v6, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void loadCaptchaInto(ImageView imageView, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        DataConfig dataConfig = instance.getDataConfig();
        Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
        sb.append(dataConfig.getApiEndpoint());
        sb.append("account/captchaImage");
        Uri.Builder appendQueryParameter = Uri.parse(sb.toString()).buildUpon().appendQueryParameter("time", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        if (i > 0 && i2 > 0) {
            appendQueryParameter.appendQueryParameter("w", String.valueOf(i));
            appendQueryParameter.appendQueryParameter("h", String.valueOf(i2));
        }
        Uri build = appendQueryParameter.build();
        HashMap hashMap = new HashMap();
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        DataConfig dataConfig2 = instance2.getDataConfig();
        Intrinsics.checkNotNullExpressionValue(dataConfig2, "DataManager.getInstance().dataConfig");
        List<String> coolMarketHeaders = dataConfig2.getCoolMarketHeaders();
        int size = coolMarketHeaders.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 % 2 == 0) {
                int i4 = i3 + 1;
                Intrinsics.checkNotNullExpressionValue(coolMarketHeaders, "headersList");
                if (i4 <= CollectionsKt.getLastIndex(coolMarketHeaders)) {
                    hashMap.put(coolMarketHeaders.get(i3), coolMarketHeaders.get(i4));
                }
            }
        }
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        for (Map.Entry entry : hashMap.entrySet()) {
            builder.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        KotlinExtendKt.appendCoolApkCookies(builder);
        GlideApp.with(imageView).load((Object) new GlideUrl(build.toString(), builder.build())).into(imageView);
    }

    public final void requestVerify() {
        if (!this.isVerifying) {
            this.isVerifying = true;
            setLoadingState(true);
            SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding = this.binding;
            if (submitVertfiyCaptchaDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = submitVertfiyCaptchaDialogBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            String obj = editText.getText().toString();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            DataManager.getInstance().requestValidate("err_request_captcha", StringsKt.trim((CharSequence) obj).toString(), "", "", "").map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new CaptchaVerifyDialog$requestVerify$1(this)).subscribe((Subscriber<? super R>) new CaptchaVerifyDialog$requestVerify$2(this));
        }
    }

    public final void setErrorText(String str) {
        String str2 = str;
        if (str2.length() > 0) {
            SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding = this.binding;
            if (submitVertfiyCaptchaDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = submitVertfiyCaptchaDialogBinding.errorView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.errorView");
            textView.setText(str2);
            SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding2 = this.binding;
            if (submitVertfiyCaptchaDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = submitVertfiyCaptchaDialogBinding2.errorView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.errorView");
            textView2.setVisibility(0);
        }
    }

    public final void setLoadingState(boolean z) {
        if (z) {
            SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding = this.binding;
            if (submitVertfiyCaptchaDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar = submitVertfiyCaptchaDialogBinding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
            progressBar.setVisibility(0);
            SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding2 = this.binding;
            if (submitVertfiyCaptchaDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = submitVertfiyCaptchaDialogBinding2.okButton;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
            textView.setVisibility(4);
            SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding3 = this.binding;
            if (submitVertfiyCaptchaDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = submitVertfiyCaptchaDialogBinding3.errorView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.errorView");
            textView2.setVisibility(8);
            return;
        }
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding4 = this.binding;
        if (submitVertfiyCaptchaDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar2 = submitVertfiyCaptchaDialogBinding4.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.progressBar");
        progressBar2.setVisibility(8);
        SubmitVertfiyCaptchaDialogBinding submitVertfiyCaptchaDialogBinding5 = this.binding;
        if (submitVertfiyCaptchaDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = submitVertfiyCaptchaDialogBinding5.okButton;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.okButton");
        textView3.setVisibility(0);
    }
}
