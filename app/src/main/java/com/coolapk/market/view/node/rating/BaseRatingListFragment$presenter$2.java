package com.coolapk.market.view.node.rating;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseRatingListFragment.kt */
final class BaseRatingListFragment$presenter$2 extends Lambda implements Function0<NodeRatingPresenter> {
    final /* synthetic */ BaseRatingListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseRatingListFragment$presenter$2(BaseRatingListFragment baseRatingListFragment) {
        super(0);
        this.this$0 = baseRatingListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NodeRatingPresenter invoke() {
        Bundle arguments = this.this$0.getArguments();
        String string = arguments != null ? arguments.getString("target_type") : null;
        Bundle arguments2 = this.this$0.getArguments();
        String string2 = arguments2 != null ? arguments2.getString("target_id") : null;
        Bundle arguments3 = this.this$0.getArguments();
        String string3 = arguments3 != null ? arguments3.getString("target_version") : null;
        Bundle arguments4 = this.this$0.getArguments();
        String string4 = arguments4 != null ? arguments4.getString("uid") : null;
        Bundle arguments5 = this.this$0.getArguments();
        int i = arguments5 != null ? arguments5.getInt("show_buyStatus", -1) : -1;
        Bundle arguments6 = this.this$0.getArguments();
        return new NodeRatingPresenter(new NodeRatingArgs(null, string, string2, string3, false, string4, null, null, i, arguments6 != null ? arguments6.getInt("show_ownerStatus", -1) : -1, 209, null), this.this$0);
    }
}
