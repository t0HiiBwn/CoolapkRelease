package com.coolapk.market.viewholder.v8.image;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/CoolPicViewPartKt$T3_V1H2_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
public final class CoolPicViewPartKt$T3_V1H2_BINDER$1 extends ImageBinder {
    CoolPicViewPartKt$T3_V1H2_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getImagePreArgs());
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((ImageArgs) obj).isVertical()) {
                break;
            }
        }
        if (obj != null) {
            ImageArgs imageArgs = (ImageArgs) obj;
            arrayList.remove(imageArgs);
            Object obj2 = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj2, "argsCopy.get(0)");
            ImageArgs imageArgs2 = (ImageArgs) obj2;
            Object obj3 = arrayList.get(1);
            Intrinsics.checkNotNullExpressionValue(obj3, "argsCopy.get(1)");
            float divider = ((((f - ImageBinder.Companion.getDIVIDER()) * 1.0f) * 1.0f) - (((ImageBinder.Companion.getDIVIDER() * imageArgs.getInRatio()) * 1.0f) * 1.0f)) / ((imageArgs.getInRatio() * 2.0f) + 1.0f);
            float divider2 = (f - ImageBinder.Companion.getDIVIDER()) - divider;
            ImageArgs.setResult$default(imageArgs, divider2, divider2 / imageArgs.getInRatio(), 0.0f, 0.0f, 5, 12, null);
            float f2 = divider / 1.0f;
            ImageArgs.setResult$default(imageArgs2, divider, f2, imageArgs.getOutWidth() + ImageBinder.Companion.getDIVIDER(), 0.0f, 2, 8, null);
            ((ImageArgs) obj3).setResult(divider, f2, imageArgs.getOutWidth() + ImageBinder.Companion.getDIVIDER(), imageArgs2.getOutHeight() + ImageBinder.Companion.getDIVIDER(), 8);
            setOutContainerHeight(imageArgs.getOutHeight());
            return;
        }
        throw new RuntimeException("Choose a wrong binder!!!");
    }
}
