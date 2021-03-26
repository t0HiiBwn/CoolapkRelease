package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.ImageUrl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/ImageUrl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RatingContentHolderVX1.kt */
final class RatingContentHolderVX1$generateDraftCopy$3 extends Lambda implements Function1<ImageUrl, CharSequence> {
    public static final RatingContentHolderVX1$generateDraftCopy$3 INSTANCE = new RatingContentHolderVX1$generateDraftCopy$3();

    RatingContentHolderVX1$generateDraftCopy$3() {
        super(1);
    }

    public final CharSequence invoke(ImageUrl imageUrl) {
        Intrinsics.checkNotNullExpressionValue(imageUrl, "it");
        String sourceUrl = imageUrl.getSourceUrl();
        Intrinsics.checkNotNullExpressionValue(sourceUrl, "it.sourceUrl");
        return sourceUrl;
    }
}
