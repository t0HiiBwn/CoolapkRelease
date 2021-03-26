package com.coolapk.market.viewholder.v8.image;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/CoolPicViewPartKt$T3_H3_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
public final class CoolPicViewPartKt$T3_H3_BINDER$1 extends ImageBinder {
    CoolPicViewPartKt$T3_H3_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        CoolPicViewPartKt$T1_BINDER$1 access$getT1_BINDER$p = CoolPicViewPartKt.access$getT1_BINDER$p();
        access$getT1_BINDER$p.reset();
        List<ImageArgs> subList = getImagePreArgs().subList(0, 1);
        Intrinsics.checkNotNullExpressionValue(subList, "imagePreArgs.subList(0, 1)");
        access$getT1_BINDER$p.setup(subList);
        access$getT1_BINDER$p.calculate(f);
        ImageArgs imageArgs = getImagePreArgs().get(0);
        Intrinsics.checkNotNullExpressionValue(imageArgs, "imagePreArgs.get(0)");
        ImageArgs imageArgs2 = imageArgs;
        float outHeight = imageArgs2.getOutHeight();
        ImageArgs imageArgs3 = getImagePreArgs().get(1);
        Intrinsics.checkNotNullExpressionValue(imageArgs3, "imagePreArgs.get(1)");
        ImageArgs imageArgs4 = imageArgs3;
        ImageArgs imageArgs5 = getImagePreArgs().get(2);
        Intrinsics.checkNotNullExpressionValue(imageArgs5, "imagePreArgs.get(2)");
        float divider = (f - ImageBinder.Companion.getDIVIDER()) / ((float) 2);
        imageArgs4.setResult(divider, divider, 0.0f, outHeight + ImageBinder.Companion.getDIVIDER(), 4);
        imageArgs5.setResult(divider, divider, divider + ImageBinder.Companion.getDIVIDER(), outHeight + ImageBinder.Companion.getDIVIDER(), 8);
        imageArgs2.setFlag(3);
        setOutContainerHeight(divider + ImageBinder.Companion.getDIVIDER() + outHeight);
    }
}
