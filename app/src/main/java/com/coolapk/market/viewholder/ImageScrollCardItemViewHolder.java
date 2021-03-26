package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemImageScrollCardItemBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.AspectRatioImageView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/viewholder/ImageScrollCardItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "aspectRatio", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;F)V", "getAspectRatio", "()F", "imageCard", "Lcom/coolapk/market/model/Entity;", "parentCard", "getParentCard", "()Lcom/coolapk/market/model/Entity;", "setParentCard", "(Lcom/coolapk/market/model/Entity;)V", "parentViewHolder", "getParentViewHolder", "()Lcom/coolapk/market/viewholder/BindingViewHolder;", "setParentViewHolder", "(Lcom/coolapk/market/viewholder/BindingViewHolder;)V", "bindTo", "", "data", "", "onClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageScrollCardItemViewHolder.kt */
public class ImageScrollCardItemViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558793;
    private final float aspectRatio;
    private Entity imageCard;
    private Entity parentCard;
    private BindingViewHolder parentViewHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageScrollCardItemViewHolder(View view, DataBindingComponent dataBindingComponent, float f) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.aspectRatio = f;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final Entity getParentCard() {
        return this.parentCard;
    }

    public final void setParentCard(Entity entity) {
        this.parentCard = entity;
    }

    public final BindingViewHolder getParentViewHolder() {
        return this.parentViewHolder;
    }

    public final void setParentViewHolder(BindingViewHolder bindingViewHolder) {
        this.parentViewHolder = bindingViewHolder;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageScrollCardItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageScrollCardItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        this.imageCard = (Entity) obj;
        ItemImageScrollCardItemBinding itemImageScrollCardItemBinding = (ItemImageScrollCardItemBinding) getBinding();
        ViewUtil.clickListener(itemImageScrollCardItemBinding.itemView, this);
        AspectRatioImageView aspectRatioImageView = itemImageScrollCardItemBinding.imageView;
        Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.imageView");
        ViewExtendsKt.darkForegroundIfNeed(aspectRatioImageView);
        AspectRatioImageView aspectRatioImageView2 = itemImageScrollCardItemBinding.imageView;
        Intrinsics.checkNotNullExpressionValue(aspectRatioImageView2, "binding.imageView");
        aspectRatioImageView2.setAspectRatio(this.aspectRatio);
        CardView cardView = itemImageScrollCardItemBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.itemView");
        cardView.getLayoutParams().width = ConvertUtils.dp2px(this.aspectRatio == 1.0f ? 68.0f : 104.0f);
        Intrinsics.checkNotNullExpressionValue(itemImageScrollCardItemBinding, "binding");
        Entity entity = this.imageCard;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageCard");
        }
        itemImageScrollCardItemBinding.setImageCard(entity);
        itemImageScrollCardItemBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362768) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Entity entity = this.imageCard;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageCard");
        }
        ActionManagerCompat.startActivityByUrl$default(context, entity.getUrl(), null, null, 12, null);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = getComponent();
        int i = null;
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
        Entity entity2 = this.imageCard;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageCard");
        }
        BindingViewHolder bindingViewHolder = this.parentViewHolder;
        if (bindingViewHolder != null) {
            i = Integer.valueOf(bindingViewHolder.getAdapterPosition());
        }
        if (i == null) {
            i = -1;
        }
        StatisticHelper.recordEntityEvent$default(instance, fixedRecordId, entity2, i.intValue(), this.parentCard, null, 16, null);
    }
}
