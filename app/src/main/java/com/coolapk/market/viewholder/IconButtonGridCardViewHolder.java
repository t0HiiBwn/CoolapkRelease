package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemIconButtonGridCardBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.TitleViewPart;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/IconButtonGridCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/design/CoolapkCardView$CardStyleCallback;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemIconButtonGridCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "onCardStyleDetermined", "cardStyle", "", "onClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconButtonGridCardViewHolder.kt */
public final class IconButtonGridCardViewHolder extends BindingViewHolder implements CoolapkCardView.CardStyleCallback {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558777;
    private final ItemIconButtonGridCardBinding binding;
    private EntityCard card;
    private final TitleViewPart viewPart;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonGridCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemIconButtonGridCardBinding itemIconButtonGridCardBinding = (ItemIconButtonGridCardBinding) getBinding();
        this.binding = itemIconButtonGridCardBinding;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        LinearLayout linearLayout = itemIconButtonGridCardBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        this.viewPart = companion.newInstance(linearLayout, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/IconButtonGridCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconButtonGridCardViewHolder.kt */
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
        TitleViewPart titleViewPart = this.viewPart;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        titleViewPart.bindToContent(entityCard);
        ItemIconButtonGridCardBinding itemIconButtonGridCardBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemIconButtonGridCardBinding, "binding");
        itemIconButtonGridCardBinding.setClick(this);
        ItemIconButtonGridCardBinding itemIconButtonGridCardBinding2 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemIconButtonGridCardBinding2, "binding");
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard2.getEntities();
        Intrinsics.checkNotNull(entities);
        itemIconButtonGridCardBinding2.setCard1(entities.get(0));
        ItemIconButtonGridCardBinding itemIconButtonGridCardBinding3 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemIconButtonGridCardBinding3, "binding");
        EntityCard entityCard3 = this.card;
        if (entityCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities2 = entityCard3.getEntities();
        Intrinsics.checkNotNull(entities2);
        itemIconButtonGridCardBinding3.setCard2(entities2.get(1));
        ItemIconButtonGridCardBinding itemIconButtonGridCardBinding4 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemIconButtonGridCardBinding4, "binding");
        itemIconButtonGridCardBinding4.setLoadListener(new IconButtonGridCardViewHolder$bindTo$onImageLoadListener$1(this));
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        String str = null;
        switch (view.getId()) {
            case 2131362201:
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityCard entityCard = this.card;
                if (entityCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities = entityCard.getEntities();
                Intrinsics.checkNotNull(entities);
                Entity entity = entities.get(0);
                Intrinsics.checkNotNullExpressionValue(entity, "card.entities!![0]");
                String url = entity.getUrl();
                EntityCard entityCard2 = this.card;
                if (entityCard2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities2 = entityCard2.getEntities();
                Intrinsics.checkNotNull(entities2);
                Entity entity2 = entities2.get(0);
                Intrinsics.checkNotNullExpressionValue(entity2, "card.entities!![0]");
                ActionManagerCompat.startActivityByUrl$default(context, url, entity2.getTitle(), null, 8, null);
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
                if (baseFragment != null) {
                    str = baseFragment.getFixedRecordId();
                }
                EntityCard entityCard3 = this.card;
                if (entityCard3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities3 = entityCard3.getEntities();
                Intrinsics.checkNotNull(entities3);
                Entity entity3 = entities3.get(0);
                Intrinsics.checkNotNullExpressionValue(entity3, "card.entities!![0]");
                Entity entity4 = entity3;
                int adapterPosition = getAdapterPosition();
                EntityCard entityCard4 = this.card;
                if (entityCard4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                StatisticHelper.recordEntityEvent$default(instance, str, entity4, adapterPosition, entityCard4, null, 16, null);
                return;
            case 2131362202:
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                EntityCard entityCard5 = this.card;
                if (entityCard5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities4 = entityCard5.getEntities();
                Intrinsics.checkNotNull(entities4);
                Entity entity5 = entities4.get(1);
                Intrinsics.checkNotNullExpressionValue(entity5, "card.entities!![1]");
                String url2 = entity5.getUrl();
                EntityCard entityCard6 = this.card;
                if (entityCard6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities5 = entityCard6.getEntities();
                Intrinsics.checkNotNull(entities5);
                Entity entity6 = entities5.get(1);
                Intrinsics.checkNotNullExpressionValue(entity6, "card.entities!![1]");
                ActionManagerCompat.startActivityByUrl$default(context2, url2, entity6.getTitle(), null, 8, null);
                StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
                DataBindingComponent component2 = getComponent();
                if (!(component2 instanceof FragmentBindingComponent)) {
                    component2 = null;
                }
                FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component2;
                Fragment fragment2 = fragmentBindingComponent2 != null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
                if (!(fragment2 instanceof BaseFragment)) {
                    fragment2 = null;
                }
                BaseFragment baseFragment2 = (BaseFragment) fragment2;
                if (baseFragment2 != null) {
                    str = baseFragment2.getFixedRecordId();
                }
                EntityCard entityCard7 = this.card;
                if (entityCard7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities6 = entityCard7.getEntities();
                Intrinsics.checkNotNull(entities6);
                Entity entity7 = entities6.get(1);
                Intrinsics.checkNotNullExpressionValue(entity7, "card.entities!![1]");
                Entity entity8 = entity7;
                int adapterPosition2 = getAdapterPosition();
                EntityCard entityCard8 = this.card;
                if (entityCard8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                StatisticHelper.recordEntityEvent$default(instance2, str, entity8, adapterPosition2, entityCard8, null, 16, null);
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.design.CoolapkCardView.CardStyleCallback
    public void onCardStyleDetermined(int i) {
        this.viewPart.updateWithCardStyle(i);
    }
}
