package com.coolapk.market.widget.view;

import android.view.View;
import com.coolapk.market.widget.view.RelativeInfoView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: RelativeInfoView.kt */
final class RelativeInfoView$RelateInfoChildViewPart$onBindToContent$3 implements View.OnClickListener {
    final /* synthetic */ RelativeInfoView.RelativeItem $data;
    final /* synthetic */ RelativeInfoView.RelateInfoChildViewPart this$0;

    RelativeInfoView$RelateInfoChildViewPart$onBindToContent$3(RelativeInfoView.RelateInfoChildViewPart relateInfoChildViewPart, RelativeInfoView.RelativeItem relativeItem) {
        this.this$0 = relateInfoChildViewPart;
        this.$data = relativeItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<RelativeInfoView.RelativeItem, Unit> onItemClickListener;
        RelativeInfoView relativeParent = this.this$0.getRelativeParent();
        if (relativeParent != null && (onItemClickListener = relativeParent.getOnItemClickListener()) != null) {
            onItemClickListener.invoke(this.$data);
        }
    }
}
