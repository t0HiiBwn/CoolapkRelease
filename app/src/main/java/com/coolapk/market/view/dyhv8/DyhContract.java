package com.coolapk.market.view.dyhv8;

import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.BasePresenter;
import rx.Observable;

public class DyhContract {

    public interface DyhArticleActionPresenter {
        Observable<Result<String>> dyhArticleFavorite(DyhArticle dyhArticle);

        Observable<Result<String>> dyhArticleLike(DyhArticle dyhArticle);

        Observable<Result<String>> dyhArticleUnFavorite(DyhArticle dyhArticle);

        Observable<Result<String>> dyhArticleUnLike(DyhArticle dyhArticle);

        Observable<Result<String>> onArticleBlock(DyhArticle dyhArticle);

        Observable<Result<String>> onArticleDelete(DyhArticle dyhArticle);

        Observable<Result<String>> onArticleRecommend(DyhArticle dyhArticle);

        Observable<Result<String>> onArticleRemove(DyhArticle dyhArticle);

        Observable<Result<String>> onArticleUnBlock(DyhArticle dyhArticle);

        Observable<Result<String>> onArticleUnRecommend(DyhArticle dyhArticle);
    }

    public interface Presenter extends BasePresenter {
        void cancelLoadDyhModel();

        Observable<Result<String>> followDyh();

        Observable<Result<DyhArticle>> getDyhArticleDetail();

        DyhModel getDyhModel();

        String getId();

        boolean getIsLoading();

        Observable<Result<DyhModel>> loadDyh();

        Observable<Result<String>> unFollowDyh();
    }

    public interface View {
        void DyhFollowed(String str, boolean z);

        void DyhFollowedFailed(Throwable th, boolean z);
    }
}
