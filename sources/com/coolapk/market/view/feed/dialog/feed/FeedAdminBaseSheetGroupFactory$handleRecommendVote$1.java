package com.coolapk.market.view.feed.dialog.feed;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedVoteRecommendEvent;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory$handleRecommendVote$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdminBaseSheetGroupFactory.kt */
public final class FeedAdminBaseSheetGroupFactory$handleRecommendVote$1 extends EmptySubscriber<String> {
    final /* synthetic */ String $commentId;
    final /* synthetic */ int $recommend;
    final /* synthetic */ String $voteId;
    final /* synthetic */ FeedAdminBaseSheetGroupFactory this$0;

    FeedAdminBaseSheetGroupFactory$handleRecommendVote$1(FeedAdminBaseSheetGroupFactory feedAdminBaseSheetGroupFactory, int i, String str, String str2) {
        this.this$0 = feedAdminBaseSheetGroupFactory;
        this.$recommend = i;
        this.$commentId = str;
        this.$voteId = str2;
    }

    public void onNext(String str) {
        super.onNext((FeedAdminBaseSheetGroupFactory$handleRecommendVote$1) str);
        Toast.show$default(this.this$0.getActivity(), this.$recommend == 0 ? "取消精选观点成功" : "设为精选观点成功", 0, false, 12, null);
        EventBus eventBus = EventBus.getDefault();
        String str2 = this.$commentId;
        String str3 = this.$voteId;
        boolean z = true;
        if (this.$recommend != 1) {
            z = false;
        }
        eventBus.post(new FeedVoteRecommendEvent(str2, str3, z));
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.this$0.getActivity(), th);
    }
}
