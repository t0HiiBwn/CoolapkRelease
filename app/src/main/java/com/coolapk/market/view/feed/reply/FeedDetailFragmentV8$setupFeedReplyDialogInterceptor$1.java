package com.coolapk.market.view.feed.reply;

import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailFragmentV8.kt */
final class FeedDetailFragmentV8$setupFeedReplyDialogInterceptor$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FeedReplyTopDialogInterceptor $interceptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailFragmentV8$setupFeedReplyDialogInterceptor$1(FeedReplyTopDialogInterceptor feedReplyTopDialogInterceptor) {
        super(0);
        this.$interceptor = feedReplyTopDialogInterceptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        SheetGroupModifierManager.INSTANCE.removeModifier(this.$interceptor);
    }
}
