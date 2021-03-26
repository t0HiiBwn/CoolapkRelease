package com.coolapk.market.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemIconGridCardItemBinding;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.viewholder.IconTitleGridCard;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/IconTitleGridCard$1$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/IconGridCardItemViewHolder;", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconTitleGridCard.kt */
public final class IconTitleGridCard$1$onCreateViewHolder$1 extends IconGridCardItemViewHolder {
    final /* synthetic */ TitleRecycleViewCardViewHolder $holder;
    final /* synthetic */ View $view;
    final /* synthetic */ IconTitleGridCard.AnonymousClass1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconTitleGridCard$1$onCreateViewHolder$1(IconTitleGridCard.AnonymousClass1 r1, TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, View view, View view2, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view2, dataBindingComponent, entityListPresenter);
        this.this$0 = r1;
        this.$holder = titleRecycleViewCardViewHolder;
        this.$view = view;
    }

    @Override // com.coolapk.market.viewholder.IconGridCardItemViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        super.bindTo(obj);
        ItemIconGridCardItemBinding itemIconGridCardItemBinding = (ItemIconGridCardItemBinding) getBinding();
        setParentCard(IconTitleGridCard.AnonymousClass1.access$getCard$p(this.this$0));
        setParentViewHolder(this.$holder);
        int dp2px = ConvertUtils.dp2px(this.this$0.spanCount == 4 ? 48.0f : 56.0f);
        ImageView imageView = itemIconGridCardItemBinding.iconView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams.width != dp2px) {
            layoutParams.width = dp2px;
            layoutParams.height = dp2px;
            itemIconGridCardItemBinding.iconView.requestLayout();
        }
        if (ArraysKt.contains(new String[]{"iconLongTitleGridCard"}, IconTitleGridCard.AnonymousClass1.access$getCard$p(this.this$0).getEntityTemplate())) {
            TextView textView = itemIconGridCardItemBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setMaxLines(2);
            return;
        }
        TextView textView2 = itemIconGridCardItemBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setMaxLines(1);
    }
}
