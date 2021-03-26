package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemImageAppBigCardBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.base.BaseFragment;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/viewholder/ImageAppBigViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemImageAppBigCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "model", "Lcom/coolapk/market/viewholder/EntityItemModel;", "bindTo", "", "data", "", "onClick", "view", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageAppBigViewHolder.kt */
public final class ImageAppBigViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558792;
    private final ItemImageAppBigCardBinding binding;
    private EntityCard card;
    private EntityItemModel model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageAppBigViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        ItemImageAppBigCardBinding itemImageAppBigCardBinding = (ItemImageAppBigCardBinding) getBinding();
        this.binding = itemImageAppBigCardBinding;
        Intrinsics.checkNotNullExpressionValue(itemImageAppBigCardBinding, "binding");
        ImageAppBigViewHolder imageAppBigViewHolder = this;
        itemImageAppBigCardBinding.getRoot().setOnClickListener(imageAppBigViewHolder);
        itemImageAppBigCardBinding.includeApp.actionContainer.setOnClickListener(imageAppBigViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageAppBigViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageAppBigViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard = (EntityCard) obj;
        this.card = entityCard;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        Intrinsics.checkNotNull(entities);
        Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
        Entity entity = (Entity) CollectionsKt.first((List<? extends Object>) entities);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        this.model = new EntityItemModel(context, entity);
        ItemImageAppBigCardBinding itemImageAppBigCardBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemImageAppBigCardBinding, "binding");
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        itemImageAppBigCardBinding.setCard(entityCard2);
        ItemImageAppBigCardBinding itemImageAppBigCardBinding2 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemImageAppBigCardBinding2, "binding");
        EntityItemModel entityItemModel = this.model;
        if (entityItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        itemImageAppBigCardBinding2.setModel(entityItemModel);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        EntityItemModel entityItemModel = this.model;
        if (entityItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        entityItemModel.doAction(view);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        String fixedRecordId = baseFragment != null ? baseFragment.getFixedRecordId() : null;
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        Intrinsics.checkNotNull(entities);
        Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
        Object first = CollectionsKt.first((List<? extends Object>) entities);
        Intrinsics.checkNotNullExpressionValue(first, "card.entities!!.first()");
        Entity entity = (Entity) first;
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        StatisticHelper.recordEntityEvent$default(instance, fixedRecordId, entity, 0, entityCard2, null, 16, null);
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        EntityItemModel entityItemModel = this.model;
        if (entityItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        if (entityItemModel.getServiceApp() == null) {
            return false;
        }
        EntityItemModel entityItemModel2 = this.model;
        if (entityItemModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        return StateViewHolder.isEventBelongTo(event, entityItemModel2.getServiceApp());
    }
}
