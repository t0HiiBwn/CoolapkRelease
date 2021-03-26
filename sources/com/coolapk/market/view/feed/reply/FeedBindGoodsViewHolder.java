package com.coolapk.market.view.feed.reply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.ItemBindGoodsChildBinding;
import com.coolapk.market.databinding.ItemFeedBindGoodsBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.viewholder.GenericBindHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedBindGoodsViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedBindGoodsBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "adapter", "Lcom/coolapk/market/view/feed/reply/FeedBindGoodsViewHolder$DataAdapter;", "bindingComponent", "Lcom/coolapk/market/binding/ContextBindingComponent;", "getBindingComponent", "()Lcom/coolapk/market/binding/ContextBindingComponent;", "bindingComponent$delegate", "Lkotlin/Lazy;", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "bindToContent", "", "data", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewHolder.kt */
public final class FeedBindGoodsViewHolder extends GenericBindHolder<ItemFeedBindGoodsBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558699;
    private final DataAdapter adapter;
    private final Lazy bindingComponent$delegate = LazyKt.lazy(new FeedBindGoodsViewHolder$bindingComponent$2(this));
    private final FeedDetailPresenter presenter;

    /* access modifiers changed from: private */
    public final ContextBindingComponent getBindingComponent() {
        return (ContextBindingComponent) this.bindingComponent$delegate.getValue();
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBindGoodsViewHolder(View view, DataBindingComponent dataBindingComponent, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.presenter = feedDetailPresenter;
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        ItemFeedBindGoodsBinding itemFeedBindGoodsBinding = (ItemFeedBindGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedBindGoodsBinding, "binding");
        itemFeedBindGoodsBinding.setClick(this);
        RecyclerView recyclerView = ((ItemFeedBindGoodsBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(dataAdapter);
        RecyclerView recyclerView2 = ((ItemFeedBindGoodsBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedBindGoodsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedBindGoodsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        Feed feed = this.presenter.getFeed();
        DataAdapter dataAdapter = this.adapter;
        List<FeedGoods> includeGoods = feed.getIncludeGoods();
        Intrinsics.checkNotNullExpressionValue(includeGoods, "feed.includeGoods");
        dataAdapter.submitList(includeGoods);
        ((ItemFeedBindGoodsBinding) getBinding()).executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedBindGoodsViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/coolapk/market/view/feed/reply/FeedBindGoodsViewHolder;)V", "dataList", "", "Lcom/coolapk/market/model/FeedGoods;", "getItem", "position", "", "getItemCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newList", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedBindGoodsViewHolder.kt */
    private final class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<FeedGoods> dataList = new ArrayList();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        public final void submitList(List<? extends FeedGoods> list) {
            Intrinsics.checkNotNullParameter(list, "newList");
            this.dataList.clear();
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            ItemBindGoodsChildBinding itemBindGoodsChildBinding = (ItemBindGoodsChildBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), 2131558628, viewGroup, false, FeedBindGoodsViewHolder.this.getBindingComponent());
            Intrinsics.checkNotNullExpressionValue(itemBindGoodsChildBinding, "binding");
            View root = itemBindGoodsChildBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return new com.coolapk.market.view.feed.goods.FeedBindGoodsViewHolder(root, FeedBindGoodsViewHolder.this.getBindingComponent());
        }

        public final FeedGoods getItem(int i) {
            return this.dataList.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            com.coolapk.market.view.feed.goods.FeedBindGoodsViewHolder feedBindGoodsViewHolder = (com.coolapk.market.view.feed.goods.FeedBindGoodsViewHolder) (!(viewHolder instanceof com.coolapk.market.view.feed.goods.FeedBindGoodsViewHolder) ? null : viewHolder);
            if (feedBindGoodsViewHolder != null) {
                feedBindGoodsViewHolder.bindTo(getItem(i));
                ((ItemBindGoodsChildBinding) feedBindGoodsViewHolder.getBinding()).containerView.setOnClickListener(new FeedBindGoodsViewHolder$DataAdapter$onBindViewHolder$$inlined$let$lambda$1(this, i, viewHolder));
            }
        }
    }
}
