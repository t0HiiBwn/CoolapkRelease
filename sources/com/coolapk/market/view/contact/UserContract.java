package com.coolapk.market.view.contact;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public interface UserContract {

    public interface View extends AsyncListContract.View<Result<List<Entity>>> {
        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<Entity>>> {
        public abstract void setKeyWord(String str);

        public Presenter(View view) {
            super(view);
        }
    }
}
