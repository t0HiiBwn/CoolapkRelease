package com.coolapk.market.view.appmanager;

import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public class UpgradeContract {

    interface View extends AsyncListContract.View<List<MobileApp>> {
    }

    static abstract class Presenter extends AsyncListPresenter<List<MobileApp>> {
        public abstract int getIgnoreNum();

        public abstract boolean isContainIgnore();

        public abstract void setContainIgnore(boolean z);

        public abstract void setTaskLoading(boolean z);

        public Presenter(View view) {
            super(view);
        }
    }
}
