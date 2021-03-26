package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.model.Goods;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.widget.decoration.ItemDecorations;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/LargeScrollCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LargeScrollCardViewHolder.kt */
public final class LargeScrollCardViewHolder extends TitleRecycleViewCardViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LargeScrollCardViewHolder(View view, DataBindingComponent dataBindingComponent, final EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, null, new TitleRecycleViewCardViewHolder.Callback() {
            /* class com.coolapk.market.viewholder.LargeScrollCardViewHolder.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                titleRecycleViewCardViewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 0, false));
                titleRecycleViewCardViewHolder.getRecyclerView().setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), ConvertUtils.dp2px(8.0f), ViewMarginData.Companion.getDEFAULT_SIZE(), ConvertUtils.dp2px(12.0f));
                titleRecycleViewCardViewHolder.getRecyclerView().setClipToPadding(false);
                titleRecycleViewCardViewHolder.getRecyclerView().setClipChildren(false);
                titleRecycleViewCardViewHolder.getRecyclerView().addItemDecoration(ItemDecorations.horizontal(titleRecycleViewCardViewHolder.getContext()).type(2131558796, 2131231064).type(2131558795, 2131231064).create());
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
                if (i != 2131558795) {
                    Intrinsics.checkNotNullExpressionValue(inflate, "view");
                    DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
                    Intrinsics.checkNotNullExpressionValue(component, "holder.component");
                    return new LargeScrollCardViewHolder$1$onCreateViewHolder$2(this, titleRecycleViewCardViewHolder, inflate, inflate, component, entityListPresenter);
                }
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                DataBindingComponent component2 = titleRecycleViewCardViewHolder.getComponent();
                Intrinsics.checkNotNullExpressionValue(component2, "holder.component");
                return new LargeScrollCardViewHolder$1$onCreateViewHolder$1(this, titleRecycleViewCardViewHolder, inflate, inflate, component2, entityListPresenter);
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(obj, "data");
                super.onBindTo(titleRecycleViewCardViewHolder, obj);
                RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null) {
                    linearLayoutManager.setInitialPrefetchItemCount(4);
                }
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public int getItemViewType(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj instanceof Goods ? 2131558795 : 2131558796;
            }
        });
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
    }
}
