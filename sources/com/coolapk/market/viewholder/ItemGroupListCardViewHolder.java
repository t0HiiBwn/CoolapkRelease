package com.coolapk.market.viewholder;

import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemGroupListCardBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.goods.GoodsV10ViewHolder;
import com.coolapk.market.view.goods.GoodsViewHolder;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import com.coolapk.market.widget.view.HotReplyTagShape;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/viewholder/ItemGroupListCardViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "Lcom/coolapk/market/design/CoolapkCardView$CardStyleCallback;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "parentAdapter", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;)V", "adapter", "Lcom/coolapk/market/viewholder/ItemGroupListCardViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/ItemGroupListCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "bindTo", "", "data", "", "onCardStyleDetermined", "cardStyle", "", "onClick", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "setDefaultCardBackground", "color", "updateBackgroundFromLogo", "firstLogo", "", "updateContentPadding", "updateDividerSize", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemGroupListCardViewHolder.kt */
public final class ItemGroupListCardViewHolder extends StateViewHolder implements CoolapkCardView.CardStyleCallback {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558778;
    private DataAdapter adapter;
    private final ItemGroupListCardBinding binding;
    private EntityCard card;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemGroupListCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, BaseMultiTypeAdapter baseMultiTypeAdapter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, (i & 4) != 0 ? null : itemActionHandler, baseMultiTypeAdapter);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemGroupListCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, BaseMultiTypeAdapter baseMultiTypeAdapter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(baseMultiTypeAdapter, "parentAdapter");
        ItemGroupListCardBinding itemGroupListCardBinding = (ItemGroupListCardBinding) getBinding();
        this.binding = itemGroupListCardBinding;
        this.adapter = new DataAdapter(baseMultiTypeAdapter);
        RecyclerView recyclerView = itemGroupListCardBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.listView");
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = itemGroupListCardBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.listView");
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = itemGroupListCardBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.listView");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView4 = itemGroupListCardBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.listView");
        recyclerView4.setAdapter(this.adapter);
        TextView textView = itemGroupListCardBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setBackground(new ShapeDrawable(new HotReplyTagShape(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 8))));
        Intrinsics.checkNotNullExpressionValue(itemGroupListCardBinding, "binding");
        itemGroupListCardBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ItemGroupListCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemGroupListCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        Entity entity;
        Intrinsics.checkNotNullParameter(obj, "data");
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setBackgroundTintList(ColorStateList.valueOf((int) 4294948626L));
        EntityCard entityCard = (EntityCard) obj;
        this.card = entityCard;
        DataAdapter dataAdapter = this.adapter;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        dataAdapter.setData(entityCard.getEntities());
        this.adapter.notifyDataSetChanged();
        TextView textView2 = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setText(entityCard.getTitle());
        this.binding.executePendingBindings();
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard2.getEntities();
        if (!(entities == null || (entity = (Entity) CollectionsKt.firstOrNull((List<? extends Object>) entities)) == null)) {
            str = entity.getLogo();
            if (str == null) {
                str = entity.getPic();
            }
            if (str == null) {
                if (entity instanceof FeedGoods) {
                    str = ((FeedGoods) entity).getCover();
                }
            }
            if (str == null) {
                updateBackgroundFromLogo(str);
                return;
            } else {
                setDefaultCardBackground$default(this, 0, 1, null);
                return;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    private final void updateBackgroundFromLogo(String str) {
        GlideApp.with(getContext()).as(PaletteBitmap.class).load(str).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).into((GlideRequest) new ItemGroupListCardViewHolder$updateBackgroundFromLogo$1(this, 24, 24));
    }

    static /* synthetic */ void setDefaultCardBackground$default(ItemGroupListCardViewHolder itemGroupListCardViewHolder, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = (int) 4286747852L;
        }
        itemGroupListCardViewHolder.setDefaultCardBackground(i);
    }

    /* access modifiers changed from: private */
    public final void setDefaultCardBackground(int i) {
        this.binding.coolapkCardView.setDefaultBackgroundColor(Integer.valueOf(i));
        this.binding.coolapkCardView.setRoundCardStyle();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362472) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String url = entityCard.getUrl();
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String title = entityCard2.getTitle();
        EntityCard entityCard3 = this.card;
        if (entityCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        ActionManagerCompat.startActivityByUrl(context, url, title, entityCard3.getSubTitle());
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        if (entities != null) {
            List<Entity> list = entities;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    if (!Intrinsics.areEqual(next.getEntityType(), "apk") || !StateViewHolder.isEventBelongTo(event, (ServiceApp) next)) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/ItemGroupListCardViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parentAdapter", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "(Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;)V", "data", "", "Lcom/coolapk/market/model/Entity;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getParentAdapter", "()Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemGroupListCardViewHolder.kt */
    private static final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private List<? extends Entity> data;
        private final BaseMultiTypeAdapter parentAdapter;

        public final BaseMultiTypeAdapter getParentAdapter() {
            return this.parentAdapter;
        }

        public DataAdapter(BaseMultiTypeAdapter baseMultiTypeAdapter) {
            Intrinsics.checkNotNullParameter(baseMultiTypeAdapter, "parentAdapter");
            this.parentAdapter = baseMultiTypeAdapter;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.Entity> */
        public final List<Entity> getData() {
            return this.data;
        }

        public final void setData(List<? extends Entity> list) {
            this.data = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            RecyclerView.ViewHolder onCreateViewHolder = this.parentAdapter.onCreateViewHolder(viewGroup, i);
            Objects.requireNonNull(onCreateViewHolder, "null cannot be cast to non-null type com.coolapk.market.viewholder.BindingViewHolder");
            BindingViewHolder bindingViewHolder = (BindingViewHolder) onCreateViewHolder;
            if (bindingViewHolder instanceof GoodsV10ViewHolder) {
                ((GoodsV10ViewHolder) bindingViewHolder).setInitLargeIconMode();
            } else if (bindingViewHolder instanceof GoodsViewHolder) {
                ((GoodsViewHolder) bindingViewHolder).setInitLargeIconMode();
            }
            return bindingViewHolder;
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            List<? extends Entity> list = this.data;
            Intrinsics.checkNotNull(list);
            bindingViewHolder.bindTo((Entity) list.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends Entity> list = this.data;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            BaseMultiTypeAdapter baseMultiTypeAdapter = this.parentAdapter;
            List<? extends Entity> list = this.data;
            Intrinsics.checkNotNull(list);
            return baseMultiTypeAdapter.getItemViewType(list.get(i));
        }

        public void onViewAttachedToWindow(BindingViewHolder bindingViewHolder) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.onViewAttachedToWindow();
        }

        public void onViewDetachedFromWindow(BindingViewHolder bindingViewHolder) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.onViewDetachedFromWindow();
        }
    }

    @Override // com.coolapk.market.design.CoolapkCardView.CardStyleCallback
    public void onCardStyleDetermined(int i) {
        updateContentPadding();
        updateDividerSize();
    }

    private final void updateContentPadding() {
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(entityCard);
        if (jsonExtraData != null) {
            if (jsonExtraData.has("cardContainerPadding")) {
                int dp = NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.getInt("cardContainerPadding")));
                this.binding.listView.setPadding(dp, dp, dp, dp);
            }
            RecyclerView recyclerView = this.binding.listView;
            Integer intOrNull = KotlinExtendKt.getIntOrNull(jsonExtraData, "cardContainerPaddingLeft");
            int dp2 = intOrNull != null ? NumberExtendsKt.getDp(intOrNull) : recyclerView.getPaddingLeft();
            Integer intOrNull2 = KotlinExtendKt.getIntOrNull(jsonExtraData, "cardContainerPaddingTop");
            int dp3 = intOrNull2 != null ? NumberExtendsKt.getDp(intOrNull2) : recyclerView.getPaddingTop();
            Integer intOrNull3 = KotlinExtendKt.getIntOrNull(jsonExtraData, "cardContainerPaddingRight");
            int dp4 = intOrNull3 != null ? NumberExtendsKt.getDp(intOrNull3) : recyclerView.getPaddingRight();
            Integer intOrNull4 = KotlinExtendKt.getIntOrNull(jsonExtraData, "cardContainerPaddingBottom");
            recyclerView.setPadding(dp2, dp3, dp4, intOrNull4 != null ? NumberExtendsKt.getDp(intOrNull4) : recyclerView.getPaddingBottom());
        }
    }

    private final void updateDividerSize() {
        RecyclerView recyclerView = this.binding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.listView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        int dp = NumberExtendsKt.getDp(Integer.valueOf(EntityExtendsKt.getIntExtraData(entityCard, "internalDividerSize", 12)));
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        RecyclerViewDivider build = companion.with(application).asSpace().size(dp).hideLastDivider().build();
        RecyclerView recyclerView2 = this.binding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.listView");
        build.addTo(recyclerView2);
    }
}
