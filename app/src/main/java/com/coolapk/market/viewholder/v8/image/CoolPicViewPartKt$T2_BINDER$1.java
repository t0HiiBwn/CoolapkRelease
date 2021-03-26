package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/CoolPicViewPartKt$T2_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
public final class CoolPicViewPartKt$T2_BINDER$1 extends ImageBinder {
    CoolPicViewPartKt$T2_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        ImageArgs imageArgs = getImagePreArgs().get(0);
        Intrinsics.checkNotNullExpressionValue(imageArgs, "imagePreArgs.get(0)");
        ImageArgs imageArgs2 = imageArgs;
        ImageArgs imageArgs3 = getImagePreArgs().get(1);
        Intrinsics.checkNotNullExpressionValue(imageArgs3, "imagePreArgs.get(1)");
        float divider = (f - ImageBinder.Companion.getDIVIDER()) / 1.5f;
        float f2 = 0.75f * divider;
        ImageArgs.setResult$default(imageArgs2, f2, divider, 0.0f, 0.0f, 5, 12, null);
        ImageArgs.setResult$default(imageArgs3, f2, divider, f2 + ImageBinder.Companion.getDIVIDER(), 0.0f, 10, 8, null);
        setOutContainerHeight(divider);
    }
}
