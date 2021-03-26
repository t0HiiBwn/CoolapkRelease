package com.coolapk.market.view.live;

import com.coolapk.market.manager.PushMessage;
import com.coolapk.market.model.Entity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020&J\u0014\u0010)\u001a\u0004\u0018\u00010\u0018*\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R2\u0010\u001e\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010 0  !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010 0 \u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/live/LiveDiscussPoll;", "", "liveId", "", "(Ljava/lang/String;)V", "bubbleMessenger", "Lcom/coolapk/market/view/live/BubbleMessenger;", "callback", "Lcom/coolapk/market/view/live/LiveDiscussPollCallback;", "getCallback", "()Lcom/coolapk/market/view/live/LiveDiscussPollCallback;", "setCallback", "(Lcom/coolapk/market/view/live/LiveDiscussPollCallback;)V", "enableSubscription", "Ljava/util/concurrent/atomic/AtomicBoolean;", "fakeDanmakuData", "Lcom/coolapk/market/view/live/FakeDanmakuData;", "getFakeDanmakuData", "()Lcom/coolapk/market/view/live/FakeDanmakuData;", "fakeDanmakuData$delegate", "Lkotlin/Lazy;", "isPolling", "latestDataList", "", "Lcom/coolapk/market/model/Entity;", "getLatestDataList", "()Ljava/util/List;", "setLatestDataList", "(Ljava/util/List;)V", "latestLiveEntity", "observablePushMessage", "Lrx/Observable;", "Lcom/coolapk/market/manager/PushMessage;", "kotlin.jvm.PlatformType", "subscriptionPoll", "Lrx/Subscription;", "subscriptionPushMessage", "launch", "", "startNewPoll", "stop", "findFirstLiveEntity", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
public final class LiveDiscussPoll {
    private final BubbleMessenger bubbleMessenger;
    private LiveDiscussPollCallback callback;
    private final AtomicBoolean enableSubscription = new AtomicBoolean(false);
    private final Lazy fakeDanmakuData$delegate;
    private final AtomicBoolean isPolling = new AtomicBoolean(false);
    private List<? extends Entity> latestDataList;
    private Entity latestLiveEntity;
    private final String liveId;
    private final Observable<PushMessage> observablePushMessage;
    private Subscription subscriptionPoll;
    private Subscription subscriptionPushMessage;

    /* access modifiers changed from: private */
    public final FakeDanmakuData getFakeDanmakuData() {
        return (FakeDanmakuData) this.fakeDanmakuData$delegate.getValue();
    }

    public LiveDiscussPoll(String str) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        this.liveId = str;
        BubbleMessenger bubbleMessenger2 = new BubbleMessenger(true);
        bubbleMessenger2.setLoggerable(true);
        bubbleMessenger2.setOutputListener(new LiveDiscussPoll$$special$$inlined$apply$lambda$1(this));
        Unit unit = Unit.INSTANCE;
        this.bubbleMessenger = bubbleMessenger2;
        this.fakeDanmakuData$delegate = LazyKt.lazy(LiveDiscussPoll$fakeDanmakuData$2.INSTANCE);
        this.observablePushMessage = Observable.create(LiveDiscussPoll$observablePushMessage$1.INSTANCE);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.Entity> */
    public final List<Entity> getLatestDataList() {
        return this.latestDataList;
    }

    public final void setLatestDataList(List<? extends Entity> list) {
        this.latestDataList = list;
    }

    public final LiveDiscussPollCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(LiveDiscussPollCallback liveDiscussPollCallback) {
        this.callback = liveDiscussPollCallback;
    }

    public final void stop() {
        LiveDiscussPollKt.liveDiscussPollLogD("请求停止轮训和推送接收");
        this.enableSubscription.set(false);
        Subscription subscription = this.subscriptionPushMessage;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.subscriptionPoll;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    public final void launch() {
        this.enableSubscription.set(true);
        startNewPoll();
        this.subscriptionPushMessage = this.observablePushMessage.throttleFirst(2, TimeUnit.SECONDS).skipWhile(new LiveDiscussPoll$launch$1(this)).doOnSubscribe(LiveDiscussPoll$launch$2.INSTANCE).doOnUnsubscribe(LiveDiscussPoll$launch$3.INSTANCE).subscribe(new LiveDiscussPoll$launch$4(this), LiveDiscussPoll$launch$5.INSTANCE);
    }

    public final synchronized void startNewPoll() {
        if (!this.enableSubscription.get()) {
            LiveDiscussPollKt.liveDiscussPollLogW("我们已经退出界面了，应该停止轮训");
            return;
        }
        LiveDiscussPollKt.liveDiscussPollLogD("启动轮询");
        Subscription subscription = this.subscriptionPoll;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscriptionPoll = Observable.defer(new LiveDiscussPoll$startNewPoll$1(this)).repeatWhen(new LiveDiscussPoll$startNewPoll$2(this)).retryWhen(new LiveDiscussPoll$startNewPoll$3(this)).doOnSubscribe(new LiveDiscussPoll$startNewPoll$4(this)).doOnUnsubscribe(new LiveDiscussPoll$startNewPoll$5(this)).subscribe(new LiveDiscussPoll$startNewPoll$6(this), new LiveDiscussPoll$startNewPoll$7(this));
    }

    /* access modifiers changed from: private */
    public final Entity findFirstLiveEntity(List<? extends Entity> list) {
        T t;
        boolean z;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            T t2 = t;
            if (Intrinsics.areEqual(t2.getEntityType(), "liveMessage") || Intrinsics.areEqual(t2.getEntityType(), "liveSystemMessage")) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return t;
    }
}
