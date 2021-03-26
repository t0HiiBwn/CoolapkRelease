package com.coolapk.market.view.live;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.hotplug.BaseNineImageHotPlug;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/live/LiveMessageViewHolder$nineImageHotPlug$1", "Lcom/coolapk/market/widget/hotplug/BaseNineImageHotPlug;", "onViewPartLoad", "", "viewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveMessageViewHolder.kt */
public final class LiveMessageViewHolder$nineImageHotPlug$1 extends BaseNineImageHotPlug {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ LiveMessageViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveMessageViewHolder$nineImageHotPlug$1(LiveMessageViewHolder liveMessageViewHolder, DataBindingComponent dataBindingComponent, View view, DataBindingComponent dataBindingComponent2) {
        super(view, dataBindingComponent2, null, false, 12, null);
        this.this$0 = liveMessageViewHolder;
        this.$component = dataBindingComponent;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.BaseNineImageHotPlug
    public void onViewPartLoad(NinePicViewPart ninePicViewPart) {
        Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
        super.onViewPartLoad(ninePicViewPart);
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(ninePicViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = ConvertUtils.dp2px(8.0f);
            marginParams.leftMargin = 0;
            marginParams.rightMargin = 0;
            marginParams.bottomMargin = 0;
            marginParams.width = NumberExtendsKt.getDp((Number) 176);
        }
        ninePicViewPart.setMaxShowCount(9);
        ninePicViewPart.setConstrainMaxHeightWhenOne(NumberExtendsKt.getDp((Number) 176));
    }
}
