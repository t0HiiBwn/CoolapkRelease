package com.coolapk.market.view.search;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public interface SearchUserContract {

    public interface View extends AsyncListContract.View<Result<List<Entity>>> {
        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<Entity>>> {
        public abstract String getKeyword();

        public Presenter(View view) {
            super(view);
        }
    }
}
