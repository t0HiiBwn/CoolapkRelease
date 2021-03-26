package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$onActivityCreated$6 extends Lambda implements Function1<Object, Boolean> {
    public static final FeedReplyListFragmentV8$onActivityCreated$6 INSTANCE = new FeedReplyListFragmentV8$onActivityCreated$6();

    FeedReplyListFragmentV8$onActivityCreated$6() {
        super(1);
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        String str = null;
        if (!(obj instanceof Entity)) {
            obj = null;
        }
        Entity entity = (Entity) obj;
        if (entity != null) {
            str = entity.getEntityType();
        }
        return (Intrinsics.areEqual(str, "SMALL_CURRENT_TITLE") || Intrinsics.areEqual(str, "SMALL_HOT_TITLE") || Intrinsics.areEqual(str, "SMALL_NEWEST_TITLE")) ? 1 : null;
    }
}
