package com.coolapk.market.view.cardlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Goods;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleVH;
import com.coolapk.market.view.goods.GoodsViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.SimpleEntityViewHolder;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.viewholder.v8.FeedNewsViewHolder;
import com.coolapk.market.viewholder.v8.FeedViewHolderV8;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$onRegisterCards$56 extends Lambda implements Function1<View, BindingViewHolder> {
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$onRegisterCards$56(EntityListFragment entityListFragment) {
        super(1);
        this.this$0 = entityListFragment;
    }

    public final BindingViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new TitleRecycleViewCardViewHolder(view, this.this$0.getBindingComponent(), null, new TitleRecycleViewCardViewHolder.Callback(this) {
            /* class com.coolapk.market.view.cardlist.EntityListFragment$onRegisterCards$56.AnonymousClass1 */
            final /* synthetic */ EntityListFragment$onRegisterCards$56 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

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
                RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
                ViewExtendsKt.removeAllItemDecorations(recyclerView);
                recyclerView.addItemDecoration(new PaddingDividerItemDecoration(new EntityListFragment$onRegisterCards$56$1$onBindTo$$inlined$apply$lambda$1(this.this$0.this$0.getActivity(), this, entityCard)));
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null) {
                    List<Entity> entities = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities);
                    linearLayoutManager.setInitialPrefetchItemCount(entities.size());
                }
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
                switch (i) {
                    case 2131558678:
                        Intrinsics.checkNotNullExpressionValue(inflate, "view");
                        DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
                        Intrinsics.checkNotNullExpressionValue(component, "holder.component");
                        return new DyhArticleVH(inflate, component, titleRecycleViewCardViewHolder.getItemActionHandler());
                    case 2131558708:
                        Intrinsics.checkNotNullExpressionValue(inflate, "view");
                        DataBindingComponent component2 = titleRecycleViewCardViewHolder.getComponent();
                        Intrinsics.checkNotNullExpressionValue(component2, "holder.component");
                        return new FeedViewHolderV8(inflate, component2, titleRecycleViewCardViewHolder.getItemActionHandler());
                    case 2131558710:
                        Intrinsics.checkNotNullExpressionValue(inflate, "view");
                        DataBindingComponent component3 = titleRecycleViewCardViewHolder.getComponent();
                        Intrinsics.checkNotNullExpressionValue(component3, "holder.component");
                        return new FeedNewsViewHolder(inflate, component3, titleRecycleViewCardViewHolder.getItemActionHandler());
                    case 2131558755:
                        Intrinsics.checkNotNullExpressionValue(inflate, "view");
                        DataBindingComponent component4 = titleRecycleViewCardViewHolder.getComponent();
                        Intrinsics.checkNotNullExpressionValue(component4, "holder.component");
                        return new GoodsViewHolder(inflate, component4, titleRecycleViewCardViewHolder.getItemActionHandler());
                    default:
                        Intrinsics.checkNotNullExpressionValue(inflate, "view");
                        DataBindingComponent component5 = titleRecycleViewCardViewHolder.getComponent();
                        Intrinsics.checkNotNullExpressionValue(component5, "holder.component");
                        return new SimpleEntityViewHolder(inflate, component5);
                }
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public int getItemViewType(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                if (obj instanceof DyhArticle) {
                    return 2131558678;
                }
                return obj instanceof Feed ? EntityExtendsKt.isArticleNews((Feed) obj) ? 2131558710 : 2131558708 : obj instanceof Goods ? 2131558755 : 2131558929;
            }
        });
    }
}
