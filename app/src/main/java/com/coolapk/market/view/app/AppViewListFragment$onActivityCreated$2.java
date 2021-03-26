package com.coolapk.market.view.app;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewListFragment.kt */
final class AppViewListFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ FragmentBindingComponent $component;
    final /* synthetic */ AppViewListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppViewListFragment$onActivityCreated$2(AppViewListFragment appViewListFragment, FragmentBindingComponent fragmentBindingComponent) {
        super(1);
        this.this$0 = appViewListFragment;
        this.$component = fragmentBindingComponent;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new AppViewBaseInfoViewHolder(view, this.$component, AppViewListFragment.access$getViewModel$p(this.this$0), AppViewListFragment.access$getPresenter$p(this.this$0));
    }
}
