package com.coolapk.market.view.main;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public interface AlbumListContract {

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
