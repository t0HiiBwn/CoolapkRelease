package com.coolapk.market.view.feed.dialog.feed;

import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedUserSheetGroupFactory.kt */
final class FeedUserSheetGroupFactory$onSheetClick$dialog$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Feed $feed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedUserSheetGroupFactory$onSheetClick$dialog$1(Feed feed) {
        super(1);
        this.$feed = feed;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke(str);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        Feed build = Feed.newBuilder(this.$feed).editorTitle(str).build();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        eventBus.post(new FeedPostEvent(build, null, null, 6, null));
    }
}
