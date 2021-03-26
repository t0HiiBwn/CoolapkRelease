package com.coolapk.market.view.live;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$startNewPoll$1<R> implements Func0<Observable<List<? extends Entity>>> {
    final /* synthetic */ LiveDiscussPoll this$0;

    LiveDiscussPoll$startNewPoll$1(LiveDiscussPoll liveDiscussPoll) {
        this.this$0 = liveDiscussPoll;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<List<Entity>> call() {
        Entity entity = this.this$0.latestLiveEntity;
        String entityId = entity != null ? entity.getEntityId() : null;
        LiveDiscussPollKt.liveDiscussPollLogD("请求API");
        if (LiveUtils.INSTANCE.isTestMultiDanmaku()) {
            return this.this$0.getFakeDanmakuData().createData().compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData());
        }
        return DataManager.getInstance().getLiveMessageList(this.this$0.liveId, "0", 0, entityId, null).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData());
    }
}
