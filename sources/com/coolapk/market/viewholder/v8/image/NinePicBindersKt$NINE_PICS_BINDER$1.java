package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/NinePicBindersKt$NINE_PICS_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicBinders.kt */
public final class NinePicBindersKt$NINE_PICS_BINDER$1 extends ImageBinder {
    NinePicBindersKt$NINE_PICS_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        ImageArgs imageArgs = getImagePreArgs().get(0);
        Intrinsics.checkNotNullExpressionValue(imageArgs, "imagePreArgs[0]");
        ImageArgs imageArgs2 = imageArgs;
        ImageArgs imageArgs3 = getImagePreArgs().get(1);
        Intrinsics.checkNotNullExpressionValue(imageArgs3, "imagePreArgs[1]");
        ImageArgs imageArgs4 = getImagePreArgs().get(2);
        Intrinsics.checkNotNullExpressionValue(imageArgs4, "imagePreArgs[2]");
        ImageArgs imageArgs5 = getImagePreArgs().get(3);
        Intrinsics.checkNotNullExpressionValue(imageArgs5, "imagePreArgs[3]");
        ImageArgs imageArgs6 = imageArgs5;
        ImageArgs imageArgs7 = getImagePreArgs().get(4);
        Intrinsics.checkNotNullExpressionValue(imageArgs7, "imagePreArgs[4]");
        ImageArgs imageArgs8 = imageArgs7;
        ImageArgs imageArgs9 = getImagePreArgs().get(5);
        Intrinsics.checkNotNullExpressionValue(imageArgs9, "imagePreArgs[5]");
        ImageArgs imageArgs10 = imageArgs9;
        ImageArgs imageArgs11 = getImagePreArgs().get(6);
        Intrinsics.checkNotNullExpressionValue(imageArgs11, "imagePreArgs[6]");
        ImageArgs imageArgs12 = imageArgs11;
        ImageArgs imageArgs13 = getImagePreArgs().get(7);
        Intrinsics.checkNotNullExpressionValue(imageArgs13, "imagePreArgs[7]");
        ImageArgs imageArgs14 = imageArgs13;
        ImageArgs imageArgs15 = getImagePreArgs().get(8);
        Intrinsics.checkNotNullExpressionValue(imageArgs15, "imagePreArgs[8]");
        float f2 = (float) 2;
        float f3 = (float) 3;
        float divider = (f - (ImageBinder.Companion.getDIVIDER() * f2)) / f3;
        ImageArgs.setResult$default(imageArgs2, divider, divider, 0.0f, 0.0f, 1, 12, null);
        ImageArgs.setResult$default(imageArgs3, divider, divider, divider + ImageBinder.Companion.getDIVIDER(), 0.0f, 0, 16, null);
        float f4 = divider * f2;
        imageArgs4.setResult(divider, divider, f4 + (ImageBinder.Companion.getDIVIDER() * f2), 0.0f, 2);
        ImageArgs.setResult$default(imageArgs6, divider, divider, 0.0f, divider + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
        ImageArgs.setResult$default(imageArgs8, divider, divider, divider + ImageBinder.Companion.getDIVIDER(), divider + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
        ImageArgs.setResult$default(imageArgs10, divider, divider, f4 + (f2 * ImageBinder.Companion.getDIVIDER()), divider + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
        imageArgs12.setResult(divider, divider, 0.0f, f4 + (ImageBinder.Companion.getDIVIDER() * f2), 4);
        ImageArgs.setResult$default(imageArgs14, divider, divider, divider + ImageBinder.Companion.getDIVIDER(), f4 + (ImageBinder.Companion.getDIVIDER() * f2), 0, 16, null);
        imageArgs15.setResult(divider, divider, f4 + (f2 * ImageBinder.Companion.getDIVIDER()), f4 + (ImageBinder.Companion.getDIVIDER() * f2), 8);
        setOutContainerHeight((f3 * divider) + (ImageBinder.Companion.getDIVIDER() * f2));
    }
}
