package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final class NinePicViewPart$defaultThumbUrlProviderForLoad$1 extends Lambda implements Function1<ImageArgs, String> {
    final /* synthetic */ NinePicViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NinePicViewPart$defaultThumbUrlProviderForLoad$1(NinePicViewPart ninePicViewPart) {
        super(1);
        this.this$0 = ninePicViewPart;
    }

    public final String invoke(ImageArgs imageArgs) {
        Intrinsics.checkNotNullParameter(imageArgs, "it");
        boolean z = true;
        if (this.this$0.currentDisplayList.size() != 1) {
            z = false;
        }
        if (imageArgs.isGifUrl()) {
            if (z) {
                return ImageArgs.Companion.smallSizeProvider(imageArgs.getInSource());
            }
            return imageArgs.getSuitableUrl(new NinePicViewPart$defaultThumbUrlProviderForLoad$1$thumbnail$1(ImageArgs.Companion));
        } else if (!z) {
            return imageArgs.getSuitableUrl(new NinePicViewPart$defaultThumbUrlProviderForLoad$1$thumbnail$2(ImageArgs.Companion));
        } else {
            if (this.this$0.getFullSizeWhenOne()) {
                return ImageArgs.Companion.s2xSizeCompatProvider(imageArgs.getInSource());
            }
            return ImageArgs.Companion.smallSizeProvider(imageArgs.getInSource());
        }
    }
}
