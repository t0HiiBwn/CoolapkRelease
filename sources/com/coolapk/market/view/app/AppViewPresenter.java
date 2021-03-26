package com.coolapk.market.view.app;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.app.AppViewContract;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

public class AppViewPresenter implements AppViewContract.Presenter {
    private static final String KEY_COMMENT_LIST = "COMMENT_LIST";
    private static final String KEY_NO_MORE_COMMENT = "NO_MORE_COMMENT";
    private static final String KEY_PAGE = "PAGE";
    private static final String KEY_SERVICE_APP = "SERVICE_APP";
    private ArrayList<Feed> commentList = new ArrayList<>();
    private Subscription favoriteAppSub;
    private Subscription followAppSub;
    private Subscription followUserSub;
    private boolean isFavoring = false;
    private boolean isFollowAppRunning = false;
    private boolean isFollowUserRunning = false;
    private boolean isLoadingApp = false;
    private boolean isLoadingComment = false;
    private boolean isRating = false;
    private Subscription loadAppSub;
    private Subscription loadCommentSub;
    private boolean noMoreComment = false;
    private AtomicInteger pageCounter = new AtomicInteger(1);
    private Subscription ratingAppSub;
    private ServiceApp serviceApp;
    private final AppViewContract.View view;

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void addToAlbum() {
    }

    public AppViewPresenter(AppViewContract.View view2) {
        this.view = view2;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.serviceApp = (ServiceApp) bundle.getParcelable("SERVICE_APP");
            this.commentList = bundle.getParcelableArrayList("COMMENT_LIST");
            this.noMoreComment = bundle.getBoolean("NO_MORE_COMMENT", false);
            this.pageCounter = new AtomicInteger(bundle.getInt("PAGE", 1));
        }
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("SERVICE_APP", this.serviceApp);
        bundle.putParcelableArrayList("COMMENT_LIST", this.commentList);
        bundle.putBoolean("NO_MORE_COMMENT", this.noMoreComment);
        bundle.putInt("PAGE", this.pageCounter.get());
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public ServiceApp getServiceApp() {
        return this.serviceApp;
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public List<Feed> getCommentList() {
        return this.commentList;
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public boolean isLoadingApp() {
        return this.isLoadingApp;
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public boolean isLoadingComment() {
        return this.isLoadingComment;
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public boolean isRating() {
        return this.isRating;
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public boolean isNoMoreComment() {
        return this.noMoreComment;
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void loadApp(String str, int i, String str2) {
        cancelLoad();
        this.isLoadingApp = true;
        this.loadAppSub = DataManager.getInstance().getAppDetail(str, i, str2, null).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isLoadingApp = false;
            }
        }).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<ServiceApp>>() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppViewPresenter.this.isLoadingApp = false;
                AppViewPresenter.this.view.onAppLoaded(null, th);
            }

            public void onNext(Result<ServiceApp> result) {
                AppViewPresenter.this.isLoadingApp = false;
                AppViewPresenter.this.serviceApp = result.getData();
                AppViewPresenter.this.view.onAppLoaded(result, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void loadComment(String str, String str2) {
        String str3;
        String str4;
        cancelLoadComment();
        if (!this.commentList.isEmpty()) {
            String id = this.commentList.get(0).getId();
            ArrayList<Feed> arrayList = this.commentList;
            str3 = arrayList.get(arrayList.size() - 1).getId();
            str4 = id;
        } else {
            str4 = null;
            str3 = null;
        }
        this.isLoadingComment = true;
        this.loadCommentSub = DataManager.getInstance().getAppCommentList(str, str2, this.pageCounter.get(), str4, str3, 0, 1, null).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass4 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isLoadingComment = false;
            }
        }).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<List<Feed>>>() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass3 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppViewPresenter.this.isLoadingComment = false;
                AppViewPresenter.this.view.onCommentLoaded(null, th);
            }

            public void onNext(Result<List<Feed>> result) {
                AppViewPresenter.this.isLoadingComment = false;
                if (CollectionUtils.isEmpty(result.getData())) {
                    LogUtils.d("No more data", new Object[0]);
                    AppViewPresenter.this.noMoreComment = true;
                } else {
                    AppViewPresenter.this.commentList.addAll(result.getData());
                    AppViewPresenter.this.pageCounter.incrementAndGet();
                }
                AppViewPresenter.this.view.onCommentLoaded(result, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void ratingApp(String str, final int i, final int i2) {
        cancelRating();
        this.isRating = true;
        this.ratingAppSub = DataManager.getInstance().ratingApp(str, i).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass6 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isRating = false;
            }
        }).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<Map<String, String>>>() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass5 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppViewPresenter.this.isRating = false;
                AppViewPresenter.this.view.onRatingComplete(i, i2, null, th);
            }

            public void onNext(Result<Map<String, String>> result) {
                AppViewPresenter.this.isRating = false;
                AppViewPresenter.this.view.onRatingComplete(i, i2, result, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void unratingApp(String str, final int i) {
        cancelRating();
        this.isRating = true;
        this.ratingAppSub = DataManager.getInstance().unratingApp(str).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass8 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isRating = false;
            }
        }).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<Map<String, String>>>() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass7 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppViewPresenter.this.isRating = false;
                AppViewPresenter.this.view.onUnratingComplete(i, null, th);
            }

            public void onNext(Result<Map<String, String>> result) {
                AppViewPresenter.this.isRating = false;
                AppViewPresenter.this.view.onUnratingComplete(i, result, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void followApp(String str, final boolean z, final boolean z2) {
        Observable<Result<Map<String, String>>> observable;
        cancelFollowApp();
        if (z2) {
            observable = DataManager.getInstance().followApp(str);
        } else {
            observable = DataManager.getInstance().unfollowApp(str);
        }
        this.followAppSub = observable.compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass11 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isFollowAppRunning = true;
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass10 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isFollowAppRunning = false;
            }
        }).map(RxUtils.checkResult()).subscribe((Subscriber) new Subscriber<Result<Map<String, String>>>() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass9 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppViewPresenter.this.isFollowAppRunning = false;
                AppViewPresenter.this.view.onFollowAppComplete(z, z2, null, th);
            }

            public void onNext(Result<Map<String, String>> result) {
                AppViewPresenter.this.isFollowAppRunning = false;
                AppViewPresenter.this.view.onFollowAppComplete(z, z2, result, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void favoriteApp(String str, final boolean z, final boolean z2) {
        Observable<Result<Integer>> observable;
        cancelFavoriteApp();
        if (z2) {
            observable = DataManager.getInstance().favoriteApp(str);
        } else {
            observable = DataManager.getInstance().unfavoriteApp(str, getServiceApp().getApkType());
        }
        this.favoriteAppSub = observable.compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass14 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isFavoring = true;
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass13 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isFavoring = false;
            }
        }).map(RxUtils.checkResult()).subscribe((Subscriber) new Subscriber<Result<Integer>>() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass12 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppViewPresenter.this.isFavoring = false;
                AppViewPresenter.this.view.onFavoriteAppComplete(z, z2, null, th);
            }

            public void onNext(Result<Integer> result) {
                AppViewPresenter.this.isFavoring = false;
                AppViewPresenter.this.view.onFavoriteAppComplete(z, z2, result, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void followUser(String str, final boolean z, final boolean z2) {
        Observable<Result<Integer>> observable;
        cancelFollowUser();
        if (z2) {
            observable = DataManager.getInstance().followUser(str);
        } else {
            observable = DataManager.getInstance().unfollowUser(str);
        }
        this.followAppSub = observable.compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass17 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isFollowUserRunning = true;
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass16 */

            @Override // rx.functions.Action0
            public void call() {
                AppViewPresenter.this.isFollowUserRunning = false;
            }
        }).map(RxUtils.checkResultToData()).subscribe((Subscriber) new Subscriber<Integer>() {
            /* class com.coolapk.market.view.app.AppViewPresenter.AnonymousClass15 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppViewPresenter.this.isFollowUserRunning = false;
                AppViewPresenter.this.view.onFollowUserComplete(z, z2, null, th);
            }

            public void onNext(Integer num) {
                AppViewPresenter.this.isFollowUserRunning = false;
                AppViewPresenter.this.view.onFollowUserComplete(z, z2, num, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void cancelLoadComment() {
        RxUtils.unsubscribe(this.loadCommentSub);
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void cancelLoad() {
        RxUtils.unsubscribe(this.loadAppSub);
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void cancelRating() {
        RxUtils.unsubscribe(this.ratingAppSub);
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void cancelFollowApp() {
        RxUtils.unsubscribe(this.followAppSub);
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void cancelFavoriteApp() {
        RxUtils.unsubscribe(this.favoriteAppSub);
    }

    @Override // com.coolapk.market.view.app.AppViewContract.Presenter
    public void cancelFollowUser() {
        RxUtils.unsubscribe(this.followUserSub);
    }
}
