package com.coolapk.market.view.center;

import android.app.Activity;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.RecentHistory;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/center/RecentHistoryProcessor$unsetTopRecent$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecentHistoryEvent.kt */
public final class RecentHistoryProcessor$unsetTopRecent$1 extends EmptySubscriber<String> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ RecentHistory $recentHistory;

    RecentHistoryProcessor$unsetTopRecent$1(Activity activity, RecentHistory recentHistory) {
        this.$activity = activity;
        this.$recentHistory = recentHistory;
    }

    public void onNext(String str) {
        super.onNext((RecentHistoryProcessor$unsetTopRecent$1) str);
        Toast.show$default(this.$activity, str, 0, false, 12, null);
        EventBus.getDefault().post(new RecentHistoryEvent(this.$recentHistory, "unset_top"));
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.$activity, th);
    }
}
