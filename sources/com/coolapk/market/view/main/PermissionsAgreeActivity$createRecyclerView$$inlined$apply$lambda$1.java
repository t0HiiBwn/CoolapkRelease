package com.coolapk.market.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.view.main.PermissionsAgreeActivity;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.PermissionsItemViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/main/PermissionsAgreeActivity$createRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PermissionsAgreeActivity.kt */
public final class PermissionsAgreeActivity$createRecyclerView$$inlined$apply$lambda$1 extends RecyclerView.Adapter<BindingViewHolder> {
    final /* synthetic */ PermissionsAgreeActivity this$0;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 2131558856;
    }

    PermissionsAgreeActivity$createRecyclerView$$inlined$apply$lambda$1(PermissionsAgreeActivity permissionsAgreeActivity) {
        this.this$0 = permissionsAgreeActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.this$0.getActivity()).inflate(i, viewGroup, false);
        List list = this.this$0.keyList;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new PermissionsItemViewHolder(list, inflate, new ContextBindingComponent(this.this$0.getActivity()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.this$0.dataList.size();
    }

    public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
        Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
        bindingViewHolder.bindTo((PermissionsAgreeActivity.PermissionsItem) this.this$0.dataList.get(i));
    }
}
