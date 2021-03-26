package com.coolapk.market.viewholder.v8.image;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/image/CoolPicViewPartKt$T4_V3_H1_BINDER$1", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "calculate", "", "maxWidth", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
public final class CoolPicViewPartKt$T4_V3_H1_BINDER$1 extends ImageBinder {
    CoolPicViewPartKt$T4_V3_H1_BINDER$1() {
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        Object obj;
        float f2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getImagePreArgs());
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!((ImageArgs) obj).isVertical()) {
                break;
            }
        }
        if (obj != null) {
            ImageArgs imageArgs = (ImageArgs) obj;
            arrayList.remove(imageArgs);
            ImageArgs imageArgs2 = getImagePreArgs().get(0);
            if (!imageArgs2.isVertical()) {
                imageArgs2 = getImagePreArgs().get(3);
            }
            Intrinsics.checkNotNullExpressionValue(imageArgs2, "imagePreArgs.get(0).run …lse imagePreArgs.get(3) }");
            arrayList.remove(imageArgs2);
            Object obj2 = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj2, "argsCopy.get(0)");
            ImageArgs imageArgs3 = (ImageArgs) obj2;
            Object obj3 = arrayList.get(1);
            Intrinsics.checkNotNullExpressionValue(obj3, "argsCopy.get(1)");
            ImageArgs imageArgs4 = (ImageArgs) obj3;
            float divider = (((f - ImageBinder.Companion.getDIVIDER()) + ((ImageBinder.Companion.getDIVIDER() * imageArgs2.getInRatio()) / (imageArgs3.getInRatio() + imageArgs4.getInRatio()))) - (ImageBinder.Companion.getDIVIDER() * imageArgs2.getInRatio())) / ((imageArgs.getInRatio() + imageArgs2.getInRatio()) + ((imageArgs.getInRatio() * imageArgs2.getInRatio()) / (imageArgs3.getInRatio() + imageArgs4.getInRatio())));
            float inRatio = divider * imageArgs.getInRatio();
            float divider2 = (f - inRatio) - ImageBinder.Companion.getDIVIDER();
            float inRatio2 = divider2 / imageArgs2.getInRatio();
            float divider3 = (inRatio2 - divider) - ImageBinder.Companion.getDIVIDER();
            ImageArgs.setResult$default(imageArgs, inRatio, divider, 0.0f, 0.0f, 0, 28, null);
            ImageArgs.setResult$default(imageArgs3, imageArgs3.getInRatio() * divider3, divider3, 0.0f, divider + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
            ImageArgs.setResult$default(imageArgs4, divider3 * imageArgs4.getInRatio(), divider3, imageArgs3.getOutWidth() + ImageBinder.Companion.getDIVIDER(), divider + ImageBinder.Companion.getDIVIDER(), 0, 16, null);
            if (getImagePreArgs().get(0).isVertical()) {
                imageArgs.offset(divider2 + ImageBinder.Companion.getDIVIDER(), 0.0f);
                imageArgs3.offset(divider2 + ImageBinder.Companion.getDIVIDER(), 0.0f);
                imageArgs4.offset(divider2 + ImageBinder.Companion.getDIVIDER(), 0.0f);
                f2 = inRatio2;
                ImageArgs.setResult$default(imageArgs2, divider2, inRatio2, 0.0f, 0.0f, 0, 28, null);
                imageArgs2.setFlag(5);
                imageArgs.setFlag(2);
                imageArgs4.setFlag(8);
            } else {
                f2 = inRatio2;
                ImageArgs.setResult$default(imageArgs2, divider2, f2, inRatio + ImageBinder.Companion.getDIVIDER(), 0.0f, 0, 24, null);
                imageArgs2.setFlag(10);
                imageArgs.setFlag(1);
                imageArgs3.setFlag(4);
            }
            setOutContainerHeight(f2);
            return;
        }
        throw new RuntimeException("Choose a wrong binder!!!");
    }
}
