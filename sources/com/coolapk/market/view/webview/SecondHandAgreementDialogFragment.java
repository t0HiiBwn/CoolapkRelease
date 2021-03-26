package com.coolapk.market.view.webview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.DialogSecondHandAgreementBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\u001b\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/webview/SecondHandAgreementDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/DialogSecondHandAgreementBinding;", "cacelListener", "Lrx/functions/Action1;", "", "listener", "subscription", "Lrx/Subscription;", "timer", "Landroid/os/CountDownTimer;", "onClick", "", "v", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "setCacelListener", "setListener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandAgreementDialogFragment.kt */
public final class SecondHandAgreementDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private DialogSecondHandAgreementBinding binding;
    private Action1<Integer> cacelListener;
    private Action1<Integer> listener;
    private Subscription subscription;
    private CountDownTimer timer;

    public static final /* synthetic */ DialogSecondHandAgreementBinding access$getBinding$p(SecondHandAgreementDialogFragment secondHandAgreementDialogFragment) {
        DialogSecondHandAgreementBinding dialogSecondHandAgreementBinding = secondHandAgreementDialogFragment.binding;
        if (dialogSecondHandAgreementBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return dialogSecondHandAgreementBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/webview/SecondHandAgreementDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/webview/SecondHandAgreementDialogFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandAgreementDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SecondHandAgreementDialogFragment newInstance() {
            return new SecondHandAgreementDialogFragment();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558532, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…d_agreement, null, false)");
        DialogSecondHandAgreementBinding dialogSecondHandAgreementBinding = (DialogSecondHandAgreementBinding) inflate;
        this.binding = dialogSecondHandAgreementBinding;
        if (dialogSecondHandAgreementBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SecondHandAgreementDialogFragment secondHandAgreementDialogFragment = this;
        dialogSecondHandAgreementBinding.cacelView.setOnClickListener(secondHandAgreementDialogFragment);
        DialogSecondHandAgreementBinding dialogSecondHandAgreementBinding2 = this.binding;
        if (dialogSecondHandAgreementBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandAgreementBinding2.submitView.setOnClickListener(secondHandAgreementDialogFragment);
        DialogSecondHandAgreementBinding dialogSecondHandAgreementBinding3 = this.binding;
        if (dialogSecondHandAgreementBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandAgreementBinding3.setLoading(false);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        this.subscription = instance.getAgreementDetail().compose(RxUtils.apiCommonToData()).subscribe(new SecondHandAgreementDialogFragment$onCreateDialog$1(this), new SecondHandAgreementDialogFragment$onCreateDialog$2(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        DialogSecondHandAgreementBinding dialogSecondHandAgreementBinding4 = this.binding;
        if (dialogSecondHandAgreementBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = builder.setView(dialogSecondHandAgreementBinding4.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "androidx.appcompat.app.A…                .create()");
        SecondHandAgreementDialogFragment$onCreateDialog$3 secondHandAgreementDialogFragment$onCreateDialog$3 = new SecondHandAgreementDialogFragment$onCreateDialog$3(this, 10500, 1000);
        this.timer = secondHandAgreementDialogFragment$onCreateDialog$3;
        Intrinsics.checkNotNull(secondHandAgreementDialogFragment$onCreateDialog$3);
        secondHandAgreementDialogFragment$onCreateDialog$3.start();
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            Intrinsics.checkNotNull(countDownTimer);
            countDownTimer.cancel();
        }
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            this.subscription = null;
        }
    }

    public final void setListener(Action1<Integer> action1) {
        Intrinsics.checkNotNullParameter(action1, "listener");
        this.listener = action1;
    }

    public final void setCacelListener(Action1<Integer> action1) {
        Intrinsics.checkNotNullParameter(action1, "cacelListener");
        this.cacelListener = action1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            Intrinsics.checkNotNull(countDownTimer);
            countDownTimer.cancel();
        }
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            this.subscription = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == 2131362193) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
            Action1<Integer> action1 = this.cacelListener;
            if (action1 != null && action1 != null) {
                action1.call(0);
            }
        } else if (id == 2131363457 && this.listener != null) {
            DialogSecondHandAgreementBinding dialogSecondHandAgreementBinding = this.binding;
            if (dialogSecondHandAgreementBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogSecondHandAgreementBinding.setLoading(true);
            DataManager.getInstance().agreement().compose(RxUtils.apiCommonToData()).subscribe(new SecondHandAgreementDialogFragment$onClick$1(this), new SecondHandAgreementDialogFragment$onClick$2(this));
        }
    }
}
