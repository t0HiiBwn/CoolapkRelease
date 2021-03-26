package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/NinePicBindersKt$AUTO_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicBinders.kt */
public final class NinePicBindersKt$AUTO_BINDER$1 extends ImageBinder {
    NinePicBindersKt$AUTO_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        float f2;
        float f3;
        int i;
        NinePicBindersKt$AUTO_BINDER$1 ninePicBindersKt$AUTO_BINDER$1;
        float f4;
        float f5;
        float f6;
        ImageArgs imageArgs = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 0);
        ImageArgs imageArgs2 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 1);
        ImageArgs imageArgs3 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 2);
        ImageArgs imageArgs4 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 3);
        ImageArgs imageArgs5 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 4);
        ImageArgs imageArgs6 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 5);
        ImageArgs imageArgs7 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 6);
        ImageArgs imageArgs8 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 7);
        ImageArgs imageArgs9 = (ImageArgs) CollectionsKt.getOrNull(getImagePreArgs(), 8);
        float f7 = (float) 2;
        float f8 = (float) 3;
        float divider = (f - (ImageBinder.Companion.getDIVIDER() * f7)) / f8;
        if (imageArgs != null) {
            ImageArgs.setResult$default(imageArgs, divider, divider, 0.0f, 0.0f, 15, 12, null);
        }
        if (imageArgs2 != null) {
            imageArgs2.setResult(divider, divider, divider + ImageBinder.Companion.getDIVIDER(), 0.0f, 15);
        }
        if (imageArgs3 != null) {
            imageArgs3.setResult(divider, divider, (divider * f7) + (ImageBinder.Companion.getDIVIDER() * f7), 0.0f, 15);
        }
        if (imageArgs4 != null) {
            f3 = f8;
            f2 = f7;
            i = 6;
            imageArgs4.setResult(divider, divider, 0.0f, divider + ImageBinder.Companion.getDIVIDER(), 15);
        } else {
            f3 = f8;
            f2 = f7;
            i = 6;
        }
        if (imageArgs5 != null) {
            imageArgs5.setResult(divider, divider, divider + ImageBinder.Companion.getDIVIDER(), divider + ImageBinder.Companion.getDIVIDER(), 15);
        }
        if (imageArgs6 != null) {
            imageArgs6.setResult(divider, divider, (divider * f2) + (ImageBinder.Companion.getDIVIDER() * f2), divider + ImageBinder.Companion.getDIVIDER(), 15);
        }
        if (imageArgs7 != null) {
            imageArgs7.setResult(divider, divider, 0.0f, (f2 * divider) + (ImageBinder.Companion.getDIVIDER() * f2), 15);
        }
        if (imageArgs8 != null) {
            imageArgs8.setResult(divider, divider, divider + ImageBinder.Companion.getDIVIDER(), (f2 * divider) + (ImageBinder.Companion.getDIVIDER() * f2), 15);
        }
        if (imageArgs9 != null) {
            float f9 = divider * f2;
            imageArgs9.setResult(divider, divider, f9 + (ImageBinder.Companion.getDIVIDER() * f2), f9 + (ImageBinder.Companion.getDIVIDER() * f2), 15);
        }
        int size = getImagePreArgs().size();
        if (size == 0) {
            f4 = 0.0f;
            ninePicBindersKt$AUTO_BINDER$1 = this;
        } else {
            if (size > 3) {
                if (size <= i) {
                    divider = (f2 * divider) + ImageBinder.Companion.getDIVIDER();
                } else {
                    if (size <= 9) {
                        f5 = f3 * divider;
                        f6 = ImageBinder.Companion.getDIVIDER();
                    } else {
                        f5 = f3 * divider;
                        f6 = ImageBinder.Companion.getDIVIDER();
                    }
                    divider = f5 + (f6 * f2);
                }
            }
            ninePicBindersKt$AUTO_BINDER$1 = this;
            f4 = divider;
        }
        ninePicBindersKt$AUTO_BINDER$1.setOutContainerHeight(f4);
    }
}
