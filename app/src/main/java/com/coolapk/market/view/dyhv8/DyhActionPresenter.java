package com.coolapk.market.view.dyhv8;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import rx.Observable;

public class DyhActionPresenter {
    private static DyhActionPresenter sInstance;
    private DyhArticle mDyhArticle;

    private DyhActionPresenter() {
    }

    public static DyhActionPresenter getInstance() {
        if (sInstance == null) {
            sInstance = new DyhActionPresenter();
        }
        return sInstance;
    }

    public DyhArticle getDyhArticle() {
        return this.mDyhArticle;
    }

    public Observable<Result<String>> onArticleBlock(DyhArticle dyhArticle) {
        return DataManager.getInstance().onArticleBlock(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> onArticleUnBlock(DyhArticle dyhArticle) {
        return DataManager.getInstance().onArticleUnBlock(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> onArticleDelete(DyhArticle dyhArticle) {
        return DataManager.getInstance().onArticleDelete(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> onArticleRemove(DyhArticle dyhArticle) {
        return DataManager.getInstance().onArticleRemove(dyhArticle.getId(), 1, dyhArticle.getDyhId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> onArticleRecommend(DyhArticle dyhArticle) {
        return DataManager.getInstance().onArticleRecommend(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> onArticleUnRecommend(DyhArticle dyhArticle) {
        return DataManager.getInstance().onArticleUnRecommend(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<Integer>> dyhArticleFavorite(DyhArticle dyhArticle) {
        return DataManager.getInstance().dyhArticleFavorite(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<Integer>> dyhArticleUnFavorite(DyhArticle dyhArticle) {
        return DataManager.getInstance().dyhArticleUnFavorite(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<Integer>> dyhArticleLike(DyhArticle dyhArticle) {
        return DataManager.getInstance().dyhArticleLike(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<Integer>> dyhArticleUnLike(DyhArticle dyhArticle) {
        return DataManager.getInstance().dyhArticleUnLike(dyhArticle.getId()).map(RxUtils.checkResult());
    }

    public Observable<Result<String>> dyhOnStick(DyhArticle dyhArticle) {
        return DataManager.getInstance().onStick(dyhArticle.getId(), 1);
    }

    public Observable<Result<String>> dyhUnOnStick(DyhArticle dyhArticle) {
        return DataManager.getInstance().onStick(dyhArticle.getId(), 2);
    }
}
