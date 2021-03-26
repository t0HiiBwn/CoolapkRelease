package com.coolapk.market.view.node;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.coolapk.market.view.node.app.AppNodePresenter;
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.widget.view.FabVerticalMenuLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/node/NodeHelper;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
final class NodeHelper$showAppFabView$4 extends Lambda implements Function1<NodeHelper, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ FabVerticalMenuLayout $layout;
    final /* synthetic */ AppNodePresenter $presenter;
    final /* synthetic */ Resources $resources;
    final /* synthetic */ AppNodeViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeHelper$showAppFabView$4(FabVerticalMenuLayout fabVerticalMenuLayout, Resources resources, AppNodePresenter appNodePresenter, AppNodeViewModel appNodeViewModel, Activity activity) {
        super(1);
        this.$layout = fabVerticalMenuLayout;
        this.$resources = resources;
        this.$presenter = appNodePresenter;
        this.$viewModel = appNodeViewModel;
        this.$activity = activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NodeHelper nodeHelper) {
        invoke(nodeHelper);
        return Unit.INSTANCE;
    }

    public final void invoke(NodeHelper nodeHelper) {
        Intrinsics.checkNotNullParameter(nodeHelper, "it");
        this.$layout.addSubFabInfo(2131689490, Integer.valueOf(this.$resources.getColor(2131099878)), "点评", new View.OnClickListener(this) {
            /* class com.coolapk.market.view.node.NodeHelper$showAppFabView$4.AnonymousClass1 */
            final /* synthetic */ NodeHelper$showAppFabView$4 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppNodePresenter.ratingAppV10$default(this.this$0.$presenter, this.this$0.$viewModel, this.this$0.$activity, 0, false, 12, null);
            }
        });
    }
}
