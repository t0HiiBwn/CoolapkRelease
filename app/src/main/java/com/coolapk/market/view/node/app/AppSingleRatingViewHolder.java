package com.coolapk.market.view.node.app;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.node.util.BaseSingleRatingViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/node/app/AppSingleRatingViewHolder;", "Lcom/coolapk/market/view/node/util/BaseSingleRatingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "presenter", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/node/app/AppNodeViewModel;Lcom/coolapk/market/view/node/app/AppNodePresenter;)V", "getRatingFeedUrl", "", "getStarCount", "", "onRequestRatingFeed", "", "rating", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppSingleRatingViewHolder.kt */
public final class AppSingleRatingViewHolder extends BaseSingleRatingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558934;
    private final AppNodePresenter presenter;
    private final AppNodeViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppSingleRatingViewHolder(View view, DataBindingComponent dataBindingComponent, AppNodeViewModel appNodeViewModel, AppNodePresenter appNodePresenter) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(appNodePresenter, "presenter");
        this.viewModel = appNodeViewModel;
        this.presenter = appNodePresenter;
        appNodeViewModel.getMyScore().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback(this) {
            /* class com.coolapk.market.view.node.app.AppSingleRatingViewHolder.AnonymousClass1 */
            final /* synthetic */ AppSingleRatingViewHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                this.this$0.requestStarCountChanged();
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/app/AppSingleRatingViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppSingleRatingViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.node.util.BaseSingleRatingViewHolder
    public int getStarCount() {
        return this.viewModel.getMyScore().get();
    }

    @Override // com.coolapk.market.view.node.util.BaseSingleRatingViewHolder
    public String getRatingFeedUrl() {
        String str = this.viewModel.getRatingFeedUrl().get();
        return str != null ? str : "";
    }

    @Override // com.coolapk.market.view.node.util.BaseSingleRatingViewHolder
    public void onRequestRatingFeed(int i) {
        AppNodePresenter appNodePresenter = this.presenter;
        AppNodeViewModel appNodeViewModel = this.viewModel;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        Intrinsics.checkNotNull(activityNullable);
        appNodePresenter.ratingAppV10(appNodeViewModel, activityNullable, i, true);
    }
}
