package com.coolapk.market.view.node.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.AppNodeToolbarContentBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.widget.ActionButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeToolbar;", "", "()V", "binding", "Lcom/coolapk/market/databinding/AppNodeToolbarContentBinding;", "init", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "presenter", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "data", "Lcom/coolapk/market/model/ServiceApp;", "updateContent", "", "updateWithAppMode", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
public final class AppNodeToolbar {
    private AppNodeToolbarContentBinding binding;

    public static final /* synthetic */ AppNodeToolbarContentBinding access$getBinding$p(AppNodeToolbar appNodeToolbar) {
        AppNodeToolbarContentBinding appNodeToolbarContentBinding = appNodeToolbar.binding;
        if (appNodeToolbarContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return appNodeToolbarContentBinding;
    }

    public final View init(Activity activity, AppNodeViewModel appNodeViewModel, AppNodePresenter appNodePresenter, ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(appNodePresenter, "presenter");
        Intrinsics.checkNotNullParameter(serviceApp, "data");
        Activity activity2 = activity;
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(activity2), 2131558465, null, false, new ContextBindingComponent(activity2));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        AppNodeToolbarContentBinding appNodeToolbarContentBinding = (AppNodeToolbarContentBinding) inflate;
        this.binding = appNodeToolbarContentBinding;
        if (appNodeToolbarContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appNodeToolbarContentBinding.setModel(appNodeViewModel);
        AppNodeToolbarContentBinding appNodeToolbarContentBinding2 = this.binding;
        if (appNodeToolbarContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = appNodeToolbarContentBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 60);
        layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 60);
        Unit unit = Unit.INSTANCE;
        root.setLayoutParams(layoutParams);
        AppNodeToolbarContentBinding appNodeToolbarContentBinding3 = this.binding;
        if (appNodeToolbarContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ActionButton.bindWithApp$default(appNodeToolbarContentBinding3.actionButton, serviceApp, false, 2, null);
        AppNodeToolbarContentBinding appNodeToolbarContentBinding4 = this.binding;
        if (appNodeToolbarContentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appNodeToolbarContentBinding4.actionButton.setOnClickListener(new AppNodeToolbar$init$2(appNodeViewModel));
        AppNodeToolbarContentBinding appNodeToolbarContentBinding5 = this.binding;
        if (appNodeToolbarContentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appNodeToolbarContentBinding5.followActionView.setOnClickListener(new AppNodeToolbar$init$3(appNodeViewModel, appNodePresenter));
        AppNodeToolbarContentBinding appNodeToolbarContentBinding6 = this.binding;
        if (appNodeToolbarContentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RatingBar ratingBar = appNodeToolbarContentBinding6.ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(appNodeViewModel.getAppScore().get()));
        AppNodeToolbarContentBinding appNodeToolbarContentBinding7 = this.binding;
        if (appNodeToolbarContentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = appNodeToolbarContentBinding7.toolbarLogoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.toolbarLogoView");
        ViewExtendsKt.darkForegroundIfNeed(imageView);
        updateWithAppMode(appNodeViewModel);
        AppNodeToolbarContentBinding appNodeToolbarContentBinding8 = this.binding;
        if (appNodeToolbarContentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root2 = appNodeToolbarContentBinding8.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        return root2;
    }

    public final void updateContent(AppNodeViewModel appNodeViewModel) {
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        AppNodeToolbarContentBinding appNodeToolbarContentBinding = this.binding;
        if (appNodeToolbarContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appNodeToolbarContentBinding.setModel(appNodeViewModel);
        AppNodeToolbarContentBinding appNodeToolbarContentBinding2 = this.binding;
        if (appNodeToolbarContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appNodeToolbarContentBinding2.executePendingBindings();
        updateWithAppMode(appNodeViewModel);
    }

    private final void updateWithAppMode(AppNodeViewModel appNodeViewModel) {
        AppMetadataKt.runOnAppMode$default(this, null, new AppNodeToolbar$updateWithAppMode$1(this), null, new AppNodeToolbar$updateWithAppMode$2(this, appNodeViewModel), 5, null);
    }
}
