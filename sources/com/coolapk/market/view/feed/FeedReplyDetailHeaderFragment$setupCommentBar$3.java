package com.coolapk.market.view.feed;

import android.graphics.Rect;
import com.coolapk.market.view.feed.reply.FeedReplyCommentBarViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailHeaderFragment.kt */
final class FeedReplyDetailHeaderFragment$setupCommentBar$3 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ FeedReplyCommentBarViewPart $viewPart;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyDetailHeaderFragment$setupCommentBar$3(FeedReplyCommentBarViewPart feedReplyCommentBarViewPart) {
        super(1);
        this.$viewPart = feedReplyCommentBarViewPart;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
        invoke(rect);
        return Unit.INSTANCE;
    }

    public final void invoke(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "it");
        this.$viewPart.insetBottom(rect.bottom);
    }
}
