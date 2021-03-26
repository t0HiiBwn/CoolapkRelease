package com.coolapk.market.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemImageAppCardBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import com.coolapk.market.widget.video.VideoModel;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/coolapk/market/viewholder/ImageAppViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemImageAppCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "model", "Lcom/coolapk/market/viewholder/EntityItemModel;", "videoViewHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "getVideoViewHotPlug", "()Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "videoViewHotPlug$delegate", "Lkotlin/Lazy;", "bindTo", "", "data", "", "onClick", "view", "onRecycled", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageAppViewHolder.kt */
public final class ImageAppViewHolder extends StateViewHolder implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558786;
    private final ItemImageAppCardBinding binding;
    private EntityCard card;
    private EntityItemModel model;
    private final Lazy videoViewHotPlug$delegate = LazyKt.lazy(new ImageAppViewHolder$videoViewHotPlug$2(this));

    private final BaseVideoHotPlug getVideoViewHotPlug() {
        return (BaseVideoHotPlug) this.videoViewHotPlug$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageAppViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        ItemImageAppCardBinding itemImageAppCardBinding = (ItemImageAppCardBinding) getBinding();
        this.binding = itemImageAppCardBinding;
        Intrinsics.checkNotNullExpressionValue(itemImageAppCardBinding, "binding");
        ImageAppViewHolder imageAppViewHolder = this;
        itemImageAppCardBinding.getRoot().setOnClickListener(imageAppViewHolder);
        itemImageAppCardBinding.includeApp.actionContainer.setOnClickListener(imageAppViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageAppViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageAppViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        VideoModel videoModel;
        String str;
        String str2;
        String str3;
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
        ItemImageAppCardBinding itemImageAppCardBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemImageAppCardBinding, "binding");
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        itemImageAppCardBinding.setCard(entityCard2);
        ItemImageAppCardBinding itemImageAppCardBinding2 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemImageAppCardBinding2, "binding");
        EntityItemModel entityItemModel = this.model;
        if (entityItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        itemImageAppCardBinding2.setModel(entityItemModel);
        this.binding.executePendingBindings();
        EntityItemModel entityItemModel2 = this.model;
        if (entityItemModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        String cardVideoUrl = entityItemModel2.getCardVideoUrl();
        if (cardVideoUrl != null) {
            EntityItemModel entityItemModel3 = this.model;
            if (entityItemModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            String cardTitle = entityItemModel3.getCardTitle();
            if (cardTitle == null) {
                cardTitle = "";
            }
            EntityItemModel entityItemModel4 = this.model;
            if (entityItemModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            String cardCover = entityItemModel4.getCardCover();
            if (cardCover != null) {
                str3 = cardCover;
            } else {
                EntityCard entityCard3 = this.card;
                if (entityCard3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                String pic = entityCard3.getPic();
                str3 = pic != null ? pic : "";
            }
            videoModel = new VideoModel(cardVideoUrl, cardTitle, str3, null, 0, 0, false, false, null, entity, null, 1528, null);
        } else {
            EntityItemModel entityItemModel5 = this.model;
            if (entityItemModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            if (entityItemModel5.getCardVideoParams() != null) {
                EntityItemModel entityItemModel6 = this.model;
                if (entityItemModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                }
                String cardTitle2 = entityItemModel6.getCardTitle();
                if (cardTitle2 != null) {
                    str = cardTitle2;
                } else {
                    str = "";
                }
                EntityItemModel entityItemModel7 = this.model;
                if (entityItemModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                }
                String cardCover2 = entityItemModel7.getCardCover();
                if (cardCover2 == null) {
                    EntityCard entityCard4 = this.card;
                    if (entityCard4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    cardCover2 = entityCard4.getPic();
                    if (cardCover2 == null) {
                        str2 = "";
                        videoModel = new VideoModel(null, str, str2, null, 0, 0, false, false, null, entity, null, 1529, null);
                    }
                }
                str2 = cardCover2;
                videoModel = new VideoModel(null, str, str2, null, 0, 0, false, false, null, entity, null, 1529, null);
            } else {
                videoModel = VideoModel.Companion.getNO_VIDEO();
            }
        }
        getVideoViewHotPlug().bindTo(videoModel);
        this.binding.includeApp.titleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        this.binding.includeApp.subtitleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        this.binding.includeApp.marketInfoView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        ImageView imageView = this.binding.includeApp.actionArrow;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.includeApp.actionArrow");
        imageView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getTextColorPrimary()));
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
        Intrinsics.checkNotNullParameter(event, "event");
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

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        getVideoViewHotPlug().onRecycled();
    }
}
