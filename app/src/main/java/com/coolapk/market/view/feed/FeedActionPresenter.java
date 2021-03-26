package com.coolapk.market.view.feed;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import rx.Observable;

public class FeedActionPresenter {
    private static FeedActionPresenter sInstance;

    private FeedActionPresenter() {
    }

    public static FeedActionPresenter getInstance() {
        if (sInstance == null) {
            sInstance = new FeedActionPresenter();
        }
        return sInstance;
    }

    public Observable<Result<String>> deleteFeed(Feed feed, int i) {
        return DataManager.getInstance().deleteFeed(feed.getId(), i).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> deleteHistoryFeed(Feed feed, int i) {
        return DataManager.getInstance().deleteHistoryFeed(feed.getId(), i).map(RxUtils.checkResult());
    }

    public Observable<Result<LikeResult>> likeFeed(Feed feed, int i) {
        return DataManager.getInstance().likeFeed(feed.getId(), i).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> likeFeedReply(FeedReply feedReply) {
        return DataManager.getInstance().likeReply(feedReply.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> unLikeFeedReply(FeedReply feedReply) {
        return DataManager.getInstance().unlikeReply(feedReply.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<LikeResult>> unlikeFeed(Feed feed, int i) {
        return DataManager.getInstance().unlikeFeed(feed.getId(), i).map(RxUtils.checkResult());
    }

    public Observable<Result<Integer>> favoriteFeed(Feed feed) {
        return DataManager.getInstance().favoriteFeed(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<Integer>> unFavoriteFeed(Feed feed) {
        return DataManager.getInstance().unFavoriteFeed(feed.getId(), feed.getFeedType()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> favoritePic(Feed feed) {
        return DataManager.getInstance().favoritePic(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> unFavoritePic(Feed feed) {
        return DataManager.getInstance().unFavoritePic(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> feedBlockPrivate(Feed feed) {
        return DataManager.getInstance().feedBlock("private", feed.getEntityType(), feed.getId());
    }

    public Observable<Result<String>> feedUnBlockPrivate(Feed feed) {
        return DataManager.getInstance().feedUnBlock("private", feed.getEntityType(), feed.getId());
    }

    public Observable<Result<String>> feedBlockFolded(Feed feed) {
        return DataManager.getInstance().feedBlock("folded", feed.getEntityType(), feed.getId());
    }

    public Observable<Result<String>> feedUnBlockFolded(Feed feed) {
        return DataManager.getInstance().feedUnBlock("folded", feed.getEntityType(), feed.getId());
    }

    public Observable<Result<String>> feedBlockBanned(Feed feed) {
        return DataManager.getInstance().feedBlock("banned", feed.getEntityType(), feed.getId());
    }

    public Observable<Result<String>> feedUnBlockBanned(Feed feed) {
        return DataManager.getInstance().feedUnBlock("banned", feed.getEntityType(), feed.getId());
    }

    public Observable<Result<String>> feedUnBlockBannedWithOnlyHomeSelf(Feed feed) {
        return DataManager.getInstance().feedUnBlock("banned", feed.getEntityType(), feed.getId(), 1);
    }

    public Observable<Result<String>> feedReplyBlockPrivate(FeedReply feedReply) {
        return DataManager.getInstance().feedReplyBlock("private", feedReply.getId());
    }

    public Observable<Result<String>> feedReplyBlockFolded(FeedReply feedReply) {
        return DataManager.getInstance().feedReplyBlock("folded", feedReply.getId());
    }

    public Observable<Result<String>> feedReplyBlockBanned(FeedReply feedReply) {
        return DataManager.getInstance().feedReplyBlock("banned", feedReply.getId());
    }

    public Observable<Result<String>> feedReplyUnBlockPrivate(FeedReply feedReply) {
        return DataManager.getInstance().feedUnReplyBlock("private", feedReply.getId());
    }

    public Observable<Result<String>> feedReplyUnBlockFolded(FeedReply feedReply) {
        return DataManager.getInstance().feedUnReplyBlock("folded", feedReply.getId());
    }

    public Observable<Result<String>> feedReplyUnBlockBanned(FeedReply feedReply) {
        return DataManager.getInstance().feedUnReplyBlock("banned", feedReply.getId());
    }

    public Observable<Result<String>> feedUnLink(Feed feed) {
        return DataManager.getInstance().unLinkToApk(feed.getId());
    }

    public Observable<Result<String>> feedUnsetMessageStatus(Feed feed) {
        return DataManager.getInstance().unsetMessageStatus(feed.getId());
    }

    public Observable<Result<String>> cancelRecommendFeed(Feed feed) {
        return DataManager.getInstance().cancelRecommend(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> RecommendFeed(Feed feed) {
        return DataManager.getInstance().feedRecommend(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> deleteFeedReply(FeedReply feedReply, int i) {
        return DataManager.getInstance().deleteFeedReply(feedReply.getId(), i).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> addToHeadline(Feed feed) {
        return DataManager.getInstance().addToHeadline(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> removeFromHeadline(Feed feed) {
        return DataManager.getInstance().removeFromHeadline(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> addToHeadlineV8(Feed feed, boolean z) {
        return DataManager.getInstance().addToHeadlineV8(feed.getId(), z ? "feedComment" : "feed").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> onlyHomeSelf(Feed feed) {
        return DataManager.getInstance().onlyHomeSelf(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> unOnlyHomeSelf(Feed feed) {
        return DataManager.getInstance().unOnlyHomeSelf(feed.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> removeFromHeadlineV8(Feed feed, boolean z) {
        return DataManager.getInstance().removeFromHeadlineV8(feed.getId(), z ? "feedComment" : "feed").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> feedReplyAddToHeadlineV8(String str) {
        return DataManager.getInstance().addToHeadlineV8(str, "feedReply").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> feedReplyRemoveFromHeadlineV8(String str) {
        return DataManager.getInstance().removeFromHeadlineV8(str, "feedReply").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> addToEditorChoice(Feed feed, boolean z) {
        return DataManager.getInstance().addToEditorChoice(feed.getId(), z ? "feedComment" : "feed").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> removeFromEditorChoice(Feed feed, boolean z) {
        return DataManager.getInstance().removeFromEditorChoice(feed.getId(), z ? "feedComment" : "feed").map(RxUtils.checkResult());
    }
}
