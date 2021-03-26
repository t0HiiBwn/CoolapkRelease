package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemFeedStackItemBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.widget.stackcard.StackCardLayoutManager;
import com.coolapk.market.widget.stackcard.StackCardTouchHelperCallback;
import com.coolapk.market.widget.stackcard.StackFrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Y\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"com/coolapk/market/viewholder/FeedStackCardViewHolder$Companion$createCallback$1", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "Lcom/coolapk/market/widget/stackcard/StackCardTouchHelperCallback$Callback;", "card", "Lcom/coolapk/market/model/EntityCard;", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemViewType", "", "obj", "", "onBindTo", "", "data", "onChildBindTo", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onInit", "onSlided", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "direction", "onSliding", "ratio", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedStackCardViewHolder.kt */
public final class FeedStackCardViewHolder$Companion$createCallback$1 extends TitleRecycleViewCardViewHolder.Callback implements StackCardTouchHelperCallback.Callback {
    final /* synthetic */ Function1 $removeAction;
    private EntityCard card;
    private TitleRecycleViewCardViewHolder holder;
    private ItemTouchHelper itemTouchHelper;
    private RecyclerView recyclerView;

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public int getItemViewType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return 0;
    }

    @Override // com.coolapk.market.widget.stackcard.StackCardTouchHelperCallback.Callback
    public void onSliding(RecyclerView.ViewHolder viewHolder, float f, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    FeedStackCardViewHolder$Companion$createCallback$1(Function1 function1) {
        this.$removeAction = function1;
    }

    public static final /* synthetic */ EntityCard access$getCard$p(FeedStackCardViewHolder$Companion$createCallback$1 feedStackCardViewHolder$Companion$createCallback$1) {
        EntityCard entityCard = feedStackCardViewHolder$Companion$createCallback$1.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    public static final /* synthetic */ ItemTouchHelper access$getItemTouchHelper$p(FeedStackCardViewHolder$Companion$createCallback$1 feedStackCardViewHolder$Companion$createCallback$1) {
        ItemTouchHelper itemTouchHelper2 = feedStackCardViewHolder$Companion$createCallback$1.itemTouchHelper;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        return itemTouchHelper2;
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        RecyclerView recyclerView2 = titleRecycleViewCardViewHolder.getRecyclerView();
        recyclerView2.setClipToPadding(false);
        recyclerView2.setClipChildren(false);
        recyclerView2.setClipToPadding(false);
        this.holder = titleRecycleViewCardViewHolder;
        this.recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(new StackCardTouchHelperCallback(this));
        this.itemTouchHelper = itemTouchHelper2;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        itemTouchHelper2.attachToRecyclerView(recyclerView3);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        ItemTouchHelper itemTouchHelper3 = this.itemTouchHelper;
        if (itemTouchHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        recyclerView4.setLayoutManager(new StackCardLayoutManager(recyclerView5, itemTouchHelper3));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onBindTo(titleRecycleViewCardViewHolder, obj);
        this.card = (EntityCard) obj;
        titleRecycleViewCardViewHolder.getRecyclerView().setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), 0, ViewMarginData.Companion.getDEFAULT_SIZE(), NumberExtendsKt.getDp((Number) 32));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558738, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "holder.component");
        return new FeedStackItemViewHolder(inflate, component, new FeedStackCardViewHolder$Companion$createCallback$1$onCreateViewHolder$1(this));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onChildBindTo(BindingViewHolder bindingViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onChildBindTo(bindingViewHolder, obj);
        FeedStackItemViewHolder feedStackItemViewHolder = (FeedStackItemViewHolder) bindingViewHolder;
        StackFrameLayout stackFrameLayout = ((ItemFeedStackItemBinding) feedStackItemViewHolder.getBinding()).itemView;
        stackFrameLayout.setOnMove(new FeedStackCardViewHolder$Companion$createCallback$1$onChildBindTo$$inlined$apply$lambda$1(stackFrameLayout, this, feedStackItemViewHolder));
    }

    @Override // com.coolapk.market.widget.stackcard.StackCardTouchHelperCallback.Callback
    public void onSlided(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        if (entities != null) {
            entities.remove(i);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities2 = entityCard2.getEntities();
        if (entities2 != null && entities2.size() == 0) {
            Function1 function1 = this.$removeAction;
            TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder = this.holder;
            if (titleRecycleViewCardViewHolder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("holder");
            }
            function1.invoke(Integer.valueOf(titleRecycleViewCardViewHolder.getAdapterPosition()));
        }
    }
}
