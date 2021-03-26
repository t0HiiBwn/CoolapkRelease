package com.coolapk.market.view.center;

import android.app.Activity;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.RecentHistory;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: RecentHistoryEvent.kt */
final class RecentHistoryProcessor$removeAllFromRecent$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ RecentHistory $recentHistory;

    RecentHistoryProcessor$removeAllFromRecent$1(Activity activity, RecentHistory recentHistory) {
        this.$activity = activity;
        this.$recentHistory = recentHistory;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataManager.getInstance().clearRecentHistory().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>(this) {
            /* class com.coolapk.market.view.center.RecentHistoryProcessor$removeAllFromRecent$1.AnonymousClass1 */
            final /* synthetic */ RecentHistoryProcessor$removeAllFromRecent$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            public void onNext(String str) {
                super.onNext((AnonymousClass1) str);
                Toast.show$default(this.this$0.$activity, str, 0, false, 12, null);
                EventBus.getDefault().post(new RecentHistoryEvent(this.this$0.$recentHistory, "clear"));
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(this.this$0.$activity, th);
            }
        });
    }
}
