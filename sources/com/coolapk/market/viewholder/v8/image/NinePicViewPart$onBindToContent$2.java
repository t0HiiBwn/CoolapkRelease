package com.coolapk.market.viewholder.v8.image;

import com.coolapk.market.databinding.ItemCoolPicImageViewBinding;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.PausableTask;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/viewholder/v8/image/NinePicViewPart$onBindToContent$2", "Lcom/coolapk/market/widget/PausableTask;", "run", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
public final class NinePicViewPart$onBindToContent$2 extends PausableTask {
    final /* synthetic */ int $requireCount;
    final /* synthetic */ NinePicViewPart this$0;

    NinePicViewPart$onBindToContent$2(NinePicViewPart ninePicViewPart, int i) {
        this.this$0 = ninePicViewPart;
        this.$requireCount = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int recycledViewPartCount = this.this$0.viewPool.getRecycledViewPartCount(2131558714);
        if (recycledViewPartCount < this.$requireCount) {
            ArrayList<ViewPart> arrayList = new ArrayList();
            int i = this.$requireCount - recycledViewPartCount;
            for (int i2 = 0; i2 < i; i2++) {
                NinePicViewPart ninePicViewPart = this.this$0;
                MaxWidthFrameLayout maxWidthFrameLayout = ((ItemCoolPicImageViewBinding) ninePicViewPart.getBinding()).frameView;
                Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
                arrayList.add(ninePicViewPart.getUnusedImageViewPart(maxWidthFrameLayout));
                checkNeedPause(false);
            }
            for (ViewPart viewPart : arrayList) {
                this.this$0.viewPool.putRecycledViewPart(viewPart, 2131558714);
            }
        }
    }
}
