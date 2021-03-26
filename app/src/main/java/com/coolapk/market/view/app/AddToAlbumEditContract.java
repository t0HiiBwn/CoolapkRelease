package com.coolapk.market.view.app;

import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;

public class AddToAlbumEditContract {

    public interface Presenter extends BasePresenter {
        void addToAlbum(String str, String str2, String str3, String str4, String str5, int i, String str6);

        void cancelAddToAlbum();

        boolean isInSubmit();
    }

    public interface View extends BaseView {
        void onAddToAlbumComplete(Throwable th);
    }
}
