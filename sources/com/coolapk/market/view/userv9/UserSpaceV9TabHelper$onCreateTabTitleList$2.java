package com.coolapk.market.view.userv9;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/userv9/UserSpaceV9TabHelper;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9TabHelper.kt */
final class UserSpaceV9TabHelper$onCreateTabTitleList$2 extends Lambda implements Function1<UserSpaceV9TabHelper, Object> {
    final /* synthetic */ ArrayList $list;
    final /* synthetic */ UserSpaceV9TabHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserSpaceV9TabHelper$onCreateTabTitleList$2(UserSpaceV9TabHelper userSpaceV9TabHelper, ArrayList arrayList) {
        super(1);
        this.this$0 = userSpaceV9TabHelper;
        this.$list = arrayList;
    }

    public final Object invoke(UserSpaceV9TabHelper userSpaceV9TabHelper) {
        Intrinsics.checkNotNullParameter(userSpaceV9TabHelper, "it");
        return Boolean.valueOf(this.$list.add(Integer.valueOf(this.this$0.getVIEW_PAGER_ALBUM())));
    }
}
