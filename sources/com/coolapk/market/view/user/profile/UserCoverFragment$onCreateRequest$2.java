package com.coolapk.market.view.user.profile;

import com.coolapk.market.model.HolderItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "it", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserCoverFragment.kt */
final class UserCoverFragment$onCreateRequest$2<T, R> implements Func1<List<? extends HolderItem>, List<? extends HolderItem>> {
    final /* synthetic */ UserCoverFragment this$0;

    UserCoverFragment$onCreateRequest$2(UserCoverFragment userCoverFragment) {
        this.this$0 = userCoverFragment;
    }

    public final List<HolderItem> call(List<? extends HolderItem> list) {
        UserCoverPresenter userCoverPresenter = this.this$0.getPresenter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        return userCoverPresenter.processDataList(list);
    }
}
