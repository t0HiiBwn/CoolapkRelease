package com.coolapk.market.view.message;

import com.coolapk.market.model.Entity;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "lhs", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "rhs", "compare"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$sort$1<T> implements Comparator<Entity> {
    public static final ChatListFragment$sort$1 INSTANCE = new ChatListFragment$sort$1();

    ChatListFragment$sort$1() {
    }

    public final int compare(Entity entity, Entity entity2) {
        Intrinsics.checkNotNullExpressionValue(entity2, "rhs");
        Long dateline = entity2.getDateline();
        Intrinsics.checkNotNull(dateline);
        long longValue = dateline.longValue();
        Intrinsics.checkNotNullExpressionValue(entity, "lhs");
        Long dateline2 = entity.getDateline();
        Intrinsics.checkNotNull(dateline2);
        Intrinsics.checkNotNullExpressionValue(dateline2, "lhs.dateline!!");
        return Long.signum(longValue - dateline2.longValue());
    }
}
