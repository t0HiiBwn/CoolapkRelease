package com.coolapk.market.view.album;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.BasePresenter;
import java.util.List;
import rx.Observable;

public class AlbumDetailContract {

    public interface Presenter extends BasePresenter {
        void cancelLoadAlbum();

        void cancelLoadComment();

        Observable<Result<Integer>> followUser(String str);

        Album getAlbum();

        String getAlbumId();

        boolean getIsLoading();

        boolean getIsLoadingReply();

        boolean getNoMoreReply();

        List<FeedReply> getReplyList();

        Observable<Result<Album>> loadAlbum(String str, String str2);

        void loadReplyList(String str, boolean z);

        Observable<Result<Integer>> unFollowUser(String str);
    }

    public interface View {
        void onAlbumLoaded(Album album, Throwable th);
    }
}
