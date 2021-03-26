package com.coolapk.market.view.node.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RatingBar;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.DialogAppRatingBinding;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.widget.MinimumWidthDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/node/app/AppRatingDialog;", "Lcom/coolapk/market/widget/MinimumWidthDialog;", "()V", "presenter", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "getPresenter", "()Lcom/coolapk/market/view/node/app/AppNodePresenter;", "setPresenter", "(Lcom/coolapk/market/view/node/app/AppNodePresenter;)V", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "getViewModel", "()Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "setViewModel", "(Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppRatingDialog.kt */
public final class AppRatingDialog extends MinimumWidthDialog {
    public static final Companion Companion = new Companion(null);
    public AppNodePresenter presenter;
    public AppNodeViewModel viewModel;

    public final AppNodeViewModel getViewModel() {
        AppNodeViewModel appNodeViewModel = this.viewModel;
        if (appNodeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return appNodeViewModel;
    }

    public final void setViewModel(AppNodeViewModel appNodeViewModel) {
        Intrinsics.checkNotNullParameter(appNodeViewModel, "<set-?>");
        this.viewModel = appNodeViewModel;
    }

    public final AppNodePresenter getPresenter() {
        AppNodePresenter appNodePresenter = this.presenter;
        if (appNodePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return appNodePresenter;
    }

    public final void setPresenter(AppNodePresenter appNodePresenter) {
        Intrinsics.checkNotNullParameter(appNodePresenter, "<set-?>");
        this.presenter = appNodePresenter;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        DialogAppRatingBinding dialogAppRatingBinding = (DialogAppRatingBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558519, null, false);
        Intrinsics.checkNotNullExpressionValue(dialogAppRatingBinding, "binding");
        AppNodeViewModel appNodeViewModel = this.viewModel;
        if (appNodeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        dialogAppRatingBinding.setViewModel(appNodeViewModel);
        ThemeUtils.setRatingBarColor(dialogAppRatingBinding.ratingBar);
        RatingBar ratingBar = dialogAppRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setOnRatingBarChangeListener(new AppRatingDialog$onCreateDialog$1(this));
        AlertDialog create = new AlertDialog.Builder(getActivity()).setView(dialogAppRatingBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        return create;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/app/AppRatingDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/node/app/AppRatingDialog;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppRatingDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppRatingDialog newInstance() {
            Bundle bundle = new Bundle();
            AppRatingDialog appRatingDialog = new AppRatingDialog();
            appRatingDialog.setArguments(bundle);
            return appRatingDialog;
        }
    }
}
