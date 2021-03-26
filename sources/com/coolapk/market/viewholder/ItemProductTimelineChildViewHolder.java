package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemProductTimelineChildBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.base.BaseFragment;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0017J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0002R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/ItemProductTimelineChildViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProductTimelineChildBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "value", "Lcom/coolapk/market/model/EntityCard;", "parentCard", "getParentCard", "()Lcom/coolapk/market/model/EntityCard;", "setParentCard", "(Lcom/coolapk/market/model/EntityCard;)V", "bindToContent", "", "data", "onClick", "view", "updateDotLineMargin", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductTimelineViewHolder.kt */
final class ItemProductTimelineChildViewHolder extends GenericBindHolder<ItemProductTimelineChildBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    private static final Regex DATE_REGEX = new Regex("(\\d{1,2})月(\\d{1,2})日");
    public static final int LAYOUT_ID = 2131558888;
    private static final Regex YEAR_REGEX = new Regex("(\\d{4})年");
    private EntityCard parentCard;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemProductTimelineChildViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemProductTimelineChildBinding itemProductTimelineChildBinding = (ItemProductTimelineChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductTimelineChildBinding, "binding");
        itemProductTimelineChildBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/ItemProductTimelineChildViewHolder$Companion;", "", "()V", "DATE_REGEX", "Lkotlin/text/Regex;", "getDATE_REGEX", "()Lkotlin/text/Regex;", "LAYOUT_ID", "", "YEAR_REGEX", "getYEAR_REGEX", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductTimelineViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Regex getYEAR_REGEX() {
            return ItemProductTimelineChildViewHolder.YEAR_REGEX;
        }

        public final Regex getDATE_REGEX() {
            return ItemProductTimelineChildViewHolder.DATE_REGEX;
        }
    }

    public final EntityCard getParentCard() {
        return this.parentCard;
    }

    public final void setParentCard(EntityCard entityCard) {
        this.parentCard = entityCard;
        updateDotLineMargin();
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        MatchResult find$default;
        Intrinsics.checkNotNullParameter(entity, "data");
        ItemProductTimelineChildBinding itemProductTimelineChildBinding = (ItemProductTimelineChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductTimelineChildBinding, "binding");
        if (!Intrinsics.areEqual(itemProductTimelineChildBinding.getModel(), entity) && (entity instanceof Product)) {
            StringBuilder sb = new StringBuilder();
            Product product = (Product) entity;
            sb.append(KotlinExtendKt.toDisplayString(product.getHotNum()));
            sb.append("热度");
            String sb2 = sb.toString();
            TextView textView = ((ItemProductTimelineChildBinding) getBinding()).infoView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.infoView");
            textView.setText(sb2);
            TextView textView2 = ((ItemProductTimelineChildBinding) getBinding()).yearView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.yearView");
            textView2.setVisibility(8);
            TextView textView3 = ((ItemProductTimelineChildBinding) getBinding()).dateView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.dateView");
            textView3.setText("未公布");
            String releaseTime = product.getReleaseTime();
            if (!(releaseTime == null || (find$default = Regex.find$default(YEAR_REGEX, releaseTime, 0, 2, null)) == null)) {
                String str = find$default.getGroupValues().get(1);
                TextView textView4 = ((ItemProductTimelineChildBinding) getBinding()).yearView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.yearView");
                textView4.setText(str);
                TextView textView5 = ((ItemProductTimelineChildBinding) getBinding()).yearView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.yearView");
                textView5.setVisibility(0);
                String replace$default = StringsKt.replace$default(releaseTime, str + (char) 24180, "", false, 4, (Object) null);
                MatchResult matchEntire = DATE_REGEX.matchEntire(replace$default);
                if (matchEntire != null) {
                    TextView textView6 = ((ItemProductTimelineChildBinding) getBinding()).dateView;
                    Intrinsics.checkNotNullExpressionValue(textView6, "binding.dateView");
                    textView6.setText(matchEntire.getGroupValues().get(1) + "." + matchEntire.getGroupValues().get(2));
                } else {
                    TextView textView7 = ((ItemProductTimelineChildBinding) getBinding()).dateView;
                    Intrinsics.checkNotNullExpressionValue(textView7, "binding.dateView");
                    textView7.setText(replace$default);
                }
            }
            ItemProductTimelineChildBinding itemProductTimelineChildBinding2 = (ItemProductTimelineChildBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemProductTimelineChildBinding2, "binding");
            itemProductTimelineChildBinding2.setModel(entity);
            ((ItemProductTimelineChildBinding) getBinding()).executePendingBindings();
        }
    }

    private final void updateDotLineMargin() {
        List<Entity> entities;
        EntityCard entityCard = this.parentCard;
        if (entityCard != null && (entities = entityCard.getEntities()) != null) {
            Intrinsics.checkNotNullExpressionValue(entities, "parentCard?.entities ?: return");
            ItemProductTimelineChildBinding itemProductTimelineChildBinding = (ItemProductTimelineChildBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemProductTimelineChildBinding, "binding");
            Entity model = itemProductTimelineChildBinding.getModel();
            if (model != null) {
                Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
                int indexOf = entities.indexOf(model);
                View view = ((ItemProductTimelineChildBinding) getBinding()).dividerView;
                Intrinsics.checkNotNullExpressionValue(view, "binding.dividerView");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                if (indexOf == 0) {
                    marginLayoutParams2.topMargin = NumberExtendsKt.getDp((Number) 8);
                    marginLayoutParams2.bottomMargin = 0;
                } else if (indexOf == entities.size() - 1) {
                    marginLayoutParams2.topMargin = 0;
                    marginLayoutParams2.bottomMargin = NumberExtendsKt.getDp((Number) 8);
                } else {
                    marginLayoutParams2.topMargin = 0;
                    marginLayoutParams2.bottomMargin = 0;
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemProductTimelineChildBinding itemProductTimelineChildBinding = (ItemProductTimelineChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductTimelineChildBinding, "binding");
        Entity model = itemProductTimelineChildBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            if (view.getId() != 2131362779) {
                super.onClick(view);
                return;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl(context, model.getUrl(), model.getTitle(), model.getSubTitle());
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
            StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, model, getAdapterPosition(), this.parentCard, null, 16, null);
        }
    }
}
