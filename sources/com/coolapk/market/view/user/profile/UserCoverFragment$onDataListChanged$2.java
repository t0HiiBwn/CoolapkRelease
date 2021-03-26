package com.coolapk.market.view.user.profile;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserCoverFragment.kt */
final class UserCoverFragment$onDataListChanged$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ List $holderList;
    final /* synthetic */ UserCoverFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserCoverFragment$onDataListChanged$2(UserCoverFragment userCoverFragment, List list) {
        super(0);
        this.this$0 = userCoverFragment;
        this.$holderList = list;
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        this.this$0.getDataList().clear();
        return this.this$0.getDataList().addAll(this.$holderList);
    }
}
