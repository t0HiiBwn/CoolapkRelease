package com.coolapk.market.view.notification;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Notification;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/notification/NotificationListFragment$deleteAllNotification$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "s", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NotificationListFragment.kt */
public final class NotificationListFragment$deleteAllNotification$1 extends EmptySubscriber<String> {
    final /* synthetic */ NotificationListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NotificationListFragment$deleteAllNotification$1(NotificationListFragment notificationListFragment) {
        this.this$0 = notificationListFragment;
    }

    public void onNext(String str) {
        int i = 0;
        while (i < this.this$0.getDataList().size()) {
            if (this.this$0.getDataList().get(i) instanceof Notification) {
                this.this$0.getDataList().remove(i);
                i--;
            }
            i++;
        }
        if (CollectionUtils.safeSize(this.this$0.getDataList()) == 1) {
            this.this$0.addHintView("你还没有收到通知", null);
        }
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
    }
}
