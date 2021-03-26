package com.coolapk.market.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.v8.VideoViewPart;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/VideoViewHolder$videoViewHotPlug$1", "Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "onViewPartLoad", "", "viewPart", "Lcom/coolapk/market/viewholder/v8/VideoViewPart;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoViewHolder.kt */
public final class VideoViewHolder$videoViewHotPlug$1 extends BaseVideoHotPlug {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ VideoViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoViewHolder$videoViewHotPlug$1(VideoViewHolder videoViewHolder, DataBindingComponent dataBindingComponent, View view, DataBindingComponent dataBindingComponent2) {
        super(view, dataBindingComponent2, null, false, 12, null);
        this.this$0 = videoViewHolder;
        this.$component = dataBindingComponent;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.BaseVideoHotPlug
    public void onViewPartLoad(VideoViewPart videoViewPart) {
        Intrinsics.checkNotNullParameter(videoViewPart, "viewPart");
        super.onViewPartLoad(videoViewPart);
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(videoViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = ConvertUtils.dp2px(0.0f);
            marginParams.leftMargin = ConvertUtils.dp2px(0.0f);
            marginParams.rightMargin = ConvertUtils.dp2px(0.0f);
            marginParams.bottomMargin = ConvertUtils.dp2px(0.0f);
        }
    }
}
