package com.coolapk.market.view.feed.vote;

import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u00012*\u0010\u0006\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "data1", "data2", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteCommentDetailListFragment.kt */
final class VoteCommentDetailListFragment$onCreateRequest$1<T1, T2, R> implements Func2<List<Entity>, List<Entity>, List<Entity>> {
    public static final VoteCommentDetailListFragment$onCreateRequest$1 INSTANCE = new VoteCommentDetailListFragment$onCreateRequest$1();

    VoteCommentDetailListFragment$onCreateRequest$1() {
    }

    public final List<Entity> call(List<Entity> list, List<Entity> list2) {
        Intrinsics.checkNotNullExpressionValue(list2, "data2");
        list.addAll(list2);
        return list;
    }
}
