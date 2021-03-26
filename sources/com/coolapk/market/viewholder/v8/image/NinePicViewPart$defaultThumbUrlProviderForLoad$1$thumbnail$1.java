package com.coolapk.market.viewholder.v8.image;

import com.coolapk.market.viewholder.v8.image.ImageArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final /* synthetic */ class NinePicViewPart$defaultThumbUrlProviderForLoad$1$thumbnail$1 extends FunctionReferenceImpl implements Function1<String, String> {
    NinePicViewPart$defaultThumbUrlProviderForLoad$1$thumbnail$1(ImageArgs.Companion companion) {
        super(1, companion, ImageArgs.Companion.class, "smallSizeProvider", "smallSizeProvider(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p1");
        return ((ImageArgs.Companion) this.receiver).smallSizeProvider(str);
    }
}
