package com.coolapk.market.view.album;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;
import rx.Observable;

interface AlbumContract {

    public interface ActionPresenter {
        Observable<Result<String>> cancelRecommendAlbum(Album album);

        Observable<Result<Integer>> collectAlbum(Album album);

        Observable<Result<String>> deleteAlbum(Album album, int i);

        Observable<Result<String>> deleteFeedReply(FeedReply feedReply, int i);

        Observable<Result<String>> feedBlockBanned(Album album);

        Observable<Result<String>> feedBlockFolded(Album album);

        Observable<Result<String>> feedBlockPrivate(Album album);

        Observable<Result<String>> feedReplyBlockBanned(FeedReply feedReply);

        Observable<Result<String>> feedReplyBlockFolded(FeedReply feedReply);

        Observable<Result<String>> feedReplyBlockPrivate(FeedReply feedReply);

        Observable<Result<String>> feedUnBlockBanned(Album album);

        Observable<Result<String>> feedUnBlockFolded(Album album);

        Observable<Result<String>> feedUnBlockPrivate(Album album);

        Observable<Result<String>> feedUnsetMessageStatus(Album album);

        Observable<Result<LikeResult>> likeAlbum(Album album);

        Observable<Result<String>> recommendAlbum(Album album);

        Observable<Result<Integer>> unCollectAlbum(Album album);

        Observable<Result<LikeResult>> unlikeAlbum(Album album);
    }

    public interface View extends AsyncListContract.View<Result<List<Entity>>> {
        void clearAllData();

        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<Entity>>> {
        public Presenter(View view) {
            super(view);
        }
    }
}
