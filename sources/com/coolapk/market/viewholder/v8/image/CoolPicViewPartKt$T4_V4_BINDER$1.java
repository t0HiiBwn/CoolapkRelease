package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/CoolPicViewPartKt$T4_V4_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
public final class CoolPicViewPartKt$T4_V4_BINDER$1 extends ImageBinder {
    CoolPicViewPartKt$T4_V4_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        ImageArgs imageArgs = getImagePreArgs().get(0);
        Intrinsics.checkNotNullExpressionValue(imageArgs, "imagePreArgs.get(0)");
        ImageArgs imageArgs2 = imageArgs;
        ImageArgs imageArgs3 = getImagePreArgs().get(1);
        Intrinsics.checkNotNullExpressionValue(imageArgs3, "imagePreArgs.get(1)");
        ImageArgs imageArgs4 = imageArgs3;
        ImageArgs imageArgs5 = getImagePreArgs().get(2);
        Intrinsics.checkNotNullExpressionValue(imageArgs5, "imagePreArgs.get(2)");
        ImageArgs imageArgs6 = imageArgs5;
        ImageArgs imageArgs7 = getImagePreArgs().get(3);
        Intrinsics.checkNotNullExpressionValue(imageArgs7, "imagePreArgs.get(3)");
        ImageArgs imageArgs8 = imageArgs7;
        float f2 = (float) 2;
        float divider = ((((f - (ImageBinder.Companion.getDIVIDER() * f2)) - ((imageArgs2.getInRatio() + imageArgs4.getInRatio()) * ImageBinder.Companion.getDIVIDER())) * imageArgs6.getInRatio()) * imageArgs8.getInRatio()) / ((imageArgs2.getInRatio() + imageArgs4.getInRatio()) * ((imageArgs6.getInRatio() + imageArgs8.getInRatio()) + (imageArgs6.getInRatio() * imageArgs8.getInRatio())));
        float inRatio = divider / imageArgs6.getInRatio();
        float inRatio2 = divider / imageArgs8.getInRatio();
        float divider2 = ImageBinder.Companion.getDIVIDER() + inRatio + inRatio2;
        ImageArgs.setResult$default(imageArgs2, imageArgs2.getInRatio() * divider2, divider2, 0.0f, 0.0f, 0, 28, null);
        ImageArgs.setResult$default(imageArgs4, imageArgs4.getInRatio() * divider2, divider2, imageArgs2.getOutWidth() + ImageBinder.Companion.getDIVIDER(), 0.0f, 0, 24, null);
        float outWidth = imageArgs2.getOutWidth() + imageArgs4.getOutWidth() + (f2 * ImageBinder.Companion.getDIVIDER());
        ImageArgs.setResult$default(imageArgs6, divider, inRatio, outWidth, 0.0f, 0, 16, null);
        ImageArgs.setResult$default(imageArgs8, divider, inRatio2, outWidth, ImageBinder.Companion.getDIVIDER() + inRatio, 0, 16, null);
        setOutContainerHeight(divider2);
    }
}
