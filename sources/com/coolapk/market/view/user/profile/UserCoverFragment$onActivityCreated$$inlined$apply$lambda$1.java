package com.coolapk.market.view.user.profile;

import androidx.recyclerview.widget.GridLayoutManager;
import com.coolapk.market.model.HolderItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/user/profile/UserCoverFragment$onActivityCreated$4$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserCoverFragment.kt */
public final class UserCoverFragment$onActivityCreated$$inlined$apply$lambda$1 extends GridLayoutManager.SpanSizeLookup {
    final /* synthetic */ UserCoverFragment this$0;

    UserCoverFragment$onActivityCreated$$inlined$apply$lambda$1(UserCoverFragment userCoverFragment) {
        this.this$0 = userCoverFragment;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        HolderItem holderItem = (HolderItem) this.this$0.getDataList().get(i);
        Intrinsics.checkNotNullExpressionValue(holderItem, "data");
        return Intrinsics.areEqual(holderItem.getEntityType(), "holder_type_title") ? 2 : 1;
    }
}
