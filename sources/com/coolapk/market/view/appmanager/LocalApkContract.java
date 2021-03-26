package com.coolapk.market.view.appmanager;

import com.coolapk.market.model.LocalApk;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public class LocalApkContract {

    interface View extends AsyncListContract.View<List<LocalApk>> {
    }

    static abstract class Presenter extends AsyncListPresenter<List<LocalApk>> {
        public Presenter(View view) {
            super(view);
        }
    }
}
