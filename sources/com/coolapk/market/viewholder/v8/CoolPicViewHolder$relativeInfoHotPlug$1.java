package com.coolapk.market.viewholder.v8;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/CoolPicViewHolder$relativeInfoHotPlug$1", "Lcom/coolapk/market/widget/hotplug/BaseFeedRelativeHotPlug;", "onViewPartLoad", "", "viewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewHolder.kt */
public final class CoolPicViewHolder$relativeInfoHotPlug$1 extends BaseFeedRelativeHotPlug {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ CoolPicViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoolPicViewHolder$relativeInfoHotPlug$1(CoolPicViewHolder coolPicViewHolder, DataBindingComponent dataBindingComponent, View view, DataBindingComponent dataBindingComponent2) {
        super(view, dataBindingComponent2, null, false, 12, null);
        this.this$0 = coolPicViewHolder;
        this.$component = dataBindingComponent;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug
    public void onViewPartLoad(FeedRelativeInfoViewPart feedRelativeInfoViewPart) {
        Intrinsics.checkNotNullParameter(feedRelativeInfoViewPart, "viewPart");
        super.onViewPartLoad(feedRelativeInfoViewPart);
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(feedRelativeInfoViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = ConvertUtils.dp2px(8.0f);
        }
    }
}
