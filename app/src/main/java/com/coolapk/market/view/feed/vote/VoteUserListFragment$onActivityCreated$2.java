package com.coolapk.market.view.feed.vote;

import com.coolapk.market.model.User;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteUserListFragment.kt */
final class VoteUserListFragment$onActivityCreated$2 extends Lambda implements Function1<Object, Boolean> {
    public static final VoteUserListFragment$onActivityCreated$2 INSTANCE = new VoteUserListFragment$onActivityCreated$2();

    VoteUserListFragment$onActivityCreated$2() {
        super(1);
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return obj instanceof User;
    }
}
