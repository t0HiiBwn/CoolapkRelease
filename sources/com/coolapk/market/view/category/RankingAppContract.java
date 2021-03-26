package com.coolapk.market.view.category;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public interface RankingAppContract {
    public static final String RANK_TYPE_COMMENT = "comment";
    public static final String RANK_TYPE_DEFAULT = "default";
    public static final String RANK_TYPE_DOWNLOAD = "download";
    public static final String RANK_TYPE_FOLLOW = "follow";
    public static final String RANK_TYPE_LAST_UPDATE = "lastupdate";
    public static final String RANK_TYPE_PUBLISH_DATE = "pubdate";
    public static final String RANK_TYPE_RATING = "rating";

    public interface View extends AsyncListContract.View<Result<List<Entity>>> {
        void clearCardData();

        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<Entity>>> {
        public abstract String getRankType();

        public abstract void resetRankType(String str);

        public Presenter(View view) {
            super(view);
        }
    }
}
