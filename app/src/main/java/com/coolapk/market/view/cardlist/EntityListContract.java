package com.coolapk.market.view.cardlist;

import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListContract;", "", "Presenter", "View", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListContract.kt */
public interface EntityListContract {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListContract$Presenter;", "Lcom/coolapk/market/view/base/BasePresenter;", "followLive", "", "liveId", "", "isFollow", "", "followSubscription", "id", "followNum", "", "followUser", "uid", "isFollowSubscriptionRunning", "isFollowUserRunning", "isUnfollowUserRunning", "unfollowUser", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityListContract.kt */
    public interface Presenter extends BasePresenter {
        void followLive(String str, boolean z);

        void followSubscription(String str, boolean z, int i);

        void followUser(String str);

        boolean isFollowSubscriptionRunning(String str);

        boolean isFollowUserRunning(String str);

        boolean isUnfollowUserRunning(String str);

        void unfollowUser(String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J)\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J,\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007H&J)\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListContract$View;", "Lcom/coolapk/market/view/base/BaseView;", "onFollowSubscriptionComplete", "", "id", "", "isFollow", "", "result", "e", "", "onFollowSubscriptionReset", "followNum", "", "onFollowSubscriptionStart", "onFollowUserComplete", "uid", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)V", "onFollowUserReset", "onFollowUserStart", "onLiveFollowComplete", "liveId", "follow", "error", "onLiveFollowReset", "onLiveFollowStart", "onUnfollowUserComplete", "onUnfollowUserReset", "onUnfollowUserStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityListContract.kt */
    public interface View extends BaseView {
        void onFollowSubscriptionComplete(String str, boolean z, String str2, Throwable th);

        void onFollowSubscriptionReset(String str, boolean z, int i);

        void onFollowSubscriptionStart(String str, boolean z, int i);

        void onFollowUserComplete(String str, Integer num, Throwable th);

        void onFollowUserReset(String str);

        void onFollowUserStart(String str);

        void onLiveFollowComplete(String str, boolean z, String str2, Throwable th);

        void onLiveFollowReset(String str, boolean z);

        void onLiveFollowStart(String str, boolean z);

        void onUnfollowUserComplete(String str, Integer num, Throwable th);

        void onUnfollowUserReset(String str);

        void onUnfollowUserStart(String str);
    }
}
