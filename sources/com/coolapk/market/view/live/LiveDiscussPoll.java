package com.coolapk.market.view.live;

import com.coolapk.market.manager.PushMessage;
import com.coolapk.market.model.Entity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscription;

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
