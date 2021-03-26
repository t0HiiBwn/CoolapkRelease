package com.coolapk.market.view.category;

import android.view.View;
import com.coolapk.market.databinding.ItemCategoryDetailRankBinding;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.category.RankingAppFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: RankingAppFragment.kt */
final class RankingAppFragment$RankTypeViewHolder$bindToContent$1 implements View.OnClickListener {
    final /* synthetic */ ItemCategoryDetailRankBinding $binding;
    final /* synthetic */ RankingAppFragment.RankTypeViewHolder this$0;

    RankingAppFragment$RankTypeViewHolder$bindToContent$1(RankingAppFragment.RankTypeViewHolder rankTypeViewHolder, ItemCategoryDetailRankBinding itemCategoryDetailRankBinding) {
        this.this$0 = rankTypeViewHolder;
        this.$binding = itemCategoryDetailRankBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(view, "v");
        BasePopMenu basePopMenu = new BasePopMenu(view.getContext(), this.$binding.imageView);
        basePopMenu.inflate(2131623939);
        basePopMenu.setOnMenuItemClickListener(this.this$0);
        basePopMenu.show();
    }
}
