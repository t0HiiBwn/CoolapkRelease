package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.LikeResult;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedDetailView;", "", "onFavoriteResult", "", "favorite", "", "favoriteNum", "", "error", "", "(ZLjava/lang/Integer;Ljava/lang/Throwable;)V", "onFeedUpdate", "feed", "Lcom/coolapk/market/model/Feed;", "onFollowAuthorResult", "following", "onLikeResult", "like", "result", "Lcom/coolapk/market/model/LikeResult;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailPresenter.kt */
public interface FeedDetailView {
    void onFavoriteResult(boolean z, Integer num, Throwable th);

    void onFeedUpdate(Feed feed);

    void onFollowAuthorResult(boolean z, Throwable th);

    void onLikeResult(boolean z, LikeResult likeResult, Throwable th);
}
