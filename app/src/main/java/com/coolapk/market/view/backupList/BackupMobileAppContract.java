package com.coolapk.market.view.backupList;

import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class BackupMobileAppContract {

    interface View extends AsyncListContract.View<List<MobileApp>> {
    }

    static abstract class Presenter extends AsyncListPresenter<List<MobileApp>> {
        public static final int SORT_BY_APP_SIZE = 3;
        public static final int SORT_BY_INSTALL_TIME = 1;
        public static final int SORT_BY_NAME = 0;
        public static final int SORT_BY_PACKAGE_NAME = 4;
        public static final int SORT_BY_UPDATE_TIME = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface SortBy {
        }

        public abstract boolean isShowSystem();

        public abstract boolean isTaskLoading();

        public abstract void setShowSystem(boolean z);

        public abstract void setSortBy(int i);

        public abstract void setTaskLoading(boolean z);

        public Presenter(View view) {
            super(view);
        }
    }
}
