package com.coolapk.market.view.feedv8;

import android.app.Dialog;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.SubmitVerifyMobileCodeDialogBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/feedv8/MobileCodeVerifyDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/SubmitVerifyMobileCodeDialogBinding;", "callback", "Lkotlin/Function0;", "", "countDownTimer", "Landroid/os/CountDownTimer;", "hadSendSms", "", "isVerifying", "mobileNumber", "", "dismiss", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "requestMobileCode", "requestVerify", "setErrorText", "message", "setLoadingState", "loading", "setRequestMobileCodeEnable", "enable", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageStatusHelper.kt */
public final class MobileCodeVerifyDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private SubmitVerifyMobileCodeDialogBinding binding;
    private Function0<Unit> callback;
    private CountDownTimer countDownTimer;
    private boolean hadSendSms;
    private boolean isVerifying;
    private String mobileNumber = "";

    public static final /* synthetic */ SubmitVerifyMobileCodeDialogBinding access$getBinding$p(MobileCodeVerifyDialog mobileCodeVerifyDialog) {
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding = mobileCodeVerifyDialog.binding;
        if (submitVerifyMobileCodeDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return submitVerifyMobileCodeDialogBinding;
    }

    public static final /* synthetic */ void access$requestMobileCode(MobileCodeVerifyDialog mobileCodeVerifyDialog) {
        mobileCodeVerifyDialog.requestMobileCode();
    }

    public static final /* synthetic */ void access$requestVerify(MobileCodeVerifyDialog mobileCodeVerifyDialog) {
        mobileCodeVerifyDialog.requestVerify();
    }

    public static final /* synthetic */ void access$setErrorText(MobileCodeVerifyDialog mobileCodeVerifyDialog, String str) {
        mobileCodeVerifyDialog.setErrorText(str);
    }

    public static final /* synthetic */ void access$setHadSendSms$p(MobileCodeVerifyDialog mobileCodeVerifyDialog, boolean z) {
        mobileCodeVerifyDialog.hadSendSms = z;
    }

    public static final /* synthetic */ void access$setLoadingState(MobileCodeVerifyDialog mobileCodeVerifyDialog, boolean z) {
        mobileCodeVerifyDialog.setLoadingState(z);
    }

    public static final /* synthetic */ void access$setRequestMobileCodeEnable(MobileCodeVerifyDialog mobileCodeVerifyDialog, boolean z) {
        mobileCodeVerifyDialog.setRequestMobileCodeEnable(z);
    }

    public static final /* synthetic */ void access$setVerifying$p(MobileCodeVerifyDialog mobileCodeVerifyDialog, boolean z) {
        mobileCodeVerifyDialog.isVerifying = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feedv8/MobileCodeVerifyDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feedv8/MobileCodeVerifyDialog;", "message", "", "messageExtra", "verifySucceedCallback", "Lkotlin/Function0;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MessageStatusHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MobileCodeVerifyDialog newInstance(String str, String str2, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "message");
            MobileCodeVerifyDialog mobileCodeVerifyDialog = new MobileCodeVerifyDialog();
            Bundle bundle = new Bundle();
            bundle.putString("message", str);
            bundle.putString("messageExtra", str2);
            Unit unit = Unit.INSTANCE;
            mobileCodeVerifyDialog.setArguments(bundle);
            mobileCodeVerifyDialog.callback = function0;
            return mobileCodeVerifyDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559179, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…code_dialog, null, false)");
        this.binding = (SubmitVerifyMobileCodeDialogBinding) inflate;
        AlertDialog.Builder title = new AlertDialog.Builder(requireActivity()).setTitle("手机验证码");
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding = this.binding;
        if (submitVerifyMobileCodeDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = title.setView(submitVerifyMobileCodeDialogBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        JSONObject jSONObject;
        super.onActivityCreated(bundle);
        String string = requireArguments().getString("messageExtra");
        String str = "";
        if (string == null) {
            string = str;
        }
        try {
            jSONObject = new JSONObject(string);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("mobile");
        if (optString != null) {
            str = optString;
        }
        this.mobileNumber = str;
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding = this.binding;
        if (submitVerifyMobileCodeDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = submitVerifyMobileCodeDialogBinding.numView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.numView");
        textView.setText("您绑定的手机号: " + this.mobileNumber);
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding2 = this.binding;
        if (submitVerifyMobileCodeDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = submitVerifyMobileCodeDialogBinding2.textView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
        textView2.setText(requireArguments().getString("message"));
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding3 = this.binding;
        if (submitVerifyMobileCodeDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = submitVerifyMobileCodeDialogBinding3.cancelButton;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.cancelButton");
        ViewExtendsKt.setUtilClickListener(textView3, new MobileCodeVerifyDialog$onActivityCreated$1(this));
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding4 = this.binding;
        if (submitVerifyMobileCodeDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView4 = submitVerifyMobileCodeDialogBinding4.okButton;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.okButton");
        ViewExtendsKt.setUtilClickListener(textView4, new MobileCodeVerifyDialog$onActivityCreated$2(this));
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding5 = this.binding;
        if (submitVerifyMobileCodeDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView5 = submitVerifyMobileCodeDialogBinding5.actionView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.actionView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(NumberExtendsKt.getDp(Double.valueOf(0.5d)), AppHolder.getAppTheme().getCurrencyColorDivider());
        gradientDrawable.setShape(0);
        float dp = (float) NumberExtendsKt.getDp((Number) 4);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, dp, dp, dp, dp, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        textView5.setBackground(gradientDrawable);
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding6 = this.binding;
        if (submitVerifyMobileCodeDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView6 = submitVerifyMobileCodeDialogBinding6.actionView;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.actionView");
        ViewExtendsKt.setUtilClickListener(textView6, new MobileCodeVerifyDialog$onActivityCreated$4(this));
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding7 = this.binding;
        if (submitVerifyMobileCodeDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitVerifyMobileCodeDialogBinding7.editText.postDelayed(new MobileCodeVerifyDialog$onActivityCreated$5(this), 100);
        setRequestMobileCodeEnable(true);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (!this.isVerifying) {
            super.dismiss();
        }
    }

    private final void setRequestMobileCodeEnable(boolean z) {
        if (z) {
            CountDownTimer countDownTimer2 = this.countDownTimer;
            if (countDownTimer2 != null) {
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                }
                this.countDownTimer = null;
            }
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding = this.binding;
            if (submitVerifyMobileCodeDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = submitVerifyMobileCodeDialogBinding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
            textView.setText(getString(2131887023));
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding2 = this.binding;
            if (submitVerifyMobileCodeDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitVerifyMobileCodeDialogBinding2.actionView.setTextColor(AppHolder.getAppTheme().getColorAccent());
        } else if (this.countDownTimer == null) {
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding3 = this.binding;
            if (submitVerifyMobileCodeDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitVerifyMobileCodeDialogBinding3.actionView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            MobileCodeVerifyDialog$setRequestMobileCodeEnable$1 mobileCodeVerifyDialog$setRequestMobileCodeEnable$1 = new MobileCodeVerifyDialog$setRequestMobileCodeEnable$1(this, 60000, 1000);
            this.countDownTimer = mobileCodeVerifyDialog$setRequestMobileCodeEnable$1;
            if (mobileCodeVerifyDialog$setRequestMobileCodeEnable$1 != null) {
                mobileCodeVerifyDialog$setRequestMobileCodeEnable$1.start();
            }
        }
    }

    private final void requestMobileCode() {
        if (!this.isVerifying) {
            setRequestMobileCodeEnable(false);
            this.isVerifying = true;
            DataManager.getInstance().sendValidateCode("err_request_mobile", this.mobileNumber, "", "").map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new MobileCodeVerifyDialog$requestMobileCode$2(this)).subscribe((Subscriber<? super R>) new MobileCodeVerifyDialog$requestMobileCode$3(this));
        }
    }

    private final void requestVerify() {
        if (!this.isVerifying) {
            if (!this.hadSendSms) {
                Toast.show$default(getActivity(), "请先获取验证码", 0, false, 12, null);
                return;
            }
            this.isVerifying = true;
            setLoadingState(true);
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding = this.binding;
            if (submitVerifyMobileCodeDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = submitVerifyMobileCodeDialogBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            String obj = editText.getText().toString();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            DataManager.getInstance().requestValidate("err_request_mobile", StringsKt.trim((CharSequence) obj).toString(), this.mobileNumber, "", "").map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new MobileCodeVerifyDialog$requestVerify$1(this)).subscribe((Subscriber<? super R>) new MobileCodeVerifyDialog$requestVerify$2(this));
        }
    }

    private final void setErrorText(String str) {
        String str2 = str;
        if (str2.length() > 0) {
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding = this.binding;
            if (submitVerifyMobileCodeDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = submitVerifyMobileCodeDialogBinding.errorView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.errorView");
            textView.setText(str2);
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding2 = this.binding;
            if (submitVerifyMobileCodeDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = submitVerifyMobileCodeDialogBinding2.errorView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.errorView");
            textView2.setVisibility(0);
        }
    }

    private final void setLoadingState(boolean z) {
        if (z) {
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding = this.binding;
            if (submitVerifyMobileCodeDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar = submitVerifyMobileCodeDialogBinding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
            progressBar.setVisibility(0);
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding2 = this.binding;
            if (submitVerifyMobileCodeDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = submitVerifyMobileCodeDialogBinding2.okButton;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
            textView.setVisibility(4);
            SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding3 = this.binding;
            if (submitVerifyMobileCodeDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = submitVerifyMobileCodeDialogBinding3.errorView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.errorView");
            textView2.setVisibility(8);
            return;
        }
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding4 = this.binding;
        if (submitVerifyMobileCodeDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar2 = submitVerifyMobileCodeDialogBinding4.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.progressBar");
        progressBar2.setVisibility(8);
        SubmitVerifyMobileCodeDialogBinding submitVerifyMobileCodeDialogBinding5 = this.binding;
        if (submitVerifyMobileCodeDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = submitVerifyMobileCodeDialogBinding5.okButton;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.okButton");
        textView3.setVisibility(0);
    }
}
