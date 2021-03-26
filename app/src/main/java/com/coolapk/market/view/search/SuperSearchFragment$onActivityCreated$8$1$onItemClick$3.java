package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.search.SuperSearchFragment$onActivityCreated$8;
import com.coolapk.market.viewholder.AppFilterViewHolder;
import com.coolapk.market.widget.SuperSearchFilterView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onActivityCreated$8$1$onItemClick$3 implements View.OnClickListener {
    final /* synthetic */ SuperSearchFragment$onActivityCreated$8.AnonymousClass1 this$0;

    SuperSearchFragment$onActivityCreated$8$1$onItemClick$3(SuperSearchFragment$onActivityCreated$8.AnonymousClass1 r1) {
        this.this$0 = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SuperSearchFilterView superSearchFilterView = this.this$0.this$0.this$0.sortFilterView;
        if (superSearchFilterView != null) {
            SuperSearchFilterView.hide$default(superSearchFilterView, false, 1, null);
        }
        RecyclerView.ViewHolder viewHolder = this.this$0.this$0.this$0.getItemAppFilterViewHolder();
        if (!(viewHolder instanceof AppFilterViewHolder)) {
            viewHolder = null;
        }
        AppFilterViewHolder appFilterViewHolder = (AppFilterViewHolder) viewHolder;
        if (appFilterViewHolder != null) {
            AppFilterViewHolder.resetSortChevronView$default(appFilterViewHolder, false, 1, null);
        }
    }
}
