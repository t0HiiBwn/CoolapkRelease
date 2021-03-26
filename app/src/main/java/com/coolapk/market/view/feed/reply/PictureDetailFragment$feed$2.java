package com.coolapk.market.view.feed.reply;

import android.os.Parcelable;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/Feed;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: PictureDetailFragment.kt */
final class PictureDetailFragment$feed$2 extends Lambda implements Function0<Feed> {
    final /* synthetic */ PictureDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PictureDetailFragment$feed$2(PictureDetailFragment pictureDetailFragment) {
        super(0);
        this.this$0 = pictureDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Feed invoke() {
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("extra_feed");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…lActivityV8.EXTRA_FEED)!!");
        return (Feed) parcelable;
    }
}
