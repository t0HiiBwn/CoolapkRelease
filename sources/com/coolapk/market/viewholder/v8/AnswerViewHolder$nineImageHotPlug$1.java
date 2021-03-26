package com.coolapk.market.viewholder.v8;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.hotplug.BaseNineImageHotPlug;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/AnswerViewHolder$nineImageHotPlug$1", "Lcom/coolapk/market/widget/hotplug/BaseNineImageHotPlug;", "onViewPartLoad", "", "viewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AnswerViewHolder.kt */
public final class AnswerViewHolder$nineImageHotPlug$1 extends BaseNineImageHotPlug {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ AnswerViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnswerViewHolder$nineImageHotPlug$1(AnswerViewHolder answerViewHolder, DataBindingComponent dataBindingComponent, View view, DataBindingComponent dataBindingComponent2) {
        super(view, dataBindingComponent2, null, false, 12, null);
        this.this$0 = answerViewHolder;
        this.$component = dataBindingComponent;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.BaseNineImageHotPlug
    public void onViewPartLoad(NinePicViewPart ninePicViewPart) {
        Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
        super.onViewPartLoad(ninePicViewPart);
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(ninePicViewPart.getView());
        if (marginParams != null) {
            marginParams.bottomMargin = 0;
            marginParams.topMargin = DisplayUtils.dp2px(this.this$0.getContext(), 8.0f);
        }
        ninePicViewPart.setMaxShowCount(3);
        ninePicViewPart.setImageViewClickable(false);
    }
}
