package com.coolapk.market.view.center;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"com/coolapk/market/view/center/MeUserMenuViewHolder$bindToContent$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/center/MeUserMenuChildViewHolder;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeUserMenuViewHolder.kt */
public final class MeUserMenuViewHolder$bindToContent$1 extends RecyclerView.Adapter<MeUserMenuChildViewHolder> {
    final /* synthetic */ MeUserMenuViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MeUserMenuViewHolder$bindToContent$1(MeUserMenuViewHolder meUserMenuViewHolder) {
        this.this$0 = meUserMenuViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MeUserMenuChildViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.this$0.getContext()).inflate(2131558640, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DataBindingComponent component = this.this$0.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "component");
        return new MeUserMenuChildViewHolder(inflate, component, this.this$0.getPresenter().getMenuPresenter());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.this$0.dataList.size();
    }

    public void onBindViewHolder(MeUserMenuChildViewHolder meUserMenuChildViewHolder, int i) {
        Intrinsics.checkNotNullParameter(meUserMenuChildViewHolder, "holder");
        meUserMenuChildViewHolder.bindTo(this.this$0.dataList.get(i));
    }
}
