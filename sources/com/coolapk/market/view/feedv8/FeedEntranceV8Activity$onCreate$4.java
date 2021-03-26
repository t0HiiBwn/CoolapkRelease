package com.coolapk.market.view.feedv8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.FeedEntranceItemsBinding;
import com.coolapk.market.view.feedv8.FeedEntranceV8Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001c\u0010\n\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"com/coolapk/market/view/feedv8/FeedEntranceV8Activity$onCreate$4", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceViewHolder;", "Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
public final class FeedEntranceV8Activity$onCreate$4 extends RecyclerView.Adapter<FeedEntranceV8Activity.EntranceViewHolder> {
    final /* synthetic */ List $entranceItems;
    final /* synthetic */ FeedEntranceV8Activity this$0;

    FeedEntranceV8Activity$onCreate$4(FeedEntranceV8Activity feedEntranceV8Activity, List list) {
        this.this$0 = feedEntranceV8Activity;
        this.$entranceItems = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FeedEntranceV8Activity.EntranceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        FeedEntranceItemsBinding feedEntranceItemsBinding = (FeedEntranceItemsBinding) DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getActivity()), 2131558557, viewGroup, false);
        FeedEntranceV8Activity feedEntranceV8Activity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(feedEntranceItemsBinding, "binding");
        View root = feedEntranceItemsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new FeedEntranceV8Activity.EntranceViewHolder(feedEntranceV8Activity, root);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.$entranceItems.size();
    }

    public void onBindViewHolder(FeedEntranceV8Activity.EntranceViewHolder entranceViewHolder, int i) {
        Intrinsics.checkNotNullParameter(entranceViewHolder, "holder");
        entranceViewHolder.bindTo(this.$entranceItems.get(i));
    }
}
