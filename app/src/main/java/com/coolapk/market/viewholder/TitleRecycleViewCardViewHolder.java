package com.coolapk.market.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemTitleListBinding;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.viewholder.TitleViewPart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 32\u00020\u00012\u00020\u0002:\u0003234B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001aH\u0002J\u001b\u0010-\u001a\u0004\u0018\u00010(*\u00020.2\u0006\u0010/\u001a\u000200H\u0002¢\u0006\u0002\u00101R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00065"}, d2 = {"Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "Lcom/coolapk/market/design/CoolapkCardView$CardStyleCallback;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "callback", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;)V", "adapter", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/ItemTitleListBinding;", "kotlin.jvm.PlatformType", "getCallback", "()Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "card", "Lcom/coolapk/market/model/EntityCard;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "getViewPart", "()Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "getBackgroundImageView", "Landroid/widget/ImageView;", "getCard", "getCardView", "Lcom/coolapk/market/design/CoolapkCardView;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isTitleShowed", "", "onCardStyleDetermined", "cardStyle", "", "onStateEventChanged", "event", "Lcom/coolapk/market/event/Event;", "updateContentPadding", "getIntOrNull", "Lorg/json/JSONObject;", "key", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "Callback", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TitleRecycleViewCardViewHolder.kt */
public class TitleRecycleViewCardViewHolder extends StateViewHolder implements CoolapkCardView.CardStyleCallback {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_SEE_MORE = "see_more";
    public static final int LAYOUT_ID = 2131558956;
    private DataAdapter adapter;
    private final ItemTitleListBinding binding;
    private final Callback callback;
    private EntityCard card;
    private final TitleViewPart viewPart;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0001H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "", "()V", "getItemViewType", "", "obj", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "onCardStyleDetermined", "cardStyle", "onChildBindTo", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TitleRecycleViewCardViewHolder.kt */
    public static abstract class Callback {
        public int getItemViewType(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return 0;
        }

        public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
            Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
            Intrinsics.checkNotNullParameter(obj, "data");
        }

        public void onCardStyleDetermined(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, int i) {
            Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        }

        public void onChildBindTo(BindingViewHolder bindingViewHolder, Object obj) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            Intrinsics.checkNotNullParameter(obj, "data");
        }

        public abstract BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i);

        public abstract void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TitleRecycleViewCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, Callback callback2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, (i & 4) != 0 ? null : itemActionHandler, callback2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleRecycleViewCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, Callback callback2) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
        ItemTitleListBinding itemTitleListBinding = (ItemTitleListBinding) getBinding();
        this.binding = itemTitleListBinding;
        this.adapter = new DataAdapter(this, callback2);
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        RecyclerView recyclerView = itemTitleListBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.listView");
        this.viewPart = companion.newInstance(recyclerView, this);
        RecyclerView recyclerView2 = itemTitleListBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.listView");
        recyclerView2.setNestedScrollingEnabled(false);
        RecyclerView recyclerView3 = itemTitleListBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.listView");
        recyclerView3.setItemAnimator(null);
        RecyclerView recyclerView4 = itemTitleListBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.listView");
        recyclerView4.setAdapter(this.adapter);
        callback2.onInit(this);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Companion;", "", "()V", "ENTITY_TYPE_SEE_MORE", "", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TitleRecycleViewCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final TitleViewPart getViewPart() {
        return this.viewPart;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        EntityCard entityCard = (EntityCard) obj;
        this.card = entityCard;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        if (Intrinsics.areEqual(entityCard.getEntityTemplate(), "readMoreScrollCard")) {
            ArrayList arrayList = new ArrayList();
            EntityCard entityCard2 = this.card;
            if (entityCard2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            List<Entity> entities = entityCard2.getEntities();
            List<Entity> list = entities;
            if (CollectionUtils.isNotEmpty(list)) {
                Intrinsics.checkNotNull(entities);
                arrayList.addAll(list);
                EntityCard entityCard3 = this.card;
                if (entityCard3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities2 = entityCard3.getEntities();
                Intrinsics.checkNotNull(entities2);
                if (entities2.size() > 1) {
                    HolderItem.Builder entityType = HolderItem.newBuilder().entityType("see_more");
                    EntityCard entityCard4 = this.card;
                    if (entityCard4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    HolderItem build = entityType.string(entityCard4.getUrl()).build();
                    Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().….string(card.url).build()");
                    arrayList.add(build);
                }
                EntityCard entityCard5 = this.card;
                if (entityCard5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                EntityCard build2 = EntityCard.builder(entityCard5).setEntities(arrayList).build();
                Intrinsics.checkNotNullExpressionValue(build2, "EntityCard.builder(card).setEntities(list).build()");
                this.card = build2;
            }
        }
        DataAdapter dataAdapter = this.adapter;
        EntityCard entityCard6 = this.card;
        if (entityCard6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        dataAdapter.setData(entityCard6.getEntities());
        this.adapter.notifyDataSetChanged();
        ItemTitleListBinding itemTitleListBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemTitleListBinding, "binding");
        EntityCard entityCard7 = this.card;
        if (entityCard7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        itemTitleListBinding.setTitle(entityCard7.getTitle());
        TitleViewPart titleViewPart = this.viewPart;
        EntityCard entityCard8 = this.card;
        if (entityCard8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        titleViewPart.bindToContent(entityCard8);
        this.binding.executePendingBindings();
        this.callback.onBindTo(this, obj);
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

    public final boolean isTitleShowed() {
        FrameLayout frameLayout = ((ItemTitleViewBinding) this.viewPart.getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "viewPart.binding.moreView");
        return frameLayout.getVisibility() == 0;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.binding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.listView");
        return recyclerView;
    }

    public final ImageView getBackgroundImageView() {
        ImageView imageView = this.binding.backgroundImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backgroundImageView");
        return imageView;
    }

    public final CoolapkCardView getCardView() {
        CoolapkCardView coolapkCardView = this.binding.coolapkCardView;
        Intrinsics.checkNotNullExpressionValue(coolapkCardView, "binding.coolapkCardView");
        return coolapkCardView;
    }

    public final EntityCard getCard() {
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "viewHolder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "callback", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "(Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;)V", "getCallback", "()Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "data", "", "Lcom/coolapk/market/model/Entity;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getViewHolder", "()Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TitleRecycleViewCardViewHolder.kt */
    public static final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final Callback callback;
        private List<? extends Entity> data;
        private final TitleRecycleViewCardViewHolder viewHolder;

        public final Callback getCallback() {
            return this.callback;
        }

        public final TitleRecycleViewCardViewHolder getViewHolder() {
            return this.viewHolder;
        }

        public DataAdapter(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Callback callback2) {
            Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(callback2, "callback");
            this.viewHolder = titleRecycleViewCardViewHolder;
            this.callback = callback2;
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
            return this.callback.onCreateViewHolder(this.viewHolder, viewGroup, i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            List<? extends Entity> list = this.data;
            Intrinsics.checkNotNull(list);
            Entity entity = (Entity) list.get(i);
            bindingViewHolder.bindTo(entity);
            this.callback.onChildBindTo(bindingViewHolder, entity);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends Entity> list = this.data;
            Intrinsics.checkNotNull(list);
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            Callback callback2 = this.callback;
            List<? extends Entity> list = this.data;
            Intrinsics.checkNotNull(list);
            return callback2.getItemViewType(list.get(i));
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
        this.viewPart.updateWithCardStyle(i);
        this.callback.onCardStyleDetermined(this, i);
        updateContentPadding();
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
                getRecyclerView().setPadding(dp, dp, dp, dp);
            }
            RecyclerView recyclerView = getRecyclerView();
            Integer intOrNull = getIntOrNull(jsonExtraData, "cardContainerPaddingLeft");
            int dp2 = intOrNull != null ? NumberExtendsKt.getDp(intOrNull) : recyclerView.getPaddingLeft();
            Integer intOrNull2 = getIntOrNull(jsonExtraData, "cardContainerPaddingTop");
            int dp3 = intOrNull2 != null ? NumberExtendsKt.getDp(intOrNull2) : recyclerView.getPaddingTop();
            Integer intOrNull3 = getIntOrNull(jsonExtraData, "cardContainerPaddingRight");
            int dp4 = intOrNull3 != null ? NumberExtendsKt.getDp(intOrNull3) : recyclerView.getPaddingRight();
            Integer intOrNull4 = getIntOrNull(jsonExtraData, "cardContainerPaddingBottom");
            recyclerView.setPadding(dp2, dp3, dp4, intOrNull4 != null ? NumberExtendsKt.getDp(intOrNull4) : recyclerView.getPaddingBottom());
        }
    }

    private final Integer getIntOrNull(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.optInt(str));
        }
        return null;
    }
}
