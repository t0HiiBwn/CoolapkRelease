package com.coolapk.market.view.app;

import com.coolapk.market.model.VersionApp;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public class HistoryVersionContract {

    public interface View extends AsyncListContract.View<List<VersionApp>> {
    }

    public static abstract class Presenter extends AsyncListPresenter<List<VersionApp>> {
        public Presenter(AsyncListContract.View<List<VersionApp>> view) {
            super(view);
        }
    }
}
