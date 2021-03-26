package com.coolapk.market.view.node.app;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.SmallScrollCardViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "any", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppDetailListFragment.kt */
final class AppDetailListFragment$onActivityCreated$5 extends Lambda implements Function2<RecyclerView.ViewHolder, Object, Unit> {
    final /* synthetic */ AppDetailListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppDetailListFragment$onActivityCreated$5(AppDetailListFragment appDetailListFragment) {
        super(2);
        this.this$0 = appDetailListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        invoke(viewHolder, obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RecyclerView.ViewHolder viewHolder, final Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        FrameLayout frameLayout = ((ItemTitleViewBinding) ((SmallScrollCardViewHolder) viewHolder).getViewPart().getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "vh.viewPart.binding.moreView");
        ViewExtendsKt.setUtilClickListener(frameLayout, new Function1<View, Unit>(this) {
            /* class com.coolapk.market.view.node.app.AppDetailListFragment$onActivityCreated$5.AnonymousClass1 */
            final /* synthetic */ AppDetailListFragment$onActivityCreated$5 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke(view);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                Object obj = obj;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
                EntityCard entityCard = (EntityCard) obj;
                String entityId = ((EntityCard) obj).getEntityId();
                if (entityId != null) {
                    int hashCode = entityId.hashCode();
                    if (hashCode != 50) {
                        if (hashCode == 51 && entityId.equals("3")) {
                            ServiceApp serviceApp = this.this$0.this$0.getViewModel().getServiceApp();
                            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp");
                            ActionManager.startRelatedAlbumsActivity(this.this$0.this$0.getActivity(), serviceApp.getAppFullName());
                        }
                    } else if (entityId.equals("2")) {
                        ServiceApp serviceApp2 = this.this$0.this$0.getViewModel().getServiceApp();
                        Intrinsics.checkNotNullExpressionValue(serviceApp2, "viewModel.serviceApp");
                        ActionManager.startDeveloperAppsActivity(this.this$0.this$0.getActivity(), serviceApp2.getDeveloperName());
                    }
                }
            }
        });
    }
}
