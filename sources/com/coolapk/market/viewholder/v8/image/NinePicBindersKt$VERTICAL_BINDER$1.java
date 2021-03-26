package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/NinePicBindersKt$VERTICAL_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicBinders.kt */
public final class NinePicBindersKt$VERTICAL_BINDER$1 extends ImageBinder {
    NinePicBindersKt$VERTICAL_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        float f2 = 0.0f;
        int i = 0;
        for (T t : getImagePreArgs()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            float inRatio = t2.getInRatio();
            if (inRatio < 0.45f) {
                inRatio = 0.45f;
            }
            float f3 = f / inRatio;
            if (i != 0) {
                f2 += ImageBinder.Companion.getDIVIDER() * ((float) 4);
            }
            t2.setResult(f, f3, 0.0f, f2, 15);
            f2 += f3;
            i = i2;
        }
        setOutContainerHeight(f2);
    }
}
