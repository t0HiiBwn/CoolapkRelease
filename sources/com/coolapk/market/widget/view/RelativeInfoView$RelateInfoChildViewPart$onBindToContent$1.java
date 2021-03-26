package com.coolapk.market.widget.view;

import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemRelativeChildBinding;
import com.coolapk.market.widget.view.RelativeInfoView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: RelativeInfoView.kt */
final class RelativeInfoView$RelateInfoChildViewPart$onBindToContent$1 implements Runnable {
    final /* synthetic */ RelativeInfoView.RelativeItem $data;
    final /* synthetic */ RelativeInfoView.RelateInfoChildViewPart this$0;

    RelativeInfoView$RelateInfoChildViewPart$onBindToContent$1(RelativeInfoView.RelateInfoChildViewPart relateInfoChildViewPart, RelativeInfoView.RelativeItem relativeItem) {
        this.this$0 = relateInfoChildViewPart;
        this.$data = relativeItem;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (RelativeInfoView.RelateInfoChildViewPart.Companion.getNUMS_REGEX().matches(this.$data.getImage())) {
            ((ItemRelativeChildBinding) this.this$0.getBinding()).iconView.setImageResource(Integer.parseInt(this.$data.getImage()));
        } else {
            AppHolder.getContextImageLoader().displayImage(this.this$0.getContext(), this.$data.getImage(), ((ItemRelativeChildBinding) this.this$0.getBinding()).iconView, 2131231374);
        }
    }
}
