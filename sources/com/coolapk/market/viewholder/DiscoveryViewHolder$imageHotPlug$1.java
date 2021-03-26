package com.coolapk.market.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.hotplug.BaseNineImageHotPlug;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0014J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\n"}, d2 = {"com/coolapk/market/viewholder/DiscoveryViewHolder$imageHotPlug$1", "Lcom/coolapk/market/widget/hotplug/BaseNineImageHotPlug;", "bindData", "", "viewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "data", "", "", "onViewPartLoad", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DiscoveryViewHolder.kt */
public final class DiscoveryViewHolder$imageHotPlug$1 extends BaseNineImageHotPlug {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ DiscoveryViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoveryViewHolder$imageHotPlug$1(DiscoveryViewHolder discoveryViewHolder, DataBindingComponent dataBindingComponent, View view, DataBindingComponent dataBindingComponent2) {
        super(view, dataBindingComponent2, null, false, 12, null);
        this.this$0 = discoveryViewHolder;
        this.$component = dataBindingComponent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.coolapk.market.viewholder.iview.ViewPart, java.lang.Object] */
    @Override // com.coolapk.market.widget.hotplug.BaseNineImageHotPlug, com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public /* bridge */ /* synthetic */ void bindData(NinePicViewPart ninePicViewPart, List<? extends String> list) {
        bindData(ninePicViewPart, (List<String>) list);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.BaseNineImageHotPlug
    public void onViewPartLoad(NinePicViewPart ninePicViewPart) {
        Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
        super.onViewPartLoad(ninePicViewPart);
        ViewGroup.LayoutParams layoutParams = ninePicViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ConvertUtils.dp2px(4.0f);
            marginLayoutParams.bottomMargin = ConvertUtils.dp2px(8.0f);
            marginLayoutParams.leftMargin = ConvertUtils.dp2px(8.0f);
            marginLayoutParams.rightMargin = ConvertUtils.dp2px(8.0f);
        }
        ninePicViewPart.setHorizonExpandWhenTriple(true);
        ninePicViewPart.setCenterCropWhenOne(true);
    }

    @Override // com.coolapk.market.widget.hotplug.BaseNineImageHotPlug
    protected void bindData(NinePicViewPart ninePicViewPart, List<String> list) {
        Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(list, "data");
        if (list.size() >= 3) {
            ninePicViewPart.setMaxShowCount(3);
        } else {
            ninePicViewPart.setMaxShowCount(1);
        }
        ninePicViewPart.bindToContent(list);
    }
}
