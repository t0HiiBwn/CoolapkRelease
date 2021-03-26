package com.coolapk.market.viewholder;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.AppCategory;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppCategoryViewHolder.kt */
final class AppCategoryViewHolder$bindToContent$2 implements View.OnClickListener {
    final /* synthetic */ AppCategory $category;
    final /* synthetic */ String $tag;
    final /* synthetic */ AppCategoryViewHolder this$0;

    AppCategoryViewHolder$bindToContent$2(AppCategoryViewHolder appCategoryViewHolder, AppCategory appCategory, String str) {
        this.this$0 = appCategoryViewHolder;
        this.$category = appCategory;
        this.$tag = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startAppCategoryActivity(this.this$0.getContext(), this.$category, this.$category.getTagList().indexOf(this.$tag) + 1);
    }
}
