package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/NinePicBindersKt$TRIPLE_EXPANDED_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicBinders.kt */
public final class NinePicBindersKt$TRIPLE_EXPANDED_BINDER$1 extends ImageBinder {
    NinePicBindersKt$TRIPLE_EXPANDED_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        ImageArgs imageArgs = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 0);
        ImageArgs imageArgs2 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 1);
        ImageArgs imageArgs3 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 2);
        float f2 = (float) 2;
        float divider = (f - (ImageBinder.Companion.getDIVIDER() * f2)) / ((float) 3);
        float f3 = (divider / ((float) 9)) * ((float) 16);
        if (imageArgs != null) {
            ImageArgs.setResult$default(imageArgs, divider, f3, 0.0f, 0.0f, 5, 12, null);
        }
        if (imageArgs2 != null) {
            imageArgs2.setResult(divider, f3, divider + ImageBinder.Companion.getDIVIDER(), 0.0f, 0);
        }
        if (imageArgs3 != null) {
            imageArgs3.setResult(divider, f3, (divider * f2) + (f2 * ImageBinder.Companion.getDIVIDER()), 0.0f, 10);
        }
        setOutContainerHeight(f3);
    }
}
