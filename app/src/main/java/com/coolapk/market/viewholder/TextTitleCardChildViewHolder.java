package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemTextTitleScrollChildBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.view.HotReplyTagShape;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/viewholder/TextTitleCardChildViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemTextTitleScrollChildBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "parentHolder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;)V", "entity", "getParentHolder", "()Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextTitleScrollCardViewHolder.kt */
final class TextTitleCardChildViewHolder extends GenericBindHolder<ItemTextTitleScrollChildBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558952;
    private Entity entity;
    private final TitleRecycleViewCardViewHolder parentHolder;

    public final TitleRecycleViewCardViewHolder getParentHolder() {
        return this.parentHolder;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextTitleCardChildViewHolder(View view, DataBindingComponent dataBindingComponent, TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "parentHolder");
        this.parentHolder = titleRecycleViewCardViewHolder;
        LinearLayout linearLayout = ((ItemTextTitleScrollChildBinding) getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
        ViewUtil.clickListener(linearLayout, this);
        LinearLayout linearLayout2 = ((ItemTextTitleScrollChildBinding) getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.cardView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(NumberExtendsKt.getDp(Double.valueOf(0.5d)), AppHolder.getAppTheme().getCurrencyColorDivider());
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        Unit unit = Unit.INSTANCE;
        linearLayout2.setBackground(gradientDrawable);
        TextView textView = ((ItemTextTitleScrollChildBinding) getBinding()).newTagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.newTagView");
        textView.setBackground(new ShapeDrawable(new HotReplyTagShape(0, 0, 3, null)));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/TextTitleCardChildViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TextTitleScrollCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity2) {
        Intrinsics.checkNotNullParameter(entity2, "data");
        ItemTextTitleScrollChildBinding itemTextTitleScrollChildBinding = (ItemTextTitleScrollChildBinding) getBinding();
        this.entity = entity2;
        Intrinsics.checkNotNullExpressionValue(itemTextTitleScrollChildBinding, "binding");
        itemTextTitleScrollChildBinding.setModel(entity2);
        itemTextTitleScrollChildBinding.executePendingBindings();
        LinearLayout linearLayout = itemTextTitleScrollChildBinding.cardView;
        List<Entity> entities = this.parentHolder.getCard().getEntities();
        Intrinsics.checkNotNull(entities);
        if (entities.size() == 1) {
            linearLayout.getLayoutParams().width = -1;
            return;
        }
        linearLayout.getLayoutParams().width = (DisplayUtils.getDecorMinSideLength(linearLayout.getContext()) / 4) * 3;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Entity entity2 = this.entity;
        if (entity2 == null) {
            return;
        }
        if (view.getId() != 2131362200) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl(context, entity2.getUrl(), entity2.getTitle(), entity2.getSubTitle());
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = getComponent();
        String str = null;
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
        StatisticHelper.recordEntityEvent$default(instance, str, entity2, getAdapterPosition(), this.parentHolder.getCard(), null, 16, null);
    }
}
