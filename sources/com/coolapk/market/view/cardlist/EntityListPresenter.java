package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListContract;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007H\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "Lcom/coolapk/market/view/cardlist/EntityListContract$Presenter;", "view", "Lcom/coolapk/market/view/cardlist/EntityListContract$View;", "(Lcom/coolapk/market/view/cardlist/EntityListContract$View;)V", "banUserAction", "Ljava/util/HashMap;", "", "Lrx/Subscription;", "Lkotlin/collections/HashMap;", "followDyhRunningId", "followDyhSub", "followLiveAction", "followUserAction", "unbanUserAction", "unfollowUserAction", "getView", "()Lcom/coolapk/market/view/cardlist/EntityListContract$View;", "followLive", "", "liveId", "isFollow", "", "followSubscription", "id", "followNum", "", "followUser", "uid", "isFollowSubscriptionRunning", "isFollowUserRunning", "isUnfollowUserRunning", "onInitPresenterState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "unfollowUser", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListPresenter.kt */
public final class EntityListPresenter implements EntityListContract.Presenter {
    private final HashMap<String, Subscription> banUserAction = new HashMap<>();
    private String followDyhRunningId;
    private Subscription followDyhSub;
    private final HashMap<String, Subscription> followLiveAction = new HashMap<>();
    private final HashMap<String, Subscription> followUserAction = new HashMap<>();
    private final HashMap<String, Subscription> unbanUserAction = new HashMap<>();
    private final HashMap<String, Subscription> unfollowUserAction = new HashMap<>();
    private final EntityListContract.View view;

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public EntityListPresenter(EntityListContract.View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
    }

    public final EntityListContract.View getView() {
        return this.view;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.Presenter
    public void followUser(String str) {
        Subscription subscription;
        Intrinsics.checkNotNullParameter(str, "uid");
        if (this.followUserAction.containsKey(str) && (subscription = this.followUserAction.get(str)) != null) {
            subscription.unsubscribe();
        }
        Subscription subscribe = DataManager.getInstance().followUser(str).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new EntityListPresenter$followUser$followUserSub$1(this, str)).doOnUnsubscribe(new EntityListPresenter$followUser$followUserSub$2(this, str)).map(RxUtils.checkResultToData()).subscribe(new EntityListPresenter$followUser$followUserSub$3(this, str), new EntityListPresenter$followUser$followUserSub$4(this, str));
        Intrinsics.checkNotNullExpressionValue(subscribe, "followUserSub");
        this.followUserAction.put(str, subscribe);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.Presenter
    public boolean isFollowUserRunning(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        return this.followUserAction.containsKey(str);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.Presenter
    public void unfollowUser(String str) {
        Subscription subscription;
        Intrinsics.checkNotNullParameter(str, "uid");
        if (this.unfollowUserAction.containsKey(str) && (subscription = this.unfollowUserAction.get(str)) != null) {
            subscription.unsubscribe();
        }
        Subscription subscribe = DataManager.getInstance().unfollowUser(str).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new EntityListPresenter$unfollowUser$unfollowUserSub$1(this, str)).doOnUnsubscribe(new EntityListPresenter$unfollowUser$unfollowUserSub$2(this, str)).map(RxUtils.checkResultToData()).subscribe(new EntityListPresenter$unfollowUser$unfollowUserSub$3(this, str), new EntityListPresenter$unfollowUser$unfollowUserSub$4(this, str));
        Intrinsics.checkNotNullExpressionValue(subscribe, "unfollowUserSub");
        this.unfollowUserAction.put(str, subscribe);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.Presenter
    public boolean isUnfollowUserRunning(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        return this.unfollowUserAction.containsKey(str);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.Presenter
    public void followSubscription(String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.followDyhSub = Observable.just(Boolean.valueOf(z)).flatMap(new EntityListPresenter$followSubscription$1(str)).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new EntityListPresenter$followSubscription$2(this, str, z, i)).doOnUnsubscribe(new EntityListPresenter$followSubscription$3(this, str, z, i)).map(RxUtils.checkResultToData()).subscribe(new EntityListPresenter$followSubscription$4(this, str, z), new EntityListPresenter$followSubscription$5(this, str, z, i));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.Presenter
    public boolean isFollowSubscriptionRunning(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return TextUtils.equals(this.followDyhRunningId, str);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.Presenter
    public void followLive(String str, boolean z) {
        Subscription subscription;
        Intrinsics.checkNotNullParameter(str, "liveId");
        if (this.followLiveAction.containsKey(str) && (subscription = this.followLiveAction.get(str)) != null) {
            subscription.unsubscribe();
        }
        Subscription subscribe = DataManager.getInstance().followLive(str, z).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).doOnSubscribe(new EntityListPresenter$followLive$followLiveSub$1(this, str, z)).doOnUnsubscribe(new EntityListPresenter$followLive$followLiveSub$2(this, str, z)).subscribe(new EntityListPresenter$followLive$followLiveSub$3(this, str, z), new EntityListPresenter$followLive$followLiveSub$4(this, str, z));
        Intrinsics.checkNotNullExpressionValue(subscribe, "followLiveSub");
        this.followLiveAction.put(str, subscribe);
    }
}
