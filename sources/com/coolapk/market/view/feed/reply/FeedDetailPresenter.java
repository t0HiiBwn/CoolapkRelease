package com.coolapk.market.view.feed.reply;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BasePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bJ\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0006\u0010\u001f\u001a\u00020\u0014J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "Lcom/coolapk/market/view/base/BasePresenter;", "feed", "Lcom/coolapk/market/model/Feed;", "view", "Lcom/coolapk/market/view/feed/reply/FeedDetailView;", "(Lcom/coolapk/market/model/Feed;Lcom/coolapk/market/view/feed/reply/FeedDetailView;)V", "<set-?>", "getFeed", "()Lcom/coolapk/market/model/Feed;", "isPostingFavorite", "", "isPostingFollow", "isPostingLike", "previewMode", "getPreviewMode", "()Z", "getView", "()Lcom/coolapk/market/view/feed/reply/FeedDetailView;", "favoriteFeed", "", "isFavoriting", "followAuthor", "isFollowing", "likeFeed", "isLiking", "onInitPresenterState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "setPreviewMode", "updateFeed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailPresenter.kt */
public final class FeedDetailPresenter implements BasePresenter {
    private Feed feed;
    private boolean isPostingFavorite;
    private boolean isPostingFollow;
    private boolean isPostingLike;
    private boolean previewMode;
    private final FeedDetailView view;

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public FeedDetailPresenter(Feed feed2, FeedDetailView feedDetailView) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        Intrinsics.checkNotNullParameter(feedDetailView, "view");
        this.view = feedDetailView;
        this.feed = feed2;
    }

    public final FeedDetailView getView() {
        return this.view;
    }

    public final boolean getPreviewMode() {
        return this.previewMode;
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final void setPreviewMode() {
        this.previewMode = true;
    }

    public final void updateFeed(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.feed = feed2;
        this.view.onFeedUpdate(feed2);
    }

    public final void likeFeed(boolean z) {
        if (!this.isPostingLike) {
            this.isPostingLike = true;
            if (z) {
                DataManager.getInstance().unlikeFeed(this.feed.getId(), 0).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedDetailPresenter$likeFeed$1(this, z));
            } else {
                DataManager.getInstance().likeFeed(this.feed.getId(), 0).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedDetailPresenter$likeFeed$2(this, z));
            }
        }
    }

    public final void favoriteFeed(boolean z) {
        if (!this.isPostingFavorite) {
            this.isPostingFavorite = true;
            this.feed.getUid();
            if (z) {
                DataManager.getInstance().unFavoriteFeed(this.feed.getId(), this.feed.getFeedType()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedDetailPresenter$favoriteFeed$1(this, z));
            } else {
                DataManager.getInstance().favoriteFeed(this.feed.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedDetailPresenter$favoriteFeed$2(this, z));
            }
        }
    }

    public final void followAuthor(boolean z) {
        if (!this.isPostingFollow) {
            this.isPostingFollow = true;
            String uid = this.feed.getUid();
            if (z) {
                DataManager.getInstance().unfollowUser(uid).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedDetailPresenter$followAuthor$1(this, z));
            } else {
                DataManager.getInstance().followUser(uid).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedDetailPresenter$followAuthor$2(this, z));
            }
        }
    }
}
