package com.coolapk.market.view.album;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.album.AlbumContract;
import rx.Observable;

public class AlbumActionPresenter implements AlbumContract.ActionPresenter {
    private static AlbumActionPresenter sInstance;

    private AlbumActionPresenter() {
    }

    public static AlbumActionPresenter getInstance() {
        if (sInstance == null) {
            sInstance = new AlbumActionPresenter();
        }
        return sInstance;
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> deleteAlbum(Album album, int i) {
        return DataManager.getInstance().deleteFeed(album.getAlbumId(), i).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<LikeResult>> likeAlbum(Album album) {
        return DataManager.getInstance().likeFeed(album.getAlbumId(), 0).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<LikeResult>> unlikeAlbum(Album album) {
        return DataManager.getInstance().unlikeFeed(album.getAlbumId(), 0).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<Integer>> collectAlbum(Album album) {
        return DataManager.getInstance().collectAlbum(album.getAlbumId()).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<Integer>> unCollectAlbum(Album album) {
        return DataManager.getInstance().unFavoriteAlbum(album.getAlbumId(), "album").map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> cancelRecommendAlbum(Album album) {
        return DataManager.getInstance().cancelRecommend(album.getAlbumId()).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> recommendAlbum(Album album) {
        return DataManager.getInstance().albumRecommend(album.getAlbumId()).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> deleteFeedReply(FeedReply feedReply, int i) {
        return DataManager.getInstance().deleteFeedReply(feedReply.getId(), i).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedBlockPrivate(Album album) {
        return DataManager.getInstance().feedBlock("private", album.getAlbumId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedUnBlockPrivate(Album album) {
        return DataManager.getInstance().feedUnBlock("private", album.getEntityType(), album.getId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedBlockFolded(Album album) {
        return DataManager.getInstance().feedBlock("folded", album.getAlbumId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedUnBlockFolded(Album album) {
        return DataManager.getInstance().feedUnBlock("folded", album.getEntityType(), album.getId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedBlockBanned(Album album) {
        return DataManager.getInstance().feedBlock("banned", album.getAlbumId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedUnBlockBanned(Album album) {
        return DataManager.getInstance().feedUnBlock("banned", album.getEntityType(), album.getId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedReplyBlockPrivate(FeedReply feedReply) {
        return DataManager.getInstance().feedReplyBlock("private", feedReply.getId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedReplyBlockFolded(FeedReply feedReply) {
        return DataManager.getInstance().feedReplyBlock("folded", feedReply.getId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedReplyBlockBanned(FeedReply feedReply) {
        return DataManager.getInstance().feedReplyBlock("banned", feedReply.getId());
    }

    @Override // com.coolapk.market.view.album.AlbumContract.ActionPresenter
    public Observable<Result<String>> feedUnsetMessageStatus(Album album) {
        return DataManager.getInstance().unsetMessageStatus(album.getId());
    }

    public Observable<Result<String>> addToHeadline(Album album) {
        return DataManager.getInstance().addToHeadline(album.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> removeFromHeadline(Album album) {
        return DataManager.getInstance().removeFromHeadline(album.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> addToHeadlineV8(Album album) {
        return DataManager.getInstance().addToHeadlineV8(album.getId(), "feed").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> removeFromHeadlineV8(Album album) {
        return DataManager.getInstance().removeFromHeadlineV8(album.getId(), "feed").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> addToEditorChoice(Album album) {
        return DataManager.getInstance().addToEditorChoice(album.getId(), "feed").map(RxUtils.checkResult());
    }

    public Observable<Result<String>> removeFromEditorChoice(Album album) {
        return DataManager.getInstance().removeFromEditorChoice(album.getId(), "feed").map(RxUtils.checkResult());
    }
}
