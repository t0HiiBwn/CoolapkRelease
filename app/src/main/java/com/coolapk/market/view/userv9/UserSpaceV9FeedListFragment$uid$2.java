package com.coolapk.market.view.userv9;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserFeedListFragment.kt */
final class UserSpaceV9FeedListFragment$uid$2 extends Lambda implements Function0<String> {
    final /* synthetic */ UserSpaceV9FeedListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserSpaceV9FeedListFragment$uid$2(UserSpaceV9FeedListFragment userSpaceV9FeedListFragment) {
        super(0);
        this.this$0 = userSpaceV9FeedListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String string = this.this$0.requireArguments().getString("UID");
        Intrinsics.checkNotNull(string);
        return string;
    }
}
