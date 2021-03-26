package com.coolapk.market.view.app;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;
import java.util.List;
import java.util.Map;

public class AppViewContract {

    public interface Presenter extends BasePresenter {
        void addToAlbum();

        void cancelFavoriteApp();

        void cancelFollowApp();

        void cancelFollowUser();

        void cancelLoad();

        void cancelLoadComment();

        void cancelRating();

        void favoriteApp(String str, boolean z, boolean z2);

        void followApp(String str, boolean z, boolean z2);

        void followUser(String str, boolean z, boolean z2);

        List<Feed> getCommentList();

        ServiceApp getServiceApp();

        boolean isLoadingApp();

        boolean isLoadingComment();

        boolean isNoMoreComment();

        boolean isRating();

        void loadApp(String str, int i, String str2);

        void loadComment(String str, String str2);

        void ratingApp(String str, int i, int i2);

        void unratingApp(String str, int i);
    }

    public interface View extends BaseView {
        void onAppLoaded(Result<ServiceApp> result, Throwable th);

        void onCommentLoaded(Result<List<Feed>> result, Throwable th);

        void onFavoriteAppComplete(boolean z, boolean z2, Result<Integer> result, Throwable th);

        void onFollowAppComplete(boolean z, boolean z2, Result<Map<String, String>> result, Throwable th);

        void onFollowUserComplete(boolean z, boolean z2, Integer num, Throwable th);

        void onRatingComplete(int i, int i2, Result<Map<String, String>> result, Throwable th);

        void onUnratingComplete(int i, Result<Map<String, String>> result, Throwable th);
    }
}
