package com.coolapk.market.view.app;

import com.coolapk.market.model.RelatedData;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public class RelateDataListContract {

    public interface View extends AsyncListContract.View<Result<List<RelatedData>>> {
        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<RelatedData>>> {
        public Presenter(View view) {
            super(view);
        }
    }
}
