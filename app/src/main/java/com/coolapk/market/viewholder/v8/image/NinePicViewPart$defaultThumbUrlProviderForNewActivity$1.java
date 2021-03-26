package com.coolapk.market.viewholder.v8.image;

import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "source", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final class NinePicViewPart$defaultThumbUrlProviderForNewActivity$1 extends Lambda implements Function1<String, String> {
    final /* synthetic */ NinePicViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NinePicViewPart$defaultThumbUrlProviderForNewActivity$1(NinePicViewPart ninePicViewPart) {
        super(1);
        this.this$0 = ninePicViewPart;
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        boolean z = false;
        boolean z2 = this.this$0.currentDisplayList.size() == 1;
        boolean z3 = this.this$0.currentDisplayList.indexOf(str) == this.this$0.handler.getCurrentGifIndex();
        if (ImageArgs.Companion.isGifPicture(str) && AppHolder.getAppSetting().shouldLoadSourcePhoto()) {
            z = true;
        }
        if (z && z3) {
            return ImageArgs.Companion.smallSizeProvider(str);
        }
        if (!z2) {
            return ImageArgs.Companion.smallSizeProvider(str);
        }
        if (this.this$0.getFullSizeWhenOne()) {
            return ImageArgs.Companion.s2xSizeCompatProvider(str);
        }
        return ImageArgs.Companion.smallSizeProvider(str);
    }
}
