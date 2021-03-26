package com.coolapk.market.view.goodsList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.ItemGoodGoodsListHeaderBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.feed.reply.FeedDetailPresenter;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.NodePaletteBackgroundTarget;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\"H\u0002J*\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00132\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0%H\u0002J\u0006\u0010&\u001a\u00020\u001fJ\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodGoodsListHeaderViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodGoodsListHeaderBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "adapter", "Lcom/coolapk/market/view/goodsList/GoodGoodsListHeaderViewHolder$DataAdapter;", "dataList", "Landroidx/databinding/ObservableArrayList;", "Lcom/coolapk/market/model/Entity;", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed", "()Lcom/coolapk/market/model/Feed;", "goodGoodsViewModel", "Lcom/coolapk/market/view/goodsList/FunThingsViewModel;", "getGoodGoodsViewModel", "()Lcom/coolapk/market/view/goodsList/FunThingsViewModel;", "initData", "", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "bindToContent", "", "data", "findTypeGoodsAdd", "", "loadBG", "callback", "Lkotlin/Function2;", "notifyData", "onClick", "view", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodGoodsListHeaderViewHolder.kt */
public final class GoodGoodsListHeaderViewHolder extends GenericBindHolder<ItemGoodGoodsListHeaderBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558754;
    public static final String TYPE_GOODS_ITEM_ADD = "GOODS_ITEM_ADD";
    private DataAdapter adapter;
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private final FunThingsViewModel goodGoodsViewModel;
    private boolean initData;
    private final FeedDetailPresenter presenter;

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodGoodsListHeaderViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.presenter = feedDetailPresenter;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.goodGoodsViewModel = new FunThingsViewModel(context);
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = ((ItemGoodGoodsListHeaderBinding) getBinding()).listItem;
        Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView, "binding.listItem");
        preventAutoScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        preventAutoScrollRecyclerView.setAdapter(dataAdapter);
        preventAutoScrollRecyclerView.addItemDecoration(((HorizontalDividerItemDecoration.Builder) ((HorizontalDividerItemDecoration.Builder) new HorizontalDividerItemDecoration.Builder(getContext()).color(0)).size(SizeUtils.dp2px(12.0f))).build());
    }

    private final Feed getFeed() {
        return this.presenter.getFeed();
    }

    public final FunThingsViewModel getGoodGoodsViewModel() {
        return this.goodGoodsViewModel;
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        this.goodGoodsViewModel.setFeed(getFeed());
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = ((ItemGoodGoodsListHeaderBinding) getBinding()).listItem;
        Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView, "binding.listItem");
        preventAutoScrollRecyclerView.setMinimumHeight((int) (((double) DisplayUtils.getHeightPixels(getContext())) * 0.6d));
        ItemGoodGoodsListHeaderBinding itemGoodGoodsListHeaderBinding = (ItemGoodGoodsListHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodGoodsListHeaderBinding, "binding");
        itemGoodGoodsListHeaderBinding.setViewModel(this.goodGoodsViewModel);
        loadBG(getFeed(), GoodGoodsListHeaderViewHolder$bindToContent$1.INSTANCE);
        if (!this.initData) {
            if (!this.dataList.isEmpty()) {
                this.dataList.clear();
            }
            if (getFeed().getGoodsListItem().isEmpty()) {
                this.dataList.add(HolderItem.newBuilder().entityType("GOODS_ITEM_ADD").build());
            } else {
                if (findTypeGoodsAdd() > -1) {
                    this.dataList.remove(findTypeGoodsAdd());
                }
                this.dataList.addAll(getFeed().getGoodsListItem());
            }
            this.initData = !this.initData;
        }
        ItemGoodGoodsListHeaderBinding itemGoodGoodsListHeaderBinding2 = (ItemGoodGoodsListHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodGoodsListHeaderBinding2, "binding");
        itemGoodGoodsListHeaderBinding2.setClick(this);
        ((ItemGoodGoodsListHeaderBinding) getBinding()).executePendingBindings();
        FeedWarningBinding feedWarningBinding = ((ItemGoodGoodsListHeaderBinding) getBinding()).alertView;
        Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
        BindingExtensionKt.updateInfo(feedWarningBinding, getFeed().getInnerInfo());
    }

    private final int findTypeGoodsAdd() {
        int size = this.dataList.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.dataList.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "dataList[i]");
            if (Intrinsics.areEqual(((Entity) obj).getEntityType(), "GOODS_ITEM_ADD")) {
                return i;
            }
        }
        return -1;
    }

    public final void notifyData() {
        this.initData = false;
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        dataAdapter.notifyDataSetChanged();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131362095) {
            Context context = getContext();
            ItemGoodGoodsListHeaderBinding itemGoodGoodsListHeaderBinding = (ItemGoodGoodsListHeaderBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemGoodGoodsListHeaderBinding, "binding");
            FunThingsViewModel viewModel = itemGoodGoodsListHeaderBinding.getViewModel();
            Intrinsics.checkNotNull(viewModel);
            Feed feed = viewModel.getFeed();
            Intrinsics.checkNotNull(feed);
            ActionManager.startUserSpaceActivity(context, feed.getUid());
        }
    }

    private final void loadBG(Feed feed, Function2<? super Integer, ? super Integer, Unit> function2) {
        String extraPic = feed.getExtraPic();
        boolean z = extraPic == null || StringsKt.isBlank(extraPic);
        GlideRequest priority = GlideApp.with(getContext()).as(PaletteBitmap.class).load(feed.getExtraPic()).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE);
        View view = ((ItemGoodGoodsListHeaderBinding) getBinding()).backgroundTopView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.backgroundTopView");
        priority.into((GlideRequest) new NodePaletteBackgroundTarget(view, ((ItemGoodGoodsListHeaderBinding) getBinding()).backgroundBottomView, false, new GoodGoodsListHeaderViewHolder$loadBG$wrapCallback$1(this, !z, function2), 4, null));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodGoodsListHeaderViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "TYPE_GOODS_ITEM_ADD", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodGoodsListHeaderViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodGoodsListHeaderViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "(Lcom/coolapk/market/view/goodsList/GoodGoodsListHeaderViewHolder;)V", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodGoodsListHeaderViewHolder.kt */
    public final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
            DataBindingComponent component2 = GoodGoodsListHeaderViewHolder.this.getComponent();
            Fragment fragment = null;
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) (!(component2 instanceof FragmentBindingComponent) ? null : component2);
            Fragment fragment2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            this.component = new FragmentBindingComponent(fragment2 instanceof Fragment ? fragment2 : fragment);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            switch (i) {
                case 2131558752:
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new ItemGoodGoodsViewHolder(inflate, this.component, null);
                case 2131558753:
                    Feed feed = GoodGoodsListHeaderViewHolder.this.getGoodGoodsViewModel().getFeed();
                    Intrinsics.checkNotNull(feed);
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new ItemGoodGoodsAddViewHolder(feed, inflate, this.component, null);
                default:
                    throw new RuntimeException("unknown view type...");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return GoodGoodsListHeaderViewHolder.this.dataList.size();
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.bindTo(GoodGoodsListHeaderViewHolder.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            Entity entity = (Entity) GoodGoodsListHeaderViewHolder.this.dataList.get(i);
            Intrinsics.checkNotNullExpressionValue(entity, "entity");
            return Intrinsics.areEqual(entity.getEntityType(), "GOODS_ITEM_ADD") ? 2131558753 : 2131558752;
        }
    }
}
