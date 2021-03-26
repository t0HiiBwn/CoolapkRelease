package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/CoolPicViewPartKt$T7_OTHER_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
public final class CoolPicViewPartKt$T7_OTHER_BINDER$1 extends ImageBinder {
    CoolPicViewPartKt$T7_OTHER_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        ImageArgs imageArgs = getImagePreArgs().get(0);
        Intrinsics.checkNotNullExpressionValue(imageArgs, "imagePreArgs.get(0)");
        ImageArgs imageArgs2 = getImagePreArgs().get(1);
        Intrinsics.checkNotNullExpressionValue(imageArgs2, "imagePreArgs.get(1)");
        ImageArgs imageArgs3 = imageArgs2;
        ImageArgs imageArgs4 = getImagePreArgs().get(2);
        Intrinsics.checkNotNullExpressionValue(imageArgs4, "imagePreArgs.get(2)");
        ImageArgs imageArgs5 = imageArgs4;
        ImageArgs imageArgs6 = getImagePreArgs().get(3);
        Intrinsics.checkNotNullExpressionValue(imageArgs6, "imagePreArgs.get(3)");
        ImageArgs imageArgs7 = imageArgs6;
        ImageArgs imageArgs8 = getImagePreArgs().get(4);
        Intrinsics.checkNotNullExpressionValue(imageArgs8, "imagePreArgs.get(4)");
        ImageArgs imageArgs9 = imageArgs8;
        ImageArgs imageArgs10 = getImagePreArgs().get(5);
        Intrinsics.checkNotNullExpressionValue(imageArgs10, "imagePreArgs.get(5)");
        ImageArgs imageArgs11 = imageArgs10;
        ImageArgs imageArgs12 = getImagePreArgs().get(6);
        Intrinsics.checkNotNullExpressionValue(imageArgs12, "imagePreArgs.get(6)");
        float f2 = (f / ((float) 16)) * ((float) 9);
        float f3 = (float) 2;
        float divider = (f - (ImageBinder.Companion.getDIVIDER() * f3)) / ((float) 3);
        ImageArgs.setResult$default(imageArgs, f, f2, 0.0f, 0.0f, 3, 12, null);
        ImageArgs.setResult$default(imageArgs3, divider, divider, 0.0f, f2 + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
        ImageArgs.setResult$default(imageArgs5, divider, divider, divider + ImageBinder.Companion.getDIVIDER(), f2 + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
        float f4 = divider * f3;
        ImageArgs.setResult$default(imageArgs7, divider, divider, (f3 * ImageBinder.Companion.getDIVIDER()) + f4, f2 + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
        float f5 = f2 + divider;
        imageArgs9.setResult(divider, divider, 0.0f, f5 + (ImageBinder.Companion.getDIVIDER() * f3), 4);
        ImageArgs.setResult$default(imageArgs11, divider, divider, divider + ImageBinder.Companion.getDIVIDER(), f5 + (ImageBinder.Companion.getDIVIDER() * f3), 0, 16, null);
        imageArgs12.setResult(divider, divider, f4 + (f3 * ImageBinder.Companion.getDIVIDER()), f5 + (ImageBinder.Companion.getDIVIDER() * f3), 8);
        setOutContainerHeight(f2 + (ImageBinder.Companion.getDIVIDER() * f3) + f4);
    }
}
