package com.coolapk.market.view.feed;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedCensorEvent;
import com.coolapk.market.model.SimpleInfo;
import com.coolapk.market.view.feed.FeedItemDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/FeedItemDialog$CensorActionItem$takeAction$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/SimpleInfo;", "onError", "", "e", "", "onNext", "info", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedItemDialog.kt */
public final class FeedItemDialog$CensorActionItem$takeAction$1 extends EmptySubscriber<SimpleInfo> {
    final /* synthetic */ FeedItemDialog.CensorActionItem this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedItemDialog$CensorActionItem$takeAction$1(FeedItemDialog.CensorActionItem censorActionItem) {
        this.this$0 = censorActionItem;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        Toast.error(AppHolder.getApplication(), th);
    }

    public void onNext(SimpleInfo simpleInfo) {
        Intrinsics.checkNotNullParameter(simpleInfo, "info");
        super.onNext((FeedItemDialog$CensorActionItem$takeAction$1) simpleInfo);
        Toast.show$default(AppHolder.getApplication(), "催审成功", 0, false, 12, null);
        EventBus eventBus = EventBus.getDefault();
        String id = this.this$0.getFeed().getId();
        Intrinsics.checkNotNull(id);
        Intrinsics.checkNotNullExpressionValue(id, "feed.id!!");
        eventBus.post(new FeedCensorEvent(id, -21, simpleInfo));
    }
}
