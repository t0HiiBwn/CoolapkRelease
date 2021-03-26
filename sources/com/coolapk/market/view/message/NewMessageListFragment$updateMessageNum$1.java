package com.coolapk.market.view.message;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.NotifyCount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/message/NewMessageListFragment$updateMessageNum$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/NotifyCount;", "onNext", "", "notifyCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
public final class NewMessageListFragment$updateMessageNum$1 extends EmptySubscriber<NotifyCount> {
    final /* synthetic */ NewMessageListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NewMessageListFragment$updateMessageNum$1(NewMessageListFragment newMessageListFragment) {
        this.this$0 = newMessageListFragment;
    }

    public void onNext(NotifyCount notifyCount) {
        String str;
        super.onNext((NewMessageListFragment$updateMessageNum$1) notifyCount);
        if (notifyCount != null) {
            int message = notifyCount.getMessage();
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            if (message > 0) {
                str = "私信（" + message + (char) 65289;
            } else {
                str = "私信";
            }
            requireActivity.setTitle(str);
        }
    }
}
