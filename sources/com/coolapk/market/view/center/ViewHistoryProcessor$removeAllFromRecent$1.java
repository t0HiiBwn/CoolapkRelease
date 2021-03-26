package com.coolapk.market.view.center;

import android.app.Activity;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewHistoryEvent.kt */
final class ViewHistoryProcessor$removeAllFromRecent$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ UserHistory $history;

    ViewHistoryProcessor$removeAllFromRecent$1(Activity activity, UserHistory userHistory) {
        this.$activity = activity;
        this.$history = userHistory;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataManager.getInstance().delAllHistory().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>(this) {
            /* class com.coolapk.market.view.center.ViewHistoryProcessor$removeAllFromRecent$1.AnonymousClass1 */
            final /* synthetic */ ViewHistoryProcessor$removeAllFromRecent$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            public void onNext(String str) {
                super.onNext((AnonymousClass1) str);
                Toast.show$default(this.this$0.$activity, str, 0, false, 12, null);
                EventBus.getDefault().post(new ViewHistoryDeleteEvent(this.this$0.$history, "clear"));
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(this.this$0.$activity, th);
            }
        });
    }
}
