package com.coolapk.market.view.feed;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.node.rating.NodeRatingDeleteEvent;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/NodeRatingDialog$deleteNodeRating$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeRatingDialog.kt */
public final class NodeRatingDialog$deleteNodeRating$1 extends EmptySubscriber<String> {
    final /* synthetic */ NodeRating $data;
    final /* synthetic */ UserInfo $userInfo;
    final /* synthetic */ NodeRatingDialog this$0;

    NodeRatingDialog$deleteNodeRating$1(NodeRatingDialog nodeRatingDialog, UserInfo userInfo, NodeRating nodeRating) {
        this.this$0 = nodeRatingDialog;
        this.$userInfo = userInfo;
        this.$data = nodeRating;
    }

    public void onNext(String str) {
        super.onNext((NodeRatingDialog$deleteNodeRating$1) str);
        Toast.show$default(this.this$0.getActivity(), str, 0, false, 12, null);
        EventBus.getDefault().post(new NodeRatingDeleteEvent(this.$userInfo.getUid(), this.$data.getTargetType(), this.$data.getTargetId()));
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Toast.error(this.this$0.getActivity(), th);
    }
}
