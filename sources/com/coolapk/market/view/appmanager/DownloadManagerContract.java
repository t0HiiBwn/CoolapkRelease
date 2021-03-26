package com.coolapk.market.view.appmanager;

import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public class DownloadManagerContract {

    interface View extends AsyncListContract.View<List<DownloadInfo>> {
    }

    static abstract class Presenter extends AsyncListPresenter<List<DownloadInfo>> {
        public Presenter(View view) {
            super(view);
        }
    }
}
