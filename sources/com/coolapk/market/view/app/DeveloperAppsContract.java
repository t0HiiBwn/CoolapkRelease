package com.coolapk.market.view.app;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public class DeveloperAppsContract {

    public interface View extends AsyncListContract.View<Result<List<ServiceApp>>> {
        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<ServiceApp>>> {
        public Presenter(View view) {
            super(view);
        }
    }
}
