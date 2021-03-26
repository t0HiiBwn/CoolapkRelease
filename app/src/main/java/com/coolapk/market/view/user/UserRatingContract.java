package com.coolapk.market.view.user;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public interface UserRatingContract {

    public interface View extends AsyncListContract.View<Result<List<Entity>>> {
        String findFirstItem();

        String findLastItem();

        void onEntityUnrated(ServiceApp serviceApp);
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<Entity>>> {
        public abstract String getUid();

        public abstract void unrateApp(ServiceApp serviceApp);

        public Presenter(View view) {
            super(view);
        }
    }
}
