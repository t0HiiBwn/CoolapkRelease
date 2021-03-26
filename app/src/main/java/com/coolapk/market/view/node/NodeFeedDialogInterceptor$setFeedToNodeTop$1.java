package com.coolapk.market.view.node;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/node/NodeFeedDialogInterceptor$setFeedToNodeTop$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeFeedDialogInterceptor.kt */
public final class NodeFeedDialogInterceptor$setFeedToNodeTop$1 extends EmptySubscriber<String> {
    final /* synthetic */ Feed $feed;
    final /* synthetic */ String $feedId;
    final /* synthetic */ NodeFeedDialogInterceptor this$0;

    NodeFeedDialogInterceptor$setFeedToNodeTop$1(NodeFeedDialogInterceptor nodeFeedDialogInterceptor, String str, Feed feed) {
        this.this$0 = nodeFeedDialogInterceptor;
        this.$feedId = str;
        this.$feed = feed;
    }

    public void onNext(String str) {
        super.onNext((NodeFeedDialogInterceptor$setFeedToNodeTop$1) str);
        Toast.show$default(this.this$0.getActivity(), str, 0, false, 12, null);
        this.this$0.getTopIds().remove(this.$feedId);
        EventBus.getDefault().post(new FeedTopEvent(this.$feed, this.this$0.getNodeType(), this.this$0.getNodeId(), false));
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Toast.error(this.this$0.getActivity(), th);
    }
}
