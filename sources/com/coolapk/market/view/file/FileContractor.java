package com.coolapk.market.view.file;

import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;
import java.io.File;
import java.util.List;

public interface FileContractor {

    public interface Presenter extends BasePresenter {
        void loadFileDir(String str);
    }

    public interface View extends BaseView {
        void onLoadSuccess(List<File> list);
    }
}
