package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.base.BaseFragment;
import com.gongwen.marqueen.MarqueeFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "holder", "Lcom/gongwen/marqueen/MarqueeFactory$ViewHolder;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Lcom/coolapk/market/model/Entity;", "onItemClickListener"}, k = 3, mv = {1, 4, 2})
/* compiled from: TextCarouselCardViewHolder.kt */
final class TextCarouselCardViewHolder$bindTo$1<V extends View, E> implements MarqueeFactory.OnItemClickListener<View, Entity> {
    final /* synthetic */ EntityCard $card;
    final /* synthetic */ TextCarouselCardViewHolder this$0;

    TextCarouselCardViewHolder$bindTo$1(TextCarouselCardViewHolder textCarouselCardViewHolder, EntityCard entityCard) {
        this.this$0 = textCarouselCardViewHolder;
        this.$card = entityCard;
    }

    @Override // com.gongwen.marqueen.MarqueeFactory.OnItemClickListener
    public final void onItemClickListener(MarqueeFactory.ViewHolder<View, Entity> viewHolder) {
        P p = viewHolder.data;
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(p, "entity");
        ActionManagerCompat.startActivityByUrl(context, p.getUrl(), p.getTitle(), p.getSubTitle());
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = this.this$0.getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, p, this.this$0.getAdapterPosition(), this.$card, null, 16, null);
    }
}
