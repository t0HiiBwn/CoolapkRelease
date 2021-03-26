package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/NinePicBindersKt$SINGLE_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicBinders.kt */
public final class NinePicBindersKt$SINGLE_BINDER$1 extends ImageBinder {
    NinePicBindersKt$SINGLE_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        float f2;
        float f3;
        ImageArgs imageArgs = getImagePreArgs().get(0);
        Intrinsics.checkNotNullExpressionValue(imageArgs, "imagePreArgs.get(0)");
        ImageArgs imageArgs2 = imageArgs;
        float inRatio = imageArgs2.getInRatio();
        if (inRatio < 0.45f) {
            inRatio = 0.45f;
        }
        if (inRatio <= 1.0f) {
            float f4 = (float) 2;
            f2 = (((f - (ImageBinder.Companion.getDIVIDER() * f4)) / ((float) 3)) * f4) + ImageBinder.Companion.getDIVIDER();
            f3 = inRatio * f2;
        } else {
            if (inRatio <= 2.0f) {
                float f5 = (float) 2;
                f = (((f - (ImageBinder.Companion.getDIVIDER() * f5)) / ((float) 3)) * f5) + ImageBinder.Companion.getDIVIDER();
            }
            f3 = f;
            f2 = f / inRatio;
        }
        ImageArgs.setResult$default(imageArgs2, f3, f2, 0.0f, 0.0f, 15, 12, null);
        setOutContainerHeight(f2);
    }
}
