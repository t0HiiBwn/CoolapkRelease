package com.coolapk.market.view.app;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;
import java.util.List;

public class AddToAlbumDialogContract {

    public interface Presenter extends BasePresenter {
        void cancelLoadAlbumList();

        List<Entity> getAlbumList();

        void loadAlbumList(String str, int i);
    }

    public interface View extends BaseView {
        void onAlbumListLoadComplete(Result<List<Entity>> result, Throwable th);
    }
}
