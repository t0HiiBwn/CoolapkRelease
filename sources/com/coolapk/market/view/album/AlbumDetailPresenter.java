package com.coolapk.market.view.album;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.album.AlbumDetailContract;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

public class AlbumDetailPresenter implements AlbumDetailContract.Presenter {
    private static final String KEY_ALBUM = "ALBUM";
    private static final String KEY_ID = "ID";
    private static final String KEY_PAGE = "PAGE";
    private Album album;
    private Context context;
    private final List<FeedReply> feedReplyList = new ArrayList();
    private String id;
    private boolean isLoading = true;
    private boolean isLoadingReply = false;
    private Subscription loadAlbumSub;
    private Subscription loadReplyListSub;
    private boolean noMoreReply = false;
    private AtomicInteger pageCounter = new AtomicInteger(1);
    private String rid;
    private Subscription subscription;
    private final AlbumDetailContract.View view;

    public AlbumDetailPresenter(AlbumDetailContract.View view2) {
        this.view = view2;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public Observable<Result<Album>> loadAlbum(String str, String str2) {
        Observable<Result<Album>> albumDetail = DataManager.getInstance().getAlbumDetail(str, str2);
        this.loadAlbumSub = albumDetail.compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<Album>>() {
            /* class com.coolapk.market.view.album.AlbumDetailPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                AlbumDetailPresenter.this.isLoading = false;
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AlbumDetailPresenter.this.isLoading = true;
                AlbumDetailPresenter.this.view.onAlbumLoaded(null, th);
            }

            public void onNext(Result<Album> result) {
                if (result.getData() != null) {
                    AlbumDetailPresenter.this.isLoading = false;
                    AlbumDetailPresenter.this.album = result.getData();
                    AlbumDetailPresenter.this.view.onAlbumLoaded(AlbumDetailPresenter.this.album, null);
                } else if (!TextUtils.isEmpty(result.getMessage())) {
                    AlbumDetailPresenter.this.view.onAlbumLoaded(null, new Throwable(result.getMessage()));
                }
            }
        });
        return albumDetail;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public Album getAlbum() {
        return this.album;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public boolean getIsLoading() {
        return this.isLoading;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public boolean getIsLoadingReply() {
        return this.isLoadingReply;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public boolean getNoMoreReply() {
        return this.noMoreReply;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public String getAlbumId() {
        return this.id;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public List<FeedReply> getReplyList() {
        return this.feedReplyList;
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public void loadReplyList(String str, boolean z) {
        String str2;
        cancelLoadComment();
        String str3 = null;
        if (!this.feedReplyList.isEmpty()) {
            str3 = this.feedReplyList.get(0).getId();
            List<FeedReply> list = this.feedReplyList;
            str2 = list.get(list.size() - 1).getId();
        } else {
            str2 = null;
        }
        this.isLoadingReply = true;
        this.loadReplyListSub = DataManager.getInstance().getAlbumReplyList(str, this.pageCounter.get(), str3, str2).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.album.AlbumDetailPresenter.AnonymousClass3 */

            @Override // rx.functions.Action0
            public void call() {
                AlbumDetailPresenter.this.isLoadingReply = false;
            }
        }).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<List<FeedReply>>>() {
            /* class com.coolapk.market.view.album.AlbumDetailPresenter.AnonymousClass2 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(AlbumDetailPresenter.this.context, th);
                AlbumDetailPresenter.this.isLoadingReply = false;
            }

            public void onNext(Result<List<FeedReply>> result) {
                AlbumDetailPresenter.this.isLoadingReply = false;
                if (CollectionUtils.isEmpty(result.getData())) {
                    LogUtils.d("No more data", new Object[0]);
                    AlbumDetailPresenter.this.noMoreReply = true;
                    return;
                }
                AlbumDetailPresenter.this.feedReplyList.addAll(result.getData());
                AlbumDetailPresenter.this.pageCounter.incrementAndGet();
            }
        });
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public void cancelLoadComment() {
        RxUtils.unsubscribe(this.loadReplyListSub);
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public void cancelLoadAlbum() {
        RxUtils.unsubscribe(this.loadAlbumSub);
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public Observable<Result<Integer>> followUser(String str) {
        return DataManager.getInstance().followUser(this.album.getUid());
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.Presenter
    public Observable<Result<Integer>> unFollowUser(String str) {
        return DataManager.getInstance().unfollowUser(this.album.getUid());
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.pageCounter = new AtomicInteger(bundle.getInt("PAGE", 1));
            this.album = (Album) bundle.getParcelable("ALBUM");
            this.id = bundle.getString("ID");
        }
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("PAGE", this.pageCounter.get());
        bundle.putParcelable("ALBUM", this.album);
        bundle.putString("ID", this.id);
    }
}
