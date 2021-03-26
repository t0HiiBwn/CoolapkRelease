package com.coolapk.market.view.cardlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$onRegisterCards$58 extends Lambda implements Function1<View, BindingViewHolder> {
    final /* synthetic */ ItemActionHandler $entityItemActionUtils;
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$onRegisterCards$58(EntityListFragment entityListFragment, ItemActionHandler itemActionHandler) {
        super(1);
        this.this$0 = entityListFragment;
        this.$entityItemActionUtils = itemActionHandler;
    }

    public final BindingViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new TitleRecycleViewCardViewHolder(view, this.this$0.getBindingComponent(), this.$entityItemActionUtils, new TitleRecycleViewCardViewHolder.Callback() {
            /* class com.coolapk.market.view.cardlist.EntityListFragment$onRegisterCards$58.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                titleRecycleViewCardViewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext()));
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(obj, "data");
                super.onBindTo(titleRecycleViewCardViewHolder, obj);
                EntityCard entityCard = (EntityCard) obj;
                ViewExtendsKt.removeAllItemDecorations(titleRecycleViewCardViewHolder.getRecyclerView());
                RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null) {
                    List<Entity> entities = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities);
                    linearLayoutManager.setInitialPrefetchItemCount(entities.size());
                }
                RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
                recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), NumberExtendsKt.getDp((Number) 8));
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                return new ServiceAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558924, viewGroup, false), titleRecycleViewCardViewHolder.getComponent(), titleRecycleViewCardViewHolder.getItemActionHandler());
            }
        });
    }
}
